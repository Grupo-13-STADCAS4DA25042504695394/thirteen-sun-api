package com.thirteen.sun.sun_api.service;

import org.springframework.stereotype.Service;

import com.thirteen.sun.sun_api.models.Customer;
import com.thirteen.sun.sun_api.repository.CustomerRepository;

import java.util.List;
@Service
public class CustomerService {

    private final CustomerRepository customerRepository;

    public CustomerService(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }

    public Customer createCustomer(Customer customer) {
        return customerRepository.save(customer);
    }

    public List<Customer> findAll() {
        return customerRepository.findAll();
    }

    public Customer findById(Long id) {
        return customerRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Customer não encontrado"));
    }

    public void delete(Long id) {
        customerRepository.deleteById(id);
    }
}
