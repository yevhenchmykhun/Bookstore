package com.yevhenchmykhun.repository;

import com.yevhenchmykhun.entity.OrderedBook;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderedBookRepository extends JpaRepository<OrderedBook, Long> {
}
