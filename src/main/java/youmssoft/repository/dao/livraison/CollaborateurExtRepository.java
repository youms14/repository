package youmssoft.repository.dao.livraison;


import java.util.Collection;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import youmssoft.repository.dto.CollaborateurExtDto;
import youmssoft.repository.entities.livraison.CollaborateurExt;
import youmssoft.repository.entities.livraison.Fournisseur;

public interface CollaborateurExtRepository  extends JpaRepository<CollaborateurExt, Long>{
	
	//public List<CollaborateurExtDto> findByMyFournisseurAndIsValideTrue(Fournisseur myFournisseur);
	
	public List<CollaborateurExt> findByMyFournisseurAndIsValideTrue(Fournisseur myFournisseur);
	
	public List<CollaborateurExt> findByMyFournisseurNomAndIsValideTrue(String nom);

	public CollaborateurExt findByIdCollaborateurExtAndIsValideTrue(long idCollaborateurExt);

}
