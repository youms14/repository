package youmssoft.repository;

import java.sql.Time;
import java.sql.Timestamp;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import youmssoft.repository.dao.RoleRepository;
import youmssoft.repository.dao.UsersRepository;
import youmssoft.repository.dao.livraison.CollaborateurExtRepository;
import youmssoft.repository.dao.livraison.DetailsLivraisonRepository;
import youmssoft.repository.dao.livraison.FournisseurRepository;
import youmssoft.repository.dao.livraison.GestionLivraisonRepository;
import youmssoft.repository.dao.livraison.LivraisonRepository;
import youmssoft.repository.dao.livraison.PersonnelRepository;
import youmssoft.repository.dao.livraison.ProduitLivraisonRepository;
import youmssoft.repository.dao.livraison.ProduitRepository;
import youmssoft.repository.dao.ventes.ArgentMvtRepository;
import youmssoft.repository.dao.ventes.CaisseJournaliereRepository;
import youmssoft.repository.dao.ventes.CaisseRepository;
import youmssoft.repository.dao.ventes.CassRepository;
import youmssoft.repository.dao.ventes.ChargementRepository;
import youmssoft.repository.dao.ventes.ClientRepository;
import youmssoft.repository.dao.ventes.CommandeRepository;
import youmssoft.repository.dao.ventes.CumulRistClientsRepository;
import youmssoft.repository.dao.ventes.DepensesRepository;
import youmssoft.repository.dao.ventes.EmballagesMvtRepository;
import youmssoft.repository.dao.ventes.FactureRepository;
import youmssoft.repository.dao.ventes.FacturesChargementRepository;
import youmssoft.repository.dao.ventes.GestionCaisseRepository;
import youmssoft.repository.dao.ventes.GestionFactureRepository;
import youmssoft.repository.dao.ventes.GestionRetourChargementRepository;
import youmssoft.repository.dao.ventes.MagEmballageRepository;
import youmssoft.repository.dao.ventes.PrixProduitsRepository;
import youmssoft.repository.dao.ventes.ProduitMvtRepository;
import youmssoft.repository.dao.ventes.ProduitsCommandeRepository;
import youmssoft.repository.dao.ventes.RetourChargementRepository;
import youmssoft.repository.dao.ventes.TotalRistournePayementRepository;
import youmssoft.repository.dto.UsedCaisseJounaliere;
import youmssoft.repository.entities.Role;
import youmssoft.repository.entities.User;
import youmssoft.repository.entities.livraison.CollaborateurExt;
import youmssoft.repository.entities.livraison.Livraison;
import youmssoft.repository.entities.livraison.Personnel;
import youmssoft.repository.entities.livraison.Produit;
import youmssoft.repository.entities.ventes.CaisseJournaliere;
import youmssoft.repository.entities.ventes.Chargement;
import youmssoft.repository.entities.ventes.Client;
import youmssoft.repository.entities.ventes.Facture;
import youmssoft.repository.entities.ventes.FacturesChargement;
import youmssoft.repository.entities.ventes.GestionCaisse;
import youmssoft.repository.entities.ventes.GestionFacture;
import youmssoft.repository.services.ServicesLivraison;
import youmssoft.repository.services.ServicesVentes;

@SpringBootApplication
public class RepositoryApplication implements CommandLineRunner{
	Timestamp timestamp = new Timestamp(System.currentTimeMillis());
	String heureActuel= LocalTime.now().toString().substring(0, 5);
	
	@Autowired
	private FournisseurRepository fournisseurRepository;
	
	@Autowired
	private CollaborateurExtRepository collaborateurExtRepository;
	
	@Autowired
	private ProduitRepository produitRepository;
	
	@Autowired
	private PersonnelRepository personnelRepository;
	
	@Autowired
	private DetailsLivraisonRepository detailsLivraisonRepository;
	
	@Autowired
	private ProduitLivraisonRepository produitLivraisonRepository;
	
	@Autowired 
	private LivraisonRepository livraisonRepository;
	
	@Autowired 
	private GestionLivraisonRepository gestionLivraisonRepository; 
	
	@Autowired 
	private ServicesLivraison servicesLivraison;
	
	@Autowired 
	private ServicesVentes servicesVentes;
	
	@Autowired
	ClientRepository clientRepository;
	
	@Autowired
	ArgentMvtRepository argentMvtRepository;
	
	@Autowired
	EmballagesMvtRepository emballagesMvtRepository;
	
	@Autowired
	ProduitMvtRepository produitMvtRepository;
	
	@Autowired
	ChargementRepository chargementRepository;
	
	@Autowired
	FacturesChargementRepository facturesChargementRepository;
	
	@Autowired
	PrixProduitsRepository prixProduitsRepository;
	
	@Autowired
	FactureRepository factureRepository;
	
	@Autowired
	CassRepository  cassRepository;
	
	@Autowired
	CaisseRepository caisseRepository;
	@Autowired
	GestionCaisseRepository gestionCaisseRepository;
	
	@Autowired
	MagEmballageRepository magEmballageRepository;
	
	@Autowired
	CumulRistClientsRepository cumulRistClientsRepository;
	
	@Autowired
	TotalRistournePayementRepository totalRistournePayementRepository;
	
	@Autowired 
	GestionFactureRepository gestionFactureRepository;
	
	@Autowired
	 RetourChargementRepository retourChargementRepository;
	
	@Autowired
	GestionRetourChargementRepository gestionRetourChargementRepository;
	
	@Autowired
	ProduitsCommandeRepository produitsCommandeRepository;
	
	@Autowired 
	CommandeRepository commandeRepository;
	
	@Autowired 
	CaisseJournaliereRepository caisseJournaliereRepository;
	
	@Autowired
	DepensesRepository depensesRepository;

	@Autowired
	UsersRepository usersRepository;

	@Autowired
	RoleRepository roleRepository;
	
	float sommeCJ=0;
	LocalDate date= LocalDate.now();
	LocalTime time= LocalTime.now();
	
	LocalDate date3=LocalDate.of(2010, 05, 4);
	
	
	public static void main(String[] args) {
		SpringApplication.run(RepositoryApplication.class, args);
	}
 

	@Override
	public void run(String... args) throws Exception {
		Personnel p= personnelRepository.findById((long) 87).get();//Personnel
		Personnel res= personnelRepository.findById((long) 59).get();
		
		Personnel p2=servicesLivraison.getPersonnelValideByid((long) 100 );
		System.out.println(p2);
		////////////////////////////////////////:PHASE DE TEST GENERAL DU MODULE GESTION VENTE/////////////////
		/*
		 * 	DG(BOSS)
		 */
		//1- Tout commence par la definition du capital par le Boss. ok
			//System.out.println(servicesVentes.definirCapital(2000000)); //OK
		
		/*
		 * 	DG(BOSS)
		 */
		//2- Ajout/Dimunition du capital ok
			//System.out.println(servicesVentes.operationCaisse(500000,true,"Reunion Bakassa"));
		
		/*
		 * 	DG(BOSS)
		 */
		//3- Definition du magasin des emballages: Le magazin est vide.
		    /* servicesVentes.initialiserMagEmballage(0,0,0).forEach(e->{
		    	 System.out.println(e.toString());
		     });*/
		
		/*
		 * 	DG(BOSS)
		 */
		//4- Achat de bouteilles. ok
				/*AchatEmballage ae=servicesVentes.achatBouteilles(300, 396000, "Ferailleurs", p);
								  servicesVentes.decaisserAchatBouteille(ae,p);
								  servicesVentes.stockerEmballageAchete(ae, p, 250, 30, 20).forEach(e->{
									  System.out.println(e.toString());
								  });*/
				
		/*
		 * 	SECRETAIRE(E)
		 */
		//4- Pour effectuer un achat: il faut faire enregister la livraison puis faire l'operation de decaissement.
			//i- Section de l'enregistrement des achats
					
					CollaborateurExt ceSABC= collaborateurExtRepository.findById((long) 1).get();//PersonnelExt
					CollaborateurExt ceUCB= collaborateurExtRepository.findById((long) 13).get();//PersonnelExt
					CollaborateurExt ceGUI= collaborateurExtRepository.findById((long) 25).get();//PersonnelExt

					Livraison liSABC= livraisonRepository.findById((long) 312).get();
					Livraison liUCB= livraisonRepository.findById((long) 335).get();
					Livraison liGUI= livraisonRepository.findById((long) 337).get();
					
					/*
					//Produits Brasseries
					Produit export= produitRepository.findById((long) 37).get();
					Produit castels= produitRepository.findById((long) 36).get();
					Produit booster= produitRepository.findById((long) 38).get();
					Produit mutzig= produitRepository.findById((long) 53).get();
					Produit top= produitRepository.findById((long) 39).get();
					Produit soda= produitRepository.findById((long) 40).get();
					Produit magnan=produitRepository.findById((long) 43).get();
					Produit fantaPet= produitRepository.findById((long) 42).get();
					Produit tangui=produitRepository.findById((long) 41).get();
					//Produits Guinness
					Produit pGui= produitRepository.findById((long) 44).get();
					Produit gGui=produitRepository.findById((long) 45).get();
					Produit smooth= produitRepository.findById((long) 46).get();
					Produit origin=produitRepository.findById((long) 47).get();
					Produit maltaG= produitRepository.findById((long) 48).get();
					//Produits UCB
					Produit kadji=produitRepository.findById((long) 49).get();
					Produit jusUCB= produitRepository.findById((long) 50).get();
					Produit petUCB=produitRepository.findById((long) 52).get();
					
				//servicesLivraison.initialiserLivraison(p,ceSABC);//312
				Livraison liSABC= livraisonRepository.findById((long) 312).get();
				Livraison liUCB= servicesLivraison.initialiserLivraison(p,ceUCB);//335
				Livraison liGUI= servicesLivraison.initialiserLivraison(p,ceGUI);//337
					
				servicesLivraison.affecterProduits(liSABC, 110, export);
				servicesLivraison.affecterProduits(liSABC, 40, castels);
				servicesLivraison.affecterProduits(liSABC, 20, booster);
				servicesLivraison.affecterProduits(liSABC, 40, mutzig);
				servicesLivraison.affecterProduits(liSABC, 30, top);
				servicesLivraison.affecterProduits(liSABC, 5, soda);
				servicesLivraison.affecterProduits(liSABC, 5, magnan);
				servicesLivraison.affecterProduits(liSABC, 5, tangui);
				servicesLivraison.affecterProduits(liSABC, 5, fantaPet);
				
				
				servicesLivraison.affecterProduits(liUCB, 25, kadji);
				servicesLivraison.affecterProduits(liUCB, 5, jusUCB);
				servicesLivraison.affecterProduits(liUCB, 2, petUCB);
				
				servicesLivraison.affecterProduits(liGUI, 10, pGui);
				servicesLivraison.affecterProduits(liGUI, 5, gGui);
				servicesLivraison.affecterProduits(liGUI, 5, smooth);
				
				
				
				System.out.println(servicesLivraison.terminerLivraison(liSABC, "111000050"));
				System.out.println(servicesLivraison.terminerLivraison(liUCB, "0000A25"));
				System.out.println(servicesLivraison.terminerLivraison(liGUI, "20005022"));
				
				/*
				 * 	MAGAZINIER(BOISSON)
				 */
					/*
				servicesLivraison.stockerLivraison(liSABC,p);
				servicesLivraison.stockerLivraison(liUCB,p);
				servicesLivraison.stockerLivraison(liGUI,p);

				*/
					/*
					 * SECRETAIRE
					 */
					
					//GestionLivraison  glSABC=servicesLivraison.avanceLivraison(liSABC,p,ceSABC,250,false,false);
					/*
					GestionLivraison  glUCB=servicesLivraison.avanceLivraison(liUCB,p,ceUCB,153400,true,false);
					GestionLivraison  glGUI=servicesLivraison.avanceLivraison(liGUI,p,ceGUI,220000,true,false);
					
					GestionLivraison  glUCB2=servicesLivraison.avanceLivraison(liUCB,p,ceUCB,30,false,false);
					GestionLivraison  glGUI2=servicesLivraison.avanceLivraison(liGUI,p,ceGUI,20,false,false);
					
					
					//GestionLivraison  glSABC=gestionLivraisonRepository.findById((long) 375).get();
					
					//System.out.println(glSABC);
					
					/*
					 * CAISSIER(E)
					 */
					//servicesVentes.decaisserAvanceLivraisonDeCaisse(glSABC,p);
					/*
					servicesVentes.decaisserAvanceLivraisonDeCaisse(glUCB,p);
					servicesVentes.decaisserAvanceLivraisonDeCaisse(glGUI,p);
					*/
					/*
					 * MAGAZINIER(EMB)
					 */
					//servicesLivraison.sortirEmballageLivraison(glSABC,p);
					/*
					servicesLivraison.sortirEmballageLivraison(glUCB2,p);
					servicesLivraison.sortirEmballageLivraison(glGUI2,p);
					*/
		
		//////////////////////////////LA ON VAS COMMENCER LES VENTES.////////////////////////////////////
					Client  confiance= clientRepository.findById((long) 240).get();
					Client  passant= clientRepository.findById((long) 241).get();
					
					
					//Produits Brasseries
					Produit export= produitRepository.findById((long) 37).get();
					Produit castels= produitRepository.findById((long) 36).get();
					Produit booster= produitRepository.findById((long) 38).get();
					Produit mutzig= produitRepository.findById((long) 53).get();
					Produit top= produitRepository.findById((long) 39).get();
					Produit soda= produitRepository.findById((long) 40).get();
					Produit magnan=produitRepository.findById((long) 43).get();
					Produit fantaPet= produitRepository.findById((long) 42).get();
					Produit tangui=produitRepository.findById((long) 41).get();
					//Produits Guinness
					Produit pGui= produitRepository.findById((long) 44).get();
					Produit gGui=produitRepository.findById((long) 45).get();
					Produit smooth= produitRepository.findById((long) 46).get();
					Produit origin=produitRepository.findById((long) 47).get();
					Produit maltaG= produitRepository.findById((long) 48).get();
					//Produits UCB
					Produit kadji=produitRepository.findById((long) 49).get();
					Produit jusUCB= produitRepository.findById((long) 50).get();
					Produit petUCB=produitRepository.findById((long) 52).get();
					
					/*
					servicesVentes.prixProduitClient(confiance,tangui,2100,300);
					servicesVentes.prixProduitClient(confiance,mutzig,6900,300);
					servicesVentes.prixProduitClient(confiance,smooth,7800,300);
					servicesVentes.prixProduitClient(confiance,kadji,6900,300);
					servicesVentes.prixProduitClient(confiance,jusUCB,4000,200);
					servicesVentes.prixProduitClient(confiance,petUCB,5400,200);
					servicesVentes.prixProduitClient(confiance,maltaG,9500,200);
					servicesVentes.prixProduitClient(confiance,origin,6900,300);
					*/
					
					//Facture fconf=servicesVentes.initialiserFactureClient(confiance, p);
					//System.out.println("\nfconf: "+fconf.toString());
					//Facture fconf=factureRepository.findById((long) 535).get();
					//Facture fconf2=factureRepository.findById((long) 506).get();
					//Facture fconf3=factureRepository.findById((long) 492).get();
					//Facture fconf4=factureRepository.findById((long) 486).get();
					
					
					//2- Ajout des produits dans la facture
					//Facture fconf12=servicesVentes.affecterProduitFacture(fconf, 10, top, 0, 0);
					//System.out.println("\nfconf12: "+fconf12.toString());
					/*
					System.out.println("\n 1- "+servicesVentes.affecterProduitFacture(fconf, 30, export, 0, 0));
					System.out.println("\n 2- "+servicesVentes.affecterProduitFacture(fconf, 10, castels, 0, 0));
					System.out.println("\n 3- "+servicesVentes.affecterProduitFacture(fconf, 10, booster, 0, 0));
					System.out.println("\n 4- "+servicesVentes.affecterProduitFacture(fconf, 10, top, 0, 0));
					System.out.println("\n 5- "+servicesVentes.affecterProduitFacture(fconf, 1, soda, 0, 0));
					System.out.println("\n 6- "+servicesVentes.affecterProduitFacture(fconf, 1, magnan, 0, 0));
					
					System.out.println("\n 7- "+servicesVentes.affecterProduitFacture(fconf, 10, mutzig, 0, 0));
					System.out.println("\n 8- "+servicesVentes.affecterProduitFacture(fconf, 3, tangui, 0, 0));
					System.out.println("\n 9- "+servicesVentes.affecterProduitFacture(fconf, 2, fantaPet, 0, 0));
					
					System.out.println("\n 10- "+servicesVentes.affecterProduitFacture(fconf, 2, pGui, 0, 0));
					System.out.println("\n 11- "+servicesVentes.affecterProduitFacture(fconf, 2, smooth, 0, 0));
					System.out.println("\n 12- "+servicesVentes.affecterProduitFacture(fconf, 1, gGui, 0, 0));
					*/
					//3- Livraison de la facture
					//Facture fconf13=factureRepository.findById((long) 562).get();
					//System.out.println("\nfconf12: "+fconf13.toString());
					
					
					//4- La facture a été livrée. Maintenant nous devons enregistrer le retour de la facture;
					// - Avance d'argent sur la facture.
					//GestionFacture gfArgent= servicesVentes.avanceFactureArgent(fconf,69000,p);
					//GestionFacture gfArgent2= servicesVentes.avanceFactureArgent(fconf2,100300,p);
					//GestionFacture gfArgent3= servicesVentes.avanceFactureArgent(fconf3,192500,p);
					//GestionFacture gfArgent= servicesVentes.avanceFactureArgent(fconf13,40000,p);
					//System.out.println("\ngfArgent: "+ gfArgent.toString());
					
					//GestionFacture gfArgent=gestionFactureRepository.findById((long) 540).get();
					//GestionFacture gfArgent2=gestionFactureRepository.findById((long) 544).get();
					//GestionFacture gfArgent3=gestionFactureRepository.findById((long) 546).get();
					//GestionFacture gfArgent4=gestionFactureRepository.findById((long) 548).get();
					//5- Avance d'Emballage
					//GestionFacture gfEmb=servicesVentes.avanceFactureEmballage(fconf, p, 10, 0, 0);
					//GestionFacture gfEmb2=servicesVentes.avanceFactureEmballage(fconf2, p, 15, 0, 0);
					//GestionFacture gfEmb3=servicesVentes.avanceFactureEmballage(fconf3, p, 30, 0, 0);
					//GestionFacture gfEmb=servicesVentes.avanceFactureEmballage(fconf13, p, 10, 0, 0);
					//System.out.println("\ngfEmb: "+ gfEmb.toString());
					
					//GestionFacture gfEmb=gestionFactureRepository.findById((long) 549).get();
					//GestionFacture gfEmb2=gestionFactureRepository.findById((long) 551).get();
					//GestionFacture gfEmb3=gestionFactureRepository.findById((long) 553).get();
					//GestionFacture gfEmb4=gestionFactureRepository.findById((long) 555).get();
					
					
					/*
					 *6- Encaissement de l'argent d'une facture
					 *Acteur: SECRETAIRE(E); 
					 */
					//
						//GestionFacture gfArgent= gestionFactureRepository.findById((long) 540).get();
					//	GestionFacture gfEmb= gestionFactureRepository.findById((long) 428).get();

						/*
						 * Encaisser l'argent d'une facture
						 * Acteur: CAISSIER(E)
						 */
					//System.out.println(servicesVentes.encaisserArgentFacture(gfArgent,p));//Encaisser Argent
					//System.out.println(servicesVentes.encaisserArgentFacture(gfArgent2,p));
					//System.out.println(servicesVentes.encaisserArgentFacture(gfArgent3,p));
					//System.out.println(servicesVentes.encaisserArgentFacture(gfArgent4,p));
					/*
					 * stocker les emballages d'une foncion
					 * Acteur: MGAZINIER(EMB)
					 */
					//servicesVentes.stockerEmbFacture(gfEmb, p);//stocker Emballages
					//servicesVentes.stockerEmbFacture(gfEmb2, p);
					//servicesVentes.stockerEmbFacture(gfEmb3, p);
					//servicesVentes.stockerEmbFacture(gfEmb4, p);
					
					//6- Une alternative du 5 et du 6 c'est l'enregistrement complet du retour d'une Facture
					//servicesVentes.enregistrerRetourLivraisonFacture(fConf, p, 15, 0, 0, 100000);
		
		////////////////////////////////////CHARGEMENT///////////////////////////////////////////
					//Chargement c=servicesVentes.initialiserChargement(p, p, res, "Tchitchap");
					Chargement c= chargementRepository.findById((long) 432).get();
					
					//System.out.println(servicesVentes.affecterProduitChargement(c, 30, export));
					//System.out.println(servicesVentes.affecterProduitChargement(c, 5, castels));
					//System.out.println(servicesVentes.affecterProduitChargement(c, 5, booster));
					
					//System.out.println(servicesVentes.livrerChargement(c,p).toString());
					
					System.out.println(LocalDate.now());
					System.out.println(servicesVentes.date);
					System.out.println(LocalDate.now());
					System.out.println(date);
					System.out.println(LocalDate.now());
					System.out.println(date);
					System.out.println(LocalDate.now());
					System.out.println(date);
					System.out.println(LocalDate.now());
					System.out.println(date);
					
					System.out.println(prixProduitsRepository.findByMyClientAndProduitAndIsValideTrue(passant, pGui).size());
					System.out.println(servicesVentes.prixProduitClient(confiance,origin,7700,300).getResponse().toString());
					System.out.println(servicesVentes.prixProduitClient(passant,pGui,13500,0).getResponse().toString());
					
					//RetourChargement rc=servicesVentes.initialiserRetourChargment(c,p,p);
					//RetourChargement rc= retourChargementRepository.findById((long) 433).get();
					
					
					//servicesVentes.affecterProduitsRetourChargement(c, 5, export, 5);
					//servicesVentes.affecterProduitsRetourChargement(c, 2, castels, 0);
					//servicesVentes.affecterProduitsRetourChargement(c, 1, booster, 0);
					
				//	servicesVentes.sockerProduitsRetourChargement(rc, p);
					
					//servicesVentes.avanceEmballageRetourChargement(c,p,31,0,0);
				//	GestionRetourChargement grc= gestionRetourChargementRepository.findById((long) 449).get();
					
					//servicesVentes.stockerEmballageRetourChargement(grc,p);
					
					//GestionRetourChargement grcArgent= servicesVentes.nouveauVersementRetourChargement(c, p, 230000);
					
				//	GestionRetourChargement grcArgent=gestionRetourChargementRepository.findById((long) 451).get();
					
				//	servicesVentes.encaisserArgentRetourChargement(grcArgent, p);
					
				//	servicesVentes.stockerEmballageRetourChargement(grc, p);
					
				//	servicesVentes.calculManquantRetourChargement(c);
					
					
					//////////////////////////////FACTURES CHARGEMENT/////////////////////////////////
					
					//FacturesChargement fc= servicesVentes. initialiserFactureChargement(c,  confiance);
					FacturesChargement fc= facturesChargementRepository.findById((long) 473).get();
					
					
					//servicesVentes.affecterProduitsFactureChargement(fc,export,10,0,0);
					//servicesVentes.affecterProduitsFactureChargement(fc,castels,2,0,0);
					//servicesVentes.affecterProduitsFactureChargement(fc,booster,3,0,0);
					
					
					//servicesVentes.terminerFactureChargement(fc);
					
					
					
					//GestionFC gfcA=servicesVentes.avanceArgentFactureChargement(fc, 34200);
					
					//GestionFC gfcE=servicesVentes.avanceEmballageFactureChargement(fc,5);
					
					
					
			 		////////////////////////////////COMMNDES////////////////////////////////////
					
					//Commande com= servicesVentes.initialiserCommande(confiance);
					//Commande com2=commandeRepository.findById((long) 480).get();
					//servicesVentes.affecterProduitsCommande(com, confiance, export, 10);
					//servicesVentes.affecterProduitsCommande(com, confiance, mutzig, 1);
					//servicesVentes.affecterProduitsCommande(com, confiance, booster, 3);
					//servicesVentes.affecterProduitsCommande(com, confiance, top, 1);
					
					//System.out.println(servicesVentes.livrerFacture(factureRepository.findById((long) 492).get(), p, p).toString());
					
					//System.out.println(servicesVentes.livrerFacture(servicesVentes.initialiserFactureFromCommande(com, p),p,p).toString());
					
					
					//////////////////////////////DEPENSES //////////////////////////////////////////////
					
					//Depenses d=servicesVentes.enregistrerDepense(3000, "Carburant", p, p);
					
					//System.out.println(servicesVentes.decaisserDepenseFromCaisse(d, p).toString());
					
					//Depenses d2=servicesVentes.enregistrerDepense(1000, "Ration", p, p);
					//Depenses d2 =depensesRepository.findById((long) 525).get();
					
					//System.out.println(servicesVentes.decaisserDepenseFromCaisseJournaliere(d2, p));
					
					
					////////////////////////////////
					
					
					
					
					
					/*		
		//les Produits
		Produit booster= produitRepository.findById((long) 38).get();
		Produit top= produitRepository.findById((long) 39).get();
		Produit soda= produitRepository.findById((long) 40).get();
		Produit magnan=produitRepository.findById((long) 43).get();
		Produit fantaPet= produitRepository.findById((long) 42).get();
		Produit export= produitRepository.findById((long) 37).get();
		Produit castels= produitRepository.findById((long) 36).get();
		
		//les clients
		Client  confiance= clientRepository.findById((long) 240).get();
		Client  passant= clientRepository.findById((long) 241).get();
		
		//Personnels
		Personnel p= personnelRepository.findById((long) 87).get();//Personnel
		
		
		//Création de Facture
		//1- Initialiser Facture
		//Facture fConf=servicesVentes.initialiserFactureClient(confiance,p);
		
		
		Facture fConf = factureRepository.findById((long)270).get();
		//System.out.println(fConf);
		
		//2- Ajout des produits dans la facture
		/*System.out.println(servicesVentes.affecterProduitFacture(fConf, 15, export, 0, 0));
		System.out.println(servicesVentes.affecterProduitFacture(fConf, 5, castels, 0, 0));
		System.out.println(servicesVentes.affecterProduitFacture(fConf, 10, booster, 0, 0));
		System.out.println(servicesVentes.affecterProduitFacture(fConf, 5, top, 0, 0));
		System.out.println(servicesVentes.affecterProduitFacture(fConf, 2, soda, 0, 0));
		System.out.println(servicesVentes.affecterProduitFacture(fConf, 3, magnan, 0, 0));
		*/
		//3- Livraison de la facture
		//System.out.println(servicesVentes.livrerFacture(fConf,p,p));	
		
		//4- Avance d'argent sur la facture.
		//System.out.println(servicesVentes.avanceFactureArgent(fConf,148600,p));
		
		//5- Avance d'Emballage
		//System.out.println(servicesVentes.avanceFactureEmballage(fConf, p, 25, 0, 0));
		
		//6- Une alternative du 5 et du 6 c'est l'enregistrement complet du retour d'une Facture
		//servicesVentes.enregistrerRetourLivraisonFacture(fConf, p, 15, 0, 0, 100000);
		
		//7-LEs requêtes
		//a- Les avances(Argent et Emballage) sur une facture.
	/*	servicesVentes.informationsFacture(fConf).forEach(gf->{
			System.out.println(gf.toString());
		});
		//b- les informations des factures d'un client.
		servicesVentes.informationsFacturesClient(confiance).forEach(f->{
			System.out.println(f.toString());
		});
		//c- Vérifier la conformité d'un client
		System.out.println(servicesVentes.conformeClient(confiance));
		
		//- d-Liste ArgentMvt en fonction d'une date
		LocalDate d1=LocalDate.of(2020,03,31);
		System.out.println(d1);
		System.out.println(d1.minusDays(1));
		System.out.println(d1.plusDays(1));
		System.out.println(date);
		System.out.println(LocalDate.now());
		System.out.println(LocalTime.now());
		System.out.println("////////////////////////////////////////////////////////");
		servicesVentes.listeEmballagesEntres(d1).forEach(am->{
			System.out.println(am.toString());
			
		});
		
		//e- Liste EmballageMvt en fonction d'une date
		System.out.println("////////////////////////////////////////////////////////");
		servicesVentes.listeEmballagesSortis(d1).forEach(emM->{
			System.out.println(emM.toString()); 
		});
		
		//f- Liste des clients non conformes.
		System.out.println("////////////////////////////////////////////////////////");
		servicesVentes.listeClientsNonConforme().forEach(f->{
			System.out.println(f.toString());
		});
		
		/*
		//Prix de Confiance
		servicesVentes.prixProduitClient(confiance,booster,6800,200);
		servicesVentes.prixProduitClient(confiance,top,4000,300);
		servicesVentes.prixProduitClient(confiance,soda,2900,300);
		servicesVentes.prixProduitClient(confiance,magnan,5600,200);
		servicesVentes.prixProduitClient(confiance,fantaPet,5400,200);
		servicesVentes.prixProduitClient(confiance,export,6900,300);
		servicesVentes.prixProduitClient(confiance,castels,6900,300);
		//Prix du client Passant
		servicesVentes.prixProduitClient(passant,booster,6600,0);
		servicesVentes.prixProduitClient(passant,top,4200,0);
		servicesVentes.prixProduitClient(passant,soda,2300,0);
		servicesVentes.prixProduitClient(passant,magnan,5200,0);
		servicesVentes.prixProduitClient(passant,fantaPet,5400,0);
		servicesVentes.prixProduitClient(passant,export,6600,0);
		servicesVentes.prixProduitClient(passant,castels,6600,0);
		
		

		
		
		
		/*
		Client c= new Client();
			c.setAdresseClient("");
			c.setDateCniClient(date3);
			c.setDateEnregistrement(date);
			c.setIsHaveRist(true);
			c.setNomClient("Confiance");
			c.setPrenomClient("");
			c.setSecteur("Molo Molo");
			c.setSexeClient(false);
			c.setTypeClient("Regulier");
			c.setDateNaissanceClient(date3);
			c.setNumeroCniClient("123465789");
			c.setTelClient("698959625");
			System.out.println(clientRepository.save(c));
			
		Client c2= new Client();
			c2.setAdresseClient("");
			c2.setDateCniClient(date3);
			c2.setDateEnregistrement(date);
			c2.setIsHaveRist(true);
			c2.setNomClient("Passant");
			c2.setPrenomClient("");
			c2.setSecteur(" ");
			c2.setSexeClient(false);
			c2.setTypeClient("Regulier");
			c2.setDateNaissanceClient(date3);
			c2.setNumeroCniClient("123465789");
			c2.setTelClient("698959625");
			System.out.println(clientRepository.save(c2));
		
		/*Livraison li= livraisonRepository.findById((long) 233).get();//Livraison
		Livraison li2= livraisonRepository.findById((long) 108).get();//Livraison
		Personnel p= personnelRepository.findById((long) 87).get();//Personnel
		CollaborateurExt ce= collaborateurExtRepository.findById((long) 1).get();//PersonnelExt
		Fournisseur four=fournisseurRepository.findById((long) 2).get();//Fournisseur
		
		
		LocalDate date3=LocalDate.of(2020, 03, 4);
		LocalDate date2=LocalDate.of(2020, 03, 19);
		
		
		//System.out.println(livraisonRepository.livraisonByDate(LocalDate.of(2020, 03, 18)).size());
		/*Collection<CollaborateurExt> colCollExt=collaborateurExtRepository.findByMyFournisseur(four);
		livraisonRepository.findByMyCollaborateurExtInAndDateLivraisonBetweenOrderByDateLivraisonAsc(colCollExt,date, date2).forEach(ol->{
			System.out.println("\n"+ol  );       
		});
		System.out.println("\n"+ date.minusDays(2) );
		/*servicesLivraison.listAndCumulRistourne(four,date, date2).forEach((chaine,montant)->{
			System.out.println("\n"+ chaine+"===="+montant );
		});*/
		//System.out.println(servicesLivraison.listAndCumulRistourne(four,date, date2).toString());
		//@DateTimeFormat(pattern = "yyyy-MM-dd")
		
		
		//System.out.println(servicesLivraison.initialiserLivraison(p, ce));//ok//167
	//	System.out.println(servicesLivraison.terminerLivraison(li, "00101"));
		
		//servicesLivraison.avanceLivraison(li, p, ce, 82000, true,false);
		//servicesLivraison.avanceLivraison(li, p, ce, 20, false,false);
		   
		//System.out.println("\n"+servicesLivraison.consulterResteArgent(li)+"\n");
		//System.out.println("\n"+servicesLivraison.consulterResteEmb(li)+"\n");
		
		//servicesLivraison.stockerLivraison(li);
		//servicesLivraison.stockerLivraison(li2);
		
		//Produit mutsig= produitRepository.findById((long) 53).get();
		
		//Produit castels= produitRepository.findById((long) 36).get();
		
		//*/
				//Produit export= produitRepository.findById((long) 37).get();
				
				//System.out.println(servicesLivraison.affecterProduits(li, 100, export));
		
		//Produit tangui= produitRepository.findById((long) 41).get();
		//System.out.println(servicesLivraison.affecterProduits(li, 10, tangui));
		/*	
		Produit booster= produitRepository.findById((long) 38).get();
		Produit top= produitRepository.findById((long) 39).get();
		Produit soda= produitRepository.findById((long) 40).get();
		Produit magnan=produitRepository.findById((long) 43).get();
		Produit fantaPet= produitRepository.findById((long) 42).get();
		
		
			
		//System.out.println(servicesLivraison.affecterProduits(li, 20, top));
		/*
		System.out.println(servicesLivraison.affecterProduits(li, 5, soda));
		System.out.println(servicesLivraison.affecterProduits(li, 15, magnan));
		System.out.println(servicesLivraison.affecterProduits(li, 5, fantaPet));
		System.out.println(servicesLivraison.affecterProduits(li, 5, tangui));
		*/
		//System.out.println(servicesLivraison.affecterProduits(li, 55, mutsig));
		
		
		/*Personnel p= personnelRepository.findById((long) 87).get();
		CollaborateurExt ce= collaborateurExtRepository.findById((long) 14).get();
		System.out.println(servicesLivraison.initialiserLivraison(p,ce));
		
		/*
		ProduitsLivraison pl= new ProduitsLivraison(3,produitRepository.findById((long) 38).get(),livraisonRepository.findById((long) 97).get());
		ProduitsLivraison pl2= new ProduitsLivraison(2,produitRepository.findById((long) 39).get(),livraisonRepository.findById((long) 97).get());
		System.out.print(produitLivraisonRepository.save(pl));
		System.out.print(produitLivraisonRepository.save(pl2));
		/*pl.setMyProduit(produitRepository.findById((long) 37).get());
		pl.setQuantite(5);
		pl.setMylivraison(livraisonRepository.findById((long) 97).get());
		pl.setPt();
		pl.setRistPL();*/
		

		
		
		//System.out.print("\n"+gestionLivraisonRepository.listOperationLivraison((long) 64).size()+"\n");  
		//listOperationLivraison((long) 64).size()
		/*GestionLivraison gl= new GestionLivraison();
		Livraison livConcerne= livraisonRepository.findById((long) 97).get();
		gl.setMyLivraison(livConcerne);
		gl.setAvanceGL(5);
		gl.setDateOperation(LocalDate.now());
		gl.setHeureOperation(LocalTime.now());
		gl.setMyPersonnelInt(personnelRepository.findById((long) 87).get());//Megane
		gl.setNatureOperation(false);
		gl.setPersonnelExt(collaborateurExtRepository.findById((long) 34).get());//Grand depot
		gl.setValideOP(true);
		//System.out .print(gestionLivraisonRepository.save(gl));
	/*Livraison li=new Livraison();
		li.setDateLivraison(LocalDate.now());
		li.setHeureLivraison(LocalTime.now());
		li.setJourLivraison("Samedi");
		li.setMyDetailsLivraison(detailsLivraisonRepository.findById((long) 88).get());//?
		li.setMyFournisseur(fournisseurRepository.findById((long) 2).get());
		li.setMyPersonnel(personnelRepository.findById((long) 53).get());
		li.setNbColis(25);
		li.setNbEmb(25);
		li.setSoldeLivraison(105000);
		li.setTotalRist(300*25);
		System.out.print(livraisonRepository.save(li));
		
		DateFormat df = new SimpleDateFormat("dd-mm-yyyy hh:mm");
		System.out.println(LocalDate.now().getDayOfWeek().toString());
		
		
		/*DetailsLivraison dl = new DetailsLivraison();
		dl.setAvanceEmb(55);
		dl.setResteEmb((float) 45);
		dl.setAvanceSolde(80000);
		dl.setResteSolde(25000);
		dl.setNumFactLivraision("52a5225541");
		System.out.print(detailsLivraisonRepository.save(dl));
	/*	Livraison li=new Livraison();
		li.setDateLivraison(LocalDate.now());
		li.setHeureLivraison(LocalTime.now());
		li.setJourLivraison("Samedi");
		li.setMyDetailsLivraison(detailsLivraisonRepository.getOne((long) 63));//?
		li.setMyFournisseur(fournisseurRepository.getOne((long) 2));
		li.setMyPersonnel(personnelRepository.getOne((long) 53));
		li.setNbColis(40);
		li.setNbEmb(25);
		li.setSoldeLivraison(126300);
		li.setTotalRist(300*25);//A calculer
		//livraisonRepository.save(li);
		
		/*DateFormat df = new SimpleDateFormat("dd-mm-yyyy hh:mm");
		System.out.println(LocalDate.now().isEqual(LocalDate.now()));
		System.out.println(LocalTime.now().toString().substring(0, 5));
		/*Personnel pers= new Personnel();
		pers.setAdressePers("Extreme Nord");
		pers.setCniPers("13151419");
		pers.setContactPers1("677825365");
		pers.setContactPers2("691247856");
		pers.setDateCniPers(LocalDate.of(2016, 05, 30));
		pers.setNomPers("MEGOUYEM");
		pers.setPostePers("Secretaire");
		pers.setPrenomPers("Megane");
		pers.setSexePers(false);
		pers.setStatus("EN SERVICE");
		pers.setDateNaissancePers(LocalDate.of(1999, 03, 26));
		//System.out.print(personnelRepository.save(pers));
		
		
	
		/*GestionLivraison gl= new GestionLivraison();
		gl.setAvanceGL(10);
		gl.setResteGL(25-10);
		gl.setDateOperation(" "+timestamp);
		gl.setNatureOperation(false);
		gl.setValideOP(true);
		gl.setMyLivraison(livraisonRepository.getOne((long) 64));
		gl.setPersonnelInt(personnelRepository.getOne((long) 59));
		gl.setPersonnelExt(collaborateurExtRepository.getOne((long) 1));
		gestionLivraisonRepository.save(gl);
		/*
		ProduitsLivraison pl=new ProduitsLivraison();
		pl.setMylivraison(livraisonRepository.getOne((long) 64));
		pl.setNomProduit("33 Export Beer");
		pl.setPu(5400);
		pl.setQuantite(10);
		pl.setPt(5400*10); 
		pl.setRistPL(300*10);
		produitLivraisonRepository.save(pl); */
		
		
		/*DetailsLivraison dl= new DetailsLivraison();
		dl.setAvanceSolde(50000);
		dl.setResteSolde(76300);
		dl.setAvanceEmb(10);
		dl.setResteEmb(15);
		dl.setDeconsigneEmb(0);
		System.out.println(detailsLivraisonRepository.save(dl));
		*/
		/*Livraison li=new Livraison();
		li.setDateLivraison("19-02-2020");
		li.setJourLivraison("Mercredi");
		li.setMyDetailsLivraison(detailsLivraisonRepository.getOne((long) 63));
		li.setMyFournisseur(fournisseurRepository.getOne((long) 2));
		li.setMyPersonnel(personnelRepository.getOne((long) 53));
		li.setNbColis(40);
		li.setNbEmb(25);
		li.setSoldeLivraison(126300);
		li.setTotalRist(300*25);//A calculer
		livraisonRepository.save(li);
		
		
		/*Personnel pers1=new Personnel();
		pers1.setNomPers("YOUMBA");
		pers1.setPrenomPers("Arlegil Browndon");
		pers1.setSexePers(true);
		pers1.setCniPers("1234567");
		pers1.setDateCniPers("13-07-2013");
		pers1.setDateNaissancePers("28-05-1995");
		pers1.setAdressePers("Yaoundé");
		pers1.setPostePers("Vice Directeur");
		pers1.setContactPers1("699986014");
		pers1.setContactPers2("671314631");
		pers1.setStatus("En Service");
		System.out.println(personnelRepository.save(pers1));
		/*Produit p1=new Produit();
		p1.setNom("Special Pet 1.5L");
		p1.setFormat(6);
		p1.setPuAchat(3700);
		p1.setPuVente(4000);
		p1.setDegreAlcool("0%");
		p1.setType("pet");
		p1.setVolume("1.5L");
		p1.setMyFournisseur(fournisseurRepository.findById((long) 3).get());
		System.out.println(p1);
		//System.out.println(repositoryProduit.save(p1));

		//c4.setMyFournisseur(fournisseurRepository.findById((long) 27).get());
		
		/*Fournisseur f1 = new Fournisseur();
		f1.setNom("SABC");
		f1.setJoursLivraison("Mercedi, samedi");
		f1.setContact("+23765285412");
		f1.setPeriodeRist("8 mois");
		
		Fournisseur f2 = new Fournisseur();
		f2.setNom("UCB");
		f2.setJoursLivraison("Mardi, Jeudi");
		f2.setContact("+237655013215");
		f2.setPeriodeRist("6 mois");
		//fournisseurRepository.save(f2);
		//System.out.println(fournisseurRepository.save(f2));
 
		Fournisseur f3 = fournisseurRepository.getOne((long) 3);
		
		CollaborateurExt c1= new CollaborateurExt() ;
		CollaborateurExt c2= new CollaborateurExt();
		CollaborateurExt c3= new CollaborateurExt();
		CollaborateurExt c4= new CollaborateurExt();
		CollaborateurExt c5= new CollaborateurExt();

		c1.setNomCE("Essengue");
		c1.setPrenomCE("Martine");
		c1.setContactCE1("+237659250797");
		c1.setContactCE1("+237671314631");
		c1.setPosteCE("ChefLivreur");
		c1.setMyFournisseur(f1);*/
		//System.out.println(c1);
		//if(f1.isPresent()) {
			//System.out.println(f1.get());
			//c1.setMyFournisseur(new Fournisseur("Grand depot","tous les jours","indéfini","inconnu"));
			//System.out.println(c1);
		//}
	//	
		
		/*
		c2.setNomCE("Kapssen");
		c2.setPrenomCE("Jean");
		c2.setContactCE1("+237650001456");
		c2.setPosteCE("LivreurCamion");
		c3.setMyFournisseur(fournisseurRepository.findById((long) 3).get());*/
		/*if(f1.isPresent()) {
			c2.setMyFournisseur(f1.get());
			System.out.println(c2);
		}*/
		//System.out.println(c2.toString());
		//System.out.println(fournisseurRepository.findById((long) 3).get());
		 /*
		
		c3.setNomCE("Etoga");
		c3.setPrenomCE("Jeanette");
		c3.setContactCE1("+237658965412");
		c3.setPosteCE("LivreurCamion");*/
		//c1.setMyFournisseur(f3);
	/*
		c4.setNomCE("Mussen");
		c4.setPrenomCE("Fabien");
		c4.setContactCE1("+237650321456");
		c4.setContactCE1("+237693910091");
		c4.setPosteCE("LivreurCamion");
		c4.setMyFournisseur(fournisseurRepository.findById((long) 2).get());
		
		c4.setNomCE("TALLA");
		c4.setPrenomCE("Dieudonne");
		c4.setContactCE1("+237650012536");
		c4.setContactCE2("+237677880014");
		c4.setPosteCE("LivreurCamion");
		Fournisseur f4 = new Fournisseur();
			f4.setNom("Grand depot S.A.");
			f4.setJoursLivraison("Mardi, Vendredi");
			f4.setContact("+237677944247");
			f4.setPeriodeRist("6 mois");
			
			c4.setMyFournisseur(fournisseurRepository.findById((long) 27).get());
			*/
		//c4.setMyFournisseur(f4);
		//System.out.println(c4.toString()); 
		 Date d= new Date();
		 Time t= new Time(d.getTime());
		 System.out.println("\n ======"+t);
		//System.out.println(gestionCaisseRepository.findById((long)589).get().getDate());

		List<CaisseJournaliere> lcj=caisseJournaliereRepository.findByMontantFinalNotAndIsTakedFalse(0);
		lcj.forEach(cj->{
			System.out.println("|||||||");
		});
		System.out.println(lcj.size());

		Personnel pBlaise= personnelRepository.findById((long) 53).get();
		Personnel pYoumba= personnelRepository.findById((long) 59).get();
		Personnel pLise= personnelRepository.findById((long) 87).get();

		Role rAdmin= roleRepository.findById((String) "ADMIN").get();
		Role rSec= roleRepository.findById((String) "SECRETAIRE").get();
		Role rCais= roleRepository.findById((String) "CAISSIER(E)").get();
		Role rProd= roleRepository.findById((String) "MAGAZINIER(E)_PROD").get();
		Role rEmb= roleRepository.findById((String) "MAGAZINIER(E)_EMB").get();

		List <Role> rBlaise= new ArrayList<>();
		List <Role> rYoums= new ArrayList<>();
		List <Role> rLise= new ArrayList<>();
		rBlaise.add(rAdmin);

		rYoums.add(rProd);
		rYoums.add(rEmb);

		rLise.add(rSec);
		rLise.add(rCais);



		usersRepository.save(new User("blaise","1234", true,pBlaise,rBlaise));
		usersRepository.save(new User("youmba","852", true,pYoumba,rYoums));
		usersRepository.save(new User("lise","1234", true,pLise,rLise));



	}

}
