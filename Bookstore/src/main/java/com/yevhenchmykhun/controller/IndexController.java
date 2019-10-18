package com.yevhenchmykhun.controller;

import com.yevhenchmykhun.entity.Book;
import com.yevhenchmykhun.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
public class IndexController {

    @Autowired
    private BookRepository bookRepository;

    @GetMapping("/index")
    public String get(Model model) {

        List<Book> pageOne = bookRepository.findAllByCategoryId(2L, PageRequest.of(0, 6));
        List<Book> pageTwo = bookRepository.findAllByCategoryId(2L, PageRequest.of(1, 6));

        model.addAttribute("pageOne", pageOne);
        model.addAttribute("pageTwo", pageTwo);

        return "index";
    }

}
