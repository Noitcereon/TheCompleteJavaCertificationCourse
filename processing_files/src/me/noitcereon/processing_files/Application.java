package me.noitcereon.processing_files;

import me.noitcereon.processing_files.filereader.FileReaderWorker;
import me.noitcereon.processing_files.scanner.ScannerWorker;

public class Application {
    public static void main(String[] args){
        System.out.println("Running processing_files module...");
        ScannerWorker.run(false);
        FileReaderWorker.run(true);

    }

}

