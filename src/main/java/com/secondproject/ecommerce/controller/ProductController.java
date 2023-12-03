package com.secondproject.ecommerce.controller;



import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.secondproject.ecommerce.entity.Product;
import com.secondproject.ecommerce.service.ProductService;

@RestController
@RequestMapping("/api/products")
public class ProductController extends GenericController<Product, Long> {

	private final ProductService productService;
	
	public ProductController(ProductService productService) {
		super(productService);
		this.productService = productService;
	}


}
