package com.yevhenchmykhun.entity;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import java.io.Serializable;
import java.util.List;

@Data
@Entity
public class Category implements Serializable {

    @Id
    @GeneratedValue
    private Long id;

    private String name;

    // bi-directional many-to-one association to Book
    @OneToMany(mappedBy = "category")
    private List<Book> books;

}
