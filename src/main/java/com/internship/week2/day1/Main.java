package com.internship.week2.day1;

public class Main {

    public static void main(String args[]) {

        Address address = new Address("1", "2", "karachi", "pakistan");
        Department department = new Department("HR");
        Employee emp1 = new Employee("Muhammad", 22, 35000, department, address);
        Employee emp2 = new Employee("Kamran", 23, 40000, department, address);
    }
}
