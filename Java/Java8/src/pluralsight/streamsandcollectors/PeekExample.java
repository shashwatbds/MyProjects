package pluralsight.streamsandcollectors;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Stream;

public class PeekExample {

	public static void main(String[] args) {
		Stream<String> stream = Stream.of("one","two","three","four","five");

		Predicate<String> p1 = Predicate.isEqual("two");
		Predicate<String> p2 = Predicate.isEqual("three");
		
		List<String> list = new ArrayList();
		
//		stream.peek(System.out::println)
//		.filter(p1.or(p2))
//		.peek(list::add);
//		
//		System.out.println("Done!!");
//		System.out.println("Size: "+list.size());
		
		//Nothing gets printed(not even first peek) since there is not final operation at end. Only when a final operation is present at the only then it will trigger 
		//processing of data using streams.
		
		stream.peek(System.out::println)
		.filter(p1.or(p2))
		.forEach(list::add);
		
		System.out.println("Done!!");
		System.out.println("Size: "+list.size());
		
		
	}

}
