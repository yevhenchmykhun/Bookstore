package com.bookstore.service.impl;

import com.bookstore.model.dto.Category;
import com.bookstore.model.mapping.CategoryMapper;
import com.bookstore.repository.CategoryRepository;
import com.bookstore.service.CategoryService;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
@Transactional
@CacheConfig(cacheNames = "categories")
public class CategoryServiceImpl implements CategoryService {

    private CategoryRepository repository;

    private CategoryMapper categoryMapper;

    public CategoryServiceImpl(CategoryRepository repository, CategoryMapper categoryMapper) {
        this.repository = repository;
        this.categoryMapper = categoryMapper;
    }

    @Override
    @Cacheable
    public List<Category> findAll() {
        return repository.findAll().stream()
                .map(entity -> categoryMapper.categoryEntityToCategoryFlat(entity))
                .collect(Collectors.toList());
    }

    @Override
    @CacheEvict(value = "categories", allEntries = true)
    public void deleteById(Long id) {
        repository.deleteById(id);
    }

}
