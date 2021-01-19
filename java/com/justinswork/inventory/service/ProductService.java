package com.justinswork.inventory.service;


import java.math.BigDecimal;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.justinswork.inventory.exceptions.NoSuchProductFoundException;
import com.justinswork.inventory.exceptions.NotEnoughProductException;
import com.justinswork.inventory.model.Product;
import com.justinswork.inventory.model.NewProductDTO;
import com.justinswork.inventory.model.Company;
import com.justinswork.inventory.repository.ProductRepository;


@Service
public class ProductService {
	
	//private CompanyRepository companyRepository;
	@Autowired
	private CompanyService companyService;
	@Autowired
	private ProductRepository productRepository;
	@Autowired
	private Product product;
	@Autowired
	private Company company;
	
	public ProductService() {
	}
	
	ProductService(ProductRepository productRepository, Product product, Company company, CompanyService companyService){
		this.productRepository = productRepository;
		this.product = product;
		this.company = company;
		this.companyService = companyService;
	}
	//DOES THIS NEW REQUEST BODY WORK!?!?!?!?
	//make this so a company can upload a new product with just an existing company id
		public void addNewProductToInventory(Product product, Company company) {
			//this is stopping the Found shared references to a collection error from happening
			product.setCompany(null);
			
			productRepository.save(product);
			companyService.saveCompany(company);
		
			/*
		if(companyService.existsByName(newProduct.getCompanyName()) && 
				companyService.existsByPhoneNumber(newProduct.getPhoneNumber()) &&
				companyService.existsByAddress(newProduct.getAddress())){
			company = companyService.findByCompanyName(newProduct.getCompanyName());
			product.setPrice(newProduct.getPrice());
			product.setProductName(newProduct.getProductName());
			product.setQuantity(newProduct.getQuantity());
			product.setCompany(company);
			productRepository.save(product);
		}else {
			//this is stopping the Found shared references to a collection error from happening
			company.setProducts(null);
			//Save company information
			company.setAddress(newProduct.getAddress());
			company.setCity(newProduct.getCity());
			company.setCompanyName(newProduct.getCompanyName());
			company.setEmail(newProduct.getEmail());
			company.setPhoneNumber(newProduct.getPhoneNumber());
			companyService.saveCompany(company);
			product.setPrice(newProduct.getPrice());
			product.setProductName(newProduct.getProductName());
			product.setQuantity(newProduct.getQuantity());
			product.setCompany(company);
			productRepository.save(product);
	}	
		product.setProductId(null);
		company.setCompanyId(null);
		*/
	}
	
	//NOT IN THE RESOURCE?????
	public void replenishEmptyStock(Product product){
		productRepository.save(product);
	}
	
	public void addExistingProductToInventory(Long productId, int productAmount) {
		product = productRepository.findByProductId(productId);
		if(isProductNull(product)) throw new NoSuchProductFoundException();
		
		product.increaseQuantity(productAmount);
		productRepository.save(product);
	}
	
	public void removeProductsFromInventory(Long productId, int productAmount){
		product = productRepository.findByProductId(productId);
		if(isProductNull(product)) throw new NoSuchProductFoundException();
		
		if(product.getQuantity() == productAmount) {
			product.setQuantity(0);
			productRepository.save(product);
		}else if(product.getQuantity()> productAmount) {
			product.decreaseQuantity(productAmount);
			productRepository.save(product);
		}else {
			throw new NotEnoughProductException();
		}
	} 	
	public void completelyRemoveProductFromInventory(Long productId) {
		if(isProductNull(productRepository.findByProductId(productId))) throw new NoSuchProductFoundException(); 
		productRepository.deleteById(productId);
	}
	
	public void changeProductPrice(Long productId, BigDecimal price) {
		product = productRepository.findByProductId(productId);
		if(isProductNull(product)) throw new NoSuchProductFoundException();
		product.setPrice(price);
		productRepository.save(product);
	}
	
	public void changeProductName(Long productId, String newName) {
		product = productRepository.findByProductId(productId);
		if(isProductNull(product)) throw new NoSuchProductFoundException();
		product.setProductName(newName.replace("_", " "));
		productRepository.save(product);
	}
	
	public Product findProductById(Long productId){
		if(isProductNull(productRepository.findByProductId(productId))) throw new NoSuchProductFoundException();
		return productRepository.findByProductId(productId);
	}
	
	public List<Product> findProductByName(String name) {
		if(productRepository.findByProductName(name) == null) throw new NoSuchProductFoundException();
		List<Product> productsWithSameName = productRepository.findByProductName(name);
		
		for(int i = 0; i < productsWithSameName.size(); i++){
			product = productsWithSameName.get(i);
			product.getProductName().replace("_", " ");
		}
		return productsWithSameName;
	}
	
	public List<Product> getAllInventory(){
		return productRepository.findAll();
	}
	
	public List<Product> sortByPriceLowToHigh(){
		return productRepository.findAllByOrderByPriceAsc();
	}
	
	public List<Product> sortByPriceHighToLow(){
		return productRepository.findAllByOrderByPriceDesc();
	}
	
	public List<Product> searchInPriceRange(BigDecimal highPrice, BigDecimal lowPrice){
		return productRepository.findAllByPrices(highPrice, lowPrice);
	}
	
	public List<Product> searchByKeyword(String keyword){
		return productRepository.findProductsByKeyword(keyword);
	}
	
	private boolean isProductNull(Product product) {
		if(product == null) {
			return true;
		}
		return false;
	}
	
}