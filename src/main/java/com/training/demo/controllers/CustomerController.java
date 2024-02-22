package com.training.demo.controllers;

import com.training.demo.entities.Customer;
import com.training.demo.services.CustomerService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

/*
    ways to do injection
    field injection:
        @Autowired
        private CustomerService customerService

      setter injection
        setter method

        constructor injection
        better testability, and it is immutable -> thread safe


     @Autowired vs @Qualifier
     Autowired: is used to automatically wire components by type
        filed, setter, maybe constructor injections

      Qualifier is used to resolve injection confusion when there are multiple beans


    if you have component injection confusion
    you can use @Autowired and @Qualifier annotation

    OOP
    spring aop -> aspect- oriented programming
        Aspect -> it is a cross-cutting concern -> contains advice and pointcut

        advice -> it represents the action taken by an aspect at a particular join point
                   implementation of aspect
                   it tells at what moment we need to execute code
                   before joint point(method execution)
                   at the time of method execution
                   after method execution
                   after returning

                   method throws as exception

        join point = (method execution in spring aop)-> it a point here your concern(s) or Aspect gets plugin

        point cut -> can include one or joint point,  we can say point cut is join point, cannot say join point is point cut in some cases


 */
@RestController
public class CustomerController {
    private final CustomerService customerService;
    public CustomerController(CustomerService customerService){
        this.customerService = customerService;
    }
    @GetMapping("/{id}")
    public ResponseEntity<Optional<Customer>> getCustomer(@PathVariable("id") int id){
        return new ResponseEntity<>(customerService.getAllCustomerById(id), HttpStatus.OK);
    }
}
