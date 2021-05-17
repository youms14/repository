package youmssoft.repository.entities;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="role")
public class Role implements Serializable{
	@Id 
	@Column(name = "role", length = 30, nullable=false)
	private String role;
	
	@Column(name = "description", length = 100,  nullable=true)
	private String description;
	
	
	
	public String getRole() { 
		return role;
	}
	public void setRole(String role) {
		this.role = role;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public Role(String role, String description) {
		super();
		this.role = role;
		this.description = description;
	}
	public Role() {
		super();
	}
	
	
	
}
