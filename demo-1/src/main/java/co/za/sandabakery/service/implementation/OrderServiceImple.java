package co.za.sandabakery.service.implementation;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import co.za.sandabakery.io.entity.Order;
import co.za.sandabakery.respositories.OrderRepository;
import co.za.sandabakery.service.OrderService;
import co.za.sandabakery.ui.model.responses.ErrorMessages;
import co.za.sandabakery.ui.model.responses.OrderModelRespo;

@Service
public class OrderServiceImple implements OrderService {

	@Autowired
	OrderRepository orderRepository;
	
	@Override
	public String createOrder(Order order) {
		// TODO Auto-generated method stub
		
		if(order==null)throw new NullPointerException(ErrorMessages.OBJECT_IS_NULL.getErrorMessages());
		
		orderRepository.save(order);
		
		return "order  successful";
	}

	@Override
	public OrderModelRespo updateOrder(String orderId, Order order) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String deleteOrder(String orderId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<OrderModelRespo> getOrders(int page, int limit) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public OrderModelRespo getOrder(String productName) {
		// TODO Auto-generated method stub
		return null;
	}

}
