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

import com.rollingstone.dao.OrderRepository;
import com.rollingstone.domain.Order;
import com.rollingstone.domain.OrderLineItem;
import com.rollingstone.domain.ROOrder;
import com.rollingstone.domain.ROrderLineItem;

@Service
public class OrderService {

	Logger logger  = LoggerFactory.getLogger("OrderService");

	OrderRepository orderRepository;

	public OrderService(OrderRepository orderRepository) {
		super();
		this.orderRepository = orderRepository;
	}
	
	
	public Order save(Order order) {
		Order orderSaved = orderRepository.save(order);
		
		return orderSaved;
	}
	
	public Page<Order> getOrderByPage(Integer pageNumber, Integer pageSize){
		
		Pageable pageable = PageRequest.of(pageNumber, pageSize, Sort.by("orderNumber").descending());
		
		
		return orderRepository.findAll(pageable);		
		
	}
	
	public ROOrder getOrder(Long orderId) {
		
		Optional<Order> optinoalOrder =  orderRepository.findById(orderId);
		
		Order order = optinoalOrder.get();
		
		ROOrder roOder = new ROOrder();
		
		roOder.setId(order.getId());
		roOder.setAccountName(order.getAccount().getAccountName());
		roOder.setAccountNumber(order.getAccount().getAccountNumber());
		roOder.setBillingCity(order.getBillingAddress().getCity());
		roOder.setBillingHouseNumber(order.getBillingAddress().getHouseNumber());
		roOder.setBillingState(order.getBillingAddress().getState());
		roOder.setBillingStreetAddress(order.getBillingAddress().getState());
		roOder.setBillingStreetAddress(order.getBillingAddress().getStreetAddress());
		roOder.setBillingZipCode(order.getBillingAddress().getZipCode());
		
		roOder.setShippingCity(order.getShippingAddress().getCity());
		roOder.setShippingHouseNumber(order.getShippingAddress().getHouseNumber());
		roOder.setShippingState(order.getShippingAddress().getState());
		roOder.setShippingStreetAddress(order.getShippingAddress().getStreetAddress());
		roOder.setShippingZipCode(order.getShippingAddress().getZipCode());
		
		roOder.setUserName(order.getUser().getUserName());
		roOder.setFirstName(order.getUser().getFirstName());
		roOder.setLastName(order.getUser().getLastName());
		roOder.setSex(order.getUser().getSex());
		
		roOder.setOrderDate(order.getOrderDate());
		roOder.setOrderNumber(order.getOrderNumber());
		roOder.setOrderTotal(order.getOrderTotal());
		roOder.setOrderTrackingNumber(order.getOrderTrackingNumber());
		
		Set<OrderLineItem> orderItemsFromDB = order.getOrderItems();
		
		Set<ROrderLineItem> orderItems = new HashSet<ROrderLineItem>();
		
		for (OrderLineItem orderItemDB : orderItemsFromDB) {
			ROrderLineItem orderItem = new ROrderLineItem();
			
			orderItem.setId(orderItemDB.getId());
			orderItem.setProductCode(orderItemDB.getProduct().getProductCode());
			orderItem.setQuantity(orderItemDB.getQuantity());
			orderItem.setUnitOfMeasurement(orderItemDB.getUnitOfMeasurement());
			orderItem.setUnitPrice(orderItemDB.getUnitPrice());

			orderItems.add(orderItem);
		}
		roOder.setOrderItems(orderItems);
		
		return roOder;
	}
	
	public void deleteOrder(Long orderId) {
		orderRepository.deleteById(orderId);
	}
}
