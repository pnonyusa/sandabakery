package co.za.sandabakery.service;

import java.util.List;

import co.za.sandabakery.io.entity.CustomerEntity;
import co.za.sandabakery.ui.model.responses.CustomerModelResp;

public interface CustomerService {
	
	CustomerModelResp createCustomer(CustomerEntity user);
	CustomerModelResp updateCustomer(String customerId,CustomerEntity user);
	String deleteCustomer(String customerId);
	List<CustomerEntity> getCustomers(int page,int limit);

}
