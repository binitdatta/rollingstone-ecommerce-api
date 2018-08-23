package com.rollingstone.service;

import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.rollingstone.dao.StorePickupRepository;
import com.rollingstone.domain.StorePickup;
@Service
public class StorePickupService {

	StorePickupRepository storePickupRepository;

	public StorePickupService(StorePickupRepository storePickupRepository) {
		super();
		this.storePickupRepository = storePickupRepository;
	}
	

	
	public StorePickup save(StorePickup storePickup) {
		StorePickup storePickupSaved = storePickupRepository.save(storePickup);
		
		return storePickupSaved;
	}
	
	public Page<StorePickup> getStorePickupByPage(Integer pageNumber, Integer pageSize){
		
		Pageable pageable = PageRequest.of(pageNumber, pageSize, Sort.by("storeNumber").descending());
		
		
		return storePickupRepository.findAll(pageable);		
		
	}
	
	public Optional<StorePickup> getStorePickup(Long storePickupId) {
		
		return storePickupRepository.findById(storePickupId);
	}
	
	public void deleteStorePickup(Long storePickupId) {
		storePickupRepository.deleteById(storePickupId);
	}
}
