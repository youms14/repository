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
@Table(name="ManquantsRC")
public class ManquantsRC implements Serializable{//Ok

	@Id @GeneratedValue
	@Column(name = "idManquantsRC", nullable = false, unique=true)
	private float idManquantsRC;

	@ManyToOne(fetch = FetchType.EAGER)//cascade = CascadeType.ALL
	@JoinColumn(name = "produitMRC", referencedColumnName="idProduit", nullable = true)
	private Produit produitMRC;

	 @Column(name = "nbCasier", nullable = true)
	 private float nbCasier;

	 @Column(name = "nbBouteilles", nullable = true)
	 private float nbBouteilles;

	 @Column(name = "isEmb", nullable = true)
 	 private boolean isEmb;

	 @Column(name = "valeurM", nullable = false)
	 private float valeurM;

	 @ManyToOne(fetch = FetchType.EAGER)//cascade = CascadeType.ALL
	 @JoinColumn(name = "myRetourChargment", referencedColumnName="idRetour", nullable = false)
	 private RetourChargement myRetourChargment;

	 @Column(name = "isValide", nullable = true) 
	 private boolean isValide=true;
    
	/**
	 * 
	 */
	public ManquantsRC() {
		super();
	}

	/**
	 * @param produitMRC
	 * @param nbCasier
	 * @param nbBouteilles
	 * @param isEmb
	 * @param valeurM
	 * @param myRetourChargment
	 */
	public ManquantsRC(Produit produitMRC, float nbCasier, float nbBouteilles, boolean isEmb, float valeurM,
			RetourChargement myRetourChargment) {
		super();
		this.produitMRC = produitMRC;
		this.nbCasier = nbCasier;
		this.nbBouteilles = nbBouteilles;
		this.isEmb = isEmb;
		this.valeurM = valeurM;
		this.myRetourChargment = myRetourChargment;
	}

	/**
	 * @param idManquantsRC
	 * @param produitMRC
	 * @param nbCasier
	 * @param nbBouteilles
	 * @param isEmb
	 * @param valeurM
	 * @param myRetourChargment
	 */
	public ManquantsRC(float idManquantsRC, Produit produitMRC, float nbCasier, float nbBouteilles, boolean isEmb,
			float valeurM, RetourChargement myRetourChargment) {
		super();
		this.idManquantsRC = idManquantsRC;
		this.produitMRC = produitMRC;
		this.nbCasier = nbCasier;
		this.nbBouteilles = nbBouteilles;
		this.isEmb = isEmb;
		this.valeurM = valeurM;
		this.myRetourChargment = myRetourChargment;
	}

	public float getIdManquantsRC() {
		return idManquantsRC;
	}

	public void setIdManquantsRC(float idManquantsRC) {
		this.idManquantsRC = idManquantsRC;
	}

	public Produit getProduitMRC() {
		return produitMRC;
	}

	public void setProduitMRC(Produit produitMRC) {
		this.produitMRC = produitMRC;
	}

	public float getNbCasier() {
		return nbCasier;
	}

	public boolean isValide() {
		return isValide;
	}

	public void setValide(boolean isValide) {
		this.isValide = isValide;
	}

	public void setNbCasier(float nbCasier) {
		this.nbCasier = nbCasier;
	}

	public float getNbBouteilles() {
		return nbBouteilles;
	}

	public void setNbBouteilles(float nbBouteilles) {
		this.nbBouteilles = nbBouteilles;
	}

	public boolean isEmb() {
		return isEmb;
	}

	public void setEmb(boolean isEmb) {
		this.isEmb = isEmb;
	}

	public float getValeurM() {
		return valeurM;
	}

	public void setValeurM(float valeurM) {
		this.valeurM = valeurM;
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
		builder.append("ManquantsRC [idManquantsRC=");
		builder.append(idManquantsRC);
		builder.append(", produitMRC=");
		builder.append(produitMRC);
		builder.append(", nbCasier=");
		builder.append(nbCasier);
		builder.append(", nbBouteilles=");
		builder.append(nbBouteilles);
		builder.append(", isEmb=");
		builder.append(isEmb);
		builder.append(", valeurM=");
		builder.append(valeurM);
		builder.append(", myRetourChargment=");
		builder.append(myRetourChargment);
		builder.append("]");
		return builder.toString();
	}

    
    
}