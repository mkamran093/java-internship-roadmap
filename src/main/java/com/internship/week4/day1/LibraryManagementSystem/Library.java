package com.internship.week4.day1.LibraryManagementSystem;

public class Library {

    public void borrowBook(Member member, Book book) {

        if (!book.isAvailable()) {
            System.out.println("Book unavailable.");
            return;
        }

        if (member.getBorrowCount() >= 3) {
            System.out.println("Borrow limit reached.");
            return;
        }

        member.borrowBook(book);

        System.out.println(member.getName() + " borrowed " + book.getTitle());
    }

}
