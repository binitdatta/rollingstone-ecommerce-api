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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.rollingstone.domain.Order;
import com.rollingstone.domain.ROOrder;
import com.rollingstone.service.OrderService;

@RestController
public class OrderController extends AbstractRestController {

	Logger logger  = LoggerFactory.getLogger("OrderController");
	
	OrderService orderService;
	
	public OrderController(OrderService orderService) {
		this.orderService = orderService;
	}
	
	@PostMapping("solcommerce/pdp-service/account/{accountId}/order")
	@ResponseBody
	public Order createOrder(@RequestBody Order order) {
		Order orderSaved  = orderService.save(order);
		
		logger.info("Order Saved :"+ orderSaved.toString());
		return order;
	}
	
	@GetMapping("solcommerce/pdp-service/account/{accountId}/order/{id}")
	@ResponseBody
	public ROOrder get(@PathVariable("id") Long id) {
		
		ROOrder orderRetreived  = orderService.getOrder(id);
		
		
		logger.info("Order Received is :"+orderRetreived.toString());
		return orderRetreived;
	}
	
	@GetMapping("solcommerce/pdp-service/account/{accountId}/order/bypage")
	@ResponseBody
	Page<Order> getOrdersByPage(
			@RequestParam(value="pagenumber", required = true, defaultValue="0") Integer pageNumber,
			@RequestParam(value="pagesize", required = true, defaultValue="20") Integer pageSize)
	{
		return orderService.getOrderByPage(pageNumber, pageSize);
	}
	
	@PutMapping("solcommerce/pdp-service/account/{accountId}/order/{id}")
	@ResponseBody
	public Order changeOrder(@RequestBody Order order) {
		Order changedOrder  = orderService.save(order);
		
		logger.info("Order Saved :"+ changedOrder.toString());
		return order;
	}
	
	 /*---Delete a Order by id---*/
	   @DeleteMapping("solcommerce/pdp-service/account/{accountId}/order/{id}")
	   public ResponseEntity<?> delete(@PathVariable("id") long id) {
		   orderService.deleteOrder(id);
	      return ResponseEntity.ok().body("Order has been deleted successfully.");
	   }
}
