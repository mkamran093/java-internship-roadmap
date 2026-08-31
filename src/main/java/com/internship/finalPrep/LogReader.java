package com.internship.finalPrep;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class LogReader {

    public static void main(String[] args) {

        int infoCount = 0;
        int warnCount = 0;
        int errorCount = 0;

        try(BufferedReader bf = new BufferedReader(
                new FileReader("app.log")
        )) {
            String line;
            while ((line = bf.readLine()) != null) {
                if (line.contains("INFO")) infoCount++;
                if (line.contains("WARN")) warnCount++;
                if (line.contains("ERROR")) errorCount++;
            }
            System.out.println("INFO Count: " + infoCount);
            System.out.println("WARN Count: " + warnCount);
            System.out.println("ERROR Count: " + errorCount);
        } catch (IOException e) {
            System.out.println("Error reading file");
        }
    }
}
