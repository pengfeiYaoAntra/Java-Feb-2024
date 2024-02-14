package com.training.demo;

public class People {
    private int id;
    private String name;
    People(int id, String name){
        this.id = id;
        this.name = name;
    }
    public void sayHello(){
        System.out.println("Hello from people class");
    }
}
