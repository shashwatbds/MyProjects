package pluralsight.streamsandcollectors;

import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;

import lambda.unit1.excercise.Person;

public class StreamsIntroduction {

	public static void main(String[] args) {
		List<Person> people = Arrays.asList(
				new Person("Shashwat", "Bhardwaj", 30),
				new Person("Oliver", "Kahn", 23),
				new Person("Abraham", "Devilliers", 75),
				new Person("Joe", "Clark", 35),
				new Person("Oven", "Dent", 58),
				new Person("Alex", "Joseph", 20)
				);
		
		people.stream()
		.filter(p -> p.getAge() > 50)
		.forEach(System.out::println);
		
		long i = people.stream()
		.filter(p -> p.getAge() > 50)
		.count();
		System.out.println(i);

		Predicate<Person> agePredicate = p -> p.getAge() > 50;
		Predicate<Person> namePredicate = p-> p.getfName().equals("Oven");
		
		people.stream()
		.filter(agePredicate.and(namePredicate))
		.forEach(System.out::println);
		
		
	}

}
