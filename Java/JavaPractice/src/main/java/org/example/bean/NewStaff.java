package org.example.bean;

import java.math.BigDecimal;
import java.util.List;

public class NewStaff {
    private String name;
    private int age;
    private BigDecimal salary;
    private List<Address> addresses;

    @Override
    public String toString() {
        return "NewStaff{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", salary=" + salary +
                ", addresses=" + addresses +
                '}';
    }

    public NewStaff(String name, int age, BigDecimal salary) {
        this.age = age;
        this.name = name;
        this.salary = salary;
        this.addresses = List.of(new Address(4, "Claygate"));
    }


    public NewStaff(String name, int age, BigDecimal salary, Address address) {
        this.age = age;
        this.name = name;
        this.salary = salary;
        this.addresses = List.of(address);
    }
    public String getName() {
        return name;
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
    public List<Address> getAddresses() {
        return addresses;
    }

    public void setAddresses(List<Address> addresses) {
        this.addresses = addresses;
    }
}
