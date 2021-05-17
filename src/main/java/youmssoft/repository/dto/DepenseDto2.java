package youmssoft.repository.dto;

public class DepenseDto2 {
	private long idDepense;
	private float amount;
	private String motif;
	private long responsable=-1;
	private long secretaire=-1;
	
	
	public long getIdDepense() {
		return idDepense;
	}
	public void setIdDepense(long idDepense) {
		this.idDepense = idDepense;
	}
	public float getAmount() {
		return amount;
	}
	public void setAmount(float amount) {
		this.amount = amount;
	}
	public String getMotif() {
		return motif;
	}
	public void setMotif(String motif) {
		this.motif = motif;
	}
	public long getResponsable() {
		return responsable;
	}
	public void setResponsable(long responsable) {
		this.responsable = responsable;
	}
	public long getSecretaire() {
		return secretaire;
	}
	public void setSecretaire(long secretaire) {
		this.secretaire = secretaire;
	}
	public DepenseDto2(long idDepense, float amount, String motif, long responsable, long secretaire) {
		super();
		this.idDepense = idDepense;
		this.amount = amount;
		this.motif = motif;
		this.responsable = responsable;
		this.secretaire = secretaire;
	}
	public DepenseDto2() {
		super();
	}
	
	

}
