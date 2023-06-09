package com.example.productservice.service.categoryService;

import com.example.productservice.model.Category;
import com.example.productservice.repo.CategoryRepository;
import com.example.productservice.service.AbstractService;
import org.springframework.stereotype.Service;

@Service
public class CategoryServiceImpl extends AbstractService<Category, Long> implements CategoryService {
    public CategoryServiceImpl(CategoryRepository categoryRepository) {
        this.jpaRepository = categoryRepository;
    }
}
