package co.za.sandabakery.service;

import java.util.List;

import co.za.sandabakery.io.entity.Order;

import co.za.sandabakery.ui.model.responses.OrderModelRespo;

public interface OrderService {
	
	  String createOrder(Order order);
	  OrderModelRespo updateOrder(String orderId,Order order);
	  String deleteOrder(String orderId);
	  List<OrderModelRespo> getOrders(int page,int limit);
	  OrderModelRespo getOrder(String productName);
}
