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

import youmssoft.repository.entities.livraison.Personnel;

@Entity
@Table(name="InterfaceCaisse")
public class InterfaceCaisse implements Serializable {

	@Id @GeneratedValue
	@Column(name = "idIntCaisse", nullable = false, unique=true)
	private long idIntCaisse;

	@Column(name = "montantOperation", nullable = false)
  	private float montantOperation;

	@Column(name = "natureOperation", nullable = false)
  	private boolean natureOperation;

	@Column(name = "dateOperation", nullable = false)
  	private LocalDate dateOperation;

  
	@ManyToOne(fetch = FetchType.EAGER)//cascade = CascadeType.ALL
	@JoinColumn(name = "responsable", referencedColumnName="idPersonnel", nullable = true)//A mettre false apres.
	private Personnel caissiere;
	
	@OneToOne(fetch = FetchType.EAGER)//cascade = CascadeType.ALL
  	@JoinColumn(name = "myAchatEmballage", referencedColumnName="idAcharEmballage", nullable = true)
  	private AchatEmballage myAchatEmballage;
  
	@OneToOne(fetch = FetchType.EAGER)//cascade = CascadeType.ALL
  	@JoinColumn(name = "myGestionCaisse", referencedColumnName="idGestionCaisse", nullable = true)
  	private GestionCaisse myGestionCaisse;
   
	@OneToOne(fetch = FetchType.EAGER)//cascade = CascadeType.ALL
  	@JoinColumn(name = "myCaisseJournaliere", referencedColumnName="idCaisseJournaliere", nullable = true)
  	private CaisseJournaliere myCaisseJournaliere;
    
	@OneToOne(fetch = FetchType.EAGER)//cascade = CascadeType.ALL
  	@JoinColumn(name = "myArgentMvtPourDecaisser", referencedColumnName="idArgentMvt", nullable = true)
  	private ArgentMvt myArgentMvtPourDecaisser;
	
	@Column(name = "isValide", nullable = true) 
	 private boolean isValide=true;

	public InterfaceCaisse(long idIntCaisse, float montantOperation, boolean natureOperation, LocalDate dateOperation,
			GestionCaisse myGestionCaisse, CaisseJournaliere myCaisseJournaliere, ArgentMvt myArgentMvtPourDecaisser,Personnel caissiere) {
		super();
		this.idIntCaisse = idIntCaisse;
		this.montantOperation = montantOperation;
		this.natureOperation = natureOperation;
		this.dateOperation = dateOperation;
		this.myGestionCaisse = myGestionCaisse;
		this.myCaisseJournaliere = myCaisseJournaliere;
		this.myArgentMvtPourDecaisser = myArgentMvtPourDecaisser;
		this.caissiere=  caissiere;
	}

	public InterfaceCaisse(float montantOperation, boolean natureOperation, LocalDate dateOperation,
			GestionCaisse myGestionCaisse, CaisseJournaliere myCaisseJournaliere, ArgentMvt myArgentMvtPourDecaisser, Personnel caissiere) {
		super();
		this.montantOperation = montantOperation;
		this.natureOperation = natureOperation;
		this.dateOperation = dateOperation;
		this.myGestionCaisse = myGestionCaisse;
		this.myCaisseJournaliere = myCaisseJournaliere;
		this.myArgentMvtPourDecaisser = myArgentMvtPourDecaisser;
		this. caissiere= caissiere;
	}

	public InterfaceCaisse() {
		super();
	}
	
	
	
	public boolean isValide() {
		return isValide;
	}

	public void setValide(boolean isValide) {
		this.isValide = isValide;
	}

	public Personnel getCaissiere() {
		return caissiere;
	}

	public void setCaissiere(Personnel caissiere) {
		this.caissiere = caissiere;
	}

	public AchatEmballage getMyAchatEmballage() {
		return myAchatEmballage;
	}

	public void setMyAchatEmballage(AchatEmballage myAchatEmballage) {
		this.myAchatEmballage = myAchatEmballage;
	}

	public long getIdIntCaisse() {
		return idIntCaisse;
	}

	public void setIdIntCaisse(long idIntCaisse) {
		this.idIntCaisse = idIntCaisse;
	}

	public float getMontantOperation() {
		return montantOperation;
	}

	public void setMontantOperation(float montantOperation) {
		this.montantOperation = montantOperation;
	}

	public boolean isNatureOperation() {
		return natureOperation;
	}

	public void setNatureOperation(boolean natureOperation) {
		this.natureOperation = natureOperation;
	}

	public LocalDate getDateOperation() {
		return dateOperation;
	}

	public void setDateOperation(LocalDate dateOperation) {
		this.dateOperation = dateOperation;
	}

	public GestionCaisse getMyGestionCaisse() {
		return myGestionCaisse;
	}

	public void setMyGestionCaisse(GestionCaisse myGestionCaisse) {
		this.myGestionCaisse = myGestionCaisse;
	}

	public CaisseJournaliere getMyCaisseJournaliere() {
		return myCaisseJournaliere;
	}

	public void setMyCaisseJournaliere(CaisseJournaliere myCaisseJournaliere) {
		this.myCaisseJournaliere = myCaisseJournaliere;
	}

	public ArgentMvt getMyArgentMvtPourDecaisser() {
		return myArgentMvtPourDecaisser;
	}

	public void setMyArgentMvtPourDecaisser(ArgentMvt myArgentMvtPourDecaisser) {
		this.myArgentMvtPourDecaisser = myArgentMvtPourDecaisser;
	}
	
	
	

}