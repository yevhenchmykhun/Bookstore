package com.bookstore.web.ui.controller.user;

import com.bookstore.model.dto.Book;
import com.bookstore.service.BookService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
@RequiredArgsConstructor
class IndexController {

    private final BookService bookService;

    @GetMapping("/")
    public String index(Model model) {
        List<Book> books = bookService.findAllByCategoryId(2L, PageRequest.of(0, 12));
        model.addAttribute("books", books);

        return "user/index";
    }

}
