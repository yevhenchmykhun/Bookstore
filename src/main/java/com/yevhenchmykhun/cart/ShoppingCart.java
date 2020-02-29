package com.yevhenchmykhun.cart;

import com.yevhenchmykhun.entity.Book;

import java.math.BigDecimal;
import java.util.List;

public interface ShoppingCart {

    void addItem(Book book);

    void deleteItem(Book book);

    void update(Book book, int quantity);

    void clear();

    int getNumberOfItems();

    List<ShoppingCartItem> getItems();

    BigDecimal getTotalPrice();

}
