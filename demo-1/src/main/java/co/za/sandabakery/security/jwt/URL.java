package co.za.sandabakery.security.jwt;

public class URL {
	
    public static final String SIGN_UP_URL = "/users/signup";
    public static final String SIGN_IN_URL="/users/login";
    public static final String ADMIN="/users/admin/**";
    public static final String ADMIN_PRODUCT="/product/admin/**";
    public static final String USER="/users/user/**";
    public static final String ALL="/product/{productId}";
    public static final String ALL_ADMIN_USER="/product";

}
