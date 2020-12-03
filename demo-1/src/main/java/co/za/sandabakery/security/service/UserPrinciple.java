package co.za.sandabakery.security.service;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Set;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;



import co.za.sandabakery.io.entity.CustomerEntity;
import co.za.sandabakery.io.entity.Role;

public class UserPrinciple implements UserDetails {

	  private static final long serialVersionUID = 1L;
	  
	  
	private CustomerEntity customer;
	
	
	

	public UserPrinciple(CustomerEntity customer) {
		this.customer = customer;
	}

	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		// TODO Auto-generated method stub
		Set<Role> roles=customer.getRoles();
		
		List<SimpleGrantedAuthority> authorities=new ArrayList<SimpleGrantedAuthority>();
		
		for(Role role:roles) {
			authorities.add(new SimpleGrantedAuthority(role.getRoleName()));
		}
		
		return authorities ;
	} 

	@Override
	public String getPassword() {
		// TODO Auto-generated method stub
		return customer.getPassword();
	}

	@Override
	public String getUsername() {
		// TODO Auto-generated method stub
		return customer.getEmailAddress();
	}

	@Override
	public boolean isAccountNonExpired() {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public boolean isAccountNonLocked() {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public boolean isCredentialsNonExpired() {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public boolean isEnabled() {
		// TODO Auto-generated method stub
		return true;
	}
	  
	 

}
