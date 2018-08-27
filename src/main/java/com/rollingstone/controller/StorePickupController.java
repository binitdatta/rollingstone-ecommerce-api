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

import com.rollingstone.domain.StorePickup;
import com.rollingstone.service.StorePickupService;

@RestController
public class StorePickupController extends AbstractRestController {
	
	Logger logger  = LoggerFactory.getLogger("StorePickupController");
	
	StorePickupService storePickupService;
	
	public StorePickupController(StorePickupService storePickupService) {
		this.storePickupService = storePickupService;
	}
	
	@PostMapping("solcommerce/pdp-service/spu/")
	@ResponseBody
	public StorePickup createStorePickup(@RequestBody StorePickup storePickup) {
		StorePickup storePickupSaved  = storePickupService.save(storePickup);
		
		logger.info("StorePickup Saved :"+ storePickupSaved.toString());
		return storePickup;
	}
	
	@GetMapping("solcommerce/pdp-service/spu/{id}")
	public StorePickup get(@PathVariable("id") Long id) {
		
		Optional<StorePickup> storePickupRetreived  = storePickupService.getStorePickup(id);
		StorePickup storePickup = storePickupRetreived.get();
		return storePickup;
	}
	
	@GetMapping("solcommerce/pdp-service/spu/bypage")
	Page<StorePickup> getStorePickupsByPage(
			@RequestParam(value="pagenumber", required = true, defaultValue="0") Integer pageNumber,
			@RequestParam(value="pagesize", required = true, defaultValue="20") Integer pageSize)
	{
		return storePickupService.getStorePickupByPage(pageNumber, pageSize);
	}
	
	@PutMapping("solcommerce/pdp-service/spu/{id}")
	@ResponseBody
	public StorePickup updateStorePickup(@RequestBody StorePickup storePickup) {
		StorePickup storePickupSaved  = storePickupService.save(storePickup);
		
		logger.info("StorePickup Updated :"+ storePickupSaved.toString());
		return storePickup;
	}
	
	
	 /*---Delete a StorePickup by id---*/
	   @DeleteMapping("solcommerce/pdp-service/spu/{id}")
	   public ResponseEntity<?> delete(@PathVariable("id") long id) {
		   storePickupService.deleteStorePickup(id);
	      return ResponseEntity.ok().body("StorePickup has been deleted successfully.");
	   }

}
