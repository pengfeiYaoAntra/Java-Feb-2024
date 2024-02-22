package com.training.demo.entities;

import jakarta.validation.constraints.*;
/*
 to use validation -> @Valid

 how to customized spring validation

    you need to implements ConstrainsValidator interface
    @Constraint
    @Target
    @Retention


    what is TDD -> test driven development
        1: first you need write test code -> red phase: you must create a test for your function/ features
        2: green phase: write code that can pass the tests
        3:refactor: improve the code
        4: go to step 1 -> until you pass all test cases
 */

public class UserSpringValidation {

    @NotNull
    @NotBlank(message = "User name is blank")
    @NotEmpty
    private String name;
    @NotNull
    @NotBlank(message = "the age is blank")
    @NotEmpty
    @Min(value = 0, message = "Age must greater than zero")
    @Max(value = 158, message = "age must less than 158")
    private int age;
    @NotBlank
    @Size(min = 10,max = 15, message = "phone number must be between 10 and 15")
    private String phoneNumber;
}
