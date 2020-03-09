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
        return bookEntity.map(value -> bookMapper.bookEntityToBook(value));
    }

    @Override
    public List<BookEntity> findByNameContaining(String title) {
        return repository.findByTitleContaining(title);
    }

    @Override
    public List<BookEntity> findByAuthorContaining(String author) {
        return repository.findByAuthorContaining(author);
    }

    @Override
    public List<BookEntity> findByIsbnContaining(String isbn) {
        return repository.findByIsbnContaining(isbn);
    }


    @Override
    public List<BookEntity> findAllByCategoryId(Long categoryId, Pageable pageable) {
        return repository.findAllByCategoryId(categoryId, pageable);
    }

    @Override
    public List<BookEntity> findAll() {
        return repository.findAll();
    }

    @Override
    public Long countByCategoryId(Long categoryId) {
        return repository.countByCategoryId(categoryId);
    }

    @Override
    public BookEntity save(BookForm bookForm) {
        BookEntity bookEntity = bookMapper.bookFormToBookEntity(bookForm);
        return repository.saveAndFlush(bookEntity);
    }

}
