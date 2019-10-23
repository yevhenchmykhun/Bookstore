package com.yevhenchmykhun.controller;

import com.yevhenchmykhun.cart.ShoppingCart;
import com.yevhenchmykhun.entity.Book;
import com.yevhenchmykhun.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Map;

@Controller
public class DescriptionController {

    @Autowired
    private BookRepository bookRepository;

    @Autowired
    private ShoppingCart shoppingCart;

    @GetMapping("/description")
    public String get(@RequestParam Long id, Model model) {

        Book book = bookRepository.getOne(id);
        model.addAttribute("book", book);

        return "user/description";
    }

    @PostMapping(value = "/addToCart", consumes = MediaType.APPLICATION_FORM_URLENCODED_VALUE)
    public @ResponseBody
    void addToCart(@RequestParam Map<String, String> parametersMap) {
        Book book = bookRepository.getOne(Long.parseLong((parametersMap.get("id"))));
        shoppingCart.addItem(book);
    }

}
