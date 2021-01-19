package com.justinswork.customercart.models;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

@Configuration
public class CartBeanConfiguration {
	
	
	@Bean
	public CartProducts productBean() {
		return new CartProducts();
	}
	
	@Bean
	public CartCartDetails shoppingCartBean() {
		return new CartCartDetails();
	}
	
	@Bean
	public RestTemplate restTemplateBean(){
		return new RestTemplate();
	}
	
	


}
