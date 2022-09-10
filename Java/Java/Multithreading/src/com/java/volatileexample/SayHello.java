package com.java.volatileexample;

public class SayHello {

	private static volatile boolean sayHello=false;// If this variable is not volatile, the thread will not read the sayHello value again from memory.
	
	public static void main(String[] args) throws InterruptedException {
		
		Thread thread = new Thread(()->{
			while(!sayHello) {
				
			}
			
			System.out.println("Hello World!!");
			
			while(sayHello) {
				
			}
			
			System.out.println("Good bye");
		}) ;
		
		thread.start();
		
		Thread.sleep(1000);
		System.out.println("Say Hello");
		sayHello=true;
		Thread.sleep(1000);
		System.out.println("Say Bye...");
		sayHello=false;
	}

}
