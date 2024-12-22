package org.example.bean;

import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Test {

    public static void main(String[] args) {

        System.out.println(Stream.of("w","o","l","f")
                .reduce("",
                        (s, c) -> s+c));

        System.out.println(List.of('w','o','l','f').parallelStream()
                .reduce("",
                        (s, c) -> s+c,//Only needed in parallel stream, accumulator will occur in parallel streams and them combiner in the end will combine results from stream.
                        (s,c)-> s+c));

//        StringBuffer buffer = Stream.of("w","o","l","f")
//                .collect(StringBuffer::new,
//                        StringBuffer::append,
//                        StringBuffer::append);
//        System.out.println(buffer.toString());
//
//        HashSet<String> set = Stream.of("w","o","l","f")
//                        .collect(Collectors.toCollection(HashSet::new));
//        System.out.println(set);
//
//        System.out.println(Stream.of(3,4,5)
//                .reduce(1,
//                        (i, j) -> i*j));
//        System.out.println(Stream.of(3,4,5)//1*3*4*5
//                .reduce(1,
//                        (i, j) -> i+j));//1+3+4+5

        //1. Separate Even and Odd Numbers
        List<Integer> numbers = Stream.iterate(1, n -> n+1).limit(20).toList();//Input list
        Map<Boolean, List<Integer>> result = numbers.stream()
                .collect(Collectors.partitioningBy(n -> n%2 ==0));
        System.out.println(result);

        //2. Remove Duplicates from a list
        List<Integer> listWithDuplicates = List.of(1,2,2,3,4,3,6,5,7,8,9,10);
        List<Integer> uniqueList = listWithDuplicates.stream()
                .distinct()
                .peek(System.out::println)
                .toList();

        //3. Frequency of each character of string
        String inputString = "Java Concept Of The Day";
        Map<Character, Long> charCountMap = inputString.chars()
                .mapToObj(c -> (char) c)
                .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));
        System.out.println(charCountMap);

        Stream.generate(() -> "Elsa")//generates infinite stream
                .filter( s -> s.length() == 4)
                .sorted()//This will wait for the other elements to come from infinite stream. So this will only have one
                .limit(2)
                .forEach(System.out::println);

        Stream.generate(() -> "Elsa")//generates infinite stream with same entry "Elsa"
                .filter( s -> s.length() == 4)
//                .sorted()//This will wait for the other elements to come from infinite stream
                .limit(2)
                .forEach(System.out::println);

    }
}
