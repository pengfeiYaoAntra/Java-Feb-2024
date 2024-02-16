package com.training.demo;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

public class ProducerConsumer {

    private BlockingQueue<Integer> queue = new ArrayBlockingQueue<>(10);

    public void produce() throws InterruptedException{
        int value =0;
        while(true){
            System.out.println("value is " + value);
            queue.put(value++);
        }
    }
    public void consume() throws InterruptedException{
        while(true){
            if(queue.size() == 10){
                int value = queue.take();
                System.out.println("consumed: " + value);
                Thread.sleep(1000);
            }
        }
    }

    public static void main(String[] args) {
        ProducerConsumer producerConsumer = new ProducerConsumer();
        Thread produceThread = new Thread(()->{
            try{
                producerConsumer.produce();
            }catch (InterruptedException e){
                e.printStackTrace();
            }
        });
        Thread consumeThread = new Thread(()->{
            try{
                producerConsumer.consume();
            }catch (InterruptedException e){
                e.printStackTrace();
            }
        });

        produceThread.start();
        consumeThread.start();
    }
}
