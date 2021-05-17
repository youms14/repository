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
@Table(name="PatrimoineFacture")
public class PatrimoineFacture implements Serializable{

	@Id @GeneratedValue
	@Column(name = "idPatrimoineFacture", nullable = false, unique=true)
	private long idPatrimoineFacture;
	
	@ManyToOne(fetch = FetchType.EAGER)//cascade = CascadeType.ALL
  	@JoinColumn(name = "patrimoine", referencedColumnName="idPatrimoine", nullable = true)
	private Patrimoine patrimoine;
	
	@ManyToOne(fetch = FetchType.EAGER)//cascade = CascadeType.ALL
  	@JoinColumn(name = "facture", referencedColumnName="idFacture", nullable = true)
	private Facture facture;
	
	@Column(name = "isValide", nullable = true) 
	 private boolean isValide=true;
	
	
	public PatrimoineFacture(long idPatrimoineFacture, Patrimoine patrimoine, Facture facture) {
		super();
		this.idPatrimoineFacture = idPatrimoineFacture;
		this.patrimoine = patrimoine;
		this.facture = facture;
	}


	public PatrimoineFacture(Patrimoine patrimoine, Facture facture) {
		super();
		this.patrimoine = patrimoine;
		this.facture = facture;
	}


	public PatrimoineFacture() {
		super();
	}


	public long getIdPatrimoineFacture() {
		return idPatrimoineFacture;
	}


	public void setIdPatrimoineFacture(long idPatrimoineFacture) {
		this.idPatrimoineFacture = idPatrimoineFacture;
	}

	

	public boolean isValide() {
		return isValide;
	}


	public void setValide(boolean isValide) {
		this.isValide = isValide;
	}


	public Patrimoine getPatrimoine() {
		return patrimoine;
	}


	public void setPatrimoine(Patrimoine patrimoine) {
		this.patrimoine = patrimoine;
	}


	public Facture getFacture() {
		return facture;
	}


	public void setFacture(Facture facture) {
		this.facture = facture;
	}


	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("PatrimoineFacture [idPatrimoineFacture=");
		builder.append(idPatrimoineFacture);
		builder.append(", patrimoine=");
		builder.append(patrimoine);
		builder.append(", facture=");
		builder.append(facture);
		builder.append("]");
		return builder.toString();
	}
	
	
	
}
