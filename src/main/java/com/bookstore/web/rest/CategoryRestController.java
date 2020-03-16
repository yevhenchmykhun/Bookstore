package com.bookstore.web.rest;

import com.bookstore.model.dto.Book;
import com.bookstore.model.dto.Category;
import com.bookstore.service.BookService;
import com.bookstore.service.CategoryService;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("${rest.base-path}/categories")
public class CategoryRestController {

    private CategoryService categoryService;

    private BookService bookService;

    public CategoryRestController(CategoryService categoryService, BookService bookService) {
        this.categoryService = categoryService;
        this.bookService = bookService;
    }

    @GetMapping
    public List<Category> getAll() {
        return categoryService.findAll();
    }

    @GetMapping("/{id}")
    public Category get(@PathVariable Long id) {
        return categoryService.findById(id).orElseGet(Category::new);
    }

    @GetMapping("/{id}/books")
    public List<Book> getAllCategoryBooks(@PathVariable Long id) {
        return bookService.findAllByCategoryId(id, Pageable.unpaged());
    }

    @PostMapping
    public Category post(@RequestBody Category category) {
        return categoryService.save(category);
    }

    @PutMapping("/{id}")
    public Category put(@PathVariable Long id, @RequestBody Category category) {
        category.setId(id);
        return categoryService.save(category);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        categoryService.deleteById(id);
    }

}
