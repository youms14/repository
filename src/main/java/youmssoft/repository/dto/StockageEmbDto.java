package youmssoft.repository.dto;

public class StockageEmbDto {

	private long idAe;
	private long mag;
	private long nbSABC;
	private long nbUCB;
	private long nbGUI;
	
	
	
	
	public StockageEmbDto() {
		super();
	}
	public StockageEmbDto(long idAe, long mag, long nbSABC, long nbUCB, long nbGUI) {
		super();
		this.idAe = idAe;
		this.mag = mag;
		this.nbSABC = nbSABC;
		this.nbUCB = nbUCB;
		this.nbGUI = nbGUI;
	}
	public long getIdAe() {
		return idAe;
	}
	public void setIdAe(long idAe) {
		this.idAe = idAe;
	}
	public long getMag() {
		return mag;
	}
	public void setMag(long mag) {
		this.mag = mag;
	}
	public long getNbSABC() {
		return nbSABC;
	}
	public void setNbSABC(long nbSABC) {
		this.nbSABC = nbSABC;
	}
	public long getNbUCB() {
		return nbUCB;
	}
	public void setNbUCB(long nbUCB) {
		this.nbUCB = nbUCB;
	}
	public long getNbGUI() {
		return nbGUI;
	}
	public void setNbGUI(long nbGUI) {
		this.nbGUI = nbGUI;
	}
	
	
	
}
