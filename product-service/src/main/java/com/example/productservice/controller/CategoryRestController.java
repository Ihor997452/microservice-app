package com.example.productservice.controller;

import com.example.productservice.model.Category;
import com.example.productservice.service.categoryService.CategoryService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/categories")
public class CategoryRestController extends AbstractRestController<Category, Long> {
    CategoryRestController(CategoryService categoryService) {
        this.service = categoryService;
    }
}
