package org.example.oop;

import org.example.pojo.Student;
import org.example.util.TestData;
import java.util.ArrayList;
import java.util.List;

public final class ImmutableClass {

    private final String name;
    private final Integer id;
    private final List<String>  hobbies;
    private final List<Student>  students;

    public ImmutableClass(String name, Integer id, List<String> hobbies, List<Student>  studentsParam) {
        this.name = name;
        this.id = id;
        this.hobbies = new ArrayList<>(hobbies);

        //// below is a trap, you are using same reference of the list passed and can be modified from outside the class.
        //// To use this you must have an immutable list passed using List.of()
//        this.students = studentsParam;//this will still have this list as immutable

        ////Below could work if it is a list of non reference variables
//        this.students = new ArrayList<>(studentsParam);

        ////Deep copy if a backed collections is passed or List contains another reference vars
        students = new ArrayList<>();
        studentsParam.forEach( s -> {
            Student student = new Student(s.getName(), s.getId(), s.getSubject(), s.getPercentage());
            students.add(student);
        });
    }

    public String getName() {
        return name;
    }

    public Integer getId() {
        return id;
    }

    public List<String> getHobbies() {
        return new ArrayList<>(hobbies);//if this was a list<referenceVariable> then we would have required to make deep copy
    }

    public List<Student> getStudents() {

        List<Student> studentsCopy = new ArrayList<>();
        for(Student student : this.students) {
            Student s = new Student(student.getName(), student.getId(), student.getSubject(), student.getPercentage());
            studentsCopy.add(s);
        }
        return studentsCopy;
    }

    public static void main(String[] args) {
        List<String> hobbies = new ArrayList<>();
        hobbies.add("playing");
        List<Student> students = TestData.getStudentsDataNormal();
        ImmutableClass immutableClass = new ImmutableClass("Shashwat", 1, hobbies, TestData.getStudentsData());
        System.out.println(immutableClass.getHobbies());
        System.out.println(immutableClass.getStudents().size());
        hobbies.add("Studying");
        students.add(new Student("Bipin", 23, "Arts", 78.9));
        System.out.println(immutableClass.getHobbies());
        System.out.println(immutableClass.getStudents().size());//same since the list if not backed
        immutableClass.getStudents().add(new Student("Bipin", 23, "Arts", 78.9));//this will be added sinc we did not have deep copy of the list while returning.
        System.out.println(immutableClass.getStudents().size());//Size wont change when we have copying list in constructor and getter but we will still be able to change the properties on student if we dont have deep copy of the student object as well.
        immutableClass.getStudents().get(1).setName("Rohit");
        System.out.println(immutableClass.getStudents().get(1));
    }
}
