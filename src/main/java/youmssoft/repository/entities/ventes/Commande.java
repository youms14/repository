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
import javax.persistence.Table;

@Entity
@Table(name="Commande")
public class Commande implements Serializable{

	@Id @GeneratedValue
	@Column(name = "idCommande", nullable = false, unique=true)
	private long idCommande;

	@Column(name = "dateCommande", nullable = false)
	private LocalDate dateCommande;

	@Column(name = "status", nullable = true, length=20)//livrée, non-Livrée etc...
	private boolean status;

	@Column(name = "heureCommande", nullable = false)
	private LocalTime heureCommande;

	@Column(name = "nbEmbCom", nullable = false)
	private float nbEmbCom;

	@Column(name = "nbCasiers", nullable = false)
	private float nbCasiers;

   
	@ManyToOne(fetch = FetchType.EAGER)//cascade = CascadeType.ALL
	@JoinColumn(name = "myClient", referencedColumnName="idClient", nullable = false) 
    public Client myClient;

	
	@Column(name = "isValide", nullable = true) 
	 private boolean isValide=true;


	/**
	 * @param idCommande
	 * @param dateCommande
	 * @param status
	 * @param heureCommande
	 * @param nbEmbCom
	 * @param nbCasiers
	 * @param myClient
	 */
	public Commande(long idCommande, LocalDate dateCommande, boolean status, LocalTime heureCommande, float nbEmbCom,
			float nbCasiers, Client myClient) {
		super();
		this.idCommande = idCommande;
		this.dateCommande = dateCommande;
		this.status = status;
		this.heureCommande = heureCommande;
		this.nbEmbCom = nbEmbCom;
		this.nbCasiers = nbCasiers;
		this.myClient = myClient;
	}



	/**
	 * 
	 */



	/**
	 * @param dateCommande
	 * @param status
	 * @param heureCommande
	 * @param nbEmbCom
	 * @param nbCasiers
	 * @param myClient
	 */
	public Commande(LocalDate dateCommande, boolean status, LocalTime heureCommande, float nbEmbCom, float nbCasiers,
			Client myClient) {
		super();
		this.dateCommande = dateCommande;
		this.status = status;
		this.heureCommande = heureCommande;
		this.nbEmbCom = nbEmbCom;
		this.nbCasiers = nbCasiers;
		this.myClient = myClient;
	}



	/**
	 * 
	 */
	public Commande() {
		super();
	}


	

	public boolean isValide() {
		return isValide;
	}



	public void setValide(boolean isValide) {
		this.isValide = isValide;
	}



	public long getIdCommande() {
		return idCommande;
	}



	public void setIdCommande(long idCommande) {
		this.idCommande = idCommande;
	}



	public LocalDate getDateCommande() {
		return dateCommande;
	}



	public void setDateCommande(LocalDate dateCommande) {
		this.dateCommande = dateCommande;
	}



	public boolean getStatus() {
		return status;
	}



	public void setStatus(boolean status) {
		this.status = status;
	}



	public LocalTime getHeureCommande() {
		return heureCommande;
	}



	public void setHeureCommande(LocalTime heureCommande) {
		this.heureCommande = heureCommande;
	}



	public float getNbEmbCom() {
		return nbEmbCom;
	}



	public void setNbEmbCom(float nbEmbCom) {
		this.nbEmbCom = nbEmbCom;
	}



	public float getNbCasiers() {
		return nbCasiers;
	}



	public void setNbCasiers(float nbCasiers) {
		this.nbCasiers = nbCasiers;
	}



	public Client getMyClient() {
		return myClient;
	}



	public void setMyClient(Client myClient) {
		this.myClient = myClient;
	}



	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Commande [idCommande=");
		builder.append(idCommande);
		builder.append(", dateCommande=");
		builder.append(dateCommande);
		builder.append(", status=");
		builder.append(status);
		builder.append(", heureCommande=");
		builder.append(heureCommande);
		builder.append(", nbEmbCom=");
		builder.append(nbEmbCom);
		builder.append(", nbCasiers=");
		builder.append(nbCasiers);
		builder.append(", myClient=");
		builder.append(myClient);
		builder.append("]");
		return builder.toString();
	}
   
    
    

}