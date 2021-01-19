package com.justinswork.storefront.model;

import java.math.BigDecimal;

public class Product {

	private Long productId;
	private String productName;
	private int quantity;
	private BigDecimal price;
	private Long companyId;
	

	protected Product() {

	}

	public Product(Long productId, String productName, int quantity, BigDecimal price, Long companyId) {
		this.productId = productId;
		this.productName = productName;
		this.quantity = quantity;
		this.price = price;
		this.companyId = companyId;

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

	public void setQuantity(int productQuantity) {
		this.quantity = productQuantity;
	}

	public void increaseQuantity(int amount) {
		quantity += amount;
	}

	public void decreaseQuantity(int amount) {
		quantity -= amount;
	}

	public BigDecimal getPrice() {
		return price;
	}

	public void setPrice(BigDecimal productPrice) {
		this.price = productPrice;
	}

	public Long getCompanyId() {
		return companyId;
	}
	
	public void setCompanyId(Long companyId) {
		this.companyId = companyId;
	}

}
