package youmssoft.repository.entities.livraison;
/*
 * Opérations liées à une livraison.
 * Chaque opération doit être iprimé et visé par les deux parties.
 */

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

import youmssoft.repository.entities.ventes.ArgentMvt;
import youmssoft.repository.entities.ventes.EmballagesMvt;

@Entity
@Table(name="gestionLivraison")
public class GestionLivraison implements Serializable{

  /**
	 * 
	 */
private static final long serialVersionUID = -2324476294027280513L;

  @Id @GeneratedValue
  @Column(name = "idGestionLivraison", nullable = false, unique=true)
  private long idGestionLivraison;

  @Column(name = "natureOperation", nullable = false)
  private boolean natureOperation;//argent ou emb?

  @Column(name = "avanceGL", nullable = false)
  private float avanceGL;
  
  /*
  @Column(name = "resteGL", nullable = false)
  private float resteGL;
*/
  @Column(name = "dateOperation", nullable = false)
  private LocalDate dateOperation;
  
  @Column(name = "heureOperation", nullable = false)
  private LocalTime heureOperation;
  

  @ManyToOne(fetch = FetchType.EAGER)//cascade = CascadeType.ALL
  @JoinColumn(name = "myPersonnelInt", referencedColumnName="idPersonnel", nullable = false)
  private Personnel myPersonnelInt;//ok

  @ManyToOne(fetch = FetchType.EAGER)
  @JoinColumn(name = "myPersonnelExt", referencedColumnName="idCollaborateurExt", nullable = false)
  private CollaborateurExt personnelExt;//ok

  @Column(name = "preuveJuridique", nullable = true, length = 60)
  private String preuveJuridique;

  @Column(name = "valideOP", nullable = false)
  private boolean valideOP=true;
  
  @Column(name = "isDeconsigned", nullable = false)
  private boolean isDeconsigned=false;

  @Column(name = "isManaged", nullable = true)//a mettre à false plus tard.
	private boolean isManaged=false;
  
  @Column(name = "isValide", nullable = true) 
	 private boolean isValide=true;
  
  @ManyToOne(fetch = FetchType.EAGER)
  @JoinColumn(name = "myLivraison", referencedColumnName="idLivraison", nullable = false)
  private Livraison myLivraison;//ok
  
  
  @OneToOne(fetch = FetchType.EAGER)//cascade = CascadeType.ALL
  @JoinColumn(name = "myArgentMvt", referencedColumnName="idArgentMvt", nullable = true)
  public ArgentMvt myArgentMvt;
  
  @OneToOne(fetch = FetchType.EAGER) //cascade=CascadeType.PERSIST: on save les deux entités à la fois
  @JoinColumn(name = "myEmballagesMvt", referencedColumnName="idEmb", nullable = true)
  private EmballagesMvt myEmballagesMvt;
  /*
   * cascade: permet de cascader les oérations.
   * 	ALL:	cascade={PERSIST, MERGE, REMOVE, REFRESH, DETACH}
   * 		PERSIST: persiste les opérations
   * 		MERGE:   
   */	
  
  
  
  /*
   * @ManyToOne
   @JoinColumn(name="ADDR_ID")
   public Address getAddress() { 
   	return address; 
   }
   */

public GestionLivraison(int idGestionLivraison, boolean natureOperation, float avanceGL, 
		LocalDate dateOperation,LocalTime heureOperation, Personnel personnelInt, CollaborateurExt personnelExt, String preuveJuridique,
		boolean valideOP, Livraison myLivraison, ArgentMvt myArgentMvt,EmballagesMvt myEmballagesMvt,boolean isManaged) {
	super();
	this.idGestionLivraison = idGestionLivraison;
	this.natureOperation = natureOperation;
	this.avanceGL = avanceGL;
	//this.resteGL = resteGL;
	this.dateOperation = dateOperation;
	this.heureOperation=heureOperation;
	this.myPersonnelInt = personnelInt;
	this.personnelExt = personnelExt;
	this.preuveJuridique = preuveJuridique;
	this.valideOP = valideOP;
	this.myLivraison = myLivraison;
	this.myArgentMvt=myArgentMvt;
	this.myEmballagesMvt=myEmballagesMvt;
	this. isManaged= isManaged;
}

public GestionLivraison(boolean natureOperation, int avanceGL,  LocalDate dateOperation, LocalTime heureOperation,
		Personnel personnelInt, CollaborateurExt personnelExt, String preuveJuridique, boolean valideOP,
		Livraison myLivraison, ArgentMvt myArgentMvt,EmballagesMvt myEmballagesMvt,boolean isManaged) {
	super();
	this.natureOperation = natureOperation;
	this.avanceGL = avanceGL;
	//this.resteGL = resteGL; //Pas nécessaire
	this.dateOperation = dateOperation;
	this.heureOperation=heureOperation;
	this.myPersonnelInt = personnelInt;
	this.personnelExt = personnelExt;
	this.preuveJuridique = preuveJuridique;
	this.valideOP = valideOP;
	this.myLivraison = myLivraison;
	this.myArgentMvt=myArgentMvt;
	this.myEmballagesMvt=myEmballagesMvt;
	this. isManaged= isManaged;
}




@Override
public String toString() {
	StringBuilder builder = new StringBuilder();
	builder.append("GestionLivraison [idGestionLivraison=");
	builder.append(idGestionLivraison);
	builder.append(", natureOperation=");
	builder.append(natureOperation);
	builder.append(", avanceGL=");
	builder.append(avanceGL);
	builder.append(", dateOperation=");
	builder.append(dateOperation);
	builder.append(", heureOperation=");
	builder.append(heureOperation);
	builder.append(", myPersonnelInt=");
	builder.append(myPersonnelInt);
	builder.append(", personnelExt=");
	builder.append(personnelExt);
	builder.append(", preuveJuridique=");
	builder.append(preuveJuridique);
	builder.append(", valideOP=");
	builder.append(valideOP);
	builder.append(", isDeconsigned=");
	builder.append(isDeconsigned);
	builder.append(", myLivraison=");
	builder.append(myLivraison);
	//builder.append(", myArgentMvt=");
	//builder.append(myArgentMvt);
	builder.append(", myEmballagesMvt=");
	builder.append(myEmballagesMvt);
	builder.append("]");
	return builder.toString();
}

public GestionLivraison() {
	super();
}





public boolean isValide() {
	return isValide;
}

public void setValide(boolean isValide) {
	this.isValide = isValide;
}

public boolean isManaged() {
	return isManaged;
}

public void setManaged(boolean isManaged) {
	this.isManaged = isManaged;
}

public EmballagesMvt getMyEmballagesMvt() {
	return myEmballagesMvt;
}

public void setMyEmballagesMvt(EmballagesMvt myEmballagesMvt) {
	this.myEmballagesMvt = myEmballagesMvt;
}

public boolean isDeconsigned() {
	return isDeconsigned;
}

public void setDeconsigned(boolean isDeconsigned) {
	this.isDeconsigned = isDeconsigned;
}

public void setNatureOperation(boolean natureOperation) {
	this.natureOperation = natureOperation;
}

public void setValideOP(boolean valideOP) {
	this.valideOP = valideOP;
}

public long getIdGestionLivraison() {
	return idGestionLivraison;
}

public void setIdGestionLivraison(int idGestionLivraison) {
	this.idGestionLivraison = idGestionLivraison;
}

public Boolean getNatureOperation() {
	return natureOperation;
}

public void setNatureOperation(Boolean natureOperation) {
	this.natureOperation = natureOperation;
}

public float getAvanceGL() {
	return avanceGL;
}

public void setAvanceGL(float avanceGL) {
	this.avanceGL = avanceGL;
}

/*
public float getResteGL() {
	return resteGL;
}

public void setResteGL(int resteGL) {
	this.resteGL = resteGL;
}*/

public LocalDate getDateOperation() {
	return dateOperation;
}

public void setDateOperation(LocalDate dateOperation) {
	this.dateOperation = dateOperation;
}



public LocalTime getHeureOperation() {
	return heureOperation;
}

public void setHeureOperation(LocalTime heureOperation) {
	this.heureOperation = heureOperation;
}

public Personnel getMyPersonnelInt() {
	return myPersonnelInt;
}

public void setMyPersonnelInt(Personnel myPersonnelInt) {
	this.myPersonnelInt = myPersonnelInt;
}

public void setIdGestionLivraison(long idGestionLivraison) {
	this.idGestionLivraison = idGestionLivraison;
}



public Personnel getPersonnelInt() {
	return myPersonnelInt;
}

public void setPersonnelInt(Personnel personnelInt) {
	this.myPersonnelInt = personnelInt;
}

public CollaborateurExt getPersonnelExt() {
	return personnelExt;
}

public void setPersonnelExt(CollaborateurExt personnelExt) {
	this.personnelExt = personnelExt;
}

public String getPreuveJuridique() {
	return preuveJuridique;
}

public void setPreuveJuridique(String preuveJuridique) {
	this.preuveJuridique = preuveJuridique;
}

public Boolean getValideOP() {
	return valideOP;
}

public void setValideOP(Boolean valideOP) {
	this.valideOP = valideOP;
}

public Livraison getMyLivraison() {
	return myLivraison;
}

public void setMyLivraison(Livraison myLivraison) {
	this.myLivraison = myLivraison;
}

public ArgentMvt getMyArgentMvt() {
	return myArgentMvt;
}

public void setMyArgentMvt(ArgentMvt myArgentMvt) {
	this.myArgentMvt = myArgentMvt;
}
  

  
}