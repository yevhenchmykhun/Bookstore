package com.bookstore.model.dto;

import lombok.Data;
import lombok.EqualsAndHashCode;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

@Data
@EqualsAndHashCode(of = "id")
public class Order implements Serializable {
    private Long id;
    private BigDecimal totalAmount;
    private Date creationDate;
    private Customer customer;
}
