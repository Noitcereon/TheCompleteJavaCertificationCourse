package me.noitcereon.generics;

import java.util.HashSet;
import java.util.Set;

public class BasicGenerics {
    private BasicGenerics(){}

    public static void doWork(){
        Set<String> set1 = new HashSet<>();
        set1.add("Foo");
        set1.add("Bar");
        set1.add("Baz");
        Set<String> set2 = new HashSet<>();
        set1.add("Foo");
        set1.add("Bar");
        set1.add("Baz");
        set1.add("Noitcereon");
        set1.add("Unique Entry!");
        Set<String> combinedSet = BasicGenerics.combine(set1, set2);
        System.out.println(combinedSet);

        String outcome = BasicGenerics.doSomethingWith3Generics("A", 123, 9L);
        System.out.println(outcome);
    }

    // The first <T> element is the definition of T.
    public static <T> Set<T> combine(Set<T> set1, Set<T> set2){
        set1.addAll(set2);
        return set1;
    }
    public static <T1, T2 extends Number, T3 extends Number> String doSomethingWith3Generics(T1 a, T2 b, T3 c){
        String aString = a.toString();
        return aString + (b.doubleValue() + c.doubleValue());
    }
}
