package org.example.bean;

import java.math.BigDecimal;
import java.util.List;

public class Staff {
    private String name;
    private int age;
    private BigDecimal salary;
    private String department;
    private List<Address> addresses;

    public Staff(String name, int age, BigDecimal salary, String department) {
        this.age = age;
        this.name = name;
        this.salary = salary;
        this.department = department;
        this.addresses = List.of(new Address(4, "Claygate"));
    }


    public Staff(String name, int age, BigDecimal salary, String department, Address address) {
        this.age = age;
        this.name = name;
        this.salary = salary;
        this.department = department;
        this.addresses = List.of(address);
    }
    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return "Staff{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", salary=" + salary +
                ", department=" + department +
                ", addresses=" + addresses +
                '}';
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public BigDecimal getSalary() {
        return salary;
    }

    public void setSalary(BigDecimal salary) {
        this.salary = salary;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public List<Address> getAddresses() {
        return addresses;
    }

    public void setAddresses(List<Address> addresses) {
        this.addresses = addresses;
    }
}
