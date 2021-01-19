package com.justinswork.customercart.service;



import java.math.BigDecimal;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.OneToMany;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.justinswork.customercart.exception.NoSuchProductFoundCartException;
import com.justinswork.customercart.exception.NotEnoughProductCartException;
import com.justinswork.customercart.models.CartProducts;
import com.justinswork.customercart.models.CartCartDetails;
import com.justinswork.customercart.models.CartOrder;
import com.justinswork.customercart.repository.CartRepository;

@Service
public class ShoppingCartService {
	
	@Value("${inventory-url}")
	private String inventoryUrl;
	
	private CartRepository cartRepository;

	private RestTemplate restTemplate;
	
	private CartProducts product;
	
	private CartCartDetails cartDetails;
	
	@OneToMany(cascade = CascadeType.ALL, mappedBy = "Customer_Cart")
	private List<CartProducts> productsList;
	
	public ShoppingCartService(CartRepository cartRepository, RestTemplate restTemplate,
			CartProducts product, CartCartDetails cartDetails) {
		this.cartRepository = cartRepository;
		this.restTemplate = restTemplate;
		this.product = product;
		this.cartDetails = cartDetails;
	}

	public void addProductToCart(Long productId, int productAmount) {
		if(cartRepository.findById(productId).isPresent()){
			product = cartRepository.findByProductId(productId);
			product.increaseQuantity(productAmount);
			product.setTotalPrice();
			productsList.add(product);
			cartRepository.save(product);
		}else {
			product = restTemplate.getForObject(inventoryUrl + "/inventory/get/Id=" + productId, CartProducts.class);
			product.setQuantity(0);
			product.increaseQuantity(productAmount);
			product.setTotalPrice();
			productsList.add(product);
			cartRepository.save(product);
		}
	}

	//GOOD
	public CartProducts removeProductFromCart(Long productId, int productAmount){
		product = cartRepository.findByProductId(productId);
		if(product == null)	throw new NoSuchProductFoundCartException();
		if(product.getQuantity() == productAmount) {
			product.setTotalPrice();
			productsList.remove(product);
			cartRepository.delete(product);
		}else if(
				product.getQuantity() < productAmount) throw new NotEnoughProductCartException();
		else{
			product.decreaseQuantity(productAmount);
			productsList.remove(product);
			product.setTotalPrice();
			cartRepository.save(product);
		}
		return product;
	}
	
	public CartProducts viewProduct(Long productId) {
		if(cartRepository.findByProductId(productId)==null){
			throw new NoSuchProductFoundCartException();
		}
		return cartRepository.findByProductId(productId);
	}

	public CartCartDetails viewCartDetails(){
		cartDetails.setItemsInCartList(cartRepository.findAll());
		cartDetails.setProductsInCart(cartRepository.findAll().size());
		cartDetails.setTotalPrice(calculateTotalPrice(cartRepository.findAllByTotalPrice()));
		return cartDetails;
	}
	
	private BigDecimal calculateTotalPrice(List<BigDecimal> totalPriceList) {
		return totalPriceList.stream().reduce(BigDecimal.ZERO, BigDecimal :: add);
		
	}
	//SHOULDNT DECLARE A NEW OBJECT IN A METHOD
	public CartOrder checkout(){
		CartOrder order = new CartOrder();
		order= restTemplate.getForObject(inventoryUrl + "/orders/createOrder", CartOrder.class);
		return order;
	}
	
	public List<CartProducts> getProductsList(){
		productsList = cartRepository.findAll();
		return productsList;
	}
	/*
	public void emptyCart() {
		cartRepository.deleteAll();
	}
	*/
	
}
