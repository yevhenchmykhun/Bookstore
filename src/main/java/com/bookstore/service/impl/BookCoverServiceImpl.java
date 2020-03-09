package com.bookstore.service.impl;

import com.bookstore.model.dto.BookCover;
import com.bookstore.model.entity.BookCoverEntity;
import com.bookstore.model.mapping.BookCoverMapper;
import com.bookstore.repository.BookCoverRepository;
import com.bookstore.service.BookCoverService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
@Transactional
public class BookCoverServiceImpl implements BookCoverService {

    private BookCoverRepository repository;

    private BookCoverMapper bookCoverMapper;

    public BookCoverServiceImpl(BookCoverRepository repository, BookCoverMapper bookCoverMapper) {
        this.repository = repository;
        this.bookCoverMapper = bookCoverMapper;
    }

    @Override
    public Optional<BookCover> findById(Long id) {
        Optional<BookCoverEntity> bookCoverEntity = repository.findById(id);
        return bookCoverEntity.map(entity -> bookCoverMapper.bookCoverEntityToBookCover(entity));
    }

}
