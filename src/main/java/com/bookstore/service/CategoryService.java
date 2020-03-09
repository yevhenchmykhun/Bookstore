package com.bookstore.service;

import com.bookstore.model.entity.CategoryEntity;

import java.util.List;

public interface CategoryService {

    List<CategoryEntity> findAll();

    CategoryEntity findByName(String category);
}
