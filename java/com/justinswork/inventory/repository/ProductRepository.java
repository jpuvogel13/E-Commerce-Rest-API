package com.justinswork.inventory.repository;

import java.math.BigDecimal;
import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.justinswork.inventory.model.Product;

@Repository
public interface ProductRepository extends CrudRepository<Product, Long> {
	
	
	
	Product findByProductId(Long id);
	
	//This returns a list in case there are 1 or more products sharing the same name
	List<Product> findByProductName(String name);

	List<Product> findAll();
	
	List<Product> findAllByOrderByPriceAsc(); 
	
	List<Product> findAllByOrderByPriceDesc();	
	
	List<Product> findAllByCompanyCompanyId(Long companyId);
	
	@Query(value = "SELECT * FROM Products WHERE Products.price < ?1  AND Products.price > ?2 ", nativeQuery = true)
	List<Product> findAllByPrices(@Param("highPrice") BigDecimal highPrice, @Param("lowPrice") BigDecimal lowPrice);
	
	
	//DOES NOT WORK
	@Query(value="SELECT * FROM Products WHERE Products.product_name LIKE '%?1%' ", nativeQuery=true)
	List<Product> findProductsByKeyword(@Param("keyword") String keyword);
	


}

