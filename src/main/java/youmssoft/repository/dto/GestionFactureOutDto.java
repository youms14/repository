package youmssoft.repository.dto;

public class GestionFactureOutDto {
	private long idGestionFacture;
	private float amount;
	private boolean nature;
	private long idFacture;
	private long idPercepteur;
	public long getIdGestionFacture() {
		return idGestionFacture;
	}
	public void setIdGestionFacture(long idGestionFacture) {
		this.idGestionFacture = idGestionFacture;
	}
	public float getAmount() {
		return amount;
	}
	public void setAmount(float amount) {
		this.amount = amount;
	}
	public boolean isNature() {
		return nature;
	}
	public void setNature(boolean nature) {
		this.nature = nature;
	}
	public long getIdFacture() {
		return idFacture;
	}
	public void setIdFacture(long idFacture) {
		this.idFacture = idFacture;
	}
	public long getIdPercepteur() {
		return idPercepteur;
	}
	public void setIdPercepteur(long idPercepteur) {
		this.idPercepteur = idPercepteur;
	}
	public GestionFactureOutDto(long idGestionFacture, float amount, boolean nature, long idFacture,
			long idPercepteur) {
		super();
		this.idGestionFacture = idGestionFacture;
		this.amount = amount;
		this.nature = nature;
		this.idFacture = idFacture;
		this.idPercepteur = idPercepteur;
	}
	public GestionFactureOutDto() {
		super();
	}
	
	
}
