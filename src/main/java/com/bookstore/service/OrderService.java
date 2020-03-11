package com.bookstore.service;

import com.bookstore.model.dto.Order;

import java.util.List;

public interface OrderService {

    List<Order> findAll();

}
