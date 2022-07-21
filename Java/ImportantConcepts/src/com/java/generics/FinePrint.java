package com.java.generics;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class FinePrint {

	public static void main(String[] args) {

		List <String> l1 = new ArrayList<String>();
		List<Integer> l2 = new ArrayList<Integer>();
		System.out.println("Class Name is : "+l1.getClass());
		System.out.println(l1.getClass() == l2.getClass());
		
		Collection cs = new ArrayList<String>();
		// Illegal.
		if (cs instanceof ArrayList) { 
			System.out.print(true);
		}
	}
}
