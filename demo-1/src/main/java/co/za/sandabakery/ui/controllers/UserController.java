package co.za.sandabakery.ui.controllers;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.security.PermitAll;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import co.za.sandabakery.io.entity.ProductEntity;
import co.za.sandabakery.io.entity.UserEntity;
import co.za.sandabakery.security.jwt.JwtProvider;
import co.za.sandabakery.security.jwt.response.JwtResponse;
import co.za.sandabakery.service.UserService;
import co.za.sandabakery.ui.model.requests.SignUpUser;
import co.za.sandabakery.ui.model.requests.UserLogIn;
import co.za.sandabakery.ui.model.responses.ProductModelRespo;
import co.za.sandabakery.ui.model.responses.UserModelResp;

import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;


@RestController
@RequestMapping("users")
public class UserController {
	
	
	@Autowired
	UserService customerService;
	
	@Autowired 
	JwtProvider jwtProvider;
	
	

	
	@PermitAll
	@PostMapping(path = "/signup",consumes = { MediaType.ALL_VALUE }, produces = { MediaType.ALL_VALUE })
	
	public ResponseEntity<UserModelResp> registerCustomer(@RequestBody SignUpUser customer ) throws Exception{
		
		return new ResponseEntity<>(customerService.createUser(customer),HttpStatus.OK) ;
	}
	
	
	@PutMapping(path = "/admin/update/{id}",consumes = { MediaType.ALL_VALUE }, produces = { MediaType.ALL_VALUE })
	public ResponseEntity<UserModelResp>  updateCustomer(@PathVariable String id,@RequestBody SignUpUser customer ) {
		
		return new ResponseEntity<UserModelResp>(customerService.updateUser(id, customer),HttpStatus.OK);
	}
	
	@PermitAll
	@PostMapping(path="/login",consumes = { MediaType.ALL_VALUE }, produces = { MediaType.ALL_VALUE })
	public JwtResponse isLoggedIn( @RequestBody UserLogIn loginCredetials){
		
		JwtResponse myToken=new JwtResponse();
		if(customerService.isLoggedIn(loginCredetials)) {
			
			myToken.setRoles(customerService.getRoles(loginCredetials));
			String token=jwtProvider.generateToken(loginCredetials.getEmailAddress());
			myToken.setAccessToken(token);
			return myToken;
			
		}
		
		myToken.setAccessToken("Unable to authenticate the user "+loginCredetials.getEmailAddress()+" "+"and unable to generate token");
		return myToken;
	}
	
	@DeleteMapping(path="/admin/delete/{id}",consumes = { MediaType.ALL_VALUE }, produces = { MediaType.ALL_VALUE })
	@ResponseBody
	public String deleteCustomer(@PathVariable String id) {
		
		return customerService.deleteUser(id);	
	}
	
	
	
	@GetMapping(path="/admin/all",consumes = { MediaType.ALL_VALUE }, produces = { MediaType.ALL_VALUE })
	public List<UserModelResp> getCustomers(){
		
		   ModelMapper modelMapper =new ModelMapper();
		    
		    List<UserModelResp> responseModel=new ArrayList<>();
		    
		    List<UserEntity> users=customerService.getUsers();
		    
		    
		    for(int i=0;i<users.size();i++) {
		    	responseModel.add(i, modelMapper.map(users.get(i), UserModelResp.class));
		    }
		    
		
		return responseModel;
		
	}
	
	
	@GetMapping(path="/admin/{customerId}",consumes = { MediaType.ALL_VALUE }, produces = { MediaType.ALL_VALUE })
	@ResponseBody
	public ResponseEntity<UserEntity> getCustomer(@PathVariable String customerId){
		
		return new ResponseEntity<UserEntity>(customerService.getUser(customerId),HttpStatus.OK) ;
		
	}
	
	
	@GetMapping(path="/admin/test")
	@ResponseBody
	public String test() {
		
		return "Hello admin";
	}
	
	
	
	@GetMapping(path="/user/test")
	@ResponseBody
	public String testCustomerAuthorization() {
		
		return "Hello user";
	}
	
	

}
