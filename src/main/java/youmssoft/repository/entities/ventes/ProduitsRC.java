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

import youmssoft.repository.entities.livraison.Produit;

@Entity
@Table(name="ProduitsRC")
public class ProduitsRC implements Serializable{//ok

	@Id @GeneratedValue
	@Column(name = "idProduitsRC", nullable = false, unique=true)
  private long idProduitsRC;

	@ManyToOne(fetch = FetchType.EAGER)//cascade = CascadeType.ALL
	@JoinColumn(name = "produitRC", referencedColumnName="idProduit", nullable = false)
  private Produit produitRC;

	 @Column(name = "quantiteRC", nullable = false)
  private float quantiteRC;
	 
	 @Column(name = "nbBouteilleSup", nullable = true)
	  private float nbBouteilleSup;

	 @Column(name = "totalParProd", nullable = false)
  private float totalParProd;
	 
	 @Column(name = "isValide", nullable = true) 
	 private boolean isValide=true;

  @ManyToOne(fetch = FetchType.EAGER)//cascade = CascadeType.ALL
	@JoinColumn(name = "myRetourChargment", referencedColumnName="idRetour", nullable = false)
    private RetourChargement myRetourChargment;



/**
 * @param idProduitsRC
 * @param produitRC
 * @param quantiteRC
 * @param nbBouteilleSup
 * @param totalParProd
 * @param myRetourChargment
 */
public ProduitsRC(long idProduitsRC, Produit produitRC, float quantiteRC, float nbBouteilleSup, float totalParProd,
		RetourChargement myRetourChargment) {
	super();
	this.idProduitsRC = idProduitsRC;
	this.produitRC = produitRC;
	this.quantiteRC = quantiteRC;
	this.nbBouteilleSup = nbBouteilleSup;
	this.totalParProd = totalParProd;
	this.myRetourChargment = myRetourChargment;
}



/**
 * @param produitRC
 * @param quantiteRC
 * @param nbBouteilleSup
 * @param totalParProd
 * @param myRetourChargment
 */
public ProduitsRC(Produit produitRC, float quantiteRC, float nbBouteilleSup, float totalParProd,
		RetourChargement myRetourChargment) {
	super();
	this.produitRC = produitRC;
	this.quantiteRC = quantiteRC;
	this.nbBouteilleSup = nbBouteilleSup;
	this.totalParProd = totalParProd;
	this.myRetourChargment = myRetourChargment;
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
public ProduitsRC() {
	super();
}



public long getIdProduitsRC() {
	return idProduitsRC;
}



public void setIdProduitsRC(long idProduitsRC) {
	this.idProduitsRC = idProduitsRC;
}



public Produit getProduitRC() {
	return produitRC;
}



public void setProduitRC(Produit produitRC) {
	this.produitRC = produitRC;
}



public float getQuantiteRC() {
	return quantiteRC;
}



public void setQuantiteRC(float quantiteRC) {
	this.quantiteRC = quantiteRC;
}



public float getNbBouteilleSup() {
	return nbBouteilleSup;
}



public void setNbBouteilleSup(float nbBouteilleSup) {
	this.nbBouteilleSup = nbBouteilleSup;
}



public float getTotalParProd() {
	return totalParProd;
}



public void setTotalParProd(float totalParProd) {
	this.totalParProd = totalParProd;
}



public RetourChargement getMyRetourChargment() {
	return myRetourChargment;
}



public void setMyRetourChargment(RetourChargement myRetourChargment) {
	this.myRetourChargment = myRetourChargment;
}



@Override
public String toString() {
	StringBuilder builder = new StringBuilder();
	builder.append("ProduitsRC [idProduitsRC=");
	builder.append(idProduitsRC);
	builder.append(", produitRC=");
	builder.append(produitRC);
	builder.append(", quantiteRC=");
	builder.append(quantiteRC);
	builder.append(", nbBouteilleSup=");
	builder.append(nbBouteilleSup);
	builder.append(", totalParProd=");
	builder.append(totalParProd);
	builder.append(", myRetourChargment=");
	builder.append(myRetourChargment);
	builder.append("]");
	return builder.toString();
}


	
    
}