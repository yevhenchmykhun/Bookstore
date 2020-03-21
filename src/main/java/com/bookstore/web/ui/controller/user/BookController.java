package com.bookstore.web.ui.controller.user;

import com.bookstore.model.dto.Book;
import com.bookstore.service.BookService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Optional;

@Controller
@RequiredArgsConstructor
class BookController {

    private final BookService bookService;

    @GetMapping("/book")
    public String get(@RequestParam Long id, Model model) {
        Optional<Book> book = bookService.findById(id);
        book.ifPresent(value -> model.addAttribute("book", value));

        return "user/book";
    }

}
