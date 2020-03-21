package com.bookstore.web.ui.controller.admin;

import com.bookstore.service.BookService;
import com.bookstore.service.CategoryService;
import com.bookstore.web.ui.form.BookForm;
import lombok.RequiredArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@Controller
@RequestMapping("/admin")
@RequiredArgsConstructor
class BooksAdminController {

    private final BookService bookService;

    private final CategoryService categoryService;

    @GetMapping("/books")
    public String getBooks(Model model) {
        model.addAttribute("books", bookService.findAll());
        return "admin/books";
    }

    @PreAuthorize("hasRole('SUPER_ADMIN')")
    @PostMapping(value = "/books/edit", consumes = MediaType.APPLICATION_FORM_URLENCODED_VALUE)
    public String editBook(@RequestParam Long id) {
        return "redirect:/dashboard";
    }

    @PreAuthorize("hasRole('SUPER_ADMIN')")
    @PostMapping(value = "/books/delete", consumes = MediaType.APPLICATION_FORM_URLENCODED_VALUE)
    public String deleteBook(@RequestParam Long id) {
        bookService.deleteById(id);
        return "redirect:/admin/books";
    }

    @GetMapping("/new-book")
    public String getNewBook(Model model) {
        model.addAttribute(new BookForm());
        model.addAttribute("categories", categoryService.findAll());
        return "admin/new_book";
    }

    @PreAuthorize("hasRole('ADMIN')")
    @PostMapping("/new-book/add")
    public String createNewBook(@ModelAttribute @Valid BookForm bookForm, BindingResult bindingResult, Model model) {
        if (bindingResult.hasErrors()) {
            model.addAttribute("categories", categoryService.findAll());
            return "admin/new_book";
        }

        bookService.save(bookForm);

        return "redirect:/admin/books";
    }

}
