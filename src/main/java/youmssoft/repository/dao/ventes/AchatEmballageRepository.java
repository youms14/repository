package youmssoft.repository.dao.ventes;

import org.springframework.data.jpa.repository.JpaRepository;

import youmssoft.repository.entities.ventes.AchatEmballage;

public interface AchatEmballageRepository extends JpaRepository<AchatEmballage,Long>{

	public AchatEmballage findByIdAcharEmballageAndIsValideTrue(long achatEmb);

}
