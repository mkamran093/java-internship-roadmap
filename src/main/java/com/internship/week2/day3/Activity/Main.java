package com.internship.week2.day3.Activity;

import java.util.ArrayList;
import java.util.HashSet;

public class Main {

    public static void main(String args[]) {

        ArrayList<Contact> alContacts = new ArrayList<>();
        HashSet<Contact> hsContacts = new HashSet<>();

        Contact c1 = new Contact(1, "Ali", "0300");
        Contact c2 = new Contact(2, "Ahmed", "0310");
        Contact c3 = new Contact(3, "Ali", "0300");

        alContacts.add(c1);
        alContacts.add(c2);
        alContacts.add(c3);

        hsContacts.add(c1);
        hsContacts.add(c2);
        hsContacts.add(c3);

        System.out.println("ArrayList: " + alContacts.toString());
        System.out.println("HashSet:" + hsContacts.toString());

    }
}
