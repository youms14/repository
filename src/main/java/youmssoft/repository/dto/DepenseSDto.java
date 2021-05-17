package youmssoft.repository.dto;

import java.time.LocalDate;
import java.time.LocalTime;

public class DepenseSDto {
	private long idDepense;
	private String responsable;
	private String secretaire;
	private float amount;
	private String motif;
	private LocalDate date;
	private LocalTime heure;
	public DepenseSDto(long idDepense, String responsable, String secretaire, float amount, String motif,
			LocalDate date, LocalTime heure) {
		super();
		this.idDepense = idDepense;
		this.responsable = responsable;
		this.secretaire = secretaire;
		this.amount = amount;
		this.motif = motif;
		this.date = date;
		this.heure = heure;
	}
	public long getIdDepense() {
		return idDepense;
	}
	public void setIdDepense(long idDepense) {
		this.idDepense = idDepense;
	}
	public String getResponsable() {
		return responsable;
	}
	public void setResponsable(String responsable) {
		this.responsable = responsable;
	}
	public String getSecretaire() {
		return secretaire;
	}
	public void setSecretaire(String secretaire){
		this.secretaire = secretaire;
	}
	public float getAmount(){
		return amount;
	}
	public void setAmount(float amount){
		this.amount = amount;
	}
	public String getMotif(){
		return motif;
	}
	public void setMotif(String motif){
		this.motif = motif;
	}
	public LocalDate getDate(){
		return date;
	}
	public void setDate(LocalDate date){
		this.date = date;
	}
	public LocalTime getHeure(){
		return heure;
	}
	public void setHeure(LocalTime heure) {
		this.heure = heure;
	}
	public DepenseSDto(){
		super();
	}

}
