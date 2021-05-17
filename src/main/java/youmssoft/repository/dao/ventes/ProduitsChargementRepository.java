package youmssoft.repository.dao.ventes;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import youmssoft.repository.entities.livraison.Produit;
import youmssoft.repository.entities.ventes.Chargement;
import youmssoft.repository.entities.ventes.ProduitsChargement;

public interface ProduitsChargementRepository extends JpaRepository<ProduitsChargement,Long>{

	public List<ProduitsChargement> findByMyChargementAndIsValideTrue(Chargement charg);

	public ProduitsChargement findByProduitPCAndIsValideTrue(Produit produit);

	public ProduitsChargement findByMyChargementAndProduitPCAndIsValideTrue(Chargement charg, Produit produit);

}
