package com.bookstore.web.ui.controller.admin;

import com.bookstore.service.BookService;
import com.bookstore.service.CategoryService;
import com.bookstore.web.ui.form.BookForm;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.validation.Valid;

@Controller
@RequestMapping("${admin-console.base-path}")
public class BooksController {

    private BookService bookService;

    private CategoryService categoryService;

    public BooksController(BookService bookService, CategoryService categoryService) {
        this.bookService = bookService;
        this.categoryService = categoryService;
    }

    @GetMapping("/books")
    public String getBooks(Model model) {
        model.addAttribute("books", bookService.findAll());
        return "admin/books";
    }

    @GetMapping("/new-book")
    public String getNewBook(Model model) {
        model.addAttribute(new BookForm());
        model.addAttribute("categories", categoryService.findAll());
        return "admin/new_book";
    }

    @PostMapping("/new-book/add")
    public String createNewBook(@ModelAttribute @Valid BookForm bookForm, BindingResult bindingResult, Model model) {
        if (bindingResult.hasErrors()) {
            model.addAttribute("categories", categoryService.findAll());
            return "admin/new_book";
        }

        bookService.save(bookForm);

        return "redirect:/admin/books";
    }

}
