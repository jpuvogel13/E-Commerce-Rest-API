package com.justinswork.storefront.resource;

import java.math.BigDecimal;
import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.justinswork.storefront.exception.NoSuchProductInInventoryException;
import com.justinswork.storefront.model.CustomerCart;
import com.justinswork.storefront.model.Product;
import com.justinswork.storefront.service.StorefrontService;

@RestController
@RequestMapping(value= "/shop", produces = MediaType.APPLICATION_JSON_VALUE)
public class StorefrontResource {

	private StorefrontService storeService;

	public StorefrontResource(StorefrontService storeService) {
		this.storeService = storeService;
	}

	//GOOD
	//***WHY HIS THIS REQUEST MAPPING??****
	@RequestMapping(value = "/addToCart/{productId}/{productAmount}")
	private ResponseEntity<String> addProductToCart(@PathVariable("productId")Long productId,
			@PathVariable("productAmount") int productAmount) throws NoSuchProductInInventoryException{
		storeService.addProductToCart(productId, productAmount);
		return ResponseEntity.status(HttpStatus.OK).body("The products have been added to your cart.");
	}

	//GOOD
	@PutMapping(value= "/removeFromCart/{productId}/{productAmount}")
	private ResponseEntity<String> removeProductFromCart(@PathVariable("productId")Long productId,
			@PathVariable("productAmount") int productAmount) {
		storeService.removeProductFromCart(productId, productAmount);
		return ResponseEntity.status(HttpStatus.OK).body("The products have been removed from your cart.");
	}

	//GOOD
	@GetMapping(value = "/view/search/byId={productId}")
	private ResponseEntity<Product> searchById(@PathVariable("productId")Long productId){		
		return ResponseEntity.status(HttpStatus.OK).body(storeService.searchForProductById(productId));
	}


	//GOOD
	//Using both a space, or an underscore (_) works fine. It is not case sensitive
	@GetMapping(value = "/view/search/byName={productName}")
	private ResponseEntity<Product> searchByName(@PathVariable("productName")String productName){
		return ResponseEntity.status(HttpStatus.OK)
				.body(storeService.searchForProductByName(productName));
	}

	//GOOD
	@GetMapping(value = "/view/cartDetails")
	private ResponseEntity<CustomerCart> viewCart(){
		return ResponseEntity.status(HttpStatus.OK).body(storeService.viewCart());
	}

	//GOOD
	@SuppressWarnings("rawtypes")
	@GetMapping(value = "/view/sortPriceLowToHigh")
	public ResponseEntity<List> searchByPriceLowToHigh(){
		return ResponseEntity.status(HttpStatus.OK)
				.body(storeService.searchByPriceLowToHigh());
	}

	//GOOD
	@SuppressWarnings("rawtypes")
	@GetMapping(value = "/view/sortPriceHighToLow")
	private ResponseEntity<List> searchByPriceHighToLow(){
		return ResponseEntity.status(HttpStatus.OK)
				.body(storeService.searchByPriceHighToLow());
	}

	//GOOD
	@SuppressWarnings("rawtypes")
	@GetMapping(value = "/view/byPriceRange/high={highPrice}/low={lowPrice}")
	private ResponseEntity<List> searchByPriceRange(@PathVariable("highPrice") BigDecimal highPrice,
			@PathVariable("lowPrice") BigDecimal lowPrice){
		return ResponseEntity.status(HttpStatus.OK)
				.body(storeService.searchInPriceRange(highPrice, lowPrice));

	}
	
	//THIS returns a long, should it return an order object? Check
	@RequestMapping(value = "/checkout")
	private ResponseEntity<String> checkout(){
		Long orderId = storeService.checkout();
		return ResponseEntity.status(HttpStatus.OK)
				.body("An order has been placed. Your order Id is : " + orderId );
	}
	
}

