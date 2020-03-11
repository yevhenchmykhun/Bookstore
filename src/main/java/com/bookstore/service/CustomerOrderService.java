package com.bookstore.service;

import com.bookstore.model.entity.OrderEntity;

import java.util.List;

public interface CustomerOrderService {

    List<OrderEntity> findAll();

}
