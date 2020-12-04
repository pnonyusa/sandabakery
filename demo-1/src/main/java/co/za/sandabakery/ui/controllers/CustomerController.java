package co.za.sandabakery.ui.controllers;

import java.util.List;

import javax.annotation.security.PermitAll;

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


import co.za.sandabakery.io.entity.CustomerEntity;
import co.za.sandabakery.security.jwt.JwtProvider;
import co.za.sandabakery.security.jwt.response.JwtResponse;
import co.za.sandabakery.service.CustomerService;
import co.za.sandabakery.ui.model.requests.SignUpUser;
import co.za.sandabakery.ui.model.requests.UserLogIn;
import co.za.sandabakery.ui.model.responses.CustomerModelResp;

import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;


@RestController
@RequestMapping("users")
public class CustomerController {
	
	
	@Autowired
	CustomerService customerService;
	
	@Autowired 
	JwtProvider jwtProvider;
	
	

	
	@PermitAll
	@PostMapping(path = "/signup",consumes = { MediaType.ALL_VALUE }, produces = { MediaType.ALL_VALUE })
	
	public ResponseEntity<CustomerModelResp> registerCustomer(@RequestBody SignUpUser customer ) throws Exception{
		
		return new ResponseEntity<>(customerService.createCustomer(customer),HttpStatus.OK) ;
	}
	
	
	@PutMapping(path = "/user/update/{id}",consumes = { MediaType.ALL_VALUE }, produces = { MediaType.ALL_VALUE })
	public ResponseEntity<CustomerModelResp>  updateCustomer(@PathVariable String id,@RequestBody SignUpUser customer ) {
		
		return new ResponseEntity<CustomerModelResp>(customerService.updateCustomer(id, customer),HttpStatus.OK);
	}
	
	@PermitAll
	@PostMapping(path="/login",consumes = { MediaType.ALL_VALUE }, produces = { MediaType.ALL_VALUE })
	public JwtResponse isLoggedIn( @RequestBody UserLogIn loginCredetials){
		
		JwtResponse myToken=new JwtResponse();
		if(customerService.isLoggedIn(loginCredetials)) {
			
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
		
		return customerService.deleteCustomer(id);	
	}
	
	
	
	@GetMapping(path="/admin",consumes = { MediaType.ALL_VALUE }, produces = { MediaType.ALL_VALUE })
	public List<CustomerEntity> getCustomers(@RequestParam(value="page",defaultValue="0") int page, @RequestParam(value="limit",defaultValue="15") int limit){
		
		return customerService.getCustomers(page, limit) ;
		
	}
	
	
	@GetMapping(path="/admin/{customerId}",consumes = { MediaType.ALL_VALUE }, produces = { MediaType.ALL_VALUE })
	@ResponseBody
	public ResponseEntity<CustomerEntity> getCustomer(@PathVariable String customerId){
		
		return new ResponseEntity<CustomerEntity>(customerService.getCustomer(customerId),HttpStatus.OK) ;
		
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
