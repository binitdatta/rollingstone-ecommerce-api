package com.rollingstone.service;

import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.rollingstone.dao.DeliveryRepository;
import com.rollingstone.domain.Delivery;

@Service
public class DeliveryService {

	Logger logger  = LoggerFactory.getLogger("DeliveryService");

	DeliveryRepository deliveryRepository;

	public DeliveryService(DeliveryRepository deliveryRepository) {
		super();
		this.deliveryRepository = deliveryRepository;
	}
	
	
	public Delivery save(Delivery delivery) {
		Delivery deliverySaved = deliveryRepository.save(delivery);
		
		return deliverySaved;
	}
	
	public Page<Delivery> getDeliveryByPage(Integer pageNumber, Integer pageSize){
		
		Pageable pageable = PageRequest.of(pageNumber, pageSize, Sort.by("productId").descending());
		
		
		return deliveryRepository.findAll(pageable);		
		
	}
	
	public Optional<Delivery> getDelivery(Long deliveryId) {
		
		logger.info("Delivery ID is :"+deliveryId);
		return deliveryRepository.findById(deliveryId);
	}
	
	public void deleteDelivery(Long deliveryId) {
		deliveryRepository.deleteById(deliveryId);
	}
}
