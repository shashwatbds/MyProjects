package com.java.multithreading.counter.oddeven;

public class OddThread extends Thread{

	int limit;
	
	SharedPrinter printer;
	
	public OddThread(int limit, SharedPrinter printer) {
		this.limit = limit;
		this.printer = printer;
	}
	
	@Override
	public void run() {
		int oddNumber = 1;
		while(oddNumber <=limit) {
			printer.printOdd(oddNumber);
			oddNumber +=2;
		}
	}
	
	
}
