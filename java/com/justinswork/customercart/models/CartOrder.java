package com.justinswork.customercart.models;


import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;


public class CartOrder{
	
	
	private Long orderId;
	private String username;
	// private User user (Person who placed the order)
	//Company ID will be a foreign key to both products table as well as companies table. Getters will use the company/product get methods to return the value
	private String dateCreated;	
	
	public CartOrder(List<CartProducts> itemsInCart, String username) {
		super();
		this.username = username;		
	}
	
	

	public String getDateCreated() {
		return dateCreated;
	}


	public void setDateCreated(String dateCreated) {
		this.dateCreated = dateCreated;
	}

	public CartOrder(){
		
	}

	public Long getOrderId() {
		return orderId;
	}
	
	public String getUsername() {
		return username;
	}

	
	public void setOrderId(Long orderId) {
		this.orderId = orderId;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	

	
	
}