package com.yevhenchmykhun.entity;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "ordered_book")
public class OrderedBook implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private int orderedBookId;

    //bi-directional many-to-one association to Book
    @ManyToOne
    @JoinColumn(name = "book_id")
    private Book book;

    //bi-directional many-to-one association to CustomerOrder
    @ManyToOne
    @JoinColumn(name = "customer_order_id")
    private CustomerOrder customerOrder;

    @Column(name = "quantity")
    private int quantity;

    public OrderedBook() {
    }

    public int getQuantity() {
        return this.quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public Book getBook() {
        return this.book;
    }

    public void setBook(Book book) {
        this.book = book;
    }

    public CustomerOrder getCustomerOrder() {
        return this.customerOrder;
    }

    public void setCustomerOrder(CustomerOrder customerOrder) {
        this.customerOrder = customerOrder;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("OrderedBook{");
        sb.append("quantity=").append(quantity);
        sb.append(", book=").append(book);
        sb.append('}');
        return sb.toString();
    }
}