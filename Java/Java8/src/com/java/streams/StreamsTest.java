package com.java.streams;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import com.java.beans.Employee;

public class StreamsTest {

	public static void main(String[] args) {
		List<Employee> emps = new ArrayList<Employee>();
		emps.add(new Employee("Shashwat1", 34, 25000, 1));
		emps.add(new Employee("Shashwat2", 30, 25000, 1));
		emps.add(new Employee("Shashwat3", 27, 25000, 2));
		emps.add(new Employee("Shashwat4", 24, 25000, 2));
		emps.add(new Employee("Shashwat5", 14, 25000, 3));
	
		// Increase Salary of employees with age > 25 by 10%
		System.out.println(emps);
		List<Employee> emps1 = emps.stream().map(e -> {
			if(e.getAge()>25) {
				e.setSalary(e.getSalary()*1.1);
			}
			return e;
		}).collect(Collectors.toList());
		System.out.println(emps1);
		
		// 2. Map Salary by Department ID
		Map<Integer, List<Employee>> empMap = new HashMap<Integer, List<Employee>>();
		empMap = emps1.stream().collect(Collectors.groupingBy(Employee::getDept));
		System.out.println(empMap);

		//3. Find average salary of all employees.
		double average = emps1.stream().mapToDouble(e -> e.getSalary()).average().getAsDouble();
		System.out.println(average);
		
	}
}
