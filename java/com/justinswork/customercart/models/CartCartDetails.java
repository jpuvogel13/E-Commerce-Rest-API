package com.justinswork.customercart.models;


import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class CartCartDetails {

	private BigDecimal priceTotal;
	private int productsInCart;
	private List<CartProducts> itemsInCart;
	
	public CartCartDetails() {
		this.priceTotal = new BigDecimal(0.00);
		this.productsInCart = 0;
		this.itemsInCart = new ArrayList<CartProducts>();
	}
	
	public void setTotalPrice(BigDecimal totalPrice) {
		this.priceTotal = totalPrice;
	}
	
	public BigDecimal getPriceTotal() {
		return priceTotal;
	}

	public void setProductsInCart(int productTotal) {
		this. productsInCart = productTotal;
	}
	
	public int getProductsInCart() {
		return this.productsInCart;
	}
	
	public List<CartProducts> getItemsInCartList() {
		return itemsInCart;
	}

	public void setItemsInCartList(List<CartProducts> itemsInCartList) {
		this.itemsInCart = itemsInCartList;
	}
	
}