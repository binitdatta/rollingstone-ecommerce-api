package com.rollingstone.service;

import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.rollingstone.dao.CartItemRepository;
import com.rollingstone.domain.CartItem;
import com.rollingstone.domain.IsolatedCartItem;

@Service
public class CartItemService {
	
	Logger logger  = LoggerFactory.getLogger("CartItemService");


	CartItemRepository cartItemRepository;

	public CartItemService(CartItemRepository cartItemRepository) {
		super();
		this.cartItemRepository = cartItemRepository;
	}
	
	
	public IsolatedCartItem save(IsolatedCartItem cartItem) {
		if (cartItem.getCartId() != null) {
			logger.info("Cart ID :" + cartItem.getCartId());
			
		}
		IsolatedCartItem cartItemSaved = cartItemRepository.save(cartItem);
		
		return cartItemSaved;
	}
	
	public Page<IsolatedCartItem> getCartItemByPage(Integer pageNumber, Integer pageSize){
		
		Pageable pageable = PageRequest.of(pageNumber, pageSize, Sort.by("houseNumber").descending());
		
		
		return cartItemRepository.findAll(pageable);		
		
	}
	
	public Optional<IsolatedCartItem> getCartItem(Long cartItemId) {
		
		return cartItemRepository.findById(cartItemId);
	}
	
	public void deleteCartItem(Long cartItemId) {
		cartItemRepository.deleteById(cartItemId);
	}
}
