package com.internship.week2.day3.module5;

import java.util.Comparator;

public class CGPAComparator implements Comparator<Student> {

    @Override
    public int compare(Student s1, Student s2) {
        return Double.compare(s1.getCgpa(), s2.getCgpa());
    }
}
