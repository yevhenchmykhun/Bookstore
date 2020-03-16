package com.bookstore.web.rest;

import com.bookstore.model.dto.Book;
import com.bookstore.service.BookService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("${rest.base-path}/books")
public class BookRestController {

    private BookService bookService;

    public BookRestController(BookService bookService) {
        this.bookService = bookService;
    }

    @GetMapping
    public List<Book> getAll() {
        return bookService.findAll();
    }

    @GetMapping("/{id}")
    public Book get(@PathVariable Long id) {
        return bookService.findById(id).orElseGet(Book::new);
    }

    @PostMapping
    public Book post(@RequestBody Book book) {
        return bookService.save(book);
    }

    @PutMapping("/{id}")
    public Book put(@PathVariable Long id, @RequestBody Book book) {
        book.setId(id);
        return bookService.save(book);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        bookService.deleteById(id);
    }

}
