package com.justinswork.inventory.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.justinswork.inventory.model.Company;

@Repository
public interface CompanyRepository extends CrudRepository<Company, Long> {
	
	List<Company> findByCompanyName(String companyName);
	
	Company findByCompanyId(Long companyId);
	
	Boolean existsByPhoneNumber(String phoneNumber);
	
	Boolean existsByAddress(String address);
	
	List<Company> findByCity(String city);
	
	List<Company> findAll();


}
