package com.training.demo;

import java.util.concurrent.Callable;

public class MyCallable implements Callable<String> {
    @Override
    public String call() throws Exception{
        System.out.println("callable method is called");
        return "hello my callable class";
    }
}
