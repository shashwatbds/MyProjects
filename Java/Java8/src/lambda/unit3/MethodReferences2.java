package lambda.unit3;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Predicate;

import lambda.unit1.excercise.Person;

public class MethodReferences2 {

	public static void main(String[] args) {
		List<Person> people = Arrays.asList(
				new Person("Shashwat", "Bhardwaj", 30),
				new Person("Oliver", "Kahn", 23),
				new Person("Abraham", "Devilliers", 75),
				new Person("Joe", "Clark", 35),
				new Person("Oven", "Dent", 58),
				new Person("Alex", "Joseph", 20)
				);

		printPeople(people, p -> true, System.out::println); 
	}

	public static void printPeople(List<Person> people, Predicate<Person> predicate, Consumer<Person> consumer) {
		for(Person p : people) {
			if(predicate.test(p)) {
				consumer.accept(p);
			}
		}

	}


}
