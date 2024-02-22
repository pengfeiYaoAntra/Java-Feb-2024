package com.training.demo;

import org.springframework.stereotype.Component;

@Component("React")
public class ReactDeveloper implements SoftwareEng{
    @Override
    public void sayHello() {
        System.out.println("Hello, I am React developer");
    }
}
