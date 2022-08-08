package com.java.practice.java.collections.thread.basic.communication;

public class Shared {
	synchronized void methodOne()
	{
		Thread t = Thread.currentThread();
		System.out.println(t.getName()+" is relasing the lock and going to wait");
		try {
			wait();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
        System.out.println(t.getName()+" got the object lock back and can continue with it's execution");
	}

	synchronized void methodTwo()
	{
		Thread t = Thread.currentThread();
		try {
            Thread.sleep(50);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
 
        notify();  
        System.out.println("A thread which is waiting for lock of this object is notified by "+t.getName());
	}
}
