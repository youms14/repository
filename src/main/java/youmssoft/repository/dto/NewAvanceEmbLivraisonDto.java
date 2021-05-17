package youmssoft.repository.dto;

public class NewAvanceEmbLivraisonDto {
	private long liv;
	private long pers;
	private long ce;
	private float avance;
	
	
	
	
	public long getLiv() {
		return liv;
	}
	public void setLiv(long liv) {
		this.liv = liv;
	}
	public long getPers() {
		return pers;
	}
	public void setPers(long pers) {
		this.pers = pers;
	}
	public long getCe() {
		return ce;
	}
	public void setCe(long ce) {
		this.ce = ce;
	}
	public float getAvance() {
		return avance;
	}
	public void setAvance(float avance) {
		this.avance = avance;
	}
	public NewAvanceEmbLivraisonDto(long liv, long pers, long ce, float avance) {
		super();
		this.liv = liv;
		this.pers = pers;
		this.ce = ce;
		this.avance = avance;
	}
	
	
	
	

}
