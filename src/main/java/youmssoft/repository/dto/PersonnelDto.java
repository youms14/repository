package youmssoft.repository.dto;

import java.time.LocalDate;

public class PersonnelDto {
	private  String nom;
	private String prenom;
	private String addresse;
	private LocalDate dateNaissance;
	private String cni;
	private LocalDate dateCni;
	private String tel1;
	private String tel2;
	private boolean sexe;
	private String poste;
	
	private String username=null;
	private String password=null;
	
	
	
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getNom() {
		return nom;
	}
	public void setNom(String nom) {
		this.nom = nom;
	}
	public String getPrenom() {
		return prenom;
	}
	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}
	public String getAddresse() {
		return addresse;
	}
	public void setAddresse(String addresse) {
		this.addresse = addresse;
	}
	public LocalDate getDateNaissance() {
		return dateNaissance;
	}
	public void setDateNaissance(LocalDate dateNaissance) {
		this.dateNaissance = dateNaissance;
	}
	public String getCni() {
		return cni;
	}
	public void setCni(String cni) {
		this.cni = cni;
	}
	public LocalDate getDateCni() {
		return dateCni;
	}
	public void setDateCni(LocalDate dateCni) {
		this.dateCni = dateCni;
	}
	public String getTel1() {
		return tel1;
	}
	public void setTel1(String tel1) {
		this.tel1 = tel1;
	}
	public String getTel2() {
		return tel2;
	}
	public void setTel2(String tel2) {
		this.tel2 = tel2;
	}
	public boolean getSexe() {
		return sexe;
	}
	public void setSexe(boolean sexe) {
		this.sexe = sexe;
	}
	public String getPoste() {
		return poste;
	}
	public void setPoste(String poste) {
		this.poste = poste;
	}
	
	
	public PersonnelDto(String nom, String prenom, String addresse, LocalDate dateNaissance, String cni,
			LocalDate dateCni, String tel1, String tel2, boolean sexe, String poste) {
		super();
		this.nom = nom;
		this.prenom = prenom;
		this.addresse = addresse;
		this.dateNaissance = dateNaissance;
		this.cni = cni;
		this.dateCni = dateCni;
		this.tel1 = tel1;
		this.tel2 = tel2;
		this.sexe = sexe;
		this.poste = poste;
	}
	public PersonnelDto() {
		super();
	}
	
	

}
