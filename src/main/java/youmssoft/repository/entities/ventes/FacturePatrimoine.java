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
@Table(name="FacturePatrimoine")
public class FacturePatrimoine implements Serializable{

	@Id @GeneratedValue
	@Column(name = "idFactPat", nullable = false, unique=true)
	private long idFactPat;

	@ManyToOne(fetch = FetchType.EAGER)//cascade = CascadeType.ALL
	@JoinColumn(name = "myFacture", referencedColumnName="idFacture", nullable = false)
    private Facture myFacture;
 
  	@ManyToOne(fetch = FetchType.EAGER)//cascade = CascadeType.ALL
	@JoinColumn(name = "myPatrimoine", referencedColumnName="idPatrimoine", nullable = true)
  	private Patrimoine myPatrimoine;
  	
  	@Column(name = "isValide", nullable = true) 
	 private boolean isValide=true;

	/**
	 * @param idFactPat
	 * @param myFacture
	 * @param myPatrimoine
	 */
	public FacturePatrimoine(long idFactPat, Facture myFacture, Patrimoine myPatrimoine) {
		super();
		this.idFactPat = idFactPat;
		this.myFacture = myFacture;
		this.myPatrimoine = myPatrimoine;
	}

	/**
	 * @param myFacture
	 * @param myPatrimoine
	 */
	public FacturePatrimoine(Facture myFacture, Patrimoine myPatrimoine) {
		super();
		this.myFacture = myFacture;
		this.myPatrimoine = myPatrimoine;
	}

	/**
	 * 
	 */
	public FacturePatrimoine() {
		super();
	}

	public long getIdFactPat() {
		return idFactPat;
	}

	public void setIdFactPat(long idFactPat) {
		this.idFactPat = idFactPat;
	}

	public Facture getMyFacture() {
		return myFacture;
	}
	
	

	public boolean isValide() {
		return isValide;
	}

	public void setValide(boolean isValide) {
		this.isValide = isValide;
	}

	public void setMyFacture(Facture myFacture) {
		this.myFacture = myFacture;
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
		builder.append("FacturePatrimoine [idFactPat=");
		builder.append(idFactPat);
		builder.append(", myFacture=");
		builder.append(myFacture);
		builder.append(", myPatrimoine=");
		builder.append(myPatrimoine);
		builder.append("]");
		return builder.toString();
	}
    
  	
    

}