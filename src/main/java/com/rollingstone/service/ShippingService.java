package com.rollingstone.service;

import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.rollingstone.dao.ProductRepository;
import com.rollingstone.dao.ShippingRepository;
import com.rollingstone.domain.Product;
import com.rollingstone.domain.ROShipping;
import com.rollingstone.domain.ROShippingLineItem;
import com.rollingstone.domain.Shipping;
import com.rollingstone.domain.ShippingLineItem;

@Service
public class ShippingService {
	
	
	Logger logger  = LoggerFactory.getLogger("ShippingService");

	ShippingRepository shippingRepository;
	ProductRepository productRepository;

	public ShippingService(ShippingRepository shippingRepository, ProductRepository productRepository) {
		super();
		this.shippingRepository = shippingRepository;
		this.productRepository = productRepository;
	}
	
	
	public Shipping save(Shipping shipping) {
		
		logger.info("Shippinh ID 1 = "+ shipping.getShippingItems().size());
		
		Set<ShippingLineItem> lineItems = shipping.getShippingItems();
		
		logger.info("Shippinh ID 2 = "+ shipping.getShippingItems().size());

		
		for (ShippingLineItem liItem : lineItems) {
			liItem.setShippment(shipping);
		}
		
		logger.info("Shippinh ID 3 = "+ shipping.getShippingItems().size());

		
		Shipping shippingSaved = shippingRepository.save(shipping);
		
		logger.info("Shippinh ID 4 shippingSaved = "+ shippingSaved.getShippingItems().size());

		
		return shippingSaved;
	}
	
	public Page<Shipping> getShippingByPage(Integer pageNumber, Integer pageSize){
		
		Pageable pageable = PageRequest.of(pageNumber, pageSize, Sort.by("offerId").descending());
		
		
		return shippingRepository.findAll(pageable);		
		
	}
	
	public ROShipping getShipping(Long shippingId) {
		
		Optional<Shipping> shippingOptional =  shippingRepository.findById(shippingId);
		
		Shipping shipping = shippingOptional.get();
		
		Set<ShippingLineItem> shippingItems = shipping.getShippingItems();
		
		Set<ROShippingLineItem> roShippingItems = new HashSet<ROShippingLineItem>();
		
		for (ShippingLineItem lineItem : shippingItems) {
			Optional<Product> optionalProduct = productRepository.findById(lineItem.getProductId());
			
			Product product = optionalProduct.get();
			
			ROShippingLineItem roShippingItem = new ROShippingLineItem();
			
			roShippingItem.setId(lineItem.getId());
			roShippingItem.setProductCode(product.getProductCode());
			roShippingItem.setProductName(product.getProductName());
			roShippingItem.setQuantity(lineItem.getQuantity());
			roShippingItem.setUnitOfMeasurement(lineItem.getUnitOfMeasurement());
			roShippingItem.setUnitPrice(lineItem.getUnitPrice());
			
			roShippingItems.add(roShippingItem);
			
		}
		
		ROShipping roShipping = new ROShipping();
		
		roShipping.setAvailable(shipping.isAvailable());
		roShipping.setAvailableDate(shipping.getAvailableDate());
		roShipping.setDaysInTransit(shipping.getDaysInTransit());
		roShipping.setFree(shipping.isFree());
		roShipping.setFreeShippingForMembers(shipping.isFreeShippingForMembers());
		roShipping.setId(shipping.getId());
		roShipping.setOfferId(shipping.getOfferId());
		
		roShipping.setOrderDate(shipping.getOrder().getOrderDate());
		roShipping.setOrderNumber(shipping.getOrder().getOrderNumber());
		roShipping.setShipCarrier(shipping.getShipCarrier());
		roShipping.setShippingCharge(shipping.getShippingCharge());
		roShipping.setShippingMode(shipping.getShippingMode());
		roShipping.setShippingItems(roShippingItems);
		
		
		return roShipping;
	}
	
	public void deleteShipping(Long shippingId) {
		shippingRepository.deleteById(shippingId);
	}

}
