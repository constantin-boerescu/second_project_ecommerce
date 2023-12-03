package com.secondproject.ecommerce.service;

import com.secondproject.ecommerce.entity.Product;
import com.secondproject.ecommerce.repository.ProductRepository;
import org.springframework.stereotype.Service;
import jakarta.transaction.Transactional;

@Service
public class ProductService extends GenericService<Product, Long> {

    private final ProductRepository productRepository;

    public ProductService(ProductRepository productRepository) {
        super(productRepository);
        this.productRepository = productRepository;
    }

    

}
