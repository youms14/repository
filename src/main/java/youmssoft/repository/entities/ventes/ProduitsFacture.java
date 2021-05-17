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
@Table(name="ProduitsFacture")
public class ProduitsFacture implements Serializable{//Ok

	@Id @GeneratedValue
	@Column(name = "idPorduitsFacture", nullable = false, unique=true)
  private long idPorduitsFacture;

	@ManyToOne(fetch = FetchType.EAGER)//cascade = CascadeType.ALL
	@JoinColumn(name = "produitPF", referencedColumnName="idProduit", nullable = false)
  private Produit produitPF;

	@Column(name = "quantitePF", nullable = false)
  private float quantitePF;

	
	@Column(name = "prixTotalPF", nullable = false)
  private float prixTotalPF;

	@Column(name = "ristPF", nullable = false)
  private float ristPF;

  @ManyToOne(fetch = FetchType.EAGER)//cascade = CascadeType.ALL
	@JoinColumn(name = "myFacture", referencedColumnName="idFacture", nullable = false)
    private Facture myFacture;
  
  @Column(name = "isValide", nullable = true) 
	 private boolean isValide=true;

	/**
	 * @param idPorduitsFacture
	 * @param produitPF
	 * @param quantitePF
	 * @param prixTotalPF
	 * @param ristPF
	 * @param myFacture
	 */
	public ProduitsFacture(long idPorduitsFacture, Produit produitPF, long quantitePF, float prixTotalPF, float ristPF,
			Facture myFacture) {
		super();
		this.idPorduitsFacture = idPorduitsFacture;
		this.produitPF = produitPF;
		this.quantitePF = quantitePF;
		this.prixTotalPF = prixTotalPF;
		this.ristPF = ristPF;
		this.myFacture = myFacture;
	}

	/**
	 * @param produitPF
	 * @param quantitePF
	 * @param prixTotalPF
	 * @param ristPF
	 * @param myFacture
	 */
	public ProduitsFacture(Produit produitPF, long quantitePF, float prixTotalPF, float ristPF, Facture myFacture) {
		super();
		this.produitPF = produitPF;
		this.quantitePF = quantitePF;
		this.prixTotalPF = prixTotalPF;
		this.ristPF = ristPF;
		this.myFacture = myFacture;
	}

	/**
	 * @param produitPF
	 * @param quantitePF
	 * @param myFacture
	 */
	public ProduitsFacture(Produit produitPF, float quantitePF, Facture myFacture) {
		super();
		this.produitPF = produitPF;
		this.quantitePF = quantitePF;
		this.myFacture = myFacture;
	}

	/**
	 * 
	 */
	public ProduitsFacture() {
		super();
	}

	public long getIdPorduitsFacture() {
		return idPorduitsFacture;
	}

	public void setIdPorduitsFacture(long idPorduitsFacture) {
		this.idPorduitsFacture = idPorduitsFacture;
	}

	public Produit getProduitPF() {
		return produitPF;
	}

	
	public boolean isValide() {
		return isValide;
	}

	public void setValide(boolean isValide) {
		this.isValide = isValide;
	}

	public void setProduitPF(Produit produitPF) {
		this.produitPF = produitPF;
	}

	public float getQuantitePF() {
		return quantitePF;
	}

	public void setQuantitePF(float quantitePF) {
		this.quantitePF = quantitePF;
	}

	public float getPrixTotalPF() {
		return prixTotalPF;
	}

	public void setPrixTotalPF(float prixTotalPF) {
		this.prixTotalPF = prixTotalPF;
	}

	public float getRistPF() {
		return ristPF;
	}

	public void setRistPF(float ristPF) {
		this.ristPF = ristPF;
	}

	public Facture getMyFacture() {
		return myFacture;
	}

	public void setMyFacture(Facture myFacture) {
		this.myFacture = myFacture;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("ProduitsFacture [idPorduitsFacture=");
		builder.append(idPorduitsFacture);
		builder.append(", produitPF=");
		builder.append(produitPF);
		builder.append(", quantitePF=");
		builder.append(quantitePF);
		builder.append(", prixTotalPF=");
		builder.append(prixTotalPF);
		builder.append(", ristPF=");
		builder.append(ristPF);
		builder.append(", myFacture=");
		builder.append(myFacture);
		builder.append("]");
		return builder.toString();
	}

    
}