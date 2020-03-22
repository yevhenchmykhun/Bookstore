package com.bookstore.model.mapping;

import com.bookstore.model.dto.Book;
import com.bookstore.model.entity.BookCoverEntity;
import com.bookstore.model.entity.BookEntity;
import com.bookstore.model.entity.CategoryEntity;
import com.bookstore.repository.BookCoverRepository;
import com.bookstore.repository.CategoryRepository;
import com.bookstore.web.ui.form.BookForm;
import org.mapstruct.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.Arrays;

@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE)
public abstract class BookMapper {

    @Autowired
    protected CategoryRepository categoryRepository;

    @Autowired
    protected BookCoverRepository bookCoverRepository;

    @Mapping(source = "category.name", target = "category")
    @Mapping(source = "cover.id", target = "coverId")
    @Mapping(source = "category.id", target = "categoryId")
    public abstract Book bookEntityToBook(BookEntity bookEntity);

    @Mapping(source = "categoryId", target = "category", qualifiedByName = "categoryById")
    @Mapping(source = "coverId", target = "cover", qualifiedByName = "coverById")
    public abstract BookEntity bookToBookEntity(Book book);

    @Mapping(source = "category", target = "category", qualifiedByName = "categoryByName")
    @Mapping(source = "cover", target = "cover.bytes")
    public abstract BookEntity bookFormToBookEntity(BookForm bookForm);

    @Named("categoryByName")
    protected CategoryEntity categoryToCategoryEntity(String category) {
        return categoryRepository.findByName(category).orElseThrow(IllegalArgumentException::new);
    }

    @Named("categoryById")
    protected CategoryEntity categoryToCategoryEntity(Long categoryId) {
        return categoryRepository.findById(categoryId).orElseThrow(IllegalArgumentException::new);
    }

    @Named("coverById")
    protected BookCoverEntity coverToCoverEntity(Long coverId) {
        return bookCoverRepository.findById(coverId).orElseThrow(IllegalArgumentException::new);
    }

    protected byte[] multipartFileToByteArray(MultipartFile file) {
        byte[] array = new byte[0];
        try {
            array = Arrays.copyOf(file.getBytes(), file.getBytes().length);
        } catch (IOException e) {
            e.printStackTrace();
        }

        return array;
    }

}
