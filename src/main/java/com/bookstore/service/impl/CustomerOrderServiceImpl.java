package com.bookstore.service.impl;

import com.bookstore.model.entity.OrderEntity;
import com.bookstore.repository.OrderRepository;
import com.bookstore.service.CustomerOrderService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class CustomerOrderServiceImpl implements CustomerOrderService {

    private OrderRepository repository;

    public CustomerOrderServiceImpl(OrderRepository repository) {
        this.repository = repository;
    }

    @Override
    public List<OrderEntity> findAll() {
        return repository.findAll();
    }

}
