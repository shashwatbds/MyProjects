package com.java.counter;

public class CounterEven implements Runnable{

	private Counter counter;
	
	public CounterEven(Counter counter) {
		super();
		this.counter = counter;
	}

	@Override
	public void run() {
		int i=0;
		int num = 2;
		while(i<5) {
			try {
				counter.printEven(num);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			num+=2;
			i++;
		}
	}
}
