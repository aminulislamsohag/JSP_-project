package model;

public class SingUpEntity {
	protected int id;
	protected String username;
	protected String password;
	protected String email;
	
	
	public SingUpEntity() {
	}
	
	public SingUpEntity(int id, String username, String password, String email) {
		this.id = id;
		this.username = username;
		this.password = password;
		this.email = email;
	}
	
	
	public SingUpEntity(String username, String password, String email) {
	
		this.username = username;
		this.password = password;
		this.email = email;
	}
	
	public SingUpEntity(String password, String email) {
		this.password = password;
		this.email = email;
	}
	
	public SingUpEntity( String email) {
		this.email = email;
	}

	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
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
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	
	
}

