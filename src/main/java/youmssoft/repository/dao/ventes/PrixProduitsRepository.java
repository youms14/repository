package youmssoft.repository.dao.ventes;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import youmssoft.repository.entities.livraison.Produit;
import youmssoft.repository.entities.ventes.Client;
import youmssoft.repository.entities.ventes.PrixProduits;

public interface PrixProduitsRepository extends JpaRepository<PrixProduits,Long>{

	public List<PrixProduits> findByMyClientAndProduitAndIsValideTrue(Client myClient, Produit produit);
}
