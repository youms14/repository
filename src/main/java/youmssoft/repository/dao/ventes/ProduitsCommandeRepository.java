package youmssoft.repository.dao.ventes;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import youmssoft.repository.entities.ventes.Commande;
import youmssoft.repository.entities.ventes.ProduitsCommande;

public interface ProduitsCommandeRepository extends JpaRepository<ProduitsCommande,Long> {

	List<ProduitsCommande> findByMyCommandeAndIsValideTrue(Commande com);

}
