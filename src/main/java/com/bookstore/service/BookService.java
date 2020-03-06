package com.bookstore.service;

import com.bookstore.model.entity.Book;
import org.springframework.data.domain.Pageable;

import java.util.List;
import java.util.Optional;

public interface BookService {

    List<Book> findByNameContaining(String title);

    List<Book> findByAuthorContaining(String author);

    List<Book> findByIsbnContaining(String isbn);

    Optional<Book> findById(Long id);

    List<Book> findAllByCategoryId(Long categoryId, Pageable pageable);

    List<Book> findAll();

    Long countByCategoryId(Long categoryId);

}
