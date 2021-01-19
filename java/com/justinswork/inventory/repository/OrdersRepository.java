package com.justinswork.inventory.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.justinswork.inventory.model.Order;

@Repository
public interface OrdersRepository extends CrudRepository<Order, Long>{
	
	Order findByOrderId(Long orderId);
	
	List<Order> findByUsername (String username);

	
}
