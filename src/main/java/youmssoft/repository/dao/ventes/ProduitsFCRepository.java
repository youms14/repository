package youmssoft.repository.dao.ventes;

import org.springframework.data.jpa.repository.JpaRepository;

import youmssoft.repository.entities.livraison.Produit;
import youmssoft.repository.entities.ventes.FacturesChargement;
import youmssoft.repository.entities.ventes.ProduitsFC;

public interface ProduitsFCRepository extends JpaRepository<ProduitsFC,Long>{

	ProduitsFC findByMyFacturesChargementAndProduitFCAndIsValideTrue(FacturesChargement fc, Produit produit);

}
