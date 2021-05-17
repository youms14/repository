package youmssoft.repository.entities.ventes;

import java.io.Serializable;
import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import youmssoft.repository.dto.UsedCaisseJounaliere;

@Entity
@Table(name="CaisseJournaliere")
public class CaisseJournaliere implements Serializable{

	@Id @GeneratedValue
	@Column(name = "idCaisseJournaliere", nullable = false, unique=true)
	private long idCaisseJournaliere;

	@Column(name = "montantEncaisse", nullable = false)
	private float montantEncaisse;

	@Column(name = "montantDepenses", nullable = false)
	private float montantDepenses;

	@Column(name = "montantFinal", nullable = false)
	private float montantFinal;

	@Column(name = "date", nullable = false)
	private LocalDate date;

	@Column(name = "isTaked", nullable = false)
	private boolean isTaked;

	@Column(name = "usedType", nullable = false)
	private UsedCaisseJounaliere usedType;

	@Column(name = "montantUsed", nullable = true)//A mettre à false apres
	private float montantUsed;
    
	@Column(name = "isValide", nullable = true) 
	 private boolean isValide=true;
   
	@OneToOne(fetch = FetchType.EAGER)//cascade = CascadeType.ALL
  	@JoinColumn(name = "myInterfaceCaisse", referencedColumnName="idIntCaisse", nullable = true)
	private InterfaceCaisse myInterfaceCaisse;
	
	@ManyToOne(fetch = FetchType.EAGER)//cascade = CascadeType.ALL
  	@JoinColumn(name = "decaissementCJ", referencedColumnName="idArgentMvt", nullable = true)
	private ArgentMvt decaissementCJ;

	public CaisseJournaliere(long idCaisseJournaliere, float montantEncaisse, float montantDepenses, float montantFinal,
			LocalDate date, boolean isTaked, UsedCaisseJounaliere isUsed, InterfaceCaisse myInterfaceCaisse,
			ArgentMvt decaissementCJ,float montantUsed) {
		super();
		this.idCaisseJournaliere = idCaisseJournaliere;
		this.montantEncaisse = montantEncaisse;
		this.montantDepenses = montantDepenses;
		this.montantFinal = montantFinal;
		this.date = date;
		this.isTaked = isTaked;
		this.usedType = isUsed;
		this.myInterfaceCaisse = myInterfaceCaisse;
		this.decaissementCJ = decaissementCJ;
		this. montantUsed= montantUsed;
	}

	public CaisseJournaliere(float montantEncaisse, float montantDepenses, float montantFinal, LocalDate date,
			boolean isTaked, UsedCaisseJounaliere isUsed, InterfaceCaisse myInterfaceCaisse, ArgentMvt decaissementCJ,float montantUsed) {
		super();
		this.montantEncaisse = montantEncaisse;
		this.montantDepenses = montantDepenses;
		this.montantFinal = montantFinal;
		this.date = date;
		this.isTaked = isTaked;
		this.usedType = isUsed;
		this.myInterfaceCaisse = myInterfaceCaisse;
		this.decaissementCJ = decaissementCJ;
		this. montantUsed= montantUsed;
	}

	public CaisseJournaliere() {
		super();
	}

	public long getIdCaisseJournaliere() {
		return idCaisseJournaliere;
	}

	public void setIdCaisseJournaliere(long idCaisseJournaliere) {
		this.idCaisseJournaliere = idCaisseJournaliere;
	}

	public float getMontantEncaisse() {
		return montantEncaisse;
	}

	public void setMontantEncaisse(float montantEncaisse) {
		this.montantEncaisse = montantEncaisse;
	}

	public float getMontantDepenses() {
		return montantDepenses;
	}

	public void setMontantDepenses(float montantDepenses) {
		this.montantDepenses = montantDepenses;
	}

	public float getMontantFinal() {
		return montantFinal;
	}
	
	

	public boolean isValide() {
		return isValide;
	}

	public void setValide(boolean isValide) {
		this.isValide = isValide;
	}

	public void setMontantFinal(float montantFinal) {
		this.montantFinal = montantFinal;
	}

	public LocalDate getDate() {
		return date;
	}

	public void setDate(LocalDate date) {
		this.date = date;
	}

	public boolean isTaked() {
		return isTaked;
	}

	public void setTaked(boolean isTaked) {
		this.isTaked = isTaked;
	}

	

	public UsedCaisseJounaliere getUsedType() {
		return usedType;
	}

	public void setUsedType(UsedCaisseJounaliere usedType) {
		this.usedType = usedType;
	}

	public float getMontantUsed() {
		return montantUsed;
	}

	public void setMontantUsed(float montantUsed) {
		this.montantUsed = montantUsed;
	}

	public InterfaceCaisse getMyInterfaceCaisse() {
		return myInterfaceCaisse;
	}

	public void setMyInterfaceCaisse(InterfaceCaisse myInterfaceCaisse) {
		this.myInterfaceCaisse = myInterfaceCaisse;
	}

	public ArgentMvt getDecaissementCJ() {
		return decaissementCJ;
	}

	public void setDecaissementCJ(ArgentMvt decaissementCJ) {
		this.decaissementCJ = decaissementCJ;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("CaisseJournaliere [idCaisseJournaliere=");
		builder.append(idCaisseJournaliere);
		builder.append(", montantEncaisse=");
		builder.append(montantEncaisse);
		builder.append(", montantDepenses=");
		builder.append(montantDepenses);
		builder.append(", montantFinal=");
		builder.append(montantFinal);
		builder.append(", date=");
		builder.append(date);
		builder.append(", isTaked=");
		builder.append(isTaked);
		builder.append(", myInterfaceCaisse=");
		builder.append(myInterfaceCaisse);
		builder.append(", decaissementCJ=");
		builder.append(decaissementCJ);
		builder.append("]");
		return builder.toString();
	}
	
	
	

}