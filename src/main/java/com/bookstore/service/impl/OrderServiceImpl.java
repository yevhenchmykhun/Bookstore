package com.bookstore.service.impl;

import com.bookstore.model.dto.Order;
import com.bookstore.model.mapping.OrderMapper;
import com.bookstore.repository.OrderRepository;
import com.bookstore.service.OrderService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
@Transactional
public class OrderServiceImpl implements OrderService {

    private OrderRepository repository;

    private OrderMapper orderMapper;

    public OrderServiceImpl(OrderRepository repository, OrderMapper orderMapper) {
        this.repository = repository;
        this.orderMapper = orderMapper;
    }

    @Override
    public List<Order> findAll() {
        return repository.findAll().stream()
                .map(entity -> orderMapper.orderEntityToOrder(entity))
                .collect(Collectors.toList());
    }

}
