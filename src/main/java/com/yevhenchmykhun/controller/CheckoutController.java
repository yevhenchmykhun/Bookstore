package com.yevhenchmykhun.controller;

import com.yevhenchmykhun.model.Billing;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import javax.validation.Valid;

@Controller
public class CheckoutController {

    @GetMapping("/checkout")
    public String checkout(Model model) {
        model.addAttribute(new Billing());
        return "user/checkout";
    }

    @PostMapping("/pay")
    public String pay(@ModelAttribute @Valid Billing billing, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return "user/checkout";
        }

        return "redirect:/goodbye";
    }

    @GetMapping("/goodbye")
    public String goodbye() {
        return "user/goodbye";
    }

}
