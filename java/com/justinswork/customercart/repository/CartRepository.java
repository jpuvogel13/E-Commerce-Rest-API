package com.justinswork.customercart.repository;

import java.math.BigDecimal;
import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.justinswork.customercart.models.CartProducts;

@Repository
public interface CartRepository extends CrudRepository<CartProducts, Long>, CartRespositoryCustom{

	List<CartProducts> findAll();
	
	List<BigDecimal> findByTotalPrice(BigDecimal price);
	
	List<BigDecimal> findAllByTotalPrice();

	CartProducts findByProductId(Long productId);
	
 }
