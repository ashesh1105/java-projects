package service;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CsvDataFileIO {

    // If source Jira Report to read is in csv format, use this method
    // Ensure there's file with name "report.csv" available under resources folder
    public static List<List<String>> getCsvData(String fileName, String delimiter) {

        List<List<String>> records = new ArrayList<>();

        URL url = CsvDataFileIO.class
                .getClassLoader()
                .getResource(fileName);

        if (url == null) throw new RuntimeException("Could not create URL object with specified file name "
                + fileName + ". Make sure the file is available at src/main/resources folder in Java app.");

        File file = new File(url.getPath());

        try (BufferedReader br = new BufferedReader(new FileReader(file))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] values = line.split(delimiter);
                records.add(Arrays.asList(values));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return records;
    }
}
