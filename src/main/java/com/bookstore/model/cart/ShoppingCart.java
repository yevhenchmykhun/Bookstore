package com.bookstore.model.cart;

import com.bookstore.model.dto.Book;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.List;

public interface ShoppingCart extends Serializable {

    void addItem(Book book);

    void deleteItem(Long bookId);

    void clear();

    boolean isEmpty();

    List<ShoppingCartItem> getItems();

    int getItemsNumber();

    BigDecimal getTotalPrice();

}
