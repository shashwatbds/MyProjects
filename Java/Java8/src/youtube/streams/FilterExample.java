package youtube.streams;

import java.util.Arrays;
import java.util.List;

public class FilterExample {

	public static void main(String[] args) {
		List<String> names = Arrays.asList("Abhay","Samir","Shashwat","Arjun","Vaishnav");
		
		names.parallelStream()
		.filter(name -> name.startsWith("S"))//Accepts a predicate and filters out elements from stream which do not match predicate condition
		.forEach(System.out::println);//Method References
	}

}
