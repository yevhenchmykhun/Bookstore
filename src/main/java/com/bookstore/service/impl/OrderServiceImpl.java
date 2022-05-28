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
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@Transactional
@RequiredArgsConstructor
public class OrderServiceImpl implements OrderService {

    private final OrderRepository orderRepository;

    private final BookRepository bookRepository;

    private final OrderMapper orderMapper;

    private final CustomerMapper customerMapper;

    private final ShoppingCart cart;

    @Override
    public List<Order> findAll() {
        return orderRepository.findAll().stream()
                .map(orderMapper::toOrder)
                .collect(Collectors.toList());
    }

    @Override
    public void processOrder(BillingForm billingForm) {
        CustomerEntity customerEntity = customerMapper.toCustomerEntity(billingForm);

        OrderEntity orderEntity = new OrderEntity();
        orderEntity.setTotalAmount(cart.getTotalPrice());
        orderEntity.setCustomer(customerEntity);
        orderEntity.setOrderedBooks(cart.getItems().stream()
                .map(shoppingCartItem -> buildOrderedBookEntity(shoppingCartItem, orderEntity))
                .collect(Collectors.toList()));

        customerEntity.getOrders().add(orderEntity);

        orderRepository.saveAndFlush(orderEntity);

        // update book quantities
        for (ShoppingCartItem item : cart.getItems()) {
            Long bookId = item.getBook().getId();
            Optional<BookEntity> bookEntity = bookRepository.findById(bookId);
            if (bookEntity.isPresent()) {
                BookEntity book = bookEntity.get();
                int newQuantity = book.getQuantity() - item.getQuantity();
                book.setQuantity(newQuantity);
                bookRepository.saveAndFlush(book);
            }
        }

        cart.clear();
    }

    private OrderedBookEntity buildOrderedBookEntity(ShoppingCartItem shoppingCartItem, OrderEntity orderEntity) {
        OrderedBookEntity orderedBookEntity = new OrderedBookEntity();
        orderedBookEntity.setQuantity(shoppingCartItem.getQuantity());
        orderedBookEntity.setOrder(orderEntity);

        Long bookId = shoppingCartItem.getBook().getId();
        bookRepository.findById(bookId)
                .ifPresent(orderedBookEntity::setBook);

        return orderedBookEntity;
    }

}
