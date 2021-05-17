package youmssoft.repository.entities.livraison;


import java.io.Serializable;
import java.util.Vector;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table(name="fournisseur")
public class Fournisseur implements Serializable {

  /**
	 * 
	 */
	private static final long serialVersionUID = -5301718463723059048L;

@Id @GeneratedValue
  @Column(name = "idFournisseur", nullable = false, unique=true)
  private long idFournisseur;

  @Column(name = "nom", nullable = false, length=40)
  private String nom;

  @Column(name = "joursLivraison", nullable = true, length=40)
  private String joursLivraison;

  @Column(name = "periodeRist", nullable = true, length=40)
  private String periodeRist;

  @Column(name = "contact", nullable = false, length=40)
  private String contact;
  
  @Column(name = "isValide", nullable = true) 
	 private boolean isValide=true;

    public Fournisseur(int idFournisseur, String nom, String joursLivraison, String periodeRist, String contact) {
    	super();
    	this.idFournisseur = idFournisseur;
    	this.nom = nom;
    	this.joursLivraison = joursLivraison;
    	this.periodeRist = periodeRist;
    	this.contact = contact;
    }
    
    
	public Fournisseur() {
		super();
	}

	

	public boolean isValide() {
		return isValide;
	}


	public void setValide(boolean isValide) {
		this.isValide = isValide;
	}


	public Fournisseur(String nom, String joursLivraison, String periodeRist, String contact) {
		super();
		this.nom = nom;
		this.joursLivraison = joursLivraison;
		this.periodeRist = periodeRist;
		this.contact = contact;
	}



	public long getIdFournisseur() {
		return idFournisseur;
	}


	public void setIdFournisseur(long id) {
		this.idFournisseur = id;
	}


	public String getNom() {
		return nom;
	}


	public void setNom(String nom) {
		this.nom = nom;
	}


	public String getJoursLivraison() {
		return joursLivraison;
	}


	public void setJoursLivraison(String joursLivraison) {
		this.joursLivraison = joursLivraison;
	}


	public String getPeriodeRist() {
		return periodeRist;
	}


	public void setPeriodeRist(String periodeRist) {
		this.periodeRist = periodeRist;
	}


	public String getContact() {
		return contact;
	}


	public void setContact(String contact) {
		this.contact = contact;
	}


	@Override
	public String toString() {
		return "Fournisseur [idFournisseur=" + idFournisseur + ", nom=" + nom + ", joursLivraison=" + joursLivraison
				+ ", periodeRist=" + periodeRist + ", contact=" + contact + "]";
	}

/*
	public Vector getMyAppProduit() {
		return myAppProduit;
	}


	public void setMyAppProduit(Vector myAppProduit) {
		this.myAppProduit = myAppProduit;
	}


	public Vector getMyAppLivraison() {
		return myAppLivraison;
	}


	public void setMyAppLivraison(Vector myAppLivraison) {
		this.myAppLivraison = myAppLivraison;
	}


	public Vector getMyAppCollaborateurExt() {
		return myAppCollaborateurExt;
	}


	public void setMyAppCollaborateurExt(Vector myAppCollaborateurExt) {
		this.myAppCollaborateurExt = myAppCollaborateurExt;
	}

*/


	/**
   * ok
   * @element-type Produit
   */
  //public Vector  myAppProduit;//ok
  
 
    /**
   * ok
   * @element-type Livraison
   */
 // public Vector  myAppLivraison;
    /**
   * ok
   * @element-type CollaborateurExt
   */
 // public Vector  myAppCollaborateurExt;//ok

  
  
}