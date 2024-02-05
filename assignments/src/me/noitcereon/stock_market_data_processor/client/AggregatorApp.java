package me.noitcereon.stock_market_data_processor.client;


import me.noitcereon.stock_market_data_processor.aggregators.AggregatorProcessor;
import me.noitcereon.stock_market_data_processor.aggregators.MaxAggregator;

import java.io.IOException;

public class AggregatorApp {
    public static void main(String[] args) throws IOException {
        MaxAggregator agg = new MaxAggregator();
        AggregatorProcessor<MaxAggregator> aggsProcessor = new AggregatorProcessor<>(agg, "table.csv");
        double value = aggsProcessor.runAggregator(1);
        System.out.println(value);
        /* -- Task description --
            1. Read the classes Aggregator, Min-, Max- and Mean-Aggregator.
            2. Implement AggregatorProccessor and the runAggregator method inside it.
         */
    }
}
