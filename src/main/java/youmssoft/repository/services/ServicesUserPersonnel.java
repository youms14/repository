package youmssoft.repository.services;

import java.util.HashMap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import youmssoft.repository.dao.RoleRepository;
import youmssoft.repository.dao.UsersRepository;
import youmssoft.repository.dao.livraison.PersonnelRepository;
import youmssoft.repository.dto.ReponseDto;
import youmssoft.repository.dto.ReponseDto.Code;
import youmssoft.repository.entities.livraison.Personnel;

@Service
public class ServicesUserPersonnel {
	@Autowired 
	UsersRepository usersRepository;
	
	@Autowired 
	RoleRepository roleRepository;
	
	@Autowired 
	PersonnelRepository personnelRepository;
	
	public ReponseDto	saveNewPersonnel(Personnel p) {
		ReponseDto r= new ReponseDto();
		if(p==null) {
			r.format(Code.FAILURE	, "Veillez saisir un paramètre non nul");
			return r;
		}
		
		r.format(Code.SUCCESS, personnelRepository.save(p));
		return r;
	}
	
	
}
