package youmssoft.repository.services;

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

@Service
public class ServicesConfiguration {
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
	
	@Autowired
	CollaborateurExtRepository collaborateurExtRepository;
	
	@Autowired
	DetailsLivraisonRepository detailsLivraisonRepository;

	@Autowired
	LivraisonRepository livraisonRepository;
	
	@Autowired
	ProduitLivraisonRepository produitLivraisonRepository;
	

	public void resetApp() {
		System.out.println("DEBUT DE LA SUPPRESSION");
		//produitLivraisonRepository.deleteAll();
		livraisonRepository.deleteAll();
		detailsLivraisonRepository.deleteAll();
		clientRepository.deleteAll();
		factureRepository.deleteAll();
		 detailsFactureRepository.deleteAll();
		gestionFactureRepository.deleteAll();
		produitsFactureRepository.deleteAll();
		commandeFactureRepository.deleteAll();
	    personnelRepository.deleteAll();
		produitRepository.deleteAll();
		argentMvtRepository.deleteAll();
		emballagesMvtRepository.deleteAll();
		produitMvtRepository.deleteAll();
	   chargementRepository.deleteAll();
		facturesChargementRepository.deleteAll();
		prixProduitsRepository.deleteAll();
		fournisseurRepository.deleteAll();
		cassRepository.deleteAll();
		caisseRepository.deleteAll();
		magEmballageRepository.deleteAll();
		cumulRistClientsRepository.deleteAll();
		totalRistournePayementRepository.deleteAll();
		chargementPatrimoineRepository.deleteAll();
		commandeRepository.deleteAll();
		depensesRepository.deleteAll();
		detailsFCRepository.deleteAll();
		facturePatrimoineRepository.deleteAll();
		gestionFCRepository.deleteAll();
		gestionRetourChargementRepository.deleteAll();
		 manquantsRCRepository.deleteAll();
		patrimoineRepository.deleteAll();
		produitsCommandeRepository.deleteAll();
		produitsFCRepository.deleteAll();
		 produitsRCRepository.deleteAll();
		retourChargementRepository.deleteAll();
		patrimoineFactureRepository.deleteAll();
		gestionCaisseRepository.deleteAll();
		caisseJournaliereRepository.deleteAll();
		interfaceCaisseRepository.deleteAll();
		produitsChargementRepository.deleteAll();
		gestionLivraisonRepository.deleteAll();
		 achatEmballageRepository.deleteAll();
		retourProduitsRepository.deleteAll();
		collaborateurExtRepository.deleteAll();
		System.out.println("FIN DE LA SUPPRESSION");
	}
	
}
