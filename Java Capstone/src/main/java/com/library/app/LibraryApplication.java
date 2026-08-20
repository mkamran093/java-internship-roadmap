package com.library.app;

import com.library.model.Book;
import com.library.repository.BookRepository;
import com.library.service.BookService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;
import java.util.Scanner;

public class LibraryApplication {

    private static final Logger logger = LoggerFactory.getLogger(LibraryApplication.class);
    private static BookService bookService;
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        // Initialize database connection
        String dbUrl = "jdbc:mysql://localhost:3306/library";
        String username = "root";
        String password = "root";

        try {
            BookRepository repository = new BookRepository(dbUrl, username, password);
            bookService = new BookService(repository);
            logger.info("Library Management System started successfully");
        } catch (Exception e) {
            logger.error("Failed to initialize application: ", e);
            System.out.println("Failed to connect to database. Please check your connection settings.");
            return;
        }

        // Run the application
        runMenu();
    }

    private static void runMenu() {
        boolean running = true;

        while (running) {
            try {
                printMenu();
                String choice = scanner.nextLine().trim();

                switch (choice) {
                    case "1":
                        addBook();
                        break;
                    case "2":
                        listAllBooks();
                        break;
                    case "3":
                        searchBook();
                        break;
                    case "4":
                        borrowBook();
                        break;
                    case "5":
                        returnBook();
                        break;
                    case "6":
                        deleteBook();
                        break;
                    case "7":
                        running = false;
                        System.out.println("\nThank you for using the Library Management System. Goodbye!");
                        logger.info("Application closed by user");
                        break;
                    default:
                        System.out.println("Invalid option. Please enter a number between 1 and 7.");
                }
            } catch (Exception e) {
                System.out.println("An unexpected error occurred: " + e.getMessage());
                logger.error("Unexpected error in main menu: ", e);
            }
        }
        scanner.close();
    }

    private static void printMenu() {
        System.out.println("\n" + "========================================");
        System.out.println("     LIBRARY MANAGEMENT SYSTEM");
        System.out.println("========================================");
        System.out.println("1. Add Book");
        System.out.println("2. List All Books");
        System.out.println("3. Search Book by ID");
        System.out.println("4. Borrow Book");
        System.out.println("5. Return Book");
        System.out.println("6. Delete Book");
        System.out.println("7. Exit");
        System.out.println("----------------------------------------");
        System.out.print("Enter your choice: ");
    }

    // ============ MENU OPERATIONS ============

    private static void addBook() {
        System.out.println("\n--- Add New Book ---");
        try {
            System.out.print("Enter title: ");
            String title = scanner.nextLine().trim();
            if (title.isEmpty()) {
                System.out.println("Error: Title cannot be empty.");
                return;
            }

            System.out.print("Enter author: ");
            String author = scanner.nextLine().trim();
            if (author.isEmpty()) {
                System.out.println("Error: Author cannot be empty.");
                return;
            }

            System.out.print("Enter ISBN: ");
            String isbn = scanner.nextLine().trim();
            if (isbn.isEmpty()) {
                System.out.println("Error: ISBN cannot be empty.");
                return;
            }

            Book book = new Book(title, isbn, author, true);
            Book savedBook = bookService.addBook(book);

            System.out.println("✅ Book added successfully!");
            System.out.println("   ID: " + savedBook.getId());
            System.out.println("   Title: " + savedBook.getTitle());
            System.out.println("   Author: " + savedBook.getAuthor());
            System.out.println("   ISBN: " + savedBook.getIsbn());
            logger.info("Book added via console: {} (ID: {})", savedBook.getTitle(), savedBook.getId());

        } catch (Exception e) {
            System.out.println("❌ Error: " + e.getMessage());
            logger.error("Error adding book: ", e);
        }
    }

    private static void listAllBooks() {
        System.out.println("\n--- All Books ---");
        try {
            List<Book> books = bookService.getAllBooks();

            if (books.isEmpty()) {
                System.out.println("📚 No books found in the library.");
                return;
            }

            System.out.println("Total books: " + books.size());
            System.out.println("--------------------------------------------------------------------------------");
            System.out.printf("%-5s %-30s %-20s %-15s %-10s%n",
                    "ID", "Title", "Author", "ISBN", "Available");
            System.out.println("--------------------------------------------------------------------------------");

            for (Book book : books) {
                String availability = book.isAvailable() ? "✅ Yes" : "❌ No";
                System.out.printf("%-5d %-30s %-20s %-15s %-10s%n",
                        book.getId(),
                        truncate(book.getTitle(), 30),
                        truncate(book.getAuthor(), 20),
                        book.getIsbn(),
                        availability
                );
            }
            System.out.println("--------------------------------------------------------------------------------");
            logger.info("Listed {} books", books.size());

        } catch (Exception e) {
            System.out.println("❌ Error retrieving books: " + e.getMessage());
            logger.error("Error listing books: ", e);
        }
    }

    private static void searchBook() {
        System.out.println("\n--- Search Book ---");
        try {
            System.out.print("Enter book ID: ");
            String input = scanner.nextLine().trim();

            if (input.isEmpty()) {
                System.out.println("Error: ID cannot be empty.");
                return;
            }

            Long id = Long.parseLong(input);
            Book book = bookService.getBookById(id);

            System.out.println("\n📖 Book Found:");
            System.out.println("--------------------------------------------------");
            System.out.println("ID:          " + book.getId());
            System.out.println("Title:       " + book.getTitle());
            System.out.println("Author:      " + book.getAuthor());
            System.out.println("ISBN:        " + book.getIsbn());
            System.out.println("Available:   " + (book.isAvailable() ? "Yes" : "No"));
            System.out.println("--------------------------------------------------");
            logger.info("Searched for book ID: {}", id);

        } catch (NumberFormatException e) {
            System.out.println("❌ Error: Please enter a valid number for ID.");
        } catch (Exception e) {
            System.out.println("❌ Error: " + e.getMessage());
            logger.error("Error searching for book: ", e);
        }
    }

    private static void borrowBook() {
        System.out.println("\n--- Borrow Book ---");
        try {
            System.out.print("Enter book ID to borrow: ");
            String input = scanner.nextLine().trim();

            if (input.isEmpty()) {
                System.out.println("Error: ID cannot be empty.");
                return;
            }

            Long id = Long.parseLong(input);
            Book book = bookService.borrowBook(id);

            System.out.println("✅ Book borrowed successfully!");
            System.out.println("   Title: " + book.getTitle());
            System.out.println("   Status: Borrowed");
            logger.info("Book borrowed: {} (ID: {})", book.getTitle(), book.getId());

        } catch (NumberFormatException e) {
            System.out.println("❌ Error: Please enter a valid number for ID.");
        } catch (Exception e) {
            System.out.println("❌ Error: " + e.getMessage());
            logger.error("Error borrowing book: ", e);
        }
    }

    private static void returnBook() {
        System.out.println("\n--- Return Book ---");
        try {
            System.out.print("Enter book ID to return: ");
            String input = scanner.nextLine().trim();

            if (input.isEmpty()) {
                System.out.println("Error: ID cannot be empty.");
                return;
            }

            Long id = Long.parseLong(input);
            Book book = bookService.returnBook(id);

            System.out.println("✅ Book returned successfully!");
            System.out.println("   Title: " + book.getTitle());
            System.out.println("   Status: Available");
            logger.info("Book returned: {} (ID: {})", book.getTitle(), book.getId());

        } catch (NumberFormatException e) {
            System.out.println("❌ Error: Please enter a valid number for ID.");
        } catch (Exception e) {
            System.out.println("❌ Error: " + e.getMessage());
            logger.error("Error returning book: ", e);
        }
    }

    private static void deleteBook() {
        System.out.println("\n--- Delete Book ---");
        try {
            System.out.print("Enter book ID to delete: ");
            String input = scanner.nextLine().trim();

            if (input.isEmpty()) {
                System.out.println("Error: ID cannot be empty.");
                return;
            }

            Long id = Long.parseLong(input);

            // Confirm deletion
            System.out.print("Are you sure you want to delete this book? (y/n): ");
            String confirm = scanner.nextLine().trim().toLowerCase();

            if (!confirm.equals("y") && !confirm.equals("yes")) {
                System.out.println("Deletion cancelled.");
                return;
            }

            bookService.deleteBook(id);
            System.out.println("✅ Book deleted successfully!");
            logger.info("Book deleted with ID: {}", id);

        } catch (NumberFormatException e) {
            System.out.println("❌ Error: Please enter a valid number for ID.");
        } catch (Exception e) {
            System.out.println("❌ Error: " + e.getMessage());
            logger.error("Error deleting book: ", e);
        }
    }

    // ============ HELPER METHODS ============

    private static String truncate(String text, int maxLength) {
        if (text == null) return "";
        if (text.length() <= maxLength) return text;
        return text.substring(0, maxLength - 3) + "...";
    }
}