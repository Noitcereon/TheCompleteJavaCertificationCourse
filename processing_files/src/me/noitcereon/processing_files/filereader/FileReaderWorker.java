package me.noitcereon.processing_files.filereader;


import java.io.*;

public class FileReaderWorker {
    private FileReaderWorker() {
    }

    public static void run(boolean shouldRun) {
        if (!shouldRun) return;
        File myFile = new File("myFile.txt");
        readFileWithoutTryWithResource(myFile);
        readFileWithTryWithResource(myFile);
    }

    /**
     * Shows the "new" Java 7 way to use FileReader  with "try-with-resource"
     *
     * @param myFile
     */
    private static void readFileWithTryWithResource(File myFile) {
        try (FileReader fileReader = new FileReader(myFile);
             BufferedReader bufferedReader = new BufferedReader(fileReader)) {
            String line = bufferedReader.readLine();
            while (line != null) {
                System.out.println(line);
                line = bufferedReader.readLine();
            }
        } catch (FileNotFoundException e) {
            System.out.println("File not found " + myFile.getAbsolutePath());
        } catch (IOException e) {
            System.err.println(e.getMessage());
        }
    }

    /**
     * Showcases how the old way (pre Java 7) would read from files with BufferedReader.
     */
    @SuppressWarnings({"java:S2093", "java:S2095"})
    private static void readFileWithoutTryWithResource(File myFile) {
        BufferedReader bufferedReader = null;
        FileReader fileReader = null;
        try {
            fileReader = new FileReader(myFile);
            bufferedReader = new BufferedReader(fileReader);

            String line = bufferedReader.readLine();
            while (line != null) {
                System.out.println(line);
                line = bufferedReader.readLine();
            }
        } catch (FileNotFoundException e) {
            System.out.println("File not found " + myFile.getAbsolutePath());
        } catch (IOException e) {
            System.err.println(e.getMessage());
        } finally {
            try {
                if (fileReader != null) {
                    fileReader.close();
                }
                if (bufferedReader != null) {
                    bufferedReader.close();
                }
            } catch (IOException e) {
                System.out.println("Unable to close file stream for file " + myFile.getName());
            }
        }
    }

}
