package youmssoft.repository.webService;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.annotation.Secured;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import youmssoft.repository.dao.RoleRepository;
import youmssoft.repository.dao.UsersRepository;
import youmssoft.repository.dao.livraison.PersonnelRepository;
import youmssoft.repository.dto.PersonnelDto;
import youmssoft.repository.dto.ReponseDto;
import youmssoft.repository.dto.UserDto;
import youmssoft.repository.dto.ReponseDto.Code;
import youmssoft.repository.entities.Role;
import youmssoft.repository.entities.User;
import youmssoft.repository.entities.livraison.Personnel;
import youmssoft.repository.services.ServicesLivraison;
import youmssoft.repository.services.ServicesUserPersonnel;
import youmssoft.repository.services.ServicesVentes;

@RestController 
@Secured(value= {"ROLE_ADMIN"})
//@CrossOrigin("*")
@CrossOrigin
public class UserPersonnelWS {
	@Autowired 
	UsersRepository usersRepository;
	
	@Autowired 
	RoleRepository roleRepository;
	
	@Autowired 
	PersonnelRepository personnelRepository;
	
	@Autowired 
	ServicesUserPersonnel sup;
	
	@Autowired 
	ServicesLivraison sl;
	
	@Autowired
	ServicesVentes sv;
	
	/*
	 * Nouveau personnel: Ajout exclusif d'un nouveau personnel
	 */
	@PostMapping(value="/addnouveaupersonnel")
	public HashMap<String, Object> addNouveauPersonnel(@RequestBody PersonnelDto pDto){
		ReponseDto r= new ReponseDto();
		if(pDto==null) {
			r.format(Code.FAILURE, "Paramètre null");
			return r.getResponse();
		}
		Personnel p= new Personnel(pDto.getNom(), pDto.getPrenom(), pDto.getSexe(), pDto.getCni(), pDto.getDateCni(), pDto.getDateNaissance(), pDto.getAddresse(), pDto.getPoste(), pDto.getTel1(), pDto.getTel2(), null);
		
		p.setValide(true);
		p.setMyUser(null);
		r=sup.saveNewPersonnel(p);
		
		return r.getResponse();
	}
	
	/*
	 * Nouveau utilisateur du systeme: Ajout exlusif d'un futur utilisateur du système
	 */
	@PostMapping(value="/adduser")
	public HashMap<String, Object> adduser(@RequestBody UserDto udto) {
		ReponseDto r= new ReponseDto();
		/*
		 * Pour enregister un nouveaau utilisateur, il faut :
		 * 1- Enregistrer le personnel: Un user du système est d'abord un personnel.
		 * Mais un personnel n'est pas toujours un user.
		 * 2- Donc faire un service pour les personnels. Et celui des users doit appeler les services 
		 * des personnels
		 */
		if(udto==null) {
			r.format(Code.FAILURE,"Paramètre null");
			return r.getResponse();
		}
		
		if(sl.getPersonnelValideByid(udto.getPersonnel())!=null) {
			r.format(Code.FAILURE, "Personnel associé non valide");
			return r.getResponse();
		}
		
		User u= usersRepository.save(new User(udto.getUsername(),udto.getPassword(),true,sl.getPersonnelValideByid(udto.getPersonnel())));
		
		r.format(Code.SUCCESS, "Utilisateur enregistré avec succes");
		
		return r.getResponse();
		
	}
	
	/*
	 * Ajout d'un nouveau Personnel qui sera en même temps un futur utilisateur du système.
	 */
	@PostMapping(value="/adduserandpersonnel")
	public HashMap<String, Object> addUserAndPersonnel(@RequestBody PersonnelDto pDto) {
		ReponseDto r= new ReponseDto();
		if(pDto==null) {
			r.format(Code.FAILURE, "Paramètre null");
			return r.getResponse();
		}
		HashMap<String, Object> r2= this.addNouveauPersonnel(pDto);
		if((boolean)r2.get("status")) {
			Personnel p= (Personnel) r2.get("data");
			this.adduser(new UserDto(pDto.getUsername(), pDto.getPassword(),p.getIdPersonnel()));
			r.format(Code.SUCCESS, "Opération éffectuée avec succes");
			return r.getResponse();
		}else {
			r.format(Code.FAILURE, "Echec dans l'enregistrement du Personnel");
			return r.getResponse();
		}
	}
		
	
	@GetMapping(value="/listusers")
	public List<User> listUsers(){
		return usersRepository.findAll();
	}
	
	@GetMapping(value="/addroletouser")
	public HashMap<String, Object> addRoleToUser(@RequestParam(name="role") String role,@RequestParam(name="username") String username){
		ReponseDto r= new ReponseDto();
		//Role role=roleRepository.save(r);
		//roleRepository.findByUser(u)
		User u= usersRepository.getOne(username);
		Role ro=roleRepository.getOne(role);
		
		
		if(u==null) {
			r.format(Code.FAILURE, "Ce username est invalide");
			return r.getResponse();
		}
		
		if(!u.isActived()) {
			r.format(Code.FAILURE, "Cet utilisateur est désactivé");
			return r.getResponse();
		}
		
		if(ro==null) {
			r.format(Code.FAILURE, "Ce poste/role est invalide");
			return r.getResponse();
		}
		
		u.getRoles().add(ro);
		u=usersRepository.save(u);
		
		r.format(Code.SUCCESS, u.getRoles());
		
		return r.getResponse();
	}
	
	
	@GetMapping(value="/removeroleofuser")
	public HashMap<String, Object> removeRoleOfUser(@RequestParam(name="role") String role,@RequestParam(name="username") String username){
		ReponseDto r= new ReponseDto();
		
		User u= usersRepository.getOne(username);
		Role ro=roleRepository.getOne(role);
		if(!u.getRoles().contains(ro)) {
			r.format(Code.FAILURE, "Cet utilisateur n'est pas "+ro.getRole());
			return r.getResponse();
		}
		
		u.getRoles().remove(ro);
		u=usersRepository.save(u);
		
		r.format(Code.SUCCESS, u.getRoles());
		return r.getResponse() ;
	}
	
	@GetMapping(value="/desactiveruser/{username}")
	public HashMap<String, Object> desactiverUser(@PathVariable String username){
		ReponseDto r= new ReponseDto();
		
		User u= usersRepository.getOne(username);
		
		if(u==null) {
			r.format(Code.FAILURE, "Cet utilisateur est inexistant/invalide");
			return r.getResponse();
		}
		
		if(!u.isActived()) {
			r.format(Code.FAILURE, "Utilisateur déjà désactivé.");
			return r.getResponse();
		}
		
		u.setActived(false);
		usersRepository.save(u);
		
		r.format(Code.SUCCESS, "Utilisateur désactivé avec succes.");
		return r.getResponse();
	}
	

	
	/*
	 * les services concernants les roles ne sont pas aussi necessaires, vu que pour cette application,les roles sont les suivants:
	 * 1- ADMIN
	 * 2- SECRETAIRE
	 * 3- CAISSIE(E)
	 * 4- MAGAZINIER(E)_EMB
	 * 5- MAGAZINIER(E)_PROD
	 */
	
}
