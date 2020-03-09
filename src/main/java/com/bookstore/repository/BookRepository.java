package com.bookstore.repository;

import com.bookstore.model.entity.BookEntity;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface BookRepository extends JpaRepository<BookEntity, Long> {

    List<BookEntity> findByTitleContaining(String title);

    List<BookEntity> findByAuthorContaining(String author);

    List<BookEntity> findByIsbnContaining(String isbn);

    List<BookEntity> findAllByCategoryId(Long categoryId, Pageable pageable);

    Long countByCategoryId(Long categoryId);

}
