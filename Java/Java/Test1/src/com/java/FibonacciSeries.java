package com.java;

import java.util.Arrays;

public class FibonacciSeries {

	public static void main(String[] args) {

		printFibonacci(10);
	}

	private static void printFibonacci(int size) {

		int[] series = new int[size];
		series[0] = 0;
		series[1] = 1;
		
		for(int i=2; i<size; i++) {
			series[i] = series[i-1] + series[i-2];
		}
		
		Arrays.stream(series).forEach(System.out::println);
	}
	
	private static int recursion(int size) {
		
		if(size == 0) {
			return 0;
		} if(size==1) {
			return 1;
		} else {
			return recursion(size-1);
		}
	}

}
