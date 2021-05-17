package youmssoft.repository.dao.ventes;

import java.time.LocalDate;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import youmssoft.repository.entities.ventes.ArgentMvt;
import youmssoft.repository.entities.ventes.Cass;
import youmssoft.repository.entities.ventes.GestionFacture;
import youmssoft.repository.entities.ventes.GestionRetourChargement;

public interface ArgentMvtRepository extends  JpaRepository<ArgentMvt,Long>{

	List<ArgentMvt> findByDateOpArgentAndIsValideTrue(LocalDate dateOpArgent);

	List<ArgentMvt> findByNatureMvtTrueAndIsValideTrue();

	List<ArgentMvt> findByNatureMvtFalseAndIsValideTrue();

	List<ArgentMvt> findByDateOpArgentAndNatureMvtTrueAndIsValideTrue(LocalDate DateOpArgent);

	List<ArgentMvt> findByDateOpArgentAndNatureMvtFalseAndIsValideTrue(LocalDate DateOpArgent);

	List<ArgentMvt> findByDateOpArgentBetweenAndIsValideTrue(LocalDate date1, LocalDate date2);

	List<ArgentMvt> findByDateOpArgentBetweenAndNatureMvtTrueAndIsValideTrue(LocalDate plusDays, LocalDate plusDays2);

	List<ArgentMvt> findByDateOpArgentBetweenAndNatureMvtFalseAndIsValideTrue(LocalDate plusDays, LocalDate plusDays2);

	ArgentMvt findByMyGestionFactureAndIsValideTrue(GestionFacture gf);

	ArgentMvt findByMyGestionRetourChargmentAndIsValideTrue(GestionRetourChargement grc);

	ArgentMvt findByIdArgentMvtAndIsValideTrue(long idArgentMvt);

	List<ArgentMvt> findByMyCassAndIsValideTrue(Cass c);

}
