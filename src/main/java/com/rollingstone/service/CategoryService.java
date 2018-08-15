package com.rollingstone.service;

import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.rollingstone.dao.CategoryRepository;
import com.rollingstone.domain.Category;

@Service
public class CategoryService {

	CategoryRepository cartRepository;

	public CategoryService(CategoryRepository cartRepository) {
		super();
		this.cartRepository = cartRepository;
	}
	
/*	public CategoryService() {
		super();
		
	}*/
	
	public Category save(Category cart) {
		Category cartSaved = cartRepository.save(cart);
		
		return cartSaved;
	}
	
	public Page<Category> getCategoryByPage(Integer pageNumber, Integer pageSize){
		
		Pageable pageable = PageRequest.of(pageNumber, pageSize, Sort.by("categoryName").descending());
		
		
		return cartRepository.findAll(pageable);		
		
	}
	
	public Optional<Category> getCategory(Long cartId) {
		
		return cartRepository.findById(cartId);
	}
	
	public void deleteCategory(Long cartId) {
		cartRepository.deleteById(cartId);
	}
}
