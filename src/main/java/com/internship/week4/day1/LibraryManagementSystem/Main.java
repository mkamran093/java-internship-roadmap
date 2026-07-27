package com.internship.week4.day1.LibraryManagementSystem;

public class Main {

    public static void main(String[] args) {

        Member member = new Member("Ali");

        Book java = new Book("Effective Java");

        member.borrowBook(java);

        member.returnBook(java);

        System.out.println("Book available: " + java.isAvailable());
        System.out.println("Borrowed books: " + member.getBorrowCount());

    }

}