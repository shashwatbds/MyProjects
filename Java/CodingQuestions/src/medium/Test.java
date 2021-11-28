package medium;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.function.Function;
import java.util.function.Predicate;

public class Test {

	public static void main(String[] args) {
		fizzBuzz();
		findPrime();
		findNthNumberInFibonacciSeries();
	}

	/**Write a method that returns the nth element of the Fibonacci Sequence
	 * The Fibonacci Sequence is the series of numbers: 0, 1, 1, 2, 3, 5, 8, 13, 21, 34,...
	 * The next number is found by adding up the two numbers before it.
	 * Assume that indexes start at zero, e.g., fib(0) = 0, fib(1) = 1, ..*/
	private static void findNthNumberInFibonacciSeries() {
		// TODO Auto-generated method stub
		
	}

	/** 
	 * A prime number is a natural number greater than 1 that has no positive divisors other than 1 and itself.
	 * Write a method that checks if a number is prime number.
	 */
	private static void findPrime() {
		Predicate<Double> primeOrNot = i -> {
			//divide by 2
			if(i!=0 && i!=2 && i!=3 && i%2==0) return false;
			//try all odd numbers till square root of the number
			int sqrt = (int)Math.sqrt(i);
			for(int x=3; x<= sqrt; x=x+2) {
				if(i%x==0) return false;
			}
			return true;
		};
		for(Integer i: getRandomNumberList(40)) {
			System.out.println(i+" is Prime Number ? "+primeOrNot.test(Double.valueOf(i)));
		}
	}

	/**
	 * Write a method that returns 'Fizz' for multiples of three and 'Buzz' for the multiples of five.
	 * For numbers which are multiples of both three and five return 'FizzBuzz'.
	 * For numbers that are neither, return the input number. */
	private static void fizzBuzz() {

		Predicate<Integer> notNullandZero = i -> (!i.equals(null) && i!=0);

		Function<Integer,String> operator = i -> {
			if((i%3 ==0) && (i%5==0))
				return "FizzBuzz";
			else if(i%3 ==0)
				return "Fizz";
			else if(i%5 ==0)
				return "Buzz";
			else
				return i+"";
		};

		List<Integer> ints = getRandomNumberList(30);
		for(Integer i: ints) {
			if(notNullandZero.test(i)) {
				System.out.println(operator.apply(i));
			}
		}
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
