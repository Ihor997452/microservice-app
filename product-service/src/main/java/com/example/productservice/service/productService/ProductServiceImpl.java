package com.example.productservice.service.productService;

import com.example.productservice.model.Product;
import com.example.productservice.repo.ProductRepository;
import com.example.productservice.service.AbstractService;
import org.springframework.stereotype.Service;

@Service
public class ProductServiceImpl extends AbstractService<Product, Long> implements ProductService {
    public ProductServiceImpl(ProductRepository productRepository) {
        this.jpaRepository = productRepository;
    }
}
