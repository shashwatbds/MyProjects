package algorithms.recursion;

public class Factorial {

	public static void main(String[] args) {

		System.out.println(findFactorial(5));
	}

	private static int findFactorial(int i) {

		if(i <=1) {
			return 1;
		}
		else {
			return i*findFactorial((i-1));
		}
	}

}
