package me.noitcereon.processing_files.scanner;

import java.util.Scanner;

public class ScannerWorker {
    private ScannerWorker(){}
    public static void run(boolean shouldRun) {
        if(shouldRun == false) return;
        Scanner scanner = new Scanner(System.in);
        String enteredText = requestUserInput(scanner);
        System.out.println(enteredText);
    }
    private static String requestUserInput(Scanner scanner){
        System.out.print("Write input: ");
        return scanner.next();
    }
}
