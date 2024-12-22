package org.example.concurrency.threadinteraction.blockingqueue;

import java.util.concurrent.*;

public class ProducerConsumerUsingBlockingQueue {

    public static void main(String[] args) {
        int maxSize = 10;

        BlockingDeque<Integer> blockingQueue = new LinkedBlockingDeque<>();
        // Producer thread creation
        Thread producer = new Thread(new Producer(blockingQueue));
        // Consumer thread creation
        Thread consumer = new Thread(new Consumer(blockingQueue));

        // Start Producer and Consumer thread
        producer.start();
        consumer.start();
    }
}
