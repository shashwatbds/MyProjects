package org.example.concurrency.sharedvariable;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.*;

public class PrintEvenOdd implements Callable {

    volatile int value = 0;

    @Override
    public Integer call() {
        System.out.println(Thread.currentThread().getName());
        return 2*(value++);
    }

    public static void main(String[] args) throws ExecutionException, InterruptedException {
        List<Future<Integer>> results = new ArrayList<>();
        try(ExecutorService es = Executors.newFixedThreadPool(4)) {
            PrintEvenOdd obj = new PrintEvenOdd();
            for(int i=1; i<=11; i++) {
                results.add(es.submit(obj));
            }
        } finally {
            for(Future<Integer> result: results)
                System.out.println(result.get());
        }

    }
}
