package com.yevhenchmykhun.controller;

import com.yevhenchmykhun.cart.ShoppingCart;
import com.yevhenchmykhun.service.BookService;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServlet;
import java.util.Map;

@Controller
@RequestMapping("/cart")
public class CartController extends HttpServlet {

    private final BookService bookService;

    private final ShoppingCart shoppingCart;

    public CartController(BookService bookService, ShoppingCart shoppingCart) {
        this.bookService = bookService;
        this.shoppingCart = shoppingCart;
    }

    @GetMapping()
    public String get(Model model) {
        model.addAttribute("cart", shoppingCart);
        return "user/cart";
    }

    @PostMapping(value = "/addToCart", consumes = MediaType.APPLICATION_FORM_URLENCODED_VALUE)
    public @ResponseBody
    void addToCart(@RequestParam Map<String, String> parametersMap) {
        bookService.findById(Long.parseLong((parametersMap.get("id")))).ifPresent(shoppingCart::addItem);
    }

    @PostMapping(value = "/updateQuantity", consumes = MediaType.APPLICATION_FORM_URLENCODED_VALUE)
    public String updateQuantity(@RequestParam Map<String, String> parametersMap) {

        return "user/cart";
    }

    @PostMapping(value = "/deleteFromCart", consumes = MediaType.APPLICATION_FORM_URLENCODED_VALUE)
    public String deleteFromCart(@RequestParam Map<String, String> parametersMap) {

        return "user/cart";
    }

    @PostMapping(value = "/checkout", consumes = MediaType.APPLICATION_FORM_URLENCODED_VALUE)
    public String checkout(@RequestParam Map<String, String> parametersMap) {

        return "user/checkout";
    }

}
