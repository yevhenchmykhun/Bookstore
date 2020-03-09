package com.bookstore.web.ui.controller.user;

import com.bookstore.model.entity.BookEntity;
import com.bookstore.service.BookService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
public class SearchController {

    private BookService bookService;

    public SearchController(BookService bookService) {
        this.bookService = bookService;
    }

    @GetMapping("/search")
    public String get(@RequestParam String q, Model model) {
        List<BookEntity> bookEntities = bookService.findByNameContaining(q);
        if (bookEntities.isEmpty()) {
            bookEntities = bookService.findByAuthorContaining(q);
            if (bookEntities.isEmpty()) {
                bookEntities = bookService.findByIsbnContaining(q);
            }
        }

        model.addAttribute("books", bookEntities);

        return "user/search_result";
    }

}
