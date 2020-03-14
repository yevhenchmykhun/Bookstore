package com.bookstore.web.rest;


import com.bookstore.model.entity.BookEntity;
import com.bookstore.repository.BookRepository;
import com.bookstore.web.ui.controller.user.advice.NavigationAttributesControllerAdvice;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import java.util.Collections;
import java.util.List;

import static org.hamcrest.Matchers.hasSize;
import static org.hamcrest.Matchers.is;
import static org.mockito.BDDMockito.given;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@WebMvcTest({BookRestController.class, NavigationAttributesControllerAdvice.class})
public class BookRestControllerIntegrationTest {

    @Autowired
    private MockMvc mvc;

    @MockBean
    private BookRepository bookRepository;

    @MockBean
    private NavigationAttributesControllerAdvice navigationAttributesControllerAdvice;

    @Test
    public void givenBooks_whenGetAllBooks_thenReturnJsonArray() throws Exception {

        BookEntity book = new BookEntity();
        book.setTitle("The C Programming Language");

        List<BookEntity> books = Collections.singletonList(book);

        given(bookRepository.findAll()).willReturn(books);

        mvc.perform(get("/books")
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$", hasSize(1)))
                .andExpect(jsonPath("$[0].title", is(books.get(0).getTitle())));
    }

}
