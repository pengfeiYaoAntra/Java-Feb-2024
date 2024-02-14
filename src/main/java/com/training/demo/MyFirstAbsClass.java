package com.training.demo;

abstract class MyFirstAbsClass {
     String name;
    public MyFirstAbsClass(String name){// allow to have constructor
        this.name = name;
    }
    abstract void myFirstMethod();// we donot need method body here
    void thisIsMethodWithoutAbstract(){// allow to have normal method in abstract class
        System.out.println("hello from thisIsMethodWithoutAbstract");
    }

}
