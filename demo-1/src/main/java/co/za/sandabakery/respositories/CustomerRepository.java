package co.za.sandabakery.respositories;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import co.za.sandabakery.io.entity.UserEntity;

@Repository
public interface CustomerRepository extends PagingAndSortingRepository<UserEntity, Long> {
	UserEntity findByEmailAddress(String emailAddress);
	UserEntity findByCustomerId(String customerId);
}
