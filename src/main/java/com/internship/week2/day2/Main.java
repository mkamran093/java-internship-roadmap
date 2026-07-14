package com.internship.week2.day2;

import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String args[]) {

        List<Person> people = new ArrayList<>();

        Employee e1 = new Employee("kamran", 22, "lskdfljf", 23422, "HR");
        Employee e2 = new Employee("Ali", 25, "lskdsfsfljf", 22422, "Sales");
        Contractor c1 = new Contractor("Hello", 34, "alsdjf", 4, 44);

        people.add(e1);
        people.add(e2);
        people.add(c1);

        for (Person p : people) {
            System.out.println(p.calculatePay());
        }
    }


}
