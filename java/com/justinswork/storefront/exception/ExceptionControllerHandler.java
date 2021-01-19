package com.justinswork.storefront.exception;



import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.client.HttpClientErrorException.NotFound;
import org.springframework.web.client.HttpServerErrorException;
import org.springframework.web.client.HttpServerErrorException.InternalServerError;



@ControllerAdvice
public class ExceptionControllerHandler {
	
	/*
	 *This exception handler class is here in case you prefer to use this rather than ResponseStatus. 
	 
	@ExceptionHandler(NoSuchProductFoundInventoryException.class)
	public ResponseEntity<String> NoSuchProductFoundException(){
		return new ResponseEntity<String>("The product you are looking for does not exist. Please try again"
				, HttpStatus.NOT_FOUND);
		
	}
	 
	 @ExceptionHandler(NoSuchProductInCartException.class)
		public ResponseEntity<String> noSuchProductInCartException(){
			return new ResponseEntity<String>("The product your trying to remove isn't in your cart.", HttpStatus.NOT_FOUND);
		}
		

	@ExceptionHandler(NotEnoughProductInventoryException.class)
	public ResponseEntity<String> notEnoughProductInventoryException(){
		return new ResponseEntity<String>("We do not have enough product in our inventory to fulfill your request. Please try again."
				,HttpStatus.BAD_REQUEST);
		
	}
	
	
	@ExceptionHandler(NotEnoughProductCartException.class)
	public ResponseEntity<String> notEnoughProductCartException(){
		return new ResponseEntity<String>("The product your trying to remove isn't in your cart.", HttpStatus.NOT_FOUND);
	}
	
	*/
	
	
	
}
