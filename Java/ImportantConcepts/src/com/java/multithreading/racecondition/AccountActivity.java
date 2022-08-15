package com.java.multithreading.racecondition;

public class AccountActivity {

	public static void main(String[] args) {
		for(int i=0; i<10; i++) {
			BankAccount jointAccount = new BankAccount(100);
			Thread shashwat = new Thread(new AccountHolder(jointAccount));
			Thread vished = new Thread(new AccountHolder(jointAccount));
			Thread rohit = new Thread(new AccountHolder(jointAccount));

			shashwat.setName("Shashwat");
			vished.setName("Vished");
			rohit.setName("Rohit");
			shashwat.start();vished.start();rohit.start();
		}
	}

}
