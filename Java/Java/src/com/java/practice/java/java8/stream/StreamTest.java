package com.java.practice.java.java8.stream;

import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.IntSummaryStatistics;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.OptionalInt;
import java.util.Set;
import java.util.regex.Pattern;
import java.util.stream.Collector;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.LongStream;
import java.util.stream.Stream;

import com.java.practice.java.java8.methodreferences.User;

/**
 * Abstract layer that provides pipeline processing of the data
 * */
public class StreamTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		//1. Stream Creation
		//1.1 Empty Stream
		Stream<String> streamEmpty = Stream.empty();
		
		//1.2 Stream from collection
		Collection<String> collection = Arrays.asList("a","b","c");
		Stream<String> streamOfCollection = collection.stream();
		
		//1.3 Stream of Array
		Stream<String> streamOfArray = Stream.of("a", "b", "c");
		String[] arr = new String[] {"a", "b", "c"};
		Stream<String> streamOfArrFull = Arrays.stream(arr);
		Stream<String> streamOfArrayPart = Arrays.stream(arr,1,3);
		
		//1.4 Stream Builder
		//Stream<String> streamBuilder = (Stream<String>) Stream.<String>builder().add("a").add("'b").add("c").add("d");
		
		
		//1.5 Stream Generate()
		Stream<String> streamGenerated = Stream.generate(() -> "element").limit(10);
		
		//1.5 Stream Iterate()
		Stream<Integer> streamIterated = Stream.iterate(40, n-> n+2).limit(20);//First element in this stream will be 40, second will be 42 and this will go one till 20 items are generated.
		
		//1.6 Stream of Primitives
		// Java 8 allows creation of streams out of three primitives types: int, long, double.
		IntStream intStream = IntStream.range(1, 3);//First index included while second index is not included.
		LongStream longStream = LongStream.rangeClosed(1, 3);//First and second index are included.
		
		//1.7 Stream Of String
		IntStream streamOfChars = "abc".chars();// This is stream of chars, we use Int stream to represent stream of chars.
		Stream<String> streamOfString = Pattern.compile(",").splitAsStream("a,b,c");
		
		//1.8 Stream of File
		/*
		 * Path path = Paths.get("H:\\Pictures\\Jobs\\Cover Letter"); try {
		 * Stream<String> streamOfStrings = Files.lines(path); Stream<String>
		 * streamWithCharset = Files.lines(path, Charset.forName("UTF-8")); } catch
		 * (IOException e) { e.printStackTrace(); }
		 */
		
		
		//2 Referencing a Stream
		Optional<String> anyElement = Stream.of("a","b","c")
				.filter(element -> element.contains("b")) // Intermediate Operation, returns  modified stream, Can contain multiple intermediate operations
				.findAny(); // Terminal Operation
		System.out.println(anyElement);
		
		//Skip few elements
		Stream.of("abcd","bbcd","cbcd").skip(1).forEach(System.out::println);
		//System.out.println(onceModifiedStream);
//		onceModifiedStream.forEach(element -> System.out::println);
		
		Stream.of("abcd","bbcd","cbcd").skip(1).map(element -> element.substring(0,2)).forEach(System.out::println);
		
		//Stream Operation Chaining
		List<String> list = Arrays.asList("abc1", "abc2", "abc3");
		/*
		 * long count = list.stream().skip(1)//filter(element -> element.contains("2"))
		 * .map(element -> element.subString(0, 3)).sorted().count();
		 */
		
		System.out.println("\n\n");
		long size = list.stream()
				  .filter(element -> element.contains("2")) // Intermediate Operation in which you want to filter a few elements.
				  .map(element -> element.substring(0, 3)) /// Intermediate Operation in which you want to perform an operation on each element.
				  .sorted() // Intermediate Operation to sort the stream.
				  .count(); // Terminal Operations
		System.out.println(size);
		
		/**
		 * Lazy Invocation
		 * 1. Intermediate Operations are lazy. They will be invokes only if it is necessary for the terminal operation execution.
		 * 2. 
		 */
		
		
		/**
		 * Stream Reduction
		 * 1. Identify - The initial value for an accumulator, or a default value if a stream is empty and there is nothing 
		 * 					to accumulate.
		 * 2. Accumulator - A function which specifies the logic of the aggregation of elements. As the accumulator creates 
		 * 					a new value for every step of reducing, the quality of new values equals the 
		 * 					stream's size and only the last value is useful. This is not very good for the performance.
		 * 3. Combiner - A function which aggregates the result of the accumulator, we only call combiner in a parallel
		 * 				 mode to reduce the results of accumulators from different threads.
		 **/
		System.out.println("\n\n");
		OptionalInt reduced = IntStream.range(1, 4).reduce((a,b) -> a+b);
		System.out.println(reduced.getAsInt());

		System.out.println("\n\n");
		int reducedTwoParams = IntStream.range(1, 4).reduce(10,(a,b) -> a+b);// Int instead of Optional Int because atleast 10 is passed.
		System.out.println(reducedTwoParams);
		
		System.out.println("\n\n");
		int reducedParams = Stream.of(1, 2, 3)
				  .reduce(10, (a, b) -> a + b, (a, b) -> {
					  System.out.println("combiner was called");
				     return a + b;
				  });
		System.out.println(reducedParams);
		
		
		System.out.println("\n\n");
		int reducedParallelParams = Arrays.asList(1, 2, 3).parallelStream()
				  .reduce(10, (a, b) -> a + b, (a, b) -> {
					  System.out.println("combiner was called");
				     return a + b;
				  });
		System.out.println(reducedParallelParams);
		//The result here is different (36), and the combiner was called twice. Here the reduction works by the following algorithm: the accumulator ran three times by adding every element of the stream to identity. These actions are being done in parallel. As a result, they have (10 + 1 = 11; 10 + 2 = 12; 10 + 3 = 13;). Now combiner can merge these three results. It needs two iterations for that (12 + 13 = 25; 25 + 11 = 36).
		
		System.out.println("\n\n");
		
		
		/**
		 * Collection Method
		 * The reduction of a stream can also be executed by another terminal operation, the collect(). 
		 * It accepts an argument of the type collector which specifies the mechanism of reduction. There are
		 * already created, predefined collectors for most common operations. they can be accessed with the help 
		 * of the collectors type.
		 **/
		List<User> users = Arrays.asList(new User("Shashwat",35), new User("Adrian",35), new User("Vished",30), new User("Rohit", 25), new User("Yash", 25));
		List<String> names = users.stream()
				.map(User::getfName) //Intermediate Operation to get only fName of each User object.
				.collect(Collectors.toList()); // Collect the elements into a list. Reducing to a list.
		names.forEach(System.out::println);
		System.out.println("\n\n");
		// String Collect
		String namesString = users.stream()
				.map(User::getfName) //Intermediate Operation to get only fName of each User object.
				.collect(Collectors.joining(",","[","]")); // Collect the elements into a single string.
		//The joiner() method can have from one to three parameters (delimiter, prefix, suffix)
		System.out.println(namesString);

		System.out.println("\n\n");
		
		
		double averageAge = users.stream()
				  .collect(Collectors.averagingInt(User::getAge));
		System.out.println(averageAge);
		System.out.println("\n\n");
		
		
		IntSummaryStatistics stats = users.stream()
				  .collect(Collectors.summarizingInt(User::getAge));
		System.out.println(stats);
		System.out.println("\n\n");
		
		/**
		 * Grouping of stream elements.
		 * */
		Map<Integer, List<User>> collectorMapOfLists = users.stream()
				  .collect(Collectors.groupingBy(User::getAge));
		System.out.println(collectorMapOfLists);
		System.out.println("\n\n");
		
		/**
		 * Grouping of stream elements based on predicate
		 * */
		Map<Boolean, List<User>> partitioned = users.stream()
				  .collect(Collectors.partitioningBy(user -> user.getAge() > 30));
		System.out.println(partitioned);
		System.out.println("\n\n");
		
		/**
		 * Pushing the collector to perform additional transformation
		 **/
		Set<User> unmodifiableSet = users.stream()
				  .collect(Collectors.collectingAndThen(Collectors.toSet(), Collections::unmodifiableSet));
		System.out.println(unmodifiableSet);
		System.out.println("\n\n");
		
		/**
		 * Custom Collection
		 * 
		 **/
		Collector<User, ?, LinkedList<User>> toLinkedList = 
				Collector.of(LinkedList::new, LinkedList::add, (first,second) -> {
					first.addAll(second);
					return first;
				});
		System.out.println(toLinkedList);
		System.out.println("\n\n");
		
		/**
		 * Parallel Streams
		 * Java 8 introduced parallelism in a functional style.
		 * This API allows us to create parallel streams, which perform operations in a parallel mode. 
		 * When the source of a stream is a collection or an array, it can be achieved with the help of the parallelStream()
		 **/
		
		Stream<User> parallelStreamOfCollection = users.parallelStream();
		boolean isParallel = streamOfCollection.isParallel();
		boolean bigPrice = parallelStreamOfCollection
				.map(user -> user.getAge()+10)
				.anyMatch(age -> age >40);
		System.out.println(bigPrice);

	}
	

}
