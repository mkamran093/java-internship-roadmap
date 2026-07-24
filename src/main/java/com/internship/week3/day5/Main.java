package com.internship.week3.day5;

import java.io.BufferedReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {

    public static void saveStudents(List<Student> students, Path path) {
        String line;
        try(FileWriter writer = new FileWriter(path.toFile())) {
            for (Student s : students) {
                line = s.getId() + "," + s.getName() + "," + s.getMarks() + '\n';
                writer.append(line);

            }
        } catch (IOException e) {
            System.out.println("Error Writing to file");
        }
    }

    public static List<Student> loadStudent(Path path) {

        List<Student> students = new ArrayList<>();
        String line;
        try(BufferedReader reader = Files.newBufferedReader(path)) {
            while((line = reader.readLine()) != null) {
                String[] columns = line.split(",");
                students.add(new Student(Integer.parseInt(columns[0]), columns[1], Integer.parseInt(columns[2])));
            }
        } catch (IOException e) {
            System.out.println("Error reading file");
        }

        return students;
    }

    public static void main(String args[]) {

        Scanner sc = new Scanner(System.in);
        System.out.print("How many students: ");
        int number = sc.nextInt();
        sc.nextLine();
        int id, marks;
        String name;
        List<Student> students = new ArrayList<>();
        for (int i = 1; i <= number; i++) {
            System.out.print("Id: ");
            id = sc.nextInt();
            sc.nextLine();
            System.out.print("Name: ");
            name = sc.nextLine();
            System.out.print("marks: ");
            marks = sc.nextInt();
            Student s = new Student(id, name, marks);
            students.add(s);
        }

        Path path = Path.of("students.csv");
        saveStudents(students, path);

        System.out.println(loadStudent(path));
    }
}
