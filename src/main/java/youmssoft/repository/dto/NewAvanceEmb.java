package youmssoft.repository.dto;

public class NewAvanceEmb {
	private long fac;
	private long sec;
	private float sabc;
	private float ucb;
	private float guinness;
	public long getFac() {
		return fac;
	}
	public void setFac(long fac) {
		this.fac = fac;
	}
	public long getSec() {
		return sec;
	}
	public void setSec(long sec) {
		this.sec = sec;
	}
	public float getSabc() {
		return sabc;
	}
	public void setSabc(float sabc) {
		this.sabc = sabc;
	}
	public float getUcb() {
		return ucb;
	}
	public void setUcb(float ucb) {
		this.ucb = ucb;
	}
	public float getGuinness() {
		return guinness;
	}
	public void setGuinness(float guinness) {
		this.guinness = guinness;
	}
	public NewAvanceEmb(long fac, long sec, float sabc, float ucb, float guinness) {
		super();
		this.fac = fac;
		this.sec = sec;
		this.sabc = sabc;
		this.ucb = ucb;
		this.guinness = guinness;
	}
	public NewAvanceEmb() {
		super();
	}
	
	
	
	

}
