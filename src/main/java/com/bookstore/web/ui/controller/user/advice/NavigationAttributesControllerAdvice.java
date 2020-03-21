package com.bookstore.web.ui.controller.user.advice;

import com.bookstore.model.cart.ShoppingCart;
import com.bookstore.service.CategoryService;
import lombok.RequiredArgsConstructor;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ModelAttribute;

@ControllerAdvice("com.bookstore.web.ui.controller.user")
@RequiredArgsConstructor
public class NavigationAttributesControllerAdvice {

    private final CategoryService categoryService;

    private final ShoppingCart cart;

    @ModelAttribute
    public void addAttributes(Model model) {
        model.addAttribute("categories", categoryService.findAll());
        model.addAttribute("cart", cart);
    }

}
