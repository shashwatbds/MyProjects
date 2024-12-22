package org.example.concurrency.sharedvariable;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.*;
import java.util.concurrent.atomic.AtomicInteger;

public class PrintEvenOdd implements Callable {

    private volatile int value = 1;
    private AtomicInteger integer = new AtomicInteger(0);
    @Override
    public Integer call() {
        int number = 2*(value++);
        System.out.println(Thread.currentThread().getName()+" - Volatile - "+number);//Order not maintained
        System.out.println(Thread.currentThread().getName()+" - Atomic - "+integer.incrementAndGet()*2);//Order not maintained
        return number;
    }

    public static void main(String[] args) throws ExecutionException, InterruptedException {
        List<Future<Integer>> results = new ArrayList<>();
        try(ExecutorService es = Executors.newFixedThreadPool(4)) {
//        try(ExecutorService es = Executors.newSingleThreadExecutor()) {
            PrintEvenOdd obj = new PrintEvenOdd();
            for(int i=1; i<11; i++) {
                results.add(es.submit(obj));
            }
        } finally {
//            for(Future<Integer> result: results)
//                System.out.println(result.get());
        }

    }
}
