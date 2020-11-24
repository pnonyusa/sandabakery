package co.za.sandabakery.security.jwt;


import org.springframework.stereotype.Component;

@Component
public class AppProperties {
	
	
	private final String SECRET = "SecretKeyToGenJWTs";
    private final  long EXPIRATION_TIME = 864_000_000; // 10 days
    private final   String TOKEN_PREFIX = "Bearer ";
    private final String HEADER_STRING = "Authorization";
	
	
    public String getSECRET() {
		return SECRET;
	}
	
	public long getEXPIRATION_TIME() {
		return EXPIRATION_TIME;
	}
	
	public String getTOKEN_PREFIX() {
		return TOKEN_PREFIX;
	}
	
	public String getHEADER_STRING() {
		return HEADER_STRING;
	}
	
	

}
