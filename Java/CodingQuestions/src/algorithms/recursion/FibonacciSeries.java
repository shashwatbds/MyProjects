package algorithms.recursion;

import java.util.Arrays;

public class FibonacciSeries {

	public static void main(String[] args) {

		int n = 10;
		int[] arr = new int[10];
		arr[0] = 0;
		arr[1] = 1;
		printFibbonacci(arr, n);
		Arrays.stream(arr).forEach(System.out::println);
		
		System.out.println(printFibbonacciUsingRecursion(n));

	}

	private static void printFibbonacci(int[] arr, int n) {

		for(int i=2; i<n; i++) {
			arr[i] = arr[i-1] + arr[i-2];
		}
	}

	private static int printFibbonacciUsingRecursion(int n) {
		if(n == 0) {
			return 0;
		} else if ( n ==1 || n==2) {
			return 1;
		} else {
			return printFibbonacciUsingRecursion(n-1) + printFibbonacciUsingRecursion(n-2);
		}
	}
}
