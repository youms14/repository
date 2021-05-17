package youmssoft.repository.entities.ventes;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import youmssoft.repository.entities.livraison.Fournisseur;

@Entity
@Table(name="MagEmballage")
public class MagEmballage implements Serializable{//ok

	@Id @GeneratedValue
	@Column(name = "idMagEmb", nullable = false, unique=true)
	private long idMagEmb;

  @ManyToOne(fetch = FetchType.EAGER)//cascade = CascadeType.ALL
  @JoinColumn(name = "fournisseur", referencedColumnName="idFournisseur", nullable = false)
  private Fournisseur fournisseur;


  @Column(name = "qteMag", nullable = false)
  private float qteMag;
  
  @Column(name = "nbBout", nullable = true)
  private float nbBout;
  
  @Column(name = "isValide", nullable = true) 
	 private boolean isValide=true;
  
  
  
/**
 * 
 */
public MagEmballage() {
	super();
}

/**
 * @param fournisseur
 * @param qteMag
 * @param nbBout
 */
public MagEmballage(Fournisseur fournisseur, float qteMag, float nbBout) {
	super();
	this.fournisseur = fournisseur;
	this.qteMag = qteMag;
	this.nbBout = nbBout;
}

/**
 * @param idMagEmb
 * @param fournisseur
 * @param qteMag
 * @param nbBout
 */
public MagEmballage(long idMagEmb, Fournisseur fournisseur, float qteMag, float nbBout) {
	super();
	this.idMagEmb = idMagEmb;
	this.fournisseur = fournisseur;
	this.qteMag = qteMag;
	this.nbBout = nbBout;
}

public long getIdMagEmb() {
	return idMagEmb;
}

public void setIdMagEmb(long idMagEmb) {
	this.idMagEmb = idMagEmb;
}

public Fournisseur getFournisseur() {
	return fournisseur;
}

public void setFournisseur(Fournisseur fournisseur) {
	this.fournisseur = fournisseur;
}

public float getQteMag() {
	return qteMag;
}


public boolean isValide() {
	return isValide;
}

public void setValide(boolean isValide) {
	this.isValide = isValide;
}

public void setQteMag(float qteMag) {
	this.qteMag = qteMag;
}

public float getNbBout() {
	return nbBout;
}

public void setNbBout(float nbBout) {
	this.nbBout = nbBout;
}

@Override
public String toString() {
	StringBuilder builder = new StringBuilder();
	builder.append("MagEmballage [idMagEmb=");
	builder.append(idMagEmb);
	builder.append(", fournisseur=");
	builder.append(fournisseur);
	builder.append(", qteMag=");
	builder.append(qteMag);
	builder.append(", nbBout=");
	builder.append(nbBout);
	builder.append("]");
	return builder.toString();
}


  

}