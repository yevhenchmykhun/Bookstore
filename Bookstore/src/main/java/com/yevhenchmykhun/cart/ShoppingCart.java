package com.yevhenchmykhun.cart;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import com.yevhenchmykhun.entity.Book;

public class ShoppingCart {

	private List<ShoppingCartItem> items;

	public ShoppingCart() {
		items = new ArrayList<ShoppingCartItem>();
	}

	public synchronized void addItem(Book book) {
		boolean newItem = true;
		for (ShoppingCartItem item : items) {
			if (item.getBook().getId() == book.getId()) {
				newItem = false;
				item.incrementQuantity();
			}
		}
		if (newItem) {
			items.add(new ShoppingCartItem(book));
		}
	}

	public synchronized void deleteItem(Book book) {
		for (ShoppingCartItem item : items) {
			if (item.getBook().getId() == book.getId()) {
				items.remove(item);
				return;
			}
		}
	}

	public synchronized void update(Book book, int quantity) {
		if (quantity >= 0) {
			ShoppingCartItem item = null;
			for (ShoppingCartItem cartItem : items) {
				if (cartItem.getBook().getId() == book.getId()) {
					if (quantity != 0) {
						cartItem.setQuantity(quantity);
					} else {
						item = cartItem;
					}
				}
			}
			if (item != null) {
				items.remove(item);
			}
		}
	}

	public synchronized List<ShoppingCartItem> getItems() {
		return items;
	}

	public synchronized int getNumberOfItems() {
		int numberOfItems = 0;
		for (ShoppingCartItem item : items) {
			numberOfItems += item.getQuantity();
		}
		return numberOfItems;
	}

	public synchronized BigDecimal getTotal() {
		BigDecimal amount = new BigDecimal(0);
		for (ShoppingCartItem item : items) {
			amount = amount.add(item.getTotal());
		}
		return amount;
	}

	public synchronized void clear() {
		items.clear();
	}

}
