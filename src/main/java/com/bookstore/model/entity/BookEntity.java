package com.bookstore.model.entity;

import lombok.Data;
import lombok.ToString;

import javax.persistence.*;
import java.io.Serializable;
import java.math.BigDecimal;
import java.sql.Timestamp;

@Data
@ToString(of = "title")
@Entity
@Table(name = "book")
public class BookEntity implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "book")
    @SequenceGenerator(name="book", sequenceName = "book_seq", allocationSize = 1)
    private Long id;

    private String author;

    @Column(length = 4096)
    private String description;

    private String isbn;

    @Column(name = "last_update")
    private Timestamp lastUpdate;

    private String title;

    private BigDecimal price;

    private Integer quantity;

    @OneToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private BookCoverEntity cover;

    @ManyToOne(fetch = FetchType.LAZY)
    private CategoryEntity category;

    @PreUpdate
    private void postUpdate() {
        lastUpdate = new Timestamp(System.currentTimeMillis());
    }

}
