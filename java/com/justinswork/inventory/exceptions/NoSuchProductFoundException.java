package com.justinswork.inventory.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.NOT_FOUND, reason =  "The product your looking for does not exist. Please try again." )
public class NoSuchProductFoundException extends RuntimeException{

	/**
	 * 
	 */
	private static final long serialVersionUID = 8363284332359802395L;

	public NoSuchProductFoundException() {
		super();
		
	}
	
	

}
