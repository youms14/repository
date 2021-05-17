package youmssoft.repository.dao.ventes;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import youmssoft.repository.entities.ventes.Facture;
import youmssoft.repository.entities.ventes.GestionFacture;


public interface GestionFactureRepository extends JpaRepository<GestionFacture,Long>{

	public List<GestionFacture> findByMyFactureAndIsValideTrue(Facture myFacture);

	public GestionFacture findByIdGestionFactureAndIsValideTrue(long gesfac);

}
