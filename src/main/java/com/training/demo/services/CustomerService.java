package com.training.demo.services;

import com.training.demo.entities.Customer;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public interface CustomerService {
    Optional<Customer> getAllCustomerById(int id);
}
