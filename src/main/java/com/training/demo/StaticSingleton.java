package com.training.demo;

public class StaticSingleton {
    private static StaticSingleton instance;
    static {
        try{
            instance = new StaticSingleton();
        }catch (Exception e){
            throw  new RuntimeException("cannot create Static singleton");
        }
    }
    private StaticSingleton(){}
    public static StaticSingleton getInstance(){
        return instance;
    }
}
