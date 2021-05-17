package youmssoft.repository.dto;

public class NewLivraisonDTO {
	long idPersonnel;
	long idCollaborateurExt;
	
	
	
	public NewLivraisonDTO(long idPersonnel, long idCollaborateurExt) {
		super();
		this.idPersonnel = idPersonnel;
		this.idCollaborateurExt = idCollaborateurExt;
	}
	public long getIdPersonnel() {
		return idPersonnel;
	}
	public void setIdPersonnel(long idPersonnel) {
		this.idPersonnel = idPersonnel;
	}
	public long getIdCollaborateurExt() {
		return idCollaborateurExt;
	}
	public void setIdCollaborateurExt(long idCollaborateurExt) {
		this.idCollaborateurExt = idCollaborateurExt;
	}
	
	
	
	

}
