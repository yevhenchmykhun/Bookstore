package com.bookstore.repository;

import com.bookstore.model.entity.Book;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@RunWith(SpringRunner.class)
@DataJpaTest
public class BookRepositoryIntegrationTest {

    @Autowired
    private TestEntityManager entityManager;

    @Autowired
    private BookRepository bookRepository;

    @Test
    public void givenBook_whenFindByNameContaining_thenReturnBook() {

        Book bookOne = new Book();
        bookOne.setName("The C Programming Language");

        Book bookTwo = new Book();
        bookTwo.setName("The C Programming Language");

        entityManager.persist(bookOne);
        entityManager.persist(bookTwo);
        entityManager.flush();

        List<Book> list = bookRepository.findByNameContaining("The");

        assertThat(list.size()).isEqualTo(2);
    }

}