package com.yevhenchmykhun.controller;

import com.yevhenchmykhun.entity.Book;
import com.yevhenchmykhun.service.BookService;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
public class IndexController {

    private BookService bookService;

    public IndexController(BookService bookService) {
        this.bookService = bookService;
    }

    @GetMapping("/index")
    public String get(Model model) {

        List<Book> pageOne = bookService.findAllByCategoryId(2L, PageRequest.of(0, 6));
        List<Book> pageTwo = bookService.findAllByCategoryId(2L, PageRequest.of(1, 6));

        model.addAttribute("pageOne", pageOne);
        model.addAttribute("pageTwo", pageTwo);

        return "user/index";
    }

}
