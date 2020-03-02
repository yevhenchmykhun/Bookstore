package com.yevhenchmykhun.cart;

import com.yevhenchmykhun.entity.Book;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class ShoppingCartImpl implements ShoppingCart {

    private List<ShoppingCartItem> items = new ArrayList<>();

    @Override
    public void addItem(Book book) {
        Optional<ShoppingCartItem> shoppingCartItem = items.stream()
                .filter(item -> item.getBook().getId().equals(book.getId()))
                .findFirst();

        if (shoppingCartItem.isPresent()) {
            shoppingCartItem.get().incrementQuantity();
        } else {
            items.add(new ShoppingCartItem(book));
        }
    }

    @Override
    public void deleteItem(Long id) {
        items.removeIf(item -> item.getBook().getId().equals(id));
    }

    @Override
    public List<ShoppingCartItem> getItems() {
        return items;
    }

    @Override
    public int getItemsNumber() {
        return items.size();
    }

    @Override
    public BigDecimal getTotalPrice() {
        return items.stream().map(ShoppingCartItem::getTotalPrice).reduce(BigDecimal.ZERO, BigDecimal::add);
    }

    @Override
    public void clear() {
        items.clear();
    }

    @Override
    public boolean isEmpty() {
        return items.isEmpty();
    }

}
