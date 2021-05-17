package youmssoft.repository.entities.ventes;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="Caisse")
public class Caisse implements Serializable{//ok

	@Id @GeneratedValue
	@Column(name = "idCaisse", nullable = false, unique=true)
	private long idCaisse;

	@Column(name = "montantCaisse", nullable = false)
	private float montantCaisse;
	
	@Column(name = "capital", nullable = false)
	private float capital;
	
	@Column(name = "isValide", nullable = true) 
	 private boolean isValide=true;

	public Caisse(long idCaisse, float montantCaisse, float capital) {
		super();
		this.idCaisse = idCaisse;
		this.montantCaisse = montantCaisse;
		this.capital = capital;
	}

	public Caisse(float montantCaisse, float capital) {
		super();
		this.montantCaisse = montantCaisse;
		this.capital = capital;
	}

	public Caisse() {
		super();
	}

	public long getIdCaisse() {
		return idCaisse;
	}

	public void setIdCaisse(long idCaisse) {
		this.idCaisse = idCaisse;
	}

	public float getMontantCaisse() {
		return montantCaisse;
	}

	
	public boolean isValide() {
		return isValide;
	}

	public void setValide(boolean isValide) {
		this.isValide = isValide;
	}

	public void setMontantCaisse(float montantCaisse) {
		this.montantCaisse = montantCaisse;
	}

	public float getCapital() {
		return capital;
	}

	public void setCapital(float capital) {
		this.capital = capital;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Caisse [idCaisse=");
		builder.append(idCaisse);
		builder.append(", montantCaisse=");
		builder.append(montantCaisse);
		builder.append(", capital=");
		builder.append(capital);
		builder.append("]");
		return builder.toString();
	}
	
	


}