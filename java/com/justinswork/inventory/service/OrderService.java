package com.justinswork.inventory.service;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import com.justinswork.inventory.model.Order;
import com.justinswork.inventory.model.Product;
import com.justinswork.inventory.model.OrderProducts;
import com.justinswork.inventory.repository.OrderProductsRepository;
import com.justinswork.inventory.repository.OrdersRepository;

@Service
public class OrderService {
	
	private RestTemplate restTemplate;
	@Value("${cart-product-list}")
	private String cartProductListURL;
	private Order order;
	private OrdersRepository orderRepo;
	private OrderProductsRepository orderProductsRepository;
	

	public OrderService(RestTemplate restTemplate, Order order, OrdersRepository orderRepo, OrderProductsRepository orderProductListRepository) {
		super();
		this.restTemplate = restTemplate;
		this.order = order;
		this.orderRepo = orderRepo;
		this.orderProductsRepository = orderProductListRepository;
		
	}
	//CHANGED THE PRODUCT LIST FROM LIST<PRODUCT> To PRODUCT LIST OBJECT, TRYING TO SAVE THE PRODUCT LIST OF EVERY ORDER IN every 
	//order made. TRYING TO USE MANY TO ONE AND ONE TO MANY BU  NOT WORKING
	public Order createOrder() {		 
		 Product[] productList = restTemplate.getForObject(cartProductListURL, Product[].class);
		 
		 order.setOrderId(null);
		 Product product = new Product();
		 order.setDateCreated(formateDate());
		//*** MANUALLY PUTTING IN USERNAME
		 order.setUsername("Jpuvogel13");
		 
		 orderRepo.save(order);
		 for(int i = 0; i< productList.length; i++) {
			 	
			 OrderProducts orderProduct = new OrderProducts();
			 orderProduct.setOrder(order);
			 product = productList[i];	 	
			 orderProduct.setProductId(product.getProductId());
			 orderProduct.setProductName(product.getProductName());
			 orderProduct.setProductPrice(product.getPrice());
			 orderProduct.setQuantity(product.getQuantity());
			 orderProductsRepository.save(orderProduct);
		 }	
		return order;
	}
	
	// have a timer, if two days after order time refuse and say products have been shipped.
	public void cancelOrder(Long orderId) {
		orderRepo.deleteById(orderId);
	}
	
	//WORKs
	public Order viewOrderById(Long orderId) {
		order = orderRepo.findByOrderId(orderId);
		order.setOrderProductList(orderProductsRepository.findByOrder(order));
		return order;	
	}
	
	//works
	public List<Order> viewOrderByUsername(String username) {
		List<Order> orderProductsList = orderRepo.findByUsername(username);
		return orderProductsList;
	}
	
	private String formateDate() {
		LocalDateTime time = LocalDateTime.now();
		DateTimeFormatter format = DateTimeFormatter.ofPattern("MM-dd-yyyy HH:mm:ss");
		return time.format(format);
	}

}
