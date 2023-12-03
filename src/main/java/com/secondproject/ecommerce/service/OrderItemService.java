package com.secondproject.ecommerce.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.secondproject.ecommerce.entity.OrderItem;
import com.secondproject.ecommerce.repository.OrderItemRepository;
@Service
public class OrderItemService extends GenericService<OrderItem, Long>{
	private final OrderItemRepository orderItemRepository;
	
	protected OrderItemService(OrderItemRepository orderItemRepository) {
		super(orderItemRepository);
		this.orderItemRepository = orderItemRepository;
	}

	public List<OrderItem> getOrderItemsByOrderId(Long orderId) {
		return orderItemRepository.getOrderItemsByOrderId(orderId);
	}
	
}
