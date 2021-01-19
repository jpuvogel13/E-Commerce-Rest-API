package com.justinswork.inventory.resource;

import java.math.BigDecimal;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.util.Date;
import java.util.List;

import javax.persistence.criteria.CriteriaBuilder.In;
import javax.websocket.server.PathParam;

import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import com.justinswork.inventory.exceptions.NoSuchProductFoundException;
import com.justinswork.inventory.exceptions.NotEnoughProductException;
import com.justinswork.inventory.model.Company;
import com.justinswork.inventory.model.Product;
import com.justinswork.inventory.model.NewProductDTO;
import com.justinswork.inventory.repository.ProductRepository;
import com.justinswork.inventory.service.ProductService;
import com.netflix.discovery.shared.Application;
import com.netflix.ribbon.proxy.annotation.Http.Header;

@RestController
@RequestMapping(value= "/inventory", produces = MediaType.APPLICATION_JSON_VALUE)
public class ProductResource {
	
	//THE response entity could respond with 4 toy cars were added to your cart!
	private ProductService productService;
	private Product product;
	
	
	public ProductResource(ProductService productService, Product product) {
		this.productService = productService;
		this.product = product;
	}
	//*******CAN @REQUEST BODY Company @RequestBody Product ELIMINATE THE DAO here???******************
	@PostMapping(value = "/add/new", headers = "Accept=application/json")
	public ResponseEntity<String> addNewProductToInventory(@RequestBody Product product, @RequestBody Company company) {
		productService.addNewProductToInventory(product,company);
		return  ResponseEntity.status(HttpStatus.CREATED).body("The product has sucessfully been added to your inventory.");
	}
	
	@PutMapping(value = "/add/{productId}")
	public ResponseEntity<String> addToExistingInventory(@PathVariable("productId")Long productId,
			@RequestBody int productAmount) {
		productService.addExistingProductToInventory(productId, productAmount);
		return  ResponseEntity.status(HttpStatus.OK).body("The products have been added to your inventory.");
	}
	
	@PutMapping(value = "/remove/{productId}") //put product ID in the URL, use pathVariable to pass in ID, search database, remove
	public ResponseEntity<String> removeProductsFromInventory(@PathVariable("productId")Long productId,
			@RequestBody int productAmount) {
		product = productService.findProductById(productId);
		productService.removeProductsFromInventory(productId, productAmount);
		return ResponseEntity.status(HttpStatus.OK).body("The products have been removed from your inventory.");
	}
	
	@DeleteMapping(value = "/delete/{productId}")
	public ResponseEntity<String> deleteProductFromInventory(@PathVariable("productId")Long productId) {
		productService.completelyRemoveProductFromInventory(productId);
		return ResponseEntity.status(HttpStatus.OK).body("The product was sucessfully removed from inventory.");
	}
	
	@PutMapping(value= "/priceChange/{productId}")
	public ResponseEntity<String> changeProductPrice(@PathVariable("productId") Long productId,
									  @RequestBody BigDecimal price) {
		if(productService.findProductById(productId)== null) throw new NoSuchProductFoundException();
		productService.changeProductPrice(productId, price);
		return ResponseEntity.status(HttpStatus.OK).body("The price has been updated to: " + price);
	}
	
	@PutMapping(value = "/changeName/{productId}")
	public ResponseEntity<String> changeProductName(@PathVariable("productId") Long productId, 
									@RequestBody String newName) {
		productService.changeProductName(productId,newName);
		return ResponseEntity.status(HttpStatus.OK).body("You have sucessfully updated product too: " + newName.replace("_", " "));
	}
	
	@GetMapping(value = "/get/Id={productId}")
	public ResponseEntity<Product> getProductById(@PathVariable("productId") Long productId) {
		product = productService.findProductById(productId);		
		return ResponseEntity.status(HttpStatus.OK).body(product);
	}

	@GetMapping(value = "/get/Name={productName}")
	public ResponseEntity<List<Product>> getProductByName(@PathVariable("productName") String productName) {
		List<Product> products = productService.findProductByName(productName);
		return new ResponseEntity<List<Product>>(products,HttpStatus.OK);
	}
	
	@GetMapping(value="/findAll")
	public ResponseEntity<List<Product>> getAllInventory(){
		return ResponseEntity.status(HttpStatus.OK).body(productService.getAllInventory());
	}

	@GetMapping(value="/sortLowToHigh")
	public ResponseEntity<List<Product>> sortByPriceLowToHigh(){
		return ResponseEntity.status(HttpStatus.OK).body(productService.sortByPriceLowToHigh());
	}
	
	@GetMapping(value="/sortHighToLow")
	public ResponseEntity<List<Product>> sortByPriceHighToLow(){
		return ResponseEntity.status(HttpStatus.OK).body(productService.sortByPriceHighToLow());
	}
	
	
	//***** CHANGE THESE FROM PATHVARIABLE TO REQUEST BODY?
	@GetMapping(value = "/searchPrice/high={highPrice}/low={lowPrice}")
	public ResponseEntity<List<Product>> sortByPriceRange(@PathVariable("highPrice") BigDecimal highPrice,
			@PathVariable("lowPrice") BigDecimal lowPrice){
		return ResponseEntity.status(HttpStatus.OK).body(productService.searchInPriceRange(highPrice, lowPrice));
	}	
	
	@GetMapping(value = "/search/keyword={keyword}")
	public List<Product> findByKeyword(@PathVariable("keyword") String keyword){
		return productService.searchByKeyword(keyword);
	}
	
}
