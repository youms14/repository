package youmssoft.repository.entities.livraison;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.Vector;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import youmssoft.repository.entities.User;
/*
 * Cette classe est pour contenir les informations sur le personnel de l'entreprise.
 */
@Entity
@Table(name="personnel")
public class Personnel implements Serializable{

  

/**
	 * 
	 */
	//private static final long serialVersionUID = 2593687443458963961L;

  @Id @GeneratedValue
  @Column(name = "idPersonnel", nullable = false, unique=true)
  private long idPersonnel;

  @Column(name = "nomPers", nullable = false, length = 45)
  private String nomPers;

  @Column(name = "prenomPers", nullable = false, length = 45)
  private String prenomPers;

  @Column(name = "sexePers", nullable = false, length = 45)
  private Boolean sexePers;

  @Column(name = "cniPers", nullable = true, length = 45)
  private String cniPers;
  
  @Column(name = "dateCniPers", nullable = true)
  private  LocalDate  dateCniPers;

  @Column(name = "dateNaissancePers", nullable = true)
  private  LocalDate dateNaissancePers;
  
  @Column(name = "adressePers", nullable = true, length = 45)
  private String adressePers;

  @Column(name = "postePers", nullable = false, length = 45)
  private String postePers;

  @Column(name = "contactPers1", nullable = false, length = 45)
  private String contactPers1;

  @Column(name = "contactPers2", nullable = true, length = 45)
  private String contactPers2;
  
  @Column(name = "status", length = 30)
  private String status;

  @Column(name = "isValide", nullable = false) 
	 private boolean isValide=true;
  
  @OneToOne(fetch = FetchType.EAGER) //cascade=CascadeType.PERSIST: on save les deux entités à la fois
  @JoinColumn(name = "myUser", referencedColumnName="username", nullable = true)// doit rester false car tout personnel n'est pas toujours un utilisateur du système.
private User myUser;
 
    public Personnel(long idPersonnel, String nomPers, String prenomPers, Boolean sexePers, String cniPers,
    		LocalDate dateCniPers, LocalDate dateNaissancePers,String adresse, String postePers, String contactPers1, String contactPers2, String status) {
	super();
	this.idPersonnel = idPersonnel;
	this.nomPers = nomPers;
	this.prenomPers = prenomPers;
	this.sexePers = sexePers;
	this.cniPers = cniPers;
	this.dateCniPers = dateCniPers;
	this.dateNaissancePers = dateNaissancePers;
	this.adressePers= adresse;
	this.postePers = postePers;
	this.contactPers1 = contactPers1;
	this.contactPers2 = contactPers2;
	this.status=status;
}
    
  
	public Personnel(String nomPers, String prenomPers, Boolean sexePers, String cniPers, LocalDate dateCniPers,
			LocalDate dateNaissancePers, String adressePers, String postePers, String contactPers1, String contactPers2, String status) {
		super();
		this.nomPers = nomPers;
		this.prenomPers = prenomPers;
		this.sexePers = sexePers;
		this.cniPers = cniPers;
		this.dateCniPers = dateCniPers;
		this.dateNaissancePers = dateNaissancePers;
		this.adressePers = adressePers;
		this.postePers = postePers;
		this.contactPers1 = contactPers1;
		this.contactPers2 = contactPers2;
		this.status=status;
	}
	
	public Personnel() {
		super();
	}
	
	
	public User getMyUser() {
		return myUser;
	}


	public void setMyUser(User myUser) {
		this.myUser = myUser;
	}


	public long getIdPersonnel() {
		return idPersonnel;
	}
	public void setIdPersonnel(long idPersonnel) {
		this.idPersonnel = idPersonnel;
	}

	public String getNomPers() {
		return nomPers;
	}

	public void setNomPers(String nomPers) {
		this.nomPers = nomPers;
	}

	public String getPrenomPers() {
		return prenomPers;
	}

	public void setPrenomPers(String prenomPers) {
		this.prenomPers = prenomPers;
	}

	public Boolean getSexePers() {
		return sexePers;
	}

	public void setSexePers(Boolean sexePers) {
		this.sexePers = sexePers;
	}

	

	public boolean isValide() {
		return isValide;
	}


	public void setValide(boolean isValide) {
		this.isValide = isValide;
	}


	public String getCniPers() {
		return cniPers;
	}


	public void setCniPers(String cniPers) {
		this.cniPers = cniPers;
	}

	public LocalDate getDateCniPers() {
		return dateCniPers;
	}

	public void setDateCniPers(LocalDate dateCniPers) {
		this.dateCniPers = dateCniPers;
	}


	public LocalDate getDateNaissancePers() {
		return dateNaissancePers;
	}


	public void setDateNaissancePers(LocalDate dateNaissancePers) {
		this.dateNaissancePers = dateNaissancePers;
	}







	public String getAdressePers() {
		return adressePers;
	}







	public void setAdressePers(String adressePers) {
		this.adressePers = adressePers;
	}







	public String getPostePers() {
		return postePers;
	}







	public void setPostePers(String postePers) {
		this.postePers = postePers;
	}







	public String getContactPers1() {
		return contactPers1;
	}







	public void setContactPers1(String contactPers1) {
		this.contactPers1 = contactPers1;
	}







	public String getContactPers2() {
		return contactPers2;
	}







	public void setContactPers2(String contactPers2) {
		this.contactPers2 = contactPers2;
	}



	public String getStatus() {
		return status;
	}



	public void setStatus(String status) {
		this.status = status;
	}



	@Override
	public String toString() {
		return "Personnel [idPersonnel=" + idPersonnel + ", nomPers=" + nomPers + ", prenomPers=" + prenomPers
				+ ", sexePers=" + sexePers + ", cniPers=" + cniPers + ", dateCniPers=" + dateCniPers
				+ ", dateNaissancePers=" + dateNaissancePers + ", adressePers=" + adressePers + ", postePers="
				+ postePers + ", contactPers1=" + contactPers1 + ", contactPers2=" + contactPers2 + ", status=" + status
				+ "]";
	}



	





/*

	public Vector getMyAppLivraison() {
		return myAppLivraison;
	}

*/




/*
	public void setMyAppLivraison(Vector myAppLivraison) {
		this.myAppLivraison = myAppLivraison;
	}

*/

	/**
   * ok
   * @element-type Livraison
   */
 // public Vector  myAppLivraison;//ok

}