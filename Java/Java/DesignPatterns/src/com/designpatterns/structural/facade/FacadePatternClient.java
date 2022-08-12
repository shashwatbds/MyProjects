package com.designpatterns.structural.facade;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class FacadePatternClient {

	public static int choice;
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		do {
			System.out.println("====Mobile Shop====");System.out.println("1. Iphone");System.out.println("2. Samsung");System.out.println("3. Blackberry");System.out.println("4. Exit");
			System.out.println("Enter Choice:");
			BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
			choice = Integer.parseInt(br.readLine());
			Shopkeeper sk = new Shopkeeper();
			
			switch(choice) {
			case 1:
				sk.iPhoneSale();
				break;
			case 2: 
				sk.samsungSale();
				break;
			case 3:
				sk.blackberrySale();
				break;
			default:
				System.out.println("Nothing purchased.");
				return;
			}
		}while(choice!=4);
	}
}
