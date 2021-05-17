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

import youmssoft.repository.dao.livraison.PersonnelRepository;
import youmssoft.repository.dto.AchatEmballageDto;
import youmssoft.repository.dto.MagDto;
import youmssoft.repository.dto.NewAchatEmballageDto;
import youmssoft.repository.dto.ReponseDto;
import youmssoft.repository.dto.StockageEmbDto;
import youmssoft.repository.dto.ReponseDto.Code;
import youmssoft.repository.entities.livraison.Fournisseur;
import youmssoft.repository.entities.livraison.Personnel;
import youmssoft.repository.entities.ventes.AchatEmballage;
import youmssoft.repository.entities.ventes.Caisse;
import youmssoft.repository.entities.ventes.CaisseJournaliere;
import youmssoft.repository.services.ServicesLivraison;
import youmssoft.repository.services.ServicesVentes;

@RestController 
@CrossOrigin("*")
public class InventairesWS {
	
	@Autowired
	ServicesLivraison sl;
	
	@Autowired
	ServicesVentes sv;
	

	//=============================initialize Capital============
	/*
	 * OK
	 * Acteur: DG
	 */
	@Secured(value="ROLE_ADMIN")
	@GetMapping(value="/setcapital/{amount}")	
	public HashMap<String, Object> setCapitalDepot(@PathVariable float amount){
		ReponseDto r= new ReponseDto ();
		if(amount<=0) {
			r.format(Code.FAILURE, "Entrez un montant valide");
		}else {
			r.format(Code.SUCCESS, sv.definirCapital(amount));
		}
		return r.getResponse();
	}
	/*
	 * OK
	 * Acteur: DG
	 */
	@Secured(value={"ROLE_ADMIN"})
	@GetMapping(value="/updatecapital/{amount}")
	public HashMap<String, Object> updateCapitalDepot(@PathVariable float amount){
		ReponseDto r= new ReponseDto ();
		r=sv.updateCapital(amount);
		return r.getResponse();
	}
	
	/*
	 * OK
	 * Acteur: DG
	 */
	@Secured(value={"ROLE_ADMIN"})
	@GetMapping(value="/addcapital")
	public HashMap<String, Object> addCapital(@RequestParam (name="amount") float amount,
											  @RequestParam (name="res") long res,
											  @RequestParam (name="source") String soud){
		ReponseDto r= new ReponseDto ();
		
		Personnel p=sl.getPersonnelValideByid(res);
		
		r=sv.operationCaisse(amount, true, soud, p);
		
		return r.getResponse();
	}
	
	
	@GetMapping(value="/getdateandhour")
	public HashMap<String, Object> getDateAndHour(){
		ReponseDto r= new ReponseDto ();
		r= sv.getDateHour();
		return r.getResponse();
	}
	
	/*
	 * OK
	 * Acteur: DG
	 */
	@Secured(value={"ROLE_ADMIN"})
	@GetMapping(value="/reducecapital")
	public HashMap<String, Object> reduceCapital(@RequestParam (name="amount") float amount,
												 @RequestParam (name="res") long res,
			  									 @RequestParam (name="destination") String destination){
		ReponseDto r= new ReponseDto ();
		
		Personnel p=sl.getPersonnelValideByid(res);
		
		r=sv.operationCaisse(amount, false, destination, p);
		
		return r.getResponse();
		
	}
	
	//========================initialize Mag Emballage==================
	/*
	 * OK
	 * Acteur: DG
	 */
	@Secured(value={"ROLE_ADMIN"})
	@PostMapping(value="/setmagemballage")
	public HashMap<String, Object> setMagEmballage(@RequestBody MagDto mdto){
		ReponseDto r= new ReponseDto ();
		if(mdto.getQuantiteGUI()<0) {
			r.format(Code.FAILURE, "Veillez saisir une quantité valide d'emballage Brasseries");
			return r.getResponse();
		}
		if(mdto.getQuantiteUCB()<0) {
			r.format(Code.FAILURE, "Veillez saisir une quantité valide d'emballage UCB");
			return r.getResponse();
		}
		if(mdto.getQuantiteGUI()<0) {
			r.format(Code.FAILURE, "Veillez saisir une quantité valide d'emballage GUINNESS");
			return r.getResponse();
		}
		
		if(sv.initialiserMagEmballage(mdto.getQuantiteSABC(), mdto.getQuantiteUCB(), mdto.getQuantiteGUI()).size()==3){
			r.format(Code.SUCCESS, mdto);
		}else {
			r.format(Code.FAILURE, "erreur");
		}
		
		return r.getResponse();
	}
	
	/*
	 * OK
	 * Acteur: DG
	 */
	@Secured(value={"ROLE_ADMIN"})
	@GetMapping(value="/updatemagemb")
	public HashMap<String, Object> updateEmballageMag(@RequestParam (name="amount") float amount,
																																					@RequestParam (name="four") long four){
		ReponseDto r= new ReponseDto();
		Fournisseur f= sl.getFournisseurValideById(four);
		r=sv.updateEmbMag(amount, f);
		
		return r.getResponse();
	}
	
	/*
	 * OK
	 * Acteur: DG,SECRETAIRE
	 */
	@Secured(value={"ROLE_ADMIN","ROLE_SECRETAIRE"})
	@PostMapping(value="/achatbouteilles")
	public HashMap<String, Object> achatBouteilles (@RequestBody NewAchatEmballageDto nae){
		ReponseDto r= new ReponseDto ();
		if(nae==null) {
			r.format(Code.FAILURE, "Veillez saisir des informations");
			return r.getResponse();
		}
		if(nae.getQteEnBout()<=0) {
			r.format(Code.FAILURE, "Veillez saisir une quantité valide");
			return r.getResponse();
		}
		if(nae.getMontant()<=0 || nae.getMontant()>150*nae.getQteEnBout()) {
			r.format(Code.FAILURE, "Veillez saisir un montant valide");
		}
		Personnel res= sl.getPersonnelValideByid(nae.getResponsable());
		if(res==null) {
			r.format(Code.FAILURE, "Veillez saisir un personnel valide");
				return r.getResponse();
		}
		AchatEmballage ae=sv.achatBouteilles(nae.getQteEnBout()/12, nae.getMontant(), nae.getSource(), res);
		
		AchatEmballageDto a= new AchatEmballageDto(ae.getIdAcharEmballage(),ae.getDateAchat(),ae.getMontantAchat(),ae.getQteEnCasier(),ae.getResponsable().getNomPers()+" "+ae.getResponsable().getPrenomPers());
		r.format(Code.SUCCESS,a);
		return r.getResponse();
	}
	
	/*
	 * OK
	 * Acteur: DG,SECRETAIRE
	 */
	@Secured(value={"ROLE_ADMIN","ROLE_SECRETAIRE"})
	@GetMapping(value="/cancelachatbouteille/{achatEmb}")
	public HashMap<String, Object> cancelAchatBouteille (@PathVariable long achatEmb){
		ReponseDto r= new ReponseDto();
		AchatEmballage ae= sv.getAchatEmballageValide(achatEmb);
		if(ae==null) {
			r.format(Code.FAILURE, "Cet Achat Emballage est invalide/inexistant");
			return r.getResponse();
		}
		if(ae.isPayed()) {
			r.format(Code.FAILURE, "Cet Achat d'Emballage est déjà payé. Donc ne peut être annulé");
			return r.getResponse();
		}
		if(ae.isStocked()) {
			r.format(Code.FAILURE, "Cet Achat d'Emballage est déjà stocké.  Donc ne peut être annulé");
			return r.getResponse();
		}
		sv.setAchatEmballageInvalide(ae);
		r.format(Code.SUCCESS, "Achat annulée avec succes");
		return r.getResponse();
	}
	
	/*
	 * OK
	 * Acteur: DG,CAISSIER(E)
	 */
	@Secured(value={"ROLE_ADMIN","ROLE_CAISSIER(E)"})
	@GetMapping(value="/decaisserfromcaisseachatbouteille")
	public HashMap<String, Object> decaisserFromCaisseAchatBouteille(@RequestParam (name="idae") long idae,
																	 @RequestParam (name="caissier") long caissier){
		ReponseDto r= new ReponseDto();
		
		Personnel p= sl.getPersonnelValideByid(caissier);
		AchatEmballage achatE= sv.getAchatEmballageValide(idae);
		
		r=sv.decaisserAchatBouteille(achatE, p);
		
		return r.getResponse();
	}
	
	/*@GetMapping(value="/canceldecaissementachatbouteille")
	public HashMap<String, Object> cancelDecaissementAchatBouteille(){
		ReponseDto r= new ReponseDto();
	}
	
	@GetMapping(value="/decaisserfromcaisseachatbouteille/")
	public HashMap<String, Object> decaisserFromCJachatBouteille(){
		ReponseDto r= new ReponseDto();
	}
	
	@GetMapping(value="/canceldecaissementfromcaissejourachatbouteille/")
	public HashMap<String, Object> cancelDecaissementFromCJachatBouteille(){
		ReponseDto r= new ReponseDto();
	}*/
	
	
	/*
	 * OK
	 * Acteur: DG,MAGZINIER(E)
	 */
	@Secured(value={"ROLE_ADMIN","ROLE_MAGAZINIER(E)_EMB"})
	@PostMapping(value="/stockerachatbouteille")
	public HashMap<String, Object> stockerAchatBouteille(@RequestBody StockageEmbDto s ){
		ReponseDto r= new ReponseDto();
		
		Personnel p= sl.getPersonnelValideByid(s.getMag());
		AchatEmballage achatE= sv.getAchatEmballageValide(s.getIdAe());
		
		r=sv.stockerEmballageAchete(achatE, p, s.getNbSABC(), s.getNbUCB(), s.getNbGUI());
		
		return r.getResponse();
																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																											
	}
	/*
	 * OK
	 * Acteur: DG
	  */
	@Secured(value={"ROLE_ADMIN"})
	@GetMapping(value="/takecaissejournaliere")
	public HashMap<String, Object> takeCaisseJournaliereToCaisse(@RequestParam (name="cj") long cj,
																																										@RequestParam (name="admin") long admin){
		ReponseDto r= new ReponseDto();
		CaisseJournaliere caisseJour= sv.getCaisseJournaliereValideById(cj);
		Personnel p= sl.getPersonnelValideByid(admin);
		r=sv.fromCaisseJournaliereToCaisse(caisseJour,p);
		
		return r.getResponse();
	}
	
	
	/*
	 * TAF:
	 * 
	 */
	
	
}
