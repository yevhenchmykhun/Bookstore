package com.bookstore.service.impl;

import com.bookstore.model.dto.Category;
import com.bookstore.model.entity.CategoryEntity;
import com.bookstore.model.mapping.CategoryMapper;
import com.bookstore.repository.CategoryRepository;
import com.bookstore.service.CategoryService;
import lombok.RequiredArgsConstructor;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@Transactional
@CacheConfig(cacheNames = "categories")
@RequiredArgsConstructor
public class CategoryServiceImpl implements CategoryService {

    private final CategoryRepository repository;

    private final CategoryMapper categoryMapper;

    @Override
    @Cacheable
    public Optional<Category> findById(Long id) {
        Optional<CategoryEntity> categoryEntity = repository.findById(id);
        return categoryEntity.map(categoryMapper::toCategory);
    }

    @Override
    @Cacheable
    public List<Category> findAll() {
        return repository.findAll().stream()
                .map(categoryMapper::toCategory)
                .collect(Collectors.toList());
    }

    @Override
    public Category save(Category category) {
        CategoryEntity categoryEntity = categoryMapper.toCategoryEntity(category);
        categoryEntity = repository.saveAndFlush(categoryEntity);
        return categoryMapper.toCategory(categoryEntity);
    }

    @Override
    @CacheEvict(value = "categories", allEntries = true)
    public void deleteById(Long id) {
        repository.deleteById(id);
    }

}
