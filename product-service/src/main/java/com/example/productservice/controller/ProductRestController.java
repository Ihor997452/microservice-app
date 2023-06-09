package com.example.productservice.controller;

import com.example.productservice.model.Product;
import com.example.productservice.service.productService.ProductService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/products")
public class ProductRestController extends AbstractRestController<Product, Long> {
    ProductRestController(ProductService productService) {
        this.service = productService;
    }
}
