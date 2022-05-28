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
    public abstract Book toBook(BookEntity bookEntity);

    @Mapping(source = "categoryId", target = "category", qualifiedByName = "categoryById")
    public abstract BookEntity toBookEntity(Book book);

    @Mapping(source = "category", target = "category", qualifiedByName = "categoryByName")
    public abstract BookEntity toBookEntity(BookForm bookForm);

    @Named("categoryByName")
    protected CategoryEntity toCategoryEntity(String category) {
        return categoryRepository.findByName(category).orElseThrow(IllegalArgumentException::new);
    }

    @Named("categoryById")
    protected CategoryEntity toCategoryEntity(Long categoryId) {
        return categoryRepository.findById(categoryId).orElseThrow(IllegalArgumentException::new);
    }

}
