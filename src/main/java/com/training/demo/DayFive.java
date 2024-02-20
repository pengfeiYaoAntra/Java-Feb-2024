package com.training.demo;

import java.util.concurrent.Callable;

/*
*
* what is JVM？
* it stands for Java Virtual Machine that allows you compiled Java code and execute it on your computer's OS
* JVM components
*Class loader: loading .class file complier to main memory
*
* Execution Engine: for interpreting and executing the bytecode(.class file)
*
* Runtime Data Area: provides memory to store objects, bytecode, parameters, local variables return values...
*
* what diffs with stack and heap
*
* stack : used for store data, like method invocations.
* local variables:  variables that defined in methods.
* method arguments: inputs
* return: values
*
* each thread has its own stack ( they do not share stack with each other) ->
*
* heap:
*
* eden space:all new objects should be belong to here
* survivor space: all new objects moved from eden space after one GC
*
* old generation: all objects in survivor space moved to here after few GC
*
* mate space(after Java 8): stores: class definitions, method definitions
*
*
*  how JVM to determine the object is alive or dead?
* in the old way: the referencing counting method
*  suppose we have class called: ReferenceCount
*   ReferenceCount rc = new ReferenceCount()
*   ReferenceCount rc1 = new ReferenceCount()
*   rc.instance = rc1
*   rc1.instance = rc
*   logic...
*   rc = null ->
*   rc1 = null ->
*
*  The GC roots method
*
*   gc roots: can be local variables, method parameters, static variables, threads stacks, class loader, classes..
*                   [Young obj1, obj2]
*   gc roots ->
*
* GC
*
* stop-the-world(STW): your application need to be stopped for the GC
*
* Normal deletion GC algorithm:
* before: [[obj1][obj2][obj3][obj4][objx][objy][objz][Empty][Empty]]
*After: [[obj1][Empty][obj3][Empty][objx][Empty][objz][Empty][Empty]]
*
* normal deletion GC algo - compacting
 * before: [[obj1][obj2][obj3][obj4][objx][objy][objz][Empty][Empty]]
 *After: [[obj1][obj3][objx][objz][Empty][Empty][Empty][Empty][Empty]]
 *
 *
 * CMS(concurrent mark and sweep):
 * why use this:  it is designed to reduce the impact of STW, to increase you application
 * steps:
 *  1: initial marking phase(STW and fast):
 *  identify the initial set of objects directly reachable from the GC roots( threads, static, local variables...)
 *  during this phase, we are having STW.
 *  The CMS also marks these objects as alive by updating a bitmap:
 *  after this phase, your application should be restarted
 *
 *  2: concurrent marking and sweeping phase(No STW)
 *     while your application is running, the CMS algorithm CONCURRENTLY continues the marking process by tracing
 *      the object bitmap that CMS generated during the phase 1
 *      problem: some objects can be dead and created.
 *  3: remarking phase(STW):
 *      remarking all objects
 *  4: sweeping phase:
 *      after step 3, the CMS performs a CONCURRENT sweeping phase
 *
 * G1 : the steps of G1  are every similar to the CMS
 * [[][][][][]] -> dividing heap into small regions or segments
 *  G1: provides a predicable pause time
 *  mixed collection: it collects both young and old generation together.
 *
 *  1: initial mark: same as CMS
 *  2: concurrent marking: same as CMS
 *  3: remarking: same as CMS
 *  4: sweeping and clean up:
 *
 * how to create thread
*   3 ways: extends thread class and implements callable and runnable interface
* thread states
* new: thread is created but not started yet
* runnable: a thread in the runnable state is executing in jVM
* blocked: one thread is blocked bc waiting for a monitor lock(synchronized)
* terminated: delete thread
* waiting:waiting for another thread to perform a particular action(wait(), join())
* wait(): give up its hold on a shared resource and wait until another thread notifies it to wake up
* sleep(): stop and suspend its execution for a specified amount of time and releases CPU.
* notifyAll(): wake all waiting threads.
* notify(): to wake up another waiting thread
*
*
* volatile
* a way to communicate between different threads
*  prevent your code reordering
*
*
*
*
* synchronized: a pessimistic locker, allows one thread to access shared resource. if other thread wants to read or modify, other thread has to wait outside.
* optimistic locker: only allow threads to read the shared resources. if other thread wants to  modify, other thread has to wait outside.
* Scenario 1: using diff threads call the same object
*
 */

public class DayFive {
    public static void main(String[] args) {
//        int a = 1;// first
//        int b = 2;// first
//        int c  = 3;// first
//        int d = a + b;// always after a and b declared
//         int e = d + c;// always after d updated
//        MyThread myThread = new MyThread();


    }

}
class MyThread extends  Thread{
    @Override
        public  void run(){
        System.out.println("my thread");
    }
}

class MyRunnable implements Runnable{

    @Override
    public void run() {
        System.out.println("my runnable  interface");
    }
}
class MyCallableInterface implements Callable<String>{

    @Override
    public String call() throws Exception {
        return "Hello I am callable";
    }
}