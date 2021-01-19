package com.justinswork.inventory.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.BAD_REQUEST, reason = "You don't have enough product in inventory. Please lower the amount and try again.")
public class NotEnoughProductException extends RuntimeException {

	/**
	 * 
	 */
	private static final long serialVersionUID = 2141876463651548704L;

	
	public NotEnoughProductException() {
		super();
	}
	
	


}
