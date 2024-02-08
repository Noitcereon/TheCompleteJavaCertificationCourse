package me.noitcereon.learning.lamda.streams;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class StreamApp {
    public static void main(String[] args){
        doWork();
    }
    @SuppressWarnings("CallToPrintStackTrace")
    public static void doWork(){
        // Example 1:
        IntStream.range(1, 10) // exclusive
                .skip(5) // skip first 5 entries. (intermediate operation)
                .forEach(number -> System.out.print(number)); // out: 6789 (terminal operation
        System.out.println();
        // Example 2:
        int sum = IntStream.range(1, 10).sum();
        System.out.println(sum); // 45
        // Example 3:
        Stream.of("Hello", "bottle", "Africa")
                .sorted() // Uses String's 'natural order' for sorting (Comparable implementation)
                .findFirst()
                .ifPresent(x -> System.out.println(x)); // out: Africa
        // Example 4:
        String[] items = {"car", "computer", "toothpaste", "box",  "pencil", "tent", "door", "toy"};
        Stream.of(items)
                .filter((String item) -> item.startsWith("t"))
                .sorted()
                .forEach(item -> System.out.print(item+", "));
        System.out.println();
        // Example 5:
        Arrays.stream(new int[] { 2, 4, 6, 8, 10})
                .map(x -> x*x) // 2*2 + 4*4 + 6*6 + 8*8 + 10*10 = 220
                .average()// 220 / 5
                .ifPresent(value -> System.out.println("average = " + value)); // 44.0
        // Example 6:
        List<String> items2 = Arrays.asList("Computer", "Toothpaste", "Box", "Car", "Tent", "Pencil");
        List<String> filteredItems2 = items2.stream()
                .map(String::toLowerCase)
                .filter(item -> item.startsWith("c"))
                .collect(Collectors.toCollection(ArrayList::new));
        System.out.println(filteredItems2); // out: [computer, car]

        // File examples:
        try {
            FileWork.doWork();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
