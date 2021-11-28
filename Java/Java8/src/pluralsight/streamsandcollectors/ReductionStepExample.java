package pluralsight.streamsandcollectors;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.function.BinaryOperator;
import java.util.stream.Stream;

public class ReductionStepExample {

	public static void main(String[] args) {

		List<Integer> ages = Arrays.asList(31,23,45,34,60,51);
		BinaryOperator<Integer> sumFunction = Integer::sum; // (i1, i1) -> i1+i2;
		
		Integer id = 0;
		Stream<Integer> stream = Stream.empty();
		int sum = ages.stream().reduce(id, sumFunction); // reduce is a terminal operator.
		int sum1 = stream.reduce(id, sumFunction);
		
		System.out.println(sum);
		System.out.println(sum1);
		
		// find youngest person whose age is more than 20
		Optional<Integer> optional =	ages.stream()
		.filter( i-> i > 20 )
		.min(Comparator.naturalOrder());
		
		if(optional.isPresent()) {
			int age = optional.get();
			System.out.println(age);
		} else {
			
		}
		
	}

}
