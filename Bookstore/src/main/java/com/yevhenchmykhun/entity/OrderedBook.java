package com.yevhenchmykhun.entity;

import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;

@Data
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

}