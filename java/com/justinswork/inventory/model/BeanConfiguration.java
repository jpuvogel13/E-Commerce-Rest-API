package com.justinswork.inventory.model;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;


@Configuration
public class BeanConfiguration {
	
	@Bean
	public Product productBean() {
		return new Product();
	}
	
	@Bean
	public Company companyBean() {
		return new Company();
	}
	
	@Bean
	public RestTemplate restTemplate() {
		return new RestTemplate();
	}
	
	@Bean 
	public Order order() {
		return new Order();
	}

	@Bean
	public OrderProducts orderProductList() {
		return new OrderProducts();
	}
	
	
}
