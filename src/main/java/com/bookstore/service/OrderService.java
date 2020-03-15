package com.bookstore.service;

import com.bookstore.model.dto.Order;
import com.bookstore.web.ui.form.BillingForm;

import java.util.List;

public interface OrderService {

    List<Order> findAll();

    void processOrder(BillingForm billingForm);

}
