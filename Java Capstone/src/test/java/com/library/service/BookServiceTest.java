package com.library.service;

import com.library.exception.BookNotFoundException;
import com.library.exception.BookNotAvailableException;
import com.library.exception.DuplicateBookException;
import com.library.model.Book;
import com.library.repository.BookRepository;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Optional;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class BookServiceTest {

    @Mock
    private BookRepository bookRepository;

    @InjectMocks
    private BookService bookService;

    private Book testBook;
    private Book anotherBook;

    @BeforeEach
    void setUp() {
        // Create test data
        testBook = new Book(1L, "Test Book", "1234567890", "Test Author", true);
        anotherBook = new Book(2L, "Another Book", "0987654321", "Another Author", true);
    }

    @Test
    void addBook_ShouldSaveBook_WhenIsbnDoesNotExist() {
        // Arrange (Given)
        // Mock repository behavior
        when(bookRepository.findByIsbn(testBook.getIsbn())).thenReturn(Optional.empty());
        when(bookRepository.save(testBook)).thenReturn(testBook);

        // Act (When)
        Book savedBook = bookService.addBook(testBook);

        // Assert (Then)
        assertNotNull(savedBook);
        assertEquals(testBook.getTitle(), savedBook.getTitle());
        verify(bookRepository).findByIsbn(testBook.getIsbn());
        verify(bookRepository).save(testBook);
    }

    @Test
    void addBook_ShouldThrowException_WhenIsbnAlreadyExists() {
        // Arrange
        when(bookRepository.findByIsbn(testBook.getIsbn())).thenReturn(Optional.of(testBook));

        // Act & Assert
        assertThrows(DuplicateBookException.class, () -> bookService.addBook(testBook));
        verify(bookRepository, never()).save(any(Book.class));
    }

    @Test
    void getBookById_ShouldReturnBook_WhenBookExists() {
        // Arrange
        when(bookRepository.findById(1L)).thenReturn(Optional.of(testBook));

        // Act
        Book foundBook = bookService.getBookById(1L);

        // Assert
        assertNotNull(foundBook);
        assertEquals(testBook.getId(), foundBook.getId());
        assertEquals(testBook.getTitle(), foundBook.getTitle());
        verify(bookRepository).findById(1L);
    }

    @Test
    void getBookById_ShouldThrowException_WhenBookDoesNotExist() {
        // Arrange
        when(bookRepository.findById(999L)).thenReturn(Optional.empty());

        // Act & Assert
        assertThrows(BookNotFoundException.class, () -> bookService.getBookById(999L));
        verify(bookRepository).findById(999L);
    }

    @Test
    void getAllBooks_ShouldReturnListOfBooks() {
        // Arrange
        List<Book> books = Arrays.asList(testBook, anotherBook);
        when(bookRepository.findAll()).thenReturn(books);

        // Act
        List<Book> result = bookService.getAllBooks();

        // Assert
        assertEquals(2, result.size());
        verify(bookRepository).findAll();
    }

    @Test
    void updateBook_ShouldUpdateBook_WhenBookExistsAndIsbnNotDuplicate() {
        // Arrange
        Book updatedBook = new Book(1L, "Updated Title", "1234567890", "Updated Author", false);
        when(bookRepository.findById(1L)).thenReturn(Optional.of(testBook));
        when(bookRepository.findByIsbn(updatedBook.getIsbn())).thenReturn(Optional.empty());
        when(bookRepository.save(any(Book.class))).thenReturn(updatedBook);

        // Act
        Book result = bookService.updateBook(updatedBook);

        // Assert
        assertNotNull(result);
        assertEquals("Updated Title", result.getTitle());
        assertEquals("Updated Author", result.getAuthor());
        verify(bookRepository).save(any(Book.class));
    }

    @Test
    void updateBook_ShouldThrowException_WhenNewIsbnAlreadyExists() {
        // Arrange
        Book updatedBook = new Book(1L, "Updated Title", "0987654321", "Updated Author", true);
        when(bookRepository.findById(1L)).thenReturn(Optional.of(testBook));
        when(bookRepository.findByIsbn("0987654321")).thenReturn(Optional.of(anotherBook));

        // Act & Assert
        assertThrows(DuplicateBookException.class, () -> bookService.updateBook(updatedBook));
        verify(bookRepository, never()).save(any(Book.class));
    }

    @Test
    void borrowBook_ShouldSetAvailableToFalse_WhenBookIsAvailable() {
        // Arrange
        Book availableBook = new Book(1L, "Test Book", "1234567890", "Test Author", true);
        Book borrowedBook = new Book(1L, "Test Book", "1234567890", "Test Author", false);
        when(bookRepository.findById(1L)).thenReturn(Optional.of(availableBook));
        when(bookRepository.save(any(Book.class))).thenReturn(borrowedBook);

        // Act
        Book result = bookService.borrowBook(1L);

        // Assert
        assertFalse(result.isAvailable());
        verify(bookRepository).save(any(Book.class));
    }

    @Test
    void borrowBook_ShouldThrowException_WhenBookIsNotAvailable() {
        // Arrange
        Book unavailableBook = new Book(1L, "Test Book", "1234567890", "Test Author", false);
        when(bookRepository.findById(1L)).thenReturn(Optional.of(unavailableBook));

        // Act & Assert
        assertThrows(BookNotAvailableException.class, () -> bookService.borrowBook(1L));
        verify(bookRepository, never()).save(any(Book.class));
    }

    @Test
    void returnBook_ShouldSetAvailableToTrue_WhenBookIsBorrowed() {
        // Arrange
        Book borrowedBook = new Book(1L, "Test Book", "1234567890", "Test Author", false);
        Book returnedBook = new Book(1L, "Test Book", "1234567890", "Test Author", true);
        when(bookRepository.findById(1L)).thenReturn(Optional.of(borrowedBook));
        when(bookRepository.save(any(Book.class))).thenReturn(returnedBook);

        // Act
        Book result = bookService.returnBook(1L);

        // Assert
        assertTrue(result.isAvailable());
        verify(bookRepository).save(any(Book.class));
    }

    @Test
    void returnBook_ShouldThrowException_WhenBookIsAlreadyAvailable() {
        // Arrange
        when(bookRepository.findById(1L)).thenReturn(Optional.of(testBook)); // testBook is available

        // Act & Assert
        assertThrows(IllegalStateException.class, () -> bookService.returnBook(1L));
        verify(bookRepository, never()).save(any(Book.class));
    }

    @Test
    void deleteBook_ShouldDeleteBook_WhenBookExists() {
        // Arrange
        when(bookRepository.findById(1L)).thenReturn(Optional.of(testBook));
        doNothing().when(bookRepository).deleteById(1L);

        // Act
        bookService.deleteBook(1L);

        // Assert
        verify(bookRepository).deleteById(1L);
    }


}