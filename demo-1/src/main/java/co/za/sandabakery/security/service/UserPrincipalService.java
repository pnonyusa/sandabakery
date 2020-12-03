package co.za.sandabakery.security.service;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import co.za.sandabakery.io.entity.CustomerEntity;
import co.za.sandabakery.respositories.CustomerRepository;
import org.springframework.transaction.annotation.Transactional;


@Service 
public class UserPrincipalService implements UserDetailsService {

	@Autowired
	private CustomerRepository customerRepo;
	
	@Override
	@Transactional
	public UserDetails loadUserByUsername(String emailAddress) throws UsernameNotFoundException {
		// TODO Auto-generated method stub
		
		CustomerEntity user=customerRepo.findByEmailAddress(emailAddress);
				
				
		if (user == null)
			throw new UsernameNotFoundException(emailAddress + "not found,please create an account");

		return new UserPrinciple(user);
	}

}
