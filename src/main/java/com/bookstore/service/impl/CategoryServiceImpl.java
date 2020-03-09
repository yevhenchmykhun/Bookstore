package com.bookstore.service.impl;

import com.bookstore.model.entity.CategoryEntity;
import com.bookstore.repository.CategoryRepository;
import com.bookstore.service.CategoryService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class CategoryServiceImpl implements CategoryService {

    private CategoryRepository repository;

    public CategoryServiceImpl(CategoryRepository repository) {
        this.repository = repository;
    }

    @Override
    public List<CategoryEntity> findAll() {
        return repository.findAll();
    }

    @Override
    public CategoryEntity findByName(String category) {
        return repository.findByName(category);
    }

}
