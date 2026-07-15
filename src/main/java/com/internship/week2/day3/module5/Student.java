package com.internship.week2.day3.module5;

public class Student implements Comparable<Student> {

    private int rollNo;
    private String name;

    @Override
    public int compareTo(Student student) {
        return Integer.compare(this.rollNo, student.rollNo);
    }
}
