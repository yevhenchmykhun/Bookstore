package com.yevhenchmykhun.service.impl;

import com.yevhenchmykhun.entity.Category;
import com.yevhenchmykhun.repository.CategoryRepository;
import com.yevhenchmykhun.service.CategoryService;
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
    public List<Category> findAll() {
        return repository.findAll();
    }

}
