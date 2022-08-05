package com.java.practice.java.collections.thread.synchronization;

public class ThreadInteracionIssueFixedWithSynchronizedMethod {

	int i;

	public synchronized void sharedMethod() {
		int i= 10;
		System.out.println(Thread.currentThread().getName()+" "+i);
		i= 20;
		System.out.println(Thread.currentThread().getName()+" "+i);
		i= 30;
		System.out.println(Thread.currentThread().getName()+" "+i);
		i= 40;
		System.out.println(Thread.currentThread().getName()+" "+i);
	}
	public static void main(String[] args) {

		final ThreadInteracionIssueFixedWithSynchronizedMethod obj = new ThreadInteracionIssueFixedWithSynchronizedMethod();
		Thread t1 = new Thread() {
			@Override
			public void run() {
				obj.sharedMethod();
			}
		};
		Thread t2 = new Thread() {
			@Override
			public void run() {
				obj.sharedMethod();
			}
		};
		t1.start();t2.start();
	}
}
