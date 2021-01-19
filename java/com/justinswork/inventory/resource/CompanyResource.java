package com.justinswork.inventory.resource;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.justinswork.inventory.model.Company;
import com.justinswork.inventory.model.Product;
import com.justinswork.inventory.service.CompanyService;

@RestController
@RequestMapping("/companies")
public class CompanyResource {
	
	private CompanyService companyService;
	
	public CompanyResource (CompanyService companyService) {
		this.companyService = companyService;
	}
	
	
	//GOOD
	@GetMapping(value = "/getBy/Name={companyName}")
	public ResponseEntity<List<Company>> findCompanyByName(@PathVariable("companyName") String companyName) {
		return ResponseEntity.status(HttpStatus.OK).body(companyService.findByCompanyName(companyName)); 
	}
	
	//GOOD 
	@GetMapping(value = "/getBy/Id={companyId}")
	public ResponseEntity<Company> getProductById(@PathVariable("companyId") Long companyId) {
		return ResponseEntity.status(HttpStatus.OK).body(companyService.findByCompanyId(companyId));
	}
	//GOOD
	@GetMapping(value = "/getBy/City={city}")
	public ResponseEntity<List<Company>> getCompaniesByCity(@PathVariable("city") String city) {
		return ResponseEntity.status(HttpStatus.OK).body(companyService.findCompaniesByCity(city));
	}
	
	//GOOD
	@GetMapping(value = "/get/AllCompanies")
	public ResponseEntity<List<Company>> getAllCompanies() {
		return ResponseEntity.status(HttpStatus.OK).body(companyService.findAllCompanies());
	}
	
	@GetMapping(value = "/getProducts/Id={companyId}")
	public ResponseEntity<List<Product>> viewCompanysProducts(@PathVariable("companyId") Long companyId){
		return ResponseEntity.status(HttpStatus.OK).body(companyService.findCompanysProducts(companyId));
	}
	
	@PostMapping(value = "/save/new")
	public Company saveCompany(Company company) {
		return companyService.saveCompany(company);
	}
	
}
