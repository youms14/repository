package youmssoft.repository.entities.ventes;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name="GestionCaisse")
public class GestionCaisse implements Serializable{

	@Id @GeneratedValue
	@Column(name = "idGestionCaisse", nullable = false, unique=true)
	private long idGestionCaisse;

	@Column(name = "natureOp", nullable = false)
	private boolean natureOp;

	@Column(name = "montant", nullable = false)
	private float montant;

	@Column(name = "date", nullable = false)
	@Temporal(TemporalType.TIMESTAMP)
	private Date date;
	
	@Column(name = "sourceOuDestination", nullable = true, length=50)
	private String sourceOuDestination;

	@OneToOne(fetch = FetchType.EAGER)//cascade = CascadeType.ALL
  	@JoinColumn(name = "myInterfaceCaisse", referencedColumnName="idIntCaisse", nullable = true)
    public InterfaceCaisse myInterfaceCaisse;
	
	@Column(name = "isValide", nullable = true) 
	 private boolean isValide=true;

	public GestionCaisse(long idGestionCaisse, boolean natureOp, float montant, Date date,
			String sourceOuDestination, InterfaceCaisse myInterfaceCaisse) {
		super();
		this.idGestionCaisse = idGestionCaisse;
		this.natureOp = natureOp;
		this.montant = montant;
		this.date = date;
		this.sourceOuDestination = sourceOuDestination;
		this.myInterfaceCaisse = myInterfaceCaisse;
	}

	public GestionCaisse() {
		super();
	}

	public GestionCaisse(boolean natureOp, float montant, Date date, String sourceOuDestination,
			InterfaceCaisse myInterfaceCaisse) {
		super();
		this.natureOp = natureOp;
		this.montant = montant;
		this.date = date;
		this.sourceOuDestination = sourceOuDestination;
		this.myInterfaceCaisse = myInterfaceCaisse;
	}

	public long getIdGestionCaisse() {
		return idGestionCaisse;
	}

	public void setIdGestionCaisse(long idGestionCaisse) {
		this.idGestionCaisse = idGestionCaisse;
	}
	

	public boolean isValide() {
		return isValide;
	}

	public void setValide(boolean isValide) {
		this.isValide = isValide;
	}

	public boolean isNatureOp() {
		return natureOp;
	}

	public void setNatureOp(boolean natureOp) {
		this.natureOp = natureOp;
	}

	public float getMontant() {
		return montant;
	}

	public void setMontant(float montant) {
		this.montant = montant;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public String getSourceOuDestination() {
		return sourceOuDestination;
	}

	public void setSourceOuDestination(String sourceOuDestination) {
		this.sourceOuDestination = sourceOuDestination;
	}

	public InterfaceCaisse getMyInterfaceCaisse() {
		return myInterfaceCaisse;
	}

	public void setMyInterfaceCaisse(InterfaceCaisse myInterfaceCaisse) {
		this.myInterfaceCaisse = myInterfaceCaisse;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("GestionCaisse [idGestionCaisse=");
		builder.append(idGestionCaisse);
		builder.append(", natureOp=");
		builder.append(natureOp);
		builder.append(", montant=");
		builder.append(montant);
		builder.append(", date=");
		builder.append(date);
		builder.append(", sourceOuDestination=");
		builder.append(sourceOuDestination);
		builder.append(", myInterfaceCaisse=");
		builder.append(myInterfaceCaisse);
		builder.append("]");
		return builder.toString();
	}
   
  
	
	
}