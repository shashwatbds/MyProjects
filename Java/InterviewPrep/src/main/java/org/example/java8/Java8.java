package org.example.java8;

import org.example.pojo.Employee;
import org.example.pojo.Student;
import org.example.util.TestData;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Java8 {

    public static void main(String[] args) {

        //Employees
        System.out.println("\n\nEmployees");
        List<Employee> employees = TestData.getEmployeeData();
        countEmployeesInEachDept(employees);
        findAvgSalaryInEachDept(employees);
        findHighestPaidEmployee(employees);
        findSeniorMostEmployee(employees);
        mergeMapsWithConflictingValue(employees);

        //Students
        System.out.println("\n\nStudents");
        List<Student> students = TestData.getStudentsData();
        groupStudentBySubject(students);
        findTotalStudents(students);
        findHighestLowestAveragePercentage(students);
        findSubjectsOffered(students);
        findNameAndPercentageOfAllStudents(students);
        findTop3PerformingStudents(students);
        partitionStudentsByMarks(students);
    }

    private static void mergeMapsWithConflictingValue(List<Employee> employees) {
        Map<Integer, String> map1 = new HashMap<>();
        map1.put(1,"One");
        map1.put(2,"Two");
        map1.put(3,"Three");
        map1.put(4,"Four");
        Map<Integer, String> map2 = new HashMap<>();
        map2.put(1,"OneOnly");

        Map<Integer, String> map3 = new HashMap<>(map1);
        map2.forEach((Key, Value) -> map3.merge(Key, Value, (value1, value2) -> value1.length() > value2.length() ? value1 : value2));

        System.out.println(map3);

        Map<Integer, String> map4 = Stream.concat(map1.entrySet().stream(), map2.entrySet().stream())
                .collect(Collectors.toMap(
                        Map.Entry::getKey,
                        Map.Entry::getValue,
                        (value1, value2) -> value1.length() > value2.length() ? value2 : value1)
                );
        System.out.println(map4);
    }

    private static void findSeniorMostEmployee(List<Employee> employees) {
        employees.parallelStream()
                .mapToInt(Employee::getYearOfJoining)
                .min()
                .ifPresent(System.out::println);

        Optional<Employee> employeeOptional = employees.stream()
                .sorted(Comparator.comparingInt(Employee::getYearOfJoining))
                .findFirst();
        if(employeeOptional.isPresent())
            System.out.println(employeeOptional.get());
    }

    private static void findHighestPaidEmployee(List<Employee> employees) {
        //find highest Salary
        employees.parallelStream()
                .mapToDouble(Employee::getSalary)
                .max()
                .ifPresent(System.out::println);
        //print employee with highest Salary
        employees.stream()
                .sorted(Comparator.comparingDouble(Employee::getSalary).reversed())
                .findFirst()
                .ifPresent(System.out::println);



    }

    private static void findAvgSalaryInEachDept(List<Employee> employees) {
        Map<String, Double> map = employees.parallelStream()
                .collect(Collectors.groupingBy(Employee::getDepartment, Collectors.averagingDouble(Employee::getSalary)));
        System.out.println(map);
    }

    private static void countEmployeesInEachDept(List<Employee> employees) {
        Map<String, Long> map = employees.parallelStream()
                .collect(Collectors.groupingBy(Employee::getDepartment, Collectors.counting()));
        System.out.println(map);
    }

    private static void groupStudentBySubject(List<Student> students) {
        Map<String, List<Student>> map = students.parallelStream()
                .collect(Collectors.groupingBy(Student::getSubject));
        System.out.println(map);
    }

    private static void findTotalStudents(List<Student> students) {
        long count = students.parallelStream().count();
        System.out.println(count);
    }

    private static void findHighestLowestAveragePercentage(List<Student> students) {
        System.out.println(students.parallelStream().collect(Collectors.summarizingDouble(Student::getPercentage)).getAverage());
        System.out.println(students.parallelStream().collect(Collectors.summarizingDouble(Student::getPercentage)).getMax());
        System.out.println(students.parallelStream().collect(Collectors.summarizingDouble(Student::getPercentage)).getMin());
    }

    private static void findSubjectsOffered(List<Student> students) {
        List<String> subjects = students.parallelStream()
                .map(Student::getSubject)
                .distinct()
                .toList();
        System.out.println(subjects);
    }

    private static void findNameAndPercentageOfAllStudents(List<Student> students) {
        Map<String, Double> map  = students.parallelStream()
                .collect(Collectors.toMap(Student::getName, Student::getPercentage));
        System.out.println(map);
    }

    private static void findTop3PerformingStudents(List<Student> students) {
       List<Student> list = students.parallelStream().sorted(Comparator.comparingDouble(Student::getPercentage).reversed()).limit(3).toList();
       System.out.println(list);
    }

    private static void partitionStudentsByMarks(List<Student> students) {
        Map<Boolean, List<Student>> map = students.parallelStream().collect(Collectors.partitioningBy(s -> s.getPercentage() > 60));
        System.out.println(map);
    }

}
