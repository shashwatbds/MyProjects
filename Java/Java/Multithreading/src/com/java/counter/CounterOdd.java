package com.java.counter;

public class CounterOdd implements Runnable {

	private Counter counter;

	public CounterOdd(Counter counter) {
		super();
		this.counter = counter;
	}


	@Override
	public void run() {
		int i=0;
		int num = 1;
		while(i<5) {
			try {
				counter.printOdd(num);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			num+=2;
			i++;
		}
	}
}
