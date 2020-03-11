package com.bookstore.model.entity;

import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;

@Data
@Entity
@Table(name = "ordered_book")
public class OrderedBookEntity implements Serializable {

    @Id
    @GeneratedValue
    private Long id;

    private int quantity;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "book_id")
    private BookEntity book;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "customer_order_id")
    private OrderEntity order;

}
