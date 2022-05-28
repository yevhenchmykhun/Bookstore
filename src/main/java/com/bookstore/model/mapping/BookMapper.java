package com.bookstore.model.mapping;

import com.bookstore.model.dto.Book;
import com.bookstore.model.entity.BookEntity;
import com.bookstore.model.entity.CategoryEntity;
import com.bookstore.repository.CategoryRepository;
import com.bookstore.web.ui.form.BookForm;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Named;
import org.mapstruct.ReportingPolicy;
import org.springframework.beans.factory.annotation.Autowired;

@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE)
public abstract class BookMapper {

    @Autowired
    protected CategoryRepository categoryRepository;

    @Mapping(source = "category.name", target = "category")
    @Mapping(source = "category.id", target = "categoryId")
    public abstract Book bookEntityToBook(BookEntity bookEntity);

    @Mapping(source = "categoryId", target = "category", qualifiedByName = "categoryById")
    public abstract BookEntity bookToBookEntity(Book book);

    @Mapping(source = "category", target = "category", qualifiedByName = "categoryByName")
    public abstract BookEntity bookFormToBookEntity(BookForm bookForm);

    @Named("categoryByName")
    protected CategoryEntity categoryToCategoryEntity(String category) {
        return categoryRepository.findByName(category).orElseThrow(IllegalArgumentException::new);
    }

    @Named("categoryById")
    protected CategoryEntity categoryToCategoryEntity(Long categoryId) {
        return categoryRepository.findById(categoryId).orElseThrow(IllegalArgumentException::new);
    }

}
