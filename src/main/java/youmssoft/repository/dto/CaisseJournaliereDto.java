package youmssoft.repository.dto;

import java.time.LocalDate;

public class CaisseJournaliereDto {
	private long idcj;
	private LocalDate date;
	private float amount;
	public CaisseJournaliereDto(long idcj, LocalDate date, float amount) {
		super();
		this.idcj = idcj;
		this.date = date;
		this.amount = amount;
	}
	public CaisseJournaliereDto() {
		super();
	}
	public long getIdcj() {
		return idcj;
	}
	public void setIdcj(long idcj) {
		this.idcj = idcj;
	}
	public LocalDate getDate() {
		return date;
	}
	public void setDate(LocalDate date) {
		this.date = date;
	}
	public float getAmount() {
		return amount;
	}
	public void setAmount(float amount) {
		this.amount = amount;
	}
	
	
	
}
