package com.justinswork.storefront.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.NOT_FOUND, reason = "The product your trying to remove isn't in your cart.")
public class NoSuchProductInCartException extends RuntimeException {

	/**
	 * 
	 */
	private static final long serialVersionUID = 4450156975254164377L;

	public NoSuchProductInCartException() {
		super();
	}
	
	

	
	
}
