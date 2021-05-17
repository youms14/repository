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
@Table(name="PrixProduits")
public class PrixProduits implements Serializable{//ok

	@Id @GeneratedValue
	@Column(name = "idPrix", nullable = false, unique=true)
	private long idPrix;

	@Column(name = "ristProd", nullable = true)
	private float ristProd;

	@Column(name = "prixClient", nullable = false)
	private float prixClient;

	@ManyToOne(fetch = FetchType.EAGER)//cascade = CascadeType.ALL
	@JoinColumn(name = "produit", referencedColumnName="idProduit", nullable = false)
	private Produit produit;
	
	@ManyToOne(fetch = FetchType.EAGER)//cascade = CascadeType.ALL
	@JoinColumn(name = "myClient", referencedColumnName="idClient", nullable = false)
	private Client myClient;
	
	@Column(name = "isValide", nullable = true) 
	 private boolean isValide=true;

/**
 * @param idPrix
 * @param ristProd
 * @param prixClient
 * @param produit
 */
public PrixProduits(long idPrix, float ristProd, float prixClient, Produit produit, Client myClient) {
	super();
	this.idPrix = idPrix;
	this.ristProd = ristProd;
	this.prixClient = prixClient;
	this.produit = produit;
	this. myClient= myClient;
}

/**
 * @param ristProd
 * @param prixClient
 * @param produit
 */
public PrixProduits(float ristProd, float prixClient, Produit produit,Client myClient) {
	super();
	this.ristProd = ristProd;
	this.prixClient = prixClient;
	this.produit = produit;
	this. myClient= myClient;
}

/**
 * 
 */
public PrixProduits() {
	super();
}





public boolean isValide() {
	return isValide;
}

public void setValide(boolean isValide) {
	this.isValide = isValide;
}

public Client getMyClient() {
	return myClient;
}

public void setMyClient(Client myClient) {
	this.myClient = myClient;
}

public long getIdPrix() {
	return idPrix;
}

public void setIdPrix(long idPrix) {
	this.idPrix = idPrix;
}

public float getRistProd() {
	return ristProd;
}

public void setRistProd(float ristProd) {
	this.ristProd = ristProd;
}

public float getPrixClient() {
	return prixClient;
}

public void setPrixClient(float prixClient) {
	this.prixClient = prixClient;
}

public Produit getProduit() {
	return produit;
}

public void setProduit(Produit produit) {
	this.produit = produit;
}

@Override
public String toString() {
	StringBuilder builder = new StringBuilder();
	builder.append("PrixProduits [idPrix=");
	builder.append(idPrix);
	builder.append(", ristProd=");
	builder.append(ristProd);
	builder.append(", prixClient=");
	builder.append(prixClient);
	builder.append(", produit=");
	builder.append(produit);
	builder.append("]");
	return builder.toString();
}

   
   

}