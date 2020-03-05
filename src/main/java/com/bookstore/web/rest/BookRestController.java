package com.bookstore.web.rest;

import com.bookstore.model.entity.Book;
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
    public List<Book> getAll() {
        return bookRepository.findAll();
    }

    @GetMapping(path = "/{id}")
    public Book get(@PathVariable Long id) {
        return bookRepository.getOne(id);
    }

    @PostMapping
    public Book post(@RequestBody Book book) {
        return bookRepository.saveAndFlush(book);
    }

    @PutMapping(path = "/{id}")
    public Book put(@PathVariable Long id, @RequestBody Book book) {
        book.setId(id);
        return bookRepository.saveAndFlush(book);
    }

    @DeleteMapping(path = "/{id}")
    public void delete(@PathVariable Long id) {
        bookRepository.deleteById(id);
    }

}
