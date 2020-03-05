package com.bookstore.cart;

import com.bookstore.entity.Book;

import java.math.BigDecimal;
import java.util.List;

public interface ShoppingCart {

    void addItem(Book book);

    void deleteItem(Long book);

    void clear();

    boolean isEmpty();

    List<ShoppingCartItem> getItems();

    int getItemsNumber();

    BigDecimal getTotalPrice();

}
