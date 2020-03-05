package com.bookstore.repository;

import com.bookstore.entity.Visitor;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Date;
import java.util.List;

public interface VisitorRepository extends JpaRepository<Visitor, Long> {

    List<Visitor> findByDate(Date date);

}
