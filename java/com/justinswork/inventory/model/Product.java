package com.justinswork.inventory.model;

import java.io.Serializable;
import java.math.BigDecimal;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Transient;

import org.codehaus.jackson.annotate.JsonIgnoreProperties;
import org.springframework.beans.factory.annotation.Value;

import com.fasterxml.jackson.annotation.JsonIgnore;


@Entity
@Table(name = "Products")
@JsonIgnoreProperties(ignoreUnknown = true)
public class Product {
	
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long productId;
	private String productName;
	private int quantity;
	private BigDecimal price;
	@ManyToOne
	private Company company;
	
	
	public Product() {
		
	}

	public Product(String productName, int quantity, BigDecimal price, Company productCompany){
		this.productName = productName;
		this.quantity = quantity;
		this.price = price;
		this.company = productCompany;
	}
	
	@JsonIgnore
	public Company getCompany() {
		return company;
	}

	public void setCompany(Company company) {
		this.company = company;
	}

	public void setProductId(Long productId) {
		this.productId = productId;
	}
	
	public Long getProductId() {
		return productId;
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
	
	
	


	
	
}
