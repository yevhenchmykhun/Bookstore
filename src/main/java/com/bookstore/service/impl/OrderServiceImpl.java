package com.bookstore.service.impl;

import com.bookstore.model.cart.ShoppingCart;
import com.bookstore.model.cart.ShoppingCartItem;
import com.bookstore.model.dto.Order;
import com.bookstore.model.entity.BookEntity;
import com.bookstore.model.entity.CustomerEntity;
import com.bookstore.model.entity.OrderEntity;
import com.bookstore.model.entity.OrderedBookEntity;
import com.bookstore.model.mapping.CustomerMapper;
import com.bookstore.model.mapping.OrderMapper;
import com.bookstore.repository.BookRepository;
import com.bookstore.repository.OrderRepository;
import com.bookstore.service.OrderService;
import com.bookstore.web.ui.form.BillingForm;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@Transactional
public class OrderServiceImpl implements OrderService {

    private OrderRepository orderRepository;

    private BookRepository bookRepository;

    private OrderMapper orderMapper;

    private CustomerMapper customerMapper;

    private ShoppingCart cart;

    public OrderServiceImpl(OrderRepository orderRepository,
                            BookRepository bookRepository,
                            OrderMapper orderMapper,
                            CustomerMapper customerMapper,
                            ShoppingCart cart) {
        this.orderRepository = orderRepository;
        this.bookRepository = bookRepository;
        this.orderMapper = orderMapper;
        this.customerMapper = customerMapper;
        this.cart = cart;
    }

    @Override
    public List<Order> findAll() {
        return orderRepository.findAll().stream()
                .map(entity -> orderMapper.orderEntityToOrder(entity))
                .collect(Collectors.toList());
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void processOrder(BillingForm billingForm) {
        CustomerEntity customerEntity = customerMapper.billingFormToCustomerEntity(billingForm);

        OrderEntity orderEntity = new OrderEntity();
        orderEntity.setTotalAmount(cart.getTotalPrice());
        orderEntity.setCustomer(customerEntity);
        orderEntity.setOrderedBooks(cart.getItems().stream()
                .map(shoppingCartItem -> buildOrderedBookEntity(shoppingCartItem, orderEntity))
                .collect(Collectors.toList()));

        customerEntity.getOrders().add(orderEntity);

        orderRepository.saveAndFlush(orderEntity);

        cart.clear();
    }

    private OrderedBookEntity buildOrderedBookEntity(ShoppingCartItem shoppingCartItem, OrderEntity orderEntity) {
        OrderedBookEntity orderedBookEntity = new OrderedBookEntity();
        orderedBookEntity.setQuantity(shoppingCartItem.getQuantity());
        orderedBookEntity.setOrder(orderEntity);
        Optional<BookEntity> bookEntity = bookRepository.findById(shoppingCartItem.getBook().getId());
        bookEntity.ifPresent(orderedBookEntity::setBook);

        return orderedBookEntity;
    }

}
