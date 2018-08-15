package com.rollingstone.service;

import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.rollingstone.dao.OrderRepository;
import com.rollingstone.domain.Order;

@Service
public class OrderService {

	OrderRepository orderRepository;

	public OrderService(OrderRepository orderRepository) {
		super();
		this.orderRepository = orderRepository;
	}
	
	public OrderService() {
		super();
		
	}
	
	public Order save(Order order) {
		Order orderSaved = orderRepository.save(order);
		
		return orderSaved;
	}
	
	public Page<Order> getOrderByPage(Integer pageNumber, Integer pageSize){
		
		Pageable pageable = PageRequest.of(pageNumber, pageSize, Sort.by("houseNumber").descending());
		
		
		return orderRepository.findAll(pageable);		
		
	}
	
	public Optional<Order> getOrder(Long orderId) {
		
		return orderRepository.findById(orderId);
	}
	
	public void deleteOrder(Long orderId) {
		orderRepository.deleteById(orderId);
	}
}
