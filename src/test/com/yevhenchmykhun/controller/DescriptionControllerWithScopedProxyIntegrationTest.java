package com.yevhenchmykhun.controller;


import com.yevhenchmykhun.cart.ShoppingCart;
import com.yevhenchmykhun.repository.BookRepository;
import com.yevhenchmykhun.repository.CategoryRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.context.annotation.Import;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;

import static org.springframework.test.util.AssertionErrors.assertEquals;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.model;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.MOCK)
//@WebMvcTest(DescriptionController.class)
@AutoConfigureMockMvc
@Import(TestConfig.class)
public class DescriptionControllerWithScopedProxyIntegrationTest {

    @Autowired
    private MockMvc mvc;

    @MockBean
    private BookRepository bookRepository;

    @MockBean
    private CategoryRepository categoryRepository;

    @MockBean
    private ShoppingCart shoppingCart;

    @Test
    public void whenFirstRequest_thenContainsUninitializedShoppingCart() throws Exception {
        MvcResult result = mvc.perform(post("/addToCart").contentType(MediaType.APPLICATION_FORM_URLENCODED_VALUE))
                .andExpect(status().isOk())
                .andExpect(model().attributeExists("shoppingCart"))
                .andReturn();

        ShoppingCart cart = (ShoppingCart) result.getModelAndView().getModel().get("shoppingCart");

        assertEquals("Items in shopping cart", 0, cart.getNumberOfItems());
    }

}