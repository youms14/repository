package youmssoft.repository.dao.livraison;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import youmssoft.repository.entities.livraison.Fournisseur;
import youmssoft.repository.entities.livraison.Produit;

public interface ProduitRepository extends  JpaRepository<Produit,Long> {
	
	public List<Produit> findByMyFournisseurAndIsValideTrue(Fournisseur fournisseur);

	public Produit findByIdProduitAndIsValideTrue(long idProduit);
}


