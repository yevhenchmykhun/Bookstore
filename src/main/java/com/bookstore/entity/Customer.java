package com.bookstore.entity;

import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Data
@Entity
public class Customer implements Serializable {

    @Id
    @GeneratedValue
    private Long id;

    private String address;

    @Column(name = "cc_number")
    private String ccNumber;

    @Column(name = "city_region")
    private String cityRegion;

    private String email;

    private String name;

    private String phone;

    // bi-directional many-to-one association to CustomerOrder
    @OneToMany(mappedBy = "customer")
    private List<CustomerOrder> customerOrders;

    public void addCustomerOrder(CustomerOrder customerOrder) {
        customerOrder.setCustomer(this);
        getCustomerOrders().add(customerOrder);
    }

}
