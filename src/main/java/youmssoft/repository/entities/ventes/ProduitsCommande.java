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
@Table(name="ProduitsCommande")
public class ProduitsCommande implements Serializable{//ok

	@Id @GeneratedValue
	@Column(name = "idProdCom", nullable = false, unique=true)
  private long idProdCom;

	@ManyToOne(fetch = FetchType.EAGER)//cascade = CascadeType.ALL
	@JoinColumn(name = "produitProdCom", referencedColumnName="idProduit", nullable = false)
  private Produit produitProdCom;

	 @Column(name = "qtePordCom", nullable = false)
  private float qtePordCom;

	 @Column(name = "nbColisProdCom", nullable = true)
  private float nbColisProdCom;

	 @Column(name = "nbEmbProdCom", nullable = false)
  private float nbEmbProdCom;

  @ManyToOne(fetch = FetchType.EAGER)//cascade = CascadeType.ALL
	@JoinColumn(name = "myCommande", referencedColumnName="idCommande", nullable = false)
    private Commande myCommande;

  @Column(name = "isValide", nullable = true) 
	 private boolean isValide=true;
	/**
	 * @param idProdCom
	 * @param produitProdCom
	 * @param qtePordCom
	 * @param nbColisProdCom
	 * @param nbEmbProdCom
	 * @param myCommande
	 */
	public ProduitsCommande(long idProdCom, Produit produitProdCom, float qtePordCom, float nbColisProdCom,
			Integer nbEmbProdCom, Commande myCommande) {
		super();
		this.idProdCom = idProdCom;
		this.produitProdCom = produitProdCom;
		this.qtePordCom = qtePordCom;
		this.nbColisProdCom = nbColisProdCom;
		this.nbEmbProdCom = nbEmbProdCom;
		this.myCommande = myCommande;
	}


	/**
	 * @param produitProdCom
	 * @param qtePordCom
	 * @param nbColisProdCom
	 * @param nbEmbProdCom
	 * @param myCommande
	 */
	public ProduitsCommande(Produit produitProdCom, float qtePordCom, float nbColisProdCom, Integer nbEmbProdCom,
			Commande myCommande) {
		super();
		this.produitProdCom = produitProdCom;
		this.qtePordCom = qtePordCom;
		this.nbColisProdCom = nbColisProdCom;
		this.nbEmbProdCom = nbEmbProdCom;
		this.myCommande = myCommande;
	}


	/**
	 * 
	 */
	public ProduitsCommande() {
		super();
	}


	public boolean isValide() {
		return isValide;
	}


	public void setValide(boolean isValide) {
		this.isValide = isValide;
	}


	public long getIdProdCom() {
		return idProdCom;
	}


	public void setIdProdCom(long idProdCom) {
		this.idProdCom = idProdCom;
	}


	public Produit getProduitProdCom() {
		return produitProdCom;
	}


	public void setProduitProdCom(Produit produitProdCom) {
		this.produitProdCom = produitProdCom;
	}


	public float getQtePordCom() {
		return qtePordCom;
	}


	public void setQtePordCom(float qtePordCom) {
		this.qtePordCom = qtePordCom;
	}


	public float getNbColisProdCom() {
		return nbColisProdCom;
	}


	public void setNbColisProdCom(float nbColisProdCom) {
		this.nbColisProdCom = nbColisProdCom;
	}


	public float getNbEmbProdCom() {
		return nbEmbProdCom;
	}


	public void setNbEmbProdCom(float nbEmbProdCom) {
		this.nbEmbProdCom = nbEmbProdCom;
	}


	public Commande getMyCommande() {
		return myCommande;
	}


	public void setMyCommande(Commande myCommande) {
		this.myCommande = myCommande;
	}


	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("ProduitsCommande [idProdCom=");
		builder.append(idProdCom);
		builder.append(", produitProdCom=");
		builder.append(produitProdCom);
		builder.append(", qtePordCom=");
		builder.append(qtePordCom);
		builder.append(", nbColisProdCom=");
		builder.append(nbColisProdCom);
		builder.append(", nbEmbProdCom=");
		builder.append(nbEmbProdCom);
		builder.append(", myCommande=");
		builder.append(myCommande);
		builder.append("]");
		return builder.toString();
	}

    
}