package co.za.sandabakery.service;

import java.util.List;

import co.za.sandabakery.io.entity.CustomerEntity;
import co.za.sandabakery.ui.model.responses.CustomerModelResp;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.security.core.userdetails.UserDetailsService;


public interface CustomerService extends UserDetailsService {
	
	CustomerModelResp createCustomer(CustomerEntity user);
	CustomerModelResp updateCustomer(String customerId,CustomerEntity user);
	String deleteCustomer(String customerId);
	List<CustomerEntity> getCustomers(int page,int limit);
	CustomerEntity getCustomer(String customerId);
	CustomerEntity getCustomerByEmail(String emailAddress);

}
