package com.secondproject.ecommerce.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;


@Controller
public class WebController {
	@GetMapping("/products")
	public String products() {
		return "products";
	}
	
	@GetMapping("/new_product")
	public String new_product() {
		return "new_product";
	}
	
	@GetMapping("/product")
    public String productDetail() {
        
        return "product_detail"; 
	}
	@GetMapping("/select-customer")
    public String selectCustomer() {
        
        return "select_customer"; 
	}
	@GetMapping("/select-order")
    public String selecCurrentOrder() {
        
        return "select-order";
	}
	@GetMapping("/order-details")
    public String orderDetails() {
        
        return "order-details"; 
	}
	@GetMapping("/all-orders")
    public String allOrders() {
        
        return "all-orders"; 
	}
}
