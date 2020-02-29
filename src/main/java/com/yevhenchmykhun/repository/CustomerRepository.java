package com.yevhenchmykhun.repository;

import com.yevhenchmykhun.entity.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CustomerRepository extends JpaRepository<Customer, Long> {
}
