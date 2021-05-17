package youmssoft.repository.dao.ventes;

import org.springframework.data.jpa.repository.JpaRepository;

import youmssoft.repository.entities.ventes.Depenses;

public interface DepensesRepository extends JpaRepository<Depenses,Long>{

	public Depenses findByIdDepenseAndIsValideTrue(long idDepense);

}
