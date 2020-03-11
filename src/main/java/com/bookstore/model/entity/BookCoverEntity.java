package com.bookstore.model.entity;

import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;

@Data
@Entity
@Table(name = "book_cover")
public class BookCoverEntity implements Serializable {

    @Id
    @GeneratedValue
    private Long id;

    @Lob
    @Column(name = "image")
    private byte[] bytes;

    @OneToOne(mappedBy = "cover", fetch = FetchType.LAZY)
    private BookEntity book;

}
