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

import youmssoft.repository.entities.livraison.Personnel;


@Entity
@Table(name="Chargement")
public class Chargement implements Serializable{//ok

	@Id @GeneratedValue
	@Column(name = "idChargement", nullable = false, unique=true)
	private long idChargement;

	@Column(name = "dateChargement", nullable = false)
	private LocalDate dateChargement;

	@Column(name = "heureChargement", nullable = false)
	private LocalTime heureChargement;

	@ManyToOne(fetch = FetchType.EAGER)//cascade = CascadeType.ALL
  	@JoinColumn(name = "livreurChar", referencedColumnName="idPersonnel", nullable = true)
	private Personnel livreurChar;

	@ManyToOne(fetch = FetchType.EAGER)//cascade = CascadeType.ALL
  	@JoinColumn(name = "magasinierChar", referencedColumnName="idPersonnel", nullable = true)
	private Personnel magasinierChar;
	
	@ManyToOne(fetch = FetchType.EAGER)//cascade = CascadeType.ALL
  	@JoinColumn(name = "secretaireChar", referencedColumnName="idPersonnel", nullable = true)
	private Personnel secretaireChar;

	@Column(name = "secteurChar", nullable = true, length=30)
	private String secteurChar;

	@Column(name = "soldeChar", nullable = false)
	private float soldeChar;

	@Column(name = "nbEmbChar", nullable = false)
	private float nbEmbChar;

	@Column(name = "nbColisChar", nullable = false)
	private float nbColisChar;
	
	@Column(name = "isLivred", nullable = true)//A mettre à false plus tard.
	private boolean isLivred;
	
	@Column(name = "isSolded", nullable = true)//A mettre à false plus tard.
	private boolean isSolded;
	
	@Column(name = "isEmbOK", nullable = true)//A mettre à false plus tard.
	private boolean isEmbOK;
	
	@Column(name = "isValide", nullable = true) 
	 private boolean isValide=true;
	
	

	@ManyToOne(fetch = FetchType.EAGER)//cascade = CascadeType.ALL
  	@JoinColumn(name = "myPersonnel", referencedColumnName="idPersonnel", nullable = true)
    public Personnel myPersonnel;
   
	@OneToOne(fetch = FetchType.EAGER)//cascade = CascadeType.ALL
  	@JoinColumn(name = "myRetourChargment", referencedColumnName="idRetour", nullable = true)
    public RetourChargement myRetourChargment;

	/**
	 * @param idChargement
	 * @param dateChargement
	 * @param heureChargement
	 * @param livreurChar
	 * @param magasinierChar
	 * @param secteurChar
	 * @param soldeChar
	 * @param nbEmbChar
	 * @param nbColisChar
	 * @param myPersonnel
	 * @param myRetourChargment
	 */
	public Chargement(long idChargement, LocalDate dateChargement, LocalTime heureChargement, Personnel livreurChar,
			Personnel magasinierChar, String secteurChar, float soldeChar, float nbEmbChar, float nbColisChar,
			Personnel myPersonnel, RetourChargement myRetourChargment, Personnel secretaireChar,boolean isLivred,boolean isSolded, boolean isEmbOK) {
		super();
		this.idChargement = idChargement;
		this.dateChargement = dateChargement;
		this.heureChargement = heureChargement;
		this.livreurChar = livreurChar;
		this.magasinierChar = magasinierChar;
		this.secteurChar = secteurChar;
		this.soldeChar = soldeChar;
		this.nbEmbChar = nbEmbChar;
		this.nbColisChar = nbColisChar;
		this.myPersonnel = myPersonnel;
		this.myRetourChargment = myRetourChargment;
		this.secretaireChar=secretaireChar;
		this. isLivred= isLivred;
		this. isSolded= isSolded;
		this.isEmbOK= isEmbOK;
	}

	/**
	 * 
	 */
	public Chargement() {
		super();
	}

	/**
	 * @param dateChargement
	 * @param heureChargement
	 * @param livreurChar
	 * @param magasinierChar
	 * @param secteurChar
	 * @param soldeChar
	 * @param nbEmbChar
	 * @param nbColisChar
	 * @param myPersonnel
	 * @param myRetourChargment
	 */
	public Chargement(LocalDate dateChargement, LocalTime heureChargement, Personnel livreurChar,
			Personnel magasinierChar, String secteurChar, float soldeChar, float nbEmbChar, float nbColisChar,
			Personnel myPersonnel, RetourChargement myRetourChargment, Personnel secretaireChar, boolean isLivred,boolean isSolded, boolean isEmbOK) {
		super();
		this.dateChargement = dateChargement;
		this.heureChargement = heureChargement;
		this.livreurChar = livreurChar;
		this.magasinierChar = magasinierChar;
		this.secteurChar = secteurChar;
		this.soldeChar = soldeChar;
		this.nbEmbChar = nbEmbChar;
		this.nbColisChar = nbColisChar;
		this.myPersonnel = myPersonnel;
		this.myRetourChargment = myRetourChargment;
		this.secretaireChar=secretaireChar;
		this. isLivred= isLivred;
		this. isSolded= isSolded;
		this.isEmbOK= isEmbOK;
	}
	
	
	
	

	public boolean isValide() {
		return isValide;
	}

	public void setValide(boolean isValide) {
		this.isValide = isValide;
	}

	public boolean isSolded() {
		return isSolded;
	}

	public void setSolded(boolean isSolded) {
		this.isSolded = isSolded;
	}

	public boolean isEmbOK() {
		return isEmbOK;
	}

	public void setEmbOK(boolean isEmbOK) {
		this.isEmbOK = isEmbOK;
	}

	public boolean isLivred() {
		return isLivred;
	}

	public void setLivred(boolean isLivred) {
		this.isLivred = isLivred;
	}

	public Personnel getSecretaireChar() {
		return secretaireChar;
	}

	public void setSecretaireChar(Personnel secretaireChar) {
		this.secretaireChar = secretaireChar;
	}

	public long getIdChargement() {
		return idChargement;
	}

	public void setIdChargement(long idChargement) {
		this.idChargement = idChargement;
	}

	public LocalDate getDateChargement() {
		return dateChargement;
	}

	public void setDateChargement(LocalDate dateChargement) {
		this.dateChargement = dateChargement;
	}

	public LocalTime getHeureChargement() {
		return heureChargement;
	}

	public void setHeureChargement(LocalTime heureChargement) {
		this.heureChargement = heureChargement;
	}

	public Personnel getLivreurChar() {
		return livreurChar;
	}

	public void setLivreurChar(Personnel livreurChar) {
		this.livreurChar = livreurChar;
	}

	public Personnel getMagasinierChar() {
		return magasinierChar;
	}

	public void setMagasinierChar(Personnel magasinierChar) {
		this.magasinierChar = magasinierChar;
	}

	public String getSecteurChar() {
		return secteurChar;
	}

	public void setSecteurChar(String secteurChar) {
		this.secteurChar = secteurChar;
	}

	public float getSoldeChar() {
		return soldeChar;
	}

	public void setSoldeChar(float soldeChar) {
		this.soldeChar = soldeChar;
	}

	public float getNbEmbChar() {
		return nbEmbChar;
	}

	public void setNbEmbChar(float nbEmbChar) {
		this.nbEmbChar = nbEmbChar;
	}

	public float getNbColisChar() {
		return nbColisChar;
	}

	public void setNbColisChar(float nbColisChar) {
		this.nbColisChar = nbColisChar;
	}

	public Personnel getMyPersonnel() {
		return myPersonnel;
	}

	public void setMyPersonnel(Personnel myPersonnel) {
		this.myPersonnel = myPersonnel;
	}

	public RetourChargement getMyRetourChargment() {
		return myRetourChargment;
	}

	public void setMyRetourChargment(RetourChargement myRetourChargment) {
		this.myRetourChargment = myRetourChargment;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Chargement [idChargement=");
		builder.append(idChargement);
		builder.append(", dateChargement=");
		builder.append(dateChargement);
		builder.append(", heureChargement=");
		builder.append(heureChargement);
		builder.append(", livreurChar=");
		builder.append(livreurChar);
		builder.append(", magasinierChar=");
		builder.append(magasinierChar);
		builder.append(", secretaireChar=");
		builder.append(secretaireChar);
		builder.append(", secteurChar=");
		builder.append(secteurChar);
		builder.append(", soldeChar=");
		builder.append(soldeChar);
		builder.append(", nbEmbChar=");
		builder.append(nbEmbChar);
		builder.append(", nbColisChar=");
		builder.append(nbColisChar);
		builder.append(", myPersonnel=");
		builder.append(myPersonnel);
		builder.append(", myRetourChargment=");
		builder.append(myRetourChargment);
		builder.append("]");
		return builder.toString();
	}

	
    
    

}