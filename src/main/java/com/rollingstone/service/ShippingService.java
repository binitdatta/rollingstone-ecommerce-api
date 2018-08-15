package com.rollingstone.service;

import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.rollingstone.dao.ShippingRepository;
import com.rollingstone.domain.Shipping;

@Service
public class ShippingService {
	

	ShippingRepository shippingRepository;

	public ShippingService(ShippingRepository shippingRepository) {
		super();
		this.shippingRepository = shippingRepository;
	}
	
	public ShippingService() {
		super();
		
	}
	
	public Shipping save(Shipping shipping) {
		Shipping shippingSaved = shippingRepository.save(shipping);
		
		return shippingSaved;
	}
	
	public Page<Shipping> getShippingByPage(Integer pageNumber, Integer pageSize){
		
		Pageable pageable = PageRequest.of(pageNumber, pageSize, Sort.by("houseNumber").descending());
		
		
		return shippingRepository.findAll(pageable);		
		
	}
	
	public Optional<Shipping> getShipping(Long shippingId) {
		
		return shippingRepository.findById(shippingId);
	}
	
	public void deleteShipping(Long shippingId) {
		shippingRepository.deleteById(shippingId);
	}

}
