package com.library.repository;

import com.library.model.Book;
import java.sql.*;
import java.util.*;

public class BookRepository {

    private final String dbUrl;
    private final String username;
    private final String password;

    public BookRepository(String dbUrl, String username, String password) {
        this.dbUrl = dbUrl;
        this.username = username;
        this.password = password;
    }

    private Connection getConnection() throws SQLException {
        return DriverManager.getConnection(dbUrl, username, password);
    }

    public Book save(Book book) {
        if (book.getId() == null) {
            return insertBook(book);
        } else {
            updateBook(book);
            return book;
        }
    }

    private Book insertBook(Book book) {
        String sql = "INSERT INTO books (title, author, isbn, isAvailable) VALUES (?, ?, ?, ?)";
        try(Connection connection = getConnection();
        PreparedStatement ps = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {
            ps.setString(1, book.getTitle());
            ps.setString(2, book.getAuthor());
            ps.setString(3, book.getIsbn());
            ps.setBoolean(4, book.isAvailable());
            ps.executeUpdate();
            try(ResultSet rs = ps.getGeneratedKeys()) {
                if (rs.next()) {
                    book.setId(rs.getLong(1));
                } else {
                    throw new SQLException("Failed to get generated ID");
                }
            }
            return book;
        } catch (SQLException e) {
            throw new RuntimeException("Failed to insert book: " + e.getMessage(), e);
        }
    }

    private void updateBook(Book book) {
        String sql = "UPDATE books SET title = ?, author = ?, isbn = ?, isAvailable = ? WHERE id = ?";
        try(Connection connection = getConnection();
        PreparedStatement ps = connection.prepareStatement(sql)) {
            ps.setString(1, book.getTitle());
            ps.setString(2, book.getAuthor());
            ps.setString(3, book.getIsbn());
            ps.setBoolean(4, book.isAvailable());
            ps.setLong(5, book.getId());
            ps.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public Optional<Book> findById(Long id) {
        String sql = "SELECT * FROM books WHERE id = ?";
        try(Connection connection = getConnection();
        PreparedStatement ps = connection.prepareStatement(sql)) {
            ps.setLong(1, id);
            try (ResultSet rs = ps.executeQuery()) {
                if (rs.next()) {
                    Book book = new Book(
                            rs.getLong("id"),
                            rs.getString("title"),
                            rs.getString("isbn"),
                            rs.getString("author"),
                            rs.getBoolean("isAvailable")
                    );
                    return Optional.of(book);
                }
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return Optional.empty(); // Remove this
    }

    public Optional<Book> findByIsbn(String isbn) {
        String sql = "SELECT * FROM books WHERE isbn = ?";
        try(Connection connection = getConnection();
            PreparedStatement ps = connection.prepareStatement(sql)) {
            ps.setString(1, isbn);
            try (ResultSet rs = ps.executeQuery()) {
                if (rs.next()) {
                    Book book = new Book(
                            rs.getLong("id"),
                            rs.getString("title"),
                            rs.getString("isbn"),
                            rs.getString("author"),
                            rs.getBoolean("isAvailable")
                    );
                    return Optional.of(book);
                }
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return Optional.empty(); // Remove this
    }

    public ArrayList<Book> findAll() {
        String sql = "SELECT * FROM books";
        ArrayList<Book> books = new ArrayList<>();
        try(Connection connection = getConnection();
            PreparedStatement ps = connection.prepareStatement(sql)) {
            try (ResultSet rs = ps.executeQuery()) {
                while (rs.next()) {
                    Book book = new Book(
                            rs.getLong("id"),
                            rs.getString("title"),
                            rs.getString("isbn"),
                            rs.getString("author"),
                            rs.getBoolean("isAvailable")
                    );
                    books.add(book);
                }
            }
            return books;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public void deleteById(Long id) {
        String sql = "DELETE FROM books WHERE id = ?";
        try(Connection connection = getConnection();
            PreparedStatement ps = connection.prepareStatement(sql)) {
            ps.setInt(1, Math.toIntExact(id));
            ps.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

}