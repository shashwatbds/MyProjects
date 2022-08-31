package com.java.multithreading.counter.oddeven;

public class SharedPrinter {

	boolean isOddPrinted;

	synchronized void printOdd(int num) {
		while(isOddPrinted) {
			try {
				wait();
			} catch(InterruptedException e) {
				e.printStackTrace();
			}
		}
		System.out.println(Thread.currentThread().getName()+" : "+num);

		isOddPrinted = true;
		try {
			Thread.sleep(1000);
		}catch(InterruptedException e) {
			e.printStackTrace();
		}
		notify();
	}

	synchronized void printEven(int num) {
		while(!isOddPrinted) {
			try {
				wait();
			} catch(InterruptedException e) {
				e.printStackTrace();
			}
		}
		System.out.println(Thread.currentThread().getName()+" : "+num);

		isOddPrinted = false;
		try {
			Thread.sleep(1000);
		}catch(InterruptedException e) {
			e.printStackTrace();
		}
		notify();
	}
}
