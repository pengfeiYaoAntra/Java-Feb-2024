package com.training.demo;

public class BillPughSingleton {
    private BillPughSingleton(){}
    private static  class BillPughHelper{
        private static  final BillPughSingleton INSTANCE = new BillPughSingleton();
    }
    public static BillPughSingleton getInstance(){
        return BillPughHelper.INSTANCE;
    }


}
