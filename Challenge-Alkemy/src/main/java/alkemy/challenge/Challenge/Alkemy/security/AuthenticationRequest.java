package alkemy.challenge.Challenge.Alkemy.security;

public class AuthenticationRequest {
	
	private String name;
	private String password;

	public AuthenticationRequest(String name, String password) {
		this.name = name;
		this.password = password;
		
	}
	
	public AuthenticationRequest() {
	}

	public String getUsername() {
		return name;
	}

	public void setUsername(String name) {
		this.name = name;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

}
