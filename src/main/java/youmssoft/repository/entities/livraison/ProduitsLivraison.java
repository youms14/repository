package youmssoft.repository.entities.livraison;
/*
 * Cette classe contient les données concenant le contenu d'une livraison.
 */

import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="produitsLivraison")
public class ProduitsLivraison implements Serializable {

  /**
	 * 
	 */
	private static final long serialVersionUID = 2731916877021747694L;

	@Id @GeneratedValue
	@Column(name = "idProduitsLivraison", nullable = false)
	private long idProduitsLivraison;

	@Column(name = "quantite", nullable = false)
	private float quantite;

	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "myProduit", referencedColumnName="idProduit", nullable = false)
	private Produit myProduit;
	
	@Column(name = "pt", nullable = false)
	private float pt;

	@Column(name = "ristPL", nullable = false)
	private float ristPL;
  
  @ManyToOne(fetch = FetchType.EAGER)//cascade = CascadeType.ALL
  @JoinColumn(name = "mylivraison", referencedColumnName="idLivraison", nullable = false)
  private Livraison mylivraison;//ok
  
  @Column(name = "isValide", nullable = true) 
	 private boolean isValide=true;

public ProduitsLivraison(long idProduitsLivraison, Produit myProduit, float quantite, Livraison mylivraison) {
	super();
	this.idProduitsLivraison = idProduitsLivraison;
	this.quantite = quantite;
	this.myProduit = myProduit;
	this.mylivraison = mylivraison;
	
}

public ProduitsLivraison(float quantite,Produit myProduit,Livraison mylivraison) {
	super();
	this.quantite = quantite;
	this.myProduit=myProduit;
	this.mylivraison = mylivraison;
	this.pt = myProduit.getPuAchat()*this.quantite;
	this.ristPL = myProduit.getRistourneLivraison()*this.quantite;
}

public ProduitsLivraison() {
	super();
}

 

public boolean isValide() {
	return isValide;
}

public void setValide(boolean isValide) {
	this.isValide = isValide;
}

public float getIdProduitsLivraison() {
	return idProduitsLivraison;
}

public void setIdProduitsLivraison(long idProduitsLivraison) {
	this.idProduitsLivraison = idProduitsLivraison;
}

public float getQuantite() {
	return quantite;
}

public void setQuantite(float quantite) {
	this.quantite = quantite;
}



public float getPt() {
	return pt;
}

public void setPt() {
	this.pt = myProduit.getPuAchat()*this.quantite;
}

public float getRistPL() {
	return ristPL;
}

public void setRistPL() {
	this.ristPL = myProduit.getRistourneLivraison()*this.quantite;
}

public Livraison getMylivraison() {
	return mylivraison;
}

public void setMylivraison(Livraison mylivraison) {
	this.mylivraison = mylivraison;
}



public Produit getMyProduit() {
	return myProduit;
}

public void setMyProduit(Produit myProduit) {
	this.myProduit = myProduit;
}

@Override
public String toString() {
	StringBuilder builder = new StringBuilder();
	builder.append("ProduitsLivraison [idProduitsLivraison=");
	builder.append(idProduitsLivraison);
	builder.append(", quantite=");
	builder.append(quantite);
	builder.append(", myProduit=");
	builder.append(myProduit);
	builder.append(", pt=");
	builder.append(pt);
	builder.append(", ristPL=");
	builder.append(ristPL);
	builder.append(", mylivraison=");
	builder.append(mylivraison);
	builder.append("]");
	return builder.toString();
}





   
}