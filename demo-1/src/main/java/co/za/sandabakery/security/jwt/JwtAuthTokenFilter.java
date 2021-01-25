package co.za.sandabakery.security.jwt;



import co.za.sandabakery.security.service.UserPrincipalService;
import co.za.sandabakery.security.service.UserPrinciple;
import lombok.extern.java.Log;

import java.io.IOException;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;

import org.springframework.stereotype.Component;
import org.springframework.web.filter.GenericFilterBean;
import static org.springframework.util.StringUtils.hasText;

@Component
@Log
public class JwtAuthTokenFilter extends GenericFilterBean {
	
	
	  public static final String AUTHORIZATION="Authorization";
	
	  @Autowired
	  private JwtProvider jwtProvider;
	 
	  @Autowired
	  private UserPrincipalService userDetailsService;
	 
	

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		    logger.info("do filter...");
		    
		    String token=getTokenFromRequest((HttpServletRequest)request);
		    
		    if(token!=null && jwtProvider.validateToken(token)) {
		    	String userLogin=jwtProvider.getLoginFromToken(token);
		    	
		    	UserPrinciple userDetails=(UserPrinciple) userDetailsService.loadUserByUsername(userLogin);
		    	
		    	UsernamePasswordAuthenticationToken auth =new UsernamePasswordAuthenticationToken(userDetails,null,userDetails.getAuthorities());
		    	
		    	 SecurityContextHolder.getContext().setAuthentication(auth);
		    	
		    }
		
		    chain.doFilter(request,response);
		
	}
	
	
	private String getTokenFromRequest(HttpServletRequest request) {
		
		String bearer=request.getHeader(AUTHORIZATION);
		
		if(hasText(bearer) && bearer.startsWith("Bearer ")) {
		         return bearer.substring(7);
		}
	 
	    return null;

	}
	
	
	
	
	
	
}

