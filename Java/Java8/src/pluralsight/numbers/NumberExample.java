package pluralsight.numbers;

import java.util.function.BinaryOperator;

public class NumberExample {

	public static void main(String[] args) {

		// 1) Reduction Operation
		long max = Long.max(1L, 2L);
		BinaryOperator<Long> sum = Long::sum; //(l1, l2) -> l1+l2;
		
		//2) Hashcode
		long l = 212342233454322333L;
		int hashCode = Long.hashCode(l);// This method is available on all Wrapper classes.Handles boxing and autoboxing itself.
	}

}
