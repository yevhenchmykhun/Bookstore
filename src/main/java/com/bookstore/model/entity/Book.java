package com.bookstore.model.entity;

import lombok.Data;
import lombok.ToString;

import javax.persistence.*;
import java.io.Serializable;
import java.math.BigDecimal;
import java.sql.Timestamp;
import java.util.Date;

@Data
@ToString(of = "name")
@Entity
public class Book implements Serializable {

    @Id
    @GeneratedValue
    private Long id;

    private String author;

    @Column(length = 4096)
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

    @Column(name = "release_date")
    private Date releaseDate;

    private String cover;

    @ManyToOne(fetch = FetchType.EAGER)
    private Category category;

    public boolean isInStock() {
        return quantity > 0;
    }

}
