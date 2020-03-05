package com.bookstore.web.ui.controller.user;

import com.bookstore.model.cart.ShoppingCart;
import com.bookstore.service.BookService;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServlet;

@Controller
@RequestMapping("/cart")
public class CartController extends HttpServlet {

    private BookService bookService;

    private ShoppingCart cart;

    public CartController(BookService bookService, ShoppingCart cart) {
        this.bookService = bookService;
        this.cart = cart;
    }

    @GetMapping()
    public String get(Model model) {
        model.addAttribute("cart", cart);
        return "user/cart";
    }

    @PostMapping(value = "/add", consumes = MediaType.APPLICATION_FORM_URLENCODED_VALUE)
    public @ResponseBody
    int add(@RequestParam Long id) {
        bookService.findById(id).ifPresent(cart::addItem);
        return cart.getItemsNumber();
    }

    @PostMapping(value = "/delete", consumes = MediaType.APPLICATION_FORM_URLENCODED_VALUE)
    public @ResponseBody
    void delete(@RequestParam Long id) {
        cart.deleteItem(id);
    }

}
