package com.training.demo;

import java.util.concurrent.*;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicStampedReference;

/*
 CAS: compare and set -> compare and swap
 Memory location(V):
 Expected old value(E):
 New value(N):

the problem of CAS is ABA problem

----------time line --------------->
----thread 1 get the value v: Aat time 1----- ---------------------------------------------------------------------------thread finished computation at time four and change v to c->
------------thread 2 get the value v: A  and change v to B at time 2 and thread 2 change v back to A at time 3



    what is atomic operation?
        atomic operation is an unit of operation always execute together

        read - modify - write operation: multiple thread are allow to read one shared resource together,
                                        allow only ONE thread to modify and write operation at one time.

thread pools in java

Fixed size thread pool
has a fixed number of threads
once the threads created, the threads are kept alive until the thread pool is shut down
when to use?
    the number of tasks (threads) is known in advance

cached thread pool
it is an unbounded thread pool that  creates new threads as your system needs
when new thread should be created
when there is no idle threads in the pool, you need to create a new thread

have a negative impact on performance of your application if too many threads are created and destroyed frequently



single threaded pool
one thread will execute your tasks sequentially


fork join pool
dividing large tasks into a smaller tasks

smaller tasks can be executed in parallel

work-stealing thread pool
when a thread completes its own task, the tread may "steal" tasks from the other threads

executor vs executor service vs executors
executor: a simple interface that allows you execute a runnable task asynchronously

executor service : allows you manage the status of the service: shutting down, submit, terminal


executors: a way to create different thread pool


concurrent hash map java before java 8
array + linkedlist
synchronized for each segment
[segment 0][][]..[segment 15]
    |
    node 1
    |
    node 2
    |...
concurrent hash map after java 8

array + linked list / red-black tree


blocking queue
put method and take method
takeIndex =
|
[] [] [] [] [] []
|
putIndex = 5 ->



 */
public class DayFour {
    public static void main(String[] args) {


        // current thread
        AtomicInteger atomicInteger = new AtomicInteger(0);
        int expectedValue = 0;
        int newValue = 1;
        System.out.println("Result is " + atomicInteger.compareAndSet(expectedValue,newValue));
        System.out.println("New value is " + atomicInteger.get());

        //assuming other thread changed initial value from 0 to 1
        AtomicInteger atomicInteger1 = new AtomicInteger(1);
        int expectedValue1 = 0;
        int newValue1 = 2;
        System.out.println("Result is " + atomicInteger1.compareAndSet(expectedValue1,newValue1));
        System.out.println("New value is " + atomicInteger1.get());

        // suppose we have a large size int array, we using fork join pool to compute sum of all elements in the array

    }
}
