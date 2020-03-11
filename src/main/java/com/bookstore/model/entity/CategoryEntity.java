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

    @OneToMany(mappedBy = "category", fetch = FetchType.EAGER)
    private List<BookEntity> books;

}
