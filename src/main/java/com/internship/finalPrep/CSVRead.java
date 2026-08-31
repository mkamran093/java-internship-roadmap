package com.internship.finalPrep;

import com.internship.week2.day5.LibraryManagement.Library;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

public class CSVRead {

    public static void main(String[] args) {

        Path file = Path.of("students.csv");

        try {
            List<String> lines = Files.readAllLines(file);

            for (String line: lines) {
                String[] parts = line.split(",");
                String name = parts[0];
                double marks = Integer.parseInt(parts[1]);

                String result = marks > 50 ? "PASS" : "FAIL";

                System.out.println(name + ": " + result);
            }
        } catch (IOException e) {
            System.out.println("Error reading file: " + e.getMessage());
        } catch (NumberFormatException e) {
            System.out.println( "Invalid score in CSV file." );
        }
    }
}
