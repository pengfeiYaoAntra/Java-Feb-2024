package com.training.demo;

public class ThisAsConstructorParam {

    int bankAccount = 1001;
    ThisAsConstructorParam(){
        Data data = new Data(this);
        data.out();
    }

    public static void main(String[] args) {
        new ThisAsConstructorParam();
    }
}

class Data{
    ThisAsConstructorParam param;
    Data(ThisAsConstructorParam param){
        this.param = param;
    }
    void out(){
        System.out.println(param.bankAccount);
    }
}
