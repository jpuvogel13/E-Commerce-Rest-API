package com.justinswork.customercart.models;

import java.math.BigDecimal;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "Customer_Cart")
public class CartProducts {
	
	@Id
	private Long productId;
	private String productName;
	private int quantity;
	private BigDecimal price;
	private BigDecimal totalPrice;

	
	public CartProducts() {
		
	}

	public CartProducts(Long productId, String productName, int quantity, BigDecimal price) {
		this.productId = productId;
		this.productName = productName;
		this.quantity = quantity;
		this.price = price;
		this.totalPrice = new BigDecimal("0.00");
	}

	public Long getProductId() {
		return productId;
	}

	public void setProductId(Long productId) {
		this.productId = productId;
	}

	public String getProductName() {
		return productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}

	public int getQuantity() {
		return quantity;
	}

	public void increaseQuantity(int amount) {
		quantity += amount;
	}
	
	public void decreaseQuantity(int amount) {
		quantity -= amount;
	}
	
	public void setQuantity(int amount) {
		quantity = amount;
	}

	public BigDecimal getPrice() {
		return price;
	}

	public void setPrice(BigDecimal productPrice) {
		this.price = productPrice;
	}
	
	public void setTotalPrice() {
		this.totalPrice = new BigDecimal(quantity).multiply(price);
	}
	
	public BigDecimal getTotalPrice() {
		return this.totalPrice;
	}
	
	
	
}
