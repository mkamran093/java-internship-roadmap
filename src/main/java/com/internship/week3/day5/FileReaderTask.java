package com.internship.week3.day5;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.Reader;
import java.nio.file.Files;
import java.nio.file.NoSuchFileException;
import java.nio.file.Path;

public class FileReaderTask {

    public static void main(String args[]) {

        Path path = Path.of("src/main/java/com/internship/week3/day5/students.txt");

        int count = 1;
        String line;

        try (BufferedReader reader = Files.newBufferedReader(path)) {

            while ((line = reader.readLine()) != null) {

                if (line.isBlank()) {
                    continue;
                }

                System.out.println(count + ". " + line);
                count++;
            }

            System.out.println("Total students: " + (count - 1));

        } catch (NoSuchFileException e) {
            System.out.println("Error: students.txt not found.");
        } catch (IOException e) {
            System.out.println("Error reading the file.");
        }

    }
}
