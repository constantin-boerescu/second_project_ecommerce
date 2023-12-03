package com.secondproject.ecommerce.controller;


import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.secondproject.ecommerce.entity.WebOrder;
import com.secondproject.ecommerce.service.OrderService;

@RestController
@RequestMapping("/api/orders")
public class OrderController extends  GenericController<WebOrder, Long>{
	
	private final OrderService orderService;
	
	protected OrderController(OrderService orderService) {
		super(orderService);
		this.orderService = orderService;
	}
	@GetMapping("/active/{customerId}")
    public ResponseEntity<WebOrder> getOrCreateActiveOrder(@PathVariable Long customerId) {
		WebOrder order = orderService.selectOrCreateOrder(customerId);
        return ResponseEntity.ok(order);
    }
	
}
