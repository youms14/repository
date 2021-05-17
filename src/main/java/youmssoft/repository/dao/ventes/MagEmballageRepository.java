package youmssoft.repository.dao.ventes;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import youmssoft.repository.entities.livraison.Fournisseur;
import youmssoft.repository.entities.livraison.Produit;
import youmssoft.repository.entities.ventes.MagEmballage;

public interface MagEmballageRepository extends JpaRepository<MagEmballage,Long>{

	@Query("select n FROM MagEmballage n where n.fournisseur.idFournisseur like :idFournisseur")
	public MagEmballage etatMagEmbParFournisseur(@Param("idFournisseur") long idFournisseur);

	public MagEmballage findByFournisseurAndIsValideTrue(Fournisseur fournisseur); 
	

}
