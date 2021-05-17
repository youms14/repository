package youmssoft.repository.dto;

public class ServiceFactureDto {
	private long idFacture;
	private long idMag;
	private long idLiv;
	public ServiceFactureDto(long idFacture, long idMag, long idLiv) {
		super();
		this.idFacture = idFacture;
		this.idMag = idMag;
		this.idLiv = idLiv;
	}
	public ServiceFactureDto() {
		super();
	}
	public long getIdFacture() {
		return idFacture;
	}
	public void setIdFacture(long idFacture) {
		this.idFacture = idFacture;
	}
	public long getIdMag() {
		return idMag;
	}
	public void setIdMag(long idMag) {
		this.idMag = idMag;
	}
	public long getIdLiv() {
		return idLiv;
	}
	public void setIdLiv(long idLiv) {
		this.idLiv = idLiv;
	}
	
	
	

}
