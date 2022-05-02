package com.bookstore.web.rest;

import com.bookstore.model.cart.ShoppingCart;
import com.bookstore.service.BookService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/rest/cart")
@RequiredArgsConstructor
public class CartRestController {

    private final BookService bookService;

    private final ShoppingCart cart;

    @PostMapping(value = "/add", consumes = MediaType.APPLICATION_FORM_URLENCODED_VALUE)
    public int add(@RequestParam Long id) {
        bookService.findById(id).ifPresent(cart::addItem);
        return cart.getItemsNumber();
    }

    @PostMapping(value = "/delete", consumes = MediaType.APPLICATION_FORM_URLENCODED_VALUE)
    public void delete(@RequestParam Long id) {
        cart.deleteItem(id);
    }

}
