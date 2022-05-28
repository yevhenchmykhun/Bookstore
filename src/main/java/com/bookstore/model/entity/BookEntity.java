package com.bookstore.model.entity;

import lombok.Data;
import lombok.ToString;

import javax.persistence.*;
import java.io.Serializable;
import java.math.BigDecimal;
import java.sql.Timestamp;

@Entity
@Table(name = "book")
@Data
@ToString(of = "title")
public class BookEntity implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "book")
    @SequenceGenerator(name = "book", sequenceName = "book_seq", allocationSize = 1)
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

    @Column(name = "s3_cover_key")
    private String s3CoverKey;

    @ManyToOne(fetch = FetchType.LAZY)
    private CategoryEntity category;

    @PreUpdate
    private void preUpdate() {
        lastUpdate = new Timestamp(System.currentTimeMillis());
    }

}
