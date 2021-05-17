package youmssoft.repository.entities.ventes;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name="FacturesChargement")
public class FacturesChargement implements Serializable{//ok

	@Id @GeneratedValue
	@Column(name = "idFactCharg", nullable = false, unique=true)
	private long idFactCharg;

  @Column(name = "dateFC", nullable = false)
  private LocalDate dateFC;

  @Column(name = "heureFC", nullable = false)
  private LocalTime heureFC;

  @Column(name = "nbColisFC", nullable = false)
  private float nbColisFC;

  @Column(name = "nbEmbFC", nullable = false)
  private float nbEmbFC;

  @Column(name = "soldeFC", nullable = false)
  private float soldeFC;

  @Column(name = "totalRistFC", nullable = false)
  private float totalRistFC;

  @Column(name = "isSolded", nullable = false)
  private boolean isSolded;

  @Column(name = "isEmbOk", nullable = false)
  private boolean isEmbOk;

  	@ManyToOne(fetch = FetchType.EAGER)//cascade = CascadeType.ALL
	@JoinColumn(name = "myChargement", referencedColumnName="idChargement", nullable = false)
    public Chargement myChargement;
    
    @ManyToOne(fetch = FetchType.EAGER)//cascade = CascadeType.ALL
	@JoinColumn(name = "myClient", referencedColumnName="idClient", nullable = false)
    public Client myClient;
   
    @OneToOne(fetch = FetchType.EAGER)//cascade = CascadeType.ALL
	@JoinColumn(name = "myDetailsFC", referencedColumnName="idDetailsFC", nullable = true)
    public DetailsFC myDetailsFC;
    
    @Column(name = "isValide", nullable = true) 
	 private boolean isValide=true;

	/**
	 * @param idFactCharg
	 * @param dateFC
	 * @param heureFC
	 * @param nbColisFC
	 * @param nbEmbFC
	 * @param soldeFC
	 * @param totalRistFC
	 * @param isSolded
	 * @param isEmbOk
	 * @param myChargement
	 * @param myClient
	 * @param myDetailsFC
	 */
	public FacturesChargement(long idFactCharg, LocalDate dateFC, LocalTime heureFC, float nbColisFC, float nbEmbFC,
			float soldeFC, float totalRistFC, boolean isSolded, boolean isEmbOk, Chargement myChargement,
			Client myClient, DetailsFC myDetailsFC) {
		super();
		this.idFactCharg = idFactCharg;
		this.dateFC = dateFC;
		this.heureFC = heureFC;
		this.nbColisFC = nbColisFC;
		this.nbEmbFC = nbEmbFC;
		this.soldeFC = soldeFC;
		this.totalRistFC = totalRistFC;
		this.isSolded = isSolded;
		this.isEmbOk = isEmbOk;
		this.myChargement = myChargement;
		this.myClient = myClient;
		this.myDetailsFC = myDetailsFC;
	}

	/**
	 * 
	 */
	public FacturesChargement() {
		super();
	}

	/**
	 * @param dateFC
	 * @param heureFC
	 * @param nbColisFC
	 * @param nbEmbFC
	 * @param soldeFC
	 * @param totalRistFC
	 * @param isSolded
	 * @param isEmbOk
	 * @param myChargement
	 * @param myClient
	 * @param myDetailsFC
	 */
	public FacturesChargement(LocalDate dateFC, LocalTime heureFC, float nbColisFC, float nbEmbFC, float soldeFC,
			float totalRistFC, boolean isSolded, boolean isEmbOk, Chargement myChargement, Client myClient,
			DetailsFC myDetailsFC) {
		super();
		this.dateFC = dateFC;
		this.heureFC = heureFC;
		this.nbColisFC = nbColisFC;
		this.nbEmbFC = nbEmbFC;
		this.soldeFC = soldeFC;
		this.totalRistFC = totalRistFC;
		this.isSolded = isSolded;
		this.isEmbOk = isEmbOk;
		this.myChargement = myChargement;
		this.myClient = myClient;
		this.myDetailsFC = myDetailsFC;
	}

	
	
	public long getIdFactCharg() {
		return idFactCharg;
	}

	public void setIdFactCharg(long idFactCharg) {
		this.idFactCharg = idFactCharg;
	}

	public LocalDate getDateFC() {
		return dateFC;
	}

	public void setDateFC(LocalDate dateFC) {
		this.dateFC = dateFC;
	}

	public LocalTime getHeureFC() {
		return heureFC;
	}

	public void setHeureFC(LocalTime heureFC) {
		this.heureFC = heureFC;
	}

	public float getNbColisFC() {
		return nbColisFC;
	}

	public void setNbColisFC(float nbColisFC) {
		this.nbColisFC = nbColisFC;
	}
	
	

	public boolean isValide() {
		return isValide;
	}

	public void setValide(boolean isValide) {
		this.isValide = isValide;
	}

	public float getNbEmbFC() {
		return nbEmbFC;
	}

	public void setNbEmbFC(float nbEmbFC) {
		this.nbEmbFC = nbEmbFC;
	}

	public float getSoldeFC() {
		return soldeFC;
	}

	public void setSoldeFC(float soldeFC) {
		this.soldeFC = soldeFC;
	}

	public float getTotalRistFC() {
		return totalRistFC;
	}

	public void setTotalRistFC(float totalRistFC) {
		this.totalRistFC = totalRistFC;
	}

	public boolean isSolded() {
		return isSolded;
	}

	public void setSolded(boolean isSolded) {
		this.isSolded = isSolded;
	}

	public boolean isEmbOk() {
		return isEmbOk;
	}

	public void setEmbOk(boolean isEmbOk) {
		this.isEmbOk = isEmbOk;
	}

	public Chargement getMyChargement() {
		return myChargement;
	}

	public void setMyChargement(Chargement myChargement) {
		this.myChargement = myChargement;
	}

	public Client getMyClient() {
		return myClient;
	}

	public void setMyClient(Client myClient) {
		this.myClient = myClient;
	}

	public DetailsFC getMyDetailsFC() {
		return myDetailsFC;
	}

	public void setMyDetailsFC(DetailsFC myDetailsFC) {
		this.myDetailsFC = myDetailsFC;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("FacturesChargement [idFactCharg=");
		builder.append(idFactCharg);
		builder.append(", dateFC=");
		builder.append(dateFC);
		builder.append(", heureFC=");
		builder.append(heureFC);
		builder.append(", nbColisFC=");
		builder.append(nbColisFC);
		builder.append(", nbEmbFC=");
		builder.append(nbEmbFC);
		builder.append(", soldeFC=");
		builder.append(soldeFC);
		builder.append(", totalRistFC=");
		builder.append(totalRistFC);
		builder.append(", isSolded=");
		builder.append(isSolded);
		builder.append(", isEmbOk=");
		builder.append(isEmbOk);
		builder.append(", myChargement=");
		builder.append(myChargement);
		builder.append(", myClient=");
		builder.append(myClient);
		builder.append(", myDetailsFC=");
		builder.append(myDetailsFC);
		builder.append("]");
		return builder.toString();
	}

    
    
}