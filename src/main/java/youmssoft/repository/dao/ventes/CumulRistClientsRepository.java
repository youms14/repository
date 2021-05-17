package youmssoft.repository.dao.ventes;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import youmssoft.repository.entities.ventes.Client;
import youmssoft.repository.entities.ventes.CumulRistClients;
import youmssoft.repository.entities.ventes.Facture;
import youmssoft.repository.entities.ventes.FacturesChargement;

public interface CumulRistClientsRepository extends JpaRepository<CumulRistClients,Long>{

	public List<CumulRistClients> findByIsPayedFalseAndIsValideTrue();

	public List<CumulRistClients> findByClientAndIsPayedFalseAndIsValideTrue(Client client);

	public CumulRistClients findByMyFacturesChargementAndIsValideTrue(FacturesChargement fc);

	public CumulRistClients findByFactureAndIsValideTrue(Facture f);

}
