package com.internship.week3.day4;

class BBook {
    String title;
    String author;

    BBook(String title, String author) {
        this.title = title;
        this.author = author;
    }

    public String getAuthor() {
        return author;
    }

    public String toString() {
        return title;
    }
}