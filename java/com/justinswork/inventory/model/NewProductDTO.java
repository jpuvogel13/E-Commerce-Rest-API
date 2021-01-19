package com.justinswork.inventory.model;

import java.io.Serializable;
import java.math.BigDecimal;



public class NewProductDTO implements Serializable {
	
	
	private static final long serialVersionUID = 1L;
	private String productName;
	private int quantity;
	private BigDecimal price;
	private String companyName;
	private String email;
	private String address;
	private String phoneNumber;
	private String city;
	

	public NewProductDTO () {
		
	}

	
	public NewProductDTO(String productName, int quantity, BigDecimal price, String companyName, String email,
			String address, String phoneNumber, String city) {
		super();
		this.productName = productName;
		this.quantity = quantity;
		this.price = price;
		this.companyName = companyName;
		this.email = email;
		this.address = address;
		this.phoneNumber = phoneNumber;
		this.city = city;
	}

	public String getProductName() {
		return productName;
	}


	public int getQuantity() {
		return quantity;
	}


	public BigDecimal getPrice() {
		return price;
	}


	public String getCompanyName() {
		return companyName;
	}


	public String getEmail() {
		return email;
	}


	public String getAddress() {
		return address;
	}


	public String getPhoneNumber() {
		return phoneNumber;
	}


	public String getCity() {
		return city;
	}


	public void setProductName(String productName) {
		this.productName = productName;
	}


	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}


	public void setPrice(BigDecimal price) {
		this.price = price;
	}


	public void setCompanyName(String companyName) {
		this.companyName = companyName;
	}


	public void setEmail(String email) {
		this.email = email;
	}


	public void setAddress(String address) {
		this.address = address;
	}


	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}


	public void setCity(String city) {
		this.city = city;
	}
	
}

	