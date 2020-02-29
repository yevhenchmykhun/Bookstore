package com.yevhenchmykhun.controller;

import com.yevhenchmykhun.entity.Book;
import com.yevhenchmykhun.service.BookService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Optional;

@Controller
public class DescriptionController {

    private BookService bookService;

    public DescriptionController(BookService bookService) {
        this.bookService = bookService;
    }

    @GetMapping("/description")
    public String get(@RequestParam Long id, Model model) {

        Optional<Book> book = bookService.findById(id);
        book.ifPresent(value -> model.addAttribute("book", value));

        return "user/description";
    }

}
