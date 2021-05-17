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
@Table(name="collaborateurExt")
public class CollaborateurExt implements Serializable{

  /**
	 * 
	 */
	private static final long serialVersionUID = 5273155155403391290L;
	
	 @Id @GeneratedValue
	 @Column(name = "idCollaborateurExt", nullable = false, unique=true)
	private long idCollaborateurExt;

	 @Column(name = "nomCE", nullable = false, length=30)
	 private String nomCE;

	 @Column(name = "prenomCE", nullable = true, length=30)
	 private String prenomCE;

	 @Column(name = "posteCE", nullable = true, length=30)
	 private String posteCE;

	 @Column(name = "contactCE1", nullable = false, length=30)
	 private String contactCE1;
	 
	 @Column(name = "contactCE2", nullable = true, length=30)
	 
	 private String contactCE2;
	 
	 @Column(name = "isValide", nullable = true) 
	 private boolean isValide=true;
  
  @ManyToOne(fetch = FetchType.EAGER) //cascade=CascadeType.PERSIST: on save les deux entités à la fois
  @JoinColumn(name = "myFournisseur", referencedColumnName="idFournisseur", nullable = false)
  private Fournisseur myFournisseur;//ok

  public CollaborateurExt(int idCollaborateurExt, String nomCE, String prenomCE, String posteCE, String contactCE1,
		String contactCE2, Fournisseur myFournisseur) {
	  super();
	  this.idCollaborateurExt = idCollaborateurExt;
	  this.nomCE = nomCE;
	  this.prenomCE = prenomCE;
	  this.posteCE = posteCE;
	  this.contactCE1 = contactCE1;
	  this.contactCE2 = contactCE2;
	  this.myFournisseur = myFournisseur;
  }

public CollaborateurExt(String nomCE, String prenomCE, String posteCE, String contactCE1, String contactCE2,
		Fournisseur myFournisseur) {
	super();
	this.nomCE = nomCE;
	this.prenomCE = prenomCE;
	this.posteCE = posteCE;
	this.contactCE1 = contactCE1;
	this.contactCE2 = contactCE2;
	this.myFournisseur = myFournisseur;
}

public CollaborateurExt() {
	super();
}

public boolean isValide() {
	return isValide;
}

public void setValide(boolean isValide) {
	this.isValide = isValide;
}

public long getIdCollaborateurExt() {
	return idCollaborateurExt;
}

public void setIdCollaborateurExt(long id) {
	this.idCollaborateurExt = id;
}

public String getNomCE() {
	return nomCE;
}

public void setNomCE(String nomCE) {
	this.nomCE = nomCE;
}

public String getPrenomCE() {
	return prenomCE;
}


public void setPrenomCE(String prenomCE) {
	this.prenomCE = prenomCE;
}

public String getPosteCE() {
	return posteCE;
}

public void setPosteCE(String posteCE) {
	this.posteCE = posteCE;
}

public String getContactCE1() {
	return contactCE1;
}

public void setContactCE1(String contactCE1) {
	this.contactCE1 = contactCE1;
}

public String getContactCE2() {
	return contactCE2;
}

public void setContactCE2(String contactCE2) {
	this.contactCE2 = contactCE2;
}

public Fournisseur getMyFournisseur() {
	return myFournisseur;
}

public void setMyFournisseur(Fournisseur myFournisseur) {
	this.myFournisseur = myFournisseur;
}

@Override
public String toString() {
	return "CollaborateurExt [idCollaborateurExt=" + idCollaborateurExt + ", nomCE=" + nomCE + ", prenomCE=" + prenomCE
			+ ", posteCE=" + posteCE + ", contactCE1=" + contactCE1 + ", contactCE2=" + contactCE2 + ", myFournisseur="
			+ myFournisseur + "]";
}
  

  

  
  

  
}