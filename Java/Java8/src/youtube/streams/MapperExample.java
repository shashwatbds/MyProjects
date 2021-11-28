package youtube.streams;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class MapperExample {

	public static void main(String[] args) {

		List<String> names = Arrays.asList("Abhay","Samir","Shashwat","Arjun","Vaishnav");
		
		List<User> users = names.stream()
		.filter(name -> name.startsWith("S"))//Accepts a predicate and filters out elements from stream which do not match predicate condition
		.map(User::new)//Accepts a function, this will create a user object for each name received from filter operation.
		.collect(Collectors.toList());
	
		System.out.println("Users : "+users.size());
	
	}

}
