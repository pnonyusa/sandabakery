package co.za.sandabakery.security.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;


import co.za.sandabakery.security.jwt.JwtAuthTokenFilter;
import co.za.sandabakery.security.jwt.URL;




@Configuration
@EnableWebSecurity
public class WebSecurity extends WebSecurityConfigurerAdapter {
	
	
	@Autowired
	JwtAuthTokenFilter jwtFilter;
	
	
	
	@Override
	protected void configure(HttpSecurity http)throws Exception{
		
		http
		
		.httpBasic().disable()
		.csrf().disable()
		.sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS)
		.and()
		.authorizeRequests()
		.antMatchers(URL.ADMIN,URL.ADMIN_PRODUCT,"users/admin/test").hasRole("ADMIN")
        .antMatchers(URL.USER,"users/user/test").hasRole("USER")
        .antMatchers(URL.ALL_ADMIN_USER).permitAll()
        .antMatchers(URL.SIGN_UP_URL, URL.SIGN_IN_URL).permitAll()
        .and()
        .addFilterBefore(jwtFilter, UsernamePasswordAuthenticationFilter.class);
	}
	
	
	   @Bean
	    public PasswordEncoder passwordEncoder() {
	        return new BCryptPasswordEncoder();
	    }
	   
		@Bean
		@Override
		public AuthenticationManager authenticationManagerBean() throws Exception {
			return super.authenticationManagerBean();
		}
	   
	

}
