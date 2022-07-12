package com.java.practice.java.java8.optional;

import java.util.List;
import java.util.Optional;

public class OptionalTest {

	public static String getString(int count) {
		if(count%2==0) {
			return "Even";
		} else {
			return null;
		}
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		//1. Creating Optional
		Optional<String> optional = Optional.empty(); // Creation of Optional using static method, Returns Empty.
		
		String str = "value";
		Optional<String> optional1 = Optional.of(str);

		Optional<String> optional3 = Optional.ofNullable(getString(2));
		Optional<String> optional4 = Optional.ofNullable(getString(3));

		//2. Using Optional
		/**
		 * Pre-Java 8 
		 * List<String> list = getList();
			List<String> listOpt = list != null ? list : new ArrayList<>();
		 */
		//List<String> listOpt = getString(3).orElseGet(() -> "");
	}

}
