package com.bookstore.model.entity;

import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;
import java.math.BigDecimal;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

@Data
@Entity
@Table(name = "customer_order")
public class OrderEntity implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "customer_order")
    @SequenceGenerator(name="customer_order", sequenceName = "customer_order_seq", allocationSize = 1)
    private Long id;

    @Column(name = "total_amount")
    private BigDecimal totalAmount;

    @Column(name = "creation_date")
    private Timestamp creationDate = new Timestamp(System.currentTimeMillis());

    @ManyToOne(cascade = CascadeType.PERSIST, fetch = FetchType.LAZY)
    private CustomerEntity customer;

    @OneToMany(cascade = CascadeType.PERSIST, mappedBy = "order", fetch = FetchType.LAZY)
    private List<OrderedBookEntity> orderedBooks = new ArrayList<>();

}
