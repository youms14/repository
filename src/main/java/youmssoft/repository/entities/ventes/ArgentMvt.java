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

import youmssoft.repository.entities.livraison.GestionLivraison;
import youmssoft.repository.entities.livraison.Personnel;


@Entity
@Table(name="ArgentMvt")
public class ArgentMvt implements Serializable{//Ok.

  @Id @GeneratedValue
  @Column(name = "idArgentMvt", nullable = false, unique=true)
  private long idArgentMvt;

  @Column(name = "montant", nullable = false)
  private float montant;

  @Column(name = "natureMvt", nullable = false)
  private Boolean natureMvt;//1 pour IN et 0 pour OUT

  @Column(name = "dateOpArgent", nullable = false)
  private LocalDate dateOpArgent;

  @Column(name = "heureOpArgent", nullable = false)
  private LocalTime heureOpArgent;

  @Column(name = "libelleArgent", nullable = true, length=50)
  private String libelleArgent;
  
  
  	@ManyToOne(fetch = FetchType.EAGER)//cascade = CascadeType.ALL
	@JoinColumn(name = "responsable", referencedColumnName="idPersonnel", nullable = true)//A mettre false apres.
	private Personnel responsable;

  	@OneToOne(fetch = FetchType.EAGER)//cascade = CascadeType.ALL
  	@JoinColumn(name = "myGestionFacture", referencedColumnName="idGestionFacture", nullable = true)
    private GestionFacture myGestionFacture;
  	
  	@OneToOne(fetch = FetchType.EAGER)//cascade = CascadeType.ALL
    @JoinColumn(name = "myGestionLivraison", referencedColumnName="idGestionLivraison", nullable = true)
    private GestionLivraison myGestionLivraison;
  	
  	@ManyToOne(fetch = FetchType.EAGER)//cascade = CascadeType.ALL
    @JoinColumn(name = "myGestionRetourChargment", referencedColumnName="idGRC", nullable = true)
    private GestionRetourChargement myGestionRetourChargment;
  	
  	@OneToOne(fetch = FetchType.EAGER)//cascade = CascadeType.ALL
    @JoinColumn(name = "myTotalRistournePayement", referencedColumnName="idTotalRistourne", nullable = true)
    private TotalRistournePayement myTotalRistournePayement;
  	
  	@OneToOne(fetch = FetchType.EAGER)//cascade = CascadeType.ALL
    @JoinColumn(name = "myDepenses", referencedColumnName="idDepense", nullable = true)
    private Depenses myDepenses;
  	
  	@OneToOne(fetch = FetchType.EAGER)//cascade = CascadeType.ALL
    @JoinColumn(name = "myCaisseJournaliere", referencedColumnName="idCaisseJournaliere", nullable = true)
  	private CaisseJournaliere myCaisseJournaliere;
  	
  	@OneToOne(fetch = FetchType.EAGER)//cascade = CascadeType.ALL
    @JoinColumn(name = "myInterfaceCaisse", referencedColumnName="idIntCaisse", nullable = true)
  	private InterfaceCaisse myInterfaceCaisse;
  	
  	 @OneToOne(fetch = FetchType.EAGER)//cascade = CascadeType.ALL
 	 @JoinColumn(name = "myCass", referencedColumnName="idCass", nullable = true)
  	 private Cass myCass;
  	
  	@Column(name = "isValide", nullable = true) 
	 private boolean isValide=true;

  	
  	
	public long getIdArgentMvt() {
		return idArgentMvt;
	}





	public Cass getMyCass() {
		return myCass;
	}





	public void setMyCass(Cass myCass) {
		this.myCass = myCass;
	}





	public ArgentMvt(long idArgentMvt, float montant, Boolean natureMvt, LocalDate dateOpArgent,
			LocalTime heureOpArgent, String libelleArgent, GestionFacture myGestionFacture,
			GestionLivraison myGestionLivraison, GestionRetourChargement myGestionRetourChargment,
			TotalRistournePayement myTotalRistournePayement, Depenses myDepenses, CaisseJournaliere myCaisseJournaliere,
			InterfaceCaisse myInterfaceCaisse,Personnel responsable) {
		super();
		this.idArgentMvt = idArgentMvt;
		this.montant = montant;
		this.natureMvt = natureMvt;
		this.dateOpArgent = dateOpArgent;
		this.heureOpArgent = heureOpArgent;
		this.libelleArgent = libelleArgent;
		this.myGestionFacture = myGestionFacture;
		this.myGestionLivraison = myGestionLivraison;
		this.myGestionRetourChargment = myGestionRetourChargment;
		this.myTotalRistournePayement = myTotalRistournePayement;
		this.myDepenses = myDepenses;
		this.myCaisseJournaliere = myCaisseJournaliere;
		this.myInterfaceCaisse = myInterfaceCaisse;
		this. responsable= responsable;
	}





	public ArgentMvt(float montant, Boolean natureMvt, LocalDate dateOpArgent, LocalTime heureOpArgent,
			String libelleArgent, GestionFacture myGestionFacture, GestionLivraison myGestionLivraison,
			GestionRetourChargement myGestionRetourChargment, TotalRistournePayement myTotalRistournePayement,
			Depenses myDepenses, CaisseJournaliere myCaisseJournaliere, InterfaceCaisse myInterfaceCaisse,Personnel responsable) {
		super();
		this.montant = montant;
		this.natureMvt = natureMvt;
		this.dateOpArgent = dateOpArgent;
		this.heureOpArgent = heureOpArgent;
		this.libelleArgent = libelleArgent;
		this.myGestionFacture = myGestionFacture;
		this.myGestionLivraison = myGestionLivraison;
		this.myGestionRetourChargment = myGestionRetourChargment;
		this.myTotalRistournePayement = myTotalRistournePayement;
		this.myDepenses = myDepenses;
		this.myCaisseJournaliere = myCaisseJournaliere;
		this.myInterfaceCaisse = myInterfaceCaisse;
		this. responsable= responsable;
	}





	public float getMontant() {
		return montant;
	}





	public void setMontant(float montant) {
		this.montant = montant;
	}





	public Boolean getNatureMvt() {
		return natureMvt;
	}





	public void setNatureMvt(Boolean natureMvt) {
		this.natureMvt = natureMvt;
	}





	public LocalDate getDateOpArgent() {
		return dateOpArgent;
	}





	public void setDateOpArgent(LocalDate dateOpArgent) {
		this.dateOpArgent = dateOpArgent;
	}





	public LocalTime getHeureOpArgent() {
		return heureOpArgent;
	}





	public boolean isValide() {
		return isValide;
	}





	public void setValide(boolean isValide) {
		this.isValide = isValide;
	}





	public void setHeureOpArgent(LocalTime heureOpArgent) {
		this.heureOpArgent = heureOpArgent;
	}





	public String getLibelleArgent() {
		return libelleArgent;
	}





	public void setLibelleArgent(String libelleArgent) {
		this.libelleArgent = libelleArgent;
	}





	public GestionFacture getMyGestionFacture() {
		return myGestionFacture;
	}





	public void setMyGestionFacture(GestionFacture myGestionFacture) {
		this.myGestionFacture = myGestionFacture;
	}





	public GestionLivraison getMyGestionLivraison() {
		return myGestionLivraison;
	}





	public void setMyGestionLivraison(GestionLivraison myGestionLivraison) {
		this.myGestionLivraison = myGestionLivraison;
	}





	public GestionRetourChargement getMyGestionRetourChargment() {
		return myGestionRetourChargment;
	}





	public void setMyGestionRetourChargment(GestionRetourChargement myGestionRetourChargment) {
		this.myGestionRetourChargment = myGestionRetourChargment;
	}





	public TotalRistournePayement getMyTotalRistournePayement() {
		return myTotalRistournePayement;
	}





	public void setMyTotalRistournePayement(TotalRistournePayement myTotalRistournePayement) {
		this.myTotalRistournePayement = myTotalRistournePayement;
	}





	public Depenses getMyDepenses() {
		return myDepenses;
	}





	public void setMyDepenses(Depenses myDepenses) {
		this.myDepenses = myDepenses;
	}





	public CaisseJournaliere getMyCaisseJournaliere() {
		return myCaisseJournaliere;
	}





	public void setMyCaisseJournaliere(CaisseJournaliere myCaisseJournaliere) {
		this.myCaisseJournaliere = myCaisseJournaliere;
	}





	public InterfaceCaisse getMyInterfaceCaisse() {
		return myInterfaceCaisse;
	}





	public void setMyInterfaceCaisse(InterfaceCaisse myInterfaceCaisse) {
		this.myInterfaceCaisse = myInterfaceCaisse;
	}





	public void setIdArgentMvt(long idArgentMvt) {
		this.idArgentMvt = idArgentMvt;
	}





	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("ArgentMvt [idArgentMvt=");
		builder.append(idArgentMvt);
		builder.append(", montant=");
		builder.append(montant);
		builder.append(", natureMvt=");
		builder.append(natureMvt);
		builder.append(", dateOpArgent=");
		builder.append(dateOpArgent);
		builder.append(", heureOpArgent=");
		builder.append(heureOpArgent);
		builder.append(", libelleArgent=");
		builder.append(libelleArgent);
		builder.append(", myGestionFacture=");
		builder.append(myGestionFacture);
		builder.append(", myGestionLivraison=");
		builder.append(myGestionLivraison);
		builder.append(", myGestionRetourChargment=");
		builder.append(myGestionRetourChargment);
		builder.append(", myTotalRistournePayement=");
		builder.append(myTotalRistournePayement);
		builder.append(", myDepenses=");
		builder.append(myDepenses);
		//builder.append(", myCaisseJournaliere=");
	//	builder.append(myCaisseJournaliere);
	//	builder.append(", myInterfaceCaisse=");
	//	builder.append(myInterfaceCaisse);
		builder.append("]");
		return builder.toString();
	}





	public Personnel getResponsable() {
		return responsable;
	}





	public void setResponsable(Personnel responsable) {
		this.responsable = responsable;
	}





	public ArgentMvt() {
		super();
	}


  	
  	
    

}