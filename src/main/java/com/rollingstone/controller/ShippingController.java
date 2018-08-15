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
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.rollingstone.domain.Shipping;
import com.rollingstone.service.ShippingService;

@RestController
@RequestMapping(value="solcommerce/pdp-service/account/{accountId}/order/{orderId}/shipping")
public class ShippingController {

Logger logger  = LoggerFactory.getLogger("ShippingController");
	
	ShippingService shippingService;
	
	public ShippingController(ShippingService shippingService) {
		this.shippingService = shippingService;
	}
	
	@PostMapping
	@ResponseBody
	public Shipping createShipping(@RequestBody Shipping shipping) {
		Shipping shippingSaved  = shippingService.save(shipping);
		
		logger.info("Shipping Saved :"+ shippingSaved.toString());
		return shipping;
	}
	
	@GetMapping
	public Shipping get(@PathVariable("id") Long id) {
		
		Optional<Shipping> shippingRetreived  = shippingService.getShipping(id);
		Shipping shipping = shippingRetreived.get();
		return shipping;
	}
	
	Page<Shipping> getShippingsByPage(
			@RequestParam(value="pagenumber", required = true, defaultValue="0") Integer pageNumber,
			@RequestParam(value="pagesize", required = true, defaultValue="20") Integer pageSize)
	{
		return shippingService.getShippingByPage(pageNumber, pageSize);
	}
		
	
	 /*---Delete a Shipping by id---*/
	   @DeleteMapping("/shipping/{id}")
	   public ResponseEntity<?> delete(@PathVariable("id") long id) {
		   shippingService.deleteShipping(id);
	      return ResponseEntity.ok().body("Shipping has been deleted successfully.");
	   }
}
