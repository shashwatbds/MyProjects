package lambda.unit1.runnable;

public class RunnableExample {

	public static void main(String[] args) {
		
		/**Normal Implementation*/
		Thread myThread = new Thread(new Runnable() {
			@Override
			public void run() {
				System.out.println("Printed inside Runnable");
			}
		});
		myThread.start();
		
		/**Lambda Implementation - will work since runnable is also a functional interface (contains just one method) */
		Thread myThread1 = new Thread(() -> System.out.println("Printed inside Lambda Runnable"));
		myThread1.start();
	}

}
