# 📚 Library Management System

A comprehensive Java-based Library Management System that demonstrates CRUD operations, JDBC persistence, and layered architecture. Built as a capstone project to showcase core Java development skills.

## 🎯 Project Overview

This application provides a console-based interface for managing library books. It allows users to:
- Add new books to the library
- View all books in the collection
- Search for books by ID
- Borrow and return books
- Delete books from the system

The project follows a clean layered architecture with proper separation of concerns:
- **Model Layer**: Business objects (Book)
- **Repository Layer**: Data access using JDBC
- **Service Layer**: Business logic and validation
- **Presentation Layer**: Console-based user interface

## 🛠️ Technology Stack

- **Java 8** - Core programming language
- **MySQL** - Relational database
- **Maven** - Build automation and dependency management
- **JUnit 5** - Unit testing framework
- **Mockito** - Mocking framework for unit tests
- **SLF4J with Logback** - Logging framework

## 📋 Prerequisites

Before you begin, ensure you have the following installed:

- **Java 8** or higher
  ```bash
  java -version
MySQL 5.7 or higher

bash
mysql --version
Maven 3.6 or higher

bash
mvn -version
Git (optional, for cloning)

🔧 Setup Instructions
1. Clone the Repository
   bash
   git clone https://github.com/yourusername/library-management-system.git
   cd library-management-system
2. Database Setup
   Create the Database
   sql
   CREATE DATABASE librarydb;
   USE librarydb;
   Create the Books Table
   sql
   CREATE TABLE books (
   id BIGINT AUTO_INCREMENT PRIMARY KEY,
   title VARCHAR(255) NOT NULL,
   author VARCHAR(255) NOT NULL,
   isbn VARCHAR(20) UNIQUE NOT NULL,
   isAvailable BOOLEAN DEFAULT TRUE
   );
   Verify Table Creation
   sql
   DESCRIBE books;
   Expected output:

text
+-------------+--------------+------+-----+---------+----------------+
| Field       | Type         | Null | Key | Default | Extra          |
+-------------+--------------+------+-----+---------+----------------+
| id          | bigint       | NO   | PRI | NULL    | auto_increment |
| title       | varchar(255) | NO   |     | NULL    |                |
| author      | varchar(255) | NO   |     | NULL    |                |
| isbn        | varchar(20)  | NO   | UNI | NULL    |                |
| isAvailable | tinyint(1)   | YES  |     | 1       |                |
+-------------+--------------+------+-----+---------+----------------+
3. Configure Database Connection
   Update the database configuration in LibraryApplication.java:

java
// File: src/main/java/com/library/app/LibraryApplication.java
String dbUrl = "jdbc:mysql://localhost:3306/librarydb";
String username = "your_username";  // Replace with your MySQL username
String password = "your_password";  // Replace with your MySQL password
Important: Never commit real credentials to version control!

4. Build the Project
   bash
   mvn clean compile
5. Run the Application
   bash
   mvn exec:java -Dexec.mainClass="com.library.app.LibraryApplication"
   Or run the JAR:

bash
mvn clean package
java -jar target/library-management-system-1.0-SNAPSHOT.jar
🧪 How to Test
Run All Tests
bash
mvn test
Run Specific Test Class
bash
mvn test -Dtest=BookServiceTest
Test Coverage
The test suite covers:

✅ Service layer business logic

✅ Success scenarios

✅ Failure scenarios (exceptions)

✅ Edge cases

✅ Mocked repository interactions

Sample Test Output
text
[INFO] Running com.library.service.BookServiceTest
[INFO] Tests run: 12, Failures: 0, Errors: 0, Skipped: 0, Time elapsed: 1.234 s
[INFO]
[INFO] Results:
[INFO]
[INFO] Tests run: 12, Failures: 0, Errors: 0, Skipped: 0
[INFO]
[INFO] BUILD SUCCESS
✨ Features
Core Features
Feature	Description	Status
Add Book	Add a new book to the library with title, author, and ISBN	✅ Complete
List Books	View all books in the library with availability status	✅ Complete
Search Book	Find a book by its unique ID	✅ Complete
Borrow Book	Borrow an available book	✅ Complete
Return Book	Return a borrowed book	✅ Complete
Delete Book	Remove a book from the library (with confirmation)	✅ Complete
Technical Features
Feature	Description
JDBC Persistence	Direct JDBC implementation with PreparedStatement
Connection Management	Proper connection handling with try-with-resources
Error Handling	Custom exceptions with meaningful messages
Logging	SLF4J logging at service and error points
Unit Testing	JUnit tests for service logic
Mocking	Mockito for repository mocking in tests
Layered Architecture	Clear separation of concerns
Future Enhancements
□ Search by ISBN and author
□ Member management system
□ Borrowing history tracking
□ Due date and fine calculation
□ Web interface (Spring Boot)
□ REST API endpoints
□ Book categories/genres
□ Bulk import/export
📝 Sample Input and Output
Session 1: Adding Books
text
========================================
LIBRARY MANAGEMENT SYSTEM
========================================
1. Add Book
2. List All Books
3. Search Book by ID
4. Borrow Book
5. Return Book
6. Delete Book
7. Exit
----------------------------------------
Enter your choice: 1

--- Add New Book ---
Enter title: The Great Gatsby
Enter author: F. Scott Fitzgerald
Enter ISBN: 9780743273565
Book added successfully!
ID: 1
Title: The Great Gatsby
Author: F. Scott Fitzgerald
ISBN: 9780743273565

========================================
LIBRARY MANAGEMENT SYSTEM
========================================
1. Add Book
2. List All Books
3. Search Book by ID
4. Borrow Book
5. Return Book
6. Delete Book
7. Exit
----------------------------------------
Enter your choice: 1

--- Add New Book ---
Enter title: 1984
Enter author: George Orwell
Enter ISBN: 9780451524935
Book added successfully!
ID: 2
Title: 1984
Author: George Orwell
ISBN: 9780451524935

========================================
LIBRARY MANAGEMENT SYSTEM
========================================
1. Add Book
2. List All Books
3. Search Book by ID
4. Borrow Book
5. Return Book
6. Delete Book
7. Exit
----------------------------------------
Enter your choice: 1

--- Add New Book ---
Enter title: To Kill a Mockingbird
Enter author: Harper Lee
Enter ISBN: 9780061120084
Book added successfully!
ID: 3
Title: To Kill a Mockingbird
Author: Harper Lee
ISBN: 9780061120084
Session 2: Listing All Books
text
========================================
LIBRARY MANAGEMENT SYSTEM
========================================
1. Add Book
2. List All Books
3. Search Book by ID
4. Borrow Book
5. Return Book
6. Delete Book
7. Exit
----------------------------------------
Enter your choice: 2

--- All Books ---
Total books: 3
--------------------------------------------------------------------------------
ID    Title                          Author               ISBN            Available
--------------------------------------------------------------------------------
1     The Great Gatsby               F. Scott Fitzger...  9780743273565   Yes
2     1984                           George Orwell        9780451524935   Yes
3     To Kill a Mockingbird          Harper Lee           9780061120084   Yes
--------------------------------------------------------------------------------
Session 3: Borrowing a Book
text
========================================
LIBRARY MANAGEMENT SYSTEM
========================================
1. Add Book
2. List All Books
3. Search Book by ID
4. Borrow Book
5. Return Book
6. Delete Book
7. Exit
----------------------------------------
Enter your choice: 4

--- Borrow Book ---
Enter book ID to borrow: 1
Book borrowed successfully!
Title: The Great Gatsby
Status: Borrowed
Session 4: Listing After Borrowing
text
========================================
LIBRARY MANAGEMENT SYSTEM
========================================
1. Add Book
2. List All Books
3. Search Book by ID
4. Borrow Book
5. Return Book
6. Delete Book
7. Exit
----------------------------------------
Enter your choice: 2

--- All Books ---
Total books: 3
--------------------------------------------------------------------------------
ID    Title                          Author               ISBN            Available
--------------------------------------------------------------------------------
1     The Great Gatsby               F. Scott Fitzger...  9780743273565   No
2     1984                           George Orwell        9780451524935   Yes
3     To Kill a Mockingbird          Harper Lee           9780061120084   Yes
--------------------------------------------------------------------------------
Session 5: Returning a Book
text
========================================
LIBRARY MANAGEMENT SYSTEM
========================================
1. Add Book
2. List All Books
3. Search Book by ID
4. Borrow Book
5. Return Book
6. Delete Book
7. Exit
----------------------------------------
Enter your choice: 5

--- Return Book ---
Enter book ID to return: 1
Book returned successfully!
Title: The Great Gatsby
Status: Available
Session 6: Searching for a Book
text
========================================
LIBRARY MANAGEMENT SYSTEM
========================================
1. Add Book
2. List All Books
3. Search Book by ID
4. Borrow Book
5. Return Book
6. Delete Book
7. Exit
----------------------------------------
Enter your choice: 3

--- Search Book ---
Enter book ID: 1

Book Found:
--------------------------------------------------
ID:          1
Title:       The Great Gatsby
Author:      F. Scott Fitzgerald
ISBN:        9780743273565
Available:   Yes
--------------------------------------------------
Session 7: Error Handling Examples
Duplicate ISBN Error
text
--- Add New Book ---
Enter title: The Great Gatsby
Enter author: F. Scott Fitzgerald
Enter ISBN: 9780743273565
Error: Book with ISBN 9780743273565 already exists
Book Not Found Error
text
--- Search Book ---
Enter book ID: 999
Error: Book with ID 999 not found
Book Not Available Error
text
--- Borrow Book ---
Enter book ID to borrow: 1
Error: Book with ID 1 is currently borrowed
📁 Project Structure
text
library-management-system/
├── pom.xml                          # Maven build configuration
├── README.md                        # Project documentation
├── logs/                            # Application logs
│   └── library.log                 # Log file
├── src/
│   ├── main/
│   │   ├── java/
│   │   │   └── com/
│   │   │       └── library/
│   │   │           ├── app/
│   │   │           │   └── LibraryApplication.java
│   │   │           ├── model/
│   │   │           │   └── Book.java
│   │   │           ├── dto/
│   │   │           │   └── BookDTO.java
│   │   │           ├── service/
│   │   │           │   └── BookService.java
│   │   │           ├── repository/
│   │   │           │   └── BookRepository.java
│   │   │           └── exception/
│   │   │               ├── BookNotFoundException.java
│   │   │               ├── DuplicateBookException.java
│   │   │               └── BookNotAvailableException.java
│   │   └── resources/
│   │       └── logback.xml         # Logging configuration
│   └── test/
│       └── java/
│           └── com/
│               └── library/
│                   └── service/
│                       └── BookServiceTest.java
🏗️ Architecture & Design Decisions
Layered Architecture
The application follows a clean layered architecture:

Presentation Layer (app package)

Console-based user interface

Handles user input and output

No business logic

Service Layer (service package)

Business logic and validation

Transaction management

Exception handling

Logging

Repository Layer (repository package)

Data access operations

JDBC implementation

SQL queries with PreparedStatement

Connection management

Model Layer (model package)

Domain objects

No business logic

Data carriers

Key Design Decisions
1. JDBC over ORM
   Decision: Used raw JDBC instead of JPA/Hibernate

Rationale:

Demonstrates understanding of database connectivity

More control over SQL queries

Better performance for simple CRUD operations

Shows knowledge of SQL injection prevention with PreparedStatement

2. Custom Exceptions
   Decision: Created custom runtime exceptions

Rationale:

Better error handling with meaningful messages

Clean separation of exception types

Easier debugging and logging

Shows understanding of exception hierarchy

3. Console-Based UI
   Decision: Console interface instead of GUI or web

Rationale:

Focuses on business logic, not UI complexity

Easy to test and demonstrate

Clear input/output examples

Quick development and iteration

4. DTO Pattern
   Decision: Used DTOs for data transfer

Rationale:

Separation of concerns

Future API extension readiness

Shows understanding of enterprise patterns

🐛 Bug Fix Example (Interview Preparation)
Bug: NullPointerException when Adding Book with Null Fields
Issue: The application would throw a NullPointerException if a user tried to add a book with an empty title or author.

Before Fix:

java
public Book addBook(Book book) {
// No validation - could cause NPE
return bookRepository.save(book);
}
After Fix:

java
public Book addBook(Book book) {
// Input validation
if (book.getTitle() == null || book.getTitle().trim().isEmpty()) {
throw new IllegalArgumentException("Title cannot be empty");
}
if (book.getAuthor() == null || book.getAuthor().trim().isEmpty()) {
throw new IllegalArgumentException("Author cannot be empty");
}
if (book.getIsbn() == null || book.getIsbn().trim().isEmpty()) {
throw new IllegalArgumentException("ISBN cannot be empty");
}

    // Check for duplicate ISBN
    if (bookRepository.findByIsbn(book.getIsbn()).isPresent()) {
        throw new DuplicateBookException("Book with ISBN " + book.getIsbn() + " already exists");
    }
    
    return bookRepository.save(book);
}
Lesson Learned:

Always validate input at the service layer

User-friendly error messages are critical

Check for null and empty strings before processing

🚀 Troubleshooting
Common Issues and Solutions
1. MySQL Connection Error
   text
   java.sql.SQLException: Access denied for user 'root'@'localhost'
   Solution:

Check username and password in LibraryApplication.java

Verify MySQL is running: sudo service mysql status

Create a dedicated database user with proper permissions

2. Table Not Found
   text
   java.sql.SQLException: Table 'librarydb.books' doesn't exist
   Solution:

Run the CREATE TABLE statement in MySQL

Verify database name is correct

Check that the table was created in the correct database

3. Duplicate ISBN Error
   text
   DuplicateBookException: Book with ISBN 9780743273565 already exists
   Solution:

This is expected behavior - it's a validation check

Use a different ISBN for new books

If updating, ensure the ISBN doesn't conflict

4. Maven Build Errors
   text
   [ERROR] Failed to execute goal ...
   Solution:

Check pom.xml for correct dependencies

Update Maven repositories: mvn clean install -U

Verify Java version compatibility

📊 Logging
Logs are written to:

Console: Immediate feedback for debugging

File: logs/library.log for historical analysis

Log Levels
INFO: Application startup, major operations (add, borrow, return)

DEBUG: Detailed operation information (finding books by ID)

WARN: Business rule violations (book not available)

ERROR: Exceptions and unexpected errors

Sample Log Output
text
2024-01-15 10:30:15 INFO  LibraryApplication - Library Management System started successfully
2024-01-15 10:30:22 INFO  BookService - Adding new book: The Great Gatsby
2024-01-15 10:30:22 INFO  BookService - Book added successfully with ID: 1
2024-01-15 10:30:30 INFO  BookService - Borrowing book with ID: 1
2024-01-15 10:30:30 INFO  BookService - Book borrowed successfully: The Great Gatsby
2024-01-15 10:30:35 INFO  BookService - Returning book with ID: 1
2024-01-15 10:30:35 INFO  BookService - Book returned successfully: The Great Gatsby
2024-01-15 10:30:40 INFO  LibraryApplication - Application closed by user
🤝 Contributing
This is a capstone project for educational purposes. Suggestions and improvements are welcome!

Fork the repository

Create a feature branch

Make your changes

Submit a pull request