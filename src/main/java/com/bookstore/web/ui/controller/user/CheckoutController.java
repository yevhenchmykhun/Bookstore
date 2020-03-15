package com.bookstore.web.ui.controller.user;

import com.bookstore.service.OrderService;
import com.bookstore.web.ui.form.BillingForm;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import javax.validation.Valid;

@Controller
public class CheckoutController {

    private OrderService orderService;

    public CheckoutController(OrderService orderService) {
        this.orderService = orderService;
    }

    @GetMapping("/checkout")
    public String checkout(Model model) {
        model.addAttribute(new BillingForm());
        return "user/checkout";
    }

    @PostMapping("/pay")
    public String pay(@ModelAttribute @Valid BillingForm billingForm, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return "user/checkout";
        }

        orderService.processOrder(billingForm);

        return "redirect:/goodbye";
    }

    @GetMapping("/goodbye")
    public String goodbye() {
        return "user/goodbye";
    }

}
