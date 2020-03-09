package com.bookstore.model.dto;

import lombok.Data;

import java.math.BigDecimal;

@Data
public class Book {

    private Long id;

    private String author;

    private String description;

    private String isbn;

    private String title;

    private BigDecimal price;

    private Integer quantity;

    private String category;

    private Long coverId;

}
