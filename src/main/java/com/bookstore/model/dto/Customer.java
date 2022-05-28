package com.bookstore.model.dto;

import lombok.Data;
import lombok.EqualsAndHashCode;

import java.io.Serializable;

@Data
@EqualsAndHashCode(of = "id")
public class Customer implements Serializable {
    private Long id;
    private String firstName;
    private String lastName;
    private String address;
    private String country;
    private String state;
    private String zip;
}
