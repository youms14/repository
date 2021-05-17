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

@Entity
@Table(name="ChargementPatrimoine")
public class ChargementPatrimoine implements Serializable{

	@Id @GeneratedValue
	@Column(name = "idChargPat", nullable = false, unique=true)
	public long idChargPat;

	@ManyToOne(fetch = FetchType.EAGER)//cascade = CascadeType.ALL
  	@JoinColumn(name = "myChargement", referencedColumnName="idChargement", nullable = true)
    private Chargement myChargement;
	
	@ManyToOne(fetch = FetchType.EAGER)//cascade = CascadeType.ALL
  	@JoinColumn(name = "myPatrimoine", referencedColumnName="idPatrimoine", nullable = true)
    private Patrimoine myPatrimoine;
	
	@Column(name = "isOccuped", nullable = false)
	public boolean isOccuped;
	
	@Column(name = "isValide", nullable = true) 
	 private boolean isValide=true;
	
	
	/**
	 * @param idChargPat
	 * @param myChargement
	 * @param myPatrimoine
	 */
	public ChargementPatrimoine(long idChargPat, Chargement myChargement, Patrimoine myPatrimoine,boolean isOccuped) {
		super();
		this.idChargPat = idChargPat;
		this.myChargement = myChargement;
		this.myPatrimoine = myPatrimoine;
	}
	/**
	 * @param myChargement
	 * @param myPatrimoine
	 */
	public ChargementPatrimoine(Chargement myChargement, Patrimoine myPatrimoine,boolean isOccuped) {
		super();
		this.myChargement = myChargement;
		this.myPatrimoine = myPatrimoine;
		this. isOccuped= isOccuped;
	}
	
	
	
	public boolean isValide() {
		return isValide;
	}
	public void setValide(boolean isValide) {
		this.isValide = isValide;
	}
	public boolean isOccuped() {
		return isOccuped;
	}
	public void setOccuped(boolean isOccuped) {
		this.isOccuped = isOccuped;
	}
	public ChargementPatrimoine() {
		super();
	}
	public long getIdChargPat() {
		return idChargPat;
	}
	public void setIdChargPat(long idChargPat) {
		this.idChargPat = idChargPat;
	}
	public Chargement getMyChargement() {
		return myChargement;
	}
	public void setMyChargement(Chargement myChargement) {
		this.myChargement = myChargement;
	}
	public Patrimoine getMyPatrimoine() {
		return myPatrimoine;
	}
	public void setMyPatrimoine(Patrimoine myPatrimoine) {
		this.myPatrimoine = myPatrimoine;
	}
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("ChargementPatrimoine [idChargPat=");
		builder.append(idChargPat);
		builder.append(", myChargement=");
		builder.append(myChargement);
		builder.append(", myPatrimoine=");
		builder.append(myPatrimoine);
		builder.append("]");
		return builder.toString();
	}

    
}