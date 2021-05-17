package youmssoft.repository.dto;

public class ProduitsLivraisonDto {
	private float qte;
	private String nomProduit;
	private float prixTotal;
	
	
	
	
	
	public ProduitsLivraisonDto() {
		super();
	}
	public ProduitsLivraisonDto(float qte, String nomProduit, float prixTotal) {
		super();
		this.qte = qte;
		this.nomProduit = nomProduit;
		this.prixTotal = prixTotal;
	}
	public float getQte() {
		return qte;
	}
	public void setQte(float qte) {
		this.qte = qte;
	}
	public String getNomProduit() {
		return nomProduit;
	}
	public void setNomProduit(String nomProduit) {
		this.nomProduit = nomProduit;
	}
	public float getPrixTotal() {
		return prixTotal;
	}
	public void setPrixTotal(float prixTotal) {
		this.prixTotal = prixTotal;
	}
	
	
	

}
