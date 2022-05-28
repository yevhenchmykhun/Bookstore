package com.bookstore.model.dto;

import lombok.Data;
import lombok.EqualsAndHashCode;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

@Data
@EqualsAndHashCode(of = "id")
public class Book implements Serializable {

    private Long id;

    private String author;

    private String description;

    private String isbn;

    private Date lastUpdate;

    private String title;

    private BigDecimal price;

    private Integer quantity;

    private String category;

    private String s3CoverKey;

    private Long categoryId;

}
