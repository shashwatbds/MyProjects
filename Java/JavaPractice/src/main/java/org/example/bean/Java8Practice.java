package org.example.bean;

import java.math.BigDecimal;
import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Java8Practice {

    public static void main(String[] args) {
        //String Upper case
        convertToUpperCase();

        //Sum of numbers in the list
        sumOfNumbersInTheList();
        sumOfNumbersInTheListUsingParallelStream();

        //listOfObjectsToListOfStrings
        listOfObjectsToListOfStrings(getStaff());
        listOfObjectsToListOfStringsUsingLFlatMap(getStaff());

        //List Of Objects to another list of Objects
        listOfObjectsToAnotherListOfObjects(getStaff());

        //group by city
        groupByCity(getStaff());

        //calculate average salary of each dpt
        averageSalaryOfEachDept(getStaff());
        //countNumberOfStaffPerDept
        countNumberOfStaffPerDept(getStaff());
        sumOfSalariesInEachDept(getStaff());
        highestPidEmployeeInEachDept(getStaff());

        //How do you find frequency of each character in a string using Java 8 streams?
        findFreqOfCharsInString();

        //How do you find frequency of each element in an array or a list?
        findFreqOfEachElementInAList();

        //How do you sort the given list of decimals in reverse order?
        sortGivenListInReversedOrder();

        //Given a list and of strings, join the strings with ‘[‘ as prefix, ‘]’ as suffix and ‘,’ as delimiter?
        addPrefixSuffixAndJoinerToAString();

        //From the given list of integers, print the numbers which are multiples of 5?
        printMultiplesOf5();

        //Given a list of integers, find maximum and minimum of those numbers?
        findMaximumAndMinimumInAList();
        
        //How do you merge two unsorted arrays into single sorted array using Java 8 streams?
        mergeTwoUnsortedArrays();

        //How do you merge two unsorted arrays into single sorted array without duplicates?
        mergeTwoUnsortedArraysRemovingDuplicates();

        //Find second largest number in an integer array?
        findSecondLargestNumberFromAnArray();
        
        //Given a list of strings, sort them according to increasing order of their length?
        sortStringsAccordingToTheLength();

        //Given a list of integers, find out all the numbers starting with 1 using Stream functions?
        findNumbersStartingWith1();

        //How to find duplicate elements in a given integers list in java using Stream functions?
        findDuplicatesInAList();
        
        //Given the list of integers, find the first element of the list using Stream functions?
        findFirstElementFromTheListOfNumbers();

        //Find Max in a list
        findMaxInAList();
        
        //find First NonRepeatingCharInAString
        findFirstNonRepeatingCharInAString();

    }

    private static void findFirstNonRepeatingCharInAString() {
        String input = "Java articles are Awesome";
        Set<Character> chars = new HashSet<>();
        input.chars()
                .mapToObj(c ->(char) c)
                .filter(c -> !chars.add(c))
                .findFirst()
                .ifPresent(System.out::println);
    }

    private static void findMaxInAList() {
        List<Integer> myList = List.of(10,15,8,49,25,98,98,32,15);
        myList.stream().sorted(Comparator.reverseOrder()).findFirst().ifPresent(System.out::println);
    }

    private static void findFirstElementFromTheListOfNumbers() {
        List<Integer> myList = Arrays.asList(10,15,8,49,25,98,98,32,15);
        myList.stream()
                .findFirst().ifPresent(System.out::println);
    }

    private static void findDuplicatesInAList() {
        List<Integer> myList = List.of(10,15,8,49,25,98,98,32,15);
        Set<Integer> mySet = new HashSet<>();
        List<Integer> ints = myList.stream()
                .filter(i -> !mySet.add(i))
                .toList();
        System.out.println(ints);
    }

    private static void findNumbersStartingWith1() {
        List<Integer> myList = List.of(10,15,8,49,25,98,32);
        myList.stream()
                .map(s -> s+"")
                .filter(s -> s.startsWith("1"))
                .peek(System.out::println)
                .toList();

    }

    private static void sortStringsAccordingToTheLength() {
        List<String> listOfStrings = Arrays.asList("Java", "Python", "C#", "HTML", "Kotlin", "C++", "COBOL", "C");
        List<String> sortedList = listOfStrings.stream().sorted(Comparator.comparingInt(String::length)).toList();
        System.out.println(sortedList);
    }

    private static void findSecondLargestNumberFromAnArray() {
        List<Integer> listOfIntegers = List.of(45, 12, 56, 15, 24, 75, 31, 89);
        System.out.println(listOfIntegers.stream().sorted().skip(1).findFirst().get());
    }

    private static void mergeTwoUnsortedArraysRemovingDuplicates() {
        int[] a = new int[] {4, 2, 2, 7, 5, 7, 1};
        int[] b = new int[] {8, 3, 9, 5};
        int[] sorted = IntStream.concat(Arrays.stream(a), Arrays.stream(b)).distinct().sorted().peek(System.out::println).toArray();
    }

    private static void mergeTwoUnsortedArrays() {
        int[] a = new int[] {4, 2, 7, 1};
        int[] b = new int[] {8, 3, 9, 5};
        int[] sorted = IntStream.concat(Arrays.stream(a), Arrays.stream(b)).sorted().peek(System.out::println).toArray();
    }

    private static void findMaximumAndMinimumInAList() {

        List<Integer> listOfIntegers = List.of(45, 12, 56, 15, 24, 75, 31, 89);
        int min = listOfIntegers.stream().min(Comparator.naturalOrder()).get();
        int max = listOfIntegers.stream().max(Comparator.naturalOrder()).get();
        System.out.println("Minimum "+ min + " and Maximum "+max);
    }

    private static void printMultiplesOf5() {
        List<Integer> listOfIntegers = List.of(45, 12, 56, 15, 24, 75, 31, 89);
        List<Integer> filteredInts = listOfIntegers.parallelStream()
                .filter(i -> i % 5 ==0)
                .toList();
        System.out.println(filteredInts);
    }

    private static void addPrefixSuffixAndJoinerToAString() {
        List<String> listOfStrings = List.of("Facebook", "Twitter", "YouTube", "WhatsApp", "LinkedIn");
        String joinedString = listOfStrings.stream()
                .collect(Collectors.joining(", ", "[", "]"));
        System.out.println(joinedString);

    }

    private static void sortGivenListInReversedOrder() {
        List<Double> decimalList = List.of(12.45, 23.58, 17.13, 42.89, 33.78, 71.85, 56.98, 21.12);
        List<Double> revSortedLst = decimalList.stream().sorted(Comparator.reverseOrder()).toList();
        System.out.println(revSortedLst);

    }

    private static void findFreqOfEachElementInAList() {
        List<String> stationeryList = List.of("Pen", "Eraser", "Note Book", "Pen", "Pencil", "Stapler", "Note Book", "Pencil");
        Map<String, Long> countMap = stationeryList.parallelStream()
                .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));
        System.out.println(countMap);
    }

    private static void findFreqOfCharsInString() {
        Map<Character, Long> countMap = "Java Concept Of The Day".chars()
                .mapToObj(c ->(char) c)
                .collect(Collectors.groupingBy(Function.identity(), //Returns a function that always returns its input argument.
                        Collectors.counting()));
        System.out.println(countMap);
    }

    private static void highestPidEmployeeInEachDept(List<Staff> staff) {
        Map<String, Optional<Staff>> map = staff.stream()
                        .collect(Collectors.groupingBy(
                                Staff::getDepartment,
                                Collectors.maxBy(Comparator.comparingDouble(Staff::getAge))));

        System.out.println(map);
    }

    private static void sumOfSalariesInEachDept(List<Staff> staff) {

        Map<String, Double> map = staff.stream()
                .collect(Collectors.groupingBy(
                        Staff::getDepartment,
                        Collectors.summingDouble(Staff::getAge)
                ));
        System.out.println(map);
    }

    private static void countNumberOfStaffPerDept(List<Staff> staff) {
        Map<String, Long> map = staff.stream()
                .collect(Collectors.groupingBy(
                        Staff::getDepartment,
                        Collectors.counting()
                ));
        System.out.println(map);
    }

    private static void averageSalaryOfEachDept(List<Staff> staff) {
        Map<String, Double> avgSal = staff.stream()
                .collect(Collectors.groupingBy(Staff::getDepartment,
                        Collectors.averagingDouble(Staff::getAge)));
        System.out.println(avgSal);
    }

    private static void groupByCity(List<Staff> staff) {
        Map<String, List<Staff>> staffByDpt = staff.parallelStream()
                .collect(Collectors.groupingBy(Staff::getDepartment));
        System.out.println(staffByDpt);
    }

    private static void listOfObjectsToAnotherListOfObjects(List<Staff> staff) {
        List<NewStaff> newStaffs = staff.stream()
                .map( s -> {
                    return new NewStaff(s.getName(), s.getAge(), s.getSalary(), s.getAddresses().get(0));
                })
                .toList();
        newStaffs.forEach(System.out::println);
    }

    private static void listOfObjectsToListOfStringsUsingLFlatMap(List<Staff> staff) {//Flattening and mapping. If a list contains another list then to access internal list we need to use flatmap.

        List<String> city = staff.stream()
                .flatMap( s -> s.getAddresses().stream()
                        .map(Address::getCity)
                )
                .toList();
        System.out.println(city);
    }

    private static List<Staff> getStaff() {
        return Arrays.asList(
                new Staff("mkyong", 30, new BigDecimal(10000), "HR", new Address(4, "Glebelands")),
                new Staff("jack", 27, new BigDecimal(20000), "Accounts", new Address(3, "Walton")),
                new Staff("lawrence", 33, new BigDecimal(30000), "IT", new Address(2, "Kingston")),
                new Staff("Shashwat", 43, new BigDecimal(13000), "IT", new Address(40, "Kingston")),
                new Staff("Kavita", 23, new BigDecimal(35000), "Accounts", new Address(23, "Walton"))
        );
    }

    private static void listOfObjectsToListOfStrings(List<Staff> staff) {
        List<String> names = staff.stream()
                .map(Staff::getName)
                .toList();
        System.out.println(names);
    }

    private static void sumOfNumbersInTheList() {
        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5, 6);
        int sum = numbers.stream()
                .reduce(0, (i1, i2) -> i1+i2);//reduce is a terminal operation.
        System.out.println(sum);
    }

    private static void sumOfNumbersInTheListUsingParallelStream() {
        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5, 6);
        int sum = numbers.parallelStream()
                .reduce(0,
                        (i1, i2) -> i1+i2,//sum of two numbers in one of the parallel thread.
                        (i3, i4) -> i3+i4);//combining results from different threads.
        System.out.println(sum);
    }

    private static void convertToUpperCase() {

        List<String> alpha = Arrays.asList("a", "b", "c", "d");
        List<String> alphaUpper = alpha.stream()
                .map(String::toUpperCase)
                .peek(System.out::println)
                .toList();

    }
}
