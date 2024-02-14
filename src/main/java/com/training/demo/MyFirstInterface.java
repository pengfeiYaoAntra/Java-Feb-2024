package com.training.demo;

public interface MyFirstInterface {
    String name = "my name";// default is final
//    public MyFirstAbsClass(){} not allow to have constructor
    void thisIsNormalMethod();// no method body needed
    default void thisIsDefault(){
        System.out.println("default");
    }
}
