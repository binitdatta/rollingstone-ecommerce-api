package com.rollingstone.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.rollingstone.domain.ROShipping;
import com.rollingstone.domain.Shipping;
import com.rollingstone.service.ShippingService;

@RestController
public class ShippingController extends AbstractRestController {
Logger logger  = LoggerFactory.getLogger("ShippingController");
	
	ShippingService shippingService;
	
	public ShippingController(ShippingService shippingService) {
		this.shippingService = shippingService;
	}
	
	@PostMapping("solcommerce/pdp-service/account/{accountId}/order/{orderId}/shipping")
	@ResponseStatus(HttpStatus.CREATED)
	@ResponseBody
	public String createShipping(@RequestBody Shipping shipping) {
		Shipping shippingSaved  = shippingService.save(shipping);
		
		logger.info("Shipping Saved :"+ shippingSaved.toString());
		return shippingSaved.toString();
	}
	
	@GetMapping("solcommerce/pdp-service/account/{accountId}/order/{orderId}/shipping/{id}")
	public ROShipping get(@PathVariable("id") Long id) {
		
		ROShipping shipping  = shippingService.getShipping(id);
		return shipping;
	}
	
	@GetMapping("solcommerce/pdp-service/account/{accountId}/order/{orderId}/shipping/bypage")
	Page<Shipping> getShippingsByPage(
			@RequestParam(value="pagenumber", required = true, defaultValue="0") Integer pageNumber,
			@RequestParam(value="pagesize", required = true, defaultValue="20") Integer pageSize)
	{
		return shippingService.getShippingByPage(pageNumber, pageSize);
	}
	
	@PutMapping("solcommerce/pdp-service/account/{accountId}/order/{orderId}/shipping/{id}")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	@ResponseBody
	public String updateShipping(@RequestBody Shipping shipping) {
		Shipping shippingSaved  = shippingService.save(shipping);
		
		logger.info("Shipping Updated :"+ shippingSaved.toString());
		return shippingSaved.toString();
	}
	
	
	 /*---Delete a Shipping by id---*/
	   @DeleteMapping("solcommerce/pdp-service/account/{accountId}/order/{orderId}/shipping/{id}")
	   public ResponseEntity<?> delete(@PathVariable("id") long id) {
		   shippingService.deleteShipping(id);
	      return ResponseEntity.ok().body("Shipping has been deleted successfully.");
	   }
}
