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

import com.rollingstone.domain.Category;
import com.rollingstone.domain.Delivery;
import com.rollingstone.service.DeliveryService;

@RestController
public class DeliveryController extends AbstractRestController {

	Logger logger  = LoggerFactory.getLogger("DeliveryController");
	
	DeliveryService deliveryService;
	
	public DeliveryController(DeliveryService deliveryService) {
		this.deliveryService = deliveryService;
	}
	
	@PostMapping("solcommerce/pdp-service/account/{accountId}/order/{orderId}/delivery")
	@ResponseBody
	public Delivery createDelivery(@RequestBody Delivery delivery) {
		Delivery deliverySaved  = deliveryService.save(delivery);
		
		logger.info("Delivery Saved :"+ deliverySaved.toString());
		return delivery;
	}
	
	@GetMapping("solcommerce/pdp-service/account/{accountId}/order/{orderId}/delivery/{deliveryId}")
	public Delivery get(@PathVariable("deliveryId") Long deliveryId) {
		
		if (deliveryService == null ) {
			logger.info("Delivery Service is null ");
		}
		else {
			logger.info("Delivery Service is not null ");
		}
				
		
		Optional<Delivery> deliveryRetreived  = deliveryService.getDelivery(deliveryId);
		Delivery delivery = deliveryRetreived.get();
		return delivery;
	}
	
	@GetMapping("solcommerce/pdp-service/account/{accountId}/order/{orderId}/delivery/bypage")
	Page<Delivery> getDeliverysByPage(
			@RequestParam(value="pagenumber", required = true, defaultValue="0") Integer pageNumber,
			@RequestParam(value="pagesize", required = true, defaultValue="20") Integer pageSize)
	{
		return deliveryService.getDeliveryByPage(pageNumber, pageSize);
	}
	
	@PutMapping("solcommerce/pdp-service/account/{accountId}/order/{orderId}/delivery/{deliveryId}")
	@ResponseBody
	public Delivery updateCategory(@RequestBody Delivery delivery) {
		Delivery deliveryUpdated  = deliveryService.save(delivery);
		
		logger.info("Delivery Updated :"+ deliveryUpdated.toString());
		return deliveryUpdated;
	}
	
	 /*---Delete a Delivery by id---*/
	   @DeleteMapping("solcommerce/pdp-service/account/{accountId}/order/{orderId}/delivery/{deliveryId}")
	   public ResponseEntity<?> delete(@PathVariable("deliveryId") long id) {
		   deliveryService.deleteDelivery(id);
	      return ResponseEntity.ok().body("Delivery has been deleted successfully.");
	   }
}
