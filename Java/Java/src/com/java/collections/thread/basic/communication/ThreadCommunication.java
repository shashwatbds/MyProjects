package com.java.practice.java.collections.thread.basic.communication;

public class ThreadCommunication {

	public static void main(String[] args) {
		final Shared s = new Shared();
		Thread t1 = new Thread()        {
            public void run()            {
                s.methodOne();   //t1 calling methodOne() of 's' object
            }
        };
 
        Thread t2 = new Thread()        {
            @Override
            public void run()            {
                s.methodTwo();   //t2 calling methodTwo() of 's' object
            }
        };
        t1.start();
        t2.start();
	}
}
