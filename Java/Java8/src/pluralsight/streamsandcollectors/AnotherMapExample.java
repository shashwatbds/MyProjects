package pluralsight.streamsandcollectors;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.stream.Stream;

import lambda.unit1.excercise.Person;

public class AnotherMapExample {

	public static void main(String[] args) {
		List<Person> people = new ArrayList<>();
		try(
				BufferedReader reader = new BufferedReader(
						new InputStreamReader(AnotherMapExample.class.getResourceAsStream("person.txt")));

				Stream<String> stream = reader.lines();// new method in buffered Reader class which returns a stream.
				){

			stream.map( line -> { 
				String[] arr = line.split(",");
				Person person = new Person(arr[0].trim(), arr[1].trim(), Integer.parseInt(arr[2].trim()));
				people.add(person);
				return person;
			})
			.forEach(System.out::println);

		}catch(IOException e) {e.printStackTrace();}

		// find youngest person whose age is more than 20
		Optional<Person> optional =	people.stream()
				.filter( p-> p.getAge() >= 20 )
				.min(Comparator.comparing(Person::getAge));
		
		if(optional.isPresent()) {
			Person p = optional.get();
			System.out.println(p);
		}
	}

}
