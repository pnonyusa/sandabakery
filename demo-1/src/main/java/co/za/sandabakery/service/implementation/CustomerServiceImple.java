/**
 * 
 */
package co.za.sandabakery.service.implementation;

import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import co.za.sandabakery.exceptions.UserServiceException;
import co.za.sandabakery.io.entity.AddressEntity;
import co.za.sandabakery.io.entity.CustomerEntity;
import co.za.sandabakery.respositories.CustomerRepository;
import co.za.sandabakery.service.CustomerService;
import co.za.sandabakery.shared.dto.utils.Utils;
import co.za.sandabakery.ui.model.responses.CustomerModelResp;
import co.za.sandabakery.ui.model.responses.ErrorMessages;


/**
 * @author Phaphamani Nonyusa
 *
 */


@Service 
public class CustomerServiceImple implements CustomerService {
	
	
	@Autowired
	CustomerRepository custRepository;
	

	@Override
	public CustomerModelResp createCustomer(CustomerEntity customer) {
		
		
		ModelMapper modelMapper =new ModelMapper();
		
		if(customer==null)throw new NullPointerException(ErrorMessages.OBJECT_IS_NULL.getErrorMessages());
		
		AddressEntity address=customer.getAddress();
		
		customer.setCustomerId(new Utils().generateUserId(12));
		
		address.setAddressId(new Utils().generateUserId(10));
		
		address.setCustomer(customer);
		
		customer.setAddress(address);
		
		return modelMapper.map(custRepository.save(customer), CustomerModelResp.class) ;
	}

	@Override
	public CustomerModelResp updateCustomer(String customerId,CustomerEntity customer) {
		
		CustomerEntity user=custRepository.findByCustomerId(customerId);
		
		ModelMapper modelMapper =new ModelMapper();
		
		if(user ==null)throw new UserServiceException(ErrorMessages.NO_RECORD_FOUND.getErrorMessages());
		
		user.setCellNumber(customer.getCellNumber());
		user.setFirstName(customer.getFirstName());
		user.setLastName(customer.getLastName());
		user.setPassword(customer.getPassword());
		user.getAddress().setCity(customer.getAddress().getCity());
		user.getAddress().setPostalCode(customer.getAddress().getPostalCode());
		user.getAddress().setStreetName(customer.getAddress().getStreetName());
		user.getAddress().setType(customer.getAddress().getType());
		
		
		
		return modelMapper.map(custRepository.save(user), CustomerModelResp.class);
	}

	
	
	@Override
	public String deleteCustomer(String customerId) {
		
		CustomerEntity customerToDelete=custRepository.findByCustomerId(customerId);
		
		if(customerToDelete==null)
			throw new UserServiceException(ErrorMessages.NO_RECORD_FOUND.getErrorMessages());
		
		
		custRepository.delete(customerToDelete);
		
		return "customer deleted successfully" ;
		
		// TODO Auto-generated method stub

	}

	@Override
	public List<CustomerEntity> getCustomers(int page, int limit) {
		
		Pageable pageReq=PageRequest.of(page, limit);
		
		Page<CustomerEntity>customerEntity=custRepository.findAll(pageReq);
		
		List<CustomerEntity> customers=customerEntity.getContent();
		
		// TODO Auto-generated method stub
		return customers;
	}

	@Override
	public CustomerEntity getCustomer(String customerId) {
		
		 CustomerEntity customer=custRepository.findByCustomerId(customerId);
		 
		 if(customer==null)throw new UserServiceException(ErrorMessages.NO_RECORD_FOUND.getErrorMessages());
		
		// TODO Auto-generated method stub
		return customer;
	}

}
