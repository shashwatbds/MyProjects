package com.java.multithreading.counter.oddeven;

public class EvenThread extends Thread{

	int limit;
	SharedPrinter printer;
	
	public EvenThread(int limit, SharedPrinter printer) {
		super();
		this.limit = limit;
		this.printer = printer;
	}
	
	@Override
	public void run() {
		int evenNumber = 2;
		while(evenNumber<=limit) {
			printer.printEven(evenNumber);
			evenNumber+=2;
		}
	}
	
}
