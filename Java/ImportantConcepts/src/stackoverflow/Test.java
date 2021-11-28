package stackoverflow;

public class Test {

	/*Another interesting scenario that causes this error is if a class is being instantiated within the same class 
	 * as an instance variable of that class. This will cause the constructor of the same class to be called 
	 * again and again (recursively) which eventually results in a StackOverflowError.
	 * 
	 * If you make below instance variable as static then no exception will occur.
	 * 
	 * **/
	
	private Test test = new Test();
	private int i = 10;
	
	public static void main(String[] args) {
		System.out.println("main executing");
		Test test1 = new Test();
		System.out.println("main has nothing to print");
	}

}
