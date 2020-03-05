package com.bookstore.web.ui.controller.admin;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller("adminIndexController")
@RequestMapping("${admin-console.base-path}")
public class IndexController {

    @GetMapping("/dashboard")
    public String getDashboard() {
        return "admin/dashboard";
    }

    @GetMapping("/books")
    public String getBooks() {
        return "admin/books";
    }

}
