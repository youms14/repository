package youmssoft.repository.dto;

public class GestionLivraisonDto {
	private long idGl;
	private float quantite;
	private String unite;
	private long idLivraison;
	private long idPersonnel;
	private long idPersExt;
	private String etat;
	
	
	public long getIdGl() {
		return idGl;
	}
	public void setIdGl(long idGl) {
		this.idGl = idGl;
	}
	public float getQuantite() {
		return quantite;
	}
	public void setQuantite(float quantite) {
		this.quantite = quantite;
	}
	
	public long getIdLivraison() {
		return idLivraison;
	}
	public void setIdLivraison(long idLivraison) {
		this.idLivraison = idLivraison;
	}
	public long getIdPersonnel() {
		return idPersonnel;
	}
	public void setIdPersonnel(long idPersonnel) {
		this.idPersonnel = idPersonnel;
	}
	public long getIdPersExt() {
		return idPersExt;
	}
	public void setIdPersExt(long idPersExt) {
		this.idPersExt = idPersExt;
	}
	public String getEtat() {
		return etat;
	}
	public void setEtat(String etat) {
		this.etat = etat;
	}
	
	public GestionLivraisonDto(long idGl, float quantite, String unite, long idLivraison, long idPersonnel,
			long idPersExt, String etat) {
		super();
		this.idGl = idGl;
		this.quantite = quantite;
		this.unite = unite;
		this.idLivraison = idLivraison;
		this.idPersonnel = idPersonnel;
		this.idPersExt = idPersExt;
		this.etat = etat;
	}
	public GestionLivraisonDto() {
		// TODO Auto-generated constructor stub
	}
	public String getUnite() {
		return unite;
	}
	public void setUnite(String unite) {
		this.unite = unite;
	}
	
	
	
	
	
	
	

}
