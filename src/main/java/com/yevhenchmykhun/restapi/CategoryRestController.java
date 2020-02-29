package com.yevhenchmykhun.restapi;

import com.yevhenchmykhun.entity.Book;
import com.yevhenchmykhun.entity.Category;
import com.yevhenchmykhun.repository.BookRepository;
import com.yevhenchmykhun.repository.CategoryRepository;
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
    public List<Category> getAll() {
        return categoryRepository.findAll();
    }

    @GetMapping(path = "/{id}")
    public Category get(@PathVariable Long id) {
        return categoryRepository.getOne(id);
    }

    @GetMapping(path = "/{id}/books")
    public List<Book> getAllCategoryBooks(@PathVariable Long id) {
        return bookRepository.findAllByCategoryId(id, Pageable.unpaged());
    }

    @PostMapping
    public Category post(@RequestBody Category category) {
        return categoryRepository.saveAndFlush(category);
    }

    @PutMapping(path = "/{id}")
    public Category put(@PathVariable Long id, @RequestBody Category category) {
        category.setId(id);
        return categoryRepository.saveAndFlush(category);
    }

    @DeleteMapping(path = "/{id}")
    public void delete(@PathVariable Long id) {
        categoryRepository.deleteById(id);
    }

}
