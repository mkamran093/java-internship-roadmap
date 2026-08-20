package com.library.service;

import com.library.model.Book;
import com.library.repository.BookRepository;
//import com.library.exception.BookNotFoundException;
//import com.library.exception.DuplicateBookException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;

public class BookService {

    private static final Logger log = LoggerFactory.getLogger(BookService.class);

    private final BookRepository bookRepository;

    public BookService(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
        log.info("Service Initiated");
    }

    public Book addBook(Book book) {
        // TODO: Implementation
        // 1. Check if ISBN already exists
        // 2. If exists, throw DuplicateBookException
        // 3. Save the book
        // 4. Log the operation
        // 5. Return saved book
        return null; // Remove this
    }

    public Book getBookById(Long id) {
        // TODO: Implementation
        // 1. Find by ID
        // 2. If not found, throw BookNotFoundException
        // 3. Return the book
        return null; // Remove this
    }

    public List<Book> getAllBooks() {
        // TODO: Implementation
        // 1. Get all books from repository
        // 2. Log operation
        // 3. Return list
        return null; // Remove this
    }

    public Book updateBook(Book book) {
        // TODO: Implementation
        // 1. Check if book exists
        // 2. Check if ISBN is changing and duplicates
        // 3. Update the book
        // 4. Log operation
        // 5. Return updated book
        return null; // Remove this
    }

    public void deleteBook(Long id) {
        // TODO: Implementation
        // 1. Check if book exists
        // 2. Delete the book
        // 3. Log operation
    }

    public Book borrowBook(Long id) {
        // TODO: Implementation
        // 1. Get the book
        // 2. Check if available
        // 3. Set available to false
        // 4. Save the book
        // 5. Log operation
        // 6. Return updated book
        return null; // Remove this
    }

    public Book returnBook(Long id) {
        // TODO: Implementation
        // 1. Get the book
        // 2. Check if not available (borrowed)
        // 3. Set available to true
        // 4. Save the book
        // 5. Log operation
        // 6. Return updated book
        return null; // Remove this
    }
}