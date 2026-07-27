package com.internship.week4.day1.LibraryManagementSystem;

import java.util.ArrayList;
import java.util.List;

public class Member {

    private String name;
    private List<Book> borrowedBooks = new ArrayList<>();

    public Member(String name) {
        this.name = name;
    }

    public void borrowBook(Book book) {
        borrowedBooks.add(book);
        book.borrow();
    }

    public void returnBook(Book book) {

        for (Book b : borrowedBooks) {

            if (b.getTitle().equals(book.getTitle())) {
                borrowedBooks.remove(book);
                break;
            }

        }

        book.returnBook();
    }

    public int getBorrowCount() {
        return borrowedBooks.size();
    }

    public String getName() {
        return name;
    }

}
