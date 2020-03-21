package com.bookstore.web.ui.controller.user;

import com.bookstore.model.dto.Book;
import com.bookstore.service.BookService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.HashSet;
import java.util.Set;

@Controller
@RequiredArgsConstructor
class SearchController {

    private final BookService bookService;

    @GetMapping("/search")
    public String get(@RequestParam String q, Model model) {
        Set<Book> books = new HashSet<>();
        books.addAll(bookService.findByNameContaining(q));
        books.addAll(bookService.findByAuthorContaining(q));
        books.addAll(bookService.findByIsbnContaining(q));

        model.addAttribute("books", books);

        return "user/search_result";
    }

}
