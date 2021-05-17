package youmssoft.repository.dto;



public class NewProductDto {
	private long idLivraison;
	private long idp;
	private float qte;
	private long idmag=0;
	
	
	public long getIdLivraison() {
		return idLivraison;
	}
	public void setIdLivraison(long idLivraison) {
		this.idLivraison = idLivraison;
	}
	public long getIdp() {
		return idp;
	}
	public void setIdp(long p) {
		this.idp = p;
	}
	public float getQte() {
		return qte;
	}
	public void setQte(float qte) {
		this.qte = qte;
	}
	public NewProductDto(long idLivraison, long p, float qte) {
		super();
		this.idLivraison = idLivraison;
		this.idp = p;
		this.qte = qte;
	}
	public NewProductDto() {
		super();
	}
	public long getIdmag() {
		return idmag;
	}
	public void setIdmag(long idmag) {
		this.idmag = idmag;
	}
	
	
	
	

}
