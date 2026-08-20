package com.library.service;

import com.library.exception.BookNotAvailableException;
import com.library.exception.BookNotFoundException;
import com.library.exception.DuplicateBookException;
import com.library.model.Book;
import com.library.repository.BookRepository;
//import com.library.exception.BookNotFoundException;
//import com.library.exception.DuplicateBookException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class BookService {

    private static final Logger log = LoggerFactory.getLogger(BookService.class);

    private final BookRepository bookRepository;

    public BookService(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
        log.info("Service Initiated");
    }

    public Book addBook(Book book) {
        if (bookRepository.findByIsbn(book.getIsbn()).isPresent()) {
            throw new DuplicateBookException("Book with ISBN " + book.getIsbn() + " already exists");
        }
        return bookRepository.save(book);
    }

    public Book getBookById(Long id) {
        return bookRepository.findById(id).
                orElseThrow(() -> new BookNotFoundException("Book with ID " + id + " not found"));
    }

    public List<Book> getAllBooks() {
        return bookRepository.findAll();
    }

    public Book updateBook(Book book) {
        Book oldBook = getBookById(book.getId());

        // Check if ISBN is being changed
        if (!book.getIsbn().equals(oldBook.getIsbn())) {
            // Check if new ISBN already exists in another book
            bookRepository.findByIsbn(book.getIsbn())
                    .ifPresent(existingBook -> {
                        throw new DuplicateBookException("Book with ISBN " + book.getIsbn() + " already exists");
                    });
            oldBook.setIsbn(book.getIsbn());  // Update the ISBN
        }

        // Update other fields
        oldBook.setTitle(book.getTitle());
        oldBook.setAuthor(book.getAuthor());
        oldBook.setAvailable(book.isAvailable());

        Book updatedBook = bookRepository.save(oldBook);
        log.info("Book updated: {}", updatedBook.getTitle());
        return updatedBook;
    }

    public void deleteBook(Long id) {
        getBookById(id);  // Ensure book exists
        bookRepository.deleteById(id);
        log.info("Book deleted with ID: {}", id);
    }

    public Book borrowBook(Long id) {
        Book book = getBookById(id);
        if(!book.isAvailable()) {
            throw new BookNotAvailableException("Book with ID " + id + " is currently borrowed");
        }
        book.setAvailable(false);
        log.info("Book borrowed");
        return bookRepository.save(book);
    }

    public Book returnBook(Long id) {
        Book book = getBookById(id);

        if (book.isAvailable()) {
            throw new IllegalStateException("Book with ID " + id + " is already available");
        }

        book.setAvailable(true);
        Book returnedBook = bookRepository.save(book);
        log.info("Book returned: {}", returnedBook.getTitle());
        return returnedBook;
    }
}