package com.java.multithreading.producerconsumer.waitnotify;

public class MainClass {

	public static void main(String[] args) {

		Data data = new Data();
		Thread sender = new Thread(new Sender(data));
		Thread reciever = new Thread(new Reciever(data));
		sender.start();reciever.start();
		
	}

}
