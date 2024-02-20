package com.training.demo;

public class ThreadSafeSIngleton {
    private  static  ThreadSafeSIngleton instance;
    private ThreadSafeSIngleton(){}
    public static  synchronized ThreadSafeSIngleton getInstance(){
        if(instance == null){
            instance = new ThreadSafeSIngleton();
        }
        return instance;
    }
}
