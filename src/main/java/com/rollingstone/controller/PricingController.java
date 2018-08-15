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

import com.rollingstone.domain.Pricing;
import com.rollingstone.service.PricingService;

@RestController
@RequestMapping(value="solcommerce/pdp-service/pricing/")
public class PricingController {

	Logger logger  = LoggerFactory.getLogger("PricingController");
	
	PricingService pricingService;
	
	public PricingController(PricingService pricingService) {
		this.pricingService = pricingService;
	}
	
	@PostMapping
	@ResponseBody
	public Pricing createPricing(@RequestBody Pricing pricing) {
		Pricing pricingSaved  = pricingService.save(pricing);
		
		logger.info("Pricing Saved :"+ pricingSaved.toString());
		return pricing;
	}
	
	@GetMapping
	public Pricing get(@PathVariable("id") Long id) {
		
		Optional<Pricing> pricingRetreived  = pricingService.getPricing(id);
		Pricing pricing = pricingRetreived.get();
		return pricing;
	}
	
	Page<Pricing> getPricingsByPage(
			@RequestParam(value="pagenumber", required = true, defaultValue="0") Integer pageNumber,
			@RequestParam(value="pagesize", required = true, defaultValue="20") Integer pageSize)
	{
		return pricingService.getPricingByPage(pageNumber, pageSize);
	}
		
	
	 /*---Delete a Pricing by id---*/
	   @DeleteMapping("/pricing/{id}")
	   public ResponseEntity<?> delete(@PathVariable("id") long id) {
		   pricingService.deletePricing(id);
	      return ResponseEntity.ok().body("Pricing has been deleted successfully.");
	   }
}
