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

import youmssoft.repository.entities.livraison.Livraison;
import youmssoft.repository.entities.livraison.Personnel;
import youmssoft.repository.entities.livraison.Produit;

@Entity
@Table(name="ProduitMvt")
public class ProduitMvt implements Serializable{//ok

	@Id @GeneratedValue
	@Column(name = "idMagProdMvt", nullable = false, unique=true)
	private long idMagProdMvt;

	@ManyToOne(fetch = FetchType.EAGER)//cascade = CascadeType.ALL
	@JoinColumn(name = "produit", referencedColumnName="idProduit", nullable = false)
	private Produit produit;

	 @Column(name = "quantite", nullable = false)
	 private float quantite;

	 @Column(name = "nature", nullable = false)
	 private Boolean nature;//IN ou OUT

	 @Column(name = "date", nullable = false)
	 private LocalDate date;

	 @Column(name = "heure", nullable = false)
	 private LocalTime heure;

	 @Column(name = "libelle", nullable = true, length=30)
	 private String libelle;
	 
	 @Column(name = "isValide", nullable = true) 
	 private boolean isValide=true;
	 
	 @ManyToOne(fetch = FetchType.EAGER)//cascade = CascadeType.ALL
		@JoinColumn(name = "magasinierPROD", referencedColumnName="idPersonnel", nullable = true)//A mettre false apres.
		private Personnel magasinierPROD;

	@ManyToOne(fetch = FetchType.EAGER)//cascade = CascadeType.ALL
	@JoinColumn(name = "myFacture", referencedColumnName="idFacture", nullable = true)
  	private Facture myFacture;
	  
	@ManyToOne(fetch = FetchType.EAGER)//cascade = CascadeType.ALL
	@JoinColumn(name = "myLivraison", referencedColumnName="idLivraison", nullable = true)
  	private Livraison myLivraison;
	  
	@ManyToOne(fetch = FetchType.EAGER)//cascade = CascadeType.ALL
	@JoinColumn(name = "myChargement", referencedColumnName="idChargement", nullable = true)
  	private Chargement myChargement;
	  
	@ManyToOne(fetch = FetchType.EAGER)//cascade = CascadeType.ALL
	@JoinColumn(name = "myRetourChargment", referencedColumnName="idRetour", nullable = true)
  	private RetourChargement myRetourChargment;
	
	@OneToOne(fetch = FetchType.EAGER)//cascade = CascadeType.ALL
	@JoinColumn(name = "myCass", referencedColumnName="idCass", nullable = true)
  private Cass myCass;
	
	
	
	
	
	public ProduitMvt(Produit produit, float quantite, Boolean nature, LocalDate date, LocalTime heure, String libelle,
			boolean isValide, Personnel magasinierPROD, Facture myFacture, Livraison myLivraison,
			Chargement myChargement, RetourChargement myRetourChargment, Cass myCass) {
		super();
		this.produit = produit;
		this.quantite = quantite;
		this.nature = nature;
		this.date = date;
		this.heure = heure;
		this.libelle = libelle;
		this.isValide = isValide;
		this.magasinierPROD = magasinierPROD;
		this.myFacture = myFacture;
		this.myLivraison = myLivraison;
		this.myChargement = myChargement;
		this.myRetourChargment = myRetourChargment;
		this.myCass = myCass;
	}
	public ProduitMvt(long idMagProdMvt, Produit produit, float quantite, Boolean nature, LocalDate date,
			LocalTime heure, String libelle, boolean isValide, Personnel magasinierPROD, Facture myFacture,
			Livraison myLivraison, Chargement myChargement, RetourChargement myRetourChargment, Cass myCass) {
		super();
		this.idMagProdMvt = idMagProdMvt;
		this.produit = produit;
		this.quantite = quantite;
		this.nature = nature;
		this.date = date;
		this.heure = heure;
		this.libelle = libelle;
		this.isValide = isValide;
		this.magasinierPROD = magasinierPROD;
		this.myFacture = myFacture;
		this.myLivraison = myLivraison;
		this.myChargement = myChargement;
		this.myRetourChargment = myRetourChargment;
		this.myCass = myCass;
	}
	public Cass getMyCass() {
		return myCass;
	}
	public void setMyCass(Cass myCass) {
		this.myCass = myCass;
	}
	/**
	 * 
	 */
	public ProduitMvt() {
		super();
	}
	/**
	 * @return the idMagProdMvt
	 */
	public long getIdMagProdMvt() {
		return idMagProdMvt;
	}
	/**
	 * @param idMagProdMvt the idMagProdMvt to set
	 */
	public void setIdMagProdMvt(long idMagProdMvt) {
		this.idMagProdMvt = idMagProdMvt;
	}
	/**
	 * @return the produit
	 */
	public Produit getProduit() {
		return produit;
	}
	/**
	 * @param produit the produit to set
	 */
	public void setProduit(Produit produit) {
		this.produit = produit;
	}
	
	
	public boolean isValide() {
		return isValide;
	}
	public void setValide(boolean isValide) {
		this.isValide = isValide;
	}
	/**
	 * @return the quantite
	 */
	public float getQuantite() {
		return quantite;
	}
	/**
	 * @param quantite the quantite to set
	 */
	public void setQuantite(float quantite) {
		this.quantite = quantite;
	}
	/**
	 * @return the nature
	 */
	public Boolean getNature() {
		return nature;
	}
	/**
	 * @param nature the nature to set
	 */
	public void setNature(Boolean nature) {
		this.nature = nature;
	}
	/**
	 * @return the date
	 */
	public LocalDate getDate() {
		return date;
	}
	/**
	 * @param date the date to set
	 */
	public void setDate(LocalDate date) {
		this.date = date;
	}
	/**
	 * @return the heure
	 */
	public LocalTime getHeure() {
		return heure;
	}
	/**
	 * @param heure the heure to set
	 */
	public void setHeure(LocalTime heure) {
		this.heure = heure;
	}
	/**
	 * @return the libelle
	 */
	public String getLibelle() {
		return libelle;
	}
	/**
	 * @param libelle the libelle to set
	 */
	public void setLibelle(String libelle) {
		this.libelle = libelle;
	}
	/**
	 * @return the myFacture
	 */
	public Facture getMyFacture() {
		return myFacture;
	}
	/**
	 * @param myFacture the myFacture to set
	 */
	public void setMyFacture(Facture myFacture) {
		this.myFacture = myFacture;
	}
	/**
	 * @return the myLivraison
	 */
	public Livraison getMyLivraison() {
		return myLivraison;
	}
	/**
	 * @param myLivraison the myLivraison to set
	 */
	public void setMyLivraison(Livraison myLivraison) {
		this.myLivraison = myLivraison;
	}
	/**
	 * @return the myChargement
	 */
	public Chargement getMyChargement() {
		return myChargement;
	}
	/**
	 * @param myChargement the myChargement to set
	 */
	public void setMyChargement(Chargement myChargement) {
		this.myChargement = myChargement;
	}
	/**
	 * @return the myRetourChargment
	 */
	public RetourChargement getMyRetourChargment() {
		return myRetourChargment;
	}
	/**
	 * @param myRetourChargment the myRetourChargment to set
	 */
	public void setMyRetourChargment(RetourChargement myRetourChargment) {
		this.myRetourChargment = myRetourChargment;
	}
	
	
	
	public Personnel getMagasinierPROD() {
		return magasinierPROD;
	}
	public void setMagasinierPROD(Personnel magasinierPROD) {
		this.magasinierPROD = magasinierPROD;
	}
	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("ProduitMvt [idMagProdMvt=");
		builder.append(idMagProdMvt);
		builder.append(", produit=");
		builder.append(produit);
		builder.append(", quantite=");
		builder.append(quantite);
		builder.append(", nature=");
		builder.append(nature);
		builder.append(", date=");
		builder.append(date);
		builder.append(", heure=");
		builder.append(heure);
		builder.append(", libelle=");
		builder.append(libelle);
		builder.append(", myFacture=");
		builder.append(myFacture);
		builder.append(", myLivraison=");
		builder.append(myLivraison);
		builder.append(", myChargement=");
		builder.append(myChargement);
		builder.append(", myRetourChargment=");
		builder.append(myRetourChargment);
		builder.append("]");
		return builder.toString();
	}
  	
  	
  	
  	

}