package lambda.unit2;

import java.util.function.BiConsumer;

public class ExceptionHandlingUsingLambda {

	public static void main(String[] args) {

		int[] someNumbers = {23,45,2,32,19,0};
		int key = 0;
		
		process(someNumbers, key, wrapperLambda((x, y) -> System.out.println(x/y)));
	}

	private static void process(int[] someNumbers, int key, BiConsumer<Integer, Integer> consumer) {
		for(int i: someNumbers) {
			consumer.accept(i, key);
		}
	}
	
	private static BiConsumer<Integer, Integer> wrapperLambda(BiConsumer<Integer, Integer> consumer) {
		return (a, b) -> {
			try {
			consumer.accept(a, b);
			} catch (ArithmeticException e) {System.out.println("Caught!!");}
		};
	}

}
