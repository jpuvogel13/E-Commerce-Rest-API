package com.justinswork.customercart.repository;

import java.math.BigDecimal;
import java.util.List;

import com.justinswork.customercart.models.CartProducts;

public interface CartRespositoryCustom  {
	
	public List<BigDecimal> findAllByTotalPrice();
	
	

}
