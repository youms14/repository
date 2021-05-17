package youmssoft.repository.dao.ventes;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import youmssoft.repository.entities.ventes.GestionRetourChargement;
import youmssoft.repository.entities.ventes.RetourChargement;

public interface GestionRetourChargementRepository extends JpaRepository<GestionRetourChargement,Long> {

	List<GestionRetourChargement> findByMyRetourChargmentAndIsValideTrue(RetourChargement rc);

}
