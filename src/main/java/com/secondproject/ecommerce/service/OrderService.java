package com.secondproject.ecommerce.service;





import java.util.Date;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.secondproject.ecommerce.entity.Customer;
import com.secondproject.ecommerce.entity.WebOrder;
import com.secondproject.ecommerce.exception.ResourceNotFoundException;
import com.secondproject.ecommerce.repository.CustomerRepository;
import com.secondproject.ecommerce.repository.OrderRepository;
import jakarta.transaction.Transactional;


@Service
public class OrderService extends GenericService<WebOrder, Long>{
	private final OrderRepository orderRepository;
	private final CustomerRepository customerRepository;
	
	protected OrderService(OrderRepository orderRepository, CustomerRepository customerRepository) {
		super(orderRepository);
		this.orderRepository = orderRepository;
		this.customerRepository = customerRepository;
	}
	
	@Transactional
	public WebOrder selectOrCreateOrder(Long customerId) {
		Customer customer = customerRepository.findById(customerId).orElseThrow(() -> new ResourceNotFoundException("Customer", "id", customerId));
		Optional<WebOrder> activeOrder = orderRepository.findActiveOrderByCustomerId(customerId);
		if (activeOrder.isPresent() && activeOrder.get().getStatus() == "Active") {
            return activeOrder.get();
        } else {

        	WebOrder newOrder = new WebOrder();
            newOrder.setCustomer(customer);
            newOrder.setStatus("Active");
            newOrder.setOrderDate(new Date());
            return orderRepository.save(newOrder);
        }
    }
		
		
	
}
	
	

