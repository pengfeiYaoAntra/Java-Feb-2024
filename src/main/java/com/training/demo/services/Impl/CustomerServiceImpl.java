package com.training.demo.services.Impl;

import com.training.demo.Repository.CustomerRepo;
import com.training.demo.entities.Customer;
import com.training.demo.services.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;
@Service
public class CustomerServiceImpl implements CustomerService {
    private final CustomerRepo customerRepo;
    /*
     if you are using newer version you do not need @Autowired annotation here
     if you are using older version, you do need it

     */
    @Autowired
    public CustomerServiceImpl(CustomerRepo customerRepo){
        this.customerRepo = customerRepo;
    }
    @Override
    public Optional<Customer> getAllCustomerById(int id) {
        Optional<Customer> customerOptional = customerRepo.findById(id);
        return customerOptional;
    }
}
