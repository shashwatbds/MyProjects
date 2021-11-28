package easy;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.util.function.BiFunction;
import java.util.function.BinaryOperator;
import java.util.function.Function;
import java.util.function.UnaryOperator;
import java.util.stream.Collectors;

public class Test {

	public static void main(String[] args) {
		sum();
		multiples();
		factorial();
		System.out.println(factorialWithRecursion(9));
		findNumber();
		reverseString();
		findMax();
		findAverage();
		convertToUpperCase();
		
	}
	
	/**
	 * Write a method that converts all strings in a list to their upper case.
	 * */
	private static void convertToUpperCase() {
		System.out.println("\n");
		List<String> strings = Arrays.asList("one","two","three");
		strings.stream()
		.map( s -> s.toUpperCase())
		.collect(Collectors.toList())
		.forEach(System.out::println);
	}

	/**
	 *  Write a method that returns the average of a list of integers.
	 * */
	private static void findAverage() {
		System.out.println("\n");
		List<Integer> ints = getRandomNumberList(10);
		double average = ints.stream()
		.mapToInt(i -> i)
		.average().getAsDouble();
		System.out.println(average);
	}

	/** Write a method that returns the largest integer in the list.
	 * You can assume that the list has at least one element.
	 */
	private static void findMax() {
		System.out.println("\n");
		List<Integer> ints = getRandomNumberList(100);
		// Method 1
		ints.sort( (x, y) -> Integer.compare(x, y));
		System.out.println(ints.get(ints.size()-1));
		
		//Method 2
		int max = ints.stream()
		.mapToInt( i -> i)
		.max()
		.getAsInt();
		System.out.println(max);
	}


	/**Write a method that reverses a string.
	 *For example, 'java interview' becomes 'weivretni avaj'. 
	 */
	private static void reverseString() {
		String str = "java interview";
		Function<String, String> reverse = s -> new StringBuilder(s).reverse().toString(); // No need to explicitly write a return keyword before new StringBuilder(s)
		System.out.println("\n"+reverse.apply(str));
	}

	/**
	 * Write a method that returns the index of the first occurrence of given integer in a list.
	 * Assume that the index of the first element in the list is zero.
	 * If the number does not exist return -1. 
	 * */
	private static void findNumber() {
		System.out.println("\n");
		List<Integer> ints = getRandomNumberList(100);
		int numberToFind = 14;
		
		//Method 1		
		ints.stream()
		.mapToInt( i -> {
			int index = ints.indexOf(numberToFind);
			if(index >=0) {
				return index;
			} else return -1;
		}).distinct()
		.forEach(System.out::println);

		//Method 2:
		BiFunction<List<Integer>, Integer, Integer> function = (list, number) -> list.indexOf(number);
		System.out.println(function.apply(ints, numberToFind));
	}
	
	/**
	 * Write a method that calculates the factorial of a given number.
	 * Factorial is the product of all positive integers less than or equal to n. For example, factorial(4) = 4x3x2x1 = 24.
	 * */
	private static int factorialWithRecursion(int x){
		if(x == 1 ) 
			return 1;
		else 
			return x*factorialWithRecursion(x-1);
	}
	
	/**
	 * Write a method that calculates the factorial of a given number.
	 * Factorial is the product of all positive integers less than or equal to n. For example, factorial(4) = 4x3x2x1 = 24.
	 * */
	private static void factorial() {
		
		UnaryOperator<Integer> factorialFunction = (a) -> {
			int factorial = 1;
			while(a > 0) {
				factorial = factorial*a;
				a--;
			}
			return factorial;
		};
		System.out.println("\n"+factorialFunction.apply(9));
	}

	/**
	 * Given a number n, write a method that sums all multiples of three and five up to n (inclusive). 
	 * */
	private static void multiples() {
		System.out.println("\n");
		int x = 30;
		List<Integer> numbers = getRandomNumberList(x);
		int sum =numbers.stream()
				.mapToInt( i-> {
					if(i%3==0 || i%5 == 0) {
						return i;
					} else return 0;

				}).sum();
		System.out.println("Sum is "+sum);
	}
	
	/**
	 * Write a method that sums two numbers. 
	 * */
	private static void sum() {
		BinaryOperator<Integer> operator = (x,y) -> x+y;
		int x = 10;
		int y = 20;
		System.out.println("\n"+operator.apply(x, y));
	}

	/**
	 * Returns random list of integers of length = n
	 * */
	private static List<Integer> getRandomNumberList(int n) {
		List<Integer> ints = new ArrayList<Integer>();
		Random random = new Random();
		for(int i =0; i <n; i++) {
			ints.add(random.nextInt(n));
		}
		return ints;
	}
}
