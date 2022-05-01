package com.bookstore.web.ui.controller.user;

import com.bookstore.model.cart.ShoppingCart;
import com.bookstore.service.BookService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/cart")
@RequiredArgsConstructor
public class CartController {

    private final BookService bookService;

    private final ShoppingCart cart;

    @GetMapping
    public String get() {
        return "user/cart";
    }

    @PostMapping(value = "/add", consumes = MediaType.APPLICATION_FORM_URLENCODED_VALUE)
    @ResponseBody
    public int add(@RequestParam Long id) {
        bookService.findById(id).ifPresent(cart::addItem);
        return cart.getItemsNumber();
    }

    @PostMapping(value = "/delete", consumes = MediaType.APPLICATION_FORM_URLENCODED_VALUE)
    @ResponseBody
    public void delete(@RequestParam Long id) {
        cart.deleteItem(id);
    }

}
