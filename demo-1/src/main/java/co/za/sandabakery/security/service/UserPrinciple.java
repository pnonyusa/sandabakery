package co.za.sandabakery.security.service;

import java.util.Collection;
import java.util.List;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import com.fasterxml.jackson.annotation.JsonIgnore;

import co.za.sandabakery.io.entity.CustomerEntity;
import java.util.Objects;
import java.util.stream.Collectors;
public class UserPrinciple implements UserDetails {

	  private static final long serialVersionUID = 1L;
	  
	  private Long id;
	 
	    private String firstName;
	 
	    private String lastName;
	 
	    private String emailAddress;
	 
	    @JsonIgnore
	    private String password;
	 
	    private Collection<? extends GrantedAuthority> authorities;
	 
	    public UserPrinciple(Long id, String firstName, 
	              String lastName, String emailAddress, String password, 
	              Collection<? extends GrantedAuthority> authorities) {
	        this.id = id;
	        this.firstName = firstName;
	        this.lastName = lastName;
	        this.emailAddress = emailAddress;
	        this.password = password;
	        this.authorities = authorities;
	    }
	 
	    public static UserPrinciple build(CustomerEntity user) {
	        List<SimpleGrantedAuthority> authorities = user.getRoles().stream().map(role ->
	                new SimpleGrantedAuthority(role.getRoleName())
	        ).collect(Collectors.toList());
	 
	        return new UserPrinciple(
	                user.getId(),
	                user.getFirstName(),
	                user.getLastName(),
	                user.getEmailAddress(),
	                user.getPassword(),
	                authorities
	        );
	    }
	 
	    public Long getId() {
	        return id;
	    }
	 
	    public String getLastName() {
	        return lastName;
	    }
	 
	    public String getFirstName() {
	        return firstName;
	    }
	 
	    @Override
	    public String getUsername() {
	        return emailAddress ;
	    }
	 
	    @Override
	    public String getPassword() {
	        return password;
	    }
	 
	    @Override
	    public Collection<? extends GrantedAuthority> getAuthorities() {
	        return authorities;
	    }
	 
	    @Override
	    public boolean isAccountNonExpired() {
	        return true;
	    }
	 
	    @Override
	    public boolean isAccountNonLocked() {
	        return true;
	    }
	 
	    @Override
	    public boolean isCredentialsNonExpired() {
	        return true;
	    }
	 
	    @Override
	    public boolean isEnabled() {
	        return true;
	    }
	 
	    @Override
	    public boolean equals(Object o) {
	        if (this == o) return true;
	        if (o == null || getClass() != o.getClass()) return false;
	        
	        UserPrinciple user = (UserPrinciple) o;
	        return Objects.equals(id, user.id);
	    }

}
