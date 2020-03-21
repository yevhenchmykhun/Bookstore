package com.bookstore.web.ui.controller.admin;

import com.bookstore.service.OrderService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/admin")
@RequiredArgsConstructor
class OrdersAdminController {

    private final OrderService orderService;

    @GetMapping("/orders")
    public String getOrders(Model model) {
        model.addAttribute("orders", orderService.findAll());
        return "admin/orders";
    }

}
