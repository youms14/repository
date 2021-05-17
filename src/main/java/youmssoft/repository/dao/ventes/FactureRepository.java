package youmssoft.repository.dao.ventes;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import youmssoft.repository.dto.FactureDto;
import youmssoft.repository.entities.ventes.Client;
import youmssoft.repository.entities.ventes.Facture;

public interface FactureRepository extends JpaRepository<Facture,Long>{

	public List<Facture> findByClientFactAndIsValideTrue(Client clientFac);

	public List<Facture> findByIsSoldedFactureAndIsValideTrue(boolean isSoldedFacture);

	public List<Facture> findByIsEmbOkFactureAndIsValideTrue(boolean isEmbOkFacture);

	public List<Facture> findByClientFactAndIsEmbOkFactureFalseOrIsSoldedFactureFalseAndIsValideTrue(Client clientFac);

	public List<FactureDto> findByIsEmbOkFactureFalseOrIsSoldedFactureFalseAndIsValideTrue();

	public List<Facture> findByIsLivredFalseAndIsValideTrue();

	public Facture findByIdFactureAndIsValideTrue(long idFacture);

}
