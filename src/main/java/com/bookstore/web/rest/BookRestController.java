package com.bookstore.web.rest;

import com.bookstore.model.entity.BookEntity;
import com.bookstore.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/books")
public class BookRestController {

    @Autowired
    private BookRepository bookRepository;

    @GetMapping
    public List<BookEntity> getAll() {
        return bookRepository.findAll();
    }

    @GetMapping(path = "/{id}")
    public BookEntity get(@PathVariable Long id) {
        return bookRepository.getOne(id);
    }

    @PostMapping
    public BookEntity post(@RequestBody BookEntity bookEntity) {
        return bookRepository.saveAndFlush(bookEntity);
    }

    @PutMapping(path = "/{id}")
    public BookEntity put(@PathVariable Long id, @RequestBody BookEntity bookEntity) {
        bookEntity.setId(id);
        return bookRepository.saveAndFlush(bookEntity);
    }

    @DeleteMapping(path = "/{id}")
    public void delete(@PathVariable Long id) {
        bookRepository.deleteById(id);
    }

}
