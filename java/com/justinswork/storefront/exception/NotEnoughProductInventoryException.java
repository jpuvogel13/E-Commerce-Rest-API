package com.justinswork.storefront.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.BAD_REQUEST, reason = "We do not have enough product in inventory to fulfill your request. Please lower your amount and try again.")
public class NotEnoughProductInventoryException extends RuntimeException{

	/**
	 * 
	 */
	private static final long serialVersionUID = 2141876463651548704L;
	
	public NotEnoughProductInventoryException() {
	super();
	
	}
	
	
}

