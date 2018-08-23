package com.rollingstone.service;

import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.rollingstone.dao.PricingRepository;
import com.rollingstone.domain.Pricing;

@Service
public class PricingService {

	PricingRepository pricingRepository;

	public PricingService(PricingRepository pricingRepository) {
		super();
		this.pricingRepository = pricingRepository;
	}
	
	
	
	public Pricing save(Pricing pricing) {
		Pricing pricingSaved = pricingRepository.save(pricing);
		
		return pricingSaved;
	}
	
	public Page<Pricing> getPricingByPage(Integer pageNumber, Integer pageSize){
		
		Pageable pageable = PageRequest.of(pageNumber, pageSize, Sort.by("productCode").descending());
		
		
		return pricingRepository.findAll(pageable);		
		
	}
	
	public Optional<Pricing> getPricing(Long pricingId) {
		
		return pricingRepository.findById(pricingId);
	}
	
	public void deletePricing(Long pricingId) {
		pricingRepository.deleteById(pricingId);
	}
}
