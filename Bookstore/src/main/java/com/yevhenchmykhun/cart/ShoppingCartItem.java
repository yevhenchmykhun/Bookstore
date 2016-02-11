package com.yevhenchmykhun.cart;

import java.math.BigDecimal;

import com.yevhenchmykhun.entity.Book;

public class ShoppingCartItem {

	private Book book;
	private int quantity;

	public ShoppingCartItem(Book book) {
		this.book = book;
		quantity = 1;
	}

	public Book getBook() {
		return book;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public void incrementQuantity() {
		quantity++;
	}

	public void decrementQuantity() {
		quantity--;
	}

	public BigDecimal getTotal() {
		return book.getPrice().multiply(new BigDecimal(quantity));
	}

}
