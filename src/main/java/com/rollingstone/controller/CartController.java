package com.rollingstone.controller;

import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.rollingstone.domain.Account;
import com.rollingstone.domain.Cart;
import com.rollingstone.service.CartService;

@RestController
public class CartController extends AbstractRestController {

	Logger logger  = LoggerFactory.getLogger("CartController");
	
	CartService cartService;
	
	public CartController(CartService cartService) {
		this.cartService = cartService;
	}
	
	@PostMapping("solcommerce/pdp-service/account/{accountId}/cart")
	@ResponseBody
	public Cart createCart(@RequestBody Cart cart) {
		Cart cartSaved  = cartService.save(cart);
		
		logger.info("Cart Saved :"+ cartSaved.toString());
		return cart;
	}
	
	@GetMapping("solcommerce/pdp-service/account/{accountId}/cart/{caertId}")
	public Cart get(@PathVariable("caertId") Long caertId) {
		
		Optional<Cart> cartRetreived  = cartService.getCart(caertId);
		Cart cart = cartRetreived.get();
		return cart;
	}
	
	@GetMapping("solcommerce/pdp-service/{accountId}/cart/bypage")
	Page<Cart> getCartsByPage(
			@RequestParam(value="pagenumber", required = true, defaultValue="0") Integer pageNumber,
			@RequestParam(value="pagesize", required = true, defaultValue="20") Integer pageSize)
	{
		return cartService.getCartByPage(pageNumber, pageSize);
	}
		
	@PutMapping("solcommerce/pdp-service/account/{accountId}/cart/{caertId}")
	@ResponseBody
	public Cart updateCart(@RequestBody Cart cart) {
		Cart cartUpdated  = cartService.save(cart);
		
		logger.info("Cart Updated :"+ cartUpdated.toString());
		return cartUpdated;
	}
	
	 /*---Delete a Cart by id---*/
	   @DeleteMapping("solcommerce/pdp-service/account/{accountId}/cart/{caertId}")
	   public ResponseEntity<?> delete(@PathVariable("caertId") long caertId) {
		   cartService.deleteCart(caertId);
	      return ResponseEntity.ok().body("Cart has been deleted successfully.");
	   }
}
