package com.rollingstone.service;

import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.rollingstone.dao.ProductRepository;
import com.rollingstone.domain.Product;

@Service
public class ProductService {

	ProductRepository productRepository;

	public ProductService(ProductRepository productRepository) {
		super();
		this.productRepository = productRepository;
	}
	
	/*public ProductService() {
		super();
		
	}*/
	
	public Product save(Product product) {
		Product productSaved = productRepository.save(product);
		
		return productSaved;
	}
	
	public Page<Product> getProductByPage(Integer pageNumber, Integer pageSize){
		
		Pageable pageable = PageRequest.of(pageNumber, pageSize, Sort.by("productName").descending());
		
		
		return productRepository.findAll(pageable);		
		
	}
	
	public Optional<Product> getProduct(Long productId) {
		
		return productRepository.findById(productId);
	}
	
	public void deleteProduct(Long productId) {
		productRepository.deleteById(productId);
	}
}
