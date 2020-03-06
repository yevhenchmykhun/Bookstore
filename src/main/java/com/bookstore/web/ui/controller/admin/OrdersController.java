package com.bookstore.web.ui.controller.admin;

import com.bookstore.service.CategoryService;
import com.bookstore.service.CustomerOrderService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("${admin-console.base-path}")
public class OrdersController {

    private CustomerOrderService customerOrderService;

    public OrdersController(CustomerOrderService customerOrderService) {
        this.customerOrderService = customerOrderService;
    }

    @GetMapping("/orders")
    public String getBooks(Model model) {
        model.addAttribute("orders", customerOrderService.findAll());
        return "admin/orders";
    }

}
