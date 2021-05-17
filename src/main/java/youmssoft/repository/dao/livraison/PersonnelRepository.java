package youmssoft.repository.dao.livraison;

import java.time.LocalDate;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.format.annotation.DateTimeFormat;

import youmssoft.repository.entities.livraison.Fournisseur;
import youmssoft.repository.entities.livraison.GestionLivraison;
import youmssoft.repository.entities.livraison.Personnel;
import youmssoft.repository.entities.livraison.Produit;

public interface PersonnelRepository extends JpaRepository<Personnel, Long> {
	@Query("select n FROM Personnel n where n.nomPers like :x and n.sexePers = :y and n.dateNaissancePers BETWEEN :start AND :end")
	public List<Personnel> getPers(@Param("x") String nom,@Param("y") boolean s,@Param("start") LocalDate dte, @Param("end") LocalDate dte2 ); 
//"SELECT e FROM MyEntity e WHERE date BETWEEN :start AND :end"
	
	public List<Personnel> findByDateNaissancePersBetweenAndIsValideTrue(LocalDate start, LocalDate end);
	
	public List<Personnel> findByNomPersAndIsValideTrue(String nom);

	public Personnel findByIdPersonnelAndIsValideTrue(long idPersonnel);

	
}
