package com.bookstore.web.ui.controller.admin;

import com.bookstore.service.CategoryService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/admin")
@RequiredArgsConstructor
class CategoriesAdminController {

    private final CategoryService categoryService;

    @GetMapping("/categories")
    public String getCategories(Model model) {
        model.addAttribute("categories", categoryService.findAll());
        return "admin/categories";
    }

    @PreAuthorize("hasRole('SUPER_ADMIN')")
    @PostMapping(value = "/categories/delete", consumes = MediaType.APPLICATION_FORM_URLENCODED_VALUE)
    public String deleteCategory(@RequestParam Long id) {
        categoryService.deleteById(id);
        return "redirect:/admin/categories";
    }

}
