package com.bookstore.model.dto;

import lombok.Data;

import java.io.Serializable;
import java.util.Objects;

@Data
public class Customer implements Serializable {

    private Long id;

    private String firstName;

    private String lastName;

    private String address;

    private String country;

    private String state;

    private String zip;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Customer customer = (Customer) o;
        return Objects.equals(id, customer.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

}
