package youmssoft.repository.dao.ventes;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import youmssoft.repository.entities.ventes.DetailsFacture;
import youmssoft.repository.entities.ventes.Facture;

public interface DetailsFactureRepository extends JpaRepository<DetailsFacture,Long>{

	public DetailsFacture findByIdDetailsFactureAndIsValideTrue(long idDetailsFacture);

}
