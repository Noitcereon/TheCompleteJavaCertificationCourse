package me.noitcereon.stock_market_data_processor.fileprocessors;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class StockFileReader {
    private final String filePath;
    private static final String RESOURCE_PATH = System.getProperty("user.dir") + File.separator + "assignments" + File.separator + "src" + File.separator + "resources" + File.separator;

    public StockFileReader(String filePath) {
        this.filePath = RESOURCE_PATH + filePath;
    }
    public List<String> getHeaders() throws IOException {
        String line = readFirstLine(filePath);
        String [] header = line.split(",");
        List<String> values;
        values = Arrays.asList(header);
        return values;
    }
    static String readFirstLine(String path) throws IOException {
        try(BufferedReader br = new BufferedReader(new FileReader(path))){
            return br.readLine();
        } catch (FileNotFoundException e){
            File file = new File(path);
            System.err.println("Could not find the file at " + file.getAbsolutePath());
            throw e;
        }
    }
    public List<String> readFileData(){
        File file = null;
        List<String> dataLines = new ArrayList<>();
        try(BufferedReader br = new BufferedReader(new FileReader(this.filePath))){
            file = new File(this.filePath);
            br.readLine(); //NOSONAR java:S2677 Discard first line with headers.
            String lineOfData;
            while((lineOfData = br.readLine()) != null){
                dataLines.add(lineOfData);
            }
        } catch (FileNotFoundException e){
            if(file == null) throw new IllegalStateException(e);
            System.err.println("Could not find the file at " + file.getAbsolutePath());
        } catch (IOException e) {
            throw new IllegalStateException(e);
        }
        return dataLines;
    }
}
