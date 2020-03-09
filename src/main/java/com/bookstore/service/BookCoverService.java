package com.bookstore.service;

import com.bookstore.model.entity.BookCoverEntity;

import java.util.Optional;

public interface BookCoverService {

    Optional<BookCoverEntity> findById(Long id);

}
