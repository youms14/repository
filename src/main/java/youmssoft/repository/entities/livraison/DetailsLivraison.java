package youmssoft.repository.entities.livraison;

import java.io.Serializable;

import javax.persistence.CascadeType;
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
@Table(name="detailsLivraison")
public class DetailsLivraison implements Serializable{

	
  /**
	 * 
	 */
	//private static final long serialVersionUID = 1713876818774335141L;

	@Id @GeneratedValue
	@Column(name = "idDetailsLivraison", nullable = false, unique=true)
	private long idDetailsLivraison;

	@Column(name = "avanceSolde", nullable = false)
	private float avanceSolde;

	@Column(name = "resteSolde", nullable = false)
	private float resteSolde;

	@Column(name = "avanceEmb", nullable = false)
	private float avanceEmb;

	@Column(name = "resteEmb", nullable = false)
	private float resteEmb;

	@Column(name = "deconsigneValue", nullable = false)
	private float deconsigneValue=(long) 0;  
	
	@Column(name = "isDeconsignedDL", nullable = false)
	private boolean isDeconsignedDL=false;  
	
	
  
  @OneToOne(fetch = FetchType.EAGER)
  @JoinColumn(name = "mylivraison", referencedColumnName="idLivraison", nullable = true)
  private Livraison myLivraison;//ok fk 
  

  @Column(name = "isValide", nullable = true) 
	 private boolean isValide=true;



  
public boolean isValide() {
	return isValide;
}



public void setValide(boolean isValide) {
	this.isValide = isValide;
}



public DetailsLivraison() {
	super();
	this.avanceSolde = 0;
	this.resteSolde = 0;
	this.avanceEmb = 0;
	this.resteEmb = 0;
	this.isDeconsignedDL=false;
	this.deconsigneValue = 0;
	//this.myPersonnelIntDL = null;
	//this.myPernonnelExtDL = pernonnelExtDL;	
}



public DetailsLivraison(float avanceSolde, float resteSolde, float avanceEmb, float resteEmb, float deconsigneValue,
		boolean isDeconsignedDL, Livraison myLivraison) {
	super();
	this.avanceSolde = avanceSolde;
	this.resteSolde = resteSolde;
	this.avanceEmb = avanceEmb;
	this.resteEmb = resteEmb;
	this.deconsigneValue = deconsigneValue;
	this.isDeconsignedDL = isDeconsignedDL;
	this.myLivraison=myLivraison;
}



public DetailsLivraison(long idDetailsLivraison, float avanceSolde, float resteSolde, float avanceEmb, float resteEmb,
		float deconsigneValue, boolean isDeconsignedDL,Livraison myLivraison) {
	super();
	this.idDetailsLivraison = idDetailsLivraison;
	this.avanceSolde = avanceSolde;
	this.resteSolde = resteSolde;
	this.avanceEmb = avanceEmb;
	this.resteEmb = resteEmb;
	this.deconsigneValue = deconsigneValue;
	this.isDeconsignedDL = isDeconsignedDL;
	this.myLivraison=myLivraison;
}



public boolean isDeconsignedDL() {
	return isDeconsignedDL;
}

public void setDeconsignedDL(boolean isDeconsignedDL) {
	this.isDeconsignedDL = isDeconsignedDL;
}

public void setIdDetailsLivraison(long idDetailsLivraison) {
	this.idDetailsLivraison = idDetailsLivraison;
}

public long getIdDetailsLivraison() {
	return idDetailsLivraison;
}

public void setIdDetailsLivraison(int idDetailsLivraison) {
	this.idDetailsLivraison = idDetailsLivraison;
}

public float getAvanceSolde() {
	return avanceSolde;
}

public void setAvanceSolde(float avanceSolde) {
	this.avanceSolde = avanceSolde;
}

public float getResteSolde() {
	return resteSolde;
}

public void setResteSolde(float resteSolde) {
	this.resteSolde = resteSolde;
}

public float getAvanceEmb() {
	return avanceEmb;
}

public void setAvanceEmb(float avanceEmb) {
	this.avanceEmb = avanceEmb;
}

public float getResteEmb() {
	return resteEmb;
}

public void setResteEmb(float resteEmb) {
	this.resteEmb = resteEmb;
}

public float getDeconsigneValue() {
	return deconsigneValue;
}

public void setDeconsigneValue(float deconsigneValue) {
	this.deconsigneValue = deconsigneValue;
}



public Livraison getMyLivraison() {
	return myLivraison;
}



public void setMyLivraison(Livraison myLivraison) {
	this.myLivraison = myLivraison;
}



@Override
public String toString() {
	StringBuilder builder = new StringBuilder();
	builder.append("DetailsLivraison [idDetailsLivraison=");
	builder.append(idDetailsLivraison);
	builder.append(", avanceSolde=");
	builder.append(avanceSolde);
	builder.append(", resteSolde=");
	builder.append(resteSolde);
	builder.append(", avanceEmb=");
	builder.append(avanceEmb);
	builder.append(", resteEmb=");
	builder.append(resteEmb);
	builder.append(", deconsigneValue=");
	builder.append(deconsigneValue);
	builder.append(", isDeconsignedDL=");
	builder.append(isDeconsignedDL);
	builder.append(", myLivraison=");
	//builder.append(myLivraison);
	builder.append("]");
	return builder.toString();
}









  
}