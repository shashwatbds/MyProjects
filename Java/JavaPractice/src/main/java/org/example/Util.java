package org.example;

import org.example.bean.Employee;

import java.util.ArrayList;
import java.util.List;

public class Util {

    public static List<Employee> employeeList() {
        List<Employee> employees = new ArrayList<>();
        Employee emp1 = new Employee(1, "Shashwat", 36, "Male", "SW", 2010, 20000.0);
        Employee emp2 = new Employee(1, "Monica", 32, "Female", "Account", 2015, 30000.0);
        Employee emp3 = new Employee(1, "Kavita", 36, "Female", "Account", 2011, 40000.0);
        Employee emp4 = new Employee(1, "Vished", 30, "Male", "Marketing", 2017, 15000.0);
        employees.add(emp1);employees.add(emp2);employees.add(emp3);employees.add(emp4);
        return employees;
    }

}
