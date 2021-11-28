package lambda.unit2;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Predicate;

import lambda.unit1.excercise.Person;

public class Unit1Excersice {

	public static void main(String[] args) {
		List<Person> people = Arrays.asList(
				new Person("Shashwat", "Bhardwaj", 30),
				new Person("Oliver", "Kahn", 23),
				new Person("Abraham", "Devilliers", 75),
				new Person("Joe", "Clark", 35),
				new Person("Oven", "Dent", 58),
				new Person("Alex", "Joseph", 20)
				);

		//Step 1: Sort list by last name
		System.out.println("Step 1 : ");
		Collections.sort(people, (p1, p2) -> p1.getlName().compareTo(p2.getlName()));
		people.forEach(System.out::println);

		//Step 2: Create a method that prints all elements in the list
		System.out.println("\n\nStep 2 : ");
		printPeople(people, p -> true, p -> System.out.println(p)); 
		//Step 3: Print all people with last name ending with D
		System.out.println("\n\nStep 3 : ");

		printPeople(people, p -> p.getlName().startsWith("D"), p -> System.out.println(p.getfName()));
	}

	public static void printPeople(List<Person> people, Predicate<Person> predicate, Consumer<Person> consumer) {
		for(Person p : people) {
			if(predicate.test(p)) {
				consumer.accept(p);
			}
		}

	}

}
