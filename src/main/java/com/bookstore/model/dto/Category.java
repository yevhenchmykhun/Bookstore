package com.bookstore.model.dto;

import lombok.Data;
import lombok.EqualsAndHashCode;

import java.io.Serializable;
import java.util.List;

@Data
@EqualsAndHashCode(of = "id")
public class Category implements Serializable {
    private Long id;
    private String name;
    private List<Book> books;
}
