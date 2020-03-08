package com.bookstore.web.ui.controller.admin;

import com.bookstore.service.BookService;
import com.bookstore.web.ui.form.Billing;
import com.bookstore.web.ui.form.Book;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.validation.Valid;

@Controller
@RequestMapping("${admin-console.base-path}")
public class BooksController {

    private BookService bookService;

    public BooksController(BookService bookService) {
        this.bookService = bookService;
    }

    @GetMapping("/books")
    public String getBooks(Model model) {
        model.addAttribute("books", bookService.findAll());
        return "admin/books";
    }

    @GetMapping("/new-book")
    public String getNewBook(Model model) {
        model.addAttribute("book", new Book());
        return "admin/new_book";
    }

    @PostMapping("/new-book/add")
    public String createNewBook(@ModelAttribute @Valid Book book, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return "admin/new_book";
        }

        return "redirect:/admin/books";
    }

}
