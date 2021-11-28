package pluralsight.strings;

import java.util.StringJoiner;

public class StringNewExample {

	public static void main(String[] args) {
		streamsOfString();
		stringJoiner();
	}

	private static void stringJoiner() {
		String s1 = "Hello ";
		String s2 = "World!!";
		
		StringJoiner sj = new StringJoiner(", ");
		sj.add(s1).add(s2);
		System.out.println(sj.toString());
	}

	private static void streamsOfString() {
		String s = "Hello World";
		
		s.chars().mapToObj( letter -> (char) letter)
		.map(Character::toUpperCase)
		.forEach(System.out::println);
	}

}
