package com.bookstore.web.ui.form;

import com.bookstore.web.ui.form.validation.File;
import lombok.Data;
import org.hibernate.validator.constraints.ISBN;
import org.hibernate.validator.constraints.Length;
import org.springframework.http.MediaType;
import org.springframework.web.multipart.MultipartFile;

import javax.validation.constraints.Digits;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;
import java.math.BigDecimal;

@Data
public class BookForm {

    @NotNull
    @Length(max = 255)
    private String title;

    @NotNull
    @Length(max = 255)
    private String author;

    @NotNull
    @ISBN
    private String isbn;

    @NotNull
    @Positive
    @Digits(integer = 6, fraction = 2)
    private BigDecimal price;

    @NotNull
    @Positive
    private Integer quantity;

    @NotNull
    @Length(max = 255)
    private String category;

    @NotNull
    @Length(max = 4096)
    private String description;

    @NotNull
    @File(mediaType = MediaType.IMAGE_JPEG_VALUE, size = 1024 * 128, message = "Only JPEG with size up to 128KB is accepted")
    private MultipartFile cover;

}
