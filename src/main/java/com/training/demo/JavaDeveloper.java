package com.training.demo;

import org.springframework.stereotype.Component;

@Component("Java")
public class JavaDeveloper implements SoftwareEng{
    @Override
    public void sayHello() {
        System.out.println("Hello, I am Java developer");
    }
}
