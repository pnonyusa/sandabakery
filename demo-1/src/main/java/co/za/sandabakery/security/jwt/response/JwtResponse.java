package co.za.sandabakery.security.jwt.response;

import java.util.List;

public class JwtResponse {
	
	  private String token;
	  
	  private List<String>roles;
	  
	  
	  
	 public JwtResponse(String token,List<String>roles) {
		     this.roles=roles;
		     this.token=token;
	 }
	 
	 
     public JwtResponse() {
		 
	 }
	 
	  public String getAccessToken() {
	    return token;
	  }
	 
	  public void setAccessToken(String accessToken) {
	    this.token = accessToken;
	  }



	public List<String> getRoles() {
		return roles;
	}

	public void setRoles(List<String> roles) {
		this.roles = roles;
	}
	 
	  
	  
	  
	
}
