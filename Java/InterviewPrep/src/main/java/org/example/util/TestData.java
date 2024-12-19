package org.example.util;

import org.example.pojo.Employee;
import org.example.pojo.Student;

import java.util.ArrayList;
import java.util.List;

public class TestData {

    public static List<Student> getStudentsData() {

        return List.of(
                new Student("Shashwat", 1, "NonMedical", 75),
                new Student("Kavita", 2, "Commerse", 80),
                new Student("Vished", 3, "Commerse", 60),
                new Student("Deep", 4, "Arts", 53),
                new Student("Shanti", 5, "Arts", 60),
                new Student("Sonia", 6, "Medical", 76)
        );
    }

    public static List<Employee> getEmployeeData() {

        return List.of(
                new Employee(1, "Shashwat", 36, "Male", "IT", 2010, 50000.0),
                new Employee(2, "Kavita", 34, "Female", "Accounts", 2013, 60000.0),
                new Employee(3, "Vished", 32, "Male", "Hospitality", 2010, 50000.0),
                new Employee(4, "Deep", 65, "Male", "Accounts", 2013, 60000.0),
                new Employee(5, "Shanti", 64, "Female", "HR", 2010, 50000.0),
                new Employee(6, "Sonia", 60, "Female", "HR", 2013, 60000.0),
                new Employee(7, "Monika", 30, "Male", "Accounts", 2013, 60000.0),
                new Employee(8, "Hitesh", 64, "Female", "IT", 2010, 50000.0)
        );
    }

    public static List<Student> getStudentsDataNormal() {

        List<Student> students = new ArrayList<>();
        Student student1 =  new Student("Shashwat", 1, "NonMedical", 75);
        Student student2 =  new Student("Kavita", 2, "Commerse", 80);
        Student student3 =  new Student("Vished", 3, "Commerse", 60);
        Student student4 =  new Student("Vished", 3, "Commerse", 60);
        Student  student5 =  new Student("Deep", 4, "Arts", 53);
        Student  student6 =  new Student("Vished", 3, "Commerse", 60);
        students.add(student1);students.add(student2);students.add(student3);
        students.add(student4);students.add(student5);students.add(student6);
        return students;
    }
}
