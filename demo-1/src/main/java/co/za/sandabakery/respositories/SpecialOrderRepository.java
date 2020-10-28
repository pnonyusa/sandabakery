package co.za.sandabakery.respositories;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import co.za.sandabakery.io.entity.SpecialOrderDetails;



@Repository
public interface SpecialOrderRepository extends PagingAndSortingRepository<SpecialOrderDetails, Long> {
	SpecialOrderDetails findBySpecialOrderId(String specialOrderId);
}
