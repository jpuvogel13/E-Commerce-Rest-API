package com.justinswork.inventory.model;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.codehaus.jackson.annotate.JsonIgnoreProperties;

@Entity
@Table(name = "companies")
@JsonIgnoreProperties(ignoreUnknown = true)

public class Company {

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	private Long companyId;
	private String companyName;
	private String email;
	private String address;
	private String phoneNumber;
	private String city;
	@OneToMany(mappedBy = "company")
	private List<Product> products;

	public Company(){
			
	}
	
	public Company(String companyName, String email, String address, String phoneNumber, String city, List<Product> products) {
		this.companyName = companyName;
		this.email = email;
		this.address = address;
		this.phoneNumber = phoneNumber;
		this.city = city;
		this.products = products;
	}
	
	
	public void setProducts(List<Product> products) {
		this.products = products;
	}
	
	public String getCity() {
		return city;
	}

	public List<Product> getProducts() {
		return products;
	}

	public void setProduct(List<Product> products) {
		this.products = products;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public void setCompanyId(Long companyId) {
		this.companyId= companyId;
	}
	
	public Long getCompanyId(){
		return this.companyId;
	}
	
	public String getCompanyName() {
		return companyName;
	}
	
	public String getEmail() {
		return email;
	}
	
	public String getAddress() {
		return address;
	}
	
	public String getPhoneNumber() {
		return phoneNumber;
	}
	
	public void setCompanyName(String companyName) {
		this.companyName = companyName;
	}
	
	public void setEmail(String email) {
		this.email = email;
	}
	
	public void setAddress(String address) {
		this.address = address;
	}
	
	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}
	
	
}

