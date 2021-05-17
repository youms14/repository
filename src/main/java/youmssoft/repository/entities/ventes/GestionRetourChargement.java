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

import youmssoft.repository.entities.livraison.Personnel;

@Entity
@Table(name="GestionRetourChargment")
public class GestionRetourChargement implements Serializable{//ok

	@Id @GeneratedValue
	@Column(name = "idGRC", nullable = false, unique=true)
	private long idGRC;

  @Column(name = "natureOpGRC", nullable = false)
  private boolean natureOpGRC;

  @Column(name = "avanceGRC", nullable = false)
  private float avanceGRC;

  @Column(name = "resteGRC", nullable = false)
  private float resteGRC;

  @Column(name = "dateGRC", nullable = false)
  private LocalDate dateGRC;

  @Column(name = "heureGRC", nullable = false)
  private LocalTime heureGRC;
  
  @Column(name = "isValide", nullable = true) 
	 private boolean isValide=true;
  
  @Column(name = "isManaged", nullable = true)// false apres
  private boolean isManaged;

  @ManyToOne(fetch = FetchType.EAGER)//cascade = CascadeType.ALL
  @JoinColumn(name = "personnelInt", referencedColumnName="idPersonnel", nullable = false)
  private Personnel personnelInt;

  	@ManyToOne(fetch = FetchType.EAGER)//cascade = CascadeType.ALL
	@JoinColumn(name = "myRetourChargment", referencedColumnName="idRetour", nullable = false)
    private RetourChargement myRetourChargment;

	/**
	 * 
	 */
	public GestionRetourChargement() {
		super();
	}

	/**
	 * @param idGRC
	 * @param natureOpGRC
	 * @param avanceGRC
	 * @param resteGRC
	 * @param dateGRC
	 * @param heureGRC
	 * @param personnelInt
	 * @param myRetourChargment
	 */
	public GestionRetourChargement(long idGRC, boolean natureOpGRC, float avanceGRC, float resteGRC, LocalDate dateGRC,
			LocalTime heureGRC, Personnel personnelInt, RetourChargement myRetourChargment,boolean isManaged) {
		super();
		this.idGRC = idGRC;
		this.natureOpGRC = natureOpGRC;
		this.avanceGRC = avanceGRC;
		this.resteGRC = resteGRC;
		this.dateGRC = dateGRC;
		this.heureGRC = heureGRC;
		this.personnelInt = personnelInt;
		this.myRetourChargment = myRetourChargment;
		this. isManaged= isManaged;
	}

	/**
	 * @param natureOpGRC
	 * @param avanceGRC
	 * @param resteGRC
	 * @param dateGRC
	 * @param heureGRC
	 * @param personnelInt
	 * @param myRetourChargment
	 */
	public GestionRetourChargement(boolean natureOpGRC, float avanceGRC, float resteGRC, LocalDate dateGRC,
			LocalTime heureGRC, Personnel personnelInt, RetourChargement myRetourChargment, boolean isManaged) {
		super();
		this.natureOpGRC = natureOpGRC;
		this.avanceGRC = avanceGRC;
		this.resteGRC = resteGRC;
		this.dateGRC = dateGRC;
		this.heureGRC = heureGRC;
		this.personnelInt = personnelInt;
		this.myRetourChargment = myRetourChargment;
		this. isManaged= isManaged;
	}

	public long getIdGRC() {
		return idGRC;
	}
	
	

	public boolean isValide() {
		return isValide;
	}

	public void setValide(boolean isValide) {
		this.isValide = isValide;
	}

	public boolean isManaged() {
		return isManaged;
	}

	public void setManaged(boolean isManaged) {
		this.isManaged = isManaged;
	}

	public void setIdGRC(long idGRC) {
		this.idGRC = idGRC;
	}

	public boolean isNatureOpGRC() {
		return natureOpGRC;
	}

	public void setNatureOpGRC(boolean natureOpGRC) {
		this.natureOpGRC = natureOpGRC;
	}

	public float getAvanceGRC() {
		return avanceGRC;
	}

	public void setAvanceGRC(float avanceGRC) {
		this.avanceGRC = avanceGRC;
	}

	public float getResteGRC() {
		return resteGRC;
	}

	public void setResteGRC(float resteGRC) {
		this.resteGRC = resteGRC;
	}

	public LocalDate getDateGRC() {
		return dateGRC;
	}

	public void setDateGRC(LocalDate dateGRC) {
		this.dateGRC = dateGRC;
	}

	public LocalTime getHeureGRC() {
		return heureGRC;
	}

	public void setHeureGRC(LocalTime heureGRC) {
		this.heureGRC = heureGRC;
	}

	public Personnel getPersonnelInt() {
		return personnelInt;
	}

	public void setPersonnelInt(Personnel personnelInt) {
		this.personnelInt = personnelInt;
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
		builder.append("GestionRetourChargment [idGRC=");
		builder.append(idGRC);
		builder.append(", natureOpGRC=");
		builder.append(natureOpGRC);
		builder.append(", avanceGRC=");
		builder.append(avanceGRC);
		builder.append(", resteGRC=");
		builder.append(resteGRC);
		builder.append(", dateGRC=");
		builder.append(dateGRC);
		builder.append(", heureGRC=");
		builder.append(heureGRC);
		builder.append(", personnelInt=");
		builder.append(personnelInt);
		builder.append(", myRetourChargment=");
		builder.append(myRetourChargment);
		builder.append("]");
		return builder.toString();
	}

    
}