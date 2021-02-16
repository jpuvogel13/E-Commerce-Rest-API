package com.justinswork.inventory.model;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.hibernate.annotations.ForeignKey;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;




@Entity
@Table (name = "order_products")
public class OrderProducts {
		
			
		@Id
		@GeneratedValue(strategy = GenerationType.AUTO)
		private Long id;
		@ManyToOne
		private Order order;
		private Long productId;
		private String productName;
		private int quantity;
		private BigDecimal productPrice;
		


		public OrderProducts(Long productId, String productName, int quantity) {
			this.productId = productId;
			this.productName = productName;
			this.quantity = quantity;
			
		}
		
		public OrderProducts() {
			
		}
		
		public Long getId() {
			return id;
		}

		public void setId(Long id) {
			this.id = id;
		}
	
		public BigDecimal getProductPrice() {
			return productPrice;
		}
		@JsonIgnore
		public Order getOrderId() {
			return order;
		}

		public void setProductPrice(BigDecimal productPrice) {
			this.productPrice = productPrice;
		}

		public void setOrder(Order order) {
			this.order = order;
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
		/*
		 @Override
		  public int hashCode() {
		      return Objects.hash(productId);
		  }
		
		@Override
		public boolean equals(Object o) {
			if( o == this) return true;
			OrderProducts opl = (OrderProducts) o;
			if(opl.getProductId().compareTo(productId) == 0 && opl.getProductName().equals(productName) 
					&& opl.getQuantity() == quantity) return true;
			
			return false;
			
		}
		*/
	
		

	
		
		
	}


