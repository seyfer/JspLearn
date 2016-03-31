package beans;

public class User {
	private String email = "";
	private String password = "";
	
	private String message = "";
	
	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public User() {
		super();
	}

	public User(String email, String password) {
		super();
		this.email = email;
		this.password = password;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
	
	public boolean validate() {
		
		if (email == null) {
			message = "email empty";
			return false;
		}
		
		if (password == null) {
			message = "password empty";
			return false;
		}
		
		if (!email.matches("\\w+\\@\\w+\\.\\w+")) {
			message = "wrong email format";
			return false;
		}
		
		if (password.length() < 8) {
			message = "should be 8 or more";
			return false;
		}
		
		return true;
		
	}

}
