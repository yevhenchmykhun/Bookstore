package com.yevhenchmykhun.restapi;

import com.yevhenchmykhun.entity.Book;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/books")
public class BookRestController {

    @GetMapping
    public List<Book> getAll() {
        List<Book> books = new ArrayList<>();
        books.add(new Book());
        books.add(new Book());
        return books;
    }

    @GetMapping(path = "/{id}")
    public Book get(@PathVariable Long id) {
        return new Book();
    }

    @PostMapping
    public Book post(@RequestBody Book book) {
        return book;
    }

    @PutMapping(path = "/{id}")
    public Book put(@PathVariable Long id, @RequestBody Book book) {
        return book;
    }

    @DeleteMapping(path = "/{id}")
    public void delete(@PathVariable Long id) {
    }

}
