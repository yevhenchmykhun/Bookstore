package com.bookstore.web.ui.controller.admin;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/admin")
class IndexAdminController {

    @GetMapping("/")
    public String index() {
        return "admin/dashboard";
    }

    @GetMapping("/dashboard")
    public String getDashboard() {
        return "admin/dashboard";
    }

}
