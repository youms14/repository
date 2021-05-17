package youmssoft.repository.dto;

public class UserDto {
	private String username;
	private String password;
	private long personnel;
	
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
	public long getPersonnel() {
		return personnel;
	}
	public void setPersonnel(long personnel) {
		this.personnel = personnel;
	}
	public UserDto(String username, String password, long personnel) {
		super();
		this.username = username;
		this.password = password;
		this.personnel = personnel;
	}
	public UserDto() {
		super();
	}
	
	
}
