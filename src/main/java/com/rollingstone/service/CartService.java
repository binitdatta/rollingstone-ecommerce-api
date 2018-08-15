package com.rollingstone.service;

import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.rollingstone.dao.CartRepository;
import com.rollingstone.domain.Cart;

@Service
public class CartService {

	CartRepository cartRepository;

	public CartService(CartRepository cartRepository) {
		super();
		this.cartRepository = cartRepository;
	}
	
/*	public CartService() {
		super();
		
	}*/
	
	public Cart save(Cart cart) {
		Cart cartSaved = cartRepository.save(cart);
		
		return cartSaved;
	}
	
	public Page<Cart> getCartByPage(Integer pageNumber, Integer pageSize){
		
		Pageable pageable = PageRequest.of(pageNumber, pageSize, Sort.by("cartTotal").descending());
		
		
		return cartRepository.findAll(pageable);		
		
	}
	
	public Optional<Cart> getCart(Long cartId) {
		
		return cartRepository.findById(cartId);
	}
	
	public void deleteCart(Long cartId) {
		cartRepository.deleteById(cartId);
	}
}
