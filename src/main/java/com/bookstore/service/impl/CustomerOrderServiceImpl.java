package com.bookstore.service.impl;

import com.bookstore.model.entity.CustomerOrder;
import com.bookstore.repository.CustomerOrderRepository;
import com.bookstore.service.CategoryService;
import com.bookstore.service.CustomerOrderService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class CustomerOrderServiceImpl implements CustomerOrderService {

    private CustomerOrderRepository repository;

    public CustomerOrderServiceImpl(CustomerOrderRepository repository) {
        this.repository = repository;
    }

    @Override
    public List<CustomerOrder> findAll() {
        return repository.findAll();
    }

}
