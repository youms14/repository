package youmssoft.repository.dao.livraison;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import youmssoft.repository.entities.livraison.Livraison;
import youmssoft.repository.entities.livraison.Produit;
import youmssoft.repository.entities.livraison.ProduitsLivraison;
//import youmssoft.repository.services.ProduitsLivraisonDto;



public interface ProduitLivraisonRepository extends JpaRepository<ProduitsLivraison,Long> {

	@Query("select n FROM ProduitsLivraison n where n.mylivraison.idLivraison like :idLivraison")
	public List<ProduitsLivraison> listProduitsLivraison(@Param("idLivraison") long idLivraison);

	public ProduitsLivraison findByMylivraisonAndMyProduitAndIsValideTrue(Livraison livraison, Produit produit);

	public List<ProduitsLivraison> findByMylivraisonAndIsValideTrue(Livraison l); 
	
}
