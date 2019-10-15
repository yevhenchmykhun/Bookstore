package com.yevhenchmykhun.entity;

import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Data
@Entity
@Table(name = "customer")
public class Customer implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

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

    public CustomerOrder addCustomerOrder(CustomerOrder customerOrder) {
        getCustomerOrders().add(customerOrder);
        customerOrder.setCustomer(this);

        return customerOrder;
    }

}