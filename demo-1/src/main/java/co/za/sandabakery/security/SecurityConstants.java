package co.za.sandabakery.security;

import co.za.sandabakery.SpringApplicationContext;

public class SecurityConstants {

	public static final long EXPIRATION_TIME=864000000;//10 days milli seconds
	public static final String TOKEN_PREFIX="Bearer ";
	public static final String HEADER_STRING="Authorization";
	public static final String SIGN_UP_URL="/customers/signup";
	public static final String SIGN_IN_URL="/customers/login";
	
	
	public static String getTokenSecret() {
		AppProperties appProp=(AppProperties)SpringApplicationContext.getBean("appProperties");
		return appProp.getTokenSecret();
		
	}
	
	
	
}
