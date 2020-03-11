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
public class OrderEntity implements Serializable {

    @Id
    @GeneratedValue
    private Long id;

    @Column(name = "total_amount")
    private BigDecimal totalAmount;

    @Column(name = "creation_date")
    private Timestamp creationDate;

    @ManyToOne
    private CustomerEntity customer;

    @OneToMany(mappedBy = "order")
    private List<OrderedBookEntity> orderedBooks;

}
