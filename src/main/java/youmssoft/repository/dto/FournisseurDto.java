package youmssoft.repository.dto;

public class FournisseurDto {
	private long idFournisseur;
	private String nom;
	
	
	
	
	
	public FournisseurDto() {
		super();
	}
	public FournisseurDto(long idFournisseur, String nom) {
		super();
		this.idFournisseur = idFournisseur;
		this.nom = nom;
	}
	public long getIdFournisseur() {
		return idFournisseur;
	}
	public void setIdFournisseur(long idFournisseur) {
		this.idFournisseur = idFournisseur;
	}
	public String getNom() {
		return nom;
	}
	public void setNom(String nom) {
		this.nom = nom;
	}
	
	
	
}
