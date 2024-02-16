package com.training.demo;

import java.util.Optional;

public class Student  {
    private int age;
    private String name;
    private Optional<String> nickName;
    Student(){
        System.out.println("no agrs cons");
    }

    Student(int age, String name, Optional<String> nickName){
        this();
        this.name = name;
        this.age = age;
        this.nickName = nickName;
//        age =  age;no "this" keyword, you are not assign to the current object
//        name = name;//
    }

    public int getAge() {
        return age;
    }

    public Optional<String> getNickName() {
        return nickName;
    }

    public String getName() {
        return name;
    }
    //    void method1(Student student){
//        System.out.println("this keyword is used as a parameter: " + student.name +" age is " + student.age);
//    }
//    void method2(){
//        method1(this);
//    }
//
//    public void sayHello(){
//        System.out.println(name +" : " + age);
//    }
//    Student getThisStudent(){
//        System.out.println("calling getThisStudnet function");
//        return this;
//    }
//    void out(){
//        System.out.println("calling out function");
//    }

//    public static void main(String[] args) {
////        Student stu1 = new Student(20, "pengfei");
////        stu1.sayHello();
////        stu1.method2();
//        //new Student().getThisStudent().out();
//        // stu2.out()
//    }

}
