package com.bookstore.service.impl;

import com.bookstore.model.dto.BookCover;
import com.bookstore.model.entity.BookCoverEntity;
import com.bookstore.model.mapping.BookCoverMapper;
import com.bookstore.repository.BookCoverRepository;
import com.bookstore.service.BookCoverService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
@Transactional
@RequiredArgsConstructor
public class BookCoverServiceImpl implements BookCoverService {

    private final BookCoverRepository repository;

    private final BookCoverMapper bookCoverMapper;

    @Override
    public Optional<BookCover> findById(Long id) {
        Optional<BookCoverEntity> bookCoverEntity = repository.findById(id);
        return bookCoverEntity.map(bookCoverMapper::bookCoverEntityToBookCover);
    }

}
