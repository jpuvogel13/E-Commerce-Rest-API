package com.justinswork.customercart.repository;

import java.math.BigDecimal;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import com.justinswork.customercart.models.CartProducts;

public class CartRepositoryImpl implements CartRespositoryCustom{
	
	@PersistenceContext
	private EntityManager entityManager;
	
	@SuppressWarnings("unchecked")
	@Override
	public List<BigDecimal> findAllByTotalPrice(){
		return this.entityManager.createQuery("select totalPrice from Product").getResultList();
		
	}
	
}
