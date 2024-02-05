package me.noitcereon.learning.collections;

import me.noitcereon.learning.collections.models.Person;

import java.util.*;

import static me.noitcereon.learning.collections.StaticData.getStringStringTreeMap;

public class CollectionsMain {
    public static void main(String[] args){
        List<Person> people = StaticData.getPeople();
        printElements(people);

        Set<Person> peopleSet = StaticData.getPeopleSet();
        printElements(peopleSet);

        Set<Person> peopleSetLinked = new LinkedHashSet<>(people);
        printElements(peopleSetLinked);

        Collections.sort(people); // uses the 'natural order' (the compareTo defined in Person)
        System.out.println(people);

        // TreeMap sorts the entries (based on the key) in their 'natural order'.
        Map<String, String> dictionary = getStringStringTreeMap();
        printElements(dictionary);
    }



    public static void printElements(List<?> elements){
        for (Object element : elements) {
            System.out.println(element);
        }
        System.out.println("Done printing List.");
    }
    public static void printElements(Set<?> elements){
        for (Object element : elements) {
            System.out.println(element);
        }
        System.out.println("Done printing Set.");
    }
    public static void printElements(Map<?, ?> elements){
        for (Map.Entry<?, ?> element : elements.entrySet()) {
            System.out.println(element);
        }
        System.out.println("Done printing Map.");
    }
}
