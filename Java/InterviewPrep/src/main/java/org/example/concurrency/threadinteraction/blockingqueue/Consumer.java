package org.example.concurrency.threadinteraction.blockingqueue;

import java.util.Queue;
import java.util.concurrent.BlockingDeque;
import java.util.concurrent.BlockingQueue;

public class Consumer implements Runnable {

    private final BlockingQueue<Integer> blockingQueue;

    public Consumer(BlockingQueue<Integer> blockingQueue) {
        this.blockingQueue = blockingQueue;
    }

    public void run() {
        while (true) {
            try {
                System.out.println(String.format("Consumer consumed data %s from queue.",blockingQueue.take()));
            } catch (InterruptedException ex) {
                System.out.println("Consumer thread is interrupted.");
            }
        }
    }
}
