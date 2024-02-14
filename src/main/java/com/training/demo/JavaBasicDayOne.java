package com.training.demo;

import java.util.List;

public class JavaBasicDayOne {
    /*
        **What is OOP in Java?
        * OOP is object-oriented programming
        *   polymorphism: multiple types of your object
        *       overloading: the same method name, but different variables: # of variables, the types of variable
        *       overriding: it happens in a child class. child class would like to inheritance some functions from
        *                       parent class.
        *  encapsulaltion: protect and manage own information.
        *       any obejct should be encapsulated. if you want to change state of the object should modified by that object's method
        *  abstraction:
        *       a class that is declared using the abstract keyword -> hiding information
        *   why do we need abstraction?
        *       hiding some very important information
        *   interface vs abstract class
        *   Inheritance -> code reusability
        *       classes can be created from other classes by using inheritance in java.
        *           keywords: extends and implements
        *   what is object?
        *       two: state, behavior
        *
        *
        * primitive type vs wrapper type
        *   wrapper types offer more functions that allow you directly use: Byte, Short, Integer, Long
        *
        *   Integer[-128,127]\\
        * Integer myInteger1 = 12;
            Integer myInteger2 = 12;
            System.out.println(myInteger1 == myInteger2); -> true-> myInteger1 and myInteger2 are using the same address
            *
            Integer myInteger3 = 222;
            Integer myInteger4 = 222;
            System.out.println(myInteger4 == myInteger3);-> false - > Java creates a new integer object
            *               myInteger3 and myInteger4 are using different address
        * public static Integer valueOf(int i) {
        if (i >= IntegerCache.low && i <= IntegerCache.high)
            return IntegerCache.cache[i + (-IntegerCache.low)];
        return new Integer(i);
        }
        *
        * what are different between "==" and equals function?
        *   primitive type: "==" -> value of primitive int i1 = 1, int i2 = 1 -> i1 == i2 -> true
        *   wrapper type: "==" value of address
        *   Integer myInteger1 = 12; -> Ox11111111
            Integer myInteger2 = 12; -> Ox11111111
        *   Integer myInteger1 = 222; -> Ox11111100
            Integer myInteger2 = 222; -> Ox11111111
            *  wrapper type: equals function - > value of integer
            *
            *
            * string vs string builder vs string buffer
            * String class is declared as final class -> immutable
            * string builder and string buffer are mutable
            *  string builder does not sync keyword, string buffer is thread safe
            *
            * access modifiers:
            *   public: class, method and variable are defined as public, you can access from any class, method.
            *   protected: can be accessed by the class of the same package, or by the sub-class of this class, or with the same class
            *   default: can be accessed within the package only. By default, all class , method, variable are default scope
            *   private: class, method, variable can be accessed within the class only
            *
            *
            *  "this" keyword usage:
            *   1can be used to reference current object -> see student class -> this.age = age
            *       see what happen if there is no "this" keyword
            *   2can be used to call constructor -> see no arg constructor
            *   3can be used as parameter -> method1 and method2 in student class
            *   4"this" can be returned
            *   5can be used as constructor parameter -> see THisAsConstructorParam class
            *
            *   "Super" keyword usage:
            *   1 calling parent object
            *   2 calling parent's function
            *   3: calling parent's constructor
            *
            *   Does Java use pass-by-value or pass-by-reference?
            *   Javac always use pass-by-value
            *   primitive type -> pass actual value of primitive type
            *   object -> pass value of reference
            *
            * shallow copy abd deep copy
            * shallow copy: create a new object, but if you change variable in shallow copy, the variable in original object
            *                           should be changed
            * deep copy: makes an exact copy of the entire object, the changes made in  deep copy object does not change the original objecgt
            *
            *                                Throwable
            *                           exception        error
            *               checked   unchecked             outOfMemory
            *            IOexception   indexOutOfBounds
            *            SQLexception
            *
            * checked vs unchecked
            * checked: happening in COMPILE time
            * unchecked:happening in runtime . unchecked in java is objects of type runtime exception.
            * using try-catch block to handle exceptions
            *
            * Generic in Java -> code reuse, type safe
            * T - type
            * E - element
            * k - key
            * N - number
            * v - value
            *
            *
            *
            * Generic class
            *
            * Generic method
            *
            * bounded generic-> T extends Number
            *
            * wildcards -> it is useful when you wanna to work with a collection(list, set..) without
            *   specifying its element type.
            *
            * generic interface
            *
            *
            *
     */
    public static void main(String[] args) {
            Integer myInteger1 = 12;
            Integer myInteger2 = 12;
            System.out.println(myInteger1 == myInteger2);
            Integer myInteger3 = 222;
            Integer myInteger4 = 222;
            System.out.println(myInteger4 == myInteger3);

        System.out.println(myInteger3.equals(myInteger4));
        String myFirstName = "Pengfei";
        String myLastName = "Yao";
        String fullName = myFirstName + myLastName;
        // java -> String type of myFirstName and myLastName to string builder -> string
        StringBuilder sb = new StringBuilder("sb");
        StringBuffer sb2 = new StringBuffer("sb2");
        try{
            Class clazz = Class.forName("com.training.demo.Emp");}
        catch (ClassNotFoundException e){
            e.printStackTrace();
        }

    }
}

class Car<T extends Number>{

    private T value;
    public  T getValue(){
        return value;
    }
    //list integer, string... other object
    public static <E> E getAllElement(E[] array){
        for(E e : array){
            System.out.println(e);
        }
        return array[1];
    }

    //wildcards
    public static  void printList(List<?> list){
        for(Object element : list){
            System.out.println(element + " ");
        }
    }
}

interface Pair<K,V>{
    K getKey();
    V getValue();
}
class MyPair<K, V> implements Pair<K,V>{
    private K key;
    private V value;
    public MyPair(K key, V value){
        this.key = key;
        this.value = value;
    }

    public K getKey(){
        return key;
    }

    public V getValue(){
        return value;
    }

}
