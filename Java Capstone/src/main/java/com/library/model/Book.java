package com.library.model;

import java.util.Objects;

public class Book {

    private Long id;
    private String title;
    private String isbn;
    private String author;
    private boolean isAvailable;

    public Book() {
    }

    public Book(Long id, String title, String isbn, String author, boolean isAvailable) {
        this.id = id;
        this.title = title;
        this.isbn = isbn;
        this.author = author;
        this.isAvailable = isAvailable;
    }

    public Book(String title, String isbn, String author, boolean isAvailable) {
        this.title = title;
        this.isbn = isbn;
        this.author = author;
        this.isAvailable = isAvailable;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public boolean isAvailable() {
        return isAvailable;
    }

    public void setAvailable(boolean available) {
        isAvailable = available;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Book book = (Book) o;
        return Objects.equals(isbn, book.isbn);
    }

    @Override
    public int hashCode() {
        return Objects.hash(isbn);
    }

    @Override
    public String toString() {
        return "Book{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", isbn='" + isbn + '\'' +
                ", author='" + author + '\'' +
                ", isAvailable=" + isAvailable +
                '}';
    }
}
