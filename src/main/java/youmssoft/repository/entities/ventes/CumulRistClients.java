package youmssoft.repository.entities.ventes;

import java.io.Serializable;
import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="CumulRistClients")
public class CumulRistClients implements Serializable{

	@Id @GeneratedValue
	@Column(name = "idCRC", nullable = false, unique=true)
	private long idCRC;

	@ManyToOne(fetch = FetchType.EAGER)//cascade = CascadeType.ALL
	@JoinColumn(name = "client", referencedColumnName="idClient", nullable = false) 
	private Client client;

	@Column(name = "date", nullable = false)
	private LocalDate date;

	@ManyToOne(fetch = FetchType.EAGER)//cascade = CascadeType.ALL
	@JoinColumn(name = "facture", referencedColumnName="idFacture", nullable = true)
	private Facture facture;

	@ManyToOne(fetch = FetchType.EAGER)//cascade = CascadeType.ALL
	@JoinColumn(name = "myFacturesChargement", referencedColumnName="idFactCharg", nullable = true)
	private FacturesChargement myFacturesChargement; 
	
  @Column(name = "montant", nullable = false)
  private float montant;

  @Column(name = "isPayed", nullable = false)
  private boolean isPayed;//vas servir lors du payement des ristournes.
  
  @Column(name = "isValide", nullable = true) 
	 private boolean isValide=true;

/**
 * @param idCRC
 * @param client
 * @param date
 * @param facture
 * @param montant
 * @param isPayed
 */
public CumulRistClients(long idCRC, Client client, LocalDate date, Facture facture, float montant, boolean isPayed) {
	super();
	this.idCRC = idCRC;
	this.client = client;
	this.date = date;
	this.facture = facture;
	this.montant = montant;
	this.isPayed = isPayed;
}

/**
 * @param client
 * @param date
 * @param facture
 * @param montant
 * @param isPayed
 */
public CumulRistClients(Client client, LocalDate date, Facture facture, float montant, boolean isPayed) {
	super();
	this.client = client;
	this.date = date;
	this.facture = facture;
	this.montant = montant;
	this.isPayed = isPayed;
}

/**
 * 
 */
public CumulRistClients() {
	super();
}



public boolean isValide() {
	return isValide;
}

public void setValide(boolean isValide) {
	this.isValide = isValide;
}

public FacturesChargement getMyFacturesChargement() {
	return myFacturesChargement;
}

public void setMyFacturesChargement(FacturesChargement myFacturesChargement) {
	this.myFacturesChargement = myFacturesChargement;
}

public long getIdCRC() {
	return idCRC;
}

public void setIdCRC(long idCRC) {
	this.idCRC = idCRC;
}

public Client getClient() {
	return client;
}

public void setClient(Client client) {
	this.client = client;
}

public LocalDate getDate() {
	return date;
}

public void setDate(LocalDate date) {
	this.date = date;
}

public Facture getFacture() {
	return facture;
}

public void setFacture(Facture facture) {
	this.facture = facture;
}

public float getMontant() {
	return montant;
}

public void setMontant(float montant) {
	this.montant = montant;
}

public boolean isPayed() {
	return isPayed;
}

public void setPayed(boolean isPayed) {
	this.isPayed = isPayed;
}

@Override
public String toString() {
	StringBuilder builder = new StringBuilder();
	builder.append("CumulRistClients [idCRC=");
	builder.append(idCRC);
	builder.append(", client=");
	builder.append(client);
	builder.append(", date=");
	builder.append(date);
	builder.append(", facture=");
	builder.append(facture);
	builder.append(", montant=");
	builder.append(montant);
	builder.append(", isPayed=");
	builder.append(isPayed);
	builder.append("]");
	return builder.toString();
}

  
}