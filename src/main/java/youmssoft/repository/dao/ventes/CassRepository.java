package youmssoft.repository.dao.ventes;

import java.time.LocalDate;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import youmssoft.repository.entities.ventes.Cass;

public interface CassRepository extends JpaRepository<Cass,Long>{

	public List<Cass> findByDateCassAndIsValideTrue(LocalDate dateCass);

	public Cass findByIdCassAndIsValideTrue(long idCass);

}
