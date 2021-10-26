package youmssoft.repository.webService;

import java.util.HashMap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.CrudRepository;
import org.springframework.security.access.annotation.Secured;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import youmssoft.repository.dao.ventes.DepensesRepository;
import youmssoft.repository.dto.CassDto;
import youmssoft.repository.dto.DepenseDto;
import youmssoft.repository.dto.DepenseDto2;
import youmssoft.repository.dto.DepenseSDto;
import youmssoft.repository.dto.NewAvanceEmb;
import youmssoft.repository.dto.NewPrixProduitDto;
import youmssoft.repository.dto.NewProductDto;
import youmssoft.repository.dto.ReponseDto;
import youmssoft.repository.dto.RetourFactureDto;
import youmssoft.repository.dto.ServiceFactureDto;
import youmssoft.repository.dto.ReponseDto.Code;
import youmssoft.repository.entities.livraison.Fournisseur;
import youmssoft.repository.entities.livraison.Personnel;
import youmssoft.repository.entities.livraison.Produit;
import youmssoft.repository.entities.ventes.Cass;
import youmssoft.repository.entities.ventes.Client;
import youmssoft.repository.entities.ventes.Depenses;
import youmssoft.repository.entities.ventes.Facture;
import youmssoft.repository.entities.ventes.GestionFacture;
import youmssoft.repository.services.ServicesLivraison;
import youmssoft.repository.services.ServicesVentes;


@RestController 
//@CrossOrigin("*")
@CrossOrigin
public class VentesWS {

	
	@Autowired
	ServicesLivraison sl;
	
	@Autowired
	ServicesVentes sv;

	@Autowired
	 DepensesRepository depensesRepository;
	
	@Secured(value={"ROLE_ADMIN"})
	@PostMapping(value="/prixproduit")
	public HashMap<String, Object> prixProduit(@RequestBody NewPrixProduitDto npp){
		ReponseDto r= new ReponseDto();
		Client c= sv.getClientValideById(npp.getClient());
		Produit p= sv.getProduitValideById(npp.getProduit());
		
		r=sv.prixProduitClient(c, p, npp.getPrix(), npp.getRist());
		
		return r.getResponse();
		
	}
	
	@Secured(value={"ROLE_ADMIN"})
	@PostMapping(value="/updateprixproduit")
	public HashMap<String, Object> updatePrixProduit(@RequestBody NewPrixProduitDto npp){
		ReponseDto r= new ReponseDto();
		Client c= sv.getClientValideById(npp.getClient());
		Produit p= sv.getProduitValideById(npp.getProduit());
		
		r=sv.modifierPrixProduitClient(p, c, npp.getPrix(), npp.getRist());
		
		return r.getResponse();
		
	}
	
	//================================GESTION DES FACTURES=========================
	@Secured(value={"ROLE_ADMIN","ROLE_SECRETAIRE"})
	@GetMapping(value="/initfacture")
	public HashMap<String, Object> initFacture(@RequestParam (name="pers") long pers,
											   @RequestParam (name="client") long client){
		ReponseDto r= new ReponseDto();
		 Personnel p= sl.getPersonnelValideByid(pers);
		 Client  c= sv.getClientValideById(client);
		 if(p==null) {
			 r.format(Code.FAILURE, "Ce personnel est invalide");
			 return r.getResponse();
		 }
		 
		 if(c==null) {
			 r.format(Code.FAILURE, "Ce client est invalide");
			 return r.getResponse();
		 }
		 
		 r.format(Code.SUCCESS, sv.initialiserFactureClient(c, p));
		 
		 return r.getResponse();
	}
	
	@Secured(value={"ROLE_ADMIN","ROLE_SECRETAIRE"})
	@PostMapping(value="/addproductfact")
	public HashMap<String, Object> addProductFacture (@RequestBody NewProductDto np){
		ReponseDto r= new ReponseDto();
		Produit p= sl.getProduitValideById(np.getIdp());
		Facture f= sv.getFactureValideById(np.getIdLivraison());
		
		r=sv.affecterProduitFacture(f, np.getQte(), p, 0, 0);
		
		return r.getResponse();
	}
	
	@Secured(value={"ROLE_ADMIN","ROLE_SECRETAIRE"})
	@GetMapping(value="/removeproduitfac")
	public HashMap<String, Object> removeProduitFacture(@RequestParam (name="fac") long idfac,
			   										@RequestParam (name="prod") long idprod){
		ReponseDto r= new ReponseDto();
		Produit p= sl.getProduitValideById(idprod);
		Facture f= sv.getFactureValideById(idfac);
		
		r=sv.retirerProduitFacture(f, p);
		
		return r.getResponse();
		
	}
	
	@Secured(value={"ROLE_ADMIN","ROLE_SECRETAIRE"})
	@PostMapping(value="/updateproduitfac")
	public HashMap<String, Object> updateProduitFacure(@RequestBody NewProductDto np){
		ReponseDto r= new ReponseDto();
		Produit p= sl.getProduitValideById(np.getIdp());
		Facture f= sv.getFactureValideById(np.getIdLivraison());
		
		if(np.getQte()<=0) {
			r.format(Code.FAILURE, "Veillez saisir un montant valide.");
			return r.getResponse();
		}else {
			r=sv.modifierQuantiteProduitFacture(f, p, np.getQte());
			return r.getResponse();
		}
	}
	
	@Secured(value={"ROLE_ADMIN","ROLE_SECRETAIRE"})
	@GetMapping(value="/cancelfac/{fac}")
	public HashMap<String, Object> cancelFacture(@PathVariable long idFac){
		ReponseDto r= new ReponseDto();
		Facture f= sv.getFactureValideById(idFac);
		
		r=sv.annulerFacture(f);
		
		return r.getResponse();
		
	}
	
	@Secured(value={"ROLE_ADMIN","ROLE_MAGAZINIER(E)_PROD"})
	@PostMapping(value="/backwardprod")
	public HashMap<String, Object> backwardProduitFacture(@RequestBody NewProductDto np){
		ReponseDto r= new ReponseDto();
		Facture f= sv.getFactureValideById(np.getIdLivraison());
		Produit p= sl.getProduitValideById(np.getIdp());
		Personnel mag=sl.getPersonnelValideByid(np.getIdmag());
		
		r=sv.retourProduitFacture(f, p, np.getQte(),mag);
		
		return r.getResponse();
	}
	
	
	@Secured(value={"ROLE_ADMIN","ROLE_MAGAZINIER(E)_PROD"})
	@PostMapping(value="/livrerfacture")
	public HashMap<String, Object> livrerFacture(@RequestBody ServiceFactureDto sf){
		ReponseDto r= new ReponseDto();
		Facture f= sv.getFactureValideById(sf.getIdFacture());
		Personnel mag= sl.getPersonnelValideByid(sf.getIdMag());
		Personnel liv= sl.getPersonnelValideByid(sf.getIdLiv());
		
		r=sv.livrerFacture(f, mag, liv);
		
		return r.getResponse();
	}
	
	
	@Secured(value={"ROLE_ADMIN","ROLE_SECRETAIRE"})
	@GetMapping(value="/cancellivraisonFacture/{fac}")
	public HashMap<String, Object> cancelLivraisonFacture(@PathVariable long fac){
		ReponseDto r= new ReponseDto();
		Facture f= sv.getFactureValideById(fac);
		
		r=sv.annulerLivraisonFacture(f);
		
		return r.getResponse();
	}
	
	
	@Secured(value={"ROLE_ADMIN","ROLE_SECRETAIRE"})
	@PostMapping(value="/avanceargentfac")
	public HashMap<String, Object> avanceArgentFacture(@RequestParam (name="fac") long idfac,
													   @RequestParam (name="sec") long idp,
													   @RequestParam (name="amount") float avance){
		ReponseDto r= new ReponseDto();
		Facture f= sv.getFactureValideById(idfac);
		Personnel sec= sl.getPersonnelValideByid(idp);
	
		r=sv.avanceFactureArgent(f, avance, sec);
	
		return r.getResponse();
	
	}
	
	@Secured(value={"ROLE_ADMIN","ROLE_SECRETAIRE"})
	@PostMapping(value="/avanceembfac")
	public HashMap<String, Object> avanceEmballageFacture(@RequestBody NewAvanceEmb nae){
		ReponseDto r= new ReponseDto();
		
		Facture f= sv.getFactureValideById(nae.getFac());
		Personnel sec= sl.getPersonnelValideByid(nae.getSec());
	
		r=sv.avanceFactureEmballage(f, sec, nae.getSabc(), nae.getUcb(), nae.getGuinness());
		
		return r.getResponse();
	}
	
	@Secured(value={"ROLE_ADMIN","ROLE_SECRETAIRE"})
	@PostMapping(value="/saveretourfacture")
	public HashMap<String, Object> saveRetourFacture(@PathVariable RetourFactureDto rf){
		ReponseDto r= new ReponseDto();
		
		Facture f= sv.getFactureValideById(rf.getIdFacture());
		Personnel sec= sl.getPersonnelValideByid(rf.getSecretaire());
		
		r=sv.enregistrerRetourFacture(f, sec, rf.getNbSABC(), rf.getNbUCB(), rf.getNbGUI(), rf.getArgent());
		
		return r.getResponse();
		
	}
	
	@Secured(value={"ROLE_ADMIN","ROLE_SECRETAIRE"})
	@GetMapping(value="/cancelavancefacture/{gesfac}")
	public HashMap<String, Object> cancelavancefacture(@PathVariable long gesfac){
		ReponseDto r= new ReponseDto();
		GestionFacture gf= sv.getGestionFactureValideById(gesfac);
		
		r=sv.annulerAvanceFacture(gf);
		
		return r.getResponse();
		
	}
	
	@Secured(value={"ROLE_ADMIN","ROLE_CAISSIER(E)"})
	@GetMapping(value="/encaisserfacture")
	public HashMap<String, Object> encaisserArgentFacture(@RequestParam (name="gesfac") long gesfac,
													   	  @RequestParam (name="caisse") long caisse){
		ReponseDto r= new ReponseDto();
		GestionFacture gf= sv.getGestionFactureValideById(gesfac);
		Personnel cais= sl.getPersonnelValideByid(caisse);
		
		r=sv.encaisserArgentFacture(gf, cais);
		
		return r.getResponse();
		
	}
	
	@Secured(value={"ROLE_ADMIN","ROLE_CAISSIER(E)"})
	@GetMapping(value="/cancelencaissementfacture/{gesfac}")
	public HashMap<String, Object> cancelEncaissementFacture(@PathVariable long gesfac){
		ReponseDto r= new ReponseDto();
		GestionFacture gf= sv.getGestionFactureValideById(gesfac);
		r=sv.annulerEncaissementArgentFacture(gf);
		return r.getResponse();
	}
	
	
	@Secured(value={"ROLE_ADMIN","ROLE_MAGAZINIER(E)_EMB"})
	@GetMapping(value="/stockerembfacture")
	public HashMap<String, Object> stockerEmbfacture(@RequestParam (name="gesfac") long gesfac,
													 @RequestParam (name="mag") long mag){
		ReponseDto r= new ReponseDto();
		GestionFacture gf= sv.getGestionFactureValideById(gesfac);
		Personnel pmag= sl.getPersonnelValideByid(mag);
		
		r=sv.stockerEmbFacture(gf, pmag);
		
		return r.getResponse();
	}
	
	@Secured(value={"ROLE_ADMIN","ROLE_MAGAZINIER(E)_EMB"})
	@GetMapping (value="/cancelstockemb/{gesfac}")
	public HashMap<String, Object> cancelStockEmballageFac(@PathVariable long gesfac){
		ReponseDto r= new ReponseDto();
		
		GestionFacture gf= sv.getGestionFactureValideById(gesfac);
		
		r=sv.annulerStockageEmballage(gf);
		
		return r.getResponse();
	}
	
	
	//===========================================GESTION DES DEPENSES=================
	@Secured(value={"ROLE_ADMIN","ROLE_SECRETAIRE"})
	@PostMapping (value="/savedepense")
	public HashMap<String, Object> saveNewDepense(@RequestBody DepenseDto d) {
		ReponseDto r= new ReponseDto();
		
		Personnel resp= sl.getPersonnelValideByid(d.getResponsable());
		Personnel sec=  sl.getPersonnelValideByid(d.getSecretaire());
		if(d.getAmount()<=0) {
			r.format(Code.FAILURE, "Veillez entrer un montant valide");
			return r.getResponse();
		}
		if(d.getMotif().equals(null) || d.getMotif().equals("")) {
			r.format(Code.FAILURE, "Veillez saisir le motif de cette dépense");
			return r.getResponse();
		}
		if(resp==null) {
			r.format(Code.FAILURE, "Veillez renseigner le responsable(valide) de la depense");
			return r.getResponse();
		}
		if(sec==null) {
			r.format(Code.FAILURE, "Veillez renseigner la secretaire(valide) qui enregistre la depense");
			return r.getResponse();
		}
		
		Depenses de=sv.enregistrerDepense(d.getAmount(), d.getMotif(), resp, sec);
		DepenseSDto dd= new DepenseSDto(de.getIdDepense(),
										de.responsable.getNomPers()+" "+de.responsable.getPrenomPers(),
										de.getSecretaire().getNomPers()+" "+de.getSecretaire().getPrenomPers(),
										de.getMontant(),
										de.getMotif(),
										de.getDateDepense(),
										de.getHeureDepense());
		
		r.format(Code.SUCCESS, dd);
		return r.getResponse();
	}
	
	@Secured(value={"ROLE_ADMIN","ROLE_SECRETAIRE"})
	@PostMapping (value="/updatedepense")
	public HashMap<String, Object> updateDepense(@RequestBody DepenseDto2 d) {
		ReponseDto r= new ReponseDto();
		
		Depenses dep= sv.getDepensesByIdAndIsValideTrue(d.getIdDepense());
		if(dep==null) {
			r.format(Code.FAILURE, "Cette dépence est invalide/inexistante");
			return r.getResponse();
		}
		
		if(d.getAmount()!=0) {
			if(d.getAmount()<0) {
				r.format(Code.FAILURE, "Ce montant est invalide");
				return r.getResponse();
			}
			dep.setMontant(d.getAmount());
		}
		
		if(d.getMotif()!=null && d.getMotif()!="") {
			dep.setMotif(d.getMotif());
		}
		
		if(d.getResponsable()!=-1) {
			Personnel resp= sl.getPersonnelValideByid(d.getResponsable());
			if(resp==null) {
				r.format(Code.FAILURE, "Veillez entrer un personnel valide/existant");
				return r.getResponse();
			}else {
				dep.setResponsable(resp);
			}
		}
		
		if(d.getSecretaire()!=-1) {
			Personnel sec= sl.getPersonnelValideByid(d.getSecretaire());
			if(sec==null) {
				r.format(Code.FAILURE, "Veillez entrer un personnel valide/existant");
				return r.getResponse();
			}else {
				dep.setResponsable(sec);
			}
		}
		
		Depenses de=depensesRepository.save(dep);
		
		DepenseSDto dd= new DepenseSDto(de.getIdDepense(),
				de.responsable.getNomPers()+" "+de.responsable.getPrenomPers(),
				de.getSecretaire().getNomPers()+" "+de.getSecretaire().getPrenomPers(),
				de.getMontant(),
				de.getMotif(),
				de.getDateDepense(),
				de.getHeureDepense());
		
		r.format(Code.SUCCESS, dd);
		
		return r.getResponse();
	
	}
	
	@Secured(value={"ROLE_ADMIN","ROLE_SECRETAIRE"})
	@GetMapping (value="/canceldepense/{dep}")
	public HashMap<String, Object> cancelDepense(@PathVariable long dep){
		ReponseDto r= new ReponseDto();
		r=sv.setDepensesInvalide(dep);
		return r.getResponse();
	}
	
	@Secured(value={"ROLE_ADMIN"})
	@GetMapping(value="/decaisserfromcaissedepense")
	public HashMap<String, Object> decaisserFromCaisseDepense(@RequestParam (name="depense") long depense,
			 												  @RequestParam (name="caissier") long caissier){
		ReponseDto r= new ReponseDto();
		Personnel caiss= sl.getPersonnelValideByid(caissier);
		Depenses dep= sv.getDepensesByIdAndIsValideTrue(depense);
		if(caiss==null) {
			r.format(Code.FAILURE, "Veillez entrer un personnel valide");
			return r.getResponse();
		}
		
		if(dep==null) {
			r.format(Code.FAILURE, "Veillez entrer une dépense valide");
			return r.getResponse();
		}
		
		r=sv.decaisserDepenseFromCaisse(dep, caiss);
		
		return r.getResponse();
	}
	
	@Secured(value={"ROLE_ADMIN"})
	@GetMapping(value="/canceldecaissementfromcaissedepense/{depense}")
	public HashMap<String, Object> cancelDecaissementFromCaisseDepense(@PathVariable long depense){
		ReponseDto r= new ReponseDto();
		Depenses dep= sv.getDepensesByIdAndIsValideTrue(depense);
		r=sv.annulerDecaissementDepenseFromCaisse(dep);
		return r.getResponse();
	}
	
	@Secured(value={"ROLE_ADMIN","ROLE_CAISSIER(E)"})
	@GetMapping(value="/decaissementFromcjDepense")
	public HashMap<String, Object> decaissementFromCJourDepense(@RequestParam (name="depense") long depense,
			  													@RequestParam (name="caissier") long caissier){
		ReponseDto r= new ReponseDto();
		Personnel caiss= sl.getPersonnelValideByid(caissier);
		Depenses dep= sv.getDepensesByIdAndIsValideTrue(depense);
		if(caiss==null) {
			r.format(Code.FAILURE, "Veillez entrer un personnel valide");
			return r.getResponse();
		}
		
		if(dep==null) {
			r.format(Code.FAILURE, "Veillez entrer une dépense valide");
			return r.getResponse();
		}
		
		r=sv.decaisserDepenseFromCaisseJournaliere(dep, caiss);
		
		return r.getResponse();
	}
	
	
	//@GetMapping(value="/canceldecaissementFromcjDepense")
	/*public HashMap<String, Object> cancelDecaissementFromCJourDepense(@RequestParam (name="depense") long depense,
			  														  @RequestParam (name="caissier") long caissier){
		ReponseDto r= new ReponseDto();
	}*/
	
	
	//===========================================GESTION DES CASS============================
	
	@Secured(value={"ROLE_ADMIN","ROLE_SECRETAIRE"})
	@PostMapping(value="/savenewcass")
	public HashMap<String, Object> saveNewCass(@RequestBody CassDto c){
		ReponseDto r= new ReponseDto();
		r=sv.enregistrerNouveauCass(c);
		return r.getResponse();
	}
	
	@Secured(value={"ROLE_ADMIN","ROLE_SECRETAIRE"})
	@PostMapping(value="/updatecass")
	public HashMap<String, Object> updateCass(@RequestBody CassDto c){
		ReponseDto r= new ReponseDto();
		r=sv.modifierCass(c);
		return r.getResponse();
	}
	
	@Secured(value={"ROLE_ADMIN","ROLE_SECRETAIRE"})
	@GetMapping(value="/cancelcass/{cass}")
	public HashMap<String, Object> cancelCass(@PathVariable long cass){
		ReponseDto r= new ReponseDto();
		r=sv.setCassInvalide(cass);
		return r.getResponse();
	}
	
	@Secured(value={"ROLE_ADMIN","ROLE_MAGAZINIER(E)_PROD"})
	@GetMapping(value="/managecassprod")
	public HashMap<String, Object> manageCassProd(@RequestParam (name="cass") long cass,
											  @RequestParam (name="mag") long mag){//Pour debiter le cass 
		ReponseDto r= new ReponseDto(); 
		Cass c= sv.getCassValideById(cass);
		Personnel p= sl.getPersonnelValideByid(mag);
		
		r=sv.gererCassProd(c,p);
		
		return r.getResponse();
		
	}
	
	@Secured(value={"ROLE_ADMIN","ROLE_MAGAZINIER(E)_EMB"})
	@GetMapping(value="/managecassemb")
	public HashMap<String, Object> manageCassEmb(@RequestParam (name="cass") long cass,
											  	 @RequestParam (name="mag") long mag){//Pour debiter le cass 
		ReponseDto r= new ReponseDto(); 
		Cass c= sv.getCassValideById(cass);
		Personnel p= sl.getPersonnelValideByid(mag);
		
		r=sv.gererCassEmb(c,p);
		
		return r.getResponse();
		
	}
	
	@Secured(value={"ROLE_ADMIN","ROLE_MAGAZINIER(E)_PROD"})
	@GetMapping(value="/cancelmanagementprodofcass/{cass}")
	public HashMap<String, Object> cancelManagementProdOfCass(@PathVariable long cass){//Pour debiter le cass 
		ReponseDto r= new ReponseDto();
		
		Cass c= sv.getCassValideById(cass);
		
		r=sv.annulerGestionCassProd(c);
		
		return r.getResponse();
		
	}
	
	@Secured(value={"ROLE_ADMIN","ROLE_MAGAZINIER(E)_EMB"})
	@GetMapping(value="/cancelmanagementembofcass/{cass}")
	public HashMap<String, Object> cancelManagementEmbOfCass(@PathVariable long cass){//Pour debiter le cass 
		ReponseDto r= new ReponseDto();
		
		Cass c= sv.getCassValideById(cass);
		
		r=sv.annulerGestionCassEmb(c);
		
		return r.getResponse();
	}
	
	@Secured(value={"ROLE_ADMIN","ROLE_CAISSIER(E)"})
	@GetMapping(value="/acquitersassbyargent")
	public HashMap<String, Object> acquiterCassByArgent(@RequestParam (name="cass") long cass,
		  	 											@RequestParam (name="caissier") long caissier){
		ReponseDto r= new ReponseDto();
		Cass c= sv.getCassValideById(cass);
		Personnel p= sl.getPersonnelValideByid(caissier);
		
		r=sv.effacementCassByArgent(c,p);
		
		return r.getResponse();
	}
	
	@Secured(value={"ROLE_ADMIN","ROLE_MAGAZINIER(E)_EMB"})
	@GetMapping(value="/acquitersassbyemb")
	public HashMap<String, Object> acquiterCassByEmballage(@RequestParam (name="cass") long cass,
		  	 											   @RequestParam (name="caissier") long caissier,
		  	 											   @RequestParam (name="four") long four){
		ReponseDto r= new ReponseDto();
		Cass c= sv.getCassValideById(cass);
		Personnel p= sl.getPersonnelValideByid(caissier);
		Fournisseur f= sl.getFournisseurValideById(four);
		
		r=sv.effacementCassByEmballage(c,p,f);
		
		return r.getResponse();
	}
	
	
	
	



}
