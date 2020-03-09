package com.bookstore.web.rest;

import com.bookstore.model.entity.BookEntity;
import com.bookstore.model.entity.CategoryEntity;
import com.bookstore.repository.BookRepository;
import com.bookstore.repository.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/categories")
public class CategoryRestController {

    @Autowired
    private CategoryRepository categoryRepository;

    @Autowired
    private BookRepository bookRepository;

    @GetMapping
    public List<CategoryEntity> getAll() {
        return categoryRepository.findAll();
    }

    @GetMapping(path = "/{id}")
    public CategoryEntity get(@PathVariable Long id) {
        return categoryRepository.getOne(id);
    }

    @GetMapping(path = "/{id}/books")
    public List<BookEntity> getAllCategoryBooks(@PathVariable Long id) {
        return bookRepository.findAllByCategoryId(id, Pageable.unpaged());
    }

    @PostMapping
    public CategoryEntity post(@RequestBody CategoryEntity categoryEntity) {
        return categoryRepository.saveAndFlush(categoryEntity);
    }

    @PutMapping(path = "/{id}")
    public CategoryEntity put(@PathVariable Long id, @RequestBody CategoryEntity categoryEntity) {
        categoryEntity.setId(id);
        return categoryRepository.saveAndFlush(categoryEntity);
    }

    @DeleteMapping(path = "/{id}")
    public void delete(@PathVariable Long id) {
        categoryRepository.deleteById(id);
    }

}
