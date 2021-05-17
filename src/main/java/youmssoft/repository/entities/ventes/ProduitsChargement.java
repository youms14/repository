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
@Table(name="ProduitsChargment")
public class ProduitsChargement implements Serializable{//ok

	@Id @GeneratedValue
	@Column(name = "idProduitsChargment", nullable = false, unique=true)
	private long idProduitsChargment;

	@ManyToOne(fetch = FetchType.EAGER)//cascade = CascadeType.ALL
	@JoinColumn(name = "produitPC", referencedColumnName="idProduit", nullable = false)
	private Produit produitPC;

	@Column(name = "quantitePC", nullable = false)
	private float quantitePC;
	
	@Column(name = "quantiteVendu", nullable = false)
	private float quantiteVendu;

	@Column(name = "prixTotalPC", nullable = false)
	private float prixTotalPC;
	
	@Column(name = "isValide", nullable = true) 
	 private boolean isValide=true;

   
	@ManyToOne(fetch = FetchType.EAGER)//cascade = CascadeType.ALL
	@JoinColumn(name = "myChargement", referencedColumnName="idChargement", nullable = false)
  	private Chargement myChargement;


	/**
	 * @param idProduitsChargment
	 * @param produitPC
	 * @param quantitePC
	 * @param prixTotalPC
	 * @param myChargement
	 */
	public ProduitsChargement(long idProduitsChargment, Produit produitPC, float quantitePC, float prixTotalPC,
			Chargement myChargement,float quantiteVendu) {
		super();
		this.idProduitsChargment = idProduitsChargment;
		this.produitPC = produitPC;
		this.quantitePC = quantitePC;
		this.prixTotalPC = prixTotalPC;
		this.myChargement = myChargement;
		this.quantiteVendu= quantiteVendu;
	}


	/**
	 * @param produitPC
	 * @param quantitePC
	 * @param prixTotalPC
	 * @param myChargement
	 */
	public ProduitsChargement(Produit produitPC, float quantitePC, float prixTotalPC, Chargement myChargement,float quantiteVendu) {
		super();
		this.produitPC = produitPC;
		this.quantitePC = quantitePC;
		this.prixTotalPC = prixTotalPC;
		this.myChargement = myChargement;
		this.quantiteVendu= quantiteVendu;
	}


	/**
	 * 
	 */
	public ProduitsChargement() {
		super();
	}

	

	public boolean isValide() {
		return isValide;
	}


	public void setValide(boolean isValide) {
		this.isValide = isValide;
	}


	public float getQuantiteVendu() {
		return quantiteVendu;
	}


	public void setQuantiteVendu(float quantiteVendu) {
		this.quantiteVendu = quantiteVendu;
	}


	public long getIdProduitsChargment() {
		return idProduitsChargment;
	}


	public void setIdProduitsChargment(long idProduitsChargment) {
		this.idProduitsChargment = idProduitsChargment;
	}


	public Produit getProduitPC() {
		return produitPC;
	}


	public void setProduitPC(Produit produitPC) {
		this.produitPC = produitPC;
	}


	public float getQuantitePC() {
		return quantitePC;
	}


	public void setQuantitePC(float quantitePC) {
		this.quantitePC = quantitePC;
	}


	public float getPrixTotalPC() {
		return prixTotalPC;
	}


	public void setPrixTotalPC(float prixTotalPC) {
		this.prixTotalPC = prixTotalPC;
	}


	public Chargement getMyChargement() {
		return myChargement;
	}


	public void setMyChargement(Chargement myChargement) {
		this.myChargement = myChargement;
	}


	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("ProduitsChargment [idProduitsChargment=");
		builder.append(idProduitsChargment);
		builder.append(", produitPC=");
		builder.append(produitPC);
		builder.append(", quantitePC=");
		builder.append(quantitePC);
		builder.append(", prixTotalPC=");
		builder.append(prixTotalPC);
		builder.append(", myChargement=");
		builder.append(myChargement);
		builder.append("]");
		return builder.toString();
	}
  	
	
	

}