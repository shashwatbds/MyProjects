package pluralsight.collection;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class MapJava8Example {

	public static void main(String[] args) {

		List<Person> people = new ArrayList<>();
		try(
				BufferedReader reader = new BufferedReader(
						new InputStreamReader(MapJava8Example.class.getResourceAsStream("person.txt")));

				Stream<String> stream = reader.lines();// new method in buffered Reader class which returns a stream.
				){

			stream.map( line -> { 
				String[] arr = line.split(",");
				Person person = new Person(arr[0].trim(), arr[1].trim(), Integer.parseInt(arr[2].trim()), arr[3].trim());
				people.add(person);
				return person;
			})
			.forEach(System.out::println);

		}catch(IOException e) {e.printStackTrace();}

		List<Person> list1 = people.subList(1, 5);
		List<Person> list2 = people.subList(6, people.size());

		Map<Integer, List<Person>> map1 = mapByAge(list1);
		Map<Integer, List<Person>> map2 = mapByAge(list2);
		//1) forEach - it accepts a bi-consumer instead on a consumer present in other collection API's
		System.out.println("\n\nMap1 -");
		map1.forEach((age, list) -> System.out.println(age+ "->"+list));
		System.out.println("\n\nMap2 -");
		map2.forEach((age, list) -> System.out.println(age+ "->"+list));

		//2) getOrDefault() - It can return us null but we wont know if key is not present in map or is present and has value as null.

		//3) put() - it automatically erases existing value associated with that key- new method is putIfNull()

		//4) replace() - does contrary of putIfNull() - NEwkey will not be added simply old value will be replaced.

		//5) replaceAll() - 

		//6) remove(key) - remove(key,value);

		//7) compute(), computeIfPresent(), computeIfAbsent()
		System.out.println("\n\nCompute Map - Creating bi-map");
		Map<Integer, Map<String, List<Person>>> biMap = new HashMap<Integer, Map<String,List<Person>>>();
		people.forEach(
				person -> 
				biMap.computeIfAbsent(
						person.getAge(),
						HashMap::new
						).merge(
								person.getGender(), 
								new ArrayList<>(Arrays.asList(person)),
								(l1,l2) -> {
									l1.addAll(l2);
									return l1;
								})
				);

		biMap.forEach((age,m) -> System.out.println(age+" -> "+m)); 
		//8) merge() - 
		map2.entrySet().stream()
		.forEach(
				entry -> 
				map1.merge(
						entry.getKey(),
						entry.getValue(), 
						(l1, l2) -> {
							l1.addAll(l2);
							return l1;
						}
						));

		System.out.println("\n\nMap1 Merged -");
		map1.forEach((age, list) -> System.out.println(age+ "->"+list));

	}

	public static Map<Integer, List<Person>> mapByAge(List<Person> list) {
		Map<Integer, List<Person>> map = 
				list.stream()
				.collect(Collectors.groupingBy(Person::getAge));
		return map;
	}
}
