package com.yevhenchmykhun.controller.advice;

import com.yevhenchmykhun.cart.ShoppingCart;
import com.yevhenchmykhun.repository.CategoryRepository;
import com.yevhenchmykhun.service.CategoryService;
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
    public void addCategories(Model model) {
        model.addAttribute("categories", categoryService.findAll());
        model.addAttribute("cart", cart);
    }

}
