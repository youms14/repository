package youmssoft.repository.services;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import youmssoft.repository.dao.livraison.CollaborateurExtRepository;
import youmssoft.repository.dao.livraison.DetailsLivraisonRepository;
import youmssoft.repository.dao.livraison.FournisseurRepository;
import youmssoft.repository.dao.livraison.GestionLivraisonRepository;
import youmssoft.repository.dao.livraison.LivraisonRepository;
import youmssoft.repository.dao.livraison.PersonnelRepository;
import youmssoft.repository.dao.livraison.ProduitLivraisonRepository;
import youmssoft.repository.dao.livraison.ProduitRepository;
import youmssoft.repository.dao.ventes.ArgentMvtRepository;
import youmssoft.repository.dao.ventes.EmballagesMvtRepository;
import youmssoft.repository.dao.ventes.MagEmballageRepository;
import youmssoft.repository.dao.ventes.ProduitMvtRepository;
import youmssoft.repository.dto.CollaborateurExtDto;
import youmssoft.repository.dto.EmballageMvtDto;
import youmssoft.repository.dto.FournisseurDto;
import youmssoft.repository.dto.GestionLivraisonDto;
import youmssoft.repository.dto.LivraisonDto;
import youmssoft.repository.dto.ProduitsLivraisonDto;
import youmssoft.repository.dto.ReponseDto;
import youmssoft.repository.dto.ReponseDto.Code;
import youmssoft.repository.entities.livraison.CollaborateurExt;
import youmssoft.repository.entities.livraison.DetailsLivraison;
import youmssoft.repository.entities.livraison.Fournisseur;
import youmssoft.repository.entities.livraison.GestionLivraison;
import youmssoft.repository.entities.livraison.Livraison;
import youmssoft.repository.entities.livraison.Personnel;
import youmssoft.repository.entities.livraison.Produit;
import youmssoft.repository.entities.livraison.ProduitsLivraison;
import youmssoft.repository.entities.ventes.ArgentMvt;
import youmssoft.repository.entities.ventes.EmballagesMvt;
import youmssoft.repository.entities.ventes.InterfaceCaisse;
import youmssoft.repository.entities.ventes.MagEmballage;
import youmssoft.repository.entities.ventes.ProduitMvt;

@Service
public class ServicesLivraison {
	public static final long DEFAULT_DL = 1;

	public static final String TYPE_CASIER = "casier";
	
	public static final String TYPE_PET = "pet";

	public static final float PRIX_EMB = 3000;

	public static final String LIBELLE_ARGENT_LIVRAISON = "Avance concernant la livraison de ";

	public static final Boolean ENTREE_ARGENT = true;

	public static final Boolean ENTREE_EMB = true;

	public static final String LIBELLE_EMB_LIVRAISON = "Sortie Emballages Livraison  ";

	public static final Boolean ENTREE_PROD = true;

	public static final Boolean SORTIE_EMB = false;

	public static final String LIBELLE_STOCKAGE_PRODUIT = "Stockage de Produit de Livraison";

	@Autowired
	CollaborateurExtRepository collaborateurExtRepository;
	
	@Autowired
	DetailsLivraisonRepository detailsLivraisonRepository;
	
	@Autowired
	FournisseurRepository fournisseurRepository;
	
	@Autowired
	GestionLivraisonRepository gestionLivraisonRepository;
	
	@Autowired
	LivraisonRepository livraisonRepository;
	
	@Autowired
	PersonnelRepository personnelRepository;
	
	@Autowired
	ProduitLivraisonRepository produitLivraisonRepository;
	
	@Autowired
	ProduitRepository produitRepository;
	
	@Autowired
	ArgentMvtRepository argentMvtRepository;
	
	@Autowired
	EmballagesMvtRepository emballagesMvtRepository;
	
	@Autowired
	ProduitMvtRepository produitMvtRepository;
	
	@Autowired 
	MagEmballageRepository magEmballageRepository;
	
	float cumulVersement = 0;
	float cumulEmb = 0;
	float total=0;

	 LocalTime heure=LocalTime.now();

	 LocalDate date=LocalDate.now();
	
	//Timestamp timestamp = new Timestamp(System.currentTimeMillis());// Useless
	
	 //Utilitaire: 
	 public Personnel getPersonnelValideByid(long id) {
		 return personnelRepository.findByIdPersonnelAndIsValideTrue(id);
	 }
	 
	 public CollaborateurExt getCEValideById(long id) {
		 return collaborateurExtRepository.findByIdCollaborateurExtAndIsValideTrue(id);
	 }
	//================================================Samedi 07 mars===Mis à jour Dimanche 08 mars==========
	//1- Enregistrer une livraison
	/*
	 * Pour enregistrer une livraison, il faut effectuer les scenarios suivant:
	 * - initialiser les atributs de livraison avec:
	 * 		- un solde 0
	 * 		- un total emb 0
	 * 		- un nombre colis 0
	 * 		- un total ristoune 0
	 * 		- un isEmbOk= false
	 * 		- un isSolded= false
	 * 		* un jour livraison extrait de LocalDate
	 * - Affecter  l'objet DetailsLivraison d'id = 1.(avance=0: Aucun versement n'est fait.DEFAULT_DL)
	 * - Affecter le personnel
	 * - Créer les ProduitsLivraisons associés
	 * 		- Chaque fois qu'un produitLivraison est ajouté, faire les sommes directement(dans Livraison)
	 * 		- Cela passe par la mise à jour des attributs ci-dessus initilisés à 0 
	 * - Entrez l'identifiant de la facture remise par le fournisseur,
	 * - Entrez le collaborateurExt(ses informations),
	 * - Puis validez.
	 *///==============================================================================part 1===OK
	 @Transactional
	 public long initialiserLivraison (Personnel pers, CollaborateurExt collExt) {
		
		
		
		
		Livraison li=new Livraison();//ce constructeur initialise les attributs de livraison à 0.
					//li.setMyDetailsLivraison(detailsLivraisonRepository.findById((long) DEFAULT_DL).get());
		
		//On crée le detailsLivraison associé avec les valeurs par defaut.
			DetailsLivraison detailsLivraison=detailsLivraisonRepository.save(new DetailsLivraison());//On recupère le detailsLivraison en question
		li.setMyDetailsLivraison(detailsLivraison);//on le set dans l'objet li.
		li.setMyPersonnel(pers);//On suppose ici que le personnel existe forcément.
		li.setMyCollaborateurExt(collExt);// De même que le collaborateur exterieur existe.
		Livraison livraison= livraisonRepository.save(li);//Ok pour livraison
			//association de livraison à son details associé.
			detailsLivraison.setMyLivraison(livraison);
			detailsLivraisonRepository.save(detailsLivraison);
		return livraison.getIdLivraison();
	}
	//===================================================================================part 2===OK==OK 18 mars
	 @Transactional
	 public ReponseDto affecterProduits(Livraison livraison, float quantite, Produit produit) {
		ReponseDto r= new ReponseDto();
		
		if(livraison==null) {
			r.format(Code.FAILURE, "Cette livraison n'existe pas");
			return r;
		}
		
		if(produit==null) {
			r.format(Code.FAILURE, "Ce produit n'existe pas");
		}
		
		if(quantite<=0) {
			r.format(Code.FAILURE, "La quantité doit être un nombre positif");
			return r;
		}
		
		
		ProduitsLivraison pl2=produitLivraisonRepository.findByMylivraisonAndMyProduitAndIsValideTrue(livraison,produit);
		ProduitsLivraison pl;
		
		if(pl2!=null) {
			pl2.setQuantite(pl2.getQuantite()+quantite);
			pl2.setPt();
			pl2.setRistPL();
			pl=produitLivraisonRepository.save(pl2);
		}else {
			pl= new ProduitsLivraison(quantite,produit,livraison);
			produitLivraisonRepository.save(pl);
		}
		
		
		
		//Mise à jour pour Livraison
		livraison.setNbColis(livraison.getNbColis()+quantite);
		if (produit.getType().equals(TYPE_CASIER)){
			livraison.setNbEmb(livraison.getNbEmb()+quantite);
		}
		livraison.setSoldeLivraison(livraison.getSoldeLivraison()+pl.getPt());
		livraison.setTotalRist(livraison.getTotalRist()+pl.getRistPL());
		
		//Mise à jour du reste à payer dans detailsLivraison. 18 mars 2020: le reste à payer est la somme actuelle
		
		DetailsLivraison dll=detailsLivraisonRepository.findByIdDetailsLivraisonAndIsValideTrue((long) livraison.getMyDetailsLivraison().getIdDetailsLivraison());
		dll.setResteSolde(dll.getResteSolde()+pl.getPt());
		if(produit.getType().equals(TYPE_CASIER)) {
			dll.setResteEmb(dll.getResteEmb()+quantite);//TU T'ES ARRETE ICI.
		}
		dll.setAvanceEmb(0);
		dll.setAvanceSolde(0);
		dll.setMyLivraison(livraison);
		detailsLivraisonRepository.save(dll);
		Livraison nl= livraisonRepository.save(livraison);
		LivraisonDto ldto= new LivraisonDto(nl.getIdLivraison(), nl.getNbEmb(), nl.getNbColis(), nl.getSoldeLivraison());
		
		r.format(Code.SUCCESS, ldto);
		return r;//On persiste
	}	
	
	
	/*
	 * Retirer un produit de la liste de produits d'une livraison.
	 */
	@Transactional
	public ReponseDto retirerProduitLivraison(Livraison l, Produit p) {
		ReponseDto r= new ReponseDto();
		if(l==null) {
			r.format(Code.FAILURE, "Cette livraison n'existe pas");
			return r;
		}
		
		if(p==null) {
			r.format(Code.FAILURE, "Ce produit n'existe pas");
			return r;
		}
		
		if(!l.isValide()) {
			r.format(Code.FAILURE, "Cette livraison est invalide");
			return r;
		}
		
		if (!p.isValide()) {
			r.format(Code.FAILURE, "Ce produit est invalide");
			return r;
		}
		
		ProduitsLivraison pl= produitLivraisonRepository.findByMylivraisonAndMyProduitAndIsValideTrue(l, p);
		
		
		if(pl==null) {
			r.format(Code.FAILURE, "Ce produit ne fait pas partie de cette livraison");
			return r;
		}
		
		if(!pl.isValide()) {
			r.format(Code.FAILURE, "Ce produit est déjà retiré de cette livraison");
			return r;
		}
		
		if(l.isSotcked()) {
			r.format(Code.FAILURE, "Impossible, Cette livraison est déjà stockée");
			return r;
		}
		
		
		if (l.isEmbOk()) {
			r.format(Code.FAILURE, "Cette livraison est déjà soldée en terme d'amballages");
			return r;
		}
		
		if(l.isSolded()) {
			r.format(Code.FAILURE, "Cette livraison est déjà soldée.");
			return r;
		}
		
		pl.setValide(false);
		produitLivraisonRepository.save(pl);
		
		//Modification dans DetailsLivraison
		DetailsLivraison dl= detailsLivraisonRepository.findByIdDetailsLivraisonAndIsValideTrue(l.getMyDetailsLivraison().getIdDetailsLivraison());
		if(p.getType().equals(TYPE_CASIER))	{
			dl.setResteEmb(dl.getResteEmb()-pl.getQuantite());
			l.setNbEmb(l.getNbEmb()-pl.getQuantite());
		}
			dl.setResteSolde(dl.getResteSolde()-pl.getPt());
		detailsLivraisonRepository.save(dl);
		
		//Modification dans Livraison
		l.setNbColis(l.getNbColis()-pl.getQuantite());
		l.setSoldeLivraison(l.getSoldeLivraison()-pl.getPt());
		l.setTotalRist(l.getTotalRist()-pl.getRistPL());
		
		Livraison nl= livraisonRepository.save(l);
		LivraisonDto ldto= new LivraisonDto(nl.getIdLivraison(),nl.getNbEmb(),nl.getNbColis(),nl.getSoldeLivraison());
		
		r.format(Code.SUCCESS, ldto);
		
		return r;
		
	}
	//Modifier la quantité d'un produit
	/*
	 * Status: non ok
	 * type: principal
	 */
	@Transactional
	public ReponseDto modifierQuantiteproduitLivraison(Livraison l, Produit p, float newQte) {
		ReponseDto r= new ReponseDto();
		if(l==null) {
			r.format(Code.FAILURE, "Cette livraison n'existe pas");
			return r;
		}
		
		if(p==null) {
			r.format(Code.FAILURE, "Ce produit n'existe pas");
			return r;
		}
		
		if(newQte<=0) {
			r.format(Code.FAILURE, "Cette quantité est invalide. Entrez un nombre positif");
			return r;
		}
		
		if(!l.isValide()) {
			r.format(Code.FAILURE, "Cette livraison est invalide");
			return r;
		}
		
		if (l.isEmbOk()) {
			r.format(Code.FAILURE, "Cette livraison est déjà soldée en terme d'amballages") ;
			return r;
		}
		
		if(l.isSolded()) {
			r.format(Code.FAILURE, "Cette livraison est déjà soldée");
			return r;
		}
				
		if(l.isSotcked()) {
			r.format(Code.FAILURE, "Cette livraison est déjà stockée");
			return r;
		}
		
		ProduitsLivraison pl= produitLivraisonRepository.findByMylivraisonAndMyProduitAndIsValideTrue(l, p);

		if(pl==null) {
			r.format(Code.FAILURE, "Ce produit ne fait pas partie de cette livraison");
			return r;
		}

		if(!pl.isValide()) {
			r.format(Code.FAILURE, "Cet produit est déjà retiré de cette livraison");
			return r;
		}

		
		float oldQte=pl.getQuantite();
		float oldPt=pl.getPt();
		float oldRist=pl.getRistPL();
		
		ProduitsLivraison newPl= new ProduitsLivraison(newQte,p,l);
		//Modification dans ProduitLivraison
		pl.setQuantite(newQte);
		pl.setMyProduit(p);
		pl.setRistPL();
		pl.setPt();
		produitLivraisonRepository.save(pl);
		
		
		//Modifications dans DetailsLivraison
		DetailsLivraison dl=l.getMyDetailsLivraison();
		if(p.getType().equals(TYPE_CASIER)) {
			dl.setResteEmb(dl.getResteEmb()-oldQte+newQte);
			l.setNbEmb(l.getNbEmb()-oldQte+newQte);
		}	
		dl.setResteSolde(dl.getResteSolde()-oldPt+ newPl.getPt());
		detailsLivraisonRepository.save(dl);
		
		//Modifications dans livraison
		l.setNbColis(l.getNbColis()-oldQte+newQte);
		l.setTotalRist(l.getTotalRist()-oldRist+newPl.getRistPL());
		l.setSoldeLivraison(l.getSoldeLivraison()-oldPt+newPl.getPt());
		
		
		Livraison nl= livraisonRepository.save(l);
		LivraisonDto ldto= new LivraisonDto(nl.getIdLivraison(),nl.getNbEmb(),nl.getNbColis(),nl.getSoldeLivraison());
		
		r.format(Code.SUCCESS, ldto);
		
		return r;
		
	}
	
	//Pour terminer une livraison
	//==================================================================ok Dimanche le 08 mars
	@Transactional
	public ReponseDto terminerLivraison(Livraison livraison,String numFacture) {
		ReponseDto r= new ReponseDto();
		if(livraison==null) {
			r.format(Code.FAILURE, "Cette livraison n'existe pas.");
			return r;
		}	
		livraison.setNumFactLivraision(numFacture);
		Livraison l=livraisonRepository.save(livraison);
			r.format(Code.SUCCESS, new LivraisonDto(l.getIdLivraison(),l.getNbEmb(),l.getNbColis(),l.getSoldeLivraison(),l.getNumFactLivraision()));
		return r;
		
		
	}//Apres l'execution de cette methode la livraison est enregistrée. les opérations peuvent être effectuées.

	/*
	 * Consulter le reste(À payer) d'une livraison.
	 * =========================================================18 mars 2020
	 */
	public float consulterResteArgent(Livraison livraison) {
		return detailsLivraisonRepository.findByIdDetailsLivraisonAndIsValideTrue((long) livraison.getMyDetailsLivraison().getIdDetailsLivraison()).getResteSolde();
	}
	
	/*
	 * Consulter le reste(d'Emballage) d'une livraison.
	 * =========================================================18 mars 202
	 */
	public float consulterResteEmb(Livraison livraison) {
		return detailsLivraisonRepository.findByIdDetailsLivraisonAndIsValideTrue((long) livraison.getMyDetailsLivraison().getIdDetailsLivraison()).getResteEmb();
	}
	// CAS DE VOL, PAR MANQUE D'ENREGISTREMENT (ESSENGUE)
	//=================================================Samedi 07 mars====Testé dim 22 mars
	//Opération pour effectuer une avance(Argent/Emballage) sur une livraison : GestionLivraison
	
	@Transactional
	public ReponseDto avanceLivraison(Livraison li, Personnel pers, CollaborateurExt cext, float avance, boolean isMoney, boolean isDeconsigned) {
		ReponseDto r= new ReponseDto();
		
		if(li==null) {
			r.format(Code.FAILURE, "Cette livraison n'existe pas");
			return r;
		}
		
		if(pers==null) {
			r.format(Code.FAILURE, "Ce personnel n'existe pas");
			return r;
		}
		
		if (cext==null) {
			r.format(Code.FAILURE, "Ce collaborateur n'existe pas");
			return r;
		}
		
		if(avance<=0) {
			r.format(Code.FAILURE, "Veillez saisir une quantité valide");
			return r;
		}
		if(isMoney && !isDeconsigned && li.isSolded()) {
			r.format(Code.FAILURE, "Cette livraison a déjà été completement soldée");
			return r;
		}
		
		if(isMoney && isDeconsigned && li.isEmbOk()) {
			r.format(Code.FAILURE, "Les Emballages de Cette livraison ont déjà été completement remis");
			return r;
		}
		
		if(!isMoney && !isDeconsigned && li.isEmbOk() ) {
			r.format(Code.FAILURE, "Les Emballages de Cette livraison ont déjà été completement remis");
			return r;
		}
		
		if(!isMoney && isDeconsigned && li.isSolded()) {
			r.format(Code.FAILURE, "Cette livraison a déjà été completement soldée");
			return r;
		}
		
		if(!isMoney && !isDeconsigned && li.getMyDetailsLivraison().getResteEmb()<avance) {
			r.format(Code.FAILURE, "Pour cette livraison, les emballages à remetre sont inférieurs à l'avance que vous éffectuez"
					+ "Vous donnez plus qu'il n'en faut. Le reste des emballages pour cette livraison est:"+li.getMyDetailsLivraison().getResteEmb());
			return r;
		}
		
		if(cext.getMyFournisseur()!=li.getMyCollaborateurExt().getMyFournisseur()) {
			r.format(Code.FAILURE, "Ce Collaborateur n'est pas du même fournisseur de cette livraison");
			return r;
		}
	
		
		GestionLivraison gl=new GestionLivraison();
			gl.setNatureOperation(isMoney);
			gl.setDeconsigned(isDeconsigned);
			gl.setAvanceGL(avance);
			gl.setMyLivraison(li);
			gl.setMyPersonnelInt(pers);
			gl.setPersonnelExt(cext);
			gl.setManaged(false);
			gl.setDateOperation(LocalDate.now());
			gl.setHeureOperation(LocalTime.now());
		GestionLivraison gls=	gestionLivraisonRepository.save(gl);
		/*if(isMoney) {
			ArgentMvt argentMvt= new ArgentMvt();
			argentMvt.setMontant(avance);
			argentMvt.setNatureMvt(ENTREE_ARGENT);
			argentMvt.setMyGestionLivraison(gls);
			argentMvt.setDateOpArgent(LocalDate.now());
			argentMvt.setHeureOpArgent(LocalTime.now());
				StringBuilder builder = new StringBuilder();
				if(isDeconsigned) {
					builder.append("DECONSIGNE: ");
				}
			argentMvt.setLibelleArgent(builder.append(LIBELLE_ARGENT_LIVRAISON).append(li.getJourLivraison()).toString());
			gls.setMyArgentMvt(argentMvtRepository.save(argentMvt));//On associe l'Argent encaissé à l'opération de Gestion Livraison Correspondante.
		}else {
			EmballagesMvt embMvt= new EmballagesMvt();
			embMvt.setDateOp(LocalDate.now());
			embMvt.setHeureOp(LocalTime.now());
			embMvt.setMyGestionLivraison(gls);
			embMvt.setNatureMvtEmb(ENTREE_EMB);
			embMvt.setQuantiteEmb(avance);
			embMvt.setFournisseurEmb(cext.getMyFournisseur());
				StringBuilder builder = new StringBuilder();
				if(isDeconsigned) {
					builder.append("DECONSIGNE: ");
				}
			embMvt.setLibelleMvtEmb(builder.append(LIBELLE_EMB_LIVRAISON).append(li.getJourLivraison()).toString());
			gls.setMyEmballagesMvt(emballagesMvtRepository.save(embMvt));
		}
		*/
		
		;
		
		//gestionLivraisonRepository.save(gls);
		//
		
		
		//Mise à jour dans detailsLivraison
		try { 
			//On récupère le DetailsLivraison de la livraison pour laquelle on a effectué l'opération d'avance		
			DetailsLivraison dl= detailsLivraisonRepository.findByIdDetailsLivraisonAndIsValideTrue((long) li.getMyDetailsLivraison().getIdDetailsLivraison());
			//JE MET À JOUR LES ATTRIBUTS DE DETAILSLIVRAISON en additionnant l'avance actuel à l'avance ancienne.
			if(!isDeconsigned) {//pas de consignation(opération normale)
				if(isMoney){
							System.out.println("SOLDE avant Avance: " +dl.getAvanceSolde());
					dl.setAvanceSolde(dl.getAvanceSolde() + avance);
							System.out.println("SOLDE apres Avance: " +dl.getAvanceSolde());
							System.out.println("RESTE avant Avance:  " +dl.getResteSolde());
					dl.setResteSolde(dl.getResteSolde() - avance);
						System.out.println("RESTE avant Avance: "+ dl.getResteSolde());
				}else {
							System.out.println("Emballage avant Avance: " + dl.getAvanceEmb());
					dl.setAvanceEmb(dl.getAvanceEmb() + avance);
							System.out.println("Emballage apres Avance: " + dl.getAvanceEmb());
							System.out.println("Reste Emballage avant Avance: " + dl.getResteEmb());
					dl.setResteEmb(dl.getResteEmb()- avance);
							System.out.println("Reste Emballage apres Avance: " + dl.getResteEmb());
				}
			}else { //deconsigne (opération): ici on s'en fou que ce soit argent/emballage
					dl.setDeconsignedDL(isDeconsigned);
					dl.setDeconsigneValue(avance);
			}
			DetailsLivraison dl2=detailsLivraisonRepository.save(dl);//persistence
			
			//Mise à jour de isEmOk et isSolded dans livraison === A REVOIR
			Livraison lii= livraisonRepository.findByIdLivraisonAndIsValideTrue(li.getIdLivraison());
			float nbCasierCons=avance/PRIX_EMB;// nombre de casiers déconsignés
			if ((dl.getAvanceEmb()>=lii.getNbEmb()) || (nbCasierCons+dl.getAvanceEmb()== lii.getNbEmb() )) {
						System.out.println("EMB_OK/DECONSIGNE REUSSI.");
				lii.setEmbOk(true);
				//dl.setResteEmb(dl.getResteEmb()-nbCasierCons);
				livraisonRepository.save(lii);
			}
			
			if((dl.getAvanceSolde()>=lii.getSoldeLivraison()) || (avance*PRIX_EMB + dl.getAvanceSolde() == lii.getSoldeLivraison())){
						System.out.println("SOLDED_OK/DECONSIGNE REUSSI.");
				lii.setSolded(true);
				livraisonRepository.save(lii);
			}
			//mise à jour tenant compte de la déconsigne
			if(isDeconsigned && isMoney) {
				dl2.setAvanceEmb(dl2.getAvanceEmb()+nbCasierCons);
				dl2.setResteEmb(dl2.getResteEmb()-nbCasierCons);
			}
			if(isDeconsigned && !isMoney) {
				dl2.setAvanceSolde(dl2.getAvanceSolde()+avance*PRIX_EMB);
				dl2.setResteSolde(dl2.getResteSolde()-avance*PRIX_EMB);
			}
			detailsLivraisonRepository.save(dl2);
			
			
		}catch(Exception e) {
			System.out.println(e.getMessage());
			r.format(Code.FAILURE, e.getMessage());
			return r;
		}
		
		//Données qui seront envoyées.
		GestionLivraisonDto gldto= new GestionLivraisonDto();
			gldto.setIdGl(gls.getIdGestionLivraison());
			gldto.setIdPersExt(gls.getPersonnelExt().getIdCollaborateurExt());
			if(gls.getNatureOperation()) {
				gldto.setUnite("FCFA");
			}else {
				gldto.setUnite("Emballages");
			}
			
			if(!gls.isManaged()) {
				gldto.setEtat("Non traité");
			}else {
				gldto.setEtat("Traité");
			}
			
			gldto.setQuantite(gls.getAvanceGL());
			gldto.setIdPersonnel(gls.getMyPersonnelInt().getIdPersonnel());
			gldto.setIdLivraison(gls.getMyLivraison().getIdLivraison());
			
		r.format(Code.SUCCESS, gldto);
		return r;
	}//ok
	
	
	/*
	 * Fonction Plus complète pour éffectuer l'Avance d'argent sur une Livraison.
	 *
	public void avanceLivraisonArgentFromCaisse(InterfaceCaisse in,Livraison li,Personnel pers, CollaborateurExt cext,boolean isDeconsigned){
		float avance= in.getMontantOperation();
		GestionLivraison gl=this.avanceLivraison(li, pers, cext, avance, true, isDeconsigned);
		in.setMyArgentMvt(gl.getMyArgentMvt());
		
		
	}*/
	
	/*
	 * Acteur: MAGASINIER (EMB)
	 * wb:ok
	 */
	@Transactional
	public ReponseDto sortirEmballageLivraison (GestionLivraison gl, Personnel mag) {
		ReponseDto r= new ReponseDto();
		if (gl==null) {
			r.format(Code.FAILURE, "Cette opération de livraison n'existe pas.");
			return r;
		}
		
		if(mag==null) {
			r.format(Code.FAILURE , "Ce personnel n'existe pas");
			return r;
		}
		
		if (!gl.isValide()) {
			r.format(Code.FAILURE, "Cette opération de livraison n'existe pas.");
			return r;
		}
		
		if(!mag.isValide()) {
			r.format(Code.FAILURE , "Ce personnel n'existe pas");
			return r;
		}
		
		if(gl.isManaged()) {
			r.format(Code.FAILURE, "Cette operation de Livraison est déja gérée");
			return r;
		}
		
		
		MagEmballage lma= magEmballageRepository.findByFournisseurAndIsValideTrue(gl.getPersonnelExt().getMyFournisseur());
		if(gl.getNatureOperation()) {
			r.format(Code.FAILURE, "Ce n'est pas une aporation de solde mais une operation d'emballage");
			return r;
		}
		
		if (gl.getAvanceGL()>lma.getQteMag()) {
			r.format(Code.FAILURE, "Retrait impossible vous n'avez assez d'emballages au magazin");
			return r;
		}
		//1- Creer une nouvelle ligne EmballageMvt
		EmballagesMvt embMvt= new EmballagesMvt();
			embMvt.setDateOp(date);
			embMvt.setHeureOp(heure);
			embMvt.setMyGestionLivraison(gl);
			embMvt.setNatureMvtEmb(SORTIE_EMB);
			embMvt.setQuantiteEmb(gl.getAvanceGL());
			embMvt.setFournisseurEmb(gl.getPersonnelExt().getMyFournisseur());
			embMvt.setMagasinierEMB(mag);
			embMvt.setLibelleMvtEmb(LIBELLE_EMB_LIVRAISON.concat(" ".concat(gl.getPersonnelExt().getMyFournisseur().getNom())));
		EmballagesMvt embMvt2=emballagesMvtRepository.save(embMvt);
		
		//Mis à jour dans EmballageMvt
		gl.setMyEmballagesMvt(embMvt2);
		gl.setManaged(true);
		gestionLivraisonRepository.save(gl);
		
		//2- Mise à jour de MagEmballage
		lma.setQteMag(lma.getQteMag()-gl.getAvanceGL());
		magEmballageRepository.save(lma);
		
		//EmballageMvtDto emdto= new EmballageMvtDto(embMvt2.getIdEmb(),embMvt2.getLibelleMvtEmb(),embMvt2.getQuantiteEmb(),embMvt2.getFournisseurEmb().getNom(),embMvt2.getMyGestionLivraison().getIdGestionLivraison(),embMvt2.getMagasinierEMB().getIdPersonnel());
		EmballageMvtDto emdto= new EmballageMvtDto(embMvt2);
		//emdto.mapObjectToHashMap(embMvt2);
		
		r.format(Code.SUCCESS, emdto.mapObjectToHashMap(embMvt2));
		return  r;
	}
	
	/*
	 * Pour stocker une livraison au magasin
	 * =======================================================Jeudi, 19 mars 2020
	 * wb: ok
	 */
	@Transactional
	public ReponseDto stockerLivraison(Livraison li, Personnel magasinierPD) {
		ReponseDto r= new ReponseDto();
		
		if(li==null) {
			r.format(Code.FAILURE, "Cette livraison n'existe pas.");
			return r;
		}
		
		if(magasinierPD == null) {
			r.format(Code.FAILURE, "Ce personnel n'existe pas.");
			return r;
		}
		
		if(li.isSotcked()) {
			r.format(Code.FAILURE, "Cette livraison est déjà stocké");
			return r;
		}
		
		Livraison li2=livraisonRepository.findByIdLivraisonAndIsValideTrue(li.getIdLivraison());
		List<ProduitsLivraison> listPl= produitLivraisonRepository.findByMylivraisonAndIsValideTrue(li);
		listPl.forEach(pl->{
			ProduitMvt pdMvt= new ProduitMvt();
				pdMvt.setDate(LocalDate.now());
				pdMvt.setHeure(LocalTime.now());
				pdMvt.setNature(ENTREE_PROD);
				pdMvt.setLibelle(LIBELLE_STOCKAGE_PRODUIT);
				pdMvt.setMyLivraison(li);
				pdMvt.setProduit(pl.getMyProduit());
				pdMvt.setQuantite(pl.getQuantite());
				pdMvt.setMagasinierPROD(magasinierPD);
			produitMvtRepository.save(pdMvt);
		
			Produit p= produitRepository.findByIdProduitAndIsValideTrue(pl.getMyProduit().getIdProduit());
				float quantite=pl.getQuantite();
				p.setQuantite(p.getQuantite() + quantite);
			produitRepository.save(p);
			
			li2.setSotcked(true);
			livraisonRepository.save(li2);		
		});
		
		r.format(Code.SUCCESS, "Livraison stockée avec succes");
		return r;
	}
	
	@Transactional
	public ReponseDto annulerStockageLivraison(Livraison li) {
		ReponseDto r= new ReponseDto();
		
		if(li==null) {
			r.format(Code.FAILURE, "Cette livraison n'existe pas.");
			return r;
		}
		
		if(!li.isSotcked()) {
			r.format(Code.FAILURE, "Cette livraison n'est pas stockée");
			return r;
		}
		List<ProduitMvt> lpm=produitMvtRepository.findByMyLivraisonAndIsValideTrue(li);
		lpm.forEach(pm->{
			//Mise à jour dans Produit
			Produit p= produitRepository.findByIdProduitAndIsValideTrue(pm.getProduit().getIdProduit());
			p.setQuantite(p.getQuantite()-pm.getQuantite());
			produitRepository.save(p);
			
			//suppression du ProduitMvt
			pm.setValide(false);
			produitMvtRepository.save(pm);
		});
		
		//Livraison
		li.setSotcked(false);
		livraisonRepository.save(li);
		r.format(Code.SUCCESS, "Opération d'annulation de stockage éffectuée avec succes");
		
		return r;
	}
	
	public List<ProduitsLivraisonDto> listProduitsByLivraison(Livraison l){
		List<ProduitsLivraisonDto> lpldto= new ArrayList<ProduitsLivraisonDto>();
		List<ProduitsLivraison> lpl= produitLivraisonRepository.findByMylivraisonAndIsValideTrue(l);
		lpl.forEach(pl->{
			ProduitsLivraisonDto pldto= new ProduitsLivraisonDto(pl.getQuantite(), pl.getMyProduit().getNom(), pl.getPt());
			lpldto.add(pldto);
		});
		return lpldto;
	}
	
	
	/*
	 * Pour avoir la liste des credits (en Argent et/ou en Emballage)
	 * =========================================================Dimanche 22 mars===Ok
	 */
	public List<DetailsLivraison> creditsLivraison(boolean typeCred){//true pour Argent et false pour Emballage
		
		return typeCred? detailsLivraisonRepository.findByMyLivraisonIsSoldedFalseAndIsValideTrue():detailsLivraisonRepository.findByMyLivraisonIsEmbOkFalseAndIsValideTrue();
	}
	
	/*
	 * lister les opértions(D'avance) d'une livraison.
	 * ================================================ Dimanhe 22 mars==== Ok Lundi 23 mars
	 */
	public List<GestionLivraison> operationsLivraison(Livraison li,boolean typeOp){
			return gestionLivraisonRepository.findByMyLivraisonAndNatureOperationAndIsValideTrue(li, typeOp);
	}
	
	
	/*
	 * Donner les details d'une livraison d'une date donnéé
	 * ========================================== Dimanche 22 mars=== codé mardi 24 mars
	 * Status: Test Concluant======Ok
	 */
	public List<Livraison> getLivraisonByDate(LocalDate d) {
		return livraisonRepository.findByIsValideTrueAndDateLivraisonBetween(d.minusDays(1), d.plusDays(1));
	}
	
	/*
	 * Faire le cumul des ristournes des Livraison pour lesquels les collaborateurs Ext sont du même Fournisseur
	 * Paramètres: Fournisseur, dadeDebut, DateFin
	 * Resultats: DateLivraison(String) - ristoune(float) et total(String) - totalRistourne(float): HashMap<String,Float>
	 * ================================================== Dimanche 22 mars
	 */
	@Transactional
	public HashMap<Object,Object>  listAndCumulRistourne(Fournisseur f, LocalDate dateDebut, LocalDate dateFin) {
		HashMap<Object, Object> reponse = new HashMap<Object, Object>();
	
		Collection<CollaborateurExt> colCollExt=collaborateurExtRepository.findByMyFournisseurAndIsValideTrue(f);//liste des collaborateursExt du fournisseur particulier f
		livraisonRepository.findByMyCollaborateurExtInAndDateLivraisonBetweenAndIsValideTrueOrderByDateLivraisonAsc(colCollExt,dateDebut, dateFin).forEach(li->{ //liste des livraisons dont le collaborateurExt est dans dans la liste précedente et dont la dateLivraion es (strictement)entre deux dates.
			reponse.put(li.getDateLivraison().toString(), li.getTotalRist());
			System.out.println(reponse.toString());
			total=total+li.getTotalRist();
		});
		reponse.put("TOTAL", total);
		System.out.println(reponse.toString());
		return reponse;
	}

	public List<FournisseurDto> fournisseursList(){
		List<Fournisseur> lf= fournisseurRepository.findByIsValideTrue();
		List<FournisseurDto> lfDto= new ArrayList<FournisseurDto>();
			lf.forEach(f->{
				FournisseurDto fdto=new FournisseurDto();
					fdto.setNom(f.getNom());
					fdto.setIdFournisseur(f.getIdFournisseur());
				lfDto.add(fdto);
			});
			
			return lfDto;
	}
	
	public List<CollaborateurExtDto> getCollaborateurExtByFournisseur(long idFournisseur){
		Collection<CollaborateurExt> colCollExt= collaborateurExtRepository.findByMyFournisseurAndIsValideTrue(fournisseurRepository.findByIdFournisseurAndIsValideTrue(idFournisseur));
		List<CollaborateurExtDto> lcedto= new ArrayList<CollaborateurExtDto>();
		colCollExt.forEach(c->{
			CollaborateurExtDto ce= new CollaborateurExtDto();
					ce.setIdCollaborateurExt(c.getIdCollaborateurExt());
					ce.setNomCE(c.getNomCE());
					ce.setPrenomCE(c.getPrenomCE());
					ce.setNomFour(c.getMyFournisseur().getNom());
			lcedto.add(ce);
		});
		return lcedto;
	}
	
	public Livraison getLivraisonValideById(long idLivraison) {
		return livraisonRepository.findByIdLivraisonAndIsValideTrue(idLivraison);
	}
	
	public Produit getProduitValideById(long idProduit) {
		return produitRepository.findByIdProduitAndIsValideTrue(idProduit);
	}
	//===============================================Samedi 07 mars
	//Consultation des details (cumuls des opérations d'une facture)
	/*
	 * Cela passe par faire le cumul
	 * Enregistrer dans DetailsFacture
	 * Retourner la liste.
	 * a TESTER
	 *///=======================================================ok Testé Dimanche le 08
	/*
	public DetailsLivraison saveDetailsLivraison (Livraison li) {
		
		//Récupération des gestionLivraison dont la livraison est li
		List<GestionLivraison> lisOp= gestionLivraisonRepository.listOperationLivraison((long) li.getIdLivraison());
		//Cumul des versements et d'emballages de la livraison li
		cumulVersement=0;
		cumulEmb=0;
		lisOp.forEach(op->{
			if(op.getNatureOperation()) {//Argent
				cumulVersement=cumulVersement+op.getAvanceGL();
			}else {//Emballage
				cumulEmb= cumulEmb+op.getAvanceGL();
			}
		});
		//Enregistrement
		DetailsLivraison dl= new DetailsLivraison();
		dl.setAvanceEmb(cumulEmb);
		dl.setAvanceSolde(cumulVersement);
		dl.setDeconsigneEmb(0);
		//dl.setNumFactLivraision("00002");//A changer plus tard. Cet attribut doit être dans la table Livraison
		dl.setResteEmb(li.getNbEmb()- cumulEmb);
		dl.setResteSolde(li.getSoldeLivraison()-cumulVersement);
		detailsLivraisonRepository.save(dl);//persister avant d'associer à la livraison
		
		//Mise à jour dans livraison
		li.setMyDetailsLivraison(dl);
		
		
		//Persistence
		livraisonRepository.save(li);
		
		
		return dl;
		
	}
	*/
	

		
	public GestionLivraison getGestionLivraisonByIdValide(long idgl) {
		return gestionLivraisonRepository.findByIdGestionLivraisonAndIsValideTrue(idgl);
	}

	@Transactional
	public ReponseDto annulerLivraison(Livraison l) {
		ReponseDto r= new ReponseDto();

		if(l==null) {
			r.format(Code.FAILURE, "Cette livraison est invalide/inexistante");
			return r;
		}

		if(l.isEmbOk() || l.isSolded()) {
			r.format(Code.FAILURE, "Cette livraison est déjà soldée en Argent/Emballage");
			return r;
		}

		List<GestionLivraison> lgl= gestionLivraisonRepository.findByMyLivraisonAndIsValideTrue(l);

		if(lgl.size()!=0) {
			r.format(Code.FAILURE, "Des avances(argent/Emballage) sont déjà éffectués sur cette livraison. Donc ne peut être modifié");
			return r;
		}

		if(l.isSotcked()) {
			r.format(Code.FAILURE, "Cette livraison est déjà stockée.");
			return r;
		}

		//DetailsLivraison
		DetailsLivraison dl= l.getMyDetailsLivraison();
		dl.setValide(false);
		detailsLivraisonRepository.save(dl);

		//ProduitsLivraison
		List<ProduitsLivraison> listPl= produitLivraisonRepository.findByMylivraisonAndIsValideTrue(l);
		listPl.forEach(pl->{
			pl.setValide(false);
			produitLivraisonRepository.save(pl);
		});
		
		//Livraison
		l.setValide(false);
		livraisonRepository.save(l);

		r.format(Code.SUCCESS,"Livraison "+l.getIdLivraison()+" annulée avec succes.");

		return r;
	}

	@Transactional
	public ReponseDto annulerAvanceLivraison(GestionLivraison gl) {
		ReponseDto r= new ReponseDto();
		if(gl==null) {
			r.format(Code.FAILURE, "Cette opération de livraison est invalide/inexistante");
			return r;
		}
		
		if(!gl.isValide()) {
			r.format(Code.FAILURE, "Cette opération livraison est invalide");
			return r;
		}
		
		if(gl.isManaged()) {
			r.format(Code.FAILURE, "Cette Opération de facture est déjà encaissée/Stockée. Donc Impossible de l'annuler");
			return r;
		}
		Livraison l= livraisonRepository.findByIdLivraisonAndIsValideTrue(gl.getMyLivraison().getIdLivraison());
		DetailsLivraison dl=  detailsLivraisonRepository.findByIdDetailsLivraisonAndIsValideTrue(l.getMyDetailsLivraison().getIdDetailsLivraison());
		
		//DetailsLivraison, ArgentMvt/EmballageMvt
		if(gl.getNatureOperation()) {
			ArgentMvt argent=gl.getMyArgentMvt();
			if(argent!=null) {
				argent.setValide(false);
				argentMvtRepository.save(argent);
			}
			
			
			if(!gl.isDeconsigned()) {

				dl.setAvanceSolde(dl.getAvanceSolde()-gl.getAvanceGL());
				dl.setResteSolde(dl.getResteSolde()+ gl.getAvanceGL());
				
				if(dl.getAvanceSolde()<l.getSoldeLivraison()) {
					l.setSolded(false);
				}
			}else {
				float y=dl.getDeconsigneValue()-gl.getAvanceGL();
				if(y==0) {
					dl.setDeconsignedDL(false);
				}
				dl.setDeconsigneValue(y);
				
				float nbCasierCons= gl.getAvanceGL()/PRIX_EMB;
				
				if (nbCasierCons+dl.getAvanceEmb()!= l.getNbEmb() ) {
					System.out.println("Annulation EMB_OK/DECONSIGNE REUSSI.");
					l.setEmbOk(false);
				}
		
				dl.setAvanceEmb(dl.getAvanceEmb()-nbCasierCons);
				dl.setResteEmb(dl.getResteEmb()+nbCasierCons);
				
			}
			
		}else {
			
			if(!gl.isDeconsigned()) {
				List<EmballagesMvt> lem= emballagesMvtRepository.findByMyGestionLivraisonAndIsValideTrue(gl);
				if(lem.size()!=0) {
					lem.forEach(em->{
						em.setValide(false);
						emballagesMvtRepository.save(em);
					});
				}
				
				dl.setAvanceEmb(dl.getAvanceEmb()-gl.getAvanceGL());
				dl.setResteEmb(dl.getResteEmb()+gl.getAvanceGL());
				
				if(dl.getAvanceEmb()<l.getNbEmb()) {
					l.setEmbOk(false);
				}
			}else {
				float y=dl.getDeconsigneValue()-gl.getAvanceGL();
				if(y==0) {
					dl.setDeconsignedDL(false);
				}
				dl.setDeconsigneValue(y);
				
				if( gl.getAvanceGL()*PRIX_EMB + dl.getAvanceSolde() != l.getSoldeLivraison()){
					System.out.println("Annulation SOLDED_OK/DECONSIGNE REUSSI.");
					l.setSolded(false);
				}
				dl.setAvanceSolde(dl.getAvanceSolde()-gl.getAvanceGL()*PRIX_EMB);
				dl.setResteSolde(dl.getResteSolde()+gl.getAvanceGL()*PRIX_EMB);
			}
			
		}
		livraisonRepository.save(l);
		
		
		detailsLivraisonRepository.save(dl);
		
		
		gl.setValide(false);
		gestionLivraisonRepository.save(gl);
		
		r.format(Code.SUCCESS, "Opération "+gl.getIdGestionLivraison()+ " annulée avec succes");
		
		return r;
	}

	public ReponseDto annulerSortieEmb(GestionLivraison gl) {
		ReponseDto r= new ReponseDto();
		if(gl==null) {
			r.format(Code.FAILURE, "Cette opération de sortie d'emballage est invalide/inexistante");
			return r;
		}
		
		if(!gl.isValide()) {
			r.format(Code.FAILURE, "Cette opération de sortie d'emballage est invalide");
			return r;
		}
			
		if(!gl.isManaged()) {
			r.format(Code.FAILURE, "Cette opération de sortie est non gérée");
			return r;
		}
				
		List<EmballagesMvt> lem= emballagesMvtRepository.findByMyGestionLivraisonAndIsValideTrue(gl);
		
		lem.forEach(em->{
			MagEmballage ma= magEmballageRepository.findByFournisseurAndIsValideTrue(fournisseurRepository.findByIdFournisseurAndIsValideTrue(em.getFournisseurEmb().getIdFournisseur()));
			 ma.setQteMag(ma.getQteMag()+em.getQuantiteEmb());
			 magEmballageRepository.save(ma);
			 
			 em.setValide(false);
			 emballagesMvtRepository.save(em);
		 });
		 
		gl.setManaged(false);
		gestionLivraisonRepository.save(gl);
		 
		r.format(Code.SUCCESS, "Annulation de sortie des emballages liée à l'opération "+gl.getIdGestionLivraison()+" est effectuée avec sucess");
		return r;
	}

	public Fournisseur getFournisseurValideById(long four) {
		// TODO Auto-generated method stub
		return fournisseurRepository.findByIdFournisseurAndIsValideTrue(four);
	}

	public MagEmballage getMaMagEmballageValideByFournisseur(Fournisseur myFournisseur) {
		return magEmballageRepository.findByFournisseurAndIsValideTrue(myFournisseur);
	}
		
	//VI- 
	
}
