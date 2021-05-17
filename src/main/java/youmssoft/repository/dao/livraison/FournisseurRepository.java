package youmssoft.repository.dao.livraison;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import youmssoft.repository.entities.livraison.Fournisseur;

public interface FournisseurRepository extends JpaRepository<Fournisseur, Long>{

	public Fournisseur findByIdFournisseurAndIsValideTrue(long idSabc);

	public List<Fournisseur> findByIsValideTrue();

}
