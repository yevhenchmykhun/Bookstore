package com.bookstore.service.impl;

import com.bookstore.model.entity.BookCoverEntity;
import com.bookstore.repository.BookCoverRepository;
import com.bookstore.service.BookCoverService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
@Transactional
public class BookCoverServiceImpl implements BookCoverService {

    private BookCoverRepository repository;

    public BookCoverServiceImpl(BookCoverRepository repository) {
        this.repository = repository;
    }

    @Override
    public Optional<BookCoverEntity> findById(Long id) {
        return repository.findById(id);
    }

}
