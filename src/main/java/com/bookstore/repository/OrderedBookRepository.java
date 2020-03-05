package com.bookstore.repository;

import com.bookstore.entity.OrderedBook;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderedBookRepository extends JpaRepository<OrderedBook, Long> {
}
