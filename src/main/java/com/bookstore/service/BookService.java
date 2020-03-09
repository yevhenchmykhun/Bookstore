package com.bookstore.service;

import com.bookstore.model.dto.Book;
import com.bookstore.model.entity.BookEntity;
import com.bookstore.web.ui.form.BookForm;
import org.springframework.data.domain.Pageable;

import java.util.List;
import java.util.Optional;

public interface BookService {

    List<BookEntity> findByNameContaining(String title);

    List<BookEntity> findByAuthorContaining(String author);

    List<BookEntity> findByIsbnContaining(String isbn);

    Optional<Book> findById(Long id);

    List<BookEntity> findAllByCategoryId(Long categoryId, Pageable pageable);

    List<BookEntity> findAll();

    Long countByCategoryId(Long categoryId);

    BookEntity save(BookForm bookForm);

}
