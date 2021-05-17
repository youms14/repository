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
@Table(name="ProduitsFC")
public class ProduitsFC implements Serializable{//ok

	@Id @GeneratedValue
	@Column(name = "idProduitFC", nullable = false, unique=true)
  private long idProduitFC;

	@ManyToOne(fetch = FetchType.EAGER)//cascade = CascadeType.ALL
	@JoinColumn(name = "produitFC", referencedColumnName="idProduit", nullable = false)
  private Produit produitFC;

	 @Column(name = "qteFC", nullable = false)
  private float qteFC;

	 @Column(name = "prixTotalFC", nullable = true)
  private float prixTotalFC;

	 @Column(name = "ristFC", nullable = true)
  private float ristFC;

  @ManyToOne(fetch = FetchType.EAGER)//cascade = CascadeType.ALL
	@JoinColumn(name = "myFacturesChargement", referencedColumnName="idFactCharg", nullable = false)
    public FacturesChargement myFacturesChargement;
  
  @Column(name = "isValide", nullable = true) 
	 private boolean isValide=true;

	/**
	 * @param idProduitFC
	 * @param produitFC
	 * @param qteFC
	 * @param prixTotalFC
	 * @param ristFC
	 * @param myFacturesChargement
	 */
	public ProduitsFC(long idProduitFC, Produit produitFC, float qteFC, float prixTotalFC, float ristFC,
			FacturesChargement myFacturesChargement) {
		super();
		this.idProduitFC = idProduitFC;
		this.produitFC = produitFC;
		this.qteFC = qteFC;
		this.prixTotalFC = prixTotalFC;
		this.ristFC = ristFC;
		this.myFacturesChargement = myFacturesChargement;
	}

	/**
	 * @param produitFC
	 * @param qteFC
	 * @param prixTotalFC
	 * @param ristFC
	 * @param myFacturesChargement
	 */
	public ProduitsFC(Produit produitFC, float qteFC, float prixTotalFC, float ristFC,
			FacturesChargement myFacturesChargement) {
		super();
		this.produitFC = produitFC;
		this.qteFC = qteFC;
		this.prixTotalFC = prixTotalFC;
		this.ristFC = ristFC;
		this.myFacturesChargement = myFacturesChargement;
	}

	/**
	 * 
	 */
	public ProduitsFC() {
		super();
	}

	public long getIdProduitFC() {
		return idProduitFC;
	}

	public boolean isValide() {
		return isValide;
	}

	public void setValide(boolean isValide) {
		this.isValide = isValide;
	}

	public void setIdProduitFC(long idProduitFC) {
		this.idProduitFC = idProduitFC;
	}

	public Produit getProduitFC() {
		return produitFC;
	}

	public void setProduitFC(Produit produitFC) {
		this.produitFC = produitFC;
	}

	public float getQteFC() {
		return qteFC;
	}

	public void setQteFC(float qteFC) {
		this.qteFC = qteFC;
	}

	public float getPrixTotalFC() {
		return prixTotalFC;
	}

	public void setPrixTotalFC(float prixTotalFC) {
		this.prixTotalFC = prixTotalFC;
	}

	public float getRistFC() {
		return ristFC;
	}

	public void setRistFC(float ristFC) {
		this.ristFC = ristFC;
	}

	public FacturesChargement getMyFacturesChargement() {
		return myFacturesChargement;
	}

	public void setMyFacturesChargement(FacturesChargement myFacturesChargement) {
		this.myFacturesChargement = myFacturesChargement;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("ProduitsFC [idProduitFC=");
		builder.append(idProduitFC);
		builder.append(", produitFC=");
		builder.append(produitFC);
		builder.append(", qteFC=");
		builder.append(qteFC);
		builder.append(", prixTotalFC=");
		builder.append(prixTotalFC);
		builder.append(", ristFC=");
		builder.append(ristFC);
		builder.append(", myFacturesChargement=");
		builder.append(myFacturesChargement);
		builder.append("]");
		return builder.toString();
	}

    
}