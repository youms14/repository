package youmssoft.repository.dao.ventes;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import youmssoft.repository.entities.livraison.Livraison;
import youmssoft.repository.entities.livraison.Produit;
import youmssoft.repository.entities.ventes.Chargement;
import youmssoft.repository.entities.ventes.Facture;
import youmssoft.repository.entities.ventes.ProduitMvt;
import youmssoft.repository.entities.ventes.RetourChargement;

public interface ProduitMvtRepository extends JpaRepository<ProduitMvt,Long>{

	List<ProduitMvt> findByMyFactureAndIsValideTrue(Facture f);

	ProduitMvt findByMyFactureAndProduitAndIsValideTrue(Facture f, Produit p);

	List<ProduitMvt> findByMyChargementAndIsValideTrue(Chargement charg);

	List<ProduitMvt> findByMyRetourChargmentAndIsValideTrue(RetourChargement rc);

	ProduitMvt findByIdMagProdMvtAndIsValideTrue(long idMagProdMvt);

	List<ProduitMvt> findByMyLivraisonAndIsValideTrue(Livraison li);

}
