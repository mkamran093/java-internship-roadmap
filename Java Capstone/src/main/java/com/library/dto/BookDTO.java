package com.library.dto;

import com.library.model.Book;
import java.util.Objects;

public class BookDTO {

    private Long id;
    private String title;
    private String author;
    private String isbn;
    private boolean available;

    // 1. No-args constructor
    public BookDTO() {
    }

    // 2. All-args constructor
    public BookDTO(Long id, String title, String author, String isbn, boolean available) {
        this.id = id;
        this.title = title;
        this.author = author;
        this.isbn = isbn;
        this.available = available;
    }

    // 3. Constructor from Book (conversion)
    public BookDTO(Book book) {
        this.id = book.getId();
        this.title = book.getTitle();
        this.author = book.getAuthor();
        this.isbn = book.getIsbn();
        this.available = book.isAvailable();
    }

    // 4. Getters and Setters
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

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    public boolean isAvailable() {
        return available;
    }

    public void setAvailable(boolean available) {
        this.available = available;
    }

    // 5. Conversion method: DTO → Book
    public Book toBook() {
        return new Book(id, title, isbn, author, available);
    }

    // 6. toString() for logging/display
    @Override
    public String toString() {
        return "BookDTO{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", author='" + author + '\'' +
                ", isbn='" + isbn + '\'' +
                ", available=" + available +
                '}';
    }

    // 7. equals() and hashCode()
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        BookDTO bookDTO = (BookDTO) o;
        return available == bookDTO.available &&
                Objects.equals(id, bookDTO.id) &&
                Objects.equals(title, bookDTO.title) &&
                Objects.equals(author, bookDTO.author) &&
                Objects.equals(isbn, bookDTO.isbn);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, title, author, isbn, available);
    }
}