package com.yevhenchmykhun.controller;

import com.yevhenchmykhun.entity.Book;
import com.yevhenchmykhun.service.BookService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Optional;

@Controller
public class BookController {

    private BookService bookService;

    public BookController(BookService bookService) {
        this.bookService = bookService;
    }

    @GetMapping("/book")
    public String get(@RequestParam Long id, Model model) {
        Optional<Book> book = bookService.findById(id);
        book.ifPresent(value -> model.addAttribute("book", value));

        return "user/book";
    }

}
