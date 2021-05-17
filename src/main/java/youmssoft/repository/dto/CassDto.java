package youmssoft.repository.dto;


public class CassDto {
	  
	private long idCass=-1;
	  private Boolean nature;//1 for product and 0 for bottle
	  private float nbBout;
	  private long auteurCass;
	  private String raison;
	  private float montantDommage;
	  private long produitCass;
	  
	  
	public CassDto(Boolean nature, float nbBout, long auteurCass, String raison, float montantDommage,
			long produitCass) {
		super();
		this.nature = nature;
		this.nbBout = nbBout;
		this.auteurCass = auteurCass;
		this.raison = raison;
		this.montantDommage = montantDommage;
		this.produitCass = produitCass;
	}
	
	
	public CassDto(long idCass, Boolean nature, float nbBout, long auteurCass, String raison, float montantDommage,
			long produitCass) {
		super();
		this.idCass = idCass;
		this.nature = nature;
		this.nbBout = nbBout;
		this.auteurCass = auteurCass;
		this.raison = raison;
		this.montantDommage = montantDommage;
		this.produitCass = produitCass;
	}


	public long getIdCass() {
		return idCass;
	}


	public void setIdCass(long idCass) {
		this.idCass = idCass;
	}


	public CassDto() {
		super();
	}
	public Boolean getNature() {
		return nature;
	}
	public void setNature(Boolean nature) {
		this.nature = nature;
	}
	public float getNbBout() {
		return nbBout;
	}
	public void setNbBout(float nbBout) {
		this.nbBout = nbBout;
	}
	public long getAuteurCass() {
		return auteurCass;
	}
	public void setAuteurCass(long auteurCass) {
		this.auteurCass = auteurCass;
	}
	public String getRaison() {
		return raison;
	}
	public void setRaison(String raison) {
		this.raison = raison;
	}
	public float getMontantDommage() {
		return montantDommage;
	}
	public void setMontantDommage(float montantDommage) {
		this.montantDommage = montantDommage;
	}
	public long getProduitCass() {
		return produitCass;
	}
	public void setProduitCass(long produitCass) {
		this.produitCass = produitCass;
	}
	  
	  
	  
	  
	  

}
