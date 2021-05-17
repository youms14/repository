package youmssoft.repository.dao.ventes;

import java.time.LocalDate;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import youmssoft.repository.entities.livraison.GestionLivraison;
import youmssoft.repository.entities.ventes.EmballagesMvt;
import youmssoft.repository.entities.ventes.GestionFacture;
import youmssoft.repository.entities.ventes.GestionRetourChargement;

public interface EmballagesMvtRepository extends JpaRepository<EmballagesMvt,Long>{

	public List<EmballagesMvt> findByDateOpAndIsValideTrue(LocalDate dateOp);

	public List<EmballagesMvt> findByDateOpAndNatureMvtEmbTrueAndIsValideTrue(LocalDate dateOp);

	public List<EmballagesMvt> findByDateOpAndNatureMvtEmbFalseAndIsValideTrue(LocalDate dateOp);

	public List<EmballagesMvt> findByDateOpBetweenAndIsValideTrue(LocalDate plusDays, LocalDate plusDays2);

	public List<EmballagesMvt> findByDateOpBetweenAndNatureMvtEmbTrueAndIsValideTrue(LocalDate plusDays, LocalDate plusDays2);

	public List<EmballagesMvt> findByDateOpBetweenAndNatureMvtEmbFalseAndIsValideTrue(LocalDate plusDays, LocalDate plusDays2);

	public List<EmballagesMvt> findByMyGestionRetourChargmentAndIsValideTrue(GestionRetourChargement grc);

	public List<EmballagesMvt> findByMyGestionFactureAndIsValideTrue(GestionFacture gf);

	public List<EmballagesMvt> findByMyGestionLivraisonAndIsValideTrue(GestionLivraison gl);

	public EmballagesMvt findByIdEmbAndIsValideTrue(long idEmb);

}
