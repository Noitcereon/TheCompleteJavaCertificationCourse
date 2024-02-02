package me.noitcereon.collections;

import me.noitcereon.collections.models.Person;

import java.util.*;

public class StaticData {
    private StaticData(){}
    public static List<Person> getPeople(){
        Person p1 = new Person();
        Person p2 = new Person("John Doe", "john@doe.com", 34);
        Person p3 = new Person("Sarah Doe", "sara@doe.com", 35);
        Person p3Duplicate = new Person("Sarah Doe", "sara@doe.com", 35);
        Person p4 = new Person("Thomas Andersen", "thomas@gmail.com", 26);
        ArrayList<Person> people = new ArrayList<>();
        people.add(p1);
        people.add(p2);
        people.add(p3);
        people.add(p4);
        people.add(p3Duplicate);
        return people;
    }
    public static Set<Person> getPeopleSet(){
        Person p1 = new Person();
        Person p2 = new Person("John Doe", "john@doe.com", 34);
        Person p3 = new Person("Sarah Doe", "sara@doe.com", 35);
        Person p3Duplicate = new Person("Sarah Doe", "sara@doe.com", 35);
        Person p4 = new Person("Thomas Andersen", "thomas@gmail.com", 26);
        Set<Person> people = new HashSet<>();
        people.add(p1);
        people.add(p2);
        people.add(p3);
        people.add(p4);
        people.add(p3Duplicate);
        return people;
    }
    public static SortedMap<String, String> getStringStringTreeMap() {
        TreeMap<String, String> dictionary = new TreeMap<>();
        dictionary.put("blue", "A color in a specific hue, like the sky without clouds during the day.");
        dictionary.put("green", "A color in a specific hue, like healthy grass.");
        dictionary.put("color", "The property possessed by an object of producing different sensations on the eye as a result of the way it reflects or emits light.");
        dictionary.put("hue", "A colour or shade. ");
        return dictionary;
    }
}
