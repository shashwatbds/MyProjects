package lambda.unit1.intro;

public class Greeter {

	public static void main(String[] args) {
		Greeter greeter = new Greeter();
		greeter.greet(new HelloWorldGreeting());
		// STEP 1: Define functionality of the functional interface inline using lambda's
		Greeting greeting = () -> System.out.println("Hello World Lambda !!");
		// STEP 2: Pass in the functionality as method argument
		greeter.greet(greeting);
		
		// Alternative: You may pass functionality as is directly as well and compiler will automatically detect the type on functionality being 
		// passed in as method argument. Java c realizes that greet method expects an implementation of Greeting interface which has just one method
		// that method has no argument and return type hence it allows the functionality being as it is being in below line of code without 
		// actually declaring interface variable like we have done in above example. 
		greeter.greet(() -> System.out.println("Hello World Another Lambda !!"));
		greeter.greet(new Greeting() {
			@Override
			public void perform() {
				System.out.println("Hello World anonymous Inner class !!");
			}
		});
	}

	public void greet(Greeting greet) {
		greet.perform();
	}
}
