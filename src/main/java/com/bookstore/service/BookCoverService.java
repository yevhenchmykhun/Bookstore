package com.bookstore.service;

import com.bookstore.model.dto.BookCover;

import java.util.Optional;

public interface BookCoverService {

    Optional<BookCover> findById(Long id);

}
