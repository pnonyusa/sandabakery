package co.za.sandabakery.ui.model.requests;

public class UserLogIn {

	private String password;
	private String emailAddress;
	
	
	
	
	
	public UserLogIn(String password, String emailAddress) {
		super();
		this.password = password;
		this.emailAddress = emailAddress;
	}
	
	
	
	public UserLogIn() {
		// TODO Auto-generated constructor stub
	}



	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getEmailAddress() {
		return emailAddress;
	}
	public void setEmailAddress(String emailAddress) {
		this.emailAddress = emailAddress;
	}
	
	
}
