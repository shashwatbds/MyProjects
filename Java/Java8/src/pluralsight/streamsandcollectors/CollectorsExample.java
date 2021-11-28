package pluralsight.streamsandcollectors;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import lambda.unit1.excercise.Person;

public class CollectorsExample {

	public static void main(String[] args) {
		List<Person> people = Arrays.asList(
				new Person("Shashwat", "Bhardwaj", 30),
				new Person("Oliver", "Kahn", 23),
				new Person("Abraham", "Devilliers", 75),
				new Person("Joe", "Clark", 35),
				new Person("Oven", "Dent", 58),
				new Person("Alex", "Joseph", 20)
				);
		String result = 
				people.stream()
				.filter( p-> p.getAge()>45)
				.map(Person :: getfName)
				.collect(Collectors.joining(","));
		System.out.println(result);

		List<String> result1 = 
				people.stream()
				.filter( p-> p.getAge() > 45)
				.map(Person :: getfName)
				.collect(Collectors.toList());
		System.out.println(result1);

		Map<Integer, List<Person>> result2 = 
				people.stream()
				.filter( p-> p.getAge() > 45)
				.collect(Collectors.groupingBy(Person::getAge));
		System.out.println(result2);
		
		//downstream collector
		Map<Integer, Long> result3 = 
				people.stream()
				.filter( p-> p.getAge() > 45)
				.collect(Collectors.groupingBy(
						Person::getAge,
						Collectors.counting()
						));
		System.out.println(result3);
	}

}
