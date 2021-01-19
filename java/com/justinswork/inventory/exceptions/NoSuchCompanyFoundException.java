package com.justinswork.inventory.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.NOT_FOUND, reason  = "The company you are looking for is not in our registry. Please check the name and try again.")
public class NoSuchCompanyFoundException extends RuntimeException {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	public NoSuchCompanyFoundException() {
		super();
	}

}
