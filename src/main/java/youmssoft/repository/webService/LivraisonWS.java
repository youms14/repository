package youmssoft.repository.webService;

import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.annotation.Secured;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import youmssoft.repository.dto.CollaborateurExtDto;
import youmssoft.repository.dto.FournisseurDto;
import youmssoft.repository.dto.LivraisonDto;
import youmssoft.repository.dto.NewAvanceEmbLivraisonDto;
import youmssoft.repository.dto.NewLivraisonDTO;
import youmssoft.repository.dto.NewProductDto;
import youmssoft.repository.dto.ProduitsLivraisonDto;
import youmssoft.repository.dto.ReponseDto;
import youmssoft.repository.dto.ReponseDto.Code;
import youmssoft.repository.entities.livraison.CollaborateurExt;
import youmssoft.repository.entities.livraison.Fournisseur;
import youmssoft.repository.entities.livraison.GestionLivraison;
import youmssoft.repository.entities.livraison.Livraison;
import youmssoft.repository.entities.livraison.Personnel;
import youmssoft.repository.entities.livraison.Produit;
import youmssoft.repository.entities.ventes.Caisse;
import youmssoft.repository.entities.ventes.MagEmballage;
import youmssoft.repository.services.ServicesLivraison;
import youmssoft.repository.services.ServicesVentes;


//@Controller si on vas utiliser MVC(Application Web convensionnelle sans les servicesWeb)
@RestController 
//@CrossOrigin("*")
@CrossOrigin
public class LivraisonWS {

	@Autowired
	ServicesLivraison sl;
	
	@Autowired
	ServicesVentes sv;
	
	
	//@Secured(value={"ROLE_ADMIN","ROLE_SECRETAIRE","ROLE_CAISSIER(E)","ROLE_MAGAZINIER(E)_PROD","ROLE_MAGAZINIER(E)_EMB"})
	@GetMapping(value="/listefournisseurs")
	public List<FournisseurDto> listeFournisseurs(){
		return sl.fournisseursList();
	}
	
	@Secured(value={"ROLE_ADMIN","ROLE_SECRETAIRE","ROLE_CAISSIER(E)","ROLE_MAGAZINIER(E)_PROD","ROLE_MAGAZINIER(E)_EMB"})
	@GetMapping(value="/collaborateursbyfour/{four}")
	public List<CollaborateurExtDto> listeCollaborateurParFournisseur(@PathVariable long four){
		return sl.getCollaborateurExtByFournisseur(four);
	}
	
	/*
	 * OK
	 * SECRETAIRE,DG
	 */
	@Secured(value={"ROLE_ADMIN","ROLE_SECRETAIRE"})
	@PostMapping(value="/initlivraison")
	public HashMap<String, Object> initializeLivraison(@RequestBody NewLivraisonDTO nl) {
		ReponseDto r= new ReponseDto();
		
		CollaborateurExt c= sl.getCEValideById(nl.getIdCollaborateurExt());
		Personnel p= sl.getPersonnelValideByid(nl.getIdPersonnel());
		
		if (c==null) {
			r.format(Code.FAILURE, "Ce collaborateur n'est pas valide");
			return r.getResponse();
		}
		if(p==null) {
			r.format(Code.FAILURE, "Ce Personnel n'est pas valide");
			return r.getResponse();
		}
		
		r.format(Code.SUCCESS, sl.initialiserLivraison(p, c));
		return r.getResponse();
	}
	
	/*
	 * OK
	 * SECRETAIRE,DG
	 */
	@Secured(value={"ROLE_ADMIN","ROLE_SECRETAIRE"})
	@PostMapping(value="/addprodutliv")
	public HashMap<String, Object> addProductLivraison(@RequestBody NewProductDto np){
		ReponseDto r= new ReponseDto();
		Produit p= sl.getProduitValideById(np.getIdp());
		Livraison l= sl.getLivraisonValideById(np.getIdLivraison());
		
		Fournisseur f= sl.getFournisseurValideById(sl.getCEValideById(sl.getLivraisonValideById(np.getIdLivraison()).getMyCollaborateurExt().getIdCollaborateurExt()).getMyFournisseur().getIdFournisseur());
		if(f!=p.getMyFournisseur()) {
			r.format(Code.FAILURE, "Ce produit n'est pas livré par le fournisseur/collaborateur extérieur indiqué.");
			return r.getResponse();
		}
		r=sl.affecterProduits(l, np.getQte(), p);
		
		return r.getResponse();
				
	}
	
	/*
	 * OK
	 * SECRETAIRE,DG
	 */
	@Secured(value={"ROLE_ADMIN","ROLE_SECRETAIRE"})
	@PostMapping(value="/removeproductliv")
	public HashMap<String, Object> removeProductLivraison(@RequestBody NewProductDto np){
		ReponseDto r= new ReponseDto();
		Produit p= sl.getProduitValideById(np.getIdp());
		Livraison l= sl.getLivraisonValideById(np.getIdLivraison());
		r=sl.retirerProduitLivraison(l, p);
		
		return r.getResponse();
	}
	
	/*
	 * OK
	 * SECRETAIRE,DG
	 */
	@Secured(value={"ROLE_ADMIN","ROLE_SECRETAIRE"})
	@PostMapping(value="/updateqteproductliv")
	public HashMap<String, Object> updateQteProductLivraison(@RequestBody NewProductDto np){
		ReponseDto r= new ReponseDto();
		Produit p= sl.getProduitValideById(np.getIdp());
		Livraison l= sl.getLivraisonValideById(np.getIdLivraison());
		r=sl.modifierQuantiteproduitLivraison(l, p, np.getQte());
		
		return r.getResponse();
	}
	/*
	 * OK
	 * SECRETAIRE,DG
	 */
	@Secured(value={"ROLE_ADMIN","ROLE_SECRETAIRE","ROLE_CAISSIER(E)","ROLE_MAGAZINIER(E)_PROD","ROLE_MAGAZINIER(E)_EMB"})
	@GetMapping(value="/listeproduitslivraison/{liv}")
	public List<ProduitsLivraisonDto> listeProduitsLivraison(@PathVariable long liv) {
		Livraison l= sl.getLivraisonValideById(liv);
		return sl.listProduitsByLivraison(l);
	}
	/*
	 * OK
	 * SECRETAIRE,DG
	 */
	@Secured(value={"ROLE_ADMIN","ROLE_SECRETAIRE"})
	@GetMapping(value="/finishliv")
	public HashMap<String, Object> finishLivraison(@RequestParam (name="liv") long liv,
												   @RequestParam (name="num") String num){
		ReponseDto r= new ReponseDto();
		Livraison l= sl.getLivraisonValideById(liv);
		r=sl.terminerLivraison(l, num);
		
		return r.getResponse();
	}
	
	/*
	 * OK
	 * SECRETAIRE,DG
	 */
	@Secured(value={"ROLE_ADMIN","ROLE_SECRETAIRE"})
	@GetMapping(value="/cancelliv/{liv}")
	public HashMap<String, Object> cancelLivraison(@PathVariable long liv){
		ReponseDto r= new ReponseDto();
		Livraison l= sl.getLivraisonValideById(liv);
		r=sl.annulerLivraison(l);
		
		return r.getResponse();
	}
	/*
	 * OK
	 * MAGAZINIER(E)_PROD,DG
	 */
	
	
	@Secured(value={"ROLE_ADMIN","ROLE_MAGAZINIER(E)_PROD"})
	@GetMapping(value="/stockerliv")
	public HashMap<String,Object> stockerLivraison(@RequestParam (name="liv") long liv,
												   @RequestParam (name="mag") long mag){
		ReponseDto r= new ReponseDto();
		Livraison l= sl.getLivraisonValideById(liv);
		Personnel p= sl.getPersonnelValideByid(mag);
		r=sl.stockerLivraison(l, p);
		
		return r.getResponse();
				
	}
	/*
	 * OK
	 * SECRETAIRE,DG
	 */
	@Secured(value={"ROLE_ADMIN","ROLE_MAGAZINIER(E)_PROD"})
	@GetMapping(value="/cancelstockageliv/{liv}")
	public HashMap<String,Object> cancelStockageLivraison(@PathVariable long liv){
		ReponseDto r= new ReponseDto();
		Livraison l= sl.getLivraisonValideById(liv);
		r=sl.annulerStockageLivraison(l);
		
		return r.getResponse();
	}
	
	
	
	
	
	//======================Acquiter une livraison
	/*
	 * OK
	 * SECRETAIRE,DG
	 */
	@Secured(value={"ROLE_ADMIN","ROLE_SECRETAIRE"})
	@PostMapping(value="/avanceembliv")
	public HashMap<String,Object> avanceEmbLiv(@RequestBody NewAvanceEmbLivraisonDto n){
		ReponseDto r= new ReponseDto(); 
		Livraison l= sl.getLivraisonValideById(n.getLiv());
		Personnel p= sl.getPersonnelValideByid(n.getPers());
		CollaborateurExt c= sl.getCEValideById(n.getCe());
		MagEmballage me= sl.getMaMagEmballageValideByFournisseur(l.getMyCollaborateurExt().getMyFournisseur());
		if(me.getQteMag()<n.getAvance()) {
			r.format(Code.FAILURE, "Au magazin, cette quantité d'emballage n'est pas disponible. "
					+ " La quantité disposnible est: " +me.getQteMag());
			return r.getResponse();
		}
		
		if(l.getMyDetailsLivraison().getResteEmb()<n.getAvance()) {
			r.format(Code.FAILURE, "Cette quantité est supérieure au reste d'emballage à donner pour Cette livraison."
									+ " Le véritable reste est: "+l.getMyDetailsLivraison().getResteEmb());
			return r.getResponse();
		}
		
		Fournisseur f= sl.getFournisseurValideById(sl.getCEValideById(sl.getLivraisonValideById(n.getLiv()).getMyCollaborateurExt().getIdCollaborateurExt()).getMyFournisseur().getIdFournisseur());
		if(f!=c.getMyFournisseur()) {
			r.format(Code.FAILURE, "Ce collaborateur extérieur n'est pas des "+sl.getLivraisonValideById(n.getLiv()).getMyCollaborateurExt().getMyFournisseur().getNom()+ " (Fournisseur de cette livraison).");
			return r.getResponse();
		}
		
		r= sl.avanceLivraison(l, p, c, n.getAvance(), false, false);
		
		return r.getResponse();
	}
	
	/*
	 * OK
	 * SECRETAIRE,DG
	 */
	@Secured(value={"ROLE_ADMIN","ROLE_SECRETAIRE"})
	@PostMapping(value="/consigneembliv")//Avance d'emballage.
	public HashMap<String,Object> consigneEmbLiv(@RequestBody NewAvanceEmbLivraisonDto n){
		ReponseDto r= new ReponseDto(); 
		Livraison l= sl.getLivraisonValideById(n.getLiv());
		Personnel p= sl.getPersonnelValideByid(n.getPers());
		CollaborateurExt c= sl.getCEValideById(n.getCe());
		
		if(l.getMyDetailsLivraison().getResteEmb()<n.getAvance()/ServicesLivraison.PRIX_EMB) {
			r.format(Code.FAILURE, "Vous consignez trop d'emballages. Pour cette livraison, il reste "
					+ l.getMyDetailsLivraison().getResteEmb() +" Emballages. "
					+ "Soit environ "+l.getMyDetailsLivraison().getResteEmb()*ServicesLivraison.PRIX_EMB + " FCFA de consignation");
			return r.getResponse();
		}
		
		Fournisseur f= sl.getFournisseurValideById(sl.getCEValideById(sl.getLivraisonValideById(n.getLiv()).getMyCollaborateurExt().getIdCollaborateurExt()).getMyFournisseur().getIdFournisseur());
		if(f!=c.getMyFournisseur()){
			r.format(Code.FAILURE, "Ce collaborateur extérieur n'est pas de "+sl.getLivraisonValideById(n.getLiv()).getMyCollaborateurExt().getMyFournisseur().getNom()+ " (Fournisseur de cette livraison).");
			return r.getResponse();
		}
		
		r=sl.avanceLivraison(l, p, c, n.getAvance(), true, true);
		
		return r.getResponse();
	}
	
	/*
	 * /*
	 * OK
	 * MAGAZINIER(E)_EMB,DG
	 */
	@Secured(value={"ROLE_ADMIN","ROLE_MAGAZINIER(E)_EMB"})
	@GetMapping(value="/sortirembmag")
	public HashMap<String,Object> sortirEmbMag(@RequestParam (name="gesliv") long gesliv,
											   @RequestParam (name="mag") long mag){
		ReponseDto r= new ReponseDto();
		GestionLivraison gl= sl.getGestionLivraisonByIdValide(gesliv);
		Personnel p= sl.getPersonnelValideByid(mag);
		
		r=sl.sortirEmballageLivraison(gl, p);
		
		return r.getResponse();
	}
	
	/*
	 * OK
	 * SECRETAIRE,DG
	 */
	@Secured(value={"ROLE_ADMIN","ROLE_MAGAZINIER(E)_EMB"})
	@GetMapping(value="/cancelsortieemb/{gesliv}")
	public HashMap<String,Object> cancelSortieEmb(@PathVariable long gesliv){
		ReponseDto r= new ReponseDto();
		GestionLivraison gl= sl.getGestionLivraisonByIdValide(gesliv);
		r=sl.annulerSortieEmb(gl);
		
		return r.getResponse();
	}
	
	/*
	 * OK
	 * SECRETAIRE,DG
	 */
	@Secured(value={"ROLE_ADMIN","ROLE_SECRETAIRE"})//peut-être la caissiere également.NON!
	@PostMapping(value="/avanceargentliv")
	public HashMap<String,Object> avanceArgentLiv(@RequestBody NewAvanceEmbLivraisonDto n){
		ReponseDto r= new ReponseDto(); 
		Livraison l= sl.getLivraisonValideById(n.getLiv());
		Personnel p= sl.getPersonnelValideByid(n.getPers());
		CollaborateurExt c= sl.getCEValideById(n.getCe());
		
		Fournisseur f= sl.getFournisseurValideById(sl.getCEValideById(sl.getLivraisonValideById(n.getLiv()).getMyCollaborateurExt().getIdCollaborateurExt()).getMyFournisseur().getIdFournisseur());
		if(f!=c.getMyFournisseur()) {
			r.format(Code.FAILURE, "Ce collaborateur extérieur n'est pas de "+sl.getLivraisonValideById(n.getLiv()).getMyCollaborateurExt().getMyFournisseur().getNom()+ " (Fournisseur de cette livraison).");
			return r.getResponse();
		}
		
		if(l.getMyDetailsLivraison().getResteSolde()<n.getAvance()) {
			r.format(Code.FAILURE, "Ce montant est supérieur au reste à payer pour Cette livraison."
									+ " Le véritable reste est: "+l.getMyDetailsLivraison().getResteSolde());
			return r.getResponse();
		}
		
		Caisse caisse= sv.getCaisseValide();
		if(caisse.getMontantCaisse()<n.getAvance()) {
			r.format(Code.FAILURE, "Retrait de caisse impossible: Ce montant est inférieure au montant disponible en caisse");
			return r.getResponse();
		}
		r= sl.avanceLivraison(l, p, c, n.getAvance(), true, false);
		
		return r.getResponse();
	}
	
	/*
	 * OK
	 * SECRETAIRE,DG
	 */
	@Secured(value={"ROLE_ADMIN","ROLE_SECRETAIRE"})
	@PostMapping(value="/deconsigneembliv")// C'est en fait une avance d'argent.
	public HashMap<String,Object> deconsigneEmbLiv(@RequestBody NewAvanceEmbLivraisonDto n){
		ReponseDto r= new ReponseDto(); 
		Livraison l= sl.getLivraisonValideById(n.getLiv());
		Personnel p= sl.getPersonnelValideByid(n.getPers());
		CollaborateurExt c= sl.getCEValideById(n.getCe());
		
		MagEmballage me= sl.getMaMagEmballageValideByFournisseur(l.getMyCollaborateurExt().getMyFournisseur());
		if(me.getQteMag()<n.getAvance()) {
			r.format(Code.FAILURE, "Au magazin, cette quantité d'emballage n'est pas disponible. "
					+ " La quantité disposnible est: " +me.getQteMag());
			return r.getResponse();
		}
		
		r=sl.avanceLivraison(l, p, c, n.getAvance(), false, true);
		
		return r.getResponse();
	}
	
	/*
	 * OK
	 * Acteur: DG
	 */
	//décaissement
	@Secured(value={"ROLE_ADMIN"})
	@GetMapping(value="/decaisserargentlivcaisse")
	public HashMap<String,Object> decaisserArgentLivDeCaisse(@RequestParam (name="gesliv") long gesliv,
													 @RequestParam (name="caiss") long caiss){
		ReponseDto r= new ReponseDto();
		GestionLivraison gl= sl.getGestionLivraisonByIdValide(gesliv);
		Personnel p= sl.getPersonnelValideByid(caiss);
		
		r= sv.decaisserAvanceLivraisonDeCaisse(gl, p);
		
		return r.getResponse();
	}
	/*
	 * OK
	 * Acteur: CAISSIER(E), DG
	 */
	@Secured(value={"ROLE_ADMIN","ROLE_CAISSIER(E)"})
	@GetMapping(value="/decaisserargentlivcj")
	public HashMap<String,Object> decaisserArgentLivDeCJ(@RequestParam (name="gesliv") long gesliv,
													 	 @RequestParam (name="caiss") long caiss){
		ReponseDto r= new ReponseDto();
		GestionLivraison gl= sl.getGestionLivraisonByIdValide(gesliv);
		Personnel p= sl.getPersonnelValideByid(caiss);
		
		r= sv.decaisserAvanceLivraisonDeCaisseJournaliere(gl, p);	
		return r.getResponse();
	}
	
	/*
	 * OK
	 * Acteur: SECRETAIRE, DG
	 */
	@Secured(value={"ROLE_ADMIN","ROLE_SECRETAIRE"})
	@GetMapping(value="/cancelavanceliv/{gesliv}")
	public HashMap<String,Object> cancelAvanceLiv(@PathVariable long gesliv){
		ReponseDto r= new ReponseDto();
		
		GestionLivraison gl= sl.getGestionLivraisonByIdValide(gesliv);
		
		r=sl.annulerAvanceLivraison(gl);
		
		return r.getResponse();
	}
	
	/*
	 * Pour la suite:
	 * - Gérer les opération d 'emballages
	 * - Effectuer des avance de solde ou forme d'Argent et de déconsigne
	 * - Faire les décaissements	 */
	
	
	
	
	
}
