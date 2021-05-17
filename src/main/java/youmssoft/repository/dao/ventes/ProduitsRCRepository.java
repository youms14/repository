package youmssoft.repository.dao.ventes;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import youmssoft.repository.entities.livraison.Produit;
import youmssoft.repository.entities.ventes.ProduitsRC;
import youmssoft.repository.entities.ventes.RetourChargement;

public interface ProduitsRCRepository extends JpaRepository<ProduitsRC,Long>{

	//public List<ProduitsRC> findByMyRetourChargment(RetourChargement myRetourChargment);

	public ProduitsRC findByMyRetourChargmentAndProduitRCAndIsValideTrue(RetourChargement myRetourChargment, Produit produit);

	public List<ProduitsRC> findByMyRetourChargmentAndIsValideTrue(RetourChargement rc);

}
