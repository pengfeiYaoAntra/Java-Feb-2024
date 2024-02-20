package com.training.demo;

import java.util.concurrent.TimeUnit;



public class Computer {
    //Scenario 1: using diff threads call the same object
    // As long as one thread call one synchronized method at certain time, other thread should wait the current thread
    // to finish first.
    // resource competition happened
    //synchronized locks the current object.
//    public static void main(String[] args) {
//        Computer computer1 = new Computer();
//        new Thread(()->{
//            computer1.sendEmail();
//        }).start();
//        new Thread(()->{
//            computer1.sendSMS();
//        }).start();
//    }
//    public synchronized void sendEmail(){
//        try{
//            TimeUnit.SECONDS.sleep(3);
//
//        }catch (InterruptedException e){
//            e.printStackTrace();
//        }
//        System.out.println("sending an email");
//        System.out.println("finished send an email");
//    }
//    public synchronized void sendSMS(){
//        System.out.println("sending a sms");
//    }
/*
    Scenario 2: using diff threads call the same object, the first thread call synchronized method and second thread call normal method
        not resource competition happened

// */
//    public static void main(String[] args) {
//        Computer computer1 = new Computer();
//        new Thread(()->{
//            computer1.sendEmail();
//        }).start();
//        new Thread(()->{
//            computer1.externalDevice();
//        }).start();
//    }
//    public synchronized void sendEmail(){
//        try{
//            TimeUnit.SECONDS.sleep(3);
//
//        }catch (InterruptedException e){
//            e.printStackTrace();
//        }
//        System.out.println("sending an email");
//        System.out.println("finished send an email");
//    }
//    public synchronized void sendSMS(){
//        System.out.println("sending a sms");
//    }
//    public void externalDevice(){
//        System.out.println("hello it is an external device");
//    }
    /*
    Scenario 3: using diff threads call  static methods for the same object
                synchronized locks the class itself, not object
                non - synchronized locks the current object


 */
//    public static void main(String[] args) {
//        Computer computer1 = new Computer();
//        Computer computer = new Computer();
//        new Thread(()->{
//            computer1.sendEmail();
//        }).start();
//        new Thread(()->{
//            computer.sendSMS();
//        }).start();
//    }
//    public static synchronized void sendEmail(){
//        try{
//            TimeUnit.SECONDS.sleep(3);
//
//        }catch (InterruptedException e){
//            e.printStackTrace();
//        }
//        System.out.println("sending an email");
//        System.out.println("finished send an email");
//    }
//    public static synchronized void sendSMS(){
//        System.out.println("sending a sms");
//    }
//    public void externalDevice(){
//        System.out.println("hello it is an external device");
//    }
        /*
    Scenario 4: using diff threads call  static methods and non static method in the same object

                synchronized locks the class itself, not object
                non - synchronized locks the current object

 */
    public static void main(String[] args) {
        Computer computer1 = new Computer();

        new Thread(()->{
            computer1.sendEmail();
        }).start();
        new Thread(()->{
            computer1.sendSMS();
        }).start();
    }
    public static synchronized void sendEmail(){
        try{
            TimeUnit.SECONDS.sleep(3);

        }catch (InterruptedException e){
            e.printStackTrace();
        }
        System.out.println("sending an email");
        System.out.println("finished send an email");
    }
    public  synchronized void sendSMS(){
        System.out.println("sending a sms");
    }
    public void externalDevice(){
        System.out.println("hello it is an external device");
    }
}
