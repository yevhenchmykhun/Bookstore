package com.bookstore.web.ui.form;

import lombok.Data;
import lombok.ToString;
import org.springframework.web.multipart.MultipartFile;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Null;
import javax.validation.constraints.Pattern;
import java.math.BigDecimal;

@Data
public class Book {

    @NotNull
    private String title;

    @NotNull
    private String author;

    @NotNull
    private String isbn;

    @NotNull
    private BigDecimal price;

    @NotNull
    private Integer quantity;

    @NotNull
    private String category;

    @NotNull
    MultipartFile cover;

}
