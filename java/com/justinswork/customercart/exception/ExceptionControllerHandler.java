package com.justinswork.customercart.exception;

import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.util.ArrayList;
import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;


@ControllerAdvice
public class ExceptionControllerHandler {
	

	/*
	 * This class is here if you would rather use this than Response Status.

	@ExceptionHandler(NoSuchProductFoundCartException.class)
	public ResponseEntity<String> NoSuchProductFoundException(){
		return new ResponseEntity<String>("The product you are looking for does not exist. Please try again"
				, HttpStatus.NOT_FOUND);

	}

	@ExceptionHandler(NotEnoughProductCartException.class)
	public ResponseEntity<String> NotEnoughProductException(){
		return new ResponseEntity<String>("We're sorry, the product your looking for is currently out of stock, please try again later."
				, HttpStatus.BAD_REQUEST);

	}


	 */

}
	



