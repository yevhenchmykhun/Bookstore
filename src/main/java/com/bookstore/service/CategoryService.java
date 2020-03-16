package com.bookstore.service;

import com.bookstore.model.dto.Category;

import java.util.List;
import java.util.Optional;

public interface CategoryService {

    List<Category> findAll();

    Optional<Category> findById(Long id);

    void deleteById(Long id);

    Category save(Category category);

}
