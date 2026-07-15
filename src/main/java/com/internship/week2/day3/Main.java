package com.internship.week2.day3;

import java.util.HashSet;
import java.util.Set;

public class Main {

    public static void main(String args[]) {

        Set<Student> students = new HashSet<>();
        students.add(new Student(1, "Ali"));
        students.add(new Student(1, "Ahmed"));

        System.out.println(students);
        System.out.println(students.size());
    }
}
