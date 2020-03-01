package com.yevhenchmykhun.service;

import com.yevhenchmykhun.entity.Book;
import org.springframework.data.domain.Pageable;

import java.util.List;
import java.util.Optional;

public interface BookService {

    Optional<Book> findById(Long id);

    List<Book> findAllByCategoryId(Long categoryId, Pageable pageable);

    Long countByCategoryId(Long categoryId);

}
