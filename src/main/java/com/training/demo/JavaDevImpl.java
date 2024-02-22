package com.training.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component
public class JavaDevImpl {

    @Autowired
    @Qualifier("Java")
    SoftwareEng softwareEng;

    public void service(){
        softwareEng.sayHello();
    }


}
