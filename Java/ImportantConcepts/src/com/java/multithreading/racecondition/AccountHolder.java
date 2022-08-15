package com.java.multithreading.racecondition;

public class AccountHolder implements Runnable {

	private BankAccount account;
	
	public AccountHolder(BankAccount account) {
		super();
		this.account = account;
	}

	@Override
	public void run() {
		for(int i = 0; i<5; i++) {
			System.out.println("Withdrawal by - "+Thread.currentThread().getName());
			double balance = account.withdraw(10);
		}
	}

}
