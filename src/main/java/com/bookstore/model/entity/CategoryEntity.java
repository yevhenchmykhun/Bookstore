package com.bookstore.model.entity;

import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Data
@Entity
@Table(name = "category")
public class CategoryEntity implements Serializable {

    @Id
    @GeneratedValue
    private Long id;

    private String name;

    // bi-directional many-to-one association to Book
    @OneToMany(mappedBy = "category", fetch = FetchType.EAGER)
    private List<BookEntity> books;

}
