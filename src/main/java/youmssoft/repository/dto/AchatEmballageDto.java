package youmssoft.repository.dto;

import java.time.LocalDate;

public class AchatEmballageDto {
	private long idAchatEmballage;
	private LocalDate dateAchat;
	private float montantAchat;
	private float qteEnCasier;
	private String responsable;
	public AchatEmballageDto(long idAchatEmballage, LocalDate dateAchat, float montantAchat, float qteEnCasier,
			String responsable) {
		super();
		this.idAchatEmballage = idAchatEmballage;
		this.dateAchat = dateAchat;
		this.montantAchat = montantAchat;
		this.qteEnCasier = qteEnCasier;
		this.responsable = responsable;
	}
	public AchatEmballageDto() {
		super();
	}
	public long getIdAchatEmballage() {
		return idAchatEmballage;
	}
	public void setIdAchatEmballage(long idAchatEmballage) {
		this.idAchatEmballage = idAchatEmballage;
	}
	public LocalDate getDateAchat() {
		return dateAchat;
	}
	public void setDateAchat(LocalDate dateAchat) {
		this.dateAchat = dateAchat;
	}
	public float getMontantAchat() {
		return montantAchat;
	}
	public void setMontantAchat(float montantAchat) {
		this.montantAchat = montantAchat;
	}
	public float getQteEnCasier() {
		return qteEnCasier;
	}
	public void setQteEnCasier(float qteEnCasier) {
		this.qteEnCasier = qteEnCasier;
	}
	public String getResponsable() {
		return responsable;
	}
	public void setResponsable(String responsable) {
		this.responsable = responsable;
	}
	
	
	
}
