/**
 * 
 */
package co.za.sandabakery.service.implementation;


import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import co.za.sandabakery.exceptions.UserServiceException;
import co.za.sandabakery.io.entity.AddressEntity;
import co.za.sandabakery.io.entity.UserEntity;
import co.za.sandabakery.respositories.CustomerRepository;
import co.za.sandabakery.respositories.RoleRepository;
import co.za.sandabakery.security.service.UserPrinciple;
import co.za.sandabakery.service.UserService;
import co.za.sandabakery.shared.dto.utils.Utils;
import co.za.sandabakery.ui.model.requests.SignUpUser;
import co.za.sandabakery.ui.model.requests.UserLogIn;
import co.za.sandabakery.ui.model.responses.UserModelResp;
import co.za.sandabakery.ui.model.responses.ErrorMessages;

import co.za.sandabakery.io.entity.Role;

/**
 * @author Phaphamani Nonyusa
 *
 */


@Service 
@Component
public class UserServiceImple implements UserService {
	
	
	@Autowired
	CustomerRepository custRepository;
	
	@Autowired
	private RoleRepository userRole;
	
	
	@Autowired
	PasswordEncoder encoder;
	
	
	@Autowired
	AuthenticationManager authenticationManager;
	
	
	
	

	//register user on system
	@Override
	public UserModelResp createUser(SignUpUser systemUser) {
		
		
		ModelMapper modelMapper =new ModelMapper();
		UserEntity customer=new UserEntity();
		AddressEntity address=new AddressEntity();
		Set<Role> roles = new HashSet<>();
	
		
		if(systemUser==null)throw new NullPointerException(ErrorMessages.OBJECT_IS_NULL.getErrorMessages());
		
		
		systemUser.getAddress().setAddressId(new Utils().generateUserId(10));
		systemUser.setCustomerId(new Utils().generateUserId(12));
	
		
		switch(systemUser.getRole()) {
		
		
		case "admin":
			Role adminRole=userRole.findByRoleName("ROLE_ADMIN");
			
		if(adminRole==null)throw new UserServiceException(ErrorMessages.NO_RECORD_FOUND.getErrorMessages());
		adminRole.setRole_Id(new Utils().generateUserId(9));
		roles.add(adminRole);
	
		break;
		
		case "user":
			Role pmRole=userRole.findByRoleName("ROLE_USER");
			if(pmRole==null)throw new UserServiceException(ErrorMessages.NO_RECORD_FOUND.getErrorMessages());
			
			pmRole.setRole_Id(new Utils().generateUserId(9));
		    roles.add(pmRole);
		    break;
		}
		
		//customer object
		customer.setCellNumber(systemUser.getCellNumber());
		customer.setRoles(roles);
		customer.setFirstName(systemUser.getFirstName());
		customer.setEmailAddress(systemUser.getEmailAddress());
		customer.setLastName(systemUser.getLastName());
		//customer.setEncryptedPassword(encoder.encode(systemUser.getPassword()));
		customer.setCustomerId(systemUser.getCustomerId());
		customer.setPassword(encoder.encode(systemUser.getPassword()));
		
		//address object
		address.setAddressId(systemUser.getAddress().getAddressId());
		address.setCity(systemUser.getAddress().getCity());
		address.setCountry(systemUser.getAddress().getCountry());
		address.setPostalCode(systemUser.getAddress().getPostalCode());
		address.setType(systemUser.getAddress().getType());
		address.setStreetName(systemUser.getAddress().getStreetName());
		
		
		//sets 
        address.setCustomer(customer);
		customer.setAddress(address);
		
		
		
		
		
		return modelMapper.map(custRepository.save(customer), UserModelResp.class);
	}

	//updates the user based on  id
	@Override
	public UserModelResp updateUser(String customerId,SignUpUser customer) {
		
		UserEntity user=custRepository.findByCustomerId(customerId);
		
		ModelMapper modelMapper =new ModelMapper();
		
		if(user ==null)throw new UserServiceException(ErrorMessages.NO_RECORD_FOUND.getErrorMessages());
		
		user.setCellNumber(customer.getCellNumber());
		user.setFirstName(customer.getFirstName());
		user.setLastName(customer.getLastName());
		user.setPassword(encoder.encode(user.getPassword()));
		//user.setEncryptedPassword(encoder.encode(user.getPassword()));
		user.getAddress().setCity(customer.getAddress().getCity());
		user.getAddress().setPostalCode(customer.getAddress().getPostalCode());
		user.getAddress().setStreetName(customer.getAddress().getStreetName());
		user.getAddress().setType(customer.getAddress().getType());
		
		
		
		return modelMapper.map(custRepository.save(user), UserModelResp.class);
	}

	
	
	//delete user based on id
	
	@Override
	public String deleteUser(String customerId) {
		
		UserEntity customerToDelete=custRepository.findByCustomerId(customerId);
		
		if(customerToDelete==null)
			throw new UserServiceException(ErrorMessages.NO_RECORD_FOUND.getErrorMessages());
		
		
		custRepository.delete(customerToDelete);
		
		return "customer deleted successfully" ;
		
		// TODO Auto-generated method stub

	}

	
	//retrives all users
	@Override
	public List<UserEntity> getUsers() {
		
		
		
		List<UserEntity>customerEntity=(List<UserEntity>) custRepository.findAll();
		
		
		
		// TODO Auto-generated method stub
		return customerEntity;
	}

	//retrieves single user based on given id
	@Override
	public UserEntity getUser(String customerId) {
		
		 UserEntity customer=custRepository.findByCustomerId(customerId);
		 
		 if(customer==null)throw new UserServiceException(ErrorMessages.NO_RECORD_FOUND.getErrorMessages());
		
		// TODO Auto-generated method stub
		return customer;
	}



	//retreives user by email
	@Override
	public UserEntity getUserByEmail(String emailAddress) {
		// TODO Auto-generated method stub
		UserEntity customer =custRepository.findByEmailAddress(emailAddress);
		
		if(customer==null)throw new UserServiceException(ErrorMessages.NO_RECORD_FOUND.getErrorMessages());
		
		return customer;
	}

	//it validate if the user logging in does exist on sql server
	@Override
	public boolean isLoggedIn(UserLogIn loginDetails) {
		// TODO Auto-generated method stub
		 UserEntity customer=getUserByEmail(loginDetails.getEmailAddress());	
		
		  if(customer!=null) {
			  encoder.matches(loginDetails.getPassword(), customer.getPassword());
			  
			  return true;
			
		  }
		
		
		return false;
	}

	
	//finish this tommorrow
	@Override
	public List<String> getRoles(UserLogIn loginDetails) {
		Authentication authentication = authenticationManager.authenticate(
				new UsernamePasswordAuthenticationToken(loginDetails.getEmailAddress(), loginDetails.getPassword()));
		
		SecurityContextHolder.getContext().setAuthentication(authentication);
		
		UserPrinciple userDetails=(UserPrinciple) authentication.getPrincipal();
		
		List<String> roles = userDetails.getAuthorities().stream()
				.map(item -> item.getAuthority())
				.collect(Collectors.toList());
		
		return roles;
	}

}
