package com.bookstore.manager;

import com.bookstore.model.cart.ShoppingCart;
import com.bookstore.model.cart.ShoppingCartItem;
import com.bookstore.repository.RepositoryFactory;
import com.bookstore.model.entity.Customer;
import com.bookstore.model.entity.CustomerOrder;
import com.bookstore.model.entity.OrderedBook;

import java.sql.Timestamp;
import java.util.List;
import java.util.Random;

public class OrderManager {

    public void placeOrder(String name, String email, String phone, String address, String cityRegion, String ccNUmber, ShoppingCart cart) {
        Customer customer = createCustomer(name, email, phone, address, cityRegion, ccNUmber);
        CustomerOrder order = createOrder(customer, cart);
        addOrderedItems(order, cart);
    }

    private Customer createCustomer(String name, String email, String phone, String address, String cityRegion, String ccNUmber) {
        Customer customer = new Customer();
        customer.setName(name);
        customer.setEmail(email);
        customer.setPhone(phone);
        customer.setAddress(address);
        customer.setCityRegion(cityRegion);
        customer.setCcNumber(ccNUmber);

        new RepositoryFactory().getCustomerRepository().saveAndFlush(customer);

        return customer;
    }

    private CustomerOrder createOrder(Customer customer, ShoppingCart cart) {
        CustomerOrder order = new CustomerOrder();
        order.setDateCreated(new Timestamp(System.currentTimeMillis()));
        order.setAmount(cart.getTotalPrice());

        Random random = new Random();
        int i = random.nextInt(99999999);
        order.setConfirmationNumber(i);

        customer.addCustomerOrder(order);

        new RepositoryFactory().getCustomerOrderRepository().saveAndFlush(order);

        return order;
    }

    private void addOrderedItems(CustomerOrder order, ShoppingCart cart) {
        List<ShoppingCartItem> items = cart.getItems();

        for (ShoppingCartItem item : items) {
            OrderedBook orderedBook = new OrderedBook();
            orderedBook.setBook(item.getBook());
            orderedBook.setQuantity(item.getQuantity());

            order.addOrderedBook(orderedBook);

            new RepositoryFactory().getOrderedBookRepository().saveAndFlush(orderedBook);
        }

    }

}
