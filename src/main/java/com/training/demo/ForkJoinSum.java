package com.training.demo;

import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.RecursiveTask;

public class ForkJoinSum extends RecursiveTask<Long> {
    private final int[] array;
    private final int startIndex;

    private final int endIndex;
    private static final int THRESHOLD = 10_000;


    public ForkJoinSum(int[] array, int startIndex, int endIndex){
        this.array = array;
        this.startIndex = startIndex;
        this.endIndex = endIndex;
    }
    @Override
    protected Long compute() {
        int length = endIndex - startIndex;
        if (length <= THRESHOLD) {
            // Base case: compute sum directly,
            // we cannot keep splitting
            long sum = 0;
            for (int i = startIndex; i < endIndex; i++) {
                sum += array[i];
            }
            return sum;
        } else {
            // Recursive case: split the task
            int mid = startIndex + (length / 2);
            ForkJoinSum leftTask = new ForkJoinSum(array, startIndex, mid);
            ForkJoinSum rightTask = new ForkJoinSum(array, mid, endIndex);

            leftTask.fork(); // Schedule left half for execution
            long rightResult = rightTask.compute(); // Compute right half directly
            long leftResult = leftTask.join(); // Wait for left half and retrieve its result

            return leftResult + rightResult;
        }
    }

    public static void main(String[] args) {
        int[] array = new int[100_000];
        for(int i = 0; i < array.length;i++){
            array[i] = (int)(Math.random() * 10);
        }
        ForkJoinPool pool = new ForkJoinPool();
        ForkJoinSum task = new ForkJoinSum(array,0,array.length);
        long sum = pool.invoke(task);
        System.out.println("Sum: " + sum);
    }
}
