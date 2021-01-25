package co.za.sandabakery.security.jwt;



import org.springframework.stereotype.Component;


import io.jsonwebtoken.Claims;

import io.jsonwebtoken.Jwts;

import io.jsonwebtoken.SignatureAlgorithm;


import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Date;




@Component
public class JwtProvider {


	 
	    
	  public String generateToken(String login) {
	        Date date = Date.from(LocalDate.now().plusDays(15).atStartOfDay(ZoneId.systemDefault()).toInstant());
	        return Jwts.builder()
	                .setSubject(login)
	                .setExpiration(date)
	                .signWith(SignatureAlgorithm.HS512, AppProperties.SECRET)
	                .compact();
	    }

	    public boolean validateToken(String token) {
	        try {
	            Jwts.parser().setSigningKey(AppProperties.SECRET).parseClaimsJws(token);
	            return true;
	        } catch (Exception e) {
	            System.out.println("invalid token");
	        }
	        return false;
	    }

	    public String getLoginFromToken(String token) {
	        Claims claims = Jwts.parser().setSigningKey(AppProperties.SECRET).parseClaimsJws(token).getBody();
	        return claims.getSubject();
	    }
	    
	    
	    
	   


}
