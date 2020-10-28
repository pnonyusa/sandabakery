package co.za.sandabakery.respositories;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import co.za.sandabakery.io.entity.Order;

@Repository
public interface OrderRepository extends PagingAndSortingRepository<Order, Long> {
	         Order findByOrderId(String orderId);
}
