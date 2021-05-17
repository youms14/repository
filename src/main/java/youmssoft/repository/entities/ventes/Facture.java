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

import youmssoft.repository.entities.livraison.Personnel;

@Entity
@Table(name="Facture")
public class Facture implements Serializable{

	 @Id @GeneratedValue
	 @Column(name = "idFacture", nullable = false, unique=true)
	 private long idFacture;

	 @Column(name = "dateFact", nullable = false)
	 private LocalDate dateFact;
	 
	 @Column(name = "heure", nullable = false)
	 private LocalTime heure;

	 @Column(name = "soldeFact", nullable = false)
	 private float soldeFact;

	 @Column(name = "nbColisFact", nullable = false)
	 private float nbColisFact;

  @Column(name = "nbEmbFact", nullable = false)
  private float nbEmbFact;

  @Column(name = "totalRistFact", nullable = false)
  private float totalRistFact;
  
  	 @ManyToOne(fetch = FetchType.EAGER)//cascade = CascadeType.ALL
	 @JoinColumn(name = "livreur", referencedColumnName="idPersonnel", nullable = true)
	 private Personnel livreur;
  	 
  	@ManyToOne(fetch = FetchType.EAGER)//cascade = CascadeType.ALL
	@JoinColumn(name = "client", referencedColumnName="idClient", nullable = true) 
  private Client clientFact;

  @ManyToOne(fetch = FetchType.EAGER)//cascade = CascadeType.ALL
  @JoinColumn(name = "secrectaireFact", referencedColumnName="idPersonnel", nullable = false)
  private Personnel secrectaireFact;

  @ManyToOne(fetch = FetchType.EAGER)//cascade = CascadeType.ALL
  @JoinColumn(name = "magasinierFact", referencedColumnName="idPersonnel", nullable = true)
  private Personnel magasinierFact;

  @Column(name = "isSoldedFacture", nullable = false)
  private boolean isSoldedFacture;

  @Column(name = "isEmbOkFacture", nullable = false)
  private boolean isEmbOkFacture;
  
  @Column(name = "isLivred", nullable = true)
  private boolean isLivred;
  
  @OneToOne(fetch = FetchType.EAGER)//cascade = CascadeType.ALL
  @JoinColumn(name = "myDetailsFacture", referencedColumnName="idDetailsFacture", nullable = true)
  private DetailsFacture myDetailsFacture;
  
  @Column(name = "isValide", nullable = true) 
	 private boolean isValide=true;

/**
 * @param idFacture
 * @param dateFact
 * @param heure
 * @param soldeFact
 * @param nbColisFact
 * @param nbEmbFact
 * @param totalRistFact
 * @param livreur
 * @param clientFact
 * @param secrectaireFact
 * @param magasinierFact
 * @param isSoldedFacture
 * @param isEmbOkFacture
 * @param myDetailsFacture
 */
public Facture(long idFacture, LocalDate dateFact, LocalTime heure, float soldeFact, float nbColisFact, float nbEmbFact,
		float totalRistFact, Personnel livreur, Client clientFact, Personnel secrectaireFact, Personnel magasinierFact,
		boolean isSoldedFacture, boolean isEmbOkFacture, DetailsFacture myDetailsFacture, boolean isLivred) {
	super();
	this.idFacture = idFacture;
	this.dateFact = dateFact;
	this.heure = heure;
	this.soldeFact = soldeFact;
	this.nbColisFact = nbColisFact;
	this.nbEmbFact = nbEmbFact;
	this.totalRistFact = totalRistFact;
	this.livreur = livreur;
	this.clientFact = clientFact;
	this.secrectaireFact = secrectaireFact;
	this.magasinierFact = magasinierFact;
	this.isSoldedFacture = isSoldedFacture;
	this.isEmbOkFacture = isEmbOkFacture;
	this.myDetailsFacture = myDetailsFacture;
	this. isLivred= isLivred;
}

/**
 * 
 */
public Facture() {
	super();
	this.dateFact = LocalDate.now();
	this.heure = LocalTime.now();
	this.soldeFact = 0;
	this.nbColisFact = 0;
	this.nbEmbFact = 0;
	this.totalRistFact = 0;
	this.isSoldedFacture = false;
	this.isEmbOkFacture = false;
	this. isLivred= false;
}

/**
 * @param dateFact
 * @param heure
 * @param soldeFact
 * @param nbColisFact
 * @param nbEmbFact
 * @param totalRistFact
 * @param livreur
 * @param clientFact
 * @param secrectaireFact
 * @param magasinierFact
 * @param isSoldedFacture
 * @param isEmbOkFacture
 * @param myDetailsFacture
 */
public Facture(LocalDate dateFact, LocalTime heure, float soldeFact, float nbColisFact, float nbEmbFact,
		float totalRistFact, Personnel livreur, Client clientFact, Personnel secrectaireFact, Personnel magasinierFact,
		boolean isSoldedFacture, boolean isEmbOkFacture, DetailsFacture myDetailsFacture, boolean isLivred) {
	super();
	this.dateFact = dateFact;
	this.heure = heure;
	this.soldeFact = soldeFact;
	this.nbColisFact = nbColisFact;
	this.nbEmbFact = nbEmbFact;
	this.totalRistFact = totalRistFact;
	this.livreur = livreur;
	this.clientFact = clientFact;
	this.secrectaireFact = secrectaireFact;
	this.magasinierFact = magasinierFact;
	this.isSoldedFacture = isSoldedFacture;
	this.isEmbOkFacture = isEmbOkFacture;
	this.myDetailsFacture = myDetailsFacture;
	this. isLivred= isLivred;
}



public boolean isLivred() {
	return isLivred;
}

public void setLivred(boolean isLivred) {
	this.isLivred = isLivred;
}

public long getIdFacture() {
	return idFacture;
}

public void setIdFacture(long idFacture) {
	this.idFacture = idFacture;
}

public LocalDate getDateFact() {
	return dateFact;
}

public void setDateFact(LocalDate dateFact) {
	this.dateFact = dateFact;
}

public boolean isValide() {
	return isValide;
}

public void setValide(boolean isValide) {
	this.isValide = isValide;
}

public LocalTime getHeure() {
	return heure;
}

public void setHeure(LocalTime heure) {
	this.heure = heure;
}

public float getSoldeFact() {
	return soldeFact;
}

public void setSoldeFact(float soldeFact) {
	this.soldeFact = soldeFact;
}

public float getNbColisFact() {
	return nbColisFact;
}

public void setNbColisFact(float nbColisFact) {
	this.nbColisFact = nbColisFact;
}

public float getNbEmbFact() {
	return nbEmbFact;
}

public void setNbEmbFact(float nbEmbFact) {
	this.nbEmbFact = nbEmbFact;
}

public float getTotalRistFact() {
	return totalRistFact;
}

public void setTotalRistFact(float totalRistFact) {
	this.totalRistFact = totalRistFact;
}

public Personnel getLivreur() {
	return livreur;
}

public void setLivreur(Personnel livreur) {
	this.livreur = livreur;
}

public Client getClientFact() {
	return clientFact;
}

public void setClientFact(Client clientFact) {
	this.clientFact = clientFact;
}

public Personnel getSecrectaireFact() {
	return secrectaireFact;
}

public void setSecrectaireFact(Personnel secrectaireFact) {
	this.secrectaireFact = secrectaireFact;
}

public Personnel getMagasinierFact() {
	return magasinierFact;
}

public void setMagasinierFact(Personnel magasinierFact) {
	this.magasinierFact = magasinierFact;
}

public boolean isSoldedFacture() {
	return isSoldedFacture;
}

public void setSoldedFacture(boolean isSoldedFacture) {
	this.isSoldedFacture = isSoldedFacture;
}

public boolean isEmbOkFacture() {
	return isEmbOkFacture;
}

public void setEmbOkFacture(boolean isEmbOkFacture) {
	this.isEmbOkFacture = isEmbOkFacture;
}

public DetailsFacture getMyDetailsFacture() {
	return myDetailsFacture;
}

public void setMyDetailsFacture(DetailsFacture myDetailsFacture) {
	this.myDetailsFacture = myDetailsFacture;
}

@Override
public String toString() {
	StringBuilder builder = new StringBuilder();
	builder.append("Facture [idFacture=");
	builder.append(idFacture);
	builder.append(", dateFact=");
	builder.append(dateFact);
	builder.append(", heure=");
	builder.append(heure);
	builder.append(", soldeFact=");
	builder.append(soldeFact);
	builder.append(", nbColisFact=");
	builder.append(nbColisFact);
	builder.append(", nbEmbFact=");
	builder.append(nbEmbFact);
	builder.append(", totalRistFact=");
	builder.append(totalRistFact);
	builder.append(", livreur=");
	builder.append(livreur);
	builder.append(", clientFact=");
	builder.append(clientFact);
	builder.append(", secrectaireFact=");
	builder.append(secrectaireFact);
	builder.append(", magasinierFact=");
	builder.append(magasinierFact);
	builder.append(", isSoldedFacture=");
	builder.append(isSoldedFacture);
	builder.append(", isEmbOkFacture=");
	builder.append(isEmbOkFacture);
	//builder.append(", myDetailsFacture=");
	//builder.append(myDetailsFacture);
	builder.append("]");
	return builder.toString();
}


  
  
  
  

}