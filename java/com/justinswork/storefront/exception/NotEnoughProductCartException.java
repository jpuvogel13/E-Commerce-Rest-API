package com.justinswork.storefront.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.BAD_REQUEST, reason = "You do not have that many products in your cart. Check your amount and try again.")
public class NotEnoughProductCartException extends RuntimeException {

	
	/**
	 * 
	 */
	private static final long serialVersionUID = 6500941798450028091L;

	public NotEnoughProductCartException() {
		super();
	}

	
}
