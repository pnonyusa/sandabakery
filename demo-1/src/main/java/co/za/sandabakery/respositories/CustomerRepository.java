package co.za.sandabakery.respositories;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import co.za.sandabakery.io.entity.CustomerEntity;

@Repository
public interface CustomerRepository extends PagingAndSortingRepository<CustomerEntity, Long> {
	CustomerEntity findByEmailAddress(String emailAddress);
	CustomerEntity findByCustomerId(String customerId);
}
