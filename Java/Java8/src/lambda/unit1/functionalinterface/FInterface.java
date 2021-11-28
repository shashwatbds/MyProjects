package lambda.unit1.functionalinterface;

@FunctionalInterface
public interface FInterface {

	public void perform();
//	public void another(); if this method is uncommented Java c wont allow us to create lambda expression using this interface.
	
	// We should add annotation at top of functional interface to ensure compile time safety for them, compiler wont allow to add new abstract method 
	// in an Functional interface. A functional interface can contain only one abstract method but can have multiple default methods.
}
