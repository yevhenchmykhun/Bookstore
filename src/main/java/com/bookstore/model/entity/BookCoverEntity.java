package com.bookstore.model.entity;

import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;

@Data
@Entity
@Table(name = "book_cover")
public class BookCoverEntity implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "book_cover")
    @SequenceGenerator(name="book_cover", sequenceName = "book_cover_seq", allocationSize = 1)
    private Long id;

    @Lob
    @Column(name = "image")
    private byte[] bytes;

    @OneToOne(mappedBy = "cover", fetch = FetchType.LAZY)
    private BookEntity book;

}
