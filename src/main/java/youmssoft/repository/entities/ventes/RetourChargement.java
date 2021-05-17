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

import youmssoft.repository.entities.livraison.Personnel;

@Entity
@Table(name="RetourChargment")
public class RetourChargement implements Serializable{//Ok

	@Id @GeneratedValue
	@Column(name = "idRetour", nullable = false, unique=true)
  private long idRetour;

	 @Column(name = "dateRetour", nullable = true)
  private LocalDate dateRetour;

	 @Column(name = "heureRetour", nullable = true)
  private LocalTime heureRetour;

	 @Column(name = "totalColisRetour", nullable = false)
  private float totalColisRetour;

	 @Column(name = "totalVersement", nullable = false)
  private float totalVersement;

	 @Column(name = "totalEmbRetour", nullable = false)
  private float totalEmbRetour;

	 @Column(name = "totalManquantProd", nullable = false)
  private float totalManquantProd;

	 @Column(name = "totalManquantEmb", nullable = false)
  private float totalManquantEmb;

	 @Column(name = "totalProduitRC", nullable = false)
  private float totalProduitRC;

	 @Column(name = "totalCasierRetour", nullable = false)
  private float totalCasierRetour;
	 
	 @Column(name = "totalCasierProd", nullable = false)
	  private float totalCasierProd;
	 
	 @Column(name = "isStockedProd", nullable = true)
	  private boolean isStockedProd;
	 
	 @Column(name = "isStockedEmb", nullable = true)
	  private boolean isStockedEmb;
	 
	 @OneToOne(fetch = FetchType.EAGER)//cascade = CascadeType.ALL
		@JoinColumn(name = "myChargement", referencedColumnName="idChargement", nullable = false)
	  	private Chargement myChargement;
	 
	 @ManyToOne(fetch = FetchType.EAGER)//cascade = CascadeType.ALL
	  	@JoinColumn(name = "secretaire", referencedColumnName="idPersonnel", nullable = true)
	    public Personnel secretaire;
	 
	 @ManyToOne(fetch = FetchType.EAGER)//cascade = CascadeType.ALL
	  	@JoinColumn(name = "magazinierPD", referencedColumnName="idPersonnel", nullable = true)
	    public Personnel magazinierPD;
	 
	 @ManyToOne(fetch = FetchType.EAGER)//cascade = CascadeType.ALL
	  	@JoinColumn(name = "magazinierEMB", referencedColumnName="idPersonnel", nullable = true)
	    public Personnel magazinierEMB;

	 
	 @Column(name = "isValide", nullable = true) 
	 private boolean isValide=true;
	 
	public RetourChargement(LocalDate dateRetour, LocalTime heureRetour, float totalColisRetour, float totalVersement,
			float totalEmbRetour, float totalManquantProd, float totalManquantEmb, float totalProduitRC,
			float totalCasierRetour, Chargement myChargement,float totalCasierProd) {
		super();
		this.dateRetour = dateRetour;
		this.heureRetour = heureRetour;
		this.totalColisRetour = totalColisRetour;
		this.totalVersement = totalVersement;
		this.totalEmbRetour = totalEmbRetour;
		this.totalManquantProd = totalManquantProd;
		this.totalManquantEmb = totalManquantEmb;
		this.totalProduitRC = totalProduitRC;
		this.totalCasierRetour = totalCasierRetour;
		this.myChargement = myChargement;
		this.totalCasierProd= totalCasierProd;
	}



	public long getIdRetour() {
		return idRetour;
	}
	
	

	public Personnel getMagazinierPD() {
		return magazinierPD;
	}



	public void setMagazinierPD(Personnel magazinierPD) {
		this.magazinierPD = magazinierPD;
	}



	public Personnel getMagazinierEMB() {
		return magazinierEMB;
	}



	public void setMagazinierEMB(Personnel magazinierEMB) {
		this.magazinierEMB = magazinierEMB;
	}



	public void setIdRetour(long idRetour) {
		this.idRetour = idRetour;
	}

	public LocalDate getDateRetour() {
		return dateRetour;
	}

	public boolean isValide() {
		return isValide;
	}



	public void setValide(boolean isValide) {
		this.isValide = isValide;
	}



	public void setDateRetour(LocalDate dateRetour) {
		this.dateRetour = dateRetour;
	}

	public LocalTime getHeureRetour() {
		return heureRetour;
	}

	public void setHeureRetour(LocalTime heureRetour) {
		this.heureRetour = heureRetour;
	}

	public float getTotalColisRetour() {
		return totalColisRetour;
	}

	public void setTotalColisRetour(float totalColisRetour) {
		this.totalColisRetour = totalColisRetour;
	}

	public float getTotalVersement() {
		return totalVersement;
	}

	public void setTotalVersement(float totalVersement) {
		this.totalVersement = totalVersement;
	}

	public float getTotalEmbRetour() {
		return totalEmbRetour;
	}

	public void setTotalEmbRetour(float totalEmbRetour) {
		this.totalEmbRetour = totalEmbRetour;
	}

	public float getTotalManquantProd() {
		return totalManquantProd;
	}

	public void setTotalManquantProd(float totalManquantProd) {
		this.totalManquantProd = totalManquantProd;
	}

	public float getTotalManquantEmb() {
		return totalManquantEmb;
	}

	public void setTotalManquantEmb(float totalManquantEmb) {
		this.totalManquantEmb = totalManquantEmb;
	}

	public float getTotalProduitRC() {
		return totalProduitRC;
	}

	public void setTotalProduitRC(float totalProduitRC) {
		this.totalProduitRC = totalProduitRC;
	}

	public float getTotalCasierRetour() {
		return totalCasierRetour;
	}

	public void setTotalCasierRetour(float totalCasierRetour) {
		this.totalCasierRetour = totalCasierRetour;
	}

	public Personnel getSecretaire() {
		return secretaire;
	}

	public void setSecretaire(Personnel secretaire) {
		this.secretaire = secretaire;
	}

	public Personnel getMagazinier() {
		return magazinierPD;
	}

	public void setMagazinier(Personnel magazinier) {
		this.magazinierPD = magazinier;
	}

	
	
	public boolean isStockedProd() {
		return isStockedProd;
	}



	public void setStockedProd(boolean isStockedProd) {
		this.isStockedProd = isStockedProd;
	}



	public boolean isStockedEmb() {
		return isStockedEmb;
	}



	public void setStockedEmb(boolean isStockedEmb) {
		this.isStockedEmb = isStockedEmb;
	}



	public RetourChargement(long idRetour, LocalDate dateRetour, LocalTime heureRetour, float totalColisRetour,
			float totalVersement, float totalEmbRetour, float totalManquantProd, float totalManquantEmb,
			float totalProduitRC, float totalCasierRetour, Personnel secretaire, Personnel magazinier,Chargement myChargement,float totalCasierProd) {
		super();
		this.idRetour = idRetour;
		this.dateRetour = dateRetour;
		this.heureRetour = heureRetour;
		this.totalVersement = totalVersement;
		
		this.totalColisRetour = totalColisRetour;
		this.totalEmbRetour = totalEmbRetour;
		this.totalProduitRC = totalProduitRC;
		this.totalCasierRetour = totalCasierRetour;
		this. totalCasierProd= totalCasierProd;
		
		this.totalManquantProd = totalManquantProd;
		this.totalManquantEmb = totalManquantEmb;
		this.secretaire = secretaire;
		this.magazinierPD = magazinier;
		this. myChargement= myChargement;
	}

	public RetourChargement(LocalDate dateRetour, LocalTime heureRetour, float totalColisRetour, float totalVersement,
			float totalEmbRetour, float totalManquantProd, float totalManquantEmb, float totalProduitRC,
			float totalCasierRetour, Chargement charg, boolean b,boolean c,float totalCasierProd) {
		super();
		this.dateRetour = dateRetour;
		this.heureRetour = heureRetour;
		this.totalColisRetour = totalColisRetour;
		this.totalVersement = totalVersement;
		this.totalEmbRetour = totalEmbRetour;
		this.totalManquantProd = totalManquantProd;
		this.totalManquantEmb = totalManquantEmb;
		this.totalProduitRC = totalProduitRC;
		this.totalCasierRetour = totalCasierRetour;
		this. isStockedProd = b;
		this. isStockedProd = c;
		this. myChargement=  charg;
		this. totalCasierProd= totalCasierProd;
	}

	public RetourChargement() {
		super();
	}



	public Chargement getMyChargement() {
		return myChargement;
	}



	public void setMyChargement(Chargement myChargement) {
		this.myChargement = myChargement;
	}



	public float getTotalCasierProd() {
		return totalCasierProd;
	}



	public void setTotalCasierProd(float totalCasierProd) {
		this.totalCasierProd = totalCasierProd;
	}

    

}