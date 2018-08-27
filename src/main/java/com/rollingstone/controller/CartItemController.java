package com.rollingstone.controller;

import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.rollingstone.domain.CartItem;
import com.rollingstone.domain.IsolatedCartItem;
import com.rollingstone.service.CartItemService;

@RestController
public class CartItemController extends AbstractRestController {

	Logger logger  = LoggerFactory.getLogger("CartItemController");
	
	CartItemService cartItemService;
	
	public CartItemController(CartItemService cartItemService) {
		this.cartItemService = cartItemService;
	}
	
	@PostMapping("solcommerce/pdp-service/account/{accountId}/cart/{cartId}/cartitem")
	@ResponseBody
	public IsolatedCartItem createCartItem(@RequestBody IsolatedCartItem cartItem) {
		IsolatedCartItem cartItemSaved  = cartItemService.save(cartItem);
		
		logger.info("CartItem Saved :"+ cartItemSaved.toString());
		return cartItem;
	}
	
	@GetMapping("solcommerce/pdp-service/account/{accountId}/cart/{cartId}/cartitem/{id}")
	public IsolatedCartItem get(@PathVariable("id") Long id) {
		
		Optional<IsolatedCartItem> cartItemRetrieved  = cartItemService.getCartItem(id);
		IsolatedCartItem cartItem = cartItemRetrieved.get();
		return cartItem;
	}
	
	@PutMapping("solcommerce/pdp-service/account/{accountId}/cart/{cartId}/cartitem/{id}")
	@ResponseBody
	public IsolatedCartItem updateCart(@RequestBody IsolatedCartItem cartItem) {
		IsolatedCartItem cartItemUpdated  = cartItemService.save(cartItem);
		
		logger.info("CartItem Updated :"+ cartItemUpdated.toString());
		return cartItemUpdated;
	}
		
	
	 /*---Delete a CartItem by id---*/
	   @DeleteMapping("solcommerce/pdp-service/account/{accountId}/cart/{cartId}/cartitem/{id}")
	   public ResponseEntity<?> delete(@PathVariable("id") long id) {
		   cartItemService.deleteCartItem(id);
	      return ResponseEntity.ok().body("CartItem has been deleted successfully.");
	   }
}
