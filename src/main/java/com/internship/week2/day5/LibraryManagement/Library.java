package com.internship.week2.day5.LibraryManagement;

import com.internship.week2.day5.LibraryManagement.Exceptions.BookNotFoundException;
import com.internship.week2.day5.LibraryManagement.Exceptions.BookUnavailableException;
import com.internship.week2.day5.LibraryManagement.Exceptions.DuplicateIsbnException;

import java.util.ArrayList;

public class Library {

    private ArrayList<Book> books = new ArrayList<>();
    private ArrayList<Member> members = new ArrayList<>();

    public void addBook(Book book) throws DuplicateIsbnException {

        for (Book b: books) {
            if (b.getIsbn().equals(book.getIsbn())) {
                throw new DuplicateIsbnException("Duplicate ISBN: " + book.getIsbn());
            }
        }
        books.add(book);
    }

    public void addMember(Member member) {
        members.add(member);
    }

    public void issueBook(String isbn, Member member) throws BookNotFoundException, BookUnavailableException {

        Book foundBook = null;

        for (Book b: books) {
            if (b.getIsbn().equals(isbn)) {
                foundBook = b;
                break;
            }
        }

        if(foundBook == null) {
            throw new BookNotFoundException("Book with ISBN: " + isbn + " not found.");
        }

        if(foundBook.getAvailableCopies() == 0) {
            throw new BookUnavailableException("No copies available");
        }

        foundBook.issueCopy();
        member.issueBook(foundBook);
        System.out.println("Book Issued to Member " + member.getMemberId());
    }
}
