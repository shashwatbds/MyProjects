package com.test;

public class VolatileExample {

	private static volatile boolean sayHello=false;
	
	public static void main(String[] args) throws InterruptedException {
	
		new Thread() {
			@Override
			public void run() {
				while(!sayHello) {
					
				}
				System.out.println("Hello World");
				
				while(sayHello) {
					
				}
				System.out.println("Good Bye..");
			}
		}.start();
		Thread.sleep(1000);
		System.out.println("Say Hello");
		sayHello=true;
		System.out.println("Say bye");
		sayHello=false;
		
	}

}
