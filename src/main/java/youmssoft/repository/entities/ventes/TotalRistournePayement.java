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
@Table(name="TotalRistournePayement")
public class TotalRistournePayement implements Serializable{

	@Id @GeneratedValue
	@Column(name = "idTotalRistourne", nullable = false, unique=true)
	private long idTotalRistourne;

	@Column(name = "montantTotal", nullable = false)
  private float montantTotal;

	@ManyToOne(fetch = FetchType.EAGER)//cascade = CascadeType.ALL
	@JoinColumn(name = "client", referencedColumnName="idClient", nullable = false) 
  private Client client;

	@Column(name = "periode", nullable = false, length=30)
  private String periode;// chercher s'il existe un objet en java permetant de representer une pépiode

	@OneToOne(fetch = FetchType.EAGER)//cascade = CascadeType.ALL
	@JoinColumn(name = "myArgentMvt", referencedColumnName="idArgentMvt", nullable = false)
    private ArgentMvt myArgentMvt;

	@Column(name = "datePayement", nullable = false)
	private LocalDate datePayement;
	
	@Column(name = "heurePayement", nullable = false)
	private LocalTime heurePayement;

	
	@Column(name = "isValide", nullable = true) 
	 private boolean isValide=true;
	/**
	 * @param idTotalRistourne
	 * @param montantTotal
	 * @param client
	 * @param periode
	 * @param myArgentMvt
	 * @param datePayement
	 * @param heurePayement
	 */
	public TotalRistournePayement(long idTotalRistourne, float montantTotal, Client client, String periode,
			ArgentMvt myArgentMvt, LocalDate datePayement, LocalTime heurePayement) {
		super();
		this.idTotalRistourne = idTotalRistourne;
		this.montantTotal = montantTotal;
		this.client = client;
		this.periode = periode;
		this.myArgentMvt = myArgentMvt;
		this.datePayement = datePayement;
		this.heurePayement = heurePayement;
	}

	/**
	 * @param montantTotal
	 * @param client
	 * @param periode
	 * @param myArgentMvt
	 * @param datePayement
	 * @param heurePayement
	 */
	public TotalRistournePayement(float montantTotal, Client client, String periode, ArgentMvt myArgentMvt,
			LocalDate datePayement, LocalTime heurePayement) {
		super();
		this.montantTotal = montantTotal;
		this.client = client;
		this.periode = periode;
		this.myArgentMvt = myArgentMvt;
		this.datePayement = datePayement;
		this.heurePayement = heurePayement;
	}

	/**
	 * 
	 */
	public TotalRistournePayement() {
		super();
	}

	public long getIdTotalRistourne() {
		return idTotalRistourne;
	}

	public void setIdTotalRistourne(long idTotalRistourne) {
		this.idTotalRistourne = idTotalRistourne;
	}

	public float getMontantTotal() {
		return montantTotal;
	}

	public void setMontantTotal(float montantTotal) {
		this.montantTotal = montantTotal;
	}

	
	public boolean isValide() {
		return isValide;
	}

	public void setValide(boolean isValide) {
		this.isValide = isValide;
	}

	public Client getClient() {
		return client;
	}

	public void setClient(Client client) {
		this.client = client;
	}

	public String getPeriode() {
		return periode;
	}

	public void setPeriode(String periode) {
		this.periode = periode;
	}

	public ArgentMvt getMyArgentMvt() {
		return myArgentMvt;
	}

	public void setMyArgentMvt(ArgentMvt myArgentMvt) {
		this.myArgentMvt = myArgentMvt;
	}

	public LocalDate getDatePayement() {
		return datePayement;
	}

	public void setDatePayement(LocalDate datePayement) {
		this.datePayement = datePayement;
	}

	public LocalTime getHeurePayement() {
		return heurePayement;
	}

	public void setHeurePayement(LocalTime heurePayement) {
		this.heurePayement = heurePayement;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("TotalRistournePayement [idTotalRistourne=");
		builder.append(idTotalRistourne);
		builder.append(", montantTotal=");
		builder.append(montantTotal);
		builder.append(", client=");
		builder.append(client);
		builder.append(", periode=");
		builder.append(periode);
		builder.append(", myArgentMvt=");
		builder.append(myArgentMvt);
		builder.append(", datePayement=");
		builder.append(datePayement);
		builder.append(", heurePayement=");
		builder.append(heurePayement);
		builder.append("]");
		return builder.toString();
	}
	
	
	
	
	
	
}