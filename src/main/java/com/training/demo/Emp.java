package com.training.demo;

public class Emp extends People{
    private int salary;
    Emp(int id, String name, int salary){
        super(id, name);
        this.salary = salary;
    }
    void out(){
        super.sayHello();
        System.out.println("salary" + salary);
    }

    public static void main(String[] args) {
        new Emp(100, "pengfei", 1000).out();
    }
}
