package com.internship.week3.day4;

class Book {
    String title;
    int year;

    Book(String title, int year) {
        this.title = title;
        this.year = year;
    }

    public String getTitle() {
        return title;
    }

    public int getYear() {
        return year;
    }

    @Override
    public String toString() {
        return title + " - " + year;
    }
}
