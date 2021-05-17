package youmssoft.repository.dto;

public class LivraisonDto {
	private long idLivraison;
	private float nbEmb;
	private float nbColis;
	private float solde;
	private String numFactLiv="";
	
	
	
	
	
	public LivraisonDto(long idLivraison, float nbEmb, float nbColis, float solde, String numFactLiv) {
		super();
		this.idLivraison = idLivraison;
		this.nbEmb = nbEmb;
		this.nbColis = nbColis;
		this.solde = solde;
		this.numFactLiv = numFactLiv;
	}
	public String getNumFactLiv() {
		return numFactLiv;
	}
	public void setNumFactLiv(String numFactLiv) {
		this.numFactLiv = numFactLiv;
	}
	public LivraisonDto(long idLivraison, float nbEmb, float nbColis, float solde) {
		super();
		this.idLivraison = idLivraison;
		this.nbEmb = nbEmb;
		this.nbColis = nbColis;
		this.solde = solde;
	}
	public LivraisonDto() {
		super();
	}
	public long getIdLivraison() {
		return idLivraison;
	}
	public void setIdLivraison(long idLivraison) {
		this.idLivraison = idLivraison;
	}
	public float getNbEmb() {
		return nbEmb;
	}
	public void setNbEmb(float nbEmb) {
		this.nbEmb = nbEmb;
	}
	public float getNbColis() {
		return nbColis;
	}
	public void setNbColis(float nbColis) {
		this.nbColis = nbColis;
	}
	public float getSolde() {
		return solde;
	}
	public void setSolde(float solde) {
		this.solde = solde;
	}
	
	
}
