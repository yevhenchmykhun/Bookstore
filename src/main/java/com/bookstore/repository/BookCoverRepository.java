package com.bookstore.repository;

import com.bookstore.model.entity.BookCoverEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BookCoverRepository extends JpaRepository<BookCoverEntity, Long> {
}
