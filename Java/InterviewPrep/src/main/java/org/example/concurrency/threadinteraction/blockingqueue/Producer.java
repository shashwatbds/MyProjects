package org.example.concurrency.threadinteraction.blockingqueue;

import java.util.Queue;
import java.util.Random;
import java.util.concurrent.BlockingDeque;

public class Producer implements Runnable{

    private BlockingDeque<Integer> queue;

    public Producer(BlockingDeque<Integer> queue){
        this.queue = queue;
    }

    @Override
    public void run() {
        for (int i = 0; i <= 50; i += 10) {
            try {
                System.out.println(String.format("Producer produced data %s and added to queue.",i));
                queue.put(i);
            } catch (InterruptedException ex) {
                System.out.println("Producer thread is interrupted.");
            }
        }
    }
}
