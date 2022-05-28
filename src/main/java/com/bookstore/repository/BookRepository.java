package com.bookstore.repository;

import com.bookstore.model.entity.BookEntity;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface BookRepository extends JpaRepository<BookEntity, Long> {

    @Query("SELECT b FROM BookEntity b WHERE b.title LIKE %?1% OR b.author LIKE %?1% OR b.isbn LIKE %?1%")
    List<BookEntity> findBySearchPhrase(String phrase);

    List<BookEntity> findAllByCategoryId(Long categoryId, Pageable pageable);

    Long countByCategoryId(Long categoryId);

}
