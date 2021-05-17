package youmssoft.repository.dao.livraison;

import java.time.LocalDate;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import youmssoft.repository.entities.livraison.GestionLivraison;
import youmssoft.repository.entities.livraison.Livraison;

public interface GestionLivraisonRepository extends JpaRepository<GestionLivraison, Long> {

	@Query("select n FROM GestionLivraison n where n.myLivraison.idLivraison like :idLivraison AND n.isValide=true")
	public List<GestionLivraison> listOperationLivraison(@Param("idLivraison") long idLivraison); 
	
	@Query("select n FROM GestionLivraison n where n.myLivraison.idLivraison like :idLivraison AND n.isValide=true")
	public List<GestionLivraison> listOperationLivraisonByType(@Param("idLivraison") long i); 

	public List<GestionLivraison> findByMyLivraisonAndIsValideTrue (Livraison idLivraison);
	
	public List<GestionLivraison> findByMyLivraisonAndNatureOperationAndIsValideTrue (Livraison livraison, boolean natureOp);

	public GestionLivraison findByIdGestionLivraisonAndIsValideTrue(long idgl);
;} 
