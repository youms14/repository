package youmssoft.repository.entities.ventes;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name="DetailsFC")
public class DetailsFC implements Serializable{//ok

	@Id @GeneratedValue
	@Column(name = "idDetailsFC", nullable = false, unique=true)
  private long idDetailsFC;
	
	@Column(name = "totalAvanceSoldeFC", nullable = false)
  private float totalAvanceSoldeFC;

	@Column(name = "totalResteSoldeFC", nullable = false)
  private float totalResteSoldeFC;

	@Column(name = "totalAvanceEmb", nullable = false)
  private float totalAvanceEmb;

	@Column(name = "totalresteEmb", nullable = false)
  private float totalresteEmb;

	@OneToOne(fetch = FetchType.EAGER)//cascade = CascadeType.ALL
	@JoinColumn(name = "myFacturesChargement", referencedColumnName="idFactCharg", nullable = true)// A changer à false.
    private FacturesChargement myFacturesChargement;
	
	@Column(name = "isValide", nullable = true) 
	 private boolean isValide=true;

	/**
	 * @param idDetailsFC
	 * @param totalAvanceSoldeFC
	 * @param totalResteSoldeFC
	 * @param totalAvanceEmb
	 * @param totalresteEmb
	 * @param myFacturesChargement
	 */
	public DetailsFC(long idDetailsFC, float totalAvanceSoldeFC, float totalResteSoldeFC, float totalAvanceEmb,
			float totalresteEmb, FacturesChargement myFacturesChargement) {
		super();
		this.idDetailsFC = idDetailsFC;
		this.totalAvanceSoldeFC = totalAvanceSoldeFC;
		this.totalResteSoldeFC = totalResteSoldeFC;
		this.totalAvanceEmb = totalAvanceEmb;
		this.totalresteEmb = totalresteEmb;
		this.myFacturesChargement = myFacturesChargement;
	}

	/**
	 * @param totalAvanceSoldeFC
	 * @param totalResteSoldeFC
	 * @param totalAvanceEmb
	 * @param totalresteEmb
	 * @param myFacturesChargement
	 */
	public DetailsFC(float totalAvanceSoldeFC, float totalResteSoldeFC, float totalAvanceEmb, float totalresteEmb,
			FacturesChargement myFacturesChargement) {
		super();
		this.totalAvanceSoldeFC = totalAvanceSoldeFC;
		this.totalResteSoldeFC = totalResteSoldeFC;
		this.totalAvanceEmb = totalAvanceEmb;
		this.totalresteEmb = totalresteEmb;
		this.myFacturesChargement = myFacturesChargement;
	}

	/**
	 * 
	 */
	public DetailsFC() {
		super();
		this.totalAvanceSoldeFC = 0;
		this.totalResteSoldeFC = 0;
		this.totalAvanceEmb = 0;
		this.totalresteEmb = 0;
		
	}
	
	

	public DetailsFC(FacturesChargement myFacturesChargement) {
		super();
		this.myFacturesChargement = myFacturesChargement;
		this.totalAvanceSoldeFC = 0;
		this.totalResteSoldeFC = 0;
		this.totalAvanceEmb = 0;
		this.totalresteEmb = 0;
	}

	public long getIdDetailsFC() {
		return idDetailsFC;
	}

	public void setIdDetailsFC(long idDetailsFC) {
		this.idDetailsFC = idDetailsFC;
	}

	public float getTotalAvanceSoldeFC() {
		return totalAvanceSoldeFC;
	}

	public void setTotalAvanceSoldeFC(float totalAvanceSoldeFC) {
		this.totalAvanceSoldeFC = totalAvanceSoldeFC;
	}

	public float getTotalResteSoldeFC() {
		return totalResteSoldeFC;
	}
	
	

	public boolean isValide() {
		return isValide;
	}

	public void setValide(boolean isValide) {
		this.isValide = isValide;
	}

	public void setTotalResteSoldeFC(float totalResteSoldeFC) {
		this.totalResteSoldeFC = totalResteSoldeFC;
	}

	public float getTotalAvanceEmb() {
		return totalAvanceEmb;
	}

	public void setTotalAvanceEmb(float totalAvanceEmb) {
		this.totalAvanceEmb = totalAvanceEmb;
	}

	public float getTotalresteEmb() {
		return totalresteEmb;
	}

	public void setTotalresteEmb(float totalresteEmb) {
		this.totalresteEmb = totalresteEmb;
	}

	public FacturesChargement getMyFacturesChargement() {
		return myFacturesChargement;
	}

	public void setMyFacturesChargement(FacturesChargement myFacturesChargement) {
		this.myFacturesChargement = myFacturesChargement;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("DetailsFC [idDetailsFC=");
		builder.append(idDetailsFC);
		builder.append(", totalAvanceSoldeFC=");
		builder.append(totalAvanceSoldeFC);
		builder.append(", totalResteSoldeFC=");
		builder.append(totalResteSoldeFC);
		builder.append(", totalAvanceEmb=");
		builder.append(totalAvanceEmb);
		builder.append(", totalresteEmb=");
		builder.append(totalresteEmb);
		builder.append(", myFacturesChargement=");
		builder.append(myFacturesChargement);
		builder.append("]");
		return builder.toString();
	}
    
    
    

}