package com.rollingstone.service;

import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.rollingstone.dao.CartItemRepository;
import com.rollingstone.domain.CartItem;

@Service
public class CartItemService {

	CartItemRepository cartItemRepository;

	public CartItemService(CartItemRepository cartItemRepository) {
		super();
		this.cartItemRepository = cartItemRepository;
	}
	
/*	public CartItemService() {
		super();
		
	}*/
	
	public CartItem save(CartItem cartItem) {
		CartItem cartItemSaved = cartItemRepository.save(cartItem);
		
		return cartItemSaved;
	}
	
	public Page<CartItem> getCartItemByPage(Integer pageNumber, Integer pageSize){
		
		Pageable pageable = PageRequest.of(pageNumber, pageSize, Sort.by("houseNumber").descending());
		
		
		return cartItemRepository.findAll(pageable);		
		
	}
	
	public Optional<CartItem> getCartItem(Long cartItemId) {
		
		return cartItemRepository.findById(cartItemId);
	}
	
	public void deleteCartItem(Long cartItemId) {
		cartItemRepository.deleteById(cartItemId);
	}
}
