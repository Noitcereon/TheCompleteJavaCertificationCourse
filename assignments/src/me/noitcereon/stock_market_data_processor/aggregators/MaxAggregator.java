package me.noitcereon.stock_market_data_processor.aggregators;

import java.util.ArrayList;
import java.util.List;

public class MaxAggregator extends Aggregator{

    public MaxAggregator() {
        this.numbers = new ArrayList<>();
    }

    public MaxAggregator(List<Double> numbers) {
        super(numbers);
    }

    @Override
    public double calculate() {
        double max = numbers.get(0);
        for(Double number : numbers){
            if(number > max){
                max = number;
            }
        }
        return max;
    }

    @Override
    public List<Double> getValues() {
        return numbers;
    }

}