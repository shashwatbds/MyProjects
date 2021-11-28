package lambda.unit3;

public class MethodReferences1 {

	public static void main(String[] args) {
		Thread thread1 = new Thread(()-> printMessage());//without method reference.
		thread1.start();
		Thread thread2 = new Thread(MethodReferences1::printMessage);
		thread2.start();
	}
	
	public static void printMessage() {
		System.out.println("Hello");
	}

}
