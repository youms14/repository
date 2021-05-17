package youmssoft.repository.dao.ventes;

import java.time.LocalDate;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import youmssoft.repository.dto.UsedCaisseJounaliere;
import youmssoft.repository.entities.ventes.ArgentMvt;
import youmssoft.repository.entities.ventes.CaisseJournaliere;

public interface CaisseJournaliereRepository extends JpaRepository<CaisseJournaliere,Long>{

	

	public List<CaisseJournaliere> findByUsedTypeOrUsedTypeAndIsTakedFalse(UsedCaisseJounaliere u1,UsedCaisseJounaliere u2);

	public CaisseJournaliere findByDateBetweenAndIsValideTrue(LocalDate plusDays, LocalDate plusDays2);

	public List<CaisseJournaliere> findByDecaissementCJAndIsValideTrue(ArgentMvt am);

	public CaisseJournaliere findByIdCaisseJournaliereAndIsValideTrue(long cj);

	public List<CaisseJournaliere> findByMontantFinalAndIsTakedFalse(float montantFinal);

	public List<CaisseJournaliere> findByMontantFinalNotAndIsTakedFalse(float montantFinal);

}
