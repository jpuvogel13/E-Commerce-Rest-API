package com.justinswork.inventory.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.justinswork.inventory.exceptions.NoSuchCompanyFoundException;
import com.justinswork.inventory.model.Company;
import com.justinswork.inventory.model.Product;
import com.justinswork.inventory.repository.CompanyRepository;
import com.justinswork.inventory.repository.ProductRepository;

@Service
public class CompanyService {
	
	//DOES THIS AUTOWIRE MATTER?
	@Autowired
	private CompanyRepository companyRepo;
	@Autowired
	private ProductRepository productRepository;
	
	
	// NOW MAKE EXCEPTIONS FOR THIS CLASS

	public CompanyService(CompanyRepository companyRepository, ProductRepository productRepository) {
		this.companyRepo = companyRepository;
		this.productRepository = productRepository;
	}
	
	public CompanyService() {
		
	}

	public Company findByCompanyId(Long companyId) {
		if(companyRepo.findByCompanyId(companyId) == null) throw new NoSuchCompanyFoundException();
		return companyRepo.findByCompanyId(companyId);
	}
	
	public List<Company> findByCompanyName(String companyName) {
		if(companyRepo.findByCompanyName(companyName) == null) throw new NoSuchCompanyFoundException();
		return companyRepo.findByCompanyName(companyName);
	}
	
	public List<Company> findCompaniesByCity(String city){
		return companyRepo.findByCity(city);
	}
	
	public List<Company> findAllCompanies(){
		return companyRepo.findAll();
	}
	
	public List<Product> findCompanysProducts(Long companyId){
		return productRepository.findAllByCompanyCompanyId(companyId);
	}
	
	public Company saveCompany(Company company) {
		companyRepo.save(company);
		return company;
	}
	
	public boolean existsByPhoneNumber(String phoneNumber) {
		return companyRepo.existsByPhoneNumber(phoneNumber);
	}
	
	public boolean existsByAddress(String address) {
		return companyRepo.existsByAddress(address);
	}
	
	public boolean existsByName(String name) {
		if(companyRepo.findByCompanyName(name)== null) return false;
		return true;
	}
	
}
