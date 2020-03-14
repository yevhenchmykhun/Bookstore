package com.bookstore.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.annotation.Order;
import org.springframework.security.access.hierarchicalroles.RoleHierarchy;
import org.springframework.security.access.hierarchicalroles.RoleHierarchyImpl;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(prePostEnabled = true)
public class SecurityConfig {

    @Configuration
    @Order(1)
    public static class AdminSecurityConfig extends WebSecurityConfigurerAdapter {

        @Override
        public void configure(AuthenticationManagerBuilder auth) throws Exception {
            auth
                    .inMemoryAuthentication()
                    .withUser("admin").password("{noop}admin").roles("ADMIN")
                    .and()
                    .withUser("superadmin").password("{noop}superadmin").roles("SUPER_ADMIN");
        }

        @Override
        protected void configure(HttpSecurity http) throws Exception {
            http
                    .csrf().disable()
                    .authorizeRequests()
                    .antMatchers("/admin/**").hasAnyRole("ADMIN", "SUPER_ADMIN")
                    .antMatchers("/actuator/**").hasAnyRole("SUPER_ADMIN")
                    .and()
                    .formLogin();
        }

        @Bean
        public RoleHierarchy roleHierarchy() {
            RoleHierarchyImpl roleHierarchy = new RoleHierarchyImpl();
            roleHierarchy.setHierarchy("ROLE_SUPER_ADMIN > ROLE_ADMIN");
            return roleHierarchy;
        }

    }

    @Configuration
    @Order(2)
    public static class UserSecurityConfig extends WebSecurityConfigurerAdapter {

        @Override
        protected void configure(HttpSecurity http) throws Exception {
            http
                    .csrf().disable()
                    .antMatcher("/**")
                    .authorizeRequests()
                    .anyRequest()
                    .permitAll();
        }

    }

}
