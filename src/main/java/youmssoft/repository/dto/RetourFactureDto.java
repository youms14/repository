package youmssoft.repository.dto;



public class RetourFactureDto {
	private long idFacture;
	private long secretaire;
	private long argent;
	private long nbSABC;
	private long nbUCB;
	private long nbGUI;
	public long getIdFacture() {
		return idFacture;
	}
	public void setIdFacture(long idFacture) {
		this.idFacture = idFacture;
	}
	public long getSecretaire() {
		return secretaire;
	}
	public void setSecretaire(long secretaire) {
		this.secretaire = secretaire;
	}
	public long getArgent() {
		return argent;
	}
	public void setArgent(long argent) {
		this.argent = argent;
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
	public RetourFactureDto(long idFacture, long secretaire, long argent, long nbSABC, long nbUCB, long nbGUI) {
		super();
		this.idFacture = idFacture;
		this.secretaire = secretaire;
		this.argent = argent;
		this.nbSABC = nbSABC;
		this.nbUCB = nbUCB;
		this.nbGUI = nbGUI;
	}
	public RetourFactureDto() {
		super();
	}

	
}