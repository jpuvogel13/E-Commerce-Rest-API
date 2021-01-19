package com.justinswork.storefront.service;

import java.math.BigDecimal;
import java.util.List;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.RestTemplate;

import com.justinswork.storefront.exception.NoSuchProductInInventoryException;
import com.justinswork.storefront.exception.NoSuchProductInCartException;
import com.justinswork.storefront.exception.NotEnoughProductCartException;
import com.justinswork.storefront.exception.NotEnoughProductInventoryException;
import com.justinswork.storefront.model.CustomerCart;
import com.justinswork.storefront.model.Order;
import com.justinswork.storefront.model.Product;


@Service
public class StorefrontService {


	@Value("${inventory-url}")
	private String inventoryUrl;
	@Value("${cart-url}")
	private String cartUrl;
	@Value("${orders-url}")
	private String orderUrl;
	private RestTemplate restTemplate;


	public StorefrontService(RestTemplate restTemplate) {
		this.restTemplate = restTemplate;
	}
	
	public void addProductToCart(Long productId, int productAmount){	
		//Make a call to the inventory to see if we have product
		try {
			restTemplate.put(inventoryUrl+ "/remove/" + productId + "/" + productAmount, Product.class);

		} catch (HttpClientErrorException e) {
			if(e.getStatusCode() == HttpStatus.BAD_REQUEST) throw new NotEnoughProductInventoryException();
			else if(e.getStatusCode() == HttpStatus.NOT_FOUND) throw new NoSuchProductInInventoryException();
		}

		//Make a call to add products to the shopping cart.
		restTemplate.put(cartUrl + "/addProduct/" + productId + "/" + productAmount, Product.class);
	}

	//GOOD
	public void removeProductFromCart(Long productId, int productAmount) {
		//Make a call to remove items from the Shopping cart
		try {
			restTemplate.put(cartUrl + "/removeProduct/" + productId + "/" + productAmount, Product.class);
		} catch (HttpClientErrorException e) {
			if(e.getStatusCode() == HttpStatus.BAD_REQUEST) throw new NotEnoughProductCartException();
			else if(e.getStatusCode() == HttpStatus.NOT_FOUND) throw new NoSuchProductInCartException();
		}
		//Make a call to add the items back into inventory
		restTemplate.put(inventoryUrl+ "/add/" + productId + "/" + productAmount, Product.class);
	}

	//Works
	public Product searchForProductById(Long productId) {
		Product idProduct = null;
		try {
			//searching for product in inventory, by product ID	
			idProduct = restTemplate.getForObject(inventoryUrl + "/get/Id="+ productId, Product.class);  	
		} catch (HttpClientErrorException e) {
			if(e.getStatusCode() == HttpStatus.NOT_FOUND) throw new NoSuchProductInInventoryException();
		}
		return idProduct;
	}
	//Works
	public Product searchForProductByName(String productName) {
		productName = productName.replace("_", " ");
		Product idProduct = null;
		try {
			//searching for product in inventory, by product name	
			idProduct = restTemplate.getForObject(inventoryUrl + "/get/Name=" + productName, Product.class);
		} catch (HttpClientErrorException e) {
			if(e.getStatusCode() == HttpStatus.NOT_FOUND) throw new NoSuchProductInInventoryException();
		}
		return idProduct;
	}

	public CustomerCart viewCart(){
		//Make a call to the customer-cart service to view cart details
		return restTemplate.getForObject(cartUrl + "/view/cartDetails", CustomerCart.class);
	}

	@SuppressWarnings("unchecked")
	public List<Product> searchByPriceLowToHigh(){
		//Make a call to the inventory service
		return restTemplate.getForObject(inventoryUrl + "/sortLowToHigh", List.class);

	}
	@SuppressWarnings("unchecked")
	public List<Product> searchByPriceHighToLow(){
		//Make a call to the inventory service
		return restTemplate.getForObject(inventoryUrl + "/sortHighToLow", List.class);
	}

	@SuppressWarnings("unchecked")
	public List<Product> searchInPriceRange(BigDecimal highPrice, BigDecimal lowPrice) {
		//Make a call to the inventory service, get sublist from these parameters (highPrice/lowPrice)
		return restTemplate.getForObject(inventoryUrl + "/searchPrice/high=" + highPrice + "/low=" + lowPrice, List.class);
	}
	
	//WHY NOT JUST CALL FOR LONG HERE, why ask for whole order object?
	public Long checkout() {
		Order order = new Order();
		order = restTemplate.getForObject(orderUrl + "/createOrder", Order.class);
		Long orderId = order.getOrderId();
		return orderId;
	}

}
