package com.secondproject.ecommerce.controller;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.secondproject.ecommerce.entity.OrderItem;
import com.secondproject.ecommerce.service.OrderItemService;


@RestController
@RequestMapping("api/order-item")
public class OrderItemController extends GenericController<OrderItem, Long>{
	
	private final OrderItemService orderItemService;
	
	public OrderItemController(OrderItemService orderItemService) {
		super(orderItemService);
		this.orderItemService = orderItemService;

	}
	
	@GetMapping("/items/{orderId}")
	public ResponseEntity<List<OrderItem>> getOrderItems(@PathVariable Long orderId) {
		List<OrderItem> items = orderItemService.getOrderItemsByOrderId(orderId);
        if (items.isEmpty()) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(items);
	}

}
