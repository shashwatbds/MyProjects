package oops.string;

public class StringOperations {

	public static void main(String[] args) {
		
		stripTest();
		System.out.println("\n");
		
		equalsAndHashcode1();
		System.out.println("\n");
		
		equalsAndHashcode2();
		System.out.println("\n");
		
		concatTest();
		System.out.println("\n");
		
		intOrString();
		System.out.println("\n");
		
		subString();
		System.out.println("\n");
		
		stringIsBlankOrEmpty();
		System.out.println("\n");
		
		stringJoin();
		System.out.println("\n");
	}

	private static void stringJoin() {
		System.out.println(String.join(",", "1", "2", "3").concat(",").repeat(3));
		System.out.println(String.join(",", "1", "2", "3").concat(",").repeat(3).lastIndexOf(","));
	}

	private static void stringIsBlankOrEmpty() {
		String str = "	";
		System.out.println(str.isBlank());
		System.out.println(str.isEmpty());
	}

	private static void subString() {
		System.out.println("JAVAJ2EE".substring(2,5).substring(1).charAt(1));
	}

	private static void intOrString() {
		System.out.println("Java"+100+200);
		System.out.println(100+200+"Java");
	}

	private static void concatTest() {
		String s1 = "One";
		String s2 = "Two";
		String s3 = "Three";
		
		s1.concat(s2);
		s1.concat(s3);
		System.out.println(s1);
	}

	private static void equalsAndHashcode2() {
		String str1 = "Java";
		String str2 = new String("Java");
		System.out.println(str1 == str2);
		System.out.println(str1.equals(str2));
		System.out.println(str1.hashCode() == str2.hashCode());
	}
	
	private static void equalsAndHashcode1() {
		String str1 = "Java";
		String str2 = "Java";
		System.out.println(str1 == str2);
		System.out.println(str1.equals(str2));
		System.out.println(str1.hashCode() == str2.hashCode());
	}

	private static void stripTest() {
		String str = "	Java\tConcept\tOf\tThe\tDay	";
		System.out.println(str.strip());//Returns a string whose value is this string, with all leading and trailing {@linkplain Character#isWhitespace(int) white space} removed.
//		System.out.println(str.stripIndent());
		System.out.println(str.stripLeading());
		System.out.println(str.stripTrailing());
		System.out.println(str.trim());// 
	}
}
