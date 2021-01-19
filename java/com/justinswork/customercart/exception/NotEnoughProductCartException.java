package com.justinswork.customercart.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.BAD_REQUEST, reason = "You don't have that much product in your cart. Please lower the amount and try again.")
public class NotEnoughProductCartException extends RuntimeException {

	/**
	 * 
	 */
	private static final long serialVersionUID = 5447991717089305543L;

	/**
	 * 
	 */

	public NotEnoughProductCartException() {
		super();
	}




}
