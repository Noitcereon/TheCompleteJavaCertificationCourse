package me.noitcereon.stock_market_data_processor.client;


import me.noitcereon.stock_market_data_processor.aggregators.AggregatorProcessor;
import me.noitcereon.stock_market_data_processor.aggregators.MaxAggregator;

import java.io.IOException;

public class AggregatorApp {
    public static void main(String[] args) throws IOException {
        MaxAggregator agg = new MaxAggregator();
        AggregatorProcessor<MaxAggregator> aggsProcessor = new AggregatorProcessor<>(agg, "table.csv");
        int column = 1;
        double max = aggsProcessor.runAggregator(column);
        System.out.println("Max="+max); // Column 3 with MaxAggregator should be '143.809998' (or 144.289993 for col 1)
    }
}
