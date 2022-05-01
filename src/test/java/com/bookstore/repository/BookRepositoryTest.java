package com.bookstore.repository;

import com.bookstore.model.entity.BookEntity;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@DataJpaTest
public class BookRepositoryTest {

    @Autowired
    private TestEntityManager entityManager;

    @Autowired
    private BookRepository bookRepository;

    @Test
    public void givenBook_whenFindByNameContaining_thenReturnBook() {

        BookEntity bookOne = new BookEntity();
        bookOne.setTitle("The C Programming Language");

        BookEntity bookTwo = new BookEntity();
        bookTwo.setTitle("The C Programming Language");

        entityManager.persist(bookOne);
        entityManager.persist(bookTwo);
        entityManager.flush();

        List<BookEntity> list = bookRepository.findByTitleContaining("The");

        assertThat(list.size()).isEqualTo(2);
    }

}