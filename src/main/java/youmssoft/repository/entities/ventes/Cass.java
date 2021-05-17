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
import youmssoft.repository.entities.livraison.Produit;


@Entity
@Table(name="cass")
public class Cass implements Serializable{
	@Id @GeneratedValue
	@Column(name = "idCass", nullable = false, unique=true)
  private long idCass;

  @Column(name = "nature", nullable = false)
  private Boolean nature;//Produits ou Emballages
  
  @Column(name = "nbBout", nullable = false)
  private float nbBout;// vu qu'on ne casse pas les casiers

  @ManyToOne(fetch = FetchType.EAGER)//cascade = CascadeType.ALL
	@JoinColumn(name = "auteurCass", referencedColumnName="idPersonnel", nullable = false)
  private Personnel auteurCass;

  @Column(name = "dateCass", nullable = false)
  private LocalDate dateCass;

  @Column(name = "heureCass", nullable = false)
  private LocalTime heureCass;

  @Column(name = "raison", nullable = true, length=50)
  private String raison;

  @Column(name = "montantDommage", nullable = false)
  private float montantDommage;

  @ManyToOne(fetch = FetchType.EAGER)//cascade = CascadeType.ALL
	@JoinColumn(name = "produitCass", referencedColumnName="idProduit", nullable = true)
  private Produit produitCass;
  
  
  @Column(name = "isValide", nullable = true) 
	 private boolean isValide=true;
  
  @Column(name = "isManaged", nullable = true) 
	 private boolean isManaged=false;
  
  @Column(name = "isAcquited", nullable = true) 
	 private boolean isAcquited=false;
  
  @ManyToOne(fetch = FetchType.EAGER)//cascade = CascadeType.ALL
	@JoinColumn(name = "magEmb", referencedColumnName="idPersonnel", nullable = true)
private Personnel magEmb;
  
  @ManyToOne(fetch = FetchType.EAGER)//cascade = CascadeType.ALL
	@JoinColumn(name = "magProd", referencedColumnName="idPersonnel", nullable = true)
private Personnel magProd;
  
  @OneToOne(fetch = FetchType.EAGER)//cascade = CascadeType.ALL
	@JoinColumn(name = "myEmballageMvt", referencedColumnName="idEmb", nullable = true)
private EmballagesMvt myEmballageMvt;
  
  @OneToOne(fetch = FetchType.EAGER)//cascade = CascadeType.ALL
	@JoinColumn(name = "myProduitMvt", referencedColumnName="idMagProdMvt", nullable = true)
private ProduitMvt myProduitMvt;

@OneToOne(fetch = FetchType.EAGER)//cascade = CascadeType.ALL
@JoinColumn(name = "myArgentMvt", referencedColumnName="idArgentMvt", nullable = true)
private ArgentMvt myArgentMvt;

/**
 * 
 */
public Cass() {
	super();
}


public long getIdCass() {
	return idCass;
}

public void setIdCass(long idCass) {
	this.idCass = idCass;
}

public Boolean getNature() {
	return nature;
}

public void setNature(Boolean nature) {
	this.nature = nature;
}



public EmballagesMvt getMyEmballageMvt() {
	return myEmballageMvt;
}


public void setMyEmballageMvt(EmballagesMvt myEmballageMvt) {
	this.myEmballageMvt = myEmballageMvt;
}


public ProduitMvt getMyProduitMvt() {
	return myProduitMvt;
}


public void setMyProduitMvt(ProduitMvt myProduitMvt) {
	this.myProduitMvt = myProduitMvt;
}


public float getNbBout() {
	return nbBout;
}

public void setNbBout(float nbBout) {
	this.nbBout = nbBout;
}

public Personnel getAuteurCass() {
	return auteurCass;
}

public void setAuteurCass(Personnel auteurCass) {
	this.auteurCass = auteurCass;
}



public ArgentMvt getMyArgentMvt() {
	return myArgentMvt;
}


public void setMyArgentMvt(ArgentMvt myArgentMvt) {
	this.myArgentMvt = myArgentMvt;
}


public boolean isValide() {
	return isValide;
}

public void setValide(boolean isValide) {
	this.isValide = isValide;
}

public LocalDate getDateCass() {
	return dateCass;
}

public void setDateCass(LocalDate dateCass) {
	this.dateCass = dateCass;
}

public LocalTime getHeureCass() {
	return heureCass;
}

public void setHeureCass(LocalTime heureCass) {
	this.heureCass = heureCass;
}

public String getRaison() {
	return raison;
}

public void setRaison(String raison) {
	this.raison = raison;
}

public float getMontantDommage() {
	return montantDommage;
}

public void setMontantDommage(float montantDommage) {
	this.montantDommage = montantDommage;
}

public Produit getProduitCass() {
	return produitCass;
}

public void setProduitCass(Produit produitCass) {
	this.produitCass = produitCass;
}




public boolean isManaged() {
	return isManaged;
}


public void setManaged(boolean isManaged) {
	this.isManaged = isManaged;
}


public boolean isAcquited() {
	return isAcquited;
}


public void setAcquited(boolean isAcquited) {
	this.isAcquited = isAcquited;
}




public Cass(Boolean nature, float nbBout, Personnel auteurCass, LocalDate dateCass, LocalTime heureCass, String raison,
		float montantDommage, Produit produitCass, boolean isValide, boolean isManaged, boolean isAcquited) {
	super();
	this.nature = nature;
	this.nbBout = nbBout;
	this.auteurCass = auteurCass;
	this.dateCass = dateCass;
	this.heureCass = heureCass;
	this.raison = raison;
	this.montantDommage = montantDommage;
	this.produitCass = produitCass;
	this.isValide = isValide;
	this.isManaged = isManaged;
	this.isAcquited = isAcquited;
}


public Cass(long idCass, Boolean nature, float nbBout, Personnel auteurCass, LocalDate dateCass, LocalTime heureCass,
		String raison, float montantDommage, Produit produitCass, boolean isValide, boolean isManaged,
		boolean isAcquited) {
	super();
	this.idCass = idCass;
	this.nature = nature;
	this.nbBout = nbBout;
	this.auteurCass = auteurCass;
	this.dateCass = dateCass;
	this.heureCass = heureCass;
	this.raison = raison;
	this.montantDommage = montantDommage;
	this.produitCass = produitCass;
	this.isValide = isValide;
	this.isManaged = isManaged;
	this.isAcquited = isAcquited;
}




public Personnel getMagEmb() {
	return magEmb;
}


public void setMagEmb(Personnel magEmb) {
	this.magEmb = magEmb;
}


public Personnel getMagProd() {
	return magProd;
}


public void setMagProd(Personnel magProd) {
	this.magProd = magProd;
}


@Override
public String toString() {
	StringBuilder builder = new StringBuilder();
	builder.append("Cass [idCass=");
	builder.append(idCass);
	builder.append(", nature=");
	builder.append(nature);
	builder.append(", nbBout=");
	builder.append(nbBout);
	builder.append(", auteurCass=");
	builder.append(auteurCass);
	builder.append(", dateCass=");
	builder.append(dateCass);
	builder.append(", heureCass=");
	builder.append(heureCass);
	builder.append(", raison=");
	builder.append(raison);
	builder.append(", montantDommage=");
	builder.append(montantDommage);
	builder.append(", produitCass=");
	builder.append(produitCass);
	builder.append("]");
	return builder.toString();
}

  
  
  
  
}