package com.justinswork.inventory.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;


@ControllerAdvice
public class ExceptionControllerHandler {
	
	
	/*
	 * This class is here in case you would rather this more than ResponseStatus.
	 * 
	 * 
	@ExceptionHandler(NoSuchProductFoundException.class)
	public ResponseEntity<String> NoSuchProductFoundException(){
		return new ResponseEntity<String>("The product you are looking for does not exist. Please try again"
				, HttpStatus.NOT_FOUND);
		
	}
	
	@ExceptionHandler(NotEnoughProductException.class)
	public ResponseEntity<String> NotEnoughProductFoundException(){
		return new ResponseEntity<String>("You don't have enough product in inventory. Please lower the amount and try again."
				, HttpStatus.BAD_REQUEST);
		
	}
	
	@ExceptionHandler(NoSuchCompanyFoundException.class)
	public ResponseEntity<String> NoSuchCompanyFoundException(){
		return new ResponseEntity<String>("The company you are looking for is not in our registry. Please check the name and try again.")
				, HttpStatus.NOT_FOUND);
		
	}

	*/
}
	
	
	



