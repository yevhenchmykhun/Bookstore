package com.bookstore.repository;

import org.springframework.beans.factory.annotation.Autowired;

// TODO: legacy class, remove later
public class RepositoryFactory {

    @Autowired
    private BookRepository bookRepository;

    @Autowired
    private CategoryRepository categoryRepository;

    @Autowired
    private CustomerOrderRepository customerOrderRepository;

    @Autowired
    private CustomerRepository customerRepository;

    @Autowired
    private OrderedBookRepository orderedBookRepository;

    @Autowired
    private VisitorRepository visitorRepository;

    public BookRepository getBookRepository() {
        return bookRepository;
    }

    public CategoryRepository getCategoryRepository() {
        return categoryRepository;
    }

    public CustomerRepository getCustomerRepository() {
        return customerRepository;
    }

    public CustomerOrderRepository getCustomerOrderRepository() {
        return customerOrderRepository;
    }

    public OrderedBookRepository getOrderedBookRepository() {
        return orderedBookRepository;
    }

    public VisitorRepository getVisitorRepository() {
        return visitorRepository;
    }

}
