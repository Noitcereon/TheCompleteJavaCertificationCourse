package me.noitcereon.stock_market_data_processor.fileprocessors;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;

public class StockFileData {
    List<HashMap<String, Double>> data = new LinkedList<>();

    public void printData(){
        for(HashMap<String, Double> entry : data){
            System.out.println(entry);
        }
    }

    public void addData(List<HashMap<String, Double>> dataIn){
        data = dataIn;
    }
}
