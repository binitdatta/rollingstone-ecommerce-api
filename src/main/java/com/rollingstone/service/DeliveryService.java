package com.rollingstone.service;

import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.rollingstone.dao.DeliveryRepository;
import com.rollingstone.domain.Delivery;

@Service
public class DeliveryService {

	DeliveryRepository deliveryRepository;

	public DeliveryService(DeliveryRepository deliveryRepository) {
		super();
		this.deliveryRepository = deliveryRepository;
	}
	
	public DeliveryService() {
		super();
		
	}
	
	public Delivery save(Delivery delivery) {
		Delivery deliverySaved = deliveryRepository.save(delivery);
		
		return deliverySaved;
	}
	
	public Page<Delivery> getDeliveryByPage(Integer pageNumber, Integer pageSize){
		
		Pageable pageable = PageRequest.of(pageNumber, pageSize, Sort.by("houseNumber").descending());
		
		
		return deliveryRepository.findAll(pageable);		
		
	}
	
	public Optional<Delivery> getDelivery(Long deliveryId) {
		
		return deliveryRepository.findById(deliveryId);
	}
	
	public void deleteDelivery(Long deliveryId) {
		deliveryRepository.deleteById(deliveryId);
	}
}
