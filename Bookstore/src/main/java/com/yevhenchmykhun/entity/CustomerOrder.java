package com.yevhenchmykhun.entity;

import javax.persistence.*;
import java.io.Serializable;
import java.math.BigDecimal;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "customer_order")
public class CustomerOrder implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

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

    public CustomerOrder() {
        this.orderedBooks = new ArrayList<OrderedBook>();
    }

    public int getId() {
        return this.id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public BigDecimal getAmount() {
        return this.amount;
    }

    public void setAmount(BigDecimal amount) {
        this.amount = amount;
    }

    public int getConfirmationNumber() {
        return this.confirmationNumber;
    }

    public void setConfirmationNumber(int confirmationNumber) {
        this.confirmationNumber = confirmationNumber;
    }

    public Timestamp getDateCreated() {
        return this.dateCreated;
    }

    public void setDateCreated(Timestamp dateCreated) {
        this.dateCreated = dateCreated;
    }

    public Customer getCustomer() {
        return this.customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public List<OrderedBook> getOrderedBooks() {
        return this.orderedBooks;
    }

    public void setOrderedBooks(List<OrderedBook> orderedBooks) {
        this.orderedBooks = orderedBooks;
    }

    public OrderedBook addOrderedBook(OrderedBook orderedBook) {
        getOrderedBooks().add(orderedBook);
        orderedBook.setCustomerOrder(this);

        return orderedBook;
    }

    public OrderedBook removeOrderedBook(OrderedBook orderedBook) {
        getOrderedBooks().remove(orderedBook);
        orderedBook.setCustomerOrder(null);

        return orderedBook;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("CustomerOrder{");
        sb.append("id=").append(id);
        sb.append(", amount=").append(amount);
        sb.append(", dateCreated=").append(dateCreated);
        sb.append('}');
        return sb.toString();
    }
}