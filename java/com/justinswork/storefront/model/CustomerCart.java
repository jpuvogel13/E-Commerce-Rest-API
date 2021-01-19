package com.justinswork.storefront.model;


import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
@Entity
@Table(name = "Customer_cart")
public class CustomerCart {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long cartId;
	private BigDecimal priceTotal;
	private int productsInCart;
	private List<Product> itemsInCart;
	private BigDecimal priceMultiplier;
	
	public CustomerCart() {
		this.priceTotal = new BigDecimal(0.00);
		this.productsInCart = 0;
		this.itemsInCart = new ArrayList<Product>();
		this.priceMultiplier = new BigDecimal(0.00);
	}


	public BigDecimal getPriceTotal() {
		return priceTotal;
	}

	public void increasePriceTotal(BigDecimal price, int amount) {
		BigDecimal quantityMultiplier = new BigDecimal(amount);
		priceMultiplier = price;
		quantityMultiplier = priceMultiplier.multiply(quantityMultiplier);
		priceTotal = priceTotal.add(quantityMultiplier);
	}

	public void decreasePriceTotal(BigDecimal price, int amount) {
		BigDecimal quantityMultiplier = new BigDecimal(amount);
		priceMultiplier = price;
		quantityMultiplier = priceMultiplier.multiply(quantityMultiplier);
		priceTotal = priceTotal.subtract(quantityMultiplier);
	}

	public void setProductsInCart(int productTotal) {
		this. productsInCart = productTotal;
	}
	
	public int getProductsInCart() {
		return this.productsInCart;
	}
	
	public List<Product> getItemsInCartList() {
		return itemsInCart;
	}

	public void setItemsInCartList(List<Product> itemsInCartList) {
		this.itemsInCart = itemsInCartList;
	}
	
}