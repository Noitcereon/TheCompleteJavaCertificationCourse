package me.noitcereon.stock_market_data_processor.aggregators;

import me.noitcereon.stock_market_data_processor.client.StockFileApplication;
import me.noitcereon.stock_market_data_processor.fileprocessors.StockFileReader;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class AggregatorProcessor<T extends Aggregator>{

    private T aggregator;
    private final StockFileReader stockFileReader;

    public AggregatorProcessor(T aggregator, String dataFilePath){
        this.aggregator = aggregator;
        this.stockFileReader = new StockFileReader(dataFilePath);
    }

    /**
     * Makes a calculation on the data in the specified column based on the given Aggregator implementation.
     * @param column The column in the dataset (e.g. table.csv), starting from number 1.
     * @return The result of the calculation.
     */
    public double runAggregator(int column) throws IOException {
        if(column == 0) return 0;
        Map<Integer,String> categories = mapColumnNumberToCategory();
        String categoryToCalculateOn = categories.get(column);
        List<HashMap<String, Double>> fullDataSet = StockFileApplication.populateStockFileData(stockFileReader.getHeaders(), stockFileReader.readFileData());
        // 1. Get the data from the column we're working with
        for (HashMap<String, Double> dataRow : fullDataSet) {
            if(dataRow.containsKey(categoryToCalculateOn)){
                // 2. Add to aggregator
                aggregator.add(dataRow.get(categoryToCalculateOn));
            }
        }
        // 3. Perform calculation.
        return aggregator.calculate();
    }

    private Map<Integer, String> mapColumnNumberToCategory() throws IOException {
        Map<Integer, String> categoryToColumnMap = new HashMap<>();
        int tmpColumn = 1;
        for (String header : stockFileReader.getHeaders()) {
            categoryToColumnMap.put(tmpColumn, header);
            tmpColumn++;
        }
        return categoryToColumnMap;
    }

    public T getAggregator() {
        return aggregator;
    }

    public void setAggregator(T aggregator) {
        this.aggregator = aggregator;
    }
}
