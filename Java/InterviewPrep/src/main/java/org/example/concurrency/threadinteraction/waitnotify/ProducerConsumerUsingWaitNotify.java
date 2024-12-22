package org.example.concurrency.threadinteraction.waitnotify;

import java.util.LinkedList;
import java.util.Queue;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ProducerConsumerUsingWaitNotify {

    public static void main(String[] args) {
        Queue<Integer> buffer = new LinkedList<>();
        int maxSize = 100;

        Producer producer = new Producer(buffer, maxSize);
        Consumer consumer = new Consumer(buffer, maxSize);
        try(ExecutorService es = Executors.newFixedThreadPool(2)) {
            es.submit(producer);
            es.submit(consumer);
        } finally {
            System.out.println("Shutdown");
        }
    }
}
