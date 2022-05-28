package com.bookstore.web.ui.controller.user;

import com.bookstore.service.BookService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequiredArgsConstructor
class SearchController {

    private final BookService bookService;

    @GetMapping("/search")
    public String get(@RequestParam String q, Model model) {
        model.addAttribute("books", bookService.findBySearchPhrase(q));
        return "user/search_result";
    }

}
