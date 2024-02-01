package me.noitcereon.serialization.models;

import java.io.Serializable;

public class Employee implements Serializable {

    private static final long serialVersionUID = 1L; // Used for serialization to version the class. Should be updated when class changes.
    private String name;
    private int age;

    public Employee() {
        setName("");
    }
    public Employee(String name, int age) {
        this.name = name;
        this.age = age;
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

    @Override
    public String toString() {
        return "Employee{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }
}
