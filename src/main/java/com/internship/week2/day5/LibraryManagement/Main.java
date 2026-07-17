package com.internship.week2.day5.LibraryManagement;

import com.internship.week2.day5.LibraryManagement.Exceptions.BookNotFoundException;
import com.internship.week2.day5.LibraryManagement.Exceptions.BookUnavailableException;
import com.internship.week2.day5.LibraryManagement.Exceptions.DuplicateIsbnException;

public class Main {

    public static void main(String args[]) {

        Library library = new Library();

        try {
            library.addBook(new Book("12345", "The kite runner", 2));
            library.addBook(new Book("12345", "The kite runner", 2));
            library.addBook(new Book("22345", "Al Chemist", 2));
            library.addBook(new Book("32345", "Parizaad", 2));
        } catch (DuplicateIsbnException e) {
            System.out.println(e.getMessage());
        }

        Member m1 = new Member("123", "Kamran");
        Member m2 = new Member("223", "Ali");

        try {
            library.issueBook("12345", m1);
        } catch (BookUnavailableException | BookNotFoundException e) {
            System.out.println(e.getMessage());
        }


    }
}
