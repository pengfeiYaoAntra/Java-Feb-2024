package com.training.demo;

public class Prototype implements Cloneable {
    private String name;
    private Integer age;

    Prototype(String name, Integer age){
        this.age= age;
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public void setName(String name) {
        this.name = name;
    }
    @Override
    protected Object clone() throws CloneNotSupportedException {
        return super.clone();
    }
}
