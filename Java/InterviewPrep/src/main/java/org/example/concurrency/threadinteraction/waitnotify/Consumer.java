package org.example.concurrency.threadinteraction.waitnotify;

import java.util.Queue;

public class Consumer implements Runnable {

    private Queue<Integer> queue;
    private int maxSize;

    public Consumer(Queue<Integer> queue, int maxSize){
        this.queue = queue;
        this.maxSize = maxSize;
    }

    @Override
    public void run() {
        while(true) {
            synchronized (queue) {
                while(queue.size() == 0) {
                    try {
                        System.out .println("Queue is empty, " + "Consumer thread waiting for " + "producer to produce value in the queue");
                        queue.wait();
                    } catch (Exception ex) {
                        ex.printStackTrace();
                    }
                }
                System.out.println("Consuming value : " + queue.remove());
                queue.notifyAll();
            }
        }

    }
}
