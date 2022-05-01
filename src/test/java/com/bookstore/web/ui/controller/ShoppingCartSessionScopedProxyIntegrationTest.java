package com.bookstore.web.ui.controller;

import com.bookstore.config.MainConfig;
import com.bookstore.service.BookService;
import com.bookstore.service.CategoryService;
import com.bookstore.web.ui.controller.user.CartController;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.context.annotation.Import;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.model;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(CartController.class)
@Import({TestConfig.class, MainConfig.class})
public class ShoppingCartSessionScopedProxyIntegrationTest {

    @Autowired
    private MockMvc mvc;

    @MockBean
    private BookService bookService;

    @MockBean
    private CategoryService categoryService;

    @Test
    public void whenFirstRequest_thenContainsUninitializedShoppingCart() throws Exception {
        mvc.perform(get("/cart"))
                .andExpect(status().isOk())
                .andExpect(model().attributeExists("cart"))
                .andReturn();
    }

}