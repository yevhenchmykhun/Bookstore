package com.bookstore.service;

import com.bookstore.model.entity.CustomerOrder;

import java.util.List;

public interface CustomerOrderService {

    List<CustomerOrder> findAll();

}
