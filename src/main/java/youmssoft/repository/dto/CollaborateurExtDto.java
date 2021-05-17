package youmssoft.repository.dto;

import javax.persistence.Column;

public class CollaborateurExtDto {

	 private long idCollaborateurExt;
	
	 private String nomCE;
	 
	 private String prenomCE;
	 
	 private String nomFour;
	 
	 
	 
	 
	

	public CollaborateurExtDto(long idCollaborateurExt, String nomCE, String prenomCE, String nomFour) {
		super();
		this.idCollaborateurExt = idCollaborateurExt;
		this.nomCE = nomCE;
		this.prenomCE = prenomCE;
		this.nomFour = nomFour;
	}

	public String getNomFour() {
		return nomFour;
	}

	public void setNomFour(String nomFour) {
		this.nomFour = nomFour;
	}

	public CollaborateurExtDto() {
		super();
	}

	public long getIdCollaborateurExt() {
		return idCollaborateurExt;
	}

	public void setIdCollaborateurExt(long idCollaborateurExt) {
		this.idCollaborateurExt = idCollaborateurExt;
	}

	public String getNomCE() {
		return nomCE;
	}

	public void setNomCE(String nomCE) {
		this.nomCE = nomCE;
	}

	public String getPrenomCE() {
		return prenomCE;
	}

	public void setPrenomCE(String prenomCE) {
		this.prenomCE = prenomCE;
	}
	 
	 
	 

}
