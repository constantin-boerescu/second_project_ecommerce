package com.secondproject.ecommerce.controller;




import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.secondproject.ecommerce.entity.Customer;
import com.secondproject.ecommerce.service.CustomerService;




@RestController
@RequestMapping("/api/customers")
public class CustomerController extends GenericController<Customer, Long>{
	
	private final CustomerService customerService;

	public CustomerController(CustomerService customerService) {
		super(customerService);
		this.customerService = customerService;
	}

	
}
