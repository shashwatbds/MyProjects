package com.java.multithreading.counter.oddeven;

public class MainClass {

	public static void main(String[] args) {
		SharedPrinter sp = new SharedPrinter();
		OddThread ot = new OddThread(20,sp);
		ot.setName("ot");
		EvenThread et = new EvenThread(20, sp);
		et.setName("et");
		ot.start();et.start();
	}

}
