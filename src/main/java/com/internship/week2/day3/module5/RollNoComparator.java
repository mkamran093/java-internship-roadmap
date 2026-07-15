package com.internship.week2.day3.module5;

import java.util.Comparator;

public class RollNoComparator implements Comparator<Student> {

    @Override
    public int compare(Student s1, Student s2) {
        return Integer.compare(s1.getRollNo(), s2.getRollNo());
    }
}
