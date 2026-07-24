package com.internship.week3.day5;

import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class StudentWriter {

    public static void main(String args[]) {

        Scanner sc = new Scanner(System.in);
        System.out.print("How many students: ");
        int number = sc.nextInt();
        sc.nextLine();
        Path path = Path.of("newStudents.txt");
        List<String> students = new ArrayList<>();
        for (int i = 1; i <= number; i++) {
            System.out.print("Enter student " + i + ": ");
            students.add(sc.nextLine());
        }

        try{
            Files.write(path, students);
            System.out.println("wrote successfully");
        } catch (IOException e) {
            System.out.println("Error writing to file");
        }

    }
}
