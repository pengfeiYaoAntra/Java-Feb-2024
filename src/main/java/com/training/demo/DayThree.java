package com.training.demo;

import java.math.BigInteger;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Optional;
import java.util.concurrent.*;
import java.util.function.Function;
import java.util.function.Supplier;
import java.util.stream.Collectors;

/*
*
* Day Three: New functions in java 8
* functional interface, stream api, parallel stream api, optional
*  lambda function, completable future, method ref...
*
* functional interface: it MUST have only one abstract method in your class
*
* @FunctionalInterface annotation
* making code readable
*
* runnable, callable, comparator, consumer, Function supplier
*
* lambda expression:
* makes your code more readable and create an anonymous function
*
* reduce the size of your code or project
* No parameter:
* () -> System.out.println("No parameter lambda expression")
* One parameter:
* (int a )-> return a * a;
* a-> a * a
* call thread, runnable, callable
* new Thread(() -> System.out.println("new thread is created")).start();
* using lambda to iterate over the list
* List<Integer> list = Arrays.asList(1,2,3,4,5,6);
        list.forEach(n ->{
            int x = n * 2;
        });
 * comparator
 * List<String> names = Arrays.asList("Java","C","python", "scala");
        Collections.sort(names, (String a, String b) -> b.compareTo(a));
        *
        * Stream api
        * performs aggregate operations on collections
        *
        * two types function:
        *   intermedia function
        *       filter(): selects only the elements in your collection that match a given predicate(if condition)
        *       map(): transforms elements into a new type
        *       flatMap()
        *       sorted()
        *       distinct()
        *   terminal function
        *   forEach()
        *   reduce()
        *   max/min
        *   anyMath/allMath/noneMath
        *
        * collections vs stream api
        *
        * collections: store all elements in memory, but stream api does not store all element in memory
        * collections can be modified by adding or removing elements, whereas stream api does not modify
        *           the original data but create a new stream
        * when you have store and organize data, please use collections
        * when you process data without modify the original list, please use stream api
        *
        *
        *
        * parallel stream api
        *
        * large data -> split large data into smaller streams that be processed in parallel
        * Fork/join
        * improve performance.
        *
        *
        * optional
        * null pointer exception -> optional can avoid
        *
        *
        * Completable Future > future
        *
        * a way to perform asynchronous computation,
        * improve the performance of your application
        * when you have time-comsuming tasks, completable future is useful
        *
        * what is supplier
        *   functional interface -> has only one single method -> get() -> no param and return a value
        *
        * what is consumer
        * functional interface -> has only one single method -> accept() ->take a single parameter and does not
        *                           return a value
        *
        *
        *
        * runAsync vs supply Async
        *
        * runAsync is for runnable tasks that do not return a result, whereas supplyAsync is for supplier
        *  tasks that do return a result
        *
        *
        * get() vs join()
        *  public T get() throws InterruptedException, ExecutionException {
        Object r;
        if ((r = result) == null)
            r = waitingGet(true);
        return (T) reportGet(r);
    }
    *        public T join() {
        Object r;
        if ((r = result) == null)
            r = waitingGet(false);
        return (T) reportJoin(r);
    }
        *
        * ThenApply vs thenRun vs ThenAccept
        * ThenApply: to do task B when task A finish, we have return
        * thenRun: to do task B when task A finish, B needs return of A, but no return value
        * thenAccept: has return, task B depends on task A
        *
        * thenCombine
        *
        * method reference:
        * reference to a static method by using method reference
        *
        * reference to a constructor
        *
        * reference to a particular Object
        *
        *
 */
public class DayThree {
    public static void main(String[] args) throws ExecutionException, InterruptedException {

        List<MethodRefUser> users = Arrays.asList(new MethodRefUser("Bob"), new MethodRefUser("Kelly"), new MethodRefUser("Alice"));
        List<String> userNames = users.stream().map(MethodRefUser::getUserName)
                .sorted()
                .collect(Collectors.toList());
        System.out.println(userNames);
        String myStringObject  = "my string object";
        Supplier<Integer> myStringObjectLen = myStringObject::length;
        System.out.println(myStringObjectLen.get());

        //method reference:
        Function<String, Integer> stringLen = String::length;
        System.out.println(stringLen.apply("hello"));

        Function<String, BigInteger> newInt = BigInteger::new;
        System.out.println(newInt.apply("1234567890"));
//        Calculator add = (a,b)-> a + b;
//        System.out.println(add.sum(1,1));
//        List<Integer> list = Arrays.asList(1,20,30,4,5,6,10,8,23);// find max value in this list
//        list.forEach(n ->{
//            int x = n * 2;
//        });
//
//        //case 1 for stream api, filter, map, sorted, forEach
//        List<String> streamList = Arrays.asList("a1","c4","b1","a2","b2","c1","c2");
//        streamList.stream()
//                .filter(s ->s.startsWith("c"))
//                .map(String::toUpperCase)
//                .sorted()
//                .forEach(System.out::println);
//        //case 2: using anyMath, allMath, collect
//        List<String> strings = Arrays.asList("This","IS", "a", "COLLECTION", "of","strings");
//        strings.stream()
//                .filter(str -> str.chars().anyMatch(Character::isLowerCase))
//                .forEach(System.out::println);
//        strings.stream()
//                .filter(str -> str.chars().allMatch(Character::isLowerCase))
//                .forEach(System.out::println);
//        List<String> allMyLowerCaseStrings = strings.stream().filter(str -> str.chars().allMatch(Character::isLowerCase))
//                .collect(Collectors.toList());
//        System.out.println(allMyLowerCaseStrings);
//        //case 3: find the max value in the list
//        Integer max = list.stream().reduce(Integer::max).get();
//        System.out.println("max is " + max);
//        // case 4: find and sum all numbers that are divisible by 3 and 5
//        int sum = list.stream().filter(n -> n % 3 == 0 && n % 5==0)
//                .mapToInt(Integer::intValue)
//                .sum();
//        System.out.println("sum is " + sum);
//
//
//        //case 5: flatmap:
//        List<String> sentences = Arrays.asList("this is a dog", "this is a cat", "I love them");
//        List<String> words  = sentences.stream().
//                flatMap(s->Arrays.stream(s.split(" ")))
//                .distinct()
//                .collect(Collectors.toList());
//        System.out.println(words);
//
//
//
//        // parallel case
//        System.out.println("this is sequential stream");
//        list.stream()
//                .map(num ->{
//                    String threadName = Thread.currentThread().getName();
//                    System.out.println("processing number" + num);
//                    return num * num;
//                })
//                .forEach(result -> System.out.println("return: " + result));
//
//        System.out.println("\n Parallel Stream: ");
//        list.parallelStream()
//                .map(num ->{
//                    String threadName = Thread.currentThread().getName();
//                    System.out.println("processing number" + num);
//                    return num * num;
//                })
//                .forEach(result -> System.out.println("return: " + result));
//        //optional example
//
//        Student stu1 = new Student(18,"pengfei", Optional.of("Matt"));
//        Student stu2 = new Student(18,"Robber", Optional.empty());
//
////        Optional<String> myNickName = stu1.getNickName();
//        Optional<String> myNickName = stu2.getNickName();
//        if(myNickName.isPresent()){
//            System.out.println("my nick name is " + myNickName.get());
//        }
//        else{
//            System.out.println("I do not have one");
//        }
//
//        //completable future
//       // FutureTask -> runnable future -> future
//        // completable future provides more functions than future task
//        FutureTask<String> futureTask = new FutureTask<>(new MyCallable());
//        Thread t1  = new Thread(futureTask,"thread 1");
//        t1.start();
//        System.out.println(futureTask.get());
//
//
//        //assuming you are dealing with a large document
//        // you have three tasks, each tasks cost 500 milliseconds
//        //one thread
//        long startTime =System.currentTimeMillis();
//        // task 1
//        try{
//            TimeUnit.MILLISECONDS.sleep(500);
//        }catch (InterruptedException e){
//            e.printStackTrace();
//        }
//        // task 2
//        try{
//            TimeUnit.MILLISECONDS.sleep(500);
//        }catch (InterruptedException e){
//            e.printStackTrace();
//        }
//        //task 3
//        try{
//            TimeUnit.MILLISECONDS.sleep(500);
//        }catch (InterruptedException e){
//            e.printStackTrace();
//        }
//        long endTime = System.currentTimeMillis();
//        System.out.println("The total cost is: " +(endTime - startTime));// >1500
//        // how to reduce the total time -> multiple threads + future task
//        // fixed thread pool -> has three threads
//        ExecutorService threadPool = Executors.newFixedThreadPool(3);
//        long startTime1 =System.currentTimeMillis();
//        // task 1
//        FutureTask<String> futureTask1 = new FutureTask<>(()->{
//            try{
//                TimeUnit.MILLISECONDS.sleep(500);
//            }catch (InterruptedException e){
//                e.printStackTrace();
//            }
//            return "task 1";
//        });
//        threadPool.submit(futureTask1);
//        //task 2
//        FutureTask<String> futureTask2 = new FutureTask<>(()->{
//            try{
//                TimeUnit.MILLISECONDS.sleep(500);
//            }catch (InterruptedException e){
//                e.printStackTrace();
//            }
//            return "task 2";
//        });
//        threadPool.submit(futureTask2);
//        FutureTask<String> futureTask3 = new FutureTask<>(()->{
//            try{
//                TimeUnit.MILLISECONDS.sleep(500);
//            }catch (InterruptedException e){
//                e.printStackTrace();
//            }
//            return "task 3";
//        });
//        threadPool.submit(futureTask3);
//
//        try{
//            futureTask1.get();
//            futureTask2.get();
//            futureTask3.get();
//        }catch (ExecutionException e){
//            e.printStackTrace();
//        }
//        long endTime1 = System.currentTimeMillis();
//        System.out.println("the total cost in future task is: " + (endTime1 - startTime1));// <1000
        //threadPool.shutdown();

        // runAsync(Runnable runnable)
        //runAsync(Runnable runnable, Executor)
        // return is void
//        public static CompletableFuture<Void> runAsync(Runnable runnable) {
//            return asyncRunStage(ASYNC_POOL, runnable);
//        }
//
//        public static CompletableFuture<Void> runAsync(Runnable runnable,
//                Executor executor) {
        // runAsync(Runnable runnable) no return
//        CompletableFuture<Void> completableFuture = CompletableFuture.runAsync(
//                ()->{
//                    System.out.println(Thread.currentThread().getName());
//                    try{
//                        TimeUnit.SECONDS.sleep(1);
//                    }catch (InterruptedException e){
//                        e.printStackTrace();
//                    }
//                }
//        );
//        System.out.println(completableFuture.get());
//        //runAsync(Runnable runnable,Executor executor)
//        ExecutorService executorService = Executors.newFixedThreadPool(1);
//        CompletableFuture<Void> completableFuture1 = CompletableFuture.runAsync(
//                ()->{
//                    System.out.println(Thread.currentThread().getName());
//                    try{
//                        TimeUnit.SECONDS.sleep(1);
//                    }catch (InterruptedException e){
//                        e.printStackTrace();
//                    }
//                }
//        ,executorService);
//        System.out.println(completableFuture1.get());
//        executorService.shutdown();

//        public static <U> CompletableFuture<U> supplyAsync(Supplier<U> supplier) {
//            return asyncSupplyStage(ASYNC_POOL, supplier);
//        }
//
//        public static <U> CompletableFuture<U> supplyAsync(Supplier<U> supplier,
//                Executor executor) {
//            return asyncSupplyStage(screenExecutor(executor), supplier);
//        }

        //supplyAsync(Supplier<U> supplier)

//        CompletableFuture<String> completableFuture2 = CompletableFuture.supplyAsync(()->{
//            System.out.println(Thread.currentThread().getName());
//            try{
//                TimeUnit.SECONDS.sleep(1);
//            }catch (InterruptedException e){
//                e.printStackTrace();
//            }
//            return "Hello, I am supply async";
//        });
//        System.out.println(completableFuture2.get());
//        ExecutorService executorService1 = Executors.newFixedThreadPool(1);
//
//        CompletableFuture<String> completableFuture3 = CompletableFuture.supplyAsync(()->{
//            System.out.println(Thread.currentThread().getName());
//            try{
//                TimeUnit.SECONDS.sleep(1);
//            }catch (InterruptedException e){
//                e.printStackTrace();
//            }
//            return "Hello, I am supply async with executor service";
//        },executorService1);
//        System.out.println(completableFuture3.get());
//        executorService1.shutdown();


        // whenComplete method in completable future
        ExecutorService executorService = Executors.newFixedThreadPool(3);
//        CompletableFuture<String> completableFuture = CompletableFuture.supplyAsync(()->{
//            System.out.println(Thread.currentThread().getName());
//            try{
//                TimeUnit.SECONDS.sleep(1);
//            }catch (InterruptedException e){
//                e.printStackTrace();
//            }
//            return "Hello, this is my first whenComplete method";
//
//        },executorService).whenComplete((r,e)->{
//            //r is return from returning
//            // e is exception
//            if(e ==null){
//                System.out.println("whenComplete is finished" + r);
//            }
//        }).exceptionally(e->{
//            e.printStackTrace();
//            System.out.println("exception is happening ");
//            return null;
//        });
//        executorService.shutdown();

//        CompletableFuture<String> completableFuture = CompletableFuture.supplyAsync(()->{
//            System.out.println(Thread.currentThread().getName());
//            try{
//                TimeUnit.SECONDS.sleep(1);
//            }catch (InterruptedException e){
//                e.printStackTrace();
//            }
//            int i = 5;
//            if(i > 0){
//                int a = i / 0;
//            }
//            return "Hello, this is my first result";
//        }, executorService).whenComplete((r,e) ->{
//            if(e == null){
//                System.out.println("whenComplete: " + r);
//            }
//        }).exceptionally( e->{
//            e.printStackTrace();
//            System.out.println("exception");
//            return null;
//        });
//        executorService.shutdown();

        // complete function: if your completable future is complete then return true, otherwise return false

//        CompletableFuture<String> completableFuture = CompletableFuture.supplyAsync(()->{
//            System.out.println(Thread.currentThread().getName());
//            try{
//                TimeUnit.SECONDS.sleep(1);
//            }catch (InterruptedException e){
//                e.printStackTrace();
//            }
//
//            return "Hello, this is my first result";
//        });
//        System.out.println(completableFuture.complete("my completable future is completed") + " my result is " + completableFuture.join());


        //thenApply
//        CompletableFuture<Integer> completableFuture = CompletableFuture.supplyAsync(()->{
//            System.out.println(Thread.currentThread().getName());
//            try{
//                TimeUnit.SECONDS.sleep(1);
//            }catch (InterruptedException e){
//                e.printStackTrace();
//            }
//            System.out.println("This is step 1.");
//            return 1;
//        },executorService).thenApply(r ->{
//            System.out.println("This is step 2.");
//            return r + 1;
//        }).thenApply( r ->{
//            System.out.println("This is step 3.");
//            return r + 2;
//        }).whenComplete((r,e) ->{
//            if(e == null){
//                System.out.println("The result from above step is: " + r);
//            }
//        }).exceptionally( e->{
//            e.printStackTrace();
//            return null;
//        });
//
//        executorService.shutdown();

        // thenCombine

        CompletableFuture<Integer> completableFuture = CompletableFuture.supplyAsync(()->{
            return 1;
        });
        CompletableFuture<Integer> completableFuture1 = CompletableFuture.supplyAsync(()->{
            return 2;
        });
        CompletableFuture res = completableFuture1.thenCombine(completableFuture, (x,y)->{
            System.out.println(x);
            System.out.println(y);
            return x + y;
        });
        System.out.println(res.join());

    }
}
