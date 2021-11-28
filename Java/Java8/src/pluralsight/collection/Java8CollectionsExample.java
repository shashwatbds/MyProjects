package pluralsight.collection;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

import lambda.unit1.excercise.Person;

public class Java8CollectionsExample {

	public static void main(String[] args) {

		List<String> list = new ArrayList<String>(Arrays.asList("One","Two","Three","Four","Five","Six"));
		
		// 1) RemoveIf(Predicate)
		list.removeIf(s -> s.length() < 4);
		System.out.println(list.stream().collect(Collectors.joining(", ")));

		// 2) replaceAll(UnaryOperator) - 
		list.replaceAll(s-> {
			if(s.equals("Four")) {
				return "Fourteen";
			}else return s;
		});
		System.out.println(list.stream().collect(Collectors.joining(", ")));
		
		list.replaceAll(String::toUpperCase);
		System.out.println(list.stream().collect(Collectors.joining(", ")));
		
		//3) Comparator method
		list.sort(Comparator.naturalOrder());
		list.forEach(System.out::println);
		
		//4) Comparator - compare implementation.
		List<Person> people = Arrays.asList(
				new Person("Shashwat", "Bhardwaj", 30),
				new Person("Oliver", "Kahn", 23),
				new Person("Abraham", "Devilliers", 75),
				new Person("Joe", "Clark", 39),
				new Person("Micheal", "Clark", 34),
				new Person("Oven", "Dent", 85),
				new Person("Alex", "Joseph", 20)
				);
		people.sort(Comparator.comparing(Person::getlName));
		people.forEach(System.out::println);
		
		// 5) Chain comparing
		people.sort(Comparator.comparing(Person::getlName).thenComparing(Person::getAge));
		people.forEach(System.out::println);
	}
}
