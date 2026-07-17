package com.internship.week2.day5.ContactList;

import java.util.ArrayList;
import java.util.HashSet;

public class ContactList {

    private ArrayList<Contact> contacts = new ArrayList<>();
    private HashSet<String> phoneNumbers = new HashSet<>();

    public boolean addContact(Contact c) {

        if(phoneNumbers.contains(c.getPhoneNumber())) {
            System.out.println("Duplicate phone number! contact not added");
            return false;
        }
        contacts.add(c);
        phoneNumbers.add(c.getPhoneNumber());
        return true;
    }

    public void displayContacts() {
        for (Contact c: contacts) {
            System.out.println(c);
        }
    }
}
