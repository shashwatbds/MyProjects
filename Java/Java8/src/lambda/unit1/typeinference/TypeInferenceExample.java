package lambda.unit1.typeinference;

public class TypeInferenceExample {

	public static void main(String[] args) {
		StringLength obj = s -> s.length();//Here Java compiler figures out type of s object here as it is functional interface 
		// and has only one method. compiler checked input parameter type of that only method and matched it's type and provides method on that type when we type code
		// after -> in this line. So all methods of string will be available on it if we use auto complete.
		getLength(obj);
	}
	
	static void getLength(StringLength l) {
		System.out.println(l.getStringLength("Hello"));
	}
	
	interface StringLength {
		int getStringLength(String string);
	}

}
