package com.internship.week2.day3;

import java.util.Objects;

public class Student {

    private int rollNo;
    private String name;

    public Student(int rollNo, String name) {
        this.rollNo = rollNo;
        this.name = name;
    }

    @Override
    public String toString() {
        return "Student{" +
                "rollNo=" + rollNo +
                ", name='" + name + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Student student = (Student) o;
        return this.rollNo == student.rollNo;
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(name);
    }
}
