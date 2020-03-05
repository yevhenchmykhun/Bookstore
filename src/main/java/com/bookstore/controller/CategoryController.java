package com.bookstore.controller;

import com.bookstore.entity.Book;
import com.bookstore.service.BookService;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
public class CategoryController {

    private static final int PAGE_SIZE = 5;

    private BookService bookService;

    public CategoryController(BookService bookService) {
        this.bookService = bookService;
    }

    @GetMapping("/category")
    public String get(@RequestParam Long id, @RequestParam Integer page, Model model) {
        List<Book> books = bookService.findAllByCategoryId(id, PageRequest.of(page - 1, PAGE_SIZE));

        long booksTotalNumber = bookService.countByCategoryId(id);
        long pagesNumber = (int) Math.ceil(booksTotalNumber * 1.0 / PAGE_SIZE);

        model.addAttribute("categoryId", id);
        model.addAttribute("books", books);
        model.addAttribute("currentPage", page);
        model.addAttribute("pagesNumber", pagesNumber);

        return "user/category";
    }

}
