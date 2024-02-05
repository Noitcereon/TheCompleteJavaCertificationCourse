package me.noitcereon.learning.collections.models;

import java.util.Objects;

public class Person implements Comparable<Person> {
    private String name;
    private String email;
    private int age;

    public Person() {
        this.name = "";
        this.email = "";
    }

    public Person(String name, String email, int age) {
        this.name = name;
        this.email = email;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", email='" + email + '\'' +
                ", age=" + age +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Person person = (Person) o;
        return getAge() == person.getAge() && Objects.equals(getName(), person.getName()) && Objects.equals(getEmail(), person.getEmail());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getName(), getEmail(), getAge());
    }

    /**
     * Compares given 'other' person with 'this' person based on their name.
     * @param other the object to compare to.
     */
    @Override
    public int compareTo(Person other) {
        return this.name.compareTo(other.getName());
    }
}
