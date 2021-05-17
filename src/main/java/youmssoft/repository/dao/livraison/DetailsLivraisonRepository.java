package youmssoft.repository.dao.livraison;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import youmssoft.repository.entities.livraison.DetailsLivraison;

public interface DetailsLivraisonRepository extends JpaRepository<DetailsLivraison,Long> {

	public List<DetailsLivraison> findByMyLivraisonIsEmbOkFalseAndIsValideTrue();

	public List<DetailsLivraison> findByMyLivraisonIsSoldedFalseAndIsValideTrue();

	public DetailsLivraison findByIdDetailsLivraisonAndIsValideTrue(long idDetailsLivraison);

}
