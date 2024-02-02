package me.noitcereon.stock_market_data_processor.client;

import me.noitcereon.stock_market_data_processor.fileprocessors.StockFileData;
import me.noitcereon.stock_market_data_processor.fileprocessors.StockFileReader;

import java.io.IOException;
import java.util.*;

public class StockFileApplication {
    public static void main(String args[]) throws IOException {
        StockFileReader fr = new StockFileReader("table.csv");
        List<HashMap<String, Double>> dataResult = populateStockFileData(fr.getHeaders(), fr.readFileData());
        StockFileData fileData = new StockFileData();
        fileData.addData(dataResult);
        fileData.printData();
        System.out.println(dataResult.size());
    }

    /**
     * Complete the method body so that it returns the given structure needed to
     * populate the data field in the StockFileData class.
     *
     * @param headers A list of headers for the data.
     * @param lines A list of dataLines separated by CSV format. One dataLine should contain data to match the amount of headers.
     * @return A list with all the lines matched to header category.
     */
    public static List<HashMap<String, Double>> populateStockFileData(List<String> headers, List<String> lines) {
        List<HashMap<String, Double>> dataResult = new ArrayList<>();
        for (String dataLine : lines) {
            // Process the dataLine, so it is split into doubles.
            List<String> splitLineData = Arrays.asList(dataLine.split(",")); // Note: I doubt this can handle edge case, when '.' and ',' functionality is reversed in numbers.
            HashMap<String, Double> mapEntry = new HashMap<>();
            if (headers.size() != splitLineData.size()) {
                throw new IllegalArgumentException("The amount of headers and values does not match! Headers count: " + headers.size() + " Doubles count: " + splitLineData.size());
            }
            for (int i = 0; i < headers.size(); i++) {
                // Add the data into its appropriate category (Open, Closed, etc...)
                mapEntry.put(headers.get(i), Double.parseDouble(splitLineData.get(i)));
            }
            dataResult.add(mapEntry);
        }
        return dataResult;
    }
}
