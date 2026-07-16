package com.internship.week2.day4.module5;

class Student {
    int rollNo;

    Student(int rollNo) {
        this.rollNo = rollNo;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Student)) return false;
        Student s = (Student) o;
        return rollNo == s.rollNo;
    }

    @Override
    public int hashCode() {
        return Integer.hashCode(rollNo);
    }

    @Override
    public String toString() {
        return "Student{" +
                "rollNo=" + rollNo +
                '}';
    }
}
