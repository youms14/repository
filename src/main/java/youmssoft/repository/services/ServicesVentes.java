package youmssoft.repository.services;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import net.bytebuddy.build.Plugin.Engine.ErrorHandler.Failing;
import youmssoft.repository.dao.livraison.FournisseurRepository;
import youmssoft.repository.dao.livraison.GestionLivraisonRepository;
import youmssoft.repository.dao.livraison.PersonnelRepository;
import youmssoft.repository.dao.livraison.ProduitRepository;
import youmssoft.repository.dao.ventes.AchatEmballageRepository;
import youmssoft.repository.dao.ventes.ArgentMvtRepository;
import youmssoft.repository.dao.ventes.CaisseJournaliereRepository;
import youmssoft.repository.dao.ventes.CaisseRepository;
import youmssoft.repository.dao.ventes.CassRepository;
import youmssoft.repository.dao.ventes.ChargementPatrimoineRepository;
import youmssoft.repository.dao.ventes.ChargementRepository;
import youmssoft.repository.dao.ventes.ClientRepository;
import youmssoft.repository.dao.ventes.CommandeFactureRepository;
import youmssoft.repository.dao.ventes.CommandeRepository;
import youmssoft.repository.dao.ventes.CumulRistClientsRepository;
import youmssoft.repository.dao.ventes.DepensesRepository;
import youmssoft.repository.dao.ventes.DetailsFCRepository;
import youmssoft.repository.dao.ventes.DetailsFactureRepository;
import youmssoft.repository.dao.ventes.EmballagesMvtRepository;
import youmssoft.repository.dao.ventes.FacturePatrimoineRepository;
import youmssoft.repository.dao.ventes.FactureRepository;
import youmssoft.repository.dao.ventes.FacturesChargementRepository;
import youmssoft.repository.dao.ventes.GestionCaisseRepository;
import youmssoft.repository.dao.ventes.GestionFCRepository;
import youmssoft.repository.dao.ventes.GestionFactureRepository;
import youmssoft.repository.dao.ventes.GestionRetourChargementRepository;
import youmssoft.repository.dao.ventes.InterfaceCaisseRepository;
import youmssoft.repository.dao.ventes.MagEmballageRepository;
import youmssoft.repository.dao.ventes.ManquantsRCRepository;
import youmssoft.repository.dao.ventes.PatrimoineFactureRepository;
import youmssoft.repository.dao.ventes.PatrimoineRepository;
import youmssoft.repository.dao.ventes.PrixProduitsRepository;
import youmssoft.repository.dao.ventes.ProduitMvtRepository;
import youmssoft.repository.dao.ventes.ProduitsChargementRepository;
import youmssoft.repository.dao.ventes.ProduitsCommandeRepository;
import youmssoft.repository.dao.ventes.ProduitsFCRepository;
import youmssoft.repository.dao.ventes.ProduitsFactureRepository;
import youmssoft.repository.dao.ventes.ProduitsRCRepository;
import youmssoft.repository.dao.ventes.RetourChargementRepository;
import youmssoft.repository.dao.ventes.RetourProduitsRepository;
import youmssoft.repository.dao.ventes.TotalRistournePayementRepository;
import youmssoft.repository.dto.ArgentMvtDto;
import youmssoft.repository.dto.CaisseJournaliereDto;
import youmssoft.repository.dto.CassDto;
import youmssoft.repository.dto.DepenseSDto;
import youmssoft.repository.dto.EmballageMvtDto;
import youmssoft.repository.dto.FactureDto;
import youmssoft.repository.dto.GestionFactureOutDto;
import youmssoft.repository.dto.MagDto;
import youmssoft.repository.dto.ReponseDto;
import youmssoft.repository.dto.ReponseDto.Code;
import youmssoft.repository.dto.UsedCaisseJounaliere;
import youmssoft.repository.entities.livraison.Fournisseur;
import youmssoft.repository.entities.livraison.GestionLivraison;
import youmssoft.repository.entities.livraison.Personnel;
import youmssoft.repository.entities.livraison.Produit;
import youmssoft.repository.entities.ventes.AchatEmballage;
import youmssoft.repository.entities.ventes.ArgentMvt;
import youmssoft.repository.entities.ventes.Caisse;
import youmssoft.repository.entities.ventes.CaisseJournaliere;
import youmssoft.repository.entities.ventes.Cass;
import youmssoft.repository.entities.ventes.Chargement;
import youmssoft.repository.entities.ventes.ChargementPatrimoine;
import youmssoft.repository.entities.ventes.Client;
import youmssoft.repository.entities.ventes.Commande;
import youmssoft.repository.entities.ventes.CumulRistClients;
import youmssoft.repository.entities.ventes.Depenses;
import youmssoft.repository.entities.ventes.DetailsFC;
import youmssoft.repository.entities.ventes.DetailsFacture;
import youmssoft.repository.entities.ventes.EmballagesMvt;
import youmssoft.repository.entities.ventes.Facture;
import youmssoft.repository.entities.ventes.FacturesChargement;
import youmssoft.repository.entities.ventes.GestionCaisse;
import youmssoft.repository.entities.ventes.GestionFC;
import youmssoft.repository.entities.ventes.GestionFacture;
import youmssoft.repository.entities.ventes.GestionRetourChargement;
import youmssoft.repository.entities.ventes.InterfaceCaisse;
import youmssoft.repository.entities.ventes.MagEmballage;
import youmssoft.repository.entities.ventes.Patrimoine;
import youmssoft.repository.entities.ventes.PatrimoineFacture;
import youmssoft.repository.entities.ventes.PrixProduits;
import youmssoft.repository.entities.ventes.ProduitMvt;
import youmssoft.repository.entities.ventes.ProduitsChargement;
import youmssoft.repository.entities.ventes.ProduitsCommande;
import youmssoft.repository.entities.ventes.ProduitsFC;
import youmssoft.repository.entities.ventes.ProduitsFacture;
import youmssoft.repository.entities.ventes.ProduitsRC;
import youmssoft.repository.entities.ventes.RetourChargement;
import youmssoft.repository.entities.ventes.RetourProduits;

@Service
public class ServicesVentes {
	
	//private static final String TYPE_CASIER = "casier";

	private static final String TYPE_CASIER = "casier";

	private static final Boolean SORTIE_PROD = false;

	private static final String LIBELLE_SORTIE_FACT = "Sortie de facture ";

	private static final Boolean ENTREE_ARGENT = true;
	
	private static final Boolean ENTREE_EMB = true;

	private static final String LIBELLE_ARGENT_FACTURE = "Avance de Facture";

	private static final String LIBELLE_EMB_FACTURE = "Avance de Facture";

	private static final long ID_SABC = 2;

	private static final long ID_UCB = 3;

	private static final long ID_GUINNESS = 26;

	private static final long ID_CAISSE = 307;

	private static final boolean SORTIE_ARGENT = false;

	private static final String LIBELLE_DECAISSEMENT = "DECAISSEMENT";

	private static final String LIBELLE_ARGENT_DEPENSE = "DEPENSE";

	private static final String LIBELLE_PRODUIT_CHARGEMENT = "Sortie de Chargement";

	private static final float CONST_BOUT_CASIER = (float) 0.083333333;
	
	private static final Boolean ENTREE_PRODUIT = true;

	private static final String LIBELLE_RETOUR_PRODUIT = "Retour Chargement Produit";

	private static final String LIBELLE_EMB_RETOUR_CHARGEMENT = "Retour Chargement Emballages";;

	private static final boolean IS_ARGENT = true;

	private static final boolean IS_EMB = false;

	private static final boolean NON_LIVREE = false;

	private static final boolean LIVREE = true;

	private static final Long ID_MAG_SABC = null;

	private static final String LIBELLE_ARGENT_ACHATBOUTEILLE = "Achat de Bouteilles";

	private static final String LIBELLE_EMB_ACHATBOUTEILLE = "Stock Achat Emballage";

	private static final String LIBELLE_AVANCE_LIVRAISON = " Livraison";

	private static final String LIBELLE_ARGENT_CHARGEMENT = "Argent Pour Chargement";

	private static final float PRIX_BOUT_VIDE = 150;

	private static final String LIBELLE_CASS = "Remplacement de CASS";

	private static final String LIBELLE_ACQUITEMENT = "Acquitement de CASS";

	public LocalDate date= LocalDate.now();
	
	public LocalTime heure=LocalTime.now();
	
	float sommeCJ=0;
	
	float montant2=0;
	
	float sommeAM=0;
	
	float sommeAMS=0;
	
	float totalPC=0;
	
	float quantiteProduitStockVirtuelle;

	float quantiteProduitStockReelle;
	
	@Autowired
	ClientRepository clientRepository;
	
	@Autowired
	FactureRepository factureRepository;
	
	@Autowired
	DetailsFactureRepository  detailsFactureRepository;
	
	@Autowired
	GestionFactureRepository gestionFactureRepository;
	
	@Autowired
	ProduitsFactureRepository produitsFactureRepository;
	
	@Autowired
	CommandeFactureRepository commandeFactureRepository;
	
	@Autowired
	PersonnelRepository  personnelRepository;
	
	@Autowired
	ProduitRepository produitRepository;
	
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
	FournisseurRepository fournisseurRepository;
	
	@Autowired
	CassRepository  cassRepository;
	
	@Autowired
	CaisseRepository caisseRepository;
	
	@Autowired
	MagEmballageRepository magEmballageRepository;
	
	@Autowired
	CumulRistClientsRepository cumulRistClientsRepository;
	
	@Autowired
	TotalRistournePayementRepository totalRistournePayementRepository;
	
	@Autowired
	ChargementPatrimoineRepository chargementPatrimoineRepository;
	
	@Autowired
	CommandeRepository commandeRepository;
	
	@Autowired
	DepensesRepository depensesRepository;
	
	@Autowired
	DetailsFCRepository detailsFCRepository;
	
	@Autowired
	FacturePatrimoineRepository facturePatrimoineRepository;
	
	@Autowired
	GestionFCRepository gestionFCRepository;
	
	@Autowired
	GestionRetourChargementRepository gestionRetourChargementRepository;
	
	@Autowired
	ManquantsRCRepository manquantsRCRepository;
	
	@Autowired
	PatrimoineRepository patrimoineRepository;
	
	@Autowired
	ProduitsCommandeRepository produitsCommandeRepository;
	
	@Autowired
	ProduitsFCRepository produitsFCRepository;
	
	@Autowired
	ProduitsRCRepository produitsRCRepository;
	
	@Autowired
	RetourChargementRepository retourChargementRepository;
	
	@Autowired
	PatrimoineFactureRepository patrimoineFactureRepository;

	@Autowired
	GestionCaisseRepository gestionCaisseRepository;
	
	@Autowired
	CaisseJournaliereRepository caisseJournaliereRepository;
	
	@Autowired
	InterfaceCaisseRepository interfaceCaisseRepository;
	
	@Autowired
	ProduitsChargementRepository produitsChargementRepository;
	
	@Autowired
	GestionLivraisonRepository gestionLivraisonRepository;
	
	@Autowired
	AchatEmballageRepository achatEmballageRepository;
	
	@Autowired
	RetourProduitsRepository retourProduitsRepository;

	private float qteNormale=0;

	
	
	
	///////////////////////////////////////FACTURES/////////////////////////////////////////////////////////
	/*
	 * Définir le prix d'un produit pour un client particulier
	 */
	public ReponseDto prixProduitClient(Client c, Produit p,float prixProd, float ristProd) {
		ReponseDto r = new ReponseDto();
		if(c==null) {
			r.format(Code.FAILURE, "Veillez entrer un client valide");
			return r;
		}
		
		if(p==null) {
			r.format(Code.FAILURE, "Veillez entrer un personnel valide");
			return r;
		}
		
		if(!c.isValide()) {
			r.format(Code.FAILURE, "Veillez entrer un client valide");
			return r;
		}
		
		if(p.isValide()) {
			r.format(Code.FAILURE, "Veillez entrer un personnel valide");
			return r;
		}
		
		if(prixProd<=0) {
			r.format(Code.FAILURE, "Veillez entrer un prix de produit valide");
			return r;
		}
		
		if(ristProd<0) {
			r.format(Code.FAILURE, "Veillez entrer une ristourne de produit valide");
			return r;
		}
		
		
		if(prixProduitsRepository.findByMyClientAndProduitAndIsValideTrue(c, p).size()==0)	{
			PrixProduits pp= new PrixProduits();
			pp.setMyClient(c);
			pp.setProduit(p);
			pp.setPrixClient(prixProd);
			pp.setRistProd(ristProd);
			pp.setValide(true);
			r.format(Code.SUCCESS, prixProduitsRepository.save(pp));
		return r;
		}else {
			r.format(Code.FAILURE, "Le prix de ce Produit est deja défini pour ce client");
			return r;
		} 
		
	}
	
	/*
	 * Modifier le prix d'un client: modification
	 * précondition: le prix de ce Client existe bien pour le Produit.
	 */
	public ReponseDto modifierPrixProduitClient(Produit p, Client c, float np, float nr) {
		ReponseDto r = new ReponseDto();
		if(c==null) {
			r.format(Code.FAILURE, "Veillez entrer un client valide");
			return r;
		}
		
		if(p==null) {
			r.format(Code.FAILURE, "Veillez entrer un personnel valide");
			return r;
		}
		
		if(!c.isValide()) {
			r.format(Code.FAILURE, "Veillez entrer un client valide");
			return r;
		}
		
		if(p.isValide()) {
			r.format(Code.FAILURE, "Veillez entrer un personnel valide");
			return r;
		}
		
		if(np<=0) {
			r.format(Code.FAILURE, "Veillez entrer un prix de produit valide");
			return r;
		}
		
		if(nr<0) {
			r.format(Code.FAILURE, "Veillez entrer une ristourne de produit valide");
			return r;
		}
		
		PrixProduits pp=prixProduitsRepository.findByMyClientAndProduitAndIsValideTrue(c, p).get(0);
			pp.setPrixClient(np);
			pp.setRistProd(nr);
			pp.setValide(true);
			r.format(Code.SUCCESS, prixProduitsRepository.save(pp));
		return	r;
	}

	/*
	 * Initialiser une Facture
	 */
	public long initialiserFactureClient(Client client, Personnel secretaire ) {
		Facture f= new Facture();
		DetailsFacture df=detailsFactureRepository.save(new DetailsFacture());
		f.setSecrectaireFact(secretaire);
		f.setClientFact(client);
		f.setMyDetailsFacture(df);
			Facture f2=factureRepository.save(f);
		df.setMyFacture(f2);
		df.setValide(true);
		detailsFactureRepository.save(df);
		return f2.getIdFacture();
	}
	
	/*
	 * 1- Fonction permettant de de connaître le stock d'un produit avant sa facturation.
	 * NB: Inclure à la fois le stock du magazin et les quantités virtuelles des produits issu de des
	 *     Factures Non-Livrées. ie. QteReel=QteEnStock-(Les QtesVirtuelles). Apres on teste si quantite<=QteReel
	 * Fonction pour avoir le stock d'un produit quelconque au magasin.
	 * Acteur: SECRETAIRE
	 */
	public float stockProduitVirtuel(Produit p) {
		List<Facture> lf=factureRepository.findByIsLivredFalseAndIsValideTrue();
		
		lf.forEach(f->{
			List<ProduitsFacture> lpf= produitsFactureRepository.findByMyFactureAndIsValideTrue(f);
			lpf.forEach(pf->{
				if(pf.getProduitPF()==p) {
					quantiteProduitStockVirtuelle=quantiteProduitStockVirtuelle+pf.getQuantitePF();//?
				}
			});
		});
		
		return quantiteProduitStockVirtuelle;
	}
	
	/*quantiteProduitStockVirtuelle
	 * Quantité reelle: La quantité de produits Non reservés.
	 */
	public float stockProduitReel(Produit p) {
		quantiteProduitStockReelle=produitRepository.findByIdProduitAndIsValideTrue(p.getIdProduit()).getQuantite()-stockProduitVirtuel(p);
		return quantiteProduitStockReelle;
	}
	/*
	 * Affecter un produit à une facture:
	 * 1- Ajouter une nouvelle ligne dans produitsFacture
	 * 2- Mettre à jour le totalSolde, totalRist, nbEmb et nbColis dans facture
	 * 3- Mettre à jour la ligne de Detailsfacture associée à la facture(les restesApayer) dans la table details_facture
	 */
	@Transactional
	public ReponseDto affecterProduitFacture(Facture facture,float quantite, Produit produit, float prix, float rist) {
		ReponseDto r= new ReponseDto();
		if(facture==null) {
			r.format(Code.FAILURE, "Cette facture est invalide/inexistante");
			return r;
		}
		
		if(produit==null) {
			r.format(Code.FAILURE, "Ce produit est invalide/inxistant");
			return r;
		}
		
		if(facture.isEmbOkFacture() || facture.isSoldedFacture()) {
			r.format(Code.FAILURE, "Cette facture est déjà soldée en argent/Emballage");
			return r;
		}
		
		if(facture.isLivred()) {
			r.format(Code.FAILURE, "Cette facture est déjà livrée. Vous pouvez en créer une "
					+ "nouvelle pour ce produit.");
			return r;
		}
		
		if (!facture.isValide()) {
			r.format(Code.FAILURE, "Cette facture est invalide");
			return r;
		}
		
		if (quantite>this.stockProduitReel(produit) && quantite>produitRepository.findByIdProduitAndIsValideTrue(produit.getIdProduit()).getQuantite()) {
			r.format(Code.FAILURE, "Affectation de Produit impossible:les Factures deja enregistrées sont pris en consideration.");
			return r;
		} 
		
		if(quantite>this.stockProduitReel(produit) && quantite<=produitRepository.findByIdProduitAndIsValideTrue(produit.getIdProduit()).getQuantite()) {
			r.format(Code.FAILURE, "Affectation de Produit impossible:les Factures deja enregistrées sont pris en consideration."
					+ " Toute fois, si cette facture est prioritaire, vous pouvez annuler/ \"\n" + 
					"						+ \"diminuer ce produit sur une facure déjà effectuée");
		return r;
		}
		//1- Création du nouvel objet ProduitsFacture
		ProduitsFacture pf= new ProduitsFacture(produit, quantite, facture);
		//Recherche du prix associé à ce client
			//Client c= clientRepository.findById(facture.getClientFact().getIdClient()).get();
			Client c=facture.getClientFact();
		PrixProduits pp = prixProduitsRepository.findByMyClientAndProduitAndIsValideTrue(c, produit).get(0);
		Facture f=factureRepository.findByIdFactureAndIsValideTrue(facture.getIdFacture());
			if(prix==0) {
				pf.setPrixTotalPF(pp.getPrixClient()*quantite);
				pf.setRistPF(pp.getRistProd()*quantite);
			}else {
				pf.setPrixTotalPF(prix*quantite);
				pf.setRistPF(rist*quantite);
			}
		pf.setQuantitePF(quantite);
		pf.setProduitPF(produit);
		pf.setMyFacture(f);
		pf.setValide(true);
		ProduitsFacture pf2= produitsFactureRepository.save(pf);
		
		//2- Mise à jour dans facture
		f.setNbColisFact(f.getNbColisFact()+quantite);
		f.setSoldeFact(f.getSoldeFact()+pf.getPrixTotalPF());
		f.setTotalRistFact(f.getTotalRistFact()+pf.getRistPF());
		f.setValide(true);
		if(produit.getType().equals(TYPE_CASIER)) {
			f.setNbEmbFact(f.getNbEmbFact()+quantite);
		}
		Facture f2=factureRepository.save(f);
		
		//3- Mise à jour dans detailsFacture
		DetailsFacture df= detailsFactureRepository.findByIdDetailsFactureAndIsValideTrue(f.getMyDetailsFacture().getIdDetailsFacture());
		df.setTotalResteSolde(df.getTotalResteSolde()+pf.getPrixTotalPF());
		if(produit.getType().equals(TYPE_CASIER)) {
			df.setTotalResteEmb(df.getTotalResteEmb()+quantite);
		}
		df.setTotalAvanceSolde(0);
		df.setTotalAvanceEmb(0);
		df.setMyFacture(f);
		df.setValide(true);
		detailsFactureRepository.save(df);
		
		r.format(Code.SUCCESS, new FactureDto(f2.getClientFact(), f2.getSoldeFact(), f2.getNbColisFact(), f2.getDateFact(), f2.getMyDetailsFacture()));
		return r;
	}
	
	/*
	 * Retirer un produit de la liste de produits d'une facture.
	 */
	@Transactional
	public ReponseDto retirerProduitFacture(Facture f, Produit p) {
		ReponseDto r=new ReponseDto();
		if(f==null) {
			r.format(Code.FAILURE, "Cette facture n'existe pas");
			return r;
		}
		
		if(p==null) {
			r.format(Code.FAILURE, "Produit n'existe pas");
			return r;
		}
		
		ProduitsFacture pf= produitsFactureRepository.findByMyFactureAndProduitPFAndIsValideTrue(f,p);
		
		if(!f.isValide()) {
			r.format(Code.FAILURE, "Cette facture est invalide");
			return r;
		}
		
		if(pf==null) {
			r.format(Code.FAILURE, "Ce Produit ne fait pas partie de cette facture");
			return r;
		}
		
		if(!pf.isValide()) {
			r.format(Code.FAILURE, "Cette ligne de la facture est déjà annulée");
			return r;
		}
		
		//si la fature a été livrée, on remet au magazin
		if(f.isLivred()) {
			//Invalidation du ProduitMvt en question
			ProduitMvt em=produitMvtRepository.findByMyFactureAndProduitAndIsValideTrue(f,p);
			em.setValide(false);
			produitMvtRepository.save(em);
			//Dimunition de quantité en stock
			p.setQuantite(p.getQuantite()+pf.getQuantitePF());
			produitRepository.save(p);
			//Modification de la ristourne clien
			CumulRistClients crc= cumulRistClientsRepository.findByFactureAndIsValideTrue(f);
				crc.setMontant(crc.getMontant()-pf.getRistPF());;
			cumulRistClientsRepository.save(crc);
		}
		
		pf.setValide(false);
		produitsFactureRepository.save(pf);
		
		PrixProduits pp=prixProduitsRepository.findByMyClientAndProduitAndIsValideTrue(f.getClientFact(), p).get(0);
		
		//Modification dans DetailsFacture
		DetailsFacture df=f.getMyDetailsFacture();
			df.setTotalResteSolde(df.getTotalResteSolde()-pp.getPrixClient()*pf.getQuantitePF());
		if(p.getType().equals(TYPE_CASIER)) {
			df.setTotalResteEmb(df.getTotalResteEmb()-pf.getQuantitePF());
		}
		detailsFactureRepository.save(df);
		
		
		//Modification dans la facture
		f.setNbColisFact(f.getNbColisFact()-pf.getQuantitePF());
		if(p.getType().equals(TYPE_CASIER)) {
			f.setNbEmbFact(f.getNbEmbFact()-pf.getQuantitePF());
		}	
		f.setSoldeFact(f.getSoldeFact()-pp.getPrixClient()*pf.getQuantitePF());
		f.setTotalRistFact(f.getTotalRistFact()-pp.getRistProd()*pf.getQuantitePF());
		
		Facture f2= factureRepository.save(f);
		r.format(Code.SUCCESS, new FactureDto(f2.getClientFact(), f2.getSoldeFact(), f2.getNbColisFact(),f2.getDateFact(), f2.getMyDetailsFacture()));
		
		return r;
	}
	/*
	public ReponseDto annulerRetourProduitFacture(Facture f, Produit p, float qte) {
		ReponseDto r=new ReponseDto();
		if(f==null) {
			r.format(Code.FAILURE, "Cette facture n'existe pas");
			return r;
		}
		
		if(p==null) {
			r.format(Code.FAILURE, "Produit n'existe pas");
			return r;
		}
		
		if(qte<=0) {
			r.format(Code.FAILURE, "Entrez un montant valide");
			return r;
		}
		
	
	}*/
	public ReponseDto retourProduitFacture(Facture f, Produit p, float qte, Personnel magazinier) {
		ReponseDto r=new ReponseDto();
		
		if(magazinier==null) {
			r.format(Code.FAILURE, "Ce Personnel n'existe pas");
			return r;
		}
		
		if(!magazinier.isValide()){
			r.format(Code.FAILURE, "Ce Personnel est invalide");
			return r;
		}
		
		if(f==null) {
			r.format(Code.FAILURE, "Cette facture n'existe pas");
			return r;
		}
		
		if(p==null) {
			r.format(Code.FAILURE, "Produit n'existe pas");
			return r;
		}
		
		if(qte<=0) {
			r.format(Code.FAILURE, "Entrez un montant valide");
			return r;
		}
		
		if(!f.isLivred()) {
			r.format(Code.FAILURE, "Cette facture n'est pas livrée, donc une modification de Facture est suffisante");
			return r;
		}

		ProduitsFacture pf= produitsFactureRepository.findByMyFactureAndProduitPFAndIsValideTrue(f,p);
		if(pf==null) {
			r.format(Code.FAILURE, "Ce Produit ne fait pas partie de cette facture");
			return r;
		}
		if(qte>pf.getQuantitePF()) {
			r.format(Code.FAILURE, "Retour de Produit Impossible. Cette quantité est anormale");
			return r;
		}
		//Modification dans Facture
		ReponseDto r2=this.modifierQuantiteProduitFacture(f, p, pf.getQuantitePF()-qte);
		
		//creation/Modification du produitMvt associé
		ProduitMvt em=produitMvtRepository.findByMyFactureAndProduitAndIsValideTrue(f,p);
		em.setQuantite(pf.getQuantitePF()-qte);
		produitMvtRepository.save(em);
			
		
		//Augmentation de la quantité en stock
		p.setQuantite(p.getQuantite()+qte);
		produitRepository.save(p);
			
		//Modification de la ristourne client
		CumulRistClients crc= cumulRistClientsRepository.findByFactureAndIsValideTrue(f);
		crc.setMontant(crc.getMontant()-qte*pf.getRistPF()/pf.getQuantitePF());
		cumulRistClientsRepository.save(crc);
		
		//Persistence dans RetourProduits
		RetourProduits rp= new RetourProduits();
			rp.setDateRetour(date);
			rp.setMyProduitFacture(pf);
			rp.setMagaziner(magazinier);
		retourProduitsRepository.save(rp);
		r2.getResponse().put("idRetourProduits", rp.getIdRP());
		
		r.format(Code.SUCCESS, r2.getResponse());
		
		return r;
	}
	
	@Transactional
	public ReponseDto modifierQuantiteProduitFacture(Facture f, Produit p, float qte) {
		ReponseDto r=new ReponseDto();
		if(f==null) {
			r.format(Code.FAILURE, "Cette facture n'existe pas");
			return r;
		}
		
		if(p==null) {
			r.format(Code.FAILURE, "Ce produit n'existe pas");
			return r;
		}
		
		if(qte<=0) {
			r.format(Code.FAILURE, "Entrez une quantité supérieure à 0");
			return r;
		}
		
		if(!f.isValide()) {
			r.format(Code.FAILURE, "Cette facture est invalide");
			return r;
		}
		ProduitsFacture pf= produitsFactureRepository.findByMyFactureAndProduitPFAndIsValideTrue(f,p);
		
		if(pf==null) {
			r.format(Code.FAILURE, "Ce Produit ne fait pas partie de cette facture");
			return r;
		}
		
		if(!pf.isValide()) {
			r.format(Code.FAILURE, "Cette ligne de la facture est invalide. Donc ne peut être modifiée");
			return r;
		}
		//Modification dans ProduitsFacture
		float oldQte=pf.getQuantitePF();
		float oldPt=pf.getPrixTotalPF();
		float oldRist=pf.getRistPF();
		pf.setQuantitePF(qte);
		pf.setPrixTotalPF(qte*oldPt/oldQte);
		pf.setRistPF(qte*oldRist/oldQte);
		pf.setValide(true);
		produitsFactureRepository.save(pf);
		
		//Modification dans detailsFacture
		DetailsFacture df=f.getMyDetailsFacture();
		df.setTotalResteSolde(df.getTotalResteSolde()-oldPt+qte*oldPt/oldQte);
		if(p.getType().equals(TYPE_CASIER)) {
			df.setTotalResteEmb(df.getTotalResteEmb()-oldQte+qte);
		}
		detailsFactureRepository.save(df);
		
		//Modification dans facture
		f.setNbColisFact(f.getNbColisFact()-oldQte+qte);
		f.setSoldeFact(f.getSoldeFact()-oldPt+qte*oldPt/oldQte);
		f.setTotalRistFact(f.getTotalRistFact()-oldRist+qte*oldRist/oldQte);
		if(p.getType().equals(TYPE_CASIER)) {
			f.setNbEmbFact(f.getNbEmbFact()-oldQte+qte);
		}
		Facture f2=factureRepository.save(f);
		FactureDto fdto = new FactureDto(f2.getClientFact(), f2.getSoldeFact(), f2.getNbColisFact(), f2.getDateFact(), f2.getMyDetailsFacture());
		
		r.format(Code.SUCCESS, fdto);
				
		return r;
		
	}
	
	public ReponseDto annulerFacture(Facture f) {
		ReponseDto r=new ReponseDto();
		
		if(f==null) {
			r.format(Code.FAILURE, "Cette facture est invalide/inexistante");
			return r;
		}
		
		if(!f.isValide()) {
			r.format(Code.FAILURE, "Facture déjà annulée");
			return r;
		}
		
		List<GestionFacture> lgf= gestionFactureRepository.findByMyFactureAndIsValideTrue(f);
		if(f.isSoldedFacture() || f.isEmbOkFacture()) {
			r.format(Code.SUCCESS, "Cette facture est soldée. Impossible de l'annuler");
			return r;
		}
		
		if(lgf.size()>0) {
			r.format(Code.SUCCESS, "Cette facture possède des opérations(Argent/Emballages). Impossible de l'annuler");
			return r;
		}
		
		//Annulation du DetailsFacture
		DetailsFacture df= f.getMyDetailsFacture();
		df.setValide(false);
		
		//Annulation des ProduitsFacures
		List<ProduitsFacture> lpf=produitsFactureRepository.findByMyFactureAndIsValideTrue(f);
		if(lpf.size()>0) {
			lpf.forEach(pf->{
				pf.setValide(false);
			});
		}
		
		//Si la facture a été livrée
		if(f.isLivred()) {
			f.setLivred(false);
			List<ProduitMvt> lpm=produitMvtRepository.findByMyFactureAndIsValideTrue(f);
			if(lpm.size()>0) {
				lpm.forEach(pm->{
					pm.setValide(false);
					
					//Modification de la quantité en stock
					Produit p=pm.getProduit();
					p.setQuantite(p.getQuantite()+pm.getQuantite());
					produitRepository.save(p);
					
					produitMvtRepository.save(pm);
				});
			}
			
			//Annulation de la ristourne du client
			CumulRistClients crc= cumulRistClientsRepository.findByFactureAndIsValideTrue(f);
			crc.setValide(false);
			cumulRistClientsRepository.save(crc);
			
		}
		
		
		//Facture
		f.setValide(false);
	
		factureRepository.save(f);
		
		r.format(Code.SUCCESS, "Opération d'annulation effectuée avec succes" );
		
		return r; 
	}
	
	/*
	 * Affecter un patrimoine pour la livraison d'une facture.
	 * NOU
	 */
	@Transactional
	public ReponseDto affecterPatrimoineFacture(Facture f, Patrimoine p) {
		ReponseDto r=new ReponseDto();
		if(f==null) {
			r.format(Code.FAILURE, "Cette facture est invalide/inexistante");
			return r;
		}
		if(p==null) {
			r.format(Code.FAILURE, "Cette facture est invalide/inexistante");
			return r;
		}
		if(f.isValide() && p.isValide()) {
			PatrimoineFacture pf= new PatrimoineFacture();
			pf.setValide(true);
			r.format(Code.SUCCESS, patrimoineFactureRepository.save(pf));
		}else {
			r.format(Code.FAILURE, "Ce patrimoine ou cette facture est invalide");
		}
		
		 return r;
	}
	
	/*
	 * Annuler l'affectation d'un patrimoine à une facture
	 * 
	 */
	@Transactional
	public ReponseDto annulerAffectationPatrimoineFacture(PatrimoineFacture pf) {
		ReponseDto r=new ReponseDto();
		
		if(pf==null) {
			r.format(Code.FAILURE, "Donnée invalide");
			return r;
		}
		if(pf.isValide()) {
			r.format(Code.FAILURE, "Cette opération est déjà éffectuée");
		}else {
			pf.setValide(false);
			patrimoineFactureRepository.save(pf);
			r.format(Code.FAILURE, "Opération effectuée");
		}
		return r;
	}
	
	/*
	 * La livraison d'une facture consiste à faire sortir les produits en question du magasin. 
	 * Donc elle consiste en:
	 * 1- créer de nouveaux enregistrements dans ProduitsMvts;
	 * 2- Mettre la variable isLivred à true;
	 * 3- Associer le Magasinier et le livreur qui effectuent la sortie des produits au magazin et la livraison du produit;
	 * 4- Ajouter la ligne dans cumulRistourneC
	 */
	@Transactional
	public ReponseDto livrerFacture(Facture f, Personnel magasinier, Personnel livreur) {
		ReponseDto r=new ReponseDto();
		if(f==null) {
			r.format(Code.FAILURE, "Cette facture est invalide/inexistante");
			return r;
		}
		if(magasinier==null) {
			r.format(Code.FAILURE, "Ce magazinier est invalide/inexistante");
			return r;
		}
		
		if(livreur==null) {
			r.format(Code.FAILURE, "Ce livreur est invalide/inexistante");
			return r;
		}
		if(f.isLivred()) {
			r.format(Code.FAILURE, "Cette facture est deja livrée");
			return r;
		}
		Facture f2= factureRepository.findByIdFactureAndIsValideTrue(f.getIdFacture());
		
		//1- Nouveaux enregistrements dans ProduitsMvt en diminuant le produit en Stock
		produitsFactureRepository.findByMyFactureAndIsValideTrue(f2).forEach(pfc->{
			//Nouveau enregistrement
			ProduitMvt pMvt= new ProduitMvt();
				pMvt.setDate(LocalDate.now());
				pMvt.setHeure(LocalTime.now());
				pMvt.setMyFacture(f2);
				pMvt.setNature(SORTIE_PROD);
				pMvt.setProduit(pfc.getProduitPF());
				pMvt.setQuantite(pfc.getQuantitePF());
					StringBuilder builder = new StringBuilder();
				pMvt.setLibelle(builder.append(LIBELLE_SORTIE_FACT).toString());
				pMvt.setMagasinierPROD(magasinier);
				produitMvtRepository.save(pMvt);
				
			//Dimunition en Stock
			Produit p= produitRepository.findByIdProduitAndIsValideTrue(pfc.getProduitPF().getIdProduit());
			p.setQuantite(p.getQuantite()-pfc.getQuantitePF());
			produitRepository.save(p);
		});
		
		//2- Affectation du magasinier et du livreur
		f2.setMagasinierFact(magasinier);
		f2.setLivreur(livreur);
		
		//3- Mettre isLivred à true
		f2.setLivred(true);
		
		//4- Sauvegarde de la ristourne du client
		CumulRistClients newRist= new CumulRistClients();
			newRist.setClient(f2.getClientFact());
			newRist.setDate(LocalDate.now());
			newRist.setFacture(f2);
			newRist.setMontant(f2.getTotalRistFact());
			newRist.setPayed(false);
		cumulRistClientsRepository.save(newRist);
		
		Facture f3=factureRepository.save(f2);
		FactureDto fdto =new FactureDto(f3.getClientFact(), f3.getSoldeFact(), f3.getNbEmbFact(),f3.getDateFact(), f3.getMyDetailsFacture());
		
			r.format(Code.SUCCESS, fdto);
		return r;
	}
	
	/*
	 * l'enregistrement du retour de la livraison d'une facture passe par les points suivants:
	 * 1- Faire une avance sur le facture avec l'ArgentRetour(En ajoutant les nouveaux enregistrements dans ArgentMvt)
	 * 2- Faire une avance de la somme des 3 catégories d'emballage sur la facture.
	 * 3- Enregistrer les catgories d'emballages dans EmballageMvt ensuite dans le Stock des emballages(MagEmballage)
	 * 4- Enregistrer les éventuels cass/Manquants
	 * NB: Ne pas oubllier l'heure.
	 */
	@Transactional
	public ReponseDto enregistrerRetourFacture(Facture f, Personnel secretaire, float nbEmbSABC, float nbEmbUCB , float nbEmbGUINNESS, float argentRetour) {
		ReponseDto r=new ReponseDto();
		
		if(f==null) {
			r.format(Code.FAILURE, "Cette facture est invalide/inexistante");
			return r;
		}
		if(secretaire==null) {
			r.format(Code.FAILURE, "Ce personnel est invalide/inexistante");
			return r;
		}
		if(!f.isValide()) {
			r.format(Code.FAILURE, "Cette facture est invalide/inexistante");
			return r;
		}
		
		if(!secretaire.isValide()){
			r.format(Code.FAILURE, "Ce personnel est invalide/inexistante");
			return r;
		}
		
		if(nbEmbGUINNESS<0){
			r.format(Code.FAILURE, "Nombre de casier Guinness invalide");
			return r;
		}
		
		if(nbEmbSABC<0){
			r.format(Code.FAILURE, "Nombre de casier Brasseries invalide");
			return r;
		}
		
		if(nbEmbUCB<0){
			r.format(Code.FAILURE, "Nombre de casier UCB invalide");
			return r;
		}
		
		if(nbEmbGUINNESS+nbEmbSABC+nbEmbUCB==0 && argentRetour!=0){
			r.format(Code.FAILURE, "Veillez changer le moyen d'enregistrement et faites une avance de Facture simple");
			return  r;
		}
		
		if(nbEmbGUINNESS+nbEmbSABC+nbEmbUCB!=0 && argentRetour==0){
			r.format(Code.FAILURE, "Veillez changer le moyen d'enregistrement et faites une avance de Facture simple");
			return  r;
		}
		
		if(nbEmbGUINNESS+nbEmbSABC+nbEmbUCB==0 && argentRetour==0) {
			r.format(Code.FAILURE, "Impossible de conserver des valeurs nulles.");
			return r;
		}
		if(argentRetour<=0) {
			r.format(Code.FAILURE, "Veillez entrer un montant valide");
			return r;
		}
		if(f.isSoldedFacture()) {
			r.format(Code.FAILURE, "Cette facture est deja soldée");
			return r;
		}
		if(f.getMyDetailsFacture().getTotalResteSolde()<argentRetour){
			r.format(Code.FAILURE, "Pour cette facture, il ne reste que "+ f.getMyDetailsFacture().getTotalResteSolde()+" à payer");
			return r;
		}
		
		List<GestionFactureOutDto> lgf= new ArrayList<GestionFactureOutDto>();
		ReponseDto res1=this.avanceFactureArgent(f, argentRetour, secretaire);
		ReponseDto res2=this.avanceFactureEmballage(f, secretaire, nbEmbSABC, nbEmbUCB, nbEmbGUINNESS);
		if((boolean)res1.getResponse().get("status") && (boolean)res1.getResponse().get("status")) {
			GestionFactureOutDto gfA=(GestionFactureOutDto) res1.getResponse().get("data");
			GestionFactureOutDto gfE=(GestionFactureOutDto) res2.getResponse().get("data");
			//GestionFactureOutDto gfdtoA= new GestionFactureOutDto(gfA.getIdGestionFacture(), gfA.getAvanceGF(),gfA.getNatureOpGF() ,gfA.getMyFacture().getIdFacture(), gfA.getPersonnelIntGF().getIdPersonnel());
			//GestionFactureOutDto gfdtoE= new GestionFactureOutDto(gfE.getIdGestionFacture(), gfE.getAvanceGF(),gfE.getNatureOpGF() ,gfE.getMyFacture().getIdFacture(), gfE.getPersonnelIntGF().getIdPersonnel());
			
			lgf.add(gfA);
			lgf.add(gfE);
			r.format(Code.SUCCESS, lgf);
			return r;
		}else {
			r.format(Code.FAILURE, "Opération non aboutie");
			return r;
		}
		//this.stockerEmbFacture(gfE, magEMB);
	} // PROBLÈME = OPPORTUNITE; PAS DE TEMPS POUR S'APPITOYER
	/*
	 * L'avance sur une facture suit le même principe que l'avance sur une livraison.
	 * ARGENT:
	 * 1- Un nouvel enregistrement dans GestionFacture;
	 * 2- Un nouvel enregistrement dans ArgentMvt;
	 * 3- Mise à jour dans DetailsFacture;
	 * 4- Mise à jour de isEmbOk et isSolde dans Facture
	 *
	 */
	@Transactional
	public ReponseDto avanceFactureArgent(Facture f, float avance, Personnel secretaire) {
		ReponseDto r= new ReponseDto();
		if(f==null) {
			r.format(Code.FAILURE, "Cette facture est invalide/inexistante");
			return r;
		}
		
		if(secretaire==null) {
			r.format(Code.FAILURE, "Ce personnel est invalide/inexistante");
			return r;
		}
		
		if(avance<=0) {
			r.format(Code.FAILURE, "Veillez entrer un montant valide");
			return r;
		}
		if(f.isSoldedFacture()) {
			r.format(Code.FAILURE, "Cette facture est deja soldée");
			return r;
		}
		if(f.getMyDetailsFacture().getTotalResteSolde()<avance) {
			r.format(Code.FAILURE, "Pour cette facture, il ne reste que "+ f.getMyDetailsFacture().getTotalResteSolde()+" à payer");
			return r;
		}
		//2-Un nouvel enregistrement dans ArgentMvt;
		ArgentMvt argent= new ArgentMvt();
			argent.setDateOpArgent(LocalDate.now());
			argent.setHeureOpArgent(LocalTime.now());
			argent.setMontant(avance);
			argent.setNatureMvt(ENTREE_ARGENT);
				StringBuilder b= new StringBuilder();
			argent.setLibelleArgent(b.append(LIBELLE_ARGENT_FACTURE).toString());
		ArgentMvt argent2= argentMvtRepository.save(argent);
		
		//1- Un nouvel enregistrement dans GestionFacture;
		GestionFacture gf= new GestionFacture();
			gf.setAvanceGF(avance);
			gf.setDateGF(LocalDate.now());
			gf.setHeureGF(LocalTime.now());
			gf.setNatureOpGF(true);
			gf.setManaged(false);
			gf.setPersonnelIntGF(secretaire);
			gf.setMyArgentMvt(argent2);
			gf.setMyFacture(f);
		GestionFacture gls= gestionFactureRepository.save(gf);
			
		argent2.setMyGestionFacture(gls);
			argentMvtRepository.save(argent2);
			
		//3- Mise à jour dans DetailsFacture;	
		DetailsFacture df= detailsFactureRepository.findByIdDetailsFactureAndIsValideTrue(f.getMyDetailsFacture().getIdDetailsFacture());
			df.setTotalAvanceSolde(df.getTotalAvanceSolde()+avance);
			df.setTotalResteSolde(df.getTotalResteSolde()-avance);
		detailsFactureRepository.save(df);	
		
		 //4- Mise à jour de isEmbOk et isSolde
		Facture f2= factureRepository.findByIdFactureAndIsValideTrue(f.getIdFacture());
		if(df.getTotalAvanceSolde()>=f2.getSoldeFact()) {
			f2.setSoldedFacture(true);
			factureRepository.save(f2);
		}
		GestionFactureOutDto gfdto = new GestionFactureOutDto(gls.getIdGestionFacture(), gls.getAvanceGF(), gls.getNatureOpGF(), gls.getMyFacture().getIdFacture(), gls.getPersonnelIntGF().getIdPersonnel()); 
		r.format(Code.SUCCESS, gfdto);
		return r;
	}	
	
	@Transactional
	public ReponseDto annulerAvanceFacture(GestionFacture gf){
		ReponseDto r= new ReponseDto();
		if(gf==null) {
			r.format(Code.FAILURE, "Cette Opération de facture invalide/inexistante.");
			return r;
		}
		
		if (!gf.isValide()) {
			r.format(Code.FAILURE, "Cette Opération de facture est invalide");
			return r;
		}
		
		if(gf.isManaged()) {
			r.format(Code.FAILURE, "Cette Opération de facture est déjà encaissée/Stockée. Donc Impossible de l'annuler");
			return r;
		}
		
		if(gf.getNatureOpGF()){//Si c'est une opération d'argent
			ArgentMvt argent=gf.getMyArgentMvt();
				argent.setValide(false);
			argentMvtRepository.save(argent);
			
			Facture f=gf.getMyFacture();
			DetailsFacture df= detailsFactureRepository.findByIdDetailsFactureAndIsValideTrue(f.getMyDetailsFacture().getIdDetailsFacture());
				df.setTotalResteSolde(df.getTotalResteSolde()+gf.getAvanceGF());
				df.setTotalAvanceSolde(df.getTotalAvanceSolde()-gf.getAvanceGF());
			detailsFactureRepository.save(df);
			
			if(df.getTotalAvanceSolde()<f.getSoldeFact()) {
				f.setSoldedFacture(false);
				factureRepository.save(f);
			}
		}else {
			List<EmballagesMvt> lem= emballagesMvtRepository.findByMyGestionFactureAndIsValideTrue(gf);
			lem.forEach(em->{
				em.setValide(false);
				emballagesMvtRepository.save(em);
			});
			
			Facture f=gf.getMyFacture();
			DetailsFacture df= detailsFactureRepository.findByIdDetailsFactureAndIsValideTrue(f.getMyDetailsFacture().getIdDetailsFacture());
				df.setTotalAvanceEmb(df.getTotalAvanceEmb()-gf.getAvanceGF());
				df.setTotalResteEmb(df.getTotalResteEmb()+gf.getAvanceGF());
			detailsFactureRepository.save(df);
			
			if(df.getTotalAvanceEmb()<f.getNbEmbFact()) {
				f.setEmbOkFacture(false);
				factureRepository.save(f);
			}
		}
		gf.setValide(false);
		gestionFactureRepository.save(gf);
		
		r.format(Code.SUCCESS, "Avance annulée avec succes.");
		
		return r;
	}
	
	@Transactional
	public ReponseDto modifierAvanceArgentFacture(GestionFacture gf, float nouvMontant) {
		ReponseDto r= new ReponseDto();
		float oldMontant =gf.getAvanceGF();
		if(!gf.isValide()) {
			r.format(Code.FAILURE, "Cette facture est invalide");
			return r;
		}
		
		if(gf.isManaged()) {
			r.format(Code.FAILURE, "Cette Opération de facture est déjà encaissée/Stockée. Donc ne peut être modifée");
			return r;
		}
		
		if(!gf.getNatureOpGF()) {
			r.format(Code.FAILURE, "La nature de cette opération n'est pas pour cette fonction de modification");
			return r;
		}
		
		
		//Mise à jour dans ArgentMvt
		ArgentMvt argent=gf.getMyArgentMvt();
			argent.setMontant(nouvMontant);
		argentMvtRepository.save(argent);
		
		//3- Mise à jour dans DetailsFacture;	
		Facture f=gf.getMyFacture();
		DetailsFacture df= detailsFactureRepository.findByIdDetailsFactureAndIsValideTrue(f.getMyDetailsFacture().getIdDetailsFacture());
			df.setTotalResteSolde(df.getTotalResteSolde()+oldMontant-nouvMontant);
			df.setTotalAvanceSolde(df.getTotalAvanceSolde()-oldMontant+nouvMontant);
		detailsFactureRepository.save(df);	
		
		//4- Mise à jour dans facture.
		if(df.getTotalAvanceSolde()>=f.getSoldeFact()) {
			f.setSoldedFacture(true);
			factureRepository.save(f);
		}
		
		gf.setAvanceGF(nouvMontant);
		r.format(Code.SUCCESS, factureRepository.save(f));
		
		return r;
	}
	
	@Transactional
	public ReponseDto modifierAvanceEmbFacture(GestionFacture gf, float nouvSABC,float nouvUCB,float nouvGUI) {
		ReponseDto r= new ReponseDto();
		float oldQuantite =gf.getAvanceGF();
		
		if(!gf.isValide()) {
			r.format(Code.FAILURE, "Cette facture est invalide");
			return r;
		}
		
		if(gf.isManaged()) {
			r.format(Code.FAILURE, "Cette Opération de facture est déjà encaissée/Stockée. Donc ne peut être modifée");
			return r;
		}
		
		if(gf.getNatureOpGF()) {
			r.format(Code.FAILURE, "La nature de cette opération n'est pas pour cette fonction de modification");
			return r;
		}
		
		//Mise à jour dans EmballageMvt
		List<EmballagesMvt> lem= emballagesMvtRepository.findByMyGestionFactureAndIsValideTrue(gf);
		lem.forEach(em->{
			if(em.getFournisseurEmb().getIdFournisseur()==ID_SABC) {
				em.setQuantiteEmb(nouvSABC);
				emballagesMvtRepository.save(em);
			}
			if(em.getFournisseurEmb().getIdFournisseur()==ID_UCB) {
				em.setQuantiteEmb(nouvUCB);
				emballagesMvtRepository.save(em);
			}
			if(em.getFournisseurEmb().getIdFournisseur()==ID_GUINNESS) {
				em.setQuantiteEmb(nouvGUI);
				emballagesMvtRepository.save(em);
			}
		});
		
		//3- Mise à jour dans DetailsFacture;	
		Facture f=gf.getMyFacture();
		DetailsFacture df= detailsFactureRepository.findByIdDetailsFactureAndIsValideTrue(f.getMyDetailsFacture().getIdDetailsFacture());
				df.setTotalAvanceEmb(df.getTotalAvanceEmb()-oldQuantite+(nouvSABC+nouvUCB+nouvGUI));
				df.setTotalResteEmb(df.getTotalAvanceEmb()+oldQuantite-(nouvSABC+nouvUCB+nouvGUI));
		detailsFactureRepository.save(df);
			
		//Mise à jour dans Facture
		if(df.getTotalAvanceEmb()>=f.getNbEmbFact()) {
			f.setEmbOkFacture(true);
			factureRepository.save(f);
		}
		
		gf.setAvanceGF(nouvSABC+nouvUCB+nouvGUI);
		
		r.format(Code.SUCCESS, gestionFactureRepository.save(gf));
		
		return r;
	}
	/*
	 * Encaisser l'argent d'une facture.
	 * Acteur: CAISSIER(E)
	 * 
	 */
	@Transactional
	public ReponseDto encaisserArgentFacture(GestionFacture gf, Personnel caissier) {
		ReponseDto r=new ReponseDto();
		
		if(gf==null) {
			r.format(Code.FAILURE, "Cette opération est invalide/inexistant");
			return r;
		}
		
		if (caissier==null) {
			r.format(Code.FAILURE, "Ce personnel est invalie/inexistant");
			return r;
		}
		
		if (!gf.getNatureOpGF()) {//C'est une opération d'Emballage
			r.format(Code.FAILURE, "C'est une operation de d'emballage et non d'argent");
			return r;
		}
		if(gf.isManaged()) {
			r.format(Code.FAILURE, "Cette opération est déja traitée");
			return r;
		}
		//Recuperation de l'ArgentMvt associé et affectation 
		ArgentMvt am= argentMvtRepository.findByMyGestionFactureAndIsValideTrue(gf);
			am.setMontant(gf.getAvanceGF());
			am.setDateOpArgent(date);
			am.setHeureOpArgent(heure);
			am.setResponsable(caissier);
			am.setMyGestionFacture(gf);
		ArgentMvt am2=argentMvtRepository.save(am);
		
		//Caisse journalière
		CaisseJournaliere cj= caisseJournaliereRepository.findByDateBetweenAndIsValideTrue(date.plusDays(1),date.plusDays(1));
		if(cj==null) {
			cj= new CaisseJournaliere();
				cj.setDate(date);
				cj.setMontantEncaisse(gf.getAvanceGF());
				cj.setMontantDepenses(0);
				cj.setMontantFinal(gf.getAvanceGF());
				cj.setTaked(false);
				cj.setUsedType(UsedCaisseJounaliere.NOTUSED);
				cj.setMontantUsed(0);
		}else {
			cj.setMontantEncaisse(cj.getMontantEncaisse()+gf.getAvanceGF());
			cj.setMontantFinal(cj.getMontantFinal()+gf.getAvanceGF());
			
		}
		CaisseJournaliere cj2=caisseJournaliereRepository.save(cj);
		
		am2.setMyCaisseJournaliere(cj2);
		argentMvtRepository.save(am2);

		gf.setManaged(true);
		gestionFactureRepository.save(gf);
		r.format(Code.SUCCESS, new CaisseJournaliereDto(cj2.getIdCaisseJournaliere(),cj2.getDate(),cj2.getMontantFinal()));
	return	r;
	}
	
	@Transactional
	public ReponseDto annulerEncaissementArgentFacture(GestionFacture gf) {
		ReponseDto r=new ReponseDto();
		if (!gf.getNatureOpGF()) {
			r.format(Code.FAILURE, "C'est une operation d'emballage et non d'argent");
			return r;
		}
		
		if(!gf.isManaged()){
			r.format(Code.FAILURE, "Cette opération n'est pas encore traitée.");
			return r;
		}
		
		//Invalidation de ArgentMvt
		ArgentMvt am= argentMvtRepository.findByMyGestionFactureAndIsValideTrue(gf);
			am.setValide(false);
		argentMvtRepository.save(am);
		
		//Retrait de l'argent en caisse
		CaisseJournaliere cj=am.getMyCaisseJournaliere();
			cj.setMontantEncaisse(cj.getMontantEncaisse()-gf.getAvanceGF());
			cj.setMontantFinal(cj.getMontantFinal()-gf.getAvanceGF());
		caisseJournaliereRepository.save(cj);
		
		//Mise à jour dans GestionFaction
		gf.setManaged(false);
		r.format(Code.SUCCESS, gestionFactureRepository.save(gf));
		
		return r;
	}
	/*
	 * L'avance sur une facture suit le même principe que l'avance sur une livraison.
	 * EMBALLAGE
	 * 1- Un nouvel enregistrement dans GestionFacture(Avec la somme des 3 catégories d'Emballages);
	 * 2- Des nouveaux enregistrements (3 au plus) dans EmballageMvt;
	 * 3- Mise à jour dans DetailsFacture;
	 * 4- Mise à jour de isEmbOk dans Facture
	 *
	 */
	@Transactional
	public ReponseDto avanceFactureEmballage(Facture f,Personnel p,float nbEmbSABC, float nbEmbUCB , float nbEmbGUINNESS ) {
		ReponseDto r=new ReponseDto();
		if(f==null) {
			r.format(Code.FAILURE, "Facture invalide/inexistante");
			return r;
		}
		
		if(p==null) {
			r.format(Code.FAILURE, "Personnel invalide/inexistante");
			return r;
		}
		
		if(!f.isValide()) {
			r.format(Code.FAILURE, "Facture invalide/inexistante");
			return r;
		}
		
		if(p.isValide()) {
			r.format(Code.FAILURE, "Personnel invalide/inexistante");
			return r;
		}
		
		if(nbEmbGUINNESS<0) {
			r.format(Code.FAILURE, "Nombre de casier Guinness invalide");
			return r;
		}
		
		if(nbEmbSABC<0) {
			r.format(Code.FAILURE, "Nombre de casier Brasseries invalide");
			return r;
		}
		
		if(nbEmbUCB<0) {
			r.format(Code.FAILURE, "Nombre de casier UCB invalide");
			return r;
		}
		
		if (f.isEmbOkFacture()) {
			r.format(Code.FAILURE, "Cette facture a des Emballages OK");
			return r;
		}
		
		if(f.getMyDetailsFacture().getTotalResteEmb()<nbEmbSABC+nbEmbUCB+nbEmbGUINNESS) {
			r.format(Code.FAILURE, "Pour cette facture il ne reste que "+ f.getMyDetailsFacture().getTotalResteEmb() +" à donner");
			return r;
		}
		//1- Un nouvel enregistrement dans GestionFacture(Avec la somme des 3 catégories d'Emballages);
				GestionFacture gf= new GestionFacture();
					gf.setAvanceGF(nbEmbSABC+nbEmbUCB+nbEmbGUINNESS);
					gf.setDateGF(LocalDate.now());
					gf.setHeureGF(LocalTime.now());
					gf.setMyFacture(f);
					gf.setNatureOpGF(false);
					gf.setPersonnelIntGF(p);
				GestionFacture gf2=gestionFactureRepository.save(gf);
		
		//2- Des nouveaux enregistrements (3 au plus) dans EmballageMvt;
		if(nbEmbSABC!=0) {
			EmballagesMvt embSABC= new EmballagesMvt();
				embSABC.setDateOp(LocalDate.now());
				embSABC.setFournisseurEmb(fournisseurRepository.findByIdFournisseurAndIsValideTrue(ID_SABC));
				embSABC.setHeureOp(LocalTime.now());
				embSABC.setLibelleMvtEmb(LIBELLE_EMB_FACTURE);
				embSABC.setNatureMvtEmb(ENTREE_EMB);
				embSABC.setQuantiteEmb(nbEmbSABC);
				embSABC.setMyGestionFacture(gf2);
			emballagesMvtRepository.save(embSABC);
		}
		if(nbEmbUCB!=0) {
			EmballagesMvt embUCB= new EmballagesMvt();
				embUCB.setDateOp(LocalDate.now());
				embUCB.setFournisseurEmb(fournisseurRepository.findByIdFournisseurAndIsValideTrue(ID_UCB));
				embUCB.setHeureOp(LocalTime.now());
				embUCB.setLibelleMvtEmb(LIBELLE_EMB_FACTURE);
				embUCB.setNatureMvtEmb(ENTREE_EMB);
				embUCB.setQuantiteEmb(nbEmbUCB);
				embUCB.setMyGestionFacture(gf2);
			emballagesMvtRepository.save(embUCB);
		}
		if(nbEmbGUINNESS!=0) {
			EmballagesMvt embGUINNESS= new EmballagesMvt();
				embGUINNESS.setDateOp(LocalDate.now());
				embGUINNESS.setFournisseurEmb(fournisseurRepository.findByIdFournisseurAndIsValideTrue(ID_GUINNESS));
				embGUINNESS.setHeureOp(LocalTime.now());
				embGUINNESS.setLibelleMvtEmb(LIBELLE_EMB_FACTURE);
				embGUINNESS.setNatureMvtEmb(ENTREE_EMB);
				embGUINNESS.setQuantiteEmb(nbEmbGUINNESS);
				embGUINNESS.setMyGestionFacture(gf2);
			emballagesMvtRepository.save(embGUINNESS);
		}
		
		//3- Mise à jour dans DetailsFacture;
		DetailsFacture df= detailsFactureRepository.findByIdDetailsFactureAndIsValideTrue(f.getMyDetailsFacture().getIdDetailsFacture());
			df.setTotalAvanceEmb(df.getTotalAvanceEmb()+nbEmbSABC+nbEmbUCB+nbEmbGUINNESS);
			df.setTotalResteEmb(df.getTotalResteEmb()-(nbEmbSABC+nbEmbUCB+nbEmbGUINNESS));
		detailsFactureRepository.save(df);
		
		//4- Mise à jour de isEmbOk et isSolde dans Livraison
		Facture f2= factureRepository.findByIdFactureAndIsValideTrue(f.getIdFacture());
		if(df.getTotalAvanceEmb()>=f2.getNbEmbFact()) {
			f2.setEmbOkFacture(true);
			factureRepository.save(f2);
		}
		
		GestionFactureOutDto gfdto= new GestionFactureOutDto(gf2.getIdGestionFacture(), gf2.getAvanceGF(),gf2.getNatureOpGF() ,gf2.getMyFacture().getIdFacture(), gf2.getPersonnelIntGF().getIdPersonnel());
		
		r.format(Code.SUCCESS, gfdto);
		return r;
	}
	
	/*
	 * Stocker les Emballages d'une Facture.
	 * Acteur: MagazinierEMB
	 */
	@Transactional
	public ReponseDto stockerEmbFacture(GestionFacture gf,Personnel magasinierEMB) {
		ReponseDto r= new ReponseDto();
		if (gf.getNatureOpGF()) {
			r.format(Code.FAILURE, "Cette opération ne concerne pas les Emballages");
			return r;
		}
		if(gf.isManaged()) {
			r.format(Code.FAILURE, "Cette opération est deja traitée");
			return r;
		}
			MagEmballage meSABC= magEmballageRepository.etatMagEmbParFournisseur(ID_SABC);
			MagEmballage meUCB= magEmballageRepository.etatMagEmbParFournisseur(ID_UCB);
			MagEmballage meGUI= magEmballageRepository.etatMagEmbParFournisseur(ID_GUINNESS);
			MagDto md= new MagDto();
			
			List<EmballagesMvt> lem= emballagesMvtRepository.findByMyGestionFactureAndIsValideTrue(gf);
			lem.forEach(em->{
				if(em.getFournisseurEmb().getIdFournisseur()==ID_SABC) {
					meSABC.setQteMag(meSABC.getQteMag()+em.getQuantiteEmb());
					magEmballageRepository.save(meSABC);
					em.setMagasinierEMB(magasinierEMB);
					emballagesMvtRepository.save(em);
					
					md.setQuantiteSABC(meSABC.getQteMag()+em.getQuantiteEmb());
				}
				if(em.getFournisseurEmb().getIdFournisseur()==ID_UCB) {
					meUCB.setQteMag(meUCB.getQteMag()+em.getQuantiteEmb());
					magEmballageRepository.save(meUCB);
					em.setMagasinierEMB(magasinierEMB);
					emballagesMvtRepository.save(em);
					
					md.setQuantiteUCB(meUCB.getQteMag()+em.getQuantiteEmb());
				}
				if(em.getFournisseurEmb().getIdFournisseur()==ID_GUINNESS) {
					meGUI.setQteMag(meGUI.getQteMag()+em.getQuantiteEmb());
					magEmballageRepository.save(meGUI);
					em.setMagasinierEMB(magasinierEMB);
					emballagesMvtRepository.save(em);
					
					md.setQuantiteGUI(meGUI.getQteMag()+em.getQuantiteEmb());
				}
			});	
		
		
		//Mise à jour de gf 
			gf.setManaged(true);
			gestionFactureRepository.save(gf);
			
			r.format(Code.SUCCESS, md);
			return r;
		}
	/*
	 * L'annulation du stockage d'une GestionFacture ne revient pas à la désactivation de celle-ci
	 * Mais à la rendre isManaged=false et à repercuter les conséquences sur les tables affectées. 
	 */
	
	@Transactional
	public ReponseDto annulerStockageEmballage(GestionFacture gf) {
		ReponseDto r= new ReponseDto();
		
		if(gf==null) {
			r.format(Code.FAILURE, "Cette opération est invalide/inexistance");
			return r;
		}
		
		if(!gf.isManaged()) {
			r.format(Code.FAILURE, "Impossible d'annuler une avance non gérée");
			return r;
		}
		
		if(!gf.isValide()) {
			r.format(Code.FAILURE, "Cette opération est invalide.");
		}
		//Désactivation des EmbalagesMvt
		List<EmballagesMvt> lem= emballagesMvtRepository.findByMyGestionFactureAndIsValideTrue(gf); 
		lem.forEach(em->{
			em.setValide(false);
			emballagesMvtRepository.save(em);
			// mis à jour de la quantité au Magazin.
			MagEmballage mag=magEmballageRepository.findByFournisseurAndIsValideTrue(em.getFournisseurEmb());
			mag.setQteMag(mag.getQteMag()-em.getQuantiteEmb());
			magEmballageRepository.save(mag);
		});
		//mise à jour dans GestionFacture
		gf.setManaged(false);
		gestionFactureRepository.save(gf);
		r.format(Code.SUCCESS, "Annulation de l'opération "+gf.getIdGestionFacture() +" éffectué avec sucses");
		
		return r;
	}
	
	/*
	 * Liste de toutes les operations d'avance sur une facture
	 */
	
	public List<GestionFacture> informationsFacture(Facture f) {
		return gestionFactureRepository.findByMyFactureAndIsValideTrue(f);
	}
	
	public List<Facture> informationsFacturesClient(Client c) {
		return factureRepository.findByClientFactAndIsValideTrue(c);
	}
	
	public List<Facture> listeFactureNonSoldees() {
		return factureRepository.findByIsSoldedFactureAndIsValideTrue(false);
	}
	
	public List<Facture> listeEmballagesNonRemis() {
		return factureRepository.findByIsEmbOkFactureAndIsValideTrue(false);
	}
	
	public boolean conformeClient(Client c) {//ni dette ni emballage en sa possession
		return factureRepository.findByClientFactAndIsEmbOkFactureFalseOrIsSoldedFactureFalseAndIsValideTrue(c).size()==0;
	}
	
	public List<FactureDto>  listeClientsNonConforme() {//Une projection sur facture
		return factureRepository.findByIsEmbOkFactureFalseOrIsSoldedFactureFalseAndIsValideTrue();
	}
	
	public List<Cass> listeCass(LocalDate date) {//Avec montant net.
		return cassRepository.findByDateCassAndIsValideTrue(date);
	}
	
	public List<ArgentMvt> listeMvtArgent(LocalDate date) {
		return argentMvtRepository.findByDateOpArgentBetweenAndIsValideTrue(date.plusDays(1),date.plusDays(1));
	}									
	
	public List<EmballagesMvt> listeMvtEmballage(LocalDate date) {
		return emballagesMvtRepository.findByDateOpBetweenAndIsValideTrue(date.plusDays(1),date.plusDays(1));
	}
	
	public List<ArgentMvt> listeArgentEntres(LocalDate date) {
		return argentMvtRepository.findByDateOpArgentBetweenAndNatureMvtTrueAndIsValideTrue(date.plusDays(1),date.plusDays(1));
	}
	
	public List<ArgentMvt> listeArgentSortis(LocalDate date) {
		return argentMvtRepository.findByDateOpArgentBetweenAndNatureMvtFalseAndIsValideTrue(date.plusDays(1),date.plusDays(1));
	}
	
	public List<EmballagesMvt> listeEmballagesEntres(LocalDate date) {
		return emballagesMvtRepository.findByDateOpBetweenAndNatureMvtEmbTrueAndIsValideTrue(date.plusDays(1),date.plusDays(1));
	}
	
	public List<EmballagesMvt> listeEmballagesSortis(LocalDate date) {
		return emballagesMvtRepository.findByDateOpBetweenAndNatureMvtEmbFalseAndIsValideTrue(date.plusDays(1),date.plusDays(1));
	}
	
	public List<MagEmballage> etatMagEmballage() {
		return magEmballageRepository.findAll();
	}
	
	public List<Produit> EtatDuMagProduitsByFournisseur(Fournisseur fournisseur) {
		return produitRepository.findByMyFournisseurAndIsValideTrue(fournisseur);
	}
	
	public void totalRistounesClientsImpayees() {
		
	}
	
	public List<CumulRistClients> listeRistournesClientsImpayees() {
		return cumulRistClientsRepository.findByIsPayedFalseAndIsValideTrue();
	}
	
	public List<CumulRistClients> listeRistournesClient(Client c) {
		return cumulRistClientsRepository.findByClientAndIsPayedFalseAndIsValideTrue(c);
	}
	
	public void totalRistournesClient(Client c) {
		
	}
	
	/*
	 * 1- On calcule le total des ristournes du client à partir de la méthode précedente;
	 * 2- On ajoute une nouvelle ligne dans TotalRistournePayement
	 */
	public void payerRistourneClient(Client c) {
		
	}
	
	/*
	 * Penser à ecrire le code néncessaire pour annuller les opérations.
	 */
	
	
	//////////////////////////////////////CHARGEMENT//////////////////////////////////////////////////
	
	@Transactional
	public Chargement initialiserChargement(Personnel sec,Personnel mag, Personnel liv,String secteur) {
		Chargement charg= new Chargement();
			charg.setDateChargement(date);
			charg.setHeureChargement(heure);
			charg.setLivred(false);
			charg.setLivreurChar(liv);//Pour un chargement c'est un livreur qui est le responsable
			charg.setMagasinierChar(mag);//Mag de la Boisson
			charg.setNbColisChar(0);
			charg.setNbEmbChar(0);
			charg.setSecretaireChar(sec);
			charg.setSecteurChar(secteur);
			charg.setSoldeChar(0);
		Chargement cgm= chargementRepository.save(charg);
			
			//RetourChargement
		RetourChargement rc=retourChargementRepository.save(new RetourChargement(date,heure,0,0,0,0,0,0,0,charg,false, false,0));
	
			cgm.setMyRetourChargment(rc);
			
			return chargementRepository.save(cgm);
	}
	
	@Transactional
	public ReponseDto affecterProduitChargement(Chargement charg,float quantite, Produit produit) {
		ReponseDto r= new ReponseDto();
		if (quantite>this.stockProduitReel(produit) && quantite>produitRepository.findByIdProduitAndIsValideTrue(produit.getIdProduit()).getQuantite()) {
			r.format(Code.FAILURE, "Affectation de Produit impossible:les Factures deja enregistrées sont pris en consideration.");
			return r;
		}
		
		if(quantite>this.stockProduitReel(produit) && quantite<=produitRepository.findByIdProduitAndIsValideTrue(produit.getIdProduit()).getQuantite()) {
			r.format(Code.FAILURE, "Affectation de Produit impossible:les Factures deja enregistrées sont pris en consideration."
					+ " Toute fois, si cette facture est prioritaire, vous pouvez annuler/diminuer ce produit sur une facure déjà effectuée");
			return r;
		}
		
		
		//Nouvelle ligne dans ProduitChargement
		ProduitsChargement pc= new ProduitsChargement(produit,quantite,produit.getPrixChargement()*quantite,charg,0);
		//Mise à jour dans Chargement
		charg.setNbColisChar(charg.getNbColisChar()+quantite);
		if(produit.getType().equals(TYPE_CASIER)) {
			charg.setNbEmbChar(charg.getNbEmbChar()+quantite);
		}
		charg.setSoldeChar(charg.getSoldeChar()+produit.getPrixChargement()*quantite);
		
		chargementRepository.save(charg);
		
		r.format(Code.SUCCESS,produitsChargementRepository.save(pc) );
		return r;
	}
	
	@Transactional
	public ReponseDto annulerProduitChargement(Chargement charg,Produit produit) {
		ReponseDto r= new ReponseDto();
		if(!charg.isValide()) {
			r.format(Code.FAILURE, "Impossible. Ce chargement est invalide.");
			return r;
		}
		
		if(charg.isLivred()) {
			r.format(Code.FAILURE, "Ce chargement est déjà livré. Impossible d'annuler un produit.");
			return r;
		}
		
		RetourChargement rc=charg.getMyRetourChargment();
		if(rc.getTotalCasierRetour()!=0 || rc.getTotalEmbRetour()!=0 || rc.getTotalVersement()!=0) {
			r.format(Code.FAILURE, "Impossible. Ce chargement a déjà un retourd.");
			return r;	
		}
		
		ProduitsChargement pc= produitsChargementRepository.findByMyChargementAndProduitPCAndIsValideTrue(charg, produit);
		if(pc==null) {
			r.format(Code.FAILURE, "Ce produit ne fais pas partie de ce chargement.");
			return r;
		}
		if(produit.getType().equals(TYPE_CASIER)) {
			charg.setNbEmbChar(charg.getNbEmbChar()-pc.getQuantitePC());
		}
		charg.setNbColisChar(charg.getNbColisChar()-pc.getQuantitePC());
		charg.setSoldeChar(charg.getSoldeChar()-pc.getPrixTotalPC());
		chargementRepository.save(charg);
		
		
		pc.setValide(false);
		
		
		r.format(Code.SUCCESS, produitsChargementRepository.save(pc));
		
		return r;
	}
	
	@Transactional
	public ReponseDto annulerChargement(Chargement charg) {
		ReponseDto r= new ReponseDto();
		if(charg.isEmbOK()||charg.isSolded()) {
			r.format(Code.FAILURE, "Impossible. Ce Chargement est déjà soldé en argent ou/et en emballage");
			return r;
		}
		
		if(!charg.isValide()) {
			r.format(Code.FAILURE, "Impossible. Ce chargement est déjà invalide");
			return r;
		}
		
		RetourChargement rc=charg.getMyRetourChargment();
		if(rc.getTotalCasierRetour()!=0 || rc.getTotalEmbRetour()!=0 || rc.getTotalVersement()!=0) {
			r.format(Code.FAILURE, "Impossible. Ce chargement a déjà un retourd.");
			return r;	
		}
		
		List<ProduitsChargement> lpc=produitsChargementRepository.findByMyChargementAndIsValideTrue(charg);
		lpc.forEach(pc->{
			pc.setValide(false);
			produitsChargementRepository.save(pc);
		});
		
		
		charg.setValide(false);
		
		r.format(Code.SUCCESS, chargementRepository.save(charg));
		
		return r;
		
	}
	
	public ChargementPatrimoine affecterPatrimoineChargement(Chargement charg, Patrimoine pat) {
		ChargementPatrimoine cp=new ChargementPatrimoine(charg,pat,true);
		return chargementPatrimoineRepository.save(cp);
	}
	/*
	 * 1- liste des produitsChargement
	 * 2- parcourir la liste en créant les ProduitMvt
	 *  Mettre la variable isLivred à true;
	 * 3- Associer le Magasinier et le livreur qui effectuent la sortie des produits au magazin et la livraison du produit;
	 * 3-decrementer en Stock
	 */
	@Transactional
	public ReponseDto livrerChargement(Chargement charg,Personnel magasinier) {
		
		ReponseDto r= new ReponseDto();
		if(charg.isLivred()) {
			r.format(Code.FAILURE, "Ce chargement est déjà livré");
			return r;
		}
		produitsChargementRepository.findByMyChargementAndIsValideTrue(charg).forEach(pc->{
			ProduitMvt pm=new ProduitMvt();
				pm.setDate(date);
				pm.setHeure(heure);
				pm.setLibelle(LIBELLE_PRODUIT_CHARGEMENT);
				pm.setMyChargement(charg);
				pm.setNature(SORTIE_PROD);
				pm.setProduit(pc.getProduitPC());
				pm.setQuantite(pc.getQuantitePC());
				pm.setMagasinierPROD(magasinier);
			produitMvtRepository.save(pm);
			
			//Dimunition en Stock
			Produit p= produitRepository.findByIdProduitAndIsValideTrue(pc.getProduitPC().getIdProduit());
			p.setQuantite(p.getQuantite()-pc.getQuantitePC());
			produitRepository.save(p);
			
		});
		
		//2- Affectation du magasinier et du livreur
		charg.setMagasinierChar(magasinier);
		
		//3- Mettre isLivred à true
		charg.setLivred(true);
		
		r.format(Code.SUCCESS, chargementRepository.save(charg));
		return r;
	}
	//Penser à écrire la fonction permettant de vérifier si une commande est livrable.
	
	@Transactional
	public ReponseDto annulerLivraisonFacture(Facture f) {
		ReponseDto r= new ReponseDto();
		if(f==null) {
			r.format(Code.FAILURE, "Cette facture est invalide/inexistant.");
			return r;
		}
		
		if(!f.isLivred()) {
			r.format(Code.FAILURE, "Cette facture n'est même pas livré");
			return r;
		}
		
		List<ProduitMvt> lpm=produitMvtRepository.findByMyFactureAndIsValideTrue(f);
		
		lpm.forEach(pm->{
			pm.setValide(false);
			produitMvtRepository.save(pm);
			
			Produit p= produitRepository.findByIdProduitAndIsValideTrue(pm.getProduit().getIdProduit());
			p.setQuantite(p.getQuantite()+pm.getQuantite());
			produitRepository.save(p);
			
			
		});
		
		f.setLivred(false);
		f.setMagasinierFact(null);
		f.setLivreur(null);
		factureRepository.save(f);
		
		
		CumulRistClients newRist= cumulRistClientsRepository.findByFactureAndIsValideTrue(f);
		newRist.setValide(false);
		cumulRistClientsRepository.save(newRist);
		
		r.format(Code.SUCCESS, "Opération(annulation de stockage de la facture "+f.getIdFacture()+ " effectuéé avec succes");
		return r;
		
	}
	
	@Transactional
	public ReponseDto annulerLivraisonChargement(Chargement  charg) {
		ReponseDto r= new ReponseDto();
		if(charg==null) {
			r.format(Code.FAILURE, "Ce chargement est invalide/inexistant.");
			return r;
		}
		
		if(!charg.isLivred()) {
			r.format(Code.FAILURE, "Ce chargement n'est même pas livré.");
			return r;
		}
		
		if(!charg.isValide()) {
			r.format(Code.FAILURE, "Ce chargement n'est pas valide");
			return r;
		}
		
		List<ProduitMvt> lpm=produitMvtRepository.findByMyChargementAndIsValideTrue(charg);
		lpm.forEach(pm->{
			pm.setValide(true);//false?
			produitMvtRepository.save(pm);
			
			
			Produit p= produitRepository.findByIdProduitAndIsValideTrue(pm.getProduit().getIdProduit());
			p.setQuantite(p.getQuantite()+pm.getQuantite());
			produitRepository.save(p);
			
		});
		charg.setLivred(false);
		chargementRepository.save(charg);
		r.format(Code.SUCCESS, "Opération(annulation de stockage du Chargement  "+charg.getIdChargement() +" effectuéé avec succes");
		
		return r;
	}
	
	@Transactional
	public RetourChargement initialiserRetourChargment(Chargement c,Personnel sec) {
		RetourChargement rc = c.getMyRetourChargment();
			rc.setDateRetour(date);
			rc.setHeureRetour(heure);
			rc.setTotalCasierRetour(0);
			rc.setTotalColisRetour(0);
			rc.setTotalEmbRetour(0);
			rc.setTotalManquantEmb(0);
			rc.setTotalManquantProd(0);
			rc.setTotalProduitRC(0);
			//rc.setMagazinierEMB(magEmb);
			rc.setSecretaire(sec);
			rc.setTotalCasierProd(0);

		return retourChargementRepository.save(rc);
		
	}
	
	/*
	 * le retour de Produits d'une Livraison
	 */
	@Transactional
	public ReponseDto affecterProduitsRetourChargement(Chargement charg,float quantite, Produit produit, float qteBout) {
		ProduitsChargement lpc= produitsChargementRepository.findByMyChargementAndProduitPCAndIsValideTrue(charg, produit);
		ReponseDto r= new ReponseDto();
		if(lpc==null) {
			r.format(Code.FAILURE, "Ce produit ne fait pas partie de la liste des produits du chargement initial");
			return r;
		}
		
		if(quantite>lpc.getQuantitePC()) {
			r.format(Code.FAILURE, "Cette quantité est anormalement grande car superieure à la quantité initiale du Chargement");
			return r;
		}
		
		
		ProduitsRC prc2= produitsRCRepository.findByMyRetourChargmentAndProduitRCAndIsValideTrue(charg.getMyRetourChargment(),produit);
		
		totalPC=quantite*produit.getPrixChargement()+produit.getPrixChargement()*qteBout/produit.getFormat();
		
		if(prc2!=null) {
			prc2.setQuantiteRC(prc2.getQuantiteRC()+quantite);
			prc2.setTotalParProd(prc2.getTotalParProd()+totalPC);
			if(prc2.getNbBouteilleSup()+qteBout>=produit.getFormat()) {
				float a , c; int b;
				a=prc2.getNbBouteilleSup()+qteBout;
				b=(int) (a/produit.getFormat());//quotient 
				c=a - produit.getFormat()*b;//reste
				prc2.setQuantiteRC(prc2.getQuantiteRC()+b);
				prc2.setNbBouteilleSup(prc2.getNbBouteilleSup()+c);
			}
			prc2.setNbBouteilleSup(prc2.getNbBouteilleSup()+qteBout);
			produitsRCRepository.save(prc2);
		}else {
			//1- Créer une nouvelle ligne dans ProduitRC.
			ProduitsRC prc= new ProduitsRC(produit,quantite,qteBout,totalPC, charg.myRetourChargment);
			produitsRCRepository.save(prc);
		}
		
		
		//2- Mise à jour de RetourChargement
		RetourChargement rc=charg.getMyRetourChargment();
			rc.setDateRetour(date);
			rc.setHeureRetour(heure);
			rc.setTotalProduitRC(rc.getTotalProduitRC()+totalPC);//prix
			
			rc.setTotalColisRetour(rc.getTotalColisRetour()+quantite+qteBout*CONST_BOUT_CASIER);
			if (produit.getType().equals(TYPE_CASIER)) {
				rc.setTotalCasierProd(rc.getTotalCasierProd()+quantite+qteBout*CONST_BOUT_CASIER);
				rc.setTotalCasierRetour(rc.getTotalCasierRetour()+quantite+qteBout*CONST_BOUT_CASIER);
			}
				
		//3- Mise à jour dans Chargement
		if(rc.getTotalCasierProd()+rc.getTotalEmbRetour()==charg.getNbEmbChar()) {//rc.getTotalCasierRetour
			charg.setEmbOK(true);
			chargementRepository.save(charg);
		}
		
		r.format(Code.SUCCESS, retourChargementRepository.save(rc));
		return r;
	}
	
	@Transactional
	public ReponseDto annulerRetourChargement(RetourChargement rc) {
		ReponseDto r= new ReponseDto();
		if(rc.isValide()) {
			r.format(Code.FAILURE, "Retour Chargement déjà invalide");
			return r;
		}
		if(rc.isStockedEmb() || rc.isStockedProd()) {
			r.format(Code.FAILURE, "Ce Retour Chargement ne peut être annulé car ses Emballages/Produits Sont déjà stockés");
			return r;
		}
		
		Chargement c=rc.getMyChargement();
		
		List<ProduitsRC> lprc= produitsRCRepository.findByMyRetourChargmentAndIsValideTrue(rc);
		if(lprc!=null) {
			lprc.forEach(p->{
				p.setValide(false);
				produitsRCRepository.save(p);
			});
		}
		

		List<GestionRetourChargement> lgrc= gestionRetourChargementRepository.findByMyRetourChargmentAndIsValideTrue(rc);
		
		lgrc.forEach(grc->{
			if(grc.isNatureOpGRC()) {
				ArgentMvt am= argentMvtRepository.findByMyGestionRetourChargmentAndIsValideTrue(grc);
				am.setValide(false);
				argentMvtRepository.save(am); 
				c.setSolded(false);
			}else {
				List<EmballagesMvt> lem= emballagesMvtRepository.findByMyGestionRetourChargmentAndIsValideTrue(grc);
				lem.forEach(em->{
					em.setValide(false);
					emballagesMvtRepository.save(em);
				});
				c.setEmbOK(false);
			}
			chargementRepository.save(c);
			
			
			grc.setValide(false);
			gestionRetourChargementRepository.save(grc);
		});
		
		
		rc.setValide(false);
		r.format(Code.SUCCESS, retourChargementRepository.save(rc));
		return r;
		
	}
	
	/*
	 * Mettre les Produits d'un retour chargement au magazin.
	 */
	@Transactional
	public ReponseDto stockerProduitsRetourChargement(Chargement c,Personnel mag) {
		ReponseDto r=new ReponseDto();
		if(c.getMyRetourChargment().isStockedProd()) {
			r.format(Code.FAILURE, "Les produits associés à ce Retour de Chargement sont deja stockés");
			
			return r;
		}
		List<ProduitsRC> lp= produitsRCRepository.findByMyRetourChargmentAndIsValideTrue(c.getMyRetourChargment());
		lp.forEach(p->{
			ProduitMvt pm= new ProduitMvt(p.getProduitRC(), p.getQuantiteRC()+p.getNbBouteilleSup()*CONST_BOUT_CASIER, ENTREE_PRODUIT, date, heure, LIBELLE_RETOUR_PRODUIT,true,mag, null, null, c, c.getMyRetourChargment(),null);
			produitMvtRepository.save(pm);
		});
		RetourChargement rc=c.getMyRetourChargment();
		rc.setStockedProd(true);
		rc.setMagazinierPD(mag);
		r.format(Code.SUCCESS, retourChargementRepository.save(rc));
		return r;
	}
	
	@Transactional
	public ReponseDto annulerStockageProduitsRetourChargement(RetourChargement rc) {
		ReponseDto r=new ReponseDto();
		if(!rc.isValide()) {
			r.format(Code.FAILURE, "Ce Retour chargement est désactivé");
			return r;
		}
		if(!rc.isStockedProd()) {
			r.format(Code.FAILURE, "Les produits ne sont pas encore stockés");
			return r;
		}
		
		List<ProduitsRC> lprc= produitsRCRepository.findByMyRetourChargmentAndIsValideTrue(rc);
		if(lprc!=null) {
			lprc.forEach(prc->{
				Produit p = produitRepository.findByIdProduitAndIsValideTrue(prc.getProduitRC().getIdProduit());
				p.setQuantite(p.getQuantite()-prc.getQuantiteRC());
				produitRepository.save(p);
				
			});
		}
		
		List<ProduitMvt> lpm= produitMvtRepository.findByMyRetourChargmentAndIsValideTrue(rc);
		if(lpm!=null) {
			lpm.forEach(pm->{
				pm.setValide(false);
				produitMvtRepository.save(pm);
			});
		}
		
		
		
		rc.setStockedProd(false);
		
		r.format(Code.SUCCESS, retourChargementRepository.save(rc));
		
		return r;
		
	}
	
	
	/*
	 * Mettre les Produits d'un retour chargement au magazin.
	 */
	@Transactional
	public ReponseDto stockerProduitsRetourChargement(RetourChargement rc,Personnel mag) {
		ReponseDto r= new ReponseDto();
		
		if(rc.isStockedProd()) {
			r.format(Code.FAILURE, "Les produits associés à ce Retour de Chargement sont deja stockés");
			return r;
		}
		List<ProduitsRC> lp= produitsRCRepository.findByMyRetourChargmentAndIsValideTrue(rc);
		lp.forEach(p->{
			ProduitMvt pm= new ProduitMvt(p.getProduitRC(), p.getQuantiteRC()+p.getNbBouteilleSup()*CONST_BOUT_CASIER, ENTREE_PRODUIT, date, heure, LIBELLE_RETOUR_PRODUIT,true,mag, null, null, rc.getMyChargement(), rc,null);
			produitMvtRepository.save(pm);
		});
		
		rc.setStockedProd(true);
		rc.setMagazinierPD(mag);
		r.format(Code.SUCCESS, retourChargementRepository.save(rc));
		return r;
	}

	/*
	 * Retour des Emballages d'un chargement
	 */
	@Transactional
	public ReponseDto avanceEmballageRetourChargement(Chargement c,Personnel p, float nbEmbSABC, float nbEmbUCB, float nbEmbGUINNESS) {
		ReponseDto r= new ReponseDto();
		if(c.isEmbOK()) {
			r.format(Code.FAILURE, "Les emballages sont deja OK pour ce chargement");
			return r;
		}
		
		//1- Nouvelle ligne dans GestionRetourChargement
		GestionRetourChargement grc2= new GestionRetourChargement(false,nbEmbSABC+nbEmbUCB+nbEmbGUINNESS,c.getNbEmbChar()-(nbEmbSABC+nbEmbUCB+nbEmbGUINNESS),date,heure,p,c.getMyRetourChargment(),false);
		GestionRetourChargement grc=gestionRetourChargementRepository.save(grc2);
		
		//2- Des nouveaux enregistrements (3 au plus) dans EmballageMvt;
				if(nbEmbSABC!=0) {
					EmballagesMvt embSABC= new EmballagesMvt();
						embSABC.setDateOp(LocalDate.now());
						embSABC.setFournisseurEmb(fournisseurRepository.findByIdFournisseurAndIsValideTrue(ID_SABC));
						embSABC.setHeureOp(LocalTime.now());
						embSABC.setLibelleMvtEmb(LIBELLE_EMB_RETOUR_CHARGEMENT);
						embSABC.setNatureMvtEmb(ENTREE_EMB);
						embSABC.setQuantiteEmb(nbEmbSABC);
						embSABC.setMyGestionRetourChargment(grc);
					emballagesMvtRepository.save(embSABC);
				}
				if(nbEmbUCB!=0) {
					EmballagesMvt embUCB= new EmballagesMvt();
						embUCB.setDateOp(LocalDate.now());
						embUCB.setFournisseurEmb(fournisseurRepository.findByIdFournisseurAndIsValideTrue(ID_UCB));
						embUCB.setHeureOp(LocalTime.now());
						embUCB.setLibelleMvtEmb(LIBELLE_EMB_RETOUR_CHARGEMENT);
						embUCB.setNatureMvtEmb(ENTREE_EMB);
						embUCB.setQuantiteEmb(nbEmbUCB);
						embUCB.setMyGestionRetourChargment(grc);
					emballagesMvtRepository.save(embUCB);
				}
				if(nbEmbGUINNESS!=0) {
					EmballagesMvt embGUINNESS= new EmballagesMvt();
						embGUINNESS.setDateOp(LocalDate.now());
						embGUINNESS.setFournisseurEmb(fournisseurRepository.findByIdFournisseurAndIsValideTrue(ID_GUINNESS));
						embGUINNESS.setHeureOp(LocalTime.now());
						embGUINNESS.setLibelleMvtEmb(LIBELLE_EMB_RETOUR_CHARGEMENT);
						embGUINNESS.setNatureMvtEmb(ENTREE_EMB);
						embGUINNESS.setQuantiteEmb(nbEmbGUINNESS);
						embGUINNESS.setMyGestionRetourChargment(grc);
					emballagesMvtRepository.save(embGUINNESS);
				}
				
			//3- Mise à jour dans RetourChargement
				RetourChargement rc=c.getMyRetourChargment();
					rc.setTotalCasierRetour(rc.getTotalCasierRetour()+(nbEmbSABC+nbEmbUCB+nbEmbGUINNESS));
					rc.setTotalEmbRetour(rc.getTotalEmbRetour()+(nbEmbSABC+nbEmbUCB+nbEmbGUINNESS));
					rc.setTotalColisRetour(rc.getTotalColisRetour()+(nbEmbSABC+nbEmbUCB+nbEmbGUINNESS));
				retourChargementRepository.save(rc);
				
			//4- Mise à jour dans Chargement
				if(rc.getTotalCasierProd()+rc.getTotalEmbRetour()==c.getNbEmbChar()) {//rc.getTotalCasierRetour
					c.setEmbOK(true);
					chargementRepository.save(c);
				}
				
				r.format(Code.SUCCESS, grc);
			return r;
	}
	
	/*
	 * Mettre les Emballages au magazin
	 */
	@Transactional
	public ReponseDto stockerEmballageRetourChargement(GestionRetourChargement grc, Personnel magEmb) {
		ReponseDto r= new ReponseDto();
		if(grc.isNatureOpGRC()) {
			r.format(Code.FAILURE, "Cette opétation de Chargement ne correspond pas à celle des emballages");
			return r;	
		}
		
		if(grc.isManaged()) {
			r.format(Code.FAILURE, "Cette opération est deja traitée");
			return r;
		}
		
			MagEmballage meSABC= magEmballageRepository.etatMagEmbParFournisseur(ID_SABC);
			MagEmballage meUCB= magEmballageRepository.etatMagEmbParFournisseur(ID_UCB);
			MagEmballage meGUI= magEmballageRepository.etatMagEmbParFournisseur(ID_GUINNESS);
			MagDto md= new MagDto();
			List<EmballagesMvt> lem= emballagesMvtRepository.findByMyGestionRetourChargmentAndIsValideTrue(grc);
			lem.forEach(em->{
				if(em.getFournisseurEmb().getIdFournisseur()==ID_SABC) {
					meSABC.setQteMag(meSABC.getQteMag()+em.getQuantiteEmb());
					magEmballageRepository.save(meSABC);
					em.setMagasinierEMB(magEmb);
					emballagesMvtRepository.save(em);
					
					md.setQuantiteSABC(meSABC.getQteMag());
				}
				if(em.getFournisseurEmb().getIdFournisseur()==ID_UCB) {
					meUCB.setQteMag(meUCB.getQteMag()+em.getQuantiteEmb());
					magEmballageRepository.save(meUCB);
					em.setMagasinierEMB(magEmb);
					emballagesMvtRepository.save(em);
					
					md.setQuantiteUCB(meUCB.getQteMag());
				}
				if(em.getFournisseurEmb().getIdFournisseur()==ID_GUINNESS) {
					meGUI.setQteMag(meGUI.getQteMag()+em.getQuantiteEmb());
					magEmballageRepository.save(meGUI);
					em.setMagasinierEMB(magEmb);
					emballagesMvtRepository.save(em);
					
					md.setQuantiteGUI(meGUI.getQteMag());
				}
			});	
			grc.setManaged(true);
			gestionRetourChargementRepository.save(grc);
			
			r.format(Code.SUCCESS, md);
		return r;
	}
	
	@Transactional
	public ReponseDto annulerStockageEmballageRetourChargement(GestionRetourChargement grc) {
		ReponseDto r=new  ReponseDto();
		if(!grc.isValide()) {
			r.format(Code.FAILURE, "Cette opération est désactivée");
			return r;
		}
		if(!grc.isManaged()) {
			r.format(Code.FAILURE, "Cette opération n'est pas encore stockée");
			return r;
		}
		if(grc.isNatureOpGRC()) {
			r.format(Code.FAILURE, "Cette opération ne correspond pas à la gestion des emballages");
			return r;
		}
		
		List<EmballagesMvt> lem= emballagesMvtRepository.findByMyGestionRetourChargmentAndIsValideTrue(grc);
		if(lem!=null) {
			lem.forEach(em->{
				MagEmballage ma= magEmballageRepository.findByFournisseurAndIsValideTrue(em.getFournisseurEmb());
				ma.setQteMag(ma.getQteMag()-em.getQuantiteEmb());
				magEmballageRepository.save(ma);
				
				em.setValide(false);
				emballagesMvtRepository.save(em);
			});
		}
		
		
		
		grc.setManaged(false);
		
		r.format(Code.SUCCESS, gestionRetourChargementRepository.save(grc));
		
		return r;
	}
	
	/*
	 * Avance Argent RetourChargement
	 */
	@Transactional
	public ReponseDto nouveauVersementRetourChargement(Chargement c, Personnel sec, float montant) {
		ReponseDto r=new  ReponseDto();
		if(c.isSolded()) {
			r.format(Code.FAILURE, "Ce chargement est deja Soldé");
			return r;
		}
		
		//1- Nouvelle ligne dans GestionReourChargement
		GestionRetourChargement grc= new GestionRetourChargement(ENTREE_ARGENT,montant,c.getSoldeChar()-montant,date,heure,sec,c.getMyRetourChargment(),false);
		
		
		//2- Mise à jour dans RetourChargement
		RetourChargement rc= c.getMyRetourChargment();
		rc.setTotalVersement(rc.getTotalVersement()+montant);
		retourChargementRepository.save(rc);
		
		//3-Mise à jour dans Chargement
		if(rc.getTotalVersement() >= c.getSoldeChar()-rc.getTotalProduitRC()) {
			c.setSolded(true);
			chargementRepository.save(c);
		}
		
		r.format(Code.SUCCESS, gestionRetourChargementRepository.save(grc));
		return r;
	}
	
	@Transactional
	public ReponseDto annulerVersementRetourChargement(GestionRetourChargement grc) {
		ReponseDto r = new ReponseDto();
		if(!grc.isValide()) {
			r.format(Code.FAILURE, "Cette opération est désactivée");
			return r;
		}
		if(grc.isManaged()) {
			r.format(Code.FAILURE, "Impossible d'annuler ce versement car il est déjà encaissé ");
			return r;
		}
		if(!grc.isNatureOpGRC()) {
			r.format(Code.FAILURE, "Cette opération ne correspond pas à une opération de solde");
			return r;
		}
		
		ArgentMvt am=argentMvtRepository.findByMyGestionRetourChargmentAndIsValideTrue(grc);
		if(am!=null) {
			am.setValide(false);
			argentMvtRepository.save(am);
		}
		
		RetourChargement rc=grc.getMyRetourChargment();
		rc.setTotalVersement(rc.getTotalVersement()-grc.getAvanceGRC());
		retourChargementRepository.save(rc);
		
		grc.setValide(false);
		r.format(Code.SUCCESS, gestionRetourChargementRepository.save(grc));
		
		return r;
		
	}
	
	@Transactional
	public ReponseDto encaisserArgentRetourChargement(GestionRetourChargement grc,Personnel caissier) {
		ReponseDto r = new ReponseDto();
		
		if (!grc.isNatureOpGRC()) {//C'est une opération d'Emballage
			r.format(Code.FAILURE, "Cette opération ne correspond pas à une opération de solde");
			return r;
		}
		
		if(grc.isManaged()) {
			r.format(Code.FAILURE, "Cette opération est deja traitée");
			return r;
		}
		//Recuperation de l'ArgentMvt associé et affectation.
		//ArgentMvt am= argentMvtRepository.findByMyGestionRetourChargment(grc);
		ArgentMvt am= new ArgentMvt();
			am.setMontant(grc.getAvanceGRC());
			am.setDateOpArgent(date);
			am.setHeureOpArgent(heure);
			am.setResponsable(caissier);
			am.setMyGestionRetourChargment(grc);
			am.setLibelleArgent(LIBELLE_ARGENT_CHARGEMENT);
			am.setNatureMvt(ENTREE_ARGENT);
		ArgentMvt am2=argentMvtRepository.save(am);
		
		//Caisse journalière.
		CaisseJournaliere cj= caisseJournaliereRepository.findByDateBetweenAndIsValideTrue(date.plusDays(1),date.plusDays(1));
		if(cj==null) {
			cj= new CaisseJournaliere();
				cj.setDate(date);
				cj.setMontantEncaisse(grc.getAvanceGRC());
				cj.setMontantFinal(grc.getAvanceGRC());
				cj.setTaked(false);
				cj.setUsedType(UsedCaisseJounaliere.NOTUSED);
				cj.setMontantUsed(0);
		}else {
			    cj.setMontantEncaisse(cj.getMontantEncaisse()+grc.getAvanceGRC());
			    cj.setMontantFinal(cj.getMontantFinal()+grc.getAvanceGRC());
		}
		CaisseJournaliere cj2=caisseJournaliereRepository.save(cj);
		
		am2.setMyCaisseJournaliere(cj2);
		argentMvtRepository.save(am2);
		
		grc.setManaged(true);
		gestionRetourChargementRepository.save(grc);
		
		r.format(Code.SUCCESS, cj2);
	return	r;	
	}
	
	@Transactional
	public ReponseDto annulerEncaissementArgentRetourChargement(GestionRetourChargement grc) {
		ReponseDto r = new ReponseDto();
		if (!grc.isNatureOpGRC()) {//C'est une opération d'Emballage
			r.format(Code.FAILURE, "Cette opération ne correspond pas à une opération de solde");
			return r;
		}
		
		if(!grc.isManaged()) {
			r.format(Code.FAILURE, "Cette opération n'est pas encaissée");
			return r;
		}
		
		if(!grc.isValide()) {
			r.format(Code.FAILURE, "Cette opération est désactivée");
			return r;
		}
		
		ArgentMvt am=argentMvtRepository.findByMyGestionRetourChargmentAndIsValideTrue(grc);
		am.setValide(false);
		argentMvtRepository.save(am);
		
		CaisseJournaliere cj=am.getMyCaisseJournaliere();
			cj.setMontantEncaisse(cj.getMontantEncaisse()-grc.getAvanceGRC());
			cj.setMontantFinal(cj.getMontantFinal()-grc.getAvanceGRC());
		caisseJournaliereRepository.save(cj);
		
		grc.setManaged(false);
		
		r.format(Code.SUCCESS, gestionRetourChargementRepository.save(grc));
		return r;
		
	}
	
	
	/*
	 * Les manquants sont de deux catégories: argent, bouteille
	 * Acteur: SECRETAIRE
	 */
	@Transactional
	public RetourChargement calculManquantRetourChargement(Chargement c) {
		//1- Manquants emballages/bouteilles
		float m,a;
		RetourChargement rc= c.getMyRetourChargment();
		m=c.getNbEmbChar()-rc.getTotalCasierRetour();
		rc.setTotalManquantEmb(m);
		
		
		//2- Manquant Argent
		a=c.getSoldeChar()-(rc.getTotalProduitRC()+rc.getTotalVersement());
		rc.setTotalManquantProd(a);
		
		return retourChargementRepository.save(rc);
	}
	
	
	
	
	
	
	////////////FACTURE CHARGEMENT
	/*
	 * Initialiser Une facture issu d'un eventuel chargement.
	 * Acteur: Personnel(Chargeur)
	 */
	@Transactional
	public FacturesChargement initialiserFactureChargement(Chargement c, Client cl) {
		FacturesChargement fc= new FacturesChargement();
		//
		fc.setDateFC(date);
		fc.setHeureFC(heure);
		fc.setMyChargement(c);
		fc.setMyClient(cl);
		//fc.setMyDetailsFC(dfc);
			FacturesChargement fc2=facturesChargementRepository.save(fc);
			DetailsFC dfc=detailsFCRepository.save(new DetailsFC(fc2));
		//dfc.setMyFacturesChargement(fc2);
			DetailsFC dfc2=detailsFCRepository.save(dfc);
		fc2.setMyDetailsFC(dfc2);
		return facturesChargementRepository.save(fc2);
		
	}
	
	/*
	 * Affecter un produit à une facture revient à:
	 * 1- Ajouter une nouvelle ligne dans produitsFacture
	 * 2- Mettre à jour le totalSolde, totalRist, nbEmb et nbColis dans facture
	 * 3- Mettre à jour la ligne de Detailsfacture associée à la facture(les restesApayer) dans la table details_facture
	 */
	@Transactional
	public ReponseDto affecterProduitsFactureChargement(FacturesChargement fc,Produit produit,float quantite,float prix, float rist) {
		ReponseDto r= new ReponseDto();
		ProduitsChargement pc= produitsChargementRepository.findByMyChargementAndProduitPCAndIsValideTrue(fc.getMyChargement(), produit);
		if(pc==null) {
			r.format(Code.FAILURE, "Ce produit ne fais pas partie de ce  Chargement.");
			return r;
		}
		
		if (quantite>pc.getQuantitePC()-pc.getQuantiteVendu()) {
			//Affectation impossible
			System.out.println("Vous ne disposez pas cette quantité");
			return null;
		}
		
		Client c=fc.getMyClient();
		PrixProduits pp=prixProduitsRepository.findByMyClientAndProduitAndIsValideTrue(c, produit).get(0);
		
		ProduitsFC pf3=produitsFCRepository.findByMyFacturesChargementAndProduitFCAndIsValideTrue(fc,produit);
		
		ProduitsFC pfc5;
		if(pf3!=null) {
			pf3.setQteFC(pf3.getQteFC()+quantite);
			if(prix==0) {
				pf3.setPrixTotalFC(pf3.getPrixTotalFC()+pp.getPrixClient()*quantite);
				pf3.setRistFC(pf3.getRistFC()+pp.getRistProd());
			}else {
				pf3.setPrixTotalFC(pf3.getPrixTotalFC()+prix*quantite);
				pf3.setRistFC(pf3.getRistFC()+rist*quantite);
			}
			 pfc5 =produitsFCRepository.save(pf3);
		
		}else {
			ProduitsFC pfc= new ProduitsFC();
			pfc.setMyFacturesChargement(fc);
			pfc.setProduitFC(produit);
			pfc.setQteFC(quantite);
			if(prix==0) {
				pfc.setPrixTotalFC(pp.getPrixClient()*quantite);
				pfc.setRistFC(pp.getRistProd()*quantite);
			}else {
				pfc.setPrixTotalFC(prix*quantite);
				pfc.setRistFC(rist*quantite);
			}
			pfc5=produitsFCRepository.save(pfc);
			
		}
		
		
		
		//2- Mise à jour des données dans la facture.
		fc.setNbColisFC(fc.getNbColisFC()+quantite);
		if(produit.getType().equals(TYPE_CASIER)) {
			fc.setNbEmbFC(fc.getNbEmbFC()+quantite);
		}
		fc.setSoldeFC(fc.getSoldeFC()+pfc5.getPrixTotalFC());
		fc.setTotalRistFC(fc.getTotalRistFC()+pfc5.getRistFC());
		facturesChargementRepository.save(fc);
		
		//3- Mise à jour dans detailsFFC
		DetailsFC dfc= fc.getMyDetailsFC();
		if(produit.getType().equals(TYPE_CASIER)) {
			dfc.setTotalresteEmb(quantite);
		}
		dfc.setTotalResteSoldeFC(dfc.getTotalResteSoldeFC()+pfc5.getPrixTotalFC());
		detailsFCRepository.save(dfc);
		
		//4- Mise à jour de quantiteVendu du produit en question dans ProduitChargement
		ProduitsChargement pc2=produitsChargementRepository.findByProduitPCAndIsValideTrue(produit);
			pc2.setQuantiteVendu(pc2.getQuantiteVendu()+quantite);
		produitsChargementRepository.save(pc2);
		
		r.format(Code.SUCCESS, pfc5);
		
		return r;
		
	}
	
	/*
	 * Terminer une FactureChargement (Facture issu d'un Chargement)
	 */
	@Transactional
	public ReponseDto terminerFactureChargement(FacturesChargement fc) {
		CumulRistClients newRist2= cumulRistClientsRepository.findByMyFacturesChargementAndIsValideTrue(fc);
		ReponseDto r= new ReponseDto();
		if(newRist2==null) {
			//5- Sauvegarde de la ristourne du client
			CumulRistClients newRist= new CumulRistClients();
				newRist.setClient(fc.getMyClient());
				newRist.setDate(fc.getDateFC());
				newRist.setMyFacturesChargement(fc);
				newRist.setMontant(fc.getTotalRistFC());
				newRist.setPayed(false);
			
			r.format(Code.SUCCESS, cumulRistClientsRepository.save(newRist));
			return r;
		}else {
			r.format(Code.FAILURE, "Les ristounes de cette facture sont deja enregistrées");
			return r;
		}
		
	}
	
	/*
	 * L'avance sur une facture suit le même principe que l'avance sur une livraison.
	 * ARGENT:
	 * 1- Un nouvel enregistrement dans GestionFC;
	 * 
	 * 3- Mise à jour dans DetailsFC;
	 * 4- Mise à jour de isEmbOk et isSolde dans Facture
	 *
	 */
	@Transactional
	public ReponseDto avanceArgentFactureChargement(FacturesChargement fc, float montant) {
		ReponseDto r= new ReponseDto();
		if(fc.isSolded()) {
			r.format(Code.FAILURE, "Cette facture est deja soldée");
			return r;
		}
		
		if(fc.getMyDetailsFC().getTotalResteSoldeFC()<montant) {
			r.format(Code.FAILURE, "Pour cette facture, il ne reste que "+fc.getMyDetailsFC().getTotalResteSoldeFC()+ "fcfa à verser.");
			return r;
		}
		//1- Un nouvel enregistrement dans GestionFC;
		GestionFC gfc= new GestionFC();
			gfc.setAvanceFC(montant);
			gfc.setDateGFC(date);
			gfc.setHeureGFC(heure);
			gfc.setMyFacturesChargement(fc);
			gfc.setNatureOpFC(IS_ARGENT);
			gfc.setManaged(false);//Bien voir le rôle de cet attribut dans la Gestion d'un chargement
			
		//2- Mise à jour de DetailsFC
		DetailsFC dfc=fc.getMyDetailsFC();
			dfc.setTotalAvanceSoldeFC(dfc.getTotalAvanceSoldeFC()+montant);
			dfc.setTotalResteSoldeFC(dfc.getTotalResteSoldeFC()-montant);
		detailsFCRepository.save(dfc);
		
		 //3- Mise à jour de isEmbOk et isSolde
		if(dfc.getTotalAvanceSoldeFC()>=fc.getSoldeFC()) {
			fc.setSolded(true);
			facturesChargementRepository.save(fc);
		}
		r.format(Code.SUCCESS, gestionFCRepository.save(gfc));
		return r;
	}
	
	@Transactional
	public CaisseJournaliere encaisserArgentFactureChargement(GestionFC gfc, Personnel caissier) {
		/*if (!gfc.isNatureOpFC()) {//C'est une opération d'Emballage
			return null;
		}
		//création de l'ArgentMvt associé et affectation 
		ArgentMvt am= new ArgentMvt();
			am.setMontant(gfc.getAvanceFC());
			am.setDateOpArgent(date);
			am.setHeureOpArgent(heure);
			am.setResponsable(caissier);
			am.set(gf);
			ArgentMvt am2=argentMvtRepository.save(am);
		
		//Caisse journalière
		CaisseJournaliere cj= caisseJournaliereRepository.findByDateBetween(date.plusDays(1),date.plusDays(1));
		if(cj==null) {
			cj= new CaisseJournaliere();
				cj.setDate(date);
				cj.setMontantEncaisse(gf.getAvanceGF());
				cj.setMontantDepenses(0);
				cj.setMontantFinal(gf.getAvanceGF());
				cj.setTaked(false);
				cj.setUsedType(UsedCaisseJounaliere.NOTUSED);
		}else {
			cj.setMontantEncaisse(cj.getMontantEncaisse()+gf.getAvanceGF());
		}
		CaisseJournaliere cj2=caisseJournaliereRepository.save(cj);
		
		am2.setMyCaisseJournaliere(cj2);
		argentMvtRepository.save(am2);
		
		gf.setManaged(true);
		gestionFactureRepository.save(gf);
		
	return	cj2;
		*/
		return null;
	}
	
	/*
	 * Pour effectuer l'avance sur une factureChargement
	 */
	@Transactional
	public ReponseDto avanceEmballageFactureChargement(FacturesChargement fc, float nbEmb) {
		ReponseDto r= new ReponseDto();
		if(fc.isEmbOk()) {
			r.format(Code.FAILURE, "Cette facture est deja soldée en Emballage");
			return r;
		}
		
		if(fc.getMyDetailsFC().getTotalresteEmb()<nbEmb) {
			r.format(Code.FAILURE, "Pour cette facture, il ne reste que "+ fc.getMyDetailsFC().getTotalresteEmb() +" emballages à remètre.");
			return r;
		}
		//1- Un nouvel enregistrement dans GestionFC;
				GestionFC gfc= new GestionFC();
					gfc.setAvanceFC(nbEmb);
					gfc.setDateGFC(date);
					gfc.setHeureGFC(heure);
					gfc.setMyFacturesChargement(fc);
					gfc.setNatureOpFC(IS_EMB);
					gfc.setManaged(false);
					
		//2- Mise à jour de DetailsFC
				DetailsFC dfc=fc.getMyDetailsFC();
					dfc.setTotalAvanceEmb(dfc.getTotalAvanceEmb()+nbEmb);
					dfc.setTotalresteEmb(dfc.getTotalresteEmb()-nbEmb);
				detailsFCRepository.save(dfc);
					
		//3- Mise à jour de isEmbOk et isSolde
				if(dfc.getTotalAvanceEmb()>=fc.getNbEmbFC()) {
					fc.setEmbOk(true);
					facturesChargementRepository.save(fc);
				}
				r.format(Code.SUCCESS, gestionFCRepository.save(gfc));
			return	r;		
	}
	
	
	////////////////////////////////////////////////////////COMMANDE///////////////////////////////////////
	@Transactional
	public Commande initialiserCommande(Client c) {
		Commande com= new Commande();
			com.setDateCommande(date);
			com.setHeureCommande(heure);
			com.setMyClient(c);
			com.setNbCasiers(0);
			com.setNbEmbCom(0);
			com.setStatus(NON_LIVREE);
		return commandeRepository.save(com);
	}
	
	@Transactional
	public ProduitsCommande affecterProduitsCommande(Commande com, Client c, Produit produit, float quantite) {
		ProduitsCommande pc= new ProduitsCommande();
			pc.setMyCommande(com);
			pc.setQtePordCom(quantite);
			pc.setProduitProdCom(produit);
			pc.setNbColisProdCom(quantite);
			if(produit.getType().equals(TYPE_CASIER)) {
				pc.setNbEmbProdCom(quantite);
			}
		
		//Mise à jour de la commande assocciée dans Commande.
			com.setNbCasiers(com.getNbCasiers()+quantite);
			if(produit.getType().equals(TYPE_CASIER)) {
				com.setNbEmbCom(com.getNbEmbCom()+quantite);
			}
			commandeRepository.save(com);
			
			return produitsCommandeRepository.save(pc);
	}
	/*
	 * De l'initialisation à l'affectation des produits
	 */
	@Transactional
	public Facture initialiserFactureFromCommande(Commande com, Personnel sec) {
		//penser à remplir automatiquement ProduitsFacture des produits provenant de Produtis Commande(Paramètre(pouvant être null)).
		Facture f=factureRepository.findByIdFactureAndIsValideTrue(this.initialiserFactureClient(com.getMyClient(), sec));
		List<ProduitsCommande> lpc= produitsCommandeRepository.findByMyCommandeAndIsValideTrue(com);
		lpc.forEach(pc->{
			PrixProduits pp= prixProduitsRepository.findByMyClientAndProduitAndIsValideTrue(com.getMyClient(),pc.getProduitProdCom()).get(0);
			 this.affecterProduitFacture(f, pc.getQtePordCom(), pc.getProduitProdCom(),pp.getPrixClient(), pp.getRistProd());
		});
		return factureRepository.findByIdFactureAndIsValideTrue(f.getIdFacture());
		
	}
	
	
	
	///////////////////////////////////DEPENSES , CAISSE & CAISSE JOURNALIÈRE/////////////////////////////////////////////////
	
	
	/*
	 * Défnir son capital
	 * Acteur: Administrateur/DG
	 */
	@Transactional
	public Caisse definirCapital(float c) {
		Caisse caisse=new Caisse();
		caisse.setCapital(c);
		caisse.setMontantCaisse(c);
		return caisseRepository.save(caisse);
	}
	
	@Transactional
	public ReponseDto updateCapital(float c){
		ReponseDto r= new ReponseDto();
		if(c<=0) {
			r.format(Code.FAILURE, "Entrez un montant valide");
			return r;
		}
		Caisse caisse=caisseRepository.findByIdCaisseAndIsValideTrue(ID_CAISSE);
		if(caisse.getCapital()!=caisse.getMontantCaisse()) {
			r.format(Code.FAILURE, "Mise à jour Impossible");
			return r;
		}
		caisse.setCapital(c);
		r.format(Code.SUCCESS, caisseRepository.save(caisse));
		return r;
	}
	/*
	 * Ajouter/Diminuer son Capital
	 * Acteur: Administrateur/DG
	 */
	@Transactional
	public ReponseDto operationCaisse(float argent,boolean nature, String sourceOuDestination,Personnel res) {
		Date date= new Date();
		LocalTime	heure= LocalTime.now();
		ReponseDto r= new ReponseDto();
		System.out.println(date);
		System.out.println(heure);
		if(argent<=0) {
			r.format(Code.FAILURE, "Veillez saisir un montant valide");
			return r;
		}
		
		if(res==null) {
			r.format(Code.FAILURE, "Ce personnel est invalide");
			return r;
		}
		//3-Mettre à jour dans Caisse
				Caisse c= caisseRepository.findByIdCaisseAndIsValideTrue(ID_CAISSE);
					if(nature) {
						c.setCapital(c.getCapital()+argent);
						c.setMontantCaisse(c.getMontantCaisse()+argent);
					}else {
						if(c.getMontantCaisse()>=argent) {
							c.setCapital(c.getCapital()- argent);
							c.setMontantCaisse(c.getMontantCaisse()- argent);
						}else {
							r.format(Code.FAILURE, "retrait Impossible");
							return r;
						}
					}
		
		//1- Creer une ligne dans GestionCaisse
		GestionCaisse gc= new GestionCaisse();
			gc.setDate(date);
			gc.setMontant(argent);
			gc.setNatureOp(nature);
			gc.setSourceOuDestination(sourceOuDestination);
		GestionCaisse gc2= gestionCaisseRepository.save(gc);
			
		//2-Creer Une ligne dans InterfaceCaisse
		InterfaceCaisse ic=new InterfaceCaisse();
			ic.setDateOperation(this.date);
			ic.setMontantOperation(argent);
			ic.setMyGestionCaisse(gc2);
			ic.setNatureOperation(nature);
			ic.setCaissiere(res);//la Caissière peut aussi être le Responsable
		gc2.setMyInterfaceCaisse(interfaceCaisseRepository.save(ic));
		gestionCaisseRepository.save(gc2);
		
		
			r.format(Code.SUCCESS, caisseRepository.save(c));
		return	r;
	}
	//LORSQU'ON EFFECTUE UN DECAISSEMENT, L'OBJET(LES CLASSES GESTIONS) DOIT ÊTRE DONNÉ AU PRÉALABLE 
	/*(POINT FOCAL N°  1)
	 * Décaisser Argent de la Caisse:
	 * 1- Mettre à jour montantCaisse sans toucher capital
	 * 2- Créer une ligne dans InterfaceCaisse
	 * 3- Créer une ligne dans ArgentMvt
	 * 4-(opt) créer une ligne dans GestionLivraison/Dépenses.
	 * NB: Doit renvoyer Un InterfaceCaisse (avec les clés étrangères vides).
	 * Et doit être habillée 
	 */
	@Transactional
	private ReponseDto decaisserArgentFromCaisse(float montant, Personnel responsable) {
		ReponseDto r= new ReponseDto();
		
		if(responsable==null) {
			r.format(Code.FAILURE, "Ce personnel n'existe pas");
			return r;
		}
		
		if(montant<=0) {
			r.format(Code.FAILURE, "Entrez un montant valide");
			return r;
		}
		//1- Mettre à jour montantCaisse sans toucher capital
		Caisse c= caisseRepository.findByIdCaisseAndIsValideTrue(ID_CAISSE);
		if(montant<=c.getMontantCaisse()) {
			c.setMontantCaisse(c.getMontantCaisse()-montant);
		}else {
			r.format(Code.FAILURE, "Impossile de faire ce decaissement");
			return r;
		}
		caisseRepository.save(c);
		//2-Créer une ligne dans InterfaceCaisse
		InterfaceCaisse ic= new InterfaceCaisse();
			ic.setDateOperation(date);
			ic.setMontantOperation(montant);
			ic.setNatureOperation(SORTIE_ARGENT);
			ic.setCaissiere(responsable);
		InterfaceCaisse ic2=interfaceCaisseRepository.save(ic);
		
		//3- Créer une ligne dans ArgentMvt
		ArgentMvt am= new ArgentMvt();
			am.setDateOpArgent(date);
			am.setHeureOpArgent(heure);
			am.setLibelleArgent(LIBELLE_DECAISSEMENT);
			am.setMontant(montant);
			am.setNatureMvt(SORTIE_ARGENT);
			am.setMyInterfaceCaisse(ic2);
			am.setResponsable(responsable);
		ArgentMvt am2=argentMvtRepository.save(am);
			ic2.setMyArgentMvtPourDecaisser(am2);	
			interfaceCaisseRepository.save(ic2);	
			
			r.format(Code.SUCCESS, am2);
			return r;
	}
	
	
	@Transactional
	public ReponseDto annulerDecaissementArgentFromCaisse(ArgentMvt am){
		ReponseDto r= new ReponseDto();
		if(am==null) {
			r.format(Code.FAILURE, "Mouvement d'argent non valide");
			return r;
		}
		
		if(!am.isValide()) {
			r.format(Code.FAILURE, "Mouvement d'argent non valide.");
			return r;
		}
		
		if(am.getNatureMvt() || am.getMyGestionFacture()!=null) {
			r.format(Code.FAILURE, "Ce Mouvement d'argent ne concerne pas un décaissement.");
			return r;
		}
		
		if(am.getMyInterfaceCaisse()==null || am.getMyCaisseJournaliere()!=null) {
			r.format(Code.FAILURE, "Ce Mouvement d'argent ne concerne pas un décaissement de la caisse.");
			return r;
		}
		
		InterfaceCaisse ic= interfaceCaisseRepository.findByIdIntCaisseAndIsValideTrue(am.getMyInterfaceCaisse().getIdIntCaisse());
		ic.setValide(false);
		interfaceCaisseRepository.save(ic);
		
		Caisse c= caisseRepository.findByIdCaisseAndIsValideTrue(ID_CAISSE);
		c.setMontantCaisse(c.getMontantCaisse()+am.getMontant());
		caisseRepository.save(c);
		
		am.setValide(false);
		argentMvtRepository.save(am);
		
		r.format(Code.SUCCESS, "Annulation de decaissement effectué avec succes.");
		return r;
		
	}
	
	
	
	
	/*
	 * Le decaissement de la CaisseJournalière
	 * En supposant que l'ArgentMvt possède déljà la clé erangère(De Livraison Ou de Depenses)
	 * Acteur: CAISSIER(E)
	 * NB: cette fonction doit être habillée, et prendre comme paramètre GestionLivraison ou Depense
	 */
	@Transactional
	private ReponseDto decaisserArgentFromCaisseJournaliere(float montant, Personnel responsable) {
		ReponseDto r= new ReponseDto();
		//Retrait proprepement dit
		montant2=montant;
		List<CaisseJournaliere> lcj=caisseJournaliereRepository.findByMontantFinalNotAndIsTakedFalse(0);
		
		
		
		lcj.forEach(cj->{
			sommeCJ = sommeCJ+cj.getMontantFinal();
		});
		if (sommeCJ>=montant2){
			//ArgentMvt
			System.out.println("Somme: "+sommeCJ+"\t montant: "+montant2);
			ArgentMvt am= new ArgentMvt();
				am.setDateOpArgent(date);
				am.setHeureOpArgent(heure);
				am.setLibelleArgent(LIBELLE_DECAISSEMENT.concat(" de Caisse Journalière"));
				am.setMontant(montant);
				am.setNatureMvt(SORTIE_ARGENT);
				am.setResponsable(responsable);
			ArgentMvt am2=	argentMvtRepository.save(am);
			System.out.println("Somme: "+sommeCJ+"\t montant: "+montant2);
			int i=0;
			while(montant2!=0) {
				CaisseJournaliere cj=lcj.get(i);
				if(cj.getMontantFinal()>=montant2) {//Au cas où une seule ligne suffit.
					cj.setMontantFinal(cj.getMontantFinal()-montant2);
					cj.setUsedType(UsedCaisseJounaliere.PARTIALUSED);
					cj.setMontantUsed(cj.getMontantUsed()+montant2);
					cj.setMontantDepenses(cj.getMontantDepenses()+montant2);
					montant2=0;
				}else{//Au cas où plusieurs lignes sont nécessaires.
					cj.setMontantFinal(0);
					cj.setMontantUsed(cj.getMontantUsed()+cj.getMontantFinal());
					cj.setUsedType(UsedCaisseJounaliere.USED);
					cj.setMontantDepenses(cj.getMontantDepenses()+cj.getMontantFinal());
					montant2=montant2-cj.getMontantFinal();//Mise à jour de montant2.
				}
				cj.setDecaissementCJ(am2);
				am2.setMyCaisseJournaliere(caisseJournaliereRepository.save(cj));
				argentMvtRepository.save(am2);
				i++;
			}
			
			
		
			 r.format(Code.SUCCESS,caisseJournaliereRepository.findByDecaissementCJAndIsValideTrue(am2));
			 return r;
		}else {
			r.format(Code.FAILURE, "Retrait impossible car solde insufisant");
			return r;
		}
	}
	/*
	@Transactional
	private ReponseDto annulerDecaissementArgentFromCaisseJournaliere(ArgentMvt am) {
		ReponseDto r= new ReponseDto();
		if(am==null) {
			r.format(Code.FAILURE, "Mouvement d'argent non valide");
			return r;
		}
		
		if(!am.isValide()) {
			r.format(Code.FAILURE, "Mouvement d'argent non valide.");
			return r;
		}
		
		if(am.getNatureMvt() || am.getMyGestionFacture()!=null) {
			r.format(Code.FAILURE, "Ce Mouvement d'argent ne concerne pas un décaissement de caisse journalière.");
			return r;
		}
		
		if(am.getMyInterfaceCaisse()!=null || am.getMyCaisseJournaliere()==null) {
			r.format(Code.FAILURE, "Ce Mouvement d'argent ne concerne pas un décaissement de caisse journalière.");
			return r;
		}
		
		List<CaisseJournaliere> lcj= caisseJournaliereRepository.findByDecaissementCJAndIsValideTrue(am);
		lcj.forEach(cj->{
			if(cj.getMontantEncaisse()-am.getMontant()>0) {//only one line can manage
				cj.setMontantDepenses(cj.getMontantDepenses()-am.getMontant());
				cj.setMontantFinal(cj.getMontantFinal()+am.getMontant());
				cj.setMontantUsed(cj.getMontantUsed()-am.getMontant());
				if(cj.getMontantDepenses()==0 || cj.getMontantUsed()==0) {
					cj.setUsedType(UsedCaisseJounaliere.NOTUSED);
				}
			}else {//severals lines manage
				cj.setMontantDepenses(cj.getMontantDepenses()-am.getMontant());
				cj.setMontant
			}
		});
	
	}*/
	
	/*
	 * Cette fonction est une tâche du caissier(e) pour decaisser de l'argent pour acquiter(avancer) le
	 * solde d'une livraison.
	 * Acteur: CAISSIER(E)
	 */
	@Transactional
	public ReponseDto decaisserAvanceLivraisonDeCaisse(GestionLivraison gl, Personnel caissier) {
		ReponseDto r= new ReponseDto();
		
		
		if(gl==null) {
			r.format(Code.FAILURE, "Cette opération de livraison n'existe pas");
			return r;
		}
		
		if(caissier==null) {
			r.format(Code.FAILURE, "Ce personnel n'existe pas");
			return r;
		}
		
		if(!gl.isValide()) {
			r.format(Code.FAILURE, "Cette opération de livraison n'existe pas");
			return r;
		}
		
		if(!caissier.isValide()) {
			r.format(Code.FAILURE, "Ce personnel n'existe pas");
			return r;
		}
		
	
		
		ReponseDto res=this.decaisserArgentFromCaisse(gl.getAvanceGL(),caissier);
		
		if((boolean) res.getResponse().get("status")) {
			ArgentMvt am=(ArgentMvt) res.getResponse().get("data");
			am.setMyGestionLivraison(gl);
			if(gl.isDeconsigned()) {
				am.setLibelleArgent(am.getLibelleArgent().concat(LIBELLE_AVANCE_LIVRAISON).concat(" ").concat(gl.getPersonnelExt().getMyFournisseur().getNom()).concat(" (Consigne)."));
			}else {
				am.setLibelleArgent(am.getLibelleArgent().concat(LIBELLE_AVANCE_LIVRAISON).concat(" ").concat(gl.getPersonnelExt().getMyFournisseur().getNom()));
			}
			
			ArgentMvt am2=argentMvtRepository.save(am);
			gl.setMyArgentMvt(am2);
			gestionLivraisonRepository.save(gl);
			
			ArgentMvtDto amdto= new ArgentMvtDto(am2);
			r.format(Code.SUCCESS, amdto.mapObjectToHashMap(am2));
			return r;
		}else {
			r.format(Code.FAILURE, "Impossible de faire ce decaissement de la Caisse car solde insufisant");
			return r;
		}
	}
	/*
	 * Cette fonction est une tâche du caissier(e) pour decaisser de l'argent pour acquiter(avancer) le
	 * solde d'une livraison.
	 * Acteur: CAISSIER(E)
	 */
	@Transactional
	public ReponseDto decaisserAvanceLivraisonDeCaisseJournaliere(GestionLivraison gl, Personnel caissier) {
		ReponseDto r= new ReponseDto();
		
		if(gl==null) {
			r.format(Code.FAILURE, "Opération de Gestion Livraison Invalide/inexistant");
			return r;
		}
		if(caissier==null) {
			r.format(Code.FAILURE, "Personnel de caisse invalide/inexistant");
			return r;
		}
		
		
		if(!gl.isValide()) {
			r.format(Code.FAILURE, "Opération de Gestion Livraison Invalide/inexistant");
			return r;
		}
		if(!caissier.isValide()) {
			r.format(Code.FAILURE, "Personnel de caisse invalide/inexistant");
			return r;
		}
		
		if(gl.isManaged()) {
			r.format(Code.FAILURE, "Cette opération de Gestion Livraison est déjà gérée.");
			return r;
		}
		if(!gl.getNatureOperation()) {
			r.format(Code.FAILURE, "Cette opération de Gestion Livraison ne concerne pas les soldes mais les emballages.");
			return r;
		}
		ReponseDto res=this.decaisserArgentFromCaisseJournaliere(gl.getAvanceGL(),caissier);
		
		if((boolean) res.getResponse().get("status")) {
			List<CaisseJournaliere> lcj= (List<CaisseJournaliere>)res.getResponse().get("data");
			CaisseJournaliere cj= lcj.get(0);
			gl.setMyArgentMvt(cj.getDecaissementCJ());
			gl.setManaged(true);
			gestionLivraisonRepository.save(gl);
			
			ArgentMvtDto amdto= new ArgentMvtDto(gl.getMyArgentMvt());
			 
			r.format(Code.SUCCESS, amdto.mapObjectToHashMap(gl.getMyArgentMvt()));
			
			return r;
			
		}else {
			r.format(Code.FAILURE, "Impossible de faire ce retrait de la caisse journalière");
			return r;
		}
	}
	/*
	 * On peut donc maintenant enregistrer une dépense concernant le depôt.
	 * ça peut être : frais de depânage d'un patrimoine, carburants, ration journalière des personnels.
	 * NB: la source d'une dépense peut être la caisse principale(POINT FOCAL N°1) ou la Caissse journalière
	 * 
	 * 
	 * 1- Créer un ArgentMvt en mettant à jour montantDepense dans CaisseJournalière.
	 * OU Récuperer le Retour de la méthode this.decaisserArgentCaissePourAction() et mettre à jour le myDepenses
	 * 2- On crée une ligne dans Depenses(Cette instruction peut passer avant le 1.) 
	 * Acteur: SECRETAIRE
	 */
	@Transactional
	public Depenses enregistrerDepense(float montantDepense, String motif, Personnel responsable, Personnel sec) {
		/*InterfaceCaisse ic= new InterfaceCaisse();boolean res = true;
		if(source) {
			 ic= decaisserArgentFromCaisse( montantDepense);
		}else {
			 res= decaisserArgentFromCaisseJournaliere(montantDepense);
		}
		
		if(( ic!=null) || !res) {
			return null;
		}*/
		
		Depenses d= new Depenses();
			d.setDateDepense(date);
			d.setHeureDepense(heure);
			d.setMotif(motif);
			d.setMontant(montantDepense);
			d.setResponsable(responsable);
			d.setSecretaire(sec);
			d.setPayed(false);
			
			return depensesRepository.save(d);
		}
	
	/*
	 * Decaisser de l'argent de la caisse. il faut au préalable faire enregistrer la depense par le secretaire.
	 * Acteur: CAISSIER(E)
	 */
	@Transactional
	public ReponseDto decaisserDepenseFromCaisse(Depenses d, Personnel caissier) {
		ReponseDto res=this.decaisserArgentFromCaisse(d.getMontant(), caissier);
		ReponseDto r= new ReponseDto();
		if(!(boolean) res.getResponse().get("status")) {
			r.format(Code.FAILURE, "Impossible de decaisser le montant de cette depense de la caisse");
			return r;
		}
		ArgentMvt am= (ArgentMvt) res.getResponse().get("data");
				am.setMyDepenses(d);
				am.setLibelleArgent(LIBELLE_ARGENT_DEPENSE);
		argentMvtRepository.save(am);
				d.setMyArgentMvt(am);
				d.setPayed(true);
		depensesRepository.save(d);
		r.format(Code.SUCCESS, am.getMyInterfaceCaisse());
		return r;
	}
	
	@Transactional
	public ReponseDto annulerDecaissementDepenseFromCaisse(Depenses d) {
		ReponseDto r= new ReponseDto();
		
		if(d==null) {
			r.format(Code.FAILURE, "Dépense invalide/inexistant.");
			return r;
		}
		
		if(!d.isValide()) {
			r.format(Code.FAILURE, "Dépense invalide/inexistant.");
			return r;
		}
		ArgentMvt am= argentMvtRepository.findByIdArgentMvtAndIsValideTrue(d.getMyArgentMvt().getIdArgentMvt());
		if(!d.isPayed || am==null)  {
			r.format(Code.FAILURE, "Cette dépense n'est pas encore décaissée");
			return r;
		}
		
		ReponseDto res=this.annulerDecaissementArgentFromCaisse(am);
		
		if(!(boolean) res.getResponse().get("status")) {
			String resString= (String)res.getResponse().get("errors");
			r.format(Code.FAILURE, "Impossible d'annuler le decaissement de cette depense de la caisse"+"\nError nested:"+resString);
			return r;
		}else {
			am.setValide(false);
			argentMvtRepository.save(am);
			
			d.setPayed(false);
			depensesRepository.save(d);
			
			r.format(Code.SUCCESS, "Opération d'annulation réalisée avec succes");
			return r;
		}
	}
	
	/*
	 * Decaisser de l'argent de la caisse Journaliere. il faut au préalable faire enregistrer la depense par le secretaire.
	 * Acteur: CAISSIER(E)
	 */
	@Transactional
	public ReponseDto decaisserDepenseFromCaisseJournaliere(Depenses d, Personnel caissier) {
		
		ReponseDto r= new ReponseDto();
		if(d.isPayed()) {
			r.format(Code.FAILURE, "Cette depense a déjà été decaissée.");
			return r;
		}
		
		ReponseDto res=this.decaisserArgentFromCaisseJournaliere(d.getMontant(), caissier);
		
		if(!(boolean) res.getResponse().get("status")) {
			r.format(Code.FAILURE, "Impossible de decaisser le montant de cette depense de la caisse Journaliere");
			return r;
		}
		 List<CaisseJournaliere> lcj=	(List<CaisseJournaliere>)res.getResponse().get("data");
		 ArgentMvt am=lcj.get(0).getDecaissementCJ();	
		 	am.setMyDepenses(d);
			am.setLibelleArgent(LIBELLE_ARGENT_DEPENSE);
		argentMvtRepository.save(am);
			d.setMyArgentMvt(am);
			d.setPayed(true);;
			depensesRepository.save(d);
			r.format(Code.SUCCESS, caisseJournaliereRepository.findByDecaissementCJAndIsValideTrue(am));
		return r;
	}
	
		
	/*
	 * Faire une sauvegarde de caisse Journalière.
	 * NB: Cette methode, il serait idéal si elle est automatique(elle s'execute par exemple tous les 18h) et 
	 * manuelle pour donner la possiblite au CAISSIER(E) de savoir quel montant elle a en caisse.
	 * 
	 * Acteur: CAISSIER(E)
	 * NYU(Not Yet Used)
	 */
	@Transactional
	public CaisseJournaliere enregistrerCaisseJournaliere(LocalDate d) {
		CaisseJournaliere cj;
		CaisseJournaliere cj2= new CaisseJournaliere();
		CaisseJournaliere cj3=	caisseJournaliereRepository.findByDateBetweenAndIsValideTrue(d.plusDays(1),d.plusDays(1));
		if(cj3!=null) {
			cj=cj3;
		}else {
			 cj= caisseJournaliereRepository.save(cj2);
		}
		
		List<ArgentMvt> la=this.listeArgentEntres(d);
		la.forEach(am->{
			sommeAM=sommeAM+am.getMontant();
			am.setMyCaisseJournaliere(cj);
			argentMvtRepository.save(am);
		});
		cj.setDate(d);
		cj.setMontantEncaisse(sommeAM);
		
		List<ArgentMvt> la2=this.listeArgentSortis(d);
			la2.forEach(em->{
				sommeAMS=sommeAMS+em.getMontant();
				em.setMyCaisseJournaliere(cj);
				argentMvtRepository.save(em);
			});
		
		cj.setMontantDepenses(sommeAMS);
		cj.setMontantFinal(cj.getMontantEncaisse()-cj.getMontantDepenses());
		CaisseJournaliere cj4=caisseJournaliereRepository.save(cj);
		return cj4;
	}
	
	/*
	 * Pour la CAISSE, ne pas oublier de modifier son contenu pendant les opérations d'achat et de vente.
	 */
	
	///////////////////////////////////////////////////ACHAT DE BOUTEILLES(CASIERS)//////////////////////
	@Transactional
	public List<MagEmballage> initialiserMagEmballage(float nbSABC, float nbUCB, float nbGUI) {
		List<MagEmballage> magEmb= new ArrayList<MagEmballage>();
		magEmb.add(magEmballageRepository.save(new MagEmballage(fournisseurRepository.findByIdFournisseurAndIsValideTrue(ID_SABC), nbSABC, 0)));
		magEmb.add(magEmballageRepository.save(new MagEmballage(fournisseurRepository.findByIdFournisseurAndIsValideTrue(ID_UCB), nbUCB, 0)));
		magEmb.add(magEmballageRepository.save(new MagEmballage(fournisseurRepository.findByIdFournisseurAndIsValideTrue(ID_GUINNESS), nbGUI, 0)));
		
		return magEmb;
	}
	
	
	/*
	 * Pour effectuer les achats de bouteilles.
	 * Acteur: Secretaire/DG
	 * 
	 */
	@Transactional
	public AchatEmballage achatBouteilles(float qteEnCasier,float montant, String source, Personnel resp) {
		
		AchatEmballage ae=new AchatEmballage();
			ae.setDateAchat(date);
			ae.setMontantAchat(montant);
			ae.setQteEnCasier(qteEnCasier);
			ae.setSource(source);
			ae.setResponsable(resp);
			ae.setPayed(false);
			ae.setStocked(false);
			ae.setNbSABC(0);
			ae.setNbUCB(0);
			ae.setNbGUI(0);
		
		
		return achatEmballageRepository.save(ae);
	}
	/*
	 * Decaissement de l'agent pour achat de bouteilles.
	 * Acteur: CAISSIER(E)
	 */
	@Transactional
	public ReponseDto decaisserAchatBouteille(AchatEmballage ae, Personnel caissier) {
		ReponseDto r= new ReponseDto();
		
		if(ae==null) {
			r.format(Code.FAILURE, "Cet Achat d'Emballage est invalide");
			return r;
		}
		
		if(caissier==null) {
			r.format(Code.FAILURE, "Veillez enter un personnel valide");
			return r;
		}
		
		if(!ae.isValide()) {
			r.format(Code.FAILURE, "Cet Achat d'Emballage est invalide");
			return r;
		}
		
		if(!caissier.isValide()) {
			r.format(Code.FAILURE, "Veillez enter un personnel valide");
			return r;
		}
		
		if(ae.isPayed) {
			r.format(Code.FAILURE, "Cet achat d'emballage est déjà été décaissé");
			return r;
		}
		
		
		Caisse c= caisseRepository.findAll().get(0);
			if(c.getMontantCaisse()<ae.getMontantAchat()) {
				r.format(Code.FAILURE, "Montant de caisse Insuffisant");
				return r;
			}
			
			c.setMontantCaisse(c.getMontantCaisse()-ae.getMontantAchat());
			caisseRepository.save(c);
			
		InterfaceCaisse ic= new InterfaceCaisse();
			ic.setDateOperation(date);
			ic.setMyAchatEmballage(ae);
			ic.setMontantOperation(ae.getMontantAchat());
			ic.setNatureOperation(SORTIE_ARGENT);
			ic.setMyAchatEmballage(ae);
			ic.setCaissiere(caissier);
			
		InterfaceCaisse ic2=interfaceCaisseRepository.save(ic);
		
		
		ArgentMvt am= new ArgentMvt();
			am.setDateOpArgent(date);
			am.setHeureOpArgent(heure);
			am.setLibelleArgent(LIBELLE_ARGENT_ACHATBOUTEILLE);
			am.setMontant(ae.getMontantAchat());
			am.setMyInterfaceCaisse(ic2);
			am.setResponsable(caissier);
			am.setNatureMvt(SORTIE_ARGENT);
		ArgentMvt am2=argentMvtRepository.save(am);
		
		
		
		ic2.setMyArgentMvtPourDecaisser(am2);
		
			ae.setPayed(true);
			ae.setMyInterfaceCaisse(ic2);
		achatEmballageRepository.save(ae);
		 interfaceCaisseRepository.save(ic2);
		 
		 ArgentMvtDto amdto = new ArgentMvtDto(am2.getIdArgentMvt(),am2.getMontant(),am2.getLibelleArgent());
	
		 r.format(Code.SUCCESS,amdto.mapObjectToHashMap(am2));
		return r;
	}
	
	/*
	 * Stocker les Emballages achetes
	 * ACTEUR: MAGAZINIER(EMB)
	 */
	@Transactional
	public ReponseDto stockerEmballageAchete(AchatEmballage ae,Personnel magasinierEMB,float nbSABC,float nbUCB,float nbGUI) {
		ReponseDto r = new ReponseDto ();
		
		
		if(magasinierEMB==null) {
			r.format(Code.FAILURE, "Veillez entrer un personnel magazinier valide");
			return r;
		}
		
		if(!magasinierEMB.isValide()) {
			r.format(Code.FAILURE, "Veillez entrer un personnel magazinier valide");
			return r;
		}
		
		if(ae==null) {
			r.format(Code.FAILURE, "Veillez entrer un Achat Emballage valide");
			return r;
		}
		
		if(!ae.isValide()) {
			r.format(Code.FAILURE, "Veillez entrer un Achat Emballage valide");
			return r;
		}
		
		if(ae.isStocked) {
			r.format(Code.FAILURE, "Cet achat d'emballage est dejà stocké");
			return r;
		}
		
		if(nbSABC+nbUCB+nbGUI!=ae.getQteEnCasier()){//Les sommes ne correspondent pas.
			r.format(Code.FAILURE, "La somme des trois quantités est differente du total");
			return r;
		}
		
		if(nbSABC<0) {
			r.format(Code.FAILURE, "Entrez le nombre de Brasseries valide");
			return r;
		}
		
		if(nbUCB<0) {
			r.format(Code.FAILURE, "Entrez le nombre de UCB valide");
			return r;
		}
		
		if(nbGUI<0) {
			r.format(Code.FAILURE, "Entrez le nombre de Guinness valide");
			return r;
		}
		
		Fournisseur fSABC=fournisseurRepository.findByIdFournisseurAndIsValideTrue(ID_SABC);
		Fournisseur fUCB=fournisseurRepository.findByIdFournisseurAndIsValideTrue(ID_UCB);
		Fournisseur fGUI=fournisseurRepository.findByIdFournisseurAndIsValideTrue(ID_GUINNESS);
		
		
		
		//Mise à jour au magazin
		MagEmballage ma= magEmballageRepository.findByFournisseurAndIsValideTrue(fSABC);
			ma.setQteMag(ma.getQteMag()+nbSABC);
			
		MagEmballage ma2= magEmballageRepository.findByFournisseurAndIsValideTrue(fUCB);
			ma2.setQteMag(ma2.getQteMag()+nbUCB);
			
		MagEmballage ma3= magEmballageRepository.findByFournisseurAndIsValideTrue(fGUI);
			ma3.setQteMag(ma3.getQteMag()+nbGUI);
			
			List<HashMap<String, Object>> res= new ArrayList<HashMap<String, Object>>();
			
		//Creation des EmballageMvt associés car concernent le magazinier et modifient l'etat du magazin.	
		if(nbSABC!=0) {
			EmballagesMvt em= new EmballagesMvt();
				em.setDateOp(date);
				em.setHeureOp(heure);
				em.setMagasinierEMB(magasinierEMB);
				em.setFournisseurEmb(fSABC);
				em.setLibelleMvtEmb(LIBELLE_EMB_ACHATBOUTEILLE);			
				em.setNatureMvtEmb(ENTREE_EMB);
				em.setQuantiteEmb(nbSABC);
				em.setMyAchatEmballage(ae);
				EmballagesMvt emSABC=emballagesMvtRepository.save(em);
				EmballageMvtDto emdto1 =new EmballageMvtDto(emSABC);
				res.add(emdto1.mapObjectToHashMap(emSABC));
		}
		if(nbUCB!=0) {
			EmballagesMvt em2= new EmballagesMvt();
				em2.setDateOp(date);
				em2.setHeureOp(heure);
				em2.setMagasinierEMB(magasinierEMB);
				em2.setFournisseurEmb(fournisseurRepository.findByIdFournisseurAndIsValideTrue(ID_UCB));
				em2.setLibelleMvtEmb(LIBELLE_EMB_ACHATBOUTEILLE);			
				em2.setNatureMvtEmb(ENTREE_EMB);
				em2.setQuantiteEmb(nbUCB);
				em2.setMyAchatEmballage(ae);
				EmballagesMvt emUCB=emballagesMvtRepository.save(em2);
				EmballageMvtDto emdto1 =new EmballageMvtDto(emUCB);
				res.add(emdto1.mapObjectToHashMap(emUCB));
		}
	
		if(nbGUI!=0) {
			EmballagesMvt em3= new EmballagesMvt();
				em3.setDateOp(date);
				em3.setHeureOp(heure);
				em3.setMagasinierEMB(magasinierEMB);
				em3.setFournisseurEmb(fournisseurRepository.findByIdFournisseurAndIsValideTrue(ID_GUINNESS));
				em3.setLibelleMvtEmb(LIBELLE_EMB_ACHATBOUTEILLE);			
				em3.setNatureMvtEmb(ENTREE_EMB);
				em3.setQuantiteEmb(nbGUI);
				em3.setMyAchatEmballage(ae);
				EmballagesMvt emGUI=emballagesMvtRepository.save(em3);
				EmballageMvtDto emdto =new EmballageMvtDto(emGUI);
				res.add(emdto.mapObjectToHashMap(emGUI));
		}
		
		//Mise à jour de l'AchatEmballage
		ae.setNbSABC(nbSABC);
		ae.setNbUCB(nbUCB);
		ae.setNbGUI(nbGUI);
		ae.setStocked(true);
		achatEmballageRepository.save(ae);
		
		//Persistence des modifications de l'etat du magazin
		List<MagEmballage> lme=new ArrayList<MagEmballage>();
			lme.add(magEmballageRepository.save(ma));
			lme.add(magEmballageRepository.save(ma2));
			lme.add(magEmballageRepository.save(ma3));
			
		r.format(Code.SUCCESS, res);
		return r;
	}

	public Client getClientValideById(long client) {
		return clientRepository.findByIdClientAndIsValideTrue(client);
	}

	public Produit getProduitValideById(long produit) {
		return produitRepository.findByIdProduitAndIsValideTrue(produit);
	}

	public Facture getFactureValideById(long idLivraison) {
		return factureRepository.findByIdFactureAndIsValideTrue(idLivraison);
	}

	public GestionFacture getGestionFactureValideById(long gesfac) {
		return gestionFactureRepository.findByIdGestionFactureAndIsValideTrue(gesfac);
	}

	public Depenses getDepensesByIdAndIsValideTrue(long idDepense) {
		return depensesRepository.findByIdDepenseAndIsValideTrue(idDepense);
	}

	@Transactional
	public ReponseDto setDepensesInvalide(long iddep) {
		Depenses dep= this.getDepensesByIdAndIsValideTrue(iddep);
		ReponseDto r = new ReponseDto ();
		if(dep!=null) {
			dep.setValide(false);
			depensesRepository.save(dep);
			r.format(Code.SUCCESS, "Cette dépense a été annulée avec succes");
		}else {
			r.format(Code.FAILURE, "Cette dépense est invalide/inexistante");
		}
		
		return r;
		
	}

	@Transactional
	public ReponseDto enregistrerNouveauCass(CassDto c) {
		ReponseDto r= new ReponseDto();
		if(c==null) {
			r.format(Code.FAILURE, "Informations invalides");
			return r;
		}
		Personnel p= personnelRepository.findByIdPersonnelAndIsValideTrue(c.getAuteurCass());
		Produit prod= produitRepository.findByIdProduitAndIsValideTrue(c.getProduitCass());
		Cass cass= new Cass();
		if(p==null) {
			r.format(Code.FAILURE, "Veillez entrer un responsable valide pour ce cass");
			return r;
		}
		
		
		if(prod==null) {
			r.format(Code.FAILURE, "Veillez entrer le produit en question.");
			return r;
		}
		
		if(c.getNbBout()<=0) {
			r.format(Code.FAILURE, "Veillez entrer une quantité de bouteille valide");
			return r;
		}
		
		
		if(c.getNature()) {
			float amount= (prod.getPuVente()/prod.getFormat())*c.getNbBout();
			cass= new Cass(c.getNature(), c.getNbBout(), p, date, heure, c.getRaison(), amount, prod,true,false,false);
		}else {
			float amount= PRIX_BOUT_VIDE*c.getNbBout();
			cass= new Cass(c.getNature(), c.getNbBout(), p, date, heure, c.getRaison(), amount, null,true,false,false);
		}
		r.format(Code.SUCCESS, cassRepository.save(cass));
		
		return r;
	}

	@Transactional
	public ReponseDto modifierCass(CassDto c) {
		ReponseDto r= new ReponseDto();
		if(c==null) {
			r.format(Code.FAILURE, "Cass non valide");
			return r;
		}
		
		Cass c2=cassRepository.findByIdCassAndIsValideTrue(c.getIdCass());
		if(c2==null) {
			r.format(Code.FAILURE, "Ce cass est invalide/inexistant");
			return r;
		}
		
		if(c2.getNature()!=c.getNature()) {
			r.format(Code.FAILURE, "La nature du cass ne peut être modifiée");
			return r;
		}
		
		Personnel p=personnelRepository.findByIdPersonnelAndIsValideTrue(c.getAuteurCass());
		if(p==null) {
			r.format(Code.FAILURE, "Veillez entrer un personnel valide");
			return r;
		}else {
			c2.setAuteurCass(p);//4
		}
		
		if(c.getNbBout()<=0) {
			r.format(Code.FAILURE, "Veillez saisir un nombre de bouteille valide");
			return r;
		}else {
			c2.setNbBout(c.getNbBout());//1
		}
		
		if(c.getRaison()!=null || c.getRaison()!="") {
			c2.setRaison(c.getRaison());//5
		}
		
		if(c2.getNature()) {
			Produit prod= produitRepository.findByIdProduitAndIsValideTrue(c.getProduitCass());
			if(prod!=null) {
				c2.setProduitCass(prod);//2 & 3
				c2.setMontantDommage((prod.getPuVente()/prod.getFormat())*c.getNbBout());
			}else {
				r.format(Code.FAILURE, "Veillez entrer un produit valide");
				return r;
			}
			
		}else {
			c2.setMontantDommage(c.getNbBout()*PRIX_BOUT_VIDE);
		}
		Cass cUpdated= cassRepository.save(c2);
		
		CassDto cdto= new CassDto(cUpdated.getNature(), cUpdated.getNbBout(), cUpdated.getAuteurCass().getIdPersonnel(), cUpdated.getRaison(), cUpdated.getMontantDommage(), cUpdated.getProduitCass().getIdProduit());
		
		r.format(Code.FAILURE, cdto);
		
		return r;
	}

	@Transactional
	public ReponseDto setCassInvalide(long cass) {
		Cass c= this.cassRepository.findByIdCassAndIsValideTrue(cass);
		ReponseDto r = new ReponseDto ();
		if(c!=null) {
			c.setValide(false);
			cassRepository.save(c);
			r.format(Code.SUCCESS, "Ce cass a été annulé avec succes");
		}else {
			r.format(Code.FAILURE, "Ce cass est invalide/inexistante");
		}
		
		return r;
	}

	
	public AchatEmballage getAchatEmballageValide(long achatEmb) {
		return achatEmballageRepository.findByIdAcharEmballageAndIsValideTrue(achatEmb);
	}

	public void setAchatEmballageInvalide(AchatEmballage ae) {
		ae.setValide(false);
		achatEmballageRepository.save(ae);	
	}

	public Cass getCassValideById(long cass) {
		return cassRepository.findByIdCassAndIsValideTrue(cass);
	}

	@Transactional
	public ReponseDto gererCassProd(Cass c, Personnel p) {
		ReponseDto r= new ReponseDto();
		
		if(c==null) {
			r.format(Code.FAILURE, "Veillez saisir un cass valide");
			return r;
		}
		
		if(p==null) {
			r.format(Code.FAILURE, "Veillez entrer un personnel valide");
			return r;
		}
		
		if(c.isManaged()) {
			r.format(Code.FAILURE, "Ce cass est déjà géré");
			return r;
		}
		
		if(c.isAcquited()) {
			r.format(Code.FAILURE, "Ce cass est déjà acquité(payé)");
			return r;
		}
		
		if(c.getMagProd()!=null) {
			r.format(Code.FAILURE, "Ce cass est déja géré en terme de produit");
			return r;
		}
		
		if(!c.getNature()) {
			r.format(Code.FAILURE, "Ce cass ne concerne que les emballages."
					+ "Donc ne peut être géré en terme de cass de produit.");
			return r;
		}
		
		
		float quantiteEnCasier=c.getNbBout()/12;
		
		Produit prod= produitRepository.findByIdProduitAndIsValideTrue(c.getProduitCass().getIdProduit());
			
			
			if(prod.getQuantite()<quantiteEnCasier) {
				r.format(Code.FAILURE, "Impossible de gérer ce cass. Le stock n'est pas suffisant");
				return r;
			}
			
			//produitMvt
			ProduitMvt pmvt= new ProduitMvt(c.getProduitCass(), quantiteEnCasier, false, date, heure, LIBELLE_CASS,true, p, null, null, null, null,c);
			ProduitMvt pmvt2=produitMvtRepository.save(pmvt);
			
			//Retrait du magasin des produits.
			prod.setQuantite(prod.getQuantite()-quantiteEnCasier);
			produitRepository.save(prod);
		
			
			//Cass
			if(c.getMagEmb()!=null) {
				c.setManaged(true);
			}
			c.setMagProd(p);
			c.setMyProduitMvt(pmvt2);
			cassRepository.save(c);
		
			r.format(Code.SUCCESS, "Opération sur le cass "+c.getIdCass()+" effectué avec succes.");
			return r;
	}
	
	@Transactional
	public ReponseDto gererCassEmb(Cass c, Personnel p) {
		ReponseDto r= new ReponseDto();
		
		if(c==null) {
			r.format(Code.FAILURE, "Veillez saisir un cass valide");
			return r;
		}
		
		if(p==null) {
			r.format(Code.FAILURE, "Veillez entrer un personnel valide");
			return r;
		}
		
		if(c.isManaged()) {
			r.format(Code.FAILURE, "Ce cass est déjà géré");
			return r;
		}
		
		if(c.isAcquited()) {
			r.format(Code.FAILURE, "Ce cass est déjà acquité(payé)");
			return r;
		}
		
		
		if(c.getMagEmb()!=null) {
			r.format(Code.FAILURE, "Ce cass est déjà géré.");
			return r;
		}
		
		float quantiteEnCasier=c.getNbBout()/12;
		
		Produit produit= this.getProduitValideById(c.getProduitCass().getIdProduit());
		Fournisseur f= fournisseurRepository.findByIdFournisseurAndIsValideTrue(produit.getMyFournisseur().getIdFournisseur());
		MagEmballage me= magEmballageRepository.findByFournisseurAndIsValideTrue(f);
		
		//EmballagesMvt
		EmballagesMvt emvt= new EmballagesMvt(quantiteEnCasier, f, false, date, heure, LIBELLE_CASS,p, null, null, null,null, c,true);
		EmballagesMvt emvt2=emballagesMvtRepository.save(emvt);
		
		//Retrait du magasin des emballages du magazin.
		me.setQteMag(me.getQteMag()-quantiteEnCasier);
		magEmballageRepository.save(me);
		
		//Cass
		c.setMagEmb(p);
		if(!c.getNature()) {
			c.setManaged(true);
		}else {
			if(c.getMagProd()!=null) {
				c.setManaged(true);
			}
		}
		c.setMyEmballageMvt(emvt2);
		cassRepository.save(c);
		
		
		r.format(Code.SUCCESS, "Opération sur le cass "+c.getIdCass()+" effectué avec succes.");
		return r;
	}

	@Transactional
	public ReponseDto annulerGestionCassEmb(Cass c) {
		ReponseDto r = new ReponseDto();
		
		if(c==null) {
			r.format(Code.FAILURE, "Veillez entrer un Cass valide");
			return r;
		}
		
		if(c.isAcquited()) {
			r.format(Code.FAILURE, "Ce cass est déjà acquité. Donc impossilble d'annuler"
					+ "sa gestion.");
			return r;
		}
		
		if(!c.isManaged()) {
			r.format(Code.FAILURE, "Ce cass n'est même pas géré.");
			return r;
		}
		
		if(c.getMagEmb()==null || c.getMyEmballageMvt()==null) {
			r.format(Code.FAILURE, "Ce cass n'est pas géré en terme d'emballages");
			return r;
		}
		
		
			//EmballagesMvt
			EmballagesMvt emvt= emballagesMvtRepository.findByIdEmbAndIsValideTrue(c.getMyEmballageMvt().getIdEmb());
			emvt.setValide(false);
			emballagesMvtRepository.save(emvt);
			
			
			//on remet au magasin les emballages.
			float quantiteEnCasier=c.getNbBout()/12;
			Produit produit= this.getProduitValideById(c.getProduitCass().getIdProduit());
			Fournisseur f= fournisseurRepository.findByIdFournisseurAndIsValideTrue(produit.getMyFournisseur().getIdFournisseur());
			MagEmballage me= magEmballageRepository.findByFournisseurAndIsValideTrue(f);
			
			me.setQteMag(me.getQteMag()+quantiteEnCasier);
			magEmballageRepository.save(me);
			
			
			//Mis à jour dans cass
			c.setMagEmb(null);
			if(!c.getNature() ||(c.getNature() && c.getMagProd()==null)) {
				c.setManaged(false);
			}
			
			c.setMyEmballageMvt(null);
			cassRepository.save(c);
			
			r.format(Code.SUCCESS, "Opération d'annulation (Emballage) effectuée avec succes sur le cass "+c.getIdCass());
			return r;
			
		}
		
	

	@Transactional
	public ReponseDto annulerGestionCassProd(Cass c) {
		ReponseDto r = new ReponseDto();

		if(c==null) {
			r.format(Code.FAILURE, "Veillez entrer un Cass valide");
			return r;
		}

		if(c.isAcquited()) {
			r.format(Code.FAILURE, "Ce cass est déjà acquité. Donc impossilble d'annuler"
					+ "sa gestion.");
			return r;
		}

		if(!c.isManaged()) {
			r.format(Code.FAILURE, "Ce cass n'est même pas géré.");
			return r;
		}
		
		if(!c.getNature()) {
			r.format(Code.FAILURE, "Opération d'annulation (produit) impossible sur ce cass");
			return r;
		}
		
		if(c.getMagProd()==null || c.getMyProduitMvt()==null) {
			r.format(Code.FAILURE, "Ce cass n'est même pas encore géré.");
			return r;
		}


		//ProduitMvt
		ProduitMvt pmvt= produitMvtRepository.findByIdMagProdMvtAndIsValideTrue(c.getMyProduitMvt().getIdMagProdMvt());
		pmvt.setValide(false);
		produitMvtRepository.save(pmvt);


		//on remet au magasin les emballages.
		float quantiteEnCasier=c.getNbBout()/12;
		Produit produit= this.getProduitValideById(c.getProduitCass().getIdProduit());
		produit.setQuantite(produit.getQuantite()+quantiteEnCasier);
		produitRepository.save(produit);


		//Mis à jour dans cass
		c.setMagProd(null);
		if(c.getNature() && (c.getMagEmb()==null || c.getMyEmballageMvt()==null)) {
			c.setManaged(false);
		}

		c.setMyProduitMvt(null);;
		cassRepository.save(c);

		r.format(Code.SUCCESS, "Opération d'annulation (Produit) effectuée avec succes sur le cass "+c.getIdCass());
		return r;

	}

	/*
	 * Acquitement du cass.
	 */
	@Transactional
	public ReponseDto effacementCassByArgent(Cass c,Personnel caissier) {
		ReponseDto r= new ReponseDto();
		
		if (c==null) {
			r.format(Code.FAILURE, "Cass invalide/inexistant");
			return r;
		}
		
		if (caissier==null) {
			r.format(Code.FAILURE, "Personnel Cassier(e) invalide/inexistant");
			return r;
		}
		
		if(!c.isValide()) {
			r.format(Code.FAILURE, "Cass invalide");
			return r;
		}
		
		if(!caissier.isValide()) {
			r.format(Code.FAILURE, "Personnel Cassier(e) invalide");
			return r;
		}
		
		if(!c.isManaged()) {
			r.format(Code.FAILURE, "Ce cass n'est pas encore géré. Donc ne peut être acquité");
			return r;
		}
		
		if(c.isAcquited()) {
			r.format(Code.FAILURE, "Ce cass a déjà été acquité");
			return r;
		}
		List<ArgentMvt> lam=argentMvtRepository.findByMyCassAndIsValideTrue(c);
		if(lam.size()>1) {
			r.format(Code.FAILURE, "Ce cass a déjà été acquité");
			return r;
		}
		CaisseJournaliere cj= caisseJournaliereRepository.findByDateBetweenAndIsValideTrue(date.plusDays(1),date.plusDays(1));
		float amount;
		
		if(!c.getNature()){
			//ArgentMvt
			 amount= c.getNbBout()*PRIX_BOUT_VIDE;
			ArgentMvt am= new ArgentMvt(amount, ENTREE_ARGENT, date, heure, LIBELLE_ACQUITEMENT, null, null, null, null, null, cj, null, caissier);
			am.setMyCass(c);
			ArgentMvt am2=argentMvtRepository.save(am);
			
			//cass
			c.setAcquited(true);
			c.setMyArgentMvt(am2);
			cassRepository.save(c);
		}else {
			//ArgentMvt
			Produit prod=produitRepository.findByIdProduitAndIsValideTrue(c.getProduitCass().getIdProduit());
			amount= c.getNbBout()*prod.getPuVente()+c.getNbBout();
			ArgentMvt am= new ArgentMvt(amount,ENTREE_ARGENT,date,heure,LIBELLE_ACQUITEMENT,null,null,null,null,null,cj,null,caissier);
			am.setMyCass(c);
			ArgentMvt am2= argentMvtRepository.save(am);
			
			//cass
			
			if(lam.size()>1) {
				c.setAcquited(true);
			}
			c.setMyArgentMvt(am2);//NOn pertinent
			cassRepository.save(c);
		}
		
		//Mise à jour de la valeur dans la caisse Journaliere
		cj.setMontantEncaisse(cj.getMontantEncaisse()+amount);
		cj.setMontantFinal(cj.getMontantFinal()+amount);
		if(cj.getMontantDepenses()>0 && cj.getMontantDepenses()<cj.getMontantDepenses()) {
			cj.setUsedType(UsedCaisseJounaliere.PARTIALUSED);
		}
		CaisseJournaliere cj2=caisseJournaliereRepository.save(cj);
		
		CaisseJournaliereDto cjdto= new CaisseJournaliereDto(cj2.getIdCaisseJournaliere(), cj.getDate(), cj.getMontantFinal());
		
		r.format(Code.SUCCESS, cjdto);
		return r;
	}
	
	@Transactional
	public ReponseDto effacementCassByEmballage(Cass c,Personnel mag,Fournisseur four) {
		ReponseDto r= new ReponseDto();
		if (c==null) {
			r.format(Code.FAILURE, "Cass invalide/inexistant");
			return r;
		}
		
		if (mag==null) {
			r.format(Code.FAILURE, "Personnel Magazinier(e) invalide/inexistant");
			return r;
		}
		
		if(!c.isValide()) {
			r.format(Code.FAILURE, "Cass invalide");
			return r;
		}
		
		if(!mag.isValide()) {
			r.format(Code.FAILURE, "Personnel Magazinier(e) invalide");
			return r;
		}
		
		if(!c.isManaged()) {
			r.format(Code.FAILURE, "Ce cass n'est pas encore géré. Donc ne peut être acquité");
			return r;
		}
		
		if(c.isAcquited()) {
			r.format(Code.FAILURE, "Ce cass a déjà été acquité");
			return r;
		}
		
		if(!four.isValide()) {
			r.format(Code.FAILURE, "Ce fournisseur est invalide/inexistant");
			return r;
		}
		
		
		List<ArgentMvt> lam=argentMvtRepository.findByMyCassAndIsValideTrue(c);
		if(lam.size()>1) {
			r.format(Code.FAILURE, "Ce cass a déjà été acquité");
			return r;
		}

		float quantiteEnCasier=c.getNbBout()/12; 

		//EmballageMvt
		Fournisseur f= fournisseurRepository.findByIdFournisseurAndIsValideTrue(c.getProduitCass().getMyFournisseur().getIdFournisseur());
		EmballagesMvt em = new EmballagesMvt();
		if(four!=null){
			em = new EmballagesMvt(quantiteEnCasier, four, true, date, heure, LIBELLE_ACQUITEMENT, mag, null, null, null, null, c, true);	
		}
		em = new EmballagesMvt(quantiteEnCasier, f, true, date, heure, LIBELLE_ACQUITEMENT, mag, null, null, null, null, c, true);
		EmballagesMvt em2=emballagesMvtRepository.save(em);

		//MagEmb
		MagEmballage me= new MagEmballage();
		if(four!=null){
			me= magEmballageRepository.findByFournisseurAndIsValideTrue(four);
		}
		me= magEmballageRepository.findByFournisseurAndIsValideTrue(f);
		me.setQteMag(me.getQteMag()+quantiteEnCasier);
		MagEmballage me2=magEmballageRepository.save(me);


		//Cass
		c.setMyEmballageMvt(em2);


		if(!c.getNature()){
			c.setAcquited(true);
		}else {
			if(!lam.isEmpty()) {
				c.setAcquited(true);
			}
		}
		cassRepository.save(c);


		r.format(Code.SUCCESS, me2);

		return r;
	}

	@Transactional
	public ReponseDto updateEmbMag(float amount, Fournisseur four) {
		ReponseDto r= new ReponseDto();
		if(amount<=0) {
			r.format(Code.FAILURE, "Entrez un montant valide");
			return r;
		}
		
		if(four==null) {
			r.format(Code.FAILURE, "Entrez un fournisseur valide");
			return r;
		}
		MagEmballage me= magEmballageRepository.findByFournisseurAndIsValideTrue(four);
		me.setQteMag(amount);
		r.format(Code.SUCCESS, magEmballageRepository.save(me));
		return r;
	}

	
	public CaisseJournaliere getCaisseJournaliereValideById(long cj) {
		return caisseJournaliereRepository.findByIdCaisseJournaliereAndIsValideTrue(cj);
	}

	
	@Transactional
	public ReponseDto fromCaisseJournaliereToCaisse(CaisseJournaliere cj, Personnel p) {
		ReponseDto r= new ReponseDto();
		if(cj==null) {
			r.format(Code.FAILURE, "Cette Caisse Journaliere est invalide/inexistant");
			return r;
		}
		if(!cj.isValide()) {
			r.format(Code.FAILURE, "Cette Caisse Journaliere est invalide/inexistant");
			return r;
		}
		if(p==null) {
			r.format(Code.FAILURE, "Ce personnel Responsable est invalide/inexistant");
			return r;
		}
		if(!p.isValide()) {
			r.format(Code.FAILURE, "Ce personnel Responsable est invalide/inexistant");
			return r;
		}
		if(cj.isTaked()) {
			r.format(Code.FAILURE, "Cette caisse journalière est déjà prise.");
			return r;
		}
		//Caisse
		Caisse c= caisseRepository.findByIdCaisseAndIsValideTrue(ID_CAISSE);
		c.setMontantCaisse( c.getMontantCaisse()  +cj.getMontantFinal());
		//InterfaceCaisse
		InterfaceCaisse ic= new InterfaceCaisse(cj.getMontantFinal(),true , date, null, cj, null,p);
		
		//cj
		cj.setTaked(true);
		cj.setMyInterfaceCaisse(interfaceCaisseRepository.save(ic));
		caisseJournaliereRepository.save(cj);
		r.format(Code.SUCCESS, caisseRepository.save(c).getMontantCaisse());
		return r;
	}

	public ReponseDto getDateHour() {
		ReponseDto r= new ReponseDto();
		LocalDate date= LocalDate.now();
		LocalTime	heure= LocalTime.now();
		r.format(Code.SUCCESS, date + "|"+heure);
		return r;
	}

	public Caisse getCaisseValide() {
		return caisseRepository.findByIdCaisseAndIsValideTrue(ID_CAISSE);
	}
		
	

	////////////////////////////////// A FAIRE PLUS TARD ////////////////////////////////////////
	/*
	 * 1- Fonction permettant de connaître le stock d'un produit avant sa facturation.
	 * NB: Inclure à la fois le stock du magazin et les quantités virtuelles des produits issu de des
	 *     Factures Non-Livrées. ie. QteReel=QteEnStock-(Les QtesVirtuelles). Apres on teste si quantite<=QteReel
	 *     (Fait)
	 * 2- Bien penser à la configuration u prix d'un produit par client(Fait).
	 * 
	 * 3- Porgrammer la gestion des erreur avec les Objtets JSON STATUS(Fait).
	 * 
	 * 4- Inclure dans chaque ligne de chaque table de la base de donnee  un attribut isValide.
	 * Pour pouvoir bien implémenter les méthodes d'annulation d'Opération(Fait)
	 * 
	 * 5- IMplémenter les methodes d'Annulation d'operations.(Fait)
	 * 
	 * 6- Tester
	 * 
	 * 7- Diviser le package Vente en: Vente, Facture, Chargements, Commandes, Caisse
	 * 
	 * 8- Une interface de Calculatrice: Pour remplacer la calculatrice electronique.
	 * 
	 * 9- Voir le decaissement pour un eventuel achat de bouteilles.(Fait)
	 * 
	 * 10- Plusieurs Caisses(comme à UBA).
	 * 
	 * 11- Modul de decsision sur les clients(credits,etc...)
	 * 
	 * 12- Inclure (update_at, update_by) et (cancel_at, cancel_by) dans toutes les tables de la base de donnée 
	 * 		et les utiliser dans les fonction de mise à jour et d'annulation
	 * 13- Gérer les dates et les heure: passer du LocalDate/LocalTime à java.util.Date
	 * 
	 */
}
