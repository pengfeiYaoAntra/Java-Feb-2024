package com.training.demo;

public class IPadCreator extends FactoryCreator{
    @Override
    public Apple factoryMethod() {
        return new IPad();
    }
}
