package com.yevhenchmykhun.entity;

import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;
import java.math.BigDecimal;
import java.sql.Timestamp;
import java.util.Date;
import java.util.List;

@Data
@Entity
public class Book implements Serializable {

    @Id
    @GeneratedValue
    private Long id;

    private String author;

    private String description;

    private String format;

    private String isbn;

    private String language;

    @Column(name = "last_update")
    private Timestamp lastUpdate;

    private int pages;

    private String name;

    private BigDecimal price;

    private String publisher;

    private int quantity;

    @Column(name = "releasedate")
    private Date releaseDate;

    private String cover;

    // bi-directional many-to-one association to Category
    @ManyToOne
    private Category category;

    // bi-directional many-to-one association to OrderedBook
    @OneToMany(mappedBy = "book")
    private List<OrderedBook> orderedBooks;

}
