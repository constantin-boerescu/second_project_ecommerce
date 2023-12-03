package com.secondproject.ecommerce.service;


import org.springframework.stereotype.Service;

import com.secondproject.ecommerce.entity.Customer;
import com.secondproject.ecommerce.exception.ResourceNotFoundException;
import com.secondproject.ecommerce.repository.CustomerRepository;

import jakarta.transaction.Transactional;

@Service
public class CustomerService extends GenericService<Customer, Long>{
	
	private  final CustomerRepository customerRepository;
	

	public CustomerService(CustomerRepository customerRepository) {
		super(customerRepository);
		this.customerRepository = customerRepository;
	}
}
