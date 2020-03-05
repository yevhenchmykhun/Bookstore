package com.bookstore.web.ui.controller.user.advice;

import com.bookstore.model.cart.ShoppingCart;
import com.bookstore.service.CategoryService;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ModelAttribute;

@ControllerAdvice
public class NavigationAttributesControllerAdvice {

    private CategoryService categoryService;

    private ShoppingCart cart;

    public NavigationAttributesControllerAdvice(CategoryService categoryService, ShoppingCart cart) {
        this.categoryService = categoryService;
        this.cart = cart;
    }

    @ModelAttribute
    public void addAttributes(Model model) {
        model.addAttribute("categories", categoryService.findAll());
        model.addAttribute("cart", cart);
    }

}
