package com.bookstore.config;

import com.bookstore.model.cart.ShoppingCart;
import com.bookstore.model.cart.ShoppingCartImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.web.context.WebApplicationContext;

@Configuration
class MainConfig {

    @Bean
    @Scope(value = WebApplicationContext.SCOPE_SESSION, proxyMode = ScopedProxyMode.INTERFACES)
    public ShoppingCart shoppingCart() {
        return new ShoppingCartImpl();
    }

}
