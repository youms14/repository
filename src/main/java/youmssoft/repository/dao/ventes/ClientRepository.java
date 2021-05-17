package youmssoft.repository.dao.ventes;

import org.springframework.data.jpa.repository.JpaRepository;

import youmssoft.repository.entities.ventes.Client;

public interface ClientRepository extends JpaRepository<Client,Long>{

	public Client findByIdClientAndIsValideTrue(long client);
	
	
}
