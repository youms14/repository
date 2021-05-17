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

import youmssoft.repository.entities.livraison.Fournisseur;
import youmssoft.repository.entities.livraison.GestionLivraison;
import youmssoft.repository.entities.livraison.Personnel;

@Entity
@Table(name="EmballagesMvt")
public class EmballagesMvt implements Serializable {//Ok.

	@Id @GeneratedValue
	@Column(name = "idEmb", nullable = false, unique=true)
	private long idEmb;

	@Column(name = "quantiteEmb", nullable = false)
  private float quantiteEmb;

	@ManyToOne(fetch = FetchType.EAGER)//cascade = CascadeType.ALL
  	@JoinColumn(name = "fournisseurEmb", referencedColumnName="idFournisseur", nullable = true)
  private Fournisseur fournisseurEmb;

  @Column(name = "natureMvtEmb", nullable = false)
  private Boolean natureMvtEmb;//1 pour IN et O pour OUT.

  @Column(name = "dateOp", nullable = false)
  private LocalDate dateOp;

  @Column(name = "heureOp", nullable = false)
  private LocalTime heureOp;

  @Column(name = "libelleMvtEmb", nullable = true)
  private String libelleMvtEmb;
  
  @ManyToOne(fetch = FetchType.EAGER)//cascade = CascadeType.ALL
	@JoinColumn(name = "magasinierEMB", referencedColumnName="idPersonnel", nullable = true)//A mettre false apres.
	private Personnel magasinierEMB;

  @ManyToOne(fetch = FetchType.EAGER)//cascade = CascadeType.ALL
	@JoinColumn(name = "myGestionFacture", referencedColumnName="idGestionFacture", nullable = true)
  private GestionFacture myGestionFacture;
  
  @OneToOne(fetch = FetchType.EAGER)//cascade = CascadeType.ALL
	@JoinColumn(name = "myGestionLivraison", referencedColumnName="idGestionLivraison", nullable = true)
  private GestionLivraison myGestionLivraison;
  
  @ManyToOne(fetch = FetchType.EAGER)//cascade = CascadeType.ALL
	@JoinColumn(name = "myGestionRetourChargment", referencedColumnName="idGRC", nullable = true)
  private GestionRetourChargement myGestionRetourChargment;
    
  @OneToOne(fetch = FetchType.EAGER)//cascade = CascadeType.ALL
	@JoinColumn(name = "myAchatEmballage", referencedColumnName="idAcharEmballage", nullable = true)
private AchatEmballage myAchatEmballage;
  
  @OneToOne(fetch = FetchType.EAGER)//cascade = CascadeType.ALL
	@JoinColumn(name = "myCass", referencedColumnName="idCass", nullable = true)
private Cass myCass;
  
  @Column(name = "isValide", nullable = true) 
	 private boolean isValide=true;
    
    

	public EmballagesMvt(float quantiteEmb, Fournisseur fournisseurEmb, Boolean natureMvtEmb, LocalDate dateOp,
		LocalTime heureOp, String libelleMvtEmb, Personnel magasinierEMB, GestionFacture myGestionFacture,
		GestionLivraison myGestionLivraison, GestionRetourChargement myGestionRetourChargment,
		AchatEmballage myAchatEmballage, Cass myCass, boolean isValide) {
	super();
	this.quantiteEmb = quantiteEmb;
	this.fournisseurEmb = fournisseurEmb;
	this.natureMvtEmb = natureMvtEmb;
	this.dateOp = dateOp;
	this.heureOp = heureOp;
	this.libelleMvtEmb = libelleMvtEmb;
	this.magasinierEMB = magasinierEMB;
	this.myGestionFacture = myGestionFacture;
	this.myGestionLivraison = myGestionLivraison;
	this.myGestionRetourChargment = myGestionRetourChargment;
	this.myAchatEmballage = myAchatEmballage;
	this.myCass = myCass;
	this.isValide = isValide;
}




	public EmballagesMvt(long idEmb, float quantiteEmb, Fournisseur fournisseurEmb, Boolean natureMvtEmb, LocalDate dateOp,
		LocalTime heureOp, String libelleMvtEmb, Personnel magasinierEMB, GestionFacture myGestionFacture,
		GestionLivraison myGestionLivraison, GestionRetourChargement myGestionRetourChargment,
		AchatEmballage myAchatEmballage, Cass myCass, boolean isValide) {
	super();
	this.idEmb = idEmb;
	this.quantiteEmb = quantiteEmb;
	this.fournisseurEmb = fournisseurEmb;
	this.natureMvtEmb = natureMvtEmb;
	this.dateOp = dateOp;
	this.heureOp = heureOp;
	this.libelleMvtEmb = libelleMvtEmb;
	this.magasinierEMB = magasinierEMB;
	this.myGestionFacture = myGestionFacture;
	this.myGestionLivraison = myGestionLivraison;
	this.myGestionRetourChargment = myGestionRetourChargment;
	this.myAchatEmballage = myAchatEmballage;
	this.myCass = myCass;
	this.isValide = isValide;
}




	public Cass getMyCass() {
	return myCass;
}




public void setMyCass(Cass myCass) {
	this.myCass = myCass;
}




	public EmballagesMvt() {
		super();
	}
	
	


	public AchatEmballage getMyAchatEmballage() {
		return myAchatEmballage;
	}


	public void setMyAchatEmballage(AchatEmballage myAchatEmballage) {
		this.myAchatEmballage = myAchatEmballage;
	}


	public long getIdEmb() {
		return idEmb;
	}
	
	


	public boolean isValide() {
		return isValide;
	}


	public void setValide(boolean isValide) {
		this.isValide = isValide;
	}


	public void setIdEmb(long idEmb) {
		this.idEmb = idEmb;
	}


	public float getQuantiteEmb() {
		return quantiteEmb;
	}


	public void setQuantiteEmb(float quantiteEmb) {
		this.quantiteEmb = quantiteEmb;
	}


	public Fournisseur getFournisseurEmb() {
		return fournisseurEmb;
	}


	public void setFournisseurEmb(Fournisseur fournisseurEmb) {
		this.fournisseurEmb = fournisseurEmb;
	}


	public Boolean getNatureMvtEmb() {
		return natureMvtEmb;
	}


	public void setNatureMvtEmb(Boolean natureMvtEmb) {
		this.natureMvtEmb = natureMvtEmb;
	}


	public LocalDate getDateOp() {
		return dateOp;
	}


	public void setDateOp(LocalDate dateOp) {
		this.dateOp = dateOp;
	}


	public LocalTime getHeureOp() {
		return heureOp;
	}


	public void setHeureOp(LocalTime heureOp) {
		this.heureOp = heureOp;
	}


	public String getLibelleMvtEmb() {
		return libelleMvtEmb;
	}


	public void setLibelleMvtEmb(String libelleMvtEmb) {
		this.libelleMvtEmb = libelleMvtEmb;
	}


	public GestionFacture getMyGestionFacture() {
		return myGestionFacture;
	}


	public void setMyGestionFacture(GestionFacture myGestionFacture) {
		this.myGestionFacture = myGestionFacture;
	}


	public GestionLivraison getMyGestionLivraison() {
		return myGestionLivraison;
	}


	public void setMyGestionLivraison(GestionLivraison myGestionLivraison) {
		this.myGestionLivraison = myGestionLivraison;
	}


	public GestionRetourChargement getMyGestionRetourChargment() {
		return myGestionRetourChargment;
	}


	public void setMyGestionRetourChargment(GestionRetourChargement myGestionRetourChargment) {
		this.myGestionRetourChargment = myGestionRetourChargment;
	}


	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("EmballagesMvt [idEmb=");
		builder.append(idEmb);
		builder.append(", quantiteEmb=");
		builder.append(quantiteEmb);
		builder.append(", fournisseurEmb=");
		builder.append(fournisseurEmb);
		builder.append(", natureMvtEmb=");
		builder.append(natureMvtEmb);
		builder.append(", dateOp=");
		builder.append(dateOp);
		builder.append(", heureOp=");
		builder.append(heureOp);
		builder.append(", libelleMvtEmb=");
		builder.append(libelleMvtEmb);
		builder.append(", myGestionFacture=");
		builder.append(myGestionFacture);
		builder.append(", myGestionLivraison=");
		builder.append(myGestionLivraison);
		builder.append(", myGestionRetourChargment=");
		builder.append(myGestionRetourChargment);
		builder.append("]");
		return builder.toString();
	}


	public Personnel getMagasinierEMB() {
		return magasinierEMB;
	}


	public void setMagasinierEMB(Personnel magasinierEMB) {
		this.magasinierEMB = magasinierEMB;
	}
    
    
    

}