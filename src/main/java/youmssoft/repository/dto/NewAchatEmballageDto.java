package youmssoft.repository.dto;

public class NewAchatEmballageDto {
	private float qteEnBout;
	private float montant;
	private String source;
	private long responsable;
	public float getQteEnBout() {
		return qteEnBout;
	}
	public void setQteEnBout(float qteEnBout) {
		this.qteEnBout = qteEnBout;
	}
	public float getMontant() {
		return montant;
	}
	public void setMontant(float montant) {
		this.montant = montant;
	}
	public String getSource() {
		return source;
	}
	public void setSource(String source) {
		this.source = source;
	}
	public long getResponsable() {
		return responsable;
	}
	public void setResponsable(long responsable) {
		this.responsable = responsable;
	}
	public NewAchatEmballageDto(float qteEnBout, float montant, String source, long responsable) {
		super();
		this.qteEnBout = qteEnBout;
		this.montant = montant;
		this.source = source;
		this.responsable = responsable;
	}
	public NewAchatEmballageDto() {
		super();
	}
	
	
	
}
