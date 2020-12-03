package co.za.sandabakery.service;

import java.util.List;

import co.za.sandabakery.io.entity.CustomerEntity;
import co.za.sandabakery.ui.model.requests.SignUpUser;
import co.za.sandabakery.ui.model.requests.UserLogIn;
import co.za.sandabakery.ui.model.responses.CustomerModelResp;



public interface CustomerService  {
	
	CustomerModelResp createCustomer(SignUpUser user);
	boolean isLoggedIn(UserLogIn loginDetails);
	CustomerModelResp updateCustomer(String customerId,SignUpUser user);
	String deleteCustomer(String customerId);
	List<CustomerEntity> getCustomers(int page,int limit);
	CustomerEntity getCustomer(String customerId);
	CustomerEntity getCustomerByEmail(String emailAddress);

}
