package com.justinswork.inventory.repository;


import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.justinswork.inventory.model.Order;
import com.justinswork.inventory.model.OrderProducts;

@Repository
public interface OrderProductsRepository extends CrudRepository<OrderProducts, Long> {
	
	List<OrderProducts> findByOrder(Order id);
}
