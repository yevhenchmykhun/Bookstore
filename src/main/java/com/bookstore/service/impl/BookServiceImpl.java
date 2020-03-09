package com.bookstore.service.impl;

import com.bookstore.model.dto.Book;
import com.bookstore.model.entity.BookEntity;
import com.bookstore.model.mapping.BookMapper;
import com.bookstore.repository.BookRepository;
import com.bookstore.service.BookService;
import com.bookstore.web.ui.form.BookForm;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@Transactional
public class BookServiceImpl implements BookService {

    private BookRepository repository;

    private BookMapper bookMapper;

    public BookServiceImpl(BookRepository repository, BookMapper bookMapper) {
        this.repository = repository;
        this.bookMapper = bookMapper;
    }

    @Override
    public Optional<Book> findById(Long id) {
        Optional<BookEntity> bookEntity = repository.findById(id);
        return bookEntity.map(entity -> bookMapper.bookEntityToBook(entity));
    }

    @Override
    public List<Book> findByNameContaining(String title) {
        return repository.findByTitleContaining(title).stream()
                .map(entity -> bookMapper.bookEntityToBook(entity))
                .collect(Collectors.toList());
    }

    @Override
    public List<Book> findByAuthorContaining(String author) {
        return repository.findByAuthorContaining(author).stream()
                .map(entity -> bookMapper.bookEntityToBook(entity))
                .collect(Collectors.toList());
    }

    @Override
    public List<Book> findByIsbnContaining(String isbn) {
        return repository.findByIsbnContaining(isbn).stream()
                .map(entity -> bookMapper.bookEntityToBook(entity))
                .collect(Collectors.toList());
    }


    @Override
    public List<Book> findAllByCategoryId(Long categoryId, Pageable pageable) {
        return repository.findAllByCategoryId(categoryId, pageable).stream()
                .map(entity -> bookMapper.bookEntityToBook(entity))
                .collect(Collectors.toList());
    }

    @Override
    public List<Book> findAll() {
        return repository.findAll().stream()
                .map(entity -> bookMapper.bookEntityToBook(entity))
                .collect(Collectors.toList());
    }

    @Override
    public Long countByCategoryId(Long categoryId) {
        return repository.countByCategoryId(categoryId);
    }

    @Override
    public Book save(BookForm bookForm) {
        BookEntity bookEntity = bookMapper.bookFormToBookEntity(bookForm);
        bookEntity = repository.saveAndFlush(bookEntity);
        return bookMapper.bookEntityToBook(bookEntity);
    }

}
