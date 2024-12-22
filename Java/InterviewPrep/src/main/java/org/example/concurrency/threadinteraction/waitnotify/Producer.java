package org.example.concurrency.threadinteraction.waitnotify;

import java.util.Queue;
import java.util.Random;

public class Producer implements Runnable{

    private Queue<Integer> queue;
    private int maxSize;

    public Producer(Queue<Integer> queue, int maxSize){
        this.queue = queue;
        this.maxSize = maxSize;
    }

    @Override
    public void run() {
        while(true) {
            synchronized (queue) {
                while(queue.size() == maxSize) {
                    try {
                        System.out .println("Queue is full, " + "Producer thread waiting for " + "consumer to take something from queue");
                        queue.wait();
                    } catch (Exception ex) {
                        ex.printStackTrace();
                    }
                }

                Random random = new Random();
                int i = queue.size();
                System.out.println("Producing value : " + i);
                queue.add(i);
                queue.notifyAll();

            }
        }
    }
}
