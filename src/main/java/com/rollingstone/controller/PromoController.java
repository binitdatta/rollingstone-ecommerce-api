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

import com.rollingstone.domain.Promo;
import com.rollingstone.service.PromoService;

@RestController
@RequestMapping(value="solcommerce/pdp-service/promo/")
public class PromoController {

Logger logger  = LoggerFactory.getLogger("PromoController");
	
	PromoService promoService;
	
	public PromoController(PromoService promoService) {
		this.promoService = promoService;
	}
	
	@PostMapping
	@ResponseBody
	public Promo createPromo(@RequestBody Promo promo) {
		Promo promoSaved  = promoService.save(promo);
		
		logger.info("Promo Saved :"+ promoSaved.toString());
		return promo;
	}
	
	@GetMapping
	public Promo get(@PathVariable("id") Long id) {
		
		Optional<Promo> promoRetreived  = promoService.getPromo(id);
		Promo promo = promoRetreived.get();
		return promo;
	}
	
	Page<Promo> getPromosByPage(
			@RequestParam(value="pagenumber", required = true, defaultValue="0") Integer pageNumber,
			@RequestParam(value="pagesize", required = true, defaultValue="20") Integer pageSize)
	{
		return promoService.getPromoByPage(pageNumber, pageSize);
	}
		
	
	 /*---Delete a Promo by id---*/
	   @DeleteMapping("/promo/{id}")
	   public ResponseEntity<?> delete(@PathVariable("id") long id) {
		   promoService.deletePromo(id);
	      return ResponseEntity.ok().body("Promo has been deleted successfully.");
	   }
}
