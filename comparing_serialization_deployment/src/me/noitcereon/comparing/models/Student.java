package me.noitcereon.comparing.models;

import java.util.Objects;

public class Student implements Comparable<Student> {
    public int rollNumber;
    public String name;
    public int age;

    public Student(int rollNumber, String name, int age) {
        this.rollNumber = rollNumber;
        this.name = name;
        this.age = age;
    }

    @Override
    public int compareTo(Student otherStudent) {
        return Integer.compare(age, otherStudent.age);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Student student = (Student) o;
        return rollNumber == student.rollNumber && age == student.age && Objects.equals(name, student.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(rollNumber, name, age);
    }

    @Override
    public String toString() {
        return "Student{" +
                "rollNumber=" + rollNumber +
                ", name='" + name + '\'' +
                ", age=" + age +
                '}';
    }
}