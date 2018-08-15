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

import com.rollingstone.domain.Delivery;
import com.rollingstone.service.DeliveryService;

@RestController
@RequestMapping(value="solcommerce/pdp-service/account/{accountId}/order/{orderId}/delivery")
public class DeliveryController {

Logger logger  = LoggerFactory.getLogger("DeliveryController");
	
	DeliveryService deliveryService;
	
	public DeliveryController(DeliveryService deliveryService) {
		this.deliveryService = deliveryService;
	}
	
	@PostMapping
	@ResponseBody
	public Delivery createDelivery(@RequestBody Delivery delivery) {
		Delivery deliverySaved  = deliveryService.save(delivery);
		
		logger.info("Delivery Saved :"+ deliverySaved.toString());
		return delivery;
	}
	
	@GetMapping
	public Delivery get(@PathVariable("id") Long id) {
		
		Optional<Delivery> deliveryRetreived  = deliveryService.getDelivery(id);
		Delivery delivery = deliveryRetreived.get();
		return delivery;
	}
	
	Page<Delivery> getDeliverysByPage(
			@RequestParam(value="pagenumber", required = true, defaultValue="0") Integer pageNumber,
			@RequestParam(value="pagesize", required = true, defaultValue="20") Integer pageSize)
	{
		return deliveryService.getDeliveryByPage(pageNumber, pageSize);
	}
		
	
	 /*---Delete a Delivery by id---*/
	   @DeleteMapping("/delivery/{id}")
	   public ResponseEntity<?> delete(@PathVariable("id") long id) {
		   deliveryService.deleteDelivery(id);
	      return ResponseEntity.ok().body("Delivery has been deleted successfully.");
	   }
}
