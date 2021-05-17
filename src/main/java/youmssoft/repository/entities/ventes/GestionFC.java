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
import javax.persistence.Table;

@Entity
@Table(name="GestionFC")
public class GestionFC implements Serializable{//ok

	@Id @GeneratedValue
	@Column(name = "idGestionFC", nullable = false, unique=true)
	private long idGestionFC;

	@Column(name = "avanceFC", nullable = false)
	private float avanceFC;

	@Column(name = "isManaged", nullable = false)
	private boolean isManaged;

	@Column(name = "natureOpFC", nullable = false)
	private boolean natureOpFC;

	@Column(name = "dateGFC", nullable = false)
	private LocalDate dateGFC;

	@Column(name = "heureGFC", nullable = false)
	private LocalTime heureGFC;

	@ManyToOne(fetch = FetchType.EAGER)//cascade = CascadeType.ALL
	@JoinColumn(name = "myFacturesChargement", referencedColumnName="idFactCharg", nullable = false)
    private FacturesChargement myFacturesChargement;
	
	@Column(name = "isValide", nullable = true) 
	 private boolean isValide=true;

	/**
	 * @param idGestionFC
	 * @param avanceFC
	 * @param resteFC
	 * @param natureOpFC
	 * @param dateGFC
	 * @param heureGFC
	 * @param myFacturesChargement
	 */
	public GestionFC(long idGestionFC, float avanceFC, boolean natureOpFC, LocalDate dateGFC,
			LocalTime heureGFC, FacturesChargement myFacturesChargement,boolean isManaged) {
		super();
		this.idGestionFC = idGestionFC;
		this.avanceFC = avanceFC;
		//this.resteFC = resteFC;
		this.natureOpFC = natureOpFC;
		this.dateGFC = dateGFC;
		this.heureGFC = heureGFC;
		this.myFacturesChargement = myFacturesChargement;
		this. isManaged= isManaged;
	}

	/**
	 * @param avanceFC
	 * @param resteFC
	 * @param natureOpFC
	 * @param dateGFC
	 * @param heureGFC
	 * @param myFacturesChargement
	 */
	public GestionFC(float avanceFC,  boolean natureOpFC, LocalDate dateGFC, LocalTime heureGFC,
			FacturesChargement myFacturesChargement,boolean isManaged) {
		super();
		this.avanceFC = avanceFC;
		//this.resteFC = resteFC;
		this.natureOpFC = natureOpFC;
		this.dateGFC = dateGFC;
		this.heureGFC = heureGFC;
		this.myFacturesChargement = myFacturesChargement;
		this. isManaged= isManaged;
	}

	
	
	
	
	public boolean isManaged() {
		return isManaged;
	}

	public void setManaged(boolean isManaged) {
		this.isManaged = isManaged;
	}

	public long getIdGestionFC() {
		return idGestionFC;
	}

	public void setIdGestionFC(long idGestionFC) {
		this.idGestionFC = idGestionFC;
	}

	public float getAvanceFC() {
		return avanceFC;
	}

	public void setAvanceFC(float avanceFC) {
		this.avanceFC = avanceFC;
	}



	public boolean isValide() {
		return isValide;
	}

	public void setValide(boolean isValide) {
		this.isValide = isValide;
	}

	public boolean isNatureOpFC() {
		return natureOpFC;
	}

	public void setNatureOpFC(boolean natureOpFC) {
		this.natureOpFC = natureOpFC;
	}

	public LocalDate getDateGFC() {
		return dateGFC;
	}

	public void setDateGFC(LocalDate dateGFC) {
		this.dateGFC = dateGFC;
	}

	public LocalTime getHeureGFC() {
		return heureGFC;
	}

	public void setHeureGFC(LocalTime heureGFC) {
		this.heureGFC = heureGFC;
	}

	public FacturesChargement getMyFacturesChargement() {
		return myFacturesChargement;
	}

	public void setMyFacturesChargement(FacturesChargement myFacturesChargement) {
		this.myFacturesChargement = myFacturesChargement;
	}

	/**
	 * 
	 */
	public GestionFC() {
		super();
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("GestionFC [idGestionFC=");
		builder.append(idGestionFC);
		builder.append(", avanceFC=");
		builder.append(avanceFC);
		//builder.append(", resteFC=");
		//builder.append(resteFC);
		builder.append(", natureOpFC=");
		builder.append(natureOpFC);
		builder.append(", dateGFC=");
		builder.append(dateGFC);
		builder.append(", heureGFC=");
		builder.append(heureGFC);
		builder.append(", myFacturesChargement=");
		builder.append(myFacturesChargement);
		builder.append("]");
		return builder.toString();
	}

    
    
}