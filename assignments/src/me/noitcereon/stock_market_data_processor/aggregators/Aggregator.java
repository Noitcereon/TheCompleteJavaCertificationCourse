package me.noitcereon.stock_market_data_processor.aggregators;

import java.util.ArrayList;
import java.util.List;

public abstract class Aggregator {
    List<Double> numbers;

    protected Aggregator(){
        numbers = new ArrayList<Double>();
    }

    protected Aggregator(List<Double> numbers){
        numbers = new ArrayList<Double>(numbers);
    }

    /**
     * add data to the given collection
     *
     */
    public void add(double number) {
        numbers.add(number);
    }
    /**
     * Any class that is a derivative of the abstract class
     * Aggregator must implement the calculate method.
     * @return double
     */
    public abstract double calculate();

    public abstract List<Double> getValues();
}
