package youmssoft.repository.dao.livraison;

import java.time.LocalDate;
import java.util.Collection;
import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import youmssoft.repository.entities.livraison.CollaborateurExt;
import youmssoft.repository.entities.livraison.Livraison;

public interface LivraisonRepository extends JpaRepository<Livraison, Long>{
	//@Query("select n FROM Livraison n where n.isValide AND n.dateLivraison BETWEEN :start AND :end")
	//public List<Livraison> livraisonByDate(@Param("start") LocalDate start, @Param("end") LocalDate end);
	
	public List<Livraison> findByIsValideTrueAndDateLivraisonBetween(LocalDate start,LocalDate end);
	
	public List<Livraison> findByMyCollaborateurExtInAndDateLivraisonBetweenAndIsValideTrueOrderByDateLivraisonAsc(Collection<CollaborateurExt> colExts, LocalDate start, LocalDate end);

	public Livraison findByIdLivraisonAndIsValideTrue(long idLivraison);
}
