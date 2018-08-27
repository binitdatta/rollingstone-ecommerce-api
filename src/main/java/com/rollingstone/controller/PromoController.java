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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.rollingstone.domain.Promo;
import com.rollingstone.service.PromoService;

@RestController
public class PromoController extends AbstractRestController {

Logger logger  = LoggerFactory.getLogger("PromoController");
	
	PromoService promoService;
	
	public PromoController(PromoService promoService) {
		this.promoService = promoService;
	}
	
	@PostMapping("solcommerce/pdp-service/promo/")
	@ResponseBody
	public Promo createPromo(@RequestBody Promo promo) {
		Promo promoSaved  = promoService.save(promo);
		
		logger.info("Promo Saved :"+ promoSaved.toString());
		return promo;
	}
	
	@GetMapping("solcommerce/pdp-service/promo/{id}")
	public Promo get(@PathVariable("id") Long id) {
		
		Optional<Promo> promoRetreived  = promoService.getPromo(id);
		Promo promo = promoRetreived.get();
		return promo;
	}
	
	@GetMapping("solcommerce/pdp-service/promo/bypage")
	Page<Promo> getPromosByPage(
			@RequestParam(value="pagenumber", required = true, defaultValue="0") Integer pageNumber,
			@RequestParam(value="pagesize", required = true, defaultValue="20") Integer pageSize)
	{
		return promoService.getPromoByPage(pageNumber, pageSize);
	}
	

	@PutMapping("solcommerce/pdp-service/promo/{id}")
	@ResponseBody
	public Promo updatePromo(@RequestBody Promo promo) {
		Promo promoSaved  = promoService.save(promo);
		
		logger.info("Promo Updated :"+ promoSaved.toString());
		return promo;
	}
	
	
	 /*---Delete a Promo by id---*/
	   @DeleteMapping("solcommerce/pdp-service/promo/{id}")
	   public ResponseEntity<?> delete(@PathVariable("id") long id) {
		   promoService.deletePromo(id);
	      return ResponseEntity.ok().body("Promo has been deleted successfully.");
	   }
}
