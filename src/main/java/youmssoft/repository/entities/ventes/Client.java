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
import javax.persistence.Table;

@Entity
@Table(name="Client")
public class Client implements Serializable{//ok

	@Id @GeneratedValue
	@Column(name = "idClient", nullable = false, unique=true)
	private long idClient;

	@Column(name = "nomClient", nullable = false, length=30)
	private String nomClient;

	@Column(name = "prenomClient", nullable = true, length=30)
	private String prenomClient;
	
	@Column(name = "telClient", nullable = true, length=30)
	private String telClient;
	
	
	@Column(name = "dateNaissanceClient", nullable = true)
	private LocalDate dateNaissanceClient;

  @Column(name = "sexeClient", nullable = true)
  private Boolean sexeClient;

  @Column(name = "numeroCniClient", nullable = true, length=10)
  private String numeroCniClient;

  @Column(name = "dateCniClient", nullable = true)
  private LocalDate dateCniClient;

  @Column(name = "dateEnregistrement", nullable = false)
  private LocalDate dateEnregistrement;

  @Column(name = "adresseClient", nullable = true, length=30)
  private String adresseClient;

  @Column(name = "secteur", nullable = true, length=30)
  private String secteur;

  @Column(name = "typeClient", nullable = false, length=30)//Regulier, Passant, etc...
  private String typeClient;

  @Column(name = "libelleArgent", nullable = false)
  private Boolean isHaveRist;

  @Column(name = "isValide", nullable = true) 
	 private boolean isValide=true;

/**
 * @param idClient
 * @param nomClient
 * @param prenomClient
 * @param dateNaissanceClient
 * @param sexeClient
 * @param numeroCniClient
 * @param dateCniClient
 * @param dateEnregistrement
 * @param adresseClient
 * @param secteur
 * @param typeClient
 * @param isHaveRist
 * @param myPrixProduits
 */
public Client(long idClient, String nomClient, String prenomClient, LocalDate dateNaissanceClient, Boolean sexeClient,
		String numeroCniClient, LocalDate dateCniClient, LocalDate dateEnregistrement, String adresseClient,
		String secteur, String typeClient, Boolean isHaveRist,String telClient) {
	super();
	this.idClient = idClient;
	this.nomClient = nomClient;
	this.prenomClient = prenomClient;
	this.dateNaissanceClient = dateNaissanceClient;
	this.sexeClient = sexeClient;
	this.numeroCniClient = numeroCniClient;
	this.dateCniClient = dateCniClient;
	this.dateEnregistrement = dateEnregistrement;
	this.adresseClient = adresseClient;
	this.secteur = secteur;
	this.typeClient = typeClient;
	this.isHaveRist = isHaveRist;
	//this.myPrixProduits = myPrixProduits;
	this. telClient= telClient;
}


/**
 * 
 */
public Client() {
	super();
}


/**
 * @param nomClient
 * @param prenomClient
 * @param dateNaissanceClient
 * @param sexeClient
 * @param numeroCniClient
 * @param dateCniClient
 * @param dateEnregistrement
 * @param adresseClient
 * @param secteur
 * @param typeClient
 * @param isHaveRist
 * @param myPrixProduits
 */
public Client(String nomClient, String prenomClient, LocalDate dateNaissanceClient, Boolean sexeClient,
		String numeroCniClient, LocalDate dateCniClient, LocalDate dateEnregistrement, String adresseClient,
		String secteur, String typeClient, Boolean isHaveRist,String telClient) {
	super();
	this.nomClient = nomClient;
	this.prenomClient = prenomClient;
	this.dateNaissanceClient = dateNaissanceClient;
	this.sexeClient = sexeClient;
	this.numeroCniClient = numeroCniClient;
	this.dateCniClient = dateCniClient;
	this.dateEnregistrement = dateEnregistrement;
	this.adresseClient = adresseClient;
	this.secteur = secteur;
	this.typeClient = typeClient;
	this.isHaveRist = isHaveRist;
	//this.myPrixProduits = myPrixProduits;
	this. telClient= telClient;
}



public String getTelClient() {
	return telClient;
}


public void setTelClient(String telClient) {
	this.telClient = telClient;
}




public boolean isValide() {
	return isValide;
}


public void setValide(boolean isValide) {
	this.isValide = isValide;
}


public long getIdClient() {
	return idClient;
}


public void setIdClient(long idClient) {
	this.idClient = idClient;
}


public String getNomClient() {
	return nomClient;
}


public void setNomClient(String nomClient) {
	this.nomClient = nomClient;
}


public String getPrenomClient() {
	return prenomClient;
}


public void setPrenomClient(String prenomClient) {
	this.prenomClient = prenomClient;
}


public LocalDate getDateNaissanceClient() {
	return dateNaissanceClient;
}


public void setDateNaissanceClient(LocalDate dateNaissanceClient) {
	this.dateNaissanceClient = dateNaissanceClient;
}


public Boolean getSexeClient() {
	return sexeClient;
}


public void setSexeClient(Boolean sexeClient) {
	this.sexeClient = sexeClient;
}


public String getNumeroCniClient() {
	return numeroCniClient;
}


public void setNumeroCniClient(String numeroCniClient) {
	this.numeroCniClient = numeroCniClient;
}


public LocalDate getDateCniClient() {
	return dateCniClient;
}


public void setDateCniClient(LocalDate dateCniClient) {
	this.dateCniClient = dateCniClient;
}


public LocalDate getDateEnregistrement() {
	return dateEnregistrement;
}


public void setDateEnregistrement(LocalDate dateEnregistrement) {
	this.dateEnregistrement = dateEnregistrement;
}


public String getAdresseClient() {
	return adresseClient;
}


public void setAdresseClient(String adresseClient) {
	this.adresseClient = adresseClient;
}


public String getSecteur() {
	return secteur;
}


public void setSecteur(String secteur) {
	this.secteur = secteur;
}


public String getTypeClient() {
	return typeClient;
}


public void setTypeClient(String typeClient) {
	this.typeClient = typeClient;
}


public Boolean getIsHaveRist() {
	return isHaveRist;
}


public void setIsHaveRist(Boolean isHaveRist) {
	this.isHaveRist = isHaveRist;
}




@Override
public String toString() {
	StringBuilder builder = new StringBuilder();
	builder.append("Client [idClient=");
	builder.append(idClient);
	builder.append(", nomClient=");
	builder.append(nomClient);
	builder.append(", prenomClient=");
	builder.append(prenomClient);
	builder.append(", dateNaissanceClient=");
	builder.append(dateNaissanceClient);
	builder.append(", sexeClient=");
	builder.append(sexeClient);
	builder.append(", numeroCniClient=");
	builder.append(numeroCniClient);
	builder.append(", dateCniClient=");
	builder.append(dateCniClient);
	builder.append(", dateEnregistrement=");
	builder.append(dateEnregistrement);
	builder.append(", adresseClient=");
	builder.append(adresseClient);
	builder.append(", secteur=");
	builder.append(secteur);
	builder.append(", typeClient=");
	builder.append(typeClient);
	builder.append(", isHaveRist=");
	builder.append(isHaveRist);
	builder.append("]");
	return builder.toString();
}





}