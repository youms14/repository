package youmssoft.repository.entities;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import youmssoft.repository.entities.livraison.Personnel;

@Entity
@Table(name="users")
public class User implements Serializable{
	@Id
	@Column(name = "username", length = 30, nullable=false)
	private String username;
	
	@Column(name = "password", nullable=false)
	private String password;
	
	private boolean actived=true;//Par defaut, on met à true.
	
	@OneToOne(fetch = FetchType.EAGER) //cascade=CascadeType.PERSIST: on save les deux entités à la fois
	@JoinColumn(name = "myPersonnel", referencedColumnName="idPersonnel", nullable = true)// A mettre false
	private Personnel myPersonnel;
	
	@ManyToMany
	@JoinTable (name="USERS_ROLES")//Pour dire que c'est une table provant de la jointure de deux autres tables.
	private List<Role> roles;
	/*
	Mettre des lignes de code pareils céereront la table naissante automatiquement.
	 */
	
	
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
	public List<Role> getRoles() {
		return roles;
	}
	public void setRoles(List<Role> roles) {
		this.roles = roles;
	}
	
	
	
	public boolean isActived() {
		return actived;
	}
	public void setActived(boolean actived) {
		this.actived = actived;
	}
	public Personnel getMyPersonnel() {
		return myPersonnel;
	}
	public void setMyPersonnel(Personnel myPersonnel) {
		this.myPersonnel = myPersonnel;
	}
	public User(String username, String password) {
		super();
		this.username = username;
		this.password = password;
	}


	public User(String username, String password, boolean actived, Personnel myPersonnel, List<Role> roles) {
		this.username = username;
		this.password = password;
		this.actived = actived;
		this.myPersonnel = myPersonnel;
		this.roles = roles;
	}

	public User(String username, String password, boolean actived, Personnel myPersonnel) {
		super();
		this.username = username;
		this.password = password;
		this.actived = actived;
		this.myPersonnel = myPersonnel;
	}
	public User() {
		super();
	}
		
	
	
	
	
}
