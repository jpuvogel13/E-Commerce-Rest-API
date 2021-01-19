package com.justinswork.customercart.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.NOT_FOUND, reason =  "The product your looking for does not exist." )
public class NoSuchProductFoundCartException extends RuntimeException{

	/**
	 * 
	 */
	private static final long serialVersionUID = 8363284332359802395L;

	public NoSuchProductFoundCartException() {
		super();
		
	}
	
	

}
