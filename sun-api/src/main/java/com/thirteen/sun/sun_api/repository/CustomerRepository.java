package com.thirteen.sun.sun_api.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.thirteen.sun.sun_api.models.Customer;

import java.util.Optional;

public interface CustomerRepository extends JpaRepository<Customer, Long> {
    Optional<Customer> findByEmail(String email);
}
