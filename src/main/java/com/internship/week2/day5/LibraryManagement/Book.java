package com.internship.week2.day5.LibraryManagement;

public class Book {

    private String isbn;
    private String title;
    private int availableCopies;

    public Book(String isbn, String title, int availableCopies) {
        this.isbn = isbn;
        this.title = title;
        this.availableCopies = availableCopies;
    }

    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getAvailableCopies() {
        return availableCopies;
    }

    public void setAvailableCopies(int availableCopies) {
        this.availableCopies = availableCopies;
    }

    @Override
    public String toString() {
        return "Book{" +
                "isbn='" + isbn + '\'' +
                ", title='" + title + '\'' +
                ", availableCopies=" + availableCopies +
                '}';
    }

    public void issueCopy() {
        availableCopies--;
    }
}
