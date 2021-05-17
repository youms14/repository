package youmssoft.repository.dao.ventes;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import youmssoft.repository.entities.livraison.Produit;
import youmssoft.repository.entities.ventes.Facture;
import youmssoft.repository.entities.ventes.ProduitsFacture;

public interface ProduitsFactureRepository extends JpaRepository<ProduitsFacture,Long>{

	public List<ProduitsFacture> findByMyFactureAndIsValideTrue(Facture myFacture);

	public ProduitsFacture findByMyFactureAndProduitPFAndIsValideTrue(Facture f, Produit p);

}
