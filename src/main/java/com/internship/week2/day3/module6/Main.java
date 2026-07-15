package com.internship.week2.day3.module6;

import java.util.TreeSet;

public class Main {

    public static void main(String args[]) {

        Student s1 = new Student(1, "Kamran", 2.56);
        Student s2 = new Student(2, "Ali", 3.45);
        Student s3 = new Student(3, "Sara", 3.82);
        Student s4 = new Student(4, "Ahmed", 2.91);
        Student s5 = new Student(5, "Ayesha", 3.67);

        TreeSet<Student> byRollNo = new TreeSet<>(new RollNoComparator());
        TreeSet<Student> byName = new TreeSet<>(new NameComparator());
        TreeSet<Student> byCgpa = new TreeSet<>(new CGPAComparator());

        byRollNo.add(s1);
        byRollNo.add(s2);
        byRollNo.add(s3);
        byRollNo.add(s4);
        byRollNo.add(s5);

        byName.add(s1);
        byName.add(s2);
        byName.add(s3);
        byName.add(s4);
        byName.add(s5);

        byCgpa.add(s1);
        byCgpa.add(s2);
        byCgpa.add(s3);
        byCgpa.add(s4);
        byCgpa.add(s5);


        System.out.println("By Name: " + byName.toString());
        System.out.println("By Roll No: " + byRollNo.toString());
        System.out.println("By CGPA: " + byCgpa.toString());

    }
}
