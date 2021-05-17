package youmssoft.repository.entities.ventes;

import java.io.Serializable;
import java.time.LocalDate;

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
@Table(name="AchatEmballage")
public class AchatEmballage implements Serializable{

	@Id @GeneratedValue
	@Column(name = "idAcharEmballage", nullable = false, unique=true)
  public long idAcharEmballage;

	@Column(name = "dateAchat", nullable = false)
  public LocalDate dateAchat;

	@Column(name = "qteEnCasier", nullable = false)
  public float qteEnCasier;

	@Column(name = "montantAchat", nullable = false)
  public float montantAchat;

	@Column(name = "source", nullable = true, length=50)
  public String source;
	
	@Column(name = "isPayed", nullable = true)
	  public boolean isPayed;
	
	@Column(name = "isStocked", nullable = true)
	  public boolean isStocked;
	
	@Column(name = "nbSABC", nullable = false)
	  public float nbSABC;
	@Column(name = "nbUCB", nullable = false)
	  public float nbUCB;
	@Column(name = "nbGUI", nullable = false)
	  public float nbGUI;
	
	@Column(name = "isValide", nullable = true) 
	 private boolean isValide=true;

	@OneToOne(fetch = FetchType.EAGER)
	  @JoinColumn(name = "myInterfaceCaisse", referencedColumnName="idIntCaisse", nullable = true)
  public InterfaceCaisse myInterfaceCaisse;
	
	@ManyToOne(fetch = FetchType.EAGER)//cascade = CascadeType.ALL
	@JoinColumn(name = "responsable", referencedColumnName="idPersonnel", nullable = false)
	private Personnel responsable;
	
	

	public long getIdAcharEmballage() {
		return idAcharEmballage;
	}

	
	public void setIdAcharEmballage(long idAcharEmballage) {
		this.idAcharEmballage = idAcharEmballage;
	}

	public LocalDate getDateAchat() {
		return dateAchat;
	}

	public void setDateAchat(LocalDate dateAchat) {
		this.dateAchat = dateAchat;
	}

	public float getQteEnCasier() {
		return qteEnCasier;
	}

	public void setQteEnCasier(float qteEnCasier) {
		this.qteEnCasier = qteEnCasier;
	}

	
	public boolean isValide() {
		return isValide;
	}


	public void setValide(boolean isValide) {
		this.isValide = isValide;
	}


	public float getMontantAchat() {
		return montantAchat;
	}

	public void setMontantAchat(float montantAchat) {
		this.montantAchat = montantAchat;
	}

	public String getSource() {
		return source;
	}

	public void setSource(String source) {
		this.source = source;
	}

	public InterfaceCaisse getMyInterfaceCaisse() {
		return myInterfaceCaisse;
	}

	public void setMyInterfaceCaisse(InterfaceCaisse myInterfaceCaisse) {
		this.myInterfaceCaisse = myInterfaceCaisse;
	}

	

	public AchatEmballage(LocalDate dateAchat, float qteEnCasier, float montantAchat, String source, boolean isPayed,
			boolean isStocked, float nbSABC, float nbUCB, float nbGUI, InterfaceCaisse myInterfaceCaisse,
			Personnel responsable) {
		super();
		this.dateAchat = dateAchat;
		this.qteEnCasier = qteEnCasier;
		this.montantAchat = montantAchat;
		this.source = source;
		this.isPayed = isPayed;
		this.isStocked = isStocked;
		this.nbSABC = nbSABC;
		this.nbUCB = nbUCB;
		this.nbGUI = nbGUI;
		this.myInterfaceCaisse = myInterfaceCaisse;
		this.responsable = responsable;
		
	}


	public AchatEmballage(long idAcharEmballage, LocalDate dateAchat, float qteEnCasier, float montantAchat,
			String source, boolean isPayed, boolean isStocked, float nbSABC, float nbUCB, float nbGUI,
			InterfaceCaisse myInterfaceCaisse, Personnel responsable) {
		super();
		this.idAcharEmballage = idAcharEmballage;
		this.dateAchat = dateAchat;
		this.qteEnCasier = qteEnCasier;
		this.montantAchat = montantAchat;
		this.source = source;
		this.isPayed = isPayed;
		this.isStocked = isStocked;
		this.nbSABC = nbSABC;
		this.nbUCB = nbUCB;
		this.nbGUI = nbGUI;
		this.myInterfaceCaisse = myInterfaceCaisse;
		this.responsable = responsable;
	
	}


	public AchatEmballage() {
		super();
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("AchatEmballage [idAcharEmballage=");
		builder.append(idAcharEmballage);
		builder.append(", dateAchat=");
		builder.append(dateAchat);
		builder.append(", qteEnCasier=");
		builder.append(qteEnCasier);
		builder.append(", montantAchat=");
		builder.append(montantAchat);
		builder.append(", source=");
		builder.append(source);
		builder.append(", myInterfaceCaisse=");
		builder.append(myInterfaceCaisse);
		builder.append("]");
		return builder.toString();
	}

	
	
	public float getNbSABC() {
		return nbSABC;
	}


	public void setNbSABC(float nbSABC) {
		this.nbSABC = nbSABC;
	}


	public float getNbUCB() {
		return nbUCB;
	}


	public void setNbUCB(float nbUCB) {
		this.nbUCB = nbUCB;
	}


	public float getNbGUI() {
		return nbGUI;
	}


	public void setNbGUI(float nbGUI) {
		this.nbGUI = nbGUI;
	}


	

	public boolean isPayed() {
		return isPayed;
	}


	public void setPayed(boolean isPayed) {
		this.isPayed = isPayed;
	}


	public boolean isStocked() {
		return isStocked;
	}


	public void setStocked(boolean isStocked) {
		this.isStocked = isStocked;
	}


	public Personnel getResponsable() {
		return responsable;
	}

	public void setResponsable(Personnel responsable) {
		this.responsable = responsable;
	}
	
	
	

}