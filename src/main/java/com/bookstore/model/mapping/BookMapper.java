package com.bookstore.model.mapping;

import com.bookstore.model.dto.Book;
import com.bookstore.model.entity.BookEntity;
import com.bookstore.model.entity.CategoryEntity;
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

    @Mapping(source = "category.name", target = "category")
    @Mapping(source = "cover.id", target = "coverId")
    public abstract Book bookEntityToBook(BookEntity bookEntity);

    @Mapping(source = "category", target = "category", qualifiedByName = "category")
    @Mapping(source = "cover", target = "cover.bytes")
    public abstract BookEntity bookFormToBookEntity(BookForm bookForm);

    @AfterMapping
    public void bookEntityAfterMapping(@MappingTarget BookEntity bookEntity) {
        bookEntity.getCover().setBook(bookEntity);
    }

    @Named("category")
    protected CategoryEntity categoryToCategoryEntity(String category) {
        return categoryRepository.findByName(category).orElseThrow(IllegalArgumentException::new);
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
