package youmssoft.repository.entities.ventes;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name="DetailsFacture")
public class DetailsFacture implements Serializable{

	@Id @GeneratedValue
	@Column(name = "idDetailsFacture", nullable = false, unique=true)
	private long idDetailsFacture;

	@Column(name = "totalAvanceSolde", nullable = false)
	private float totalAvanceSolde;

	@Column(name = "totalResteSolde", nullable = false)
	private float totalResteSolde;

	@Column(name = "totalAvanceEmb", nullable = false)
	private float totalAvanceEmb;

	@Column(name = "totalResteEmb", nullable = false)
	private float totalResteEmb;

  
	@OneToOne(fetch = FetchType.EAGER)//cascade = CascadeType.ALL
	@JoinColumn(name = "myFacture", referencedColumnName="idFacture", nullable = true)
    private Facture myFacture;
	
	@Column(name = "isValide", nullable = true) 
	 private boolean isValide=true;

	/**
	 * @param idDetailsFacture
	 * @param totalAvanceSolde
	 * @param totalResteSolde
	 * @param totalAvanceEmb
	 * @param totalResteEmb
	 * @param myFacture
	 */
	public DetailsFacture(long idDetailsFacture, float totalAvanceSolde, float totalResteSolde, float totalAvanceEmb,
			float totalResteEmb, Facture myFacture) {
		super();
		this.idDetailsFacture = idDetailsFacture;
		this.totalAvanceSolde = totalAvanceSolde;
		this.totalResteSolde = totalResteSolde;
		this.totalAvanceEmb = totalAvanceEmb;
		this.totalResteEmb = totalResteEmb;
		this.myFacture = myFacture;
	}

	/**
	 * @param totalAvanceSolde
	 * @param totalResteSolde
	 * @param totalAvanceEmb
	 * @param totalResteEmb
	 * @param myFacture
	 */
	public DetailsFacture(float totalAvanceSolde, float totalResteSolde, float totalAvanceEmb, float totalResteEmb,
			Facture myFacture) {
		super();
		this.totalAvanceSolde = totalAvanceSolde;
		this.totalResteSolde = totalResteSolde;
		this.totalAvanceEmb = totalAvanceEmb;
		this.totalResteEmb = totalResteEmb;
		this.myFacture = myFacture;
	}

	/**
	 * 
	 */
	public DetailsFacture() {
		super();
		this.totalAvanceSolde = 0;
		this.totalResteSolde = 0;
		this.totalAvanceEmb = 0;
		this.totalResteEmb = 0;
	}

	public long getIdDetailsFacture() {
		return idDetailsFacture;
	}

	public void setIdDetailsFacture(long idDetailsFacture) {
		this.idDetailsFacture = idDetailsFacture;
	}

	
	public boolean isValide() {
		return isValide;
	}

	public void setValide(boolean isValide) {
		this.isValide = isValide;
	}

	public float getTotalAvanceSolde() {
		return totalAvanceSolde;
	}

	public void setTotalAvanceSolde(float totalAvanceSolde) {
		this.totalAvanceSolde = totalAvanceSolde;
	}

	public float getTotalResteSolde() {
		return totalResteSolde;
	}

	public void setTotalResteSolde(float totalResteSolde) {
		this.totalResteSolde = totalResteSolde;
	}

	public float getTotalAvanceEmb() {
		return totalAvanceEmb;
	}

	public void setTotalAvanceEmb(float totalAvanceEmb) {
		this.totalAvanceEmb = totalAvanceEmb;
	}

	public float getTotalResteEmb() {
		return totalResteEmb;
	}

	public void setTotalResteEmb(float totalResteEmb) {
		this.totalResteEmb = totalResteEmb;
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
		builder.append("DetailsFacture [idDetailsFacture=");
		builder.append(idDetailsFacture);
		builder.append(", totalAvanceSolde=");
		builder.append(totalAvanceSolde);
		builder.append(", totalResteSolde=");
		builder.append(totalResteSolde);
		builder.append(", totalAvanceEmb=");
		builder.append(totalAvanceEmb);
		builder.append(", totalResteEmb=");
		builder.append(totalResteEmb);
		//builder.append(", myFacture=");
		//builder.append(myFacture);
		builder.append("]");
		return builder.toString();
	}
	
	
    
	
	
    
    

}