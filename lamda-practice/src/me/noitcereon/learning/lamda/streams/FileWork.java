package me.noitcereon.learning.lamda.streams;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class FileWork {
    private static final String RESOURCE_FOLDER = System.getProperty("user.dir")
            + File.separator + "lamda-practice" + File.separator + "src" + File.separator + "resources";
    private static final Path STOCK_DATA_CSV = Paths.get(RESOURCE_FOLDER + File.separator + "stockDataCsv.txt");
    private static final Path WORD_FILE = Paths.get(RESOURCE_FOLDER + File.separator + "wordFile.txt");

    private FileWork() {
    }

    public static void doWork() throws IOException {
        try (Stream<String> words = Files.lines(WORD_FILE);) {
            // Example 7:
            words.filter(x -> x.length() > 6)
                    .sorted()
                    .forEach(x -> System.out.print(x + ", "));
            System.out.println();
        }

        // Example 8:
        try (Stream<String> words = Files.lines(WORD_FILE);) {
            List<String> thWords = words.filter(x -> x.contains("th"))
                    .collect(Collectors.toCollection(ArrayList::new));
            System.out.println("thWords: " + thWords); // [Samantha, Health Insurance]
        }
        try (Stream<String> stockData = Files.lines(STOCK_DATA_CSV);) {
            List<String[]> wellFormedStockDataLines = stockData.map((String line) -> line.split(","))
                    .filter((String[] array) -> array.length > 3)
                    .collect(Collectors.toList());
            System.out.println("wellFormedLinesCount=" + wellFormedStockDataLines.size());
            for (String[] line : wellFormedStockDataLines) {
                System.out.println(Arrays.toString(line));
                System.out.println("array size="+line.length);
            }
        }
    }
}
