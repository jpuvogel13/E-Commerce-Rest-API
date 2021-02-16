package com.justinswork.inventory.model;

import java.util.List;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table(name = "orders")
public class Order {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long orderId;
	private String username;
	private String dateCreated;
	@OneToMany(mappedBy = "order")
	private List<OrderProducts> orderProductList;

	
	
	public Order(List<OrderProducts> orderProductList, String username) {
		super();
		this.orderProductList = orderProductList;
		this.username = username;
	
	}

	public Order() {

	}
	
	public List<OrderProducts> getOrderProductList() {
		return orderProductList;
	}

	public void setOrderProductList(List<OrderProducts> orderProductList) {
		this.orderProductList = orderProductList;
	}
	
	public String getDateCreated() {
		return dateCreated;
	}
	
	public void setDateCreated(String dateCreated) {
		this.dateCreated = dateCreated;
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
