package co.za.sandabakery.ui.controllers;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import co.za.sandabakery.io.entity.CustomerEntity;
import co.za.sandabakery.service.CustomerService;
import co.za.sandabakery.ui.model.responses.CustomerModelResp;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

@RestController
@RequestMapping("customers")
public class CustomerController {
	
	
	@Autowired
	CustomerService customerService;
	
	

	@PostMapping(path = "/signup", consumes ="application/json", produces = "application/json")
	
	public ResponseEntity<CustomerModelResp> registerCustomer(@RequestBody CustomerEntity customer ) throws Exception{
		
		return new ResponseEntity<>(customerService.createCustomer(customer),HttpStatus.OK) ;
	}
	
	
	@PutMapping(path = "/update/{id}",consumes ="application/json", produces = "application/json")
	public ResponseEntity<CustomerModelResp>  updateCustomer(@PathVariable String id,@RequestBody CustomerEntity customer ) {
		
		return new ResponseEntity<CustomerModelResp>(customerService.updateCustomer(id, customer),HttpStatus.OK);
	}
	
	
	
	@DeleteMapping(path="/delete/{id}",consumes ="application/json", produces = "application/json")
	public String deleteCustomer(@PathVariable String id) {
		
		return customerService.deleteCustomer(id);	
	}
	
	
	
	@GetMapping(consumes ="application/json", produces = "application/json")
	public List<CustomerEntity> getCustomers(@RequestParam(value="page",defaultValue="0") int page, @RequestParam(value="limit",defaultValue="15") int limit){
		
		return customerService.getCustomers(page, limit) ;
		
	}
	
	

}
