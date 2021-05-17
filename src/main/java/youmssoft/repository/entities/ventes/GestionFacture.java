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
@Table(name="GestionFacture")
public class GestionFacture implements Serializable{//ok

	@Id @GeneratedValue
	@Column(name = "idGestionFacture", nullable = false, unique=true)
	private long idGestionFacture;

	@Column(name = "natureOpGF", nullable = false)
	private Boolean natureOpGF;

	@Column(name = "avanceGF", nullable = false)
	private float avanceGF;

	@Column(name = "dateGF", nullable = false)
	private LocalDate dateGF;

	@Column(name = "heureGF", nullable = false)
	private LocalTime heureGF;
	
	@Column(name = "isManaged", nullable = true)// false apres.
	private boolean isManaged=false;

	@ManyToOne(fetch = FetchType.EAGER)//cascade = CascadeType.ALL
	@JoinColumn(name = "personnelIntGF", referencedColumnName="idPersonnel", nullable = false)
	private Personnel personnelIntGF;

	@ManyToOne(fetch = FetchType.EAGER)//cascade = CascadeType.ALL
	@JoinColumn(name = "myFacture", referencedColumnName="idFacture", nullable = false)
    private Facture myFacture;
	
	@OneToOne(fetch = FetchType.EAGER)//cascade = CascadeType.ALL
	@JoinColumn(name = "myArgentMvt", referencedColumnName="idArgentMvt", nullable = true)
    private ArgentMvt myArgentMvt;
	
	@Column(name = "isValide", nullable = true) 
	 private boolean isValide=true;
	/**
	 * @param idGestionFacture
	 * @param natureOpGF
	 * @param avanceGF
	 * @param resteGF
	 * @param dateGF
	 * @param heureGF
	 * @param personnelIntGF
	 * @param myFacture
	 * @param myArgentMvt
	 */
	public GestionFacture(long idGestionFacture, Boolean natureOpGF, float avanceGF,  LocalDate dateGF,
			LocalTime heureGF, Personnel personnelIntGF, Facture myFacture, ArgentMvt myArgentMvt,boolean isManaged) {
		super();
		this.idGestionFacture = idGestionFacture;
		this.natureOpGF = natureOpGF;
		this.avanceGF = avanceGF;
		//this.resteGF = resteGF;
		this.dateGF = dateGF;
		this.heureGF = heureGF;
		this.personnelIntGF = personnelIntGF;
		this.myFacture = myFacture;
		this.myArgentMvt = myArgentMvt;
		this. isManaged= isManaged;
	}
	/**
	 * @param natureOpGF
	 * @param avanceGF
	 * @param resteGF
	 * @param dateGF
	 * @param heureGF
	 * @param personnelIntGF
	 * @param myFacture
	 * @param myArgentMvt
	 */
	public GestionFacture(Boolean natureOpGF, float avanceGF, LocalDate dateGF, LocalTime heureGF,
			Personnel personnelIntGF, Facture myFacture, ArgentMvt myArgentMvt,boolean isManaged) {
		super();
		this.natureOpGF = natureOpGF;
		this.avanceGF = avanceGF;
		//this.resteGF = resteGF;
		this.dateGF = dateGF;
		this.heureGF = heureGF;
		this.personnelIntGF = personnelIntGF;
		this.myFacture = myFacture;
		this.myArgentMvt = myArgentMvt;
		this. isManaged= isManaged;
	}
	/**
	 * 
	 */
	public GestionFacture() {
		super();
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
	public long getIdGestionFacture() {
		return idGestionFacture;
	}
	public void setIdGestionFacture(long idGestionFacture) {
		this.idGestionFacture = idGestionFacture;
	}
	public Boolean getNatureOpGF() {
		return natureOpGF;
	}
	public void setNatureOpGF(Boolean natureOpGF) {
		this.natureOpGF = natureOpGF;
	}
	public float getAvanceGF() {
		return avanceGF;
	}
	public void setAvanceGF(float avanceGF) {
		this.avanceGF = avanceGF;
	}
	
	public LocalDate getDateGF() {
		return dateGF;
	}
	public void setDateGF(LocalDate dateGF) {
		this.dateGF = dateGF;
	}
	public LocalTime getHeureGF() {
		return heureGF;
	}
	public void setHeureGF(LocalTime heureGF) {
		this.heureGF = heureGF;
	}
	public Personnel getPersonnelIntGF() {
		return personnelIntGF;
	}
	public void setPersonnelIntGF(Personnel personnelIntGF) {
		this.personnelIntGF = personnelIntGF;
	}
	public Facture getMyFacture() {
		return myFacture;
	}
	public void setMyFacture(Facture myFacture) {
		this.myFacture = myFacture;
	}
	public ArgentMvt getMyArgentMvt() {
		return myArgentMvt;
	}
	public void setMyArgentMvt(ArgentMvt myArgentMvt) {
		this.myArgentMvt = myArgentMvt;
	}
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("GestionFacture [idGestionFacture=");
		builder.append(idGestionFacture);
		builder.append(", natureOpGF=");
		builder.append(natureOpGF);
		builder.append(", avanceGF=");
		builder.append(avanceGF);
		builder.append(", dateGF=");
		builder.append(dateGF);
		builder.append(", heureGF=");
		builder.append(heureGF);
		builder.append(", personnelIntGF=");
		builder.append(personnelIntGF);
		builder.append(", myFacture=");
		builder.append(myFacture);
		//builder.append(", myArgentMvt=");
		//builder.append(myArgentMvt);
		builder.append("]");
		return builder.toString();
	}
    
    

}