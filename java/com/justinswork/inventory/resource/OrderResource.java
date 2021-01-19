package com.justinswork.inventory.resource;

import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.justinswork.inventory.model.Order;
import com.justinswork.inventory.service.OrderService;

@RestController
@RequestMapping("/orders")
public class OrderResource {
	
	private OrderService orderService;
	private Order order;
	
	
	public OrderResource(OrderService orderService, Order order) {
		super();
		this.orderService = orderService;
		this.order = order;
	}

	//WHY IS THIS GET??? WHy RETURN ORDER??
	@GetMapping(value = "/createOrder")
	public Order createOrder() {
		order = orderService.createOrder();
		return order;
	}
	
	
	@GetMapping(value = "/view/recentOrder/id={orderId}")
	public Order viewOrderById(@PathVariable("orderId") Long orderId) {
		order = orderService.viewOrderById(orderId);
		return order;
	}
		
	@GetMapping(value = "/view/recentOrders/username={username}")
	public List<Order> viewOrdersByUsername(@PathVariable("username") String username) {
		return orderService.viewOrderByUsername(username);
	}
	
	@DeleteMapping(value= "/cancelOrder")
	public void cancelOrder(Long orderId) {
		orderService.cancelOrder(orderId);
	}
}
