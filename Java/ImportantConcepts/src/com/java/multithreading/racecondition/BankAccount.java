package com.java.multithreading.racecondition;

public class BankAccount {

	private double balance;

	public BankAccount(double initialDeposit) {
		super();
		this.balance = initialDeposit;
	}
	
	public double getBalance() {
		return this.balance;
	}
	
	public double deposit(double amount) {
		if(amount <= 0) {
			System.out.println("Invalid Amount, enter amount greater than 0");
			return balance;
		}
		
		balance +=amount;
		
		return balance;
	}
	
	public double withdraw(double amount) {
		if(amount <= 0 || amount > balance) {
			System.out.println("Invalid Amount, enter amount greater than 0 and less than account balance "+this.balance);
			return balance;
		}
		
		balance -=amount;
		System.out.println("Balance after withdrawal of "+amount+  " is - "+balance);

		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		return balance;
	}
}
