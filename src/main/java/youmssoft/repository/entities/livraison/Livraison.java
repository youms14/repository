package youmssoft.repository.entities.livraison;

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


@Entity
@Table(name="livraison")
public class Livraison implements Serializable{

  /**
	 * 
	 */
	private static final long serialVersionUID = 4983628600532872264L;

private static final String DEFAULT_NF = "0000000";
	
	@Id @GeneratedValue
	@Column(name = "idLivraison", nullable = false, unique=true)
	private long idLivraison;
	
	@Column(name = "jourLivraison", nullable = false, length = 30)
	private String jourLivraison;//Ex: Mercredi
	
	@Column(name = "dateLivraison", nullable = true)
	private LocalDate dateLivraison;
	
	@Column(name = "heureLivraison")
	private LocalTime heureLivraison;
	
	@Column(name = "nbColis")
	private float nbColis;
	
	@Column(name = "nbEmb", nullable = false)
	private float nbEmb;
	
	@Column(name = "soldeLivraison", nullable = false)
	private float soldeLivraison;
	
	@Column(name = "totalRist", nullable = false)
	private float totalRist;
	
	@Column(name = "isSolded", nullable = false)
	private boolean isSolded;
	
	@Column(name = "isEmbOk", nullable = false)
	private boolean isEmbOk;
	
	@Column(name = "numFactLivraision", nullable = true, length=30)
	private String numFactLivraision;
	
	@Column(name = "isSotcked", nullable = false)
	private boolean isSotcked;
	
	
	@Column(name = "isValide", nullable = true) 
	 private boolean isValide=true;

  @ManyToOne(fetch = FetchType.EAGER)  
  @JoinColumn(name = "myCollaborateurExt", referencedColumnName="idCollaborateurExt", nullable = false)
  private CollaborateurExt myCollaborateurExt;//ok

  @OneToOne(fetch = FetchType.EAGER)
  @JoinColumn(name = "myDetailsLivraison", referencedColumnName="idDetailsLivraison", nullable = false)
  private DetailsLivraison myDetailsLivraison;//ok
  
  @ManyToOne(fetch = FetchType.EAGER) //cascade = CascadeType.ALL,
  @JoinColumn(name = "myPersonnel", referencedColumnName="idPersonnel", nullable = false)
  private Personnel myPersonnel;//ok
  
  public Livraison(long idLivraison, String jourLivraison,LocalTime heureLivraison, LocalDate dateLivraison, float nbColis, float nbEmb,
		float soldeLivraison, float totalRist, CollaborateurExt myCollaborateurExt, DetailsLivraison myDetailsLivraison,
		Personnel myPersonnel, boolean isSolded, boolean isEmbOk, String numFactLivraision, boolean isSotcked) {
	super();
	this.idLivraison = idLivraison;
	this.jourLivraison = jourLivraison;//fin
	this.heureLivraison=heureLivraison;//fin
	this.dateLivraison = dateLivraison;//ok
	this.nbColis = nbColis;//ok
	this.nbEmb = nbEmb;//ok
	this.soldeLivraison = soldeLivraison;//ok
	this.totalRist = totalRist;//ok
	this.myCollaborateurExt = myCollaborateurExt;//ok
	this.myDetailsLivraison = myDetailsLivraison;
	this.myPersonnel = myPersonnel;
	this.isEmbOk=isEmbOk;
	this.isSolded=isSolded;
	this.numFactLivraision=numFactLivraision;
	this. isSotcked= isSotcked;
	
    }
  
	public Livraison() {
	super();
	this.isEmbOk=false;
	this.isSolded=false;
	this.nbColis=0;
	this.nbEmb=0;
	this.soldeLivraison=0;
	this.totalRist=0;
	this.dateLivraison=LocalDate.now();
	this.heureLivraison=LocalTime.now();
	this.jourLivraison=LocalDate.now().getDayOfWeek().toString();//plus tards on pensera au dictionnaire.
	this.numFactLivraision=DEFAULT_NF;
	
	
}

	public Livraison(String jourLivraison, LocalTime heureLivraison, LocalDate dateLivraison, float nbColis, float nbEmb, float soldeLivraison, float totalRist,
			CollaborateurExt myCollaborateurExt, DetailsLivraison myDetailsLivraison, Personnel myPersonnel, boolean isSolded, boolean isEmbOk, String numFactLivraision, boolean isSotcked) {
	super();
	this.jourLivraison = jourLivraison;
	this.heureLivraison=heureLivraison;
	this.dateLivraison = dateLivraison;
	this.nbColis = nbColis;//c
	this.nbEmb = nbEmb;//c
	this.soldeLivraison = soldeLivraison;//c
	this.totalRist = totalRist;//c
	this.myCollaborateurExt = myCollaborateurExt;
	this.myDetailsLivraison = myDetailsLivraison;//plus tard
	this.myPersonnel = myPersonnel;
	this.isEmbOk=isEmbOk;//plus tard
	this.isSolded=isSolded;//plus tard
	this.numFactLivraision=numFactLivraision;//pour la confirmation
	this. isSotcked= isSotcked;
	
}

	
	

	public boolean isValide() {
		return isValide;
	}

	public void setValide(boolean isValide) {
		this.isValide = isValide;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Livraison [idLivraison=");
		builder.append(idLivraison);
		builder.append(", jourLivraison=");
		builder.append(jourLivraison);
		builder.append(", dateLivraison=");
		builder.append(dateLivraison);
		builder.append(", heureLivraison=");
		builder.append(heureLivraison);
		builder.append(", nbColis=");
		builder.append(nbColis);
		builder.append(", nbEmb=");
		builder.append(nbEmb);
		builder.append(", soldeLivraison=");
		builder.append(soldeLivraison);
		builder.append(", totalRist=");
		builder.append(totalRist);
		builder.append(", isSolded=");
		builder.append(isSolded);
		builder.append(", isEmbOk=");
		builder.append(isEmbOk);
		builder.append(", numFactLivraision=");
		builder.append(numFactLivraision);
		builder.append(", myCollaborateurExt=");
		builder.append(myCollaborateurExt);
		builder.append(", myDetailsLivraison=");
		//builder.append(myDetailsLivraison);
		builder.append(", myPersonnel=");
		builder.append(myPersonnel);
		builder.append("]");
		return builder.toString();
	}
	
	

	

	public boolean isSolded() {
		return isSolded;
	}

	public void setSolded(boolean isSolded) {
		this.isSolded = isSolded;
	}

	public boolean isEmbOk() {
		return isEmbOk;
	}

	public void setEmbOk(boolean isEmbOk) {
		this.isEmbOk = isEmbOk;
	}

	public long getIdLivraison() {
		return idLivraison;
	}

	public void setIdLivraison(long id) {
		this.idLivraison = id;
	}
	
	

	public boolean isSotcked() {
		return isSotcked;
	}

	public void setSotcked(boolean isSotcked) {
		this.isSotcked = isSotcked;
	}

	public String getJourLivraison() {
		return jourLivraison;
	}

	public void setJourLivraison(String jourLivraison) {
		this.jourLivraison = jourLivraison;
	}

	public LocalDate getDateLivraison() {
		return dateLivraison;
	}
	
	

	public LocalTime getHeureLivraison() {
		return heureLivraison;
	}

	public void setHeureLivraison(LocalTime heureLivraison) {
		this.heureLivraison = heureLivraison;
	}

	public void setDateLivraison(LocalDate dateLivraison) {
		this.dateLivraison = dateLivraison;
	}

	public float getNbColis() {
		return nbColis;
	}

	public void setNbColis(float nbColis) {
		this.nbColis = nbColis;
	}

	public float getNbEmb() {
		return nbEmb;
	}

	public void setNbEmb(float nbEmb) {
		this.nbEmb = nbEmb;
	}

	public float getSoldeLivraison() {
		return soldeLivraison;
	}

	public void setSoldeLivraison(float soldeLivraison) {
		this.soldeLivraison = soldeLivraison;
	}

	public float getTotalRist() {
		return totalRist;
	}

	public void setTotalRist(float totalRist) {
		this.totalRist = totalRist;
	}

	public CollaborateurExt getMyCollaborateurExt() {
		return myCollaborateurExt;
	}

	public void setMyCollaborateurExt(CollaborateurExt myCollaborateurExt) {
		this.myCollaborateurExt = myCollaborateurExt;
	}

	public DetailsLivraison getMyDetailsLivraison() {
		return myDetailsLivraison;
	}

	public void setMyDetailsLivraison(DetailsLivraison myDetailsLivraison) {
		this.myDetailsLivraison = myDetailsLivraison;
	}

	public Personnel getMyPersonnel() {
		return myPersonnel;
	}

	public void setMyPersonnel(Personnel myPersonnel) {
		this.myPersonnel = myPersonnel;
	}

	public String getNumFactLivraision() {
		return numFactLivraision;
	}

	public void setNumFactLivraision(String numFactLivraision) {
		this.numFactLivraision = numFactLivraision;
	}
	
	
/*
	public Vector getMyAppProduitsLivraison() {
		return myAppProduitsLivraison;
	}

	public void setMyAppProduitsLivraison(Vector myAppProduitsLivraison) {
		this.myAppProduitsLivraison = myAppProduitsLivraison;
	}

	public Vector getMyAppGestionLivraison() {
		return myAppGestionLivraison;
	}

	public void setMyAppGestionLivraison(Vector myAppGestionLivraison) {
		this.myAppGestionLivraison = myAppGestionLivraison;
	}


*/




	/**
     * ok
     * @element-type ProduitsLivraison
     *
    public Vector  myAppProduitsLivraison;//ok
    
    /**
   * ok
   * @element-type GestionLivraison
   * it is an object for application's layer
   *
  public Vector  myAppGestionLivraison;//ok
  */
  
  

}