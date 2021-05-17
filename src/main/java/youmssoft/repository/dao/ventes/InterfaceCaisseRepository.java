package youmssoft.repository.dao.ventes;

import org.springframework.data.jpa.repository.JpaRepository;

import youmssoft.repository.entities.ventes.InterfaceCaisse;

public interface InterfaceCaisseRepository extends JpaRepository<InterfaceCaisse,Long>{

	public InterfaceCaisse findByIdIntCaisseAndIsValideTrue(long idIntCaisse);

}
