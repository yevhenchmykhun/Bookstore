package com.bookstore.model.cart;

import com.bookstore.model.dto.Book;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.math.BigDecimal;

@Data
@AllArgsConstructor
public class ShoppingCartItem {

    private Book book;
    private int quantity;

    public ShoppingCartItem(Book book) {
        this(book, 1);
    }

    public void incrementQuantity() {
        quantity++;
    }

    public BigDecimal getTotalPrice() {
        return book.getPrice().multiply(new BigDecimal(quantity));
    }

}
