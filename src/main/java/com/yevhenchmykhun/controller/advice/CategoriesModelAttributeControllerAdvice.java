package com.yevhenchmykhun.controller.advice;

import com.yevhenchmykhun.repository.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ModelAttribute;

@ControllerAdvice
public class CategoriesModelAttributeControllerAdvice {

    @Autowired
    private CategoryRepository categoryRepository;

    @ModelAttribute
    public void addCategories(Model model) {
        model.addAttribute("categories", categoryRepository.findAll());
    }

}
