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
@Table(name="Depenses")
public class Depenses implements Serializable {

	@Id @GeneratedValue
	@Column(name = "idDepense", nullable = false, unique=true)
  public long idDepense;

	@Column(name = "motif", nullable = false, length=50)
  public String motif;

  @Column(name = "montant", nullable = false)
  public float montant;

  @Column(name = "dateDepense", nullable = false)
  public LocalDate dateDepense;

  @Column(name = "heureDepense", nullable = false)
  public LocalTime heureDepense;
  
  @Column(name = "isPayed", nullable = false)//false apres
  public boolean isPayed=false;

  @ManyToOne(fetch = FetchType.EAGER)//cascade = CascadeType.ALL
  @JoinColumn(name = "responsable", referencedColumnName="idPersonnel", nullable = false)
  public Personnel responsable;
  
  @ManyToOne(fetch = FetchType.EAGER)//cascade = CascadeType.ALL
  @JoinColumn(name = "secretaire", referencedColumnName="idPersonnel", nullable = false)
  public Personnel secretaire;
  
  @OneToOne(fetch = FetchType.EAGER)//cascade = CascadeType.ALL
  @JoinColumn(name = "myArgentMvt", referencedColumnName="idArgentMvt", nullable = true)
  public ArgentMvt myArgentMvt;
  
  @Column(name = "isValide", nullable = true) 
	 private boolean isValide=true;

/**
 * @param idDepense
 * @param motif
 * @param montant
 * @param dateDepense
 * @param heureDepense
 * @param responsable
 * @param myArgentMvt
 */
public Depenses(long idDepense, String motif, float montant, LocalDate dateDepense, LocalTime heureDepense,
		Personnel responsable, ArgentMvt myArgentMvt,Personnel secretaire) {
	super();
	this.idDepense = idDepense;
	this.motif = motif;
	this.montant = montant;
	this.dateDepense = dateDepense;
	this.heureDepense = heureDepense;
	this.responsable = responsable;
	this.myArgentMvt = myArgentMvt;
	this. secretaire= secretaire;
}





public boolean isValide() {
	return isValide;
}





public void setValide(boolean isValide) {
	this.isValide = isValide;
}





/**
 * 
 */
public Depenses() {
	super();
}





public boolean isPayed() {
	return isPayed;
}





public void setPayed(boolean isPayed) {
	this.isPayed = isPayed;
}





/**
 * @param motif
 * @param montant
 * @param dateDepense
 * @param heureDepense
 * @param responsable
 * @param myArgentMvt
 */
public Depenses(String motif, float montant, LocalDate dateDepense, LocalTime heureDepense, Personnel responsable,
		ArgentMvt myArgentMvt,Personnel secretaire) {
	super();
	this.motif = motif;
	this.montant = montant;
	this.dateDepense = dateDepense;
	this.heureDepense = heureDepense;
	this.responsable = responsable;
	this.myArgentMvt = myArgentMvt;
	this. secretaire= secretaire;
}





public Personnel getSecretaire() {
	return secretaire;
}





public void setSecretaire(Personnel secretaire) {
	this.secretaire = secretaire;
}





public long getIdDepense() {
	return idDepense;
}

public void setIdDepense(long idDepense) {
	this.idDepense = idDepense;
}

public String getMotif() {
	return motif;
}

public void setMotif(String motif) {
	this.motif = motif;
}

public float getMontant() {
	return montant;
}

public void setMontant(float montant) {
	this.montant = montant;
}

public LocalDate getDateDepense() {
	return dateDepense;
}

public void setDateDepense(LocalDate dateDepense) {
	this.dateDepense = dateDepense;
}

public LocalTime getHeureDepense() {
	return heureDepense;
}

public void setHeureDepense(LocalTime heureDepense) {
	this.heureDepense = heureDepense;
}

public Personnel getResponsable() {
	return responsable;
}

public void setResponsable(Personnel responsable) {
	this.responsable = responsable;
}

public ArgentMvt getMyArgentMvt() {
	return myArgentMvt;
}

public void setMyArgentMvt(ArgentMvt myArgentMvt) {
	this.myArgentMvt = myArgentMvt;
}

@Override
public String toString() {
	StringBuilder builder = new StringBuilder();
	builder.append("Depenses [idDepense=");
	builder.append(idDepense);
	builder.append(", motif=");
	builder.append(motif);
	builder.append(", montant=");
	builder.append(montant);
	builder.append(", dateDepense=");
	builder.append(dateDepense);
	builder.append(", heureDepense=");
	builder.append(heureDepense);
	builder.append(", responsable=");
	builder.append(responsable);
	//builder.append(", myArgentMvt=");
	//builder.append(myArgentMvt);
	builder.append("]");
	return builder.toString();
}
  
  
  
  
  

}