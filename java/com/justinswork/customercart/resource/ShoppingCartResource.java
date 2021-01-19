package com.justinswork.customercart.resource;


import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import com.justinswork.customercart.models.CartCartDetails;
import com.justinswork.customercart.models.CartOrder;
import com.justinswork.customercart.models.CartProducts;
import com.justinswork.customercart.service.ShoppingCartService;

@RestController
@RequestMapping(value = "/cart", produces =  MediaType.APPLICATION_JSON_VALUE)
public class ShoppingCartResource {
	
	private ShoppingCartService shoppingCartService;
	
	public ShoppingCartResource(ShoppingCartService shoppingCartService) {
		this.shoppingCartService = shoppingCartService;
	}
	 	
	//GOOD
	//DOES NOT TAKE OUT OF PRODUCTS DATABASE, because customer cart is used only through storeFront
	@PutMapping(value = "/addProduct/{productId}/{productAmount}")
	public ResponseEntity<String> addProductTocart(@PathVariable("productId") Long productId,
			@PathVariable("productAmount") int productAmount){
		
		shoppingCartService.addProductToCart(productId, productAmount);
		return ResponseEntity.status(HttpStatus.OK).body("The product had been added to your cart.");		
	}
	
	//
	//DOES NOT Put PRODUCTS in DATABASE, because customer cart is used only through storeFront
	//GOOD
	@PutMapping(value ="/removeProduct/{productId}/{productAmount}")
	public ResponseEntity<String> removeProductFromCart(@PathVariable("productId")Long productId,
			@PathVariable("productAmount") int productAmount){
		
		shoppingCartService.removeProductFromCart(productId, productAmount);
		return ResponseEntity.status(HttpStatus.OK).body("The products have been removed from your cart.");
	}
	
	//Good
	@GetMapping(value= "/viewProduct/{productId}")
	public ResponseEntity<CartProducts> viewProductInCart(@PathVariable("productId") Long productId) {
		return ResponseEntity.status(HttpStatus.OK).body(shoppingCartService.viewProduct(productId));
	}
	
	//GOOD
	@GetMapping(value= "/view/cartDetails")
	public ResponseEntity<CartCartDetails> viewCartDetails(){
		return ResponseEntity.status(HttpStatus.OK).body(shoppingCartService.viewCartDetails());
	}
	
	//RETURN RESPONSE ENTITY WITH THESE
	@GetMapping(value= "/checkout")
	public CartOrder checkout() {
		return shoppingCartService.checkout();
	}
	
	@RequestMapping(value = "/getProductList")
	public List<CartProducts> getProductList(){
		return shoppingCartService.getProductsList();
	}
	
}
