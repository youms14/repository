package youmssoft.repository.dao.ventes;

import org.springframework.data.jpa.repository.JpaRepository;

import youmssoft.repository.entities.ventes.Caisse;

public interface CaisseRepository extends  JpaRepository<Caisse,Long>{

	public Caisse findByIdCaisseAndIsValideTrue(long idCaisse);

}
