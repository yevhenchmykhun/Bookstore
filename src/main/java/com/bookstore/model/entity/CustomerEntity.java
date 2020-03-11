package com.bookstore.model.entity;

import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Data
@Entity
@Table(name = "customer")
public class CustomerEntity implements Serializable {

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

    @OneToMany(mappedBy = "customer")
    private List<OrderEntity> orders;

}
