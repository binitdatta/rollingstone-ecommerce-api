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
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.rollingstone.domain.Order;
import com.rollingstone.service.OrderService;

@RestController
@RequestMapping(value="solcommerce/pdp-service/account/{accountId}/order")
public class OrderController {

	Logger logger  = LoggerFactory.getLogger("OrderController");
	
	OrderService orderService;
	
	public OrderController(OrderService orderService) {
		this.orderService = orderService;
	}
	
	@PostMapping
	@ResponseBody
	public Order createOrder(@RequestBody Order order) {
		Order orderSaved  = orderService.save(order);
		
		logger.info("Order Saved :"+ orderSaved.toString());
		return order;
	}
	
	@GetMapping
	public Order get(@PathVariable("id") Long id) {
		
		Optional<Order> orderRetreived  = orderService.getOrder(id);
		Order order = orderRetreived.get();
		return order;
	}
	
	Page<Order> getOrdersByPage(
			@RequestParam(value="pagenumber", required = true, defaultValue="0") Integer pageNumber,
			@RequestParam(value="pagesize", required = true, defaultValue="20") Integer pageSize)
	{
		return orderService.getOrderByPage(pageNumber, pageSize);
	}
		
	
	 /*---Delete a Order by id---*/
	   @DeleteMapping("/order/{id}")
	   public ResponseEntity<?> delete(@PathVariable("id") long id) {
		   orderService.deleteOrder(id);
	      return ResponseEntity.ok().body("Order has been deleted successfully.");
	   }
}
