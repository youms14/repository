package youmssoft.repository.dto;

public class NewPrixProduitDto {
	private long client;
	private long produit;
	private float prix;
	private float rist;
	public NewPrixProduitDto(long client, long produit, float prix, float rist) {
		super();
		this.client = client;
		this.produit = produit;
		this.prix = prix;
		this.rist = rist;
	}
	public NewPrixProduitDto() {
		super();
	}
	public long getClient() {
		return client;
	}
	public void setClient(long client) {
		this.client = client;
	}
	public long getProduit() {
		return produit;
	}
	public void setProduit(long produit) {
		this.produit = produit;
	}
	public float getPrix() {
		return prix;
	}
	public void setPrix(float prix) {
		this.prix = prix;
	}
	public float getRist() {
		return rist;
	}
	public void setRist(float rist) {
		this.rist = rist;
	}
	
	

}
