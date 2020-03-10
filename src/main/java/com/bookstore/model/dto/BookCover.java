package com.bookstore.model.dto;

import lombok.Data;

import java.io.Serializable;

@Data
public class BookCover implements Serializable {

    private Long id;

    private byte[] bytes;

}
