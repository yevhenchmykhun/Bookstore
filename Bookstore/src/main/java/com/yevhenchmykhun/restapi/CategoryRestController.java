package com.yevhenchmykhun.restapi;

import com.yevhenchmykhun.entity.Book;
import com.yevhenchmykhun.entity.Category;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/categories")
public class CategoryRestController {

    @GetMapping
    public List<Category> getAll() {
        return new ArrayList<>();
    }

    @GetMapping(path = "/{id}")
    public Category get(@PathVariable Long id) {
        return new Category();
    }

    @GetMapping(path = "/{id}/books")
    public List<Book> getAllCategoryBooks() {
        return new ArrayList<>();
    }

    @PostMapping
    public Category post(@RequestBody Category category) {
        return category;
    }

    @PutMapping(path = "/{id}")
    public Category put(@PathVariable Long id, @RequestBody Category category) {
        return category;
    }

    @DeleteMapping(path = "/{id}")
    public void delete(@PathVariable Long id) {
    }

}
