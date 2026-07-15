package com.internship.week2.day3.module5;

import java.util.TreeSet;

public class Main {

    public static void main(String args[]) {

        TreeSet<Student> students = new TreeSet<>(new RollNoComparator());

        students.add(new Student(3, "Kamran", 3.21));
        students.add(new Student(1, "Ali", 3.85));
        students.add(new Student(2, "Sara", 3.26));
        students.add(new Student(2, "Ahmed", 3.63));

        System.out.println(students);
    }
}
