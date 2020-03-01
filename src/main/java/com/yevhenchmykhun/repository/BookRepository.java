package com.yevhenchmykhun.repository;

import com.yevhenchmykhun.entity.Book;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface BookRepository extends JpaRepository<Book, Long> {

    List<Book> findByNameContaining(String title);

    List<Book> findByAuthorContaining(String author);

    List<Book> findByIsbnContaining(String isbn);

    List<Book> findAllByCategoryId(Long categoryId, Pageable pageable);

    Long countByCategoryId(Long categoryId);

}
