package com.internship.week2.day5.ContactList;

public class Main {

    public static void main(String args[]) {

        ContactList contactList = new ContactList();

        contactList.addContact(new Contact("Ali", "1234567890"));
        contactList.addContact(new Contact("Ahmed", "33698792720"));
        contactList.addContact(new Contact("Sara", "1234567890"));

        contactList.displayContacts();
    }
}
