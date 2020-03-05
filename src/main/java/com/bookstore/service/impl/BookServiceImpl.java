package com.bookstore.service.impl;

import com.bookstore.entity.Book;
import com.bookstore.repository.BookRepository;
import com.bookstore.service.BookService;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class BookServiceImpl implements BookService {

    private BookRepository repository;

    public BookServiceImpl(BookRepository repository) {
        this.repository = repository;
    }

    @Override
    public Optional<Book> findById(Long id) {
        return repository.findById(id);
    }

    @Override
    public List<Book> findByNameContaining(String title) {
        return repository.findByNameContaining(title);
    }

    @Override
    public List<Book> findByAuthorContaining(String author) {
        return repository.findByAuthorContaining(author);
    }

    @Override
    public List<Book> findByIsbnContaining(String isbn) {
        return repository.findByIsbnContaining(isbn);
    }


    @Override
    public List<Book> findAllByCategoryId(Long categoryId, Pageable pageable) {
        return repository.findAllByCategoryId(categoryId, pageable);
    }

    @Override
    public Long countByCategoryId(Long categoryId) {
        return repository.countByCategoryId(categoryId);
    }

}
