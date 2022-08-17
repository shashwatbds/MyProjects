package com.java.multithreading.semaphore;

import java.util.concurrent.Semaphore;

public class SemaphoreTest {

	Semaphore s = new Semaphore(2);// based on this parameter passed the critical region will allow number of threads between acquire and release code.
	
	public static void main(String[] args) {
		SemaphoreTest test = new SemaphoreTest();
		new Thread() {
			@Override
			public void run() {
				test.mutualExclusion();
			}
		}.start();
		
		new Thread() {
			@Override
			public void run() {
				test.mutualExclusion();
			}
		}.start();
		
		new Thread() {
			@Override
			public void run() {
				test.mutualExclusion();
			}
		}.start();
		new Thread() {
			@Override
			public void run() {
				test.mutualExclusion();
			}
		}.start();
		
	}
	
	public void mutualExclusion() {
		
		try {
			System.out.println("Hello "+Thread.currentThread().getName());
			s.acquire();
			System.out.println(Thread.currentThread().getName()+" is inside mutual exclusive.");
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		} finally {
			s.release();
		}

		
	}
}
