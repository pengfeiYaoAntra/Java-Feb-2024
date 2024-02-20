package com.training.demo;

public class IphoneCreator  extends  FactoryCreator{
    @Override
    public Apple factoryMethod() {
        return new Iphone();
    }
}
