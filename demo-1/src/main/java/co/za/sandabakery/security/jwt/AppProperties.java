package co.za.sandabakery.security.jwt;


import org.springframework.stereotype.Component;

@Component
public class AppProperties {
	
	
	public static final String SECRET = "$a!d@@1234#";
    public static final  long EXPIRATION_TIME = 120000; // 10 days
    public static final   String TOKEN_PREFIX = "Bearer ";
    public static final String HEADER_STRING = "Authorization";
	
}
