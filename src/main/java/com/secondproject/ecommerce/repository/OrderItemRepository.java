package com.secondproject.ecommerce.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.secondproject.ecommerce.entity.OrderItem;


@Repository
public interface OrderItemRepository extends JpaRepository<OrderItem, Long>{

	List<OrderItem> getOrderItemsByOrderId(Long orderId);

}
