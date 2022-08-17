package com.java.multithreading.semaphore;

public class VolatileTest implements Runnable{

	private volatile int number = 1;
	private int base;
	
	public VolatileTest(int base) {
		this.base = base;
	}
	
	@Override
	public void run() {
		
		while(number<11) {
			System.out.println(Thread.currentThread().getName());
			System.out.println(base+" * "+number+" = "+base*number);
			number++;
		}
	}
	
	public static void main(String[] args) {
		VolatileTest vt = new VolatileTest(3);
	}

}
