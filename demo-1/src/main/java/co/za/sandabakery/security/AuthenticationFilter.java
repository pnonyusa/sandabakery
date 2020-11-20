package co.za.sandabakery.security;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.security.core.userdetails.User;

import com.fasterxml.jackson.databind.ObjectMapper;

import co.za.sandabakery.SpringApplicationContext;
import co.za.sandabakery.io.entity.CustomerEntity;
import co.za.sandabakery.service.CustomerService;
import co.za.sandabakery.ui.model.requests.UserLogIn;

public class AuthenticationFilter extends UsernamePasswordAuthenticationFilter{  
	
	private final AuthenticationManager authenticationManager;
	
	public AuthenticationFilter(AuthenticationManager authenticationManager) {
		
		this.authenticationManager=authenticationManager;
	}
	
	
	
	@Override
	public Authentication attemptAuthentication(HttpServletRequest req,HttpServletResponse res) throws AuthenticationException{
		
		
		
		try {
			UserLogIn userCredentials=new ObjectMapper().
					readValue(req.getInputStream(),UserLogIn.class);
			
			return authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(userCredentials.getEmailAddress(),userCredentials.getPassword(),
					new ArrayList<>()));
			
		}catch(IOException e) {
			
			throw new  RuntimeException(e);
		}
		
	}
	
	
	
	@Override
	protected void successfulAuthentication(HttpServletRequest req,HttpServletResponse res,FilterChain chain,Authentication auth)throws ServletException,IOException {
		    String userName =((User)auth.getPrincipal()).getUsername();
		    
		    //generates token
		    String token =Jwts.builder()
		    		.setSubject(userName)
		    		.setExpiration(new Date(System.currentTimeMillis()+SecurityConstants.EXPIRATION_TIME))
		    		.signWith(SignatureAlgorithm.HS512, SecurityConstants.getTokenSecret())
		    		.compact();
		    
		    
		    CustomerService custService=(CustomerService)SpringApplicationContext.getBean("CustomerServiceImple");
		    
		    CustomerEntity custEntity=custService.getCustomerByEmail(userName);
		    //adds the token to header
		    res.addHeader(SecurityConstants.HEADER_STRING, SecurityConstants.TOKEN_PREFIX+token);
		    res.addHeader("CustomerId", custEntity.getCustomerId());
		    
	}
	
	
	
}
