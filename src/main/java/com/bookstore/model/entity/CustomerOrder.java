package com.bookstore.model.entity;

import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;
import java.math.BigDecimal;
import java.sql.Timestamp;
import java.util.List;

@Data
@Entity
@Table(name = "customer_order")
public class CustomerOrder implements Serializable {

    @Id
    @GeneratedValue
    private Long id;

    private BigDecimal amount;

    @Column(name = "confirmation_number")
    private int confirmationNumber;

    @Column(name = "date_created")
    private Timestamp dateCreated;

    //bi-directional many-to-one association to Customer
    @ManyToOne
    private Customer customer;

    //bi-directional many-to-one association to OrderedBook
    @OneToMany(mappedBy = "customerOrder")
    private List<OrderedBook> orderedBooks;

    public void addOrderedBook(OrderedBook orderedBook) {
        orderedBook.setCustomerOrder(this);
        getOrderedBooks().add(orderedBook);
    }

}
