package com.internship.week3.day4;

import java.util.*;
import java.util.stream.Collectors;

public class Main {

    public static void main(String args[]) {
        List<Integer> prices = Arrays.asList(120, 80, 250, 90, 300, 150);

        prices.stream()
                .filter(x -> x >= 150)
                .collect(Collectors.toList())
                .forEach(System.out::println);

        List<String> titles = Arrays.asList(
                "clean code",
                "effective java",
                "spring in action",
                "java concurrency"
        );

        List<String> upperTitles = titles.stream().map(String::toUpperCase).toList();
        System.out.println(upperTitles);

        List<Book> books = Arrays.asList(
                new Book("Clean Code", 2008),
                new Book("Effective Java", 2018),
                new Book("Java Concurrency", 2013),
                new Book("Spring Boot", 2020)
        );

        List<Book> byYear = books.stream()
                .sorted(Comparator.comparing(Book::getYear).reversed())
                .toList();
        System.out.println(byYear);

        List<Integer> ratings = Arrays.asList(
                5, 4, 5, 3, 2, 4, 5, 1, 3, 5
        );

        long count = ratings.stream()
                .distinct()
                .skip(1)
                .limit(3)
                .count();

        System.out.println(count);

        List<String> authors = Arrays.asList(
                "Robert Martin",
                "Joshua Bloch",
                "Robert Martin",
                "Martin Fowler",
                "Joshua Bloch"
        );

        System.out.println(authors);
        Set<String> distinctAuthors = authors.stream()
                .collect(Collectors.toSet());
        System.out.println(distinctAuthors);
        Map<String, Integer> nameLength = authors.stream()
                .collect(Collectors.toMap(
                        author -> author,
                        String::length,
                        (existing, replacement) -> existing
                ));

        System.out.println(nameLength);

        List<BBook> booksAuthors = Arrays.asList(
                new BBook("Clean Code", "Robert Martin"),
                new BBook("Clean Architecture", "Robert Martin"),
                new BBook("Effective Java", "Joshua Bloch"),
                new BBook("Java Concurrency", "Brian Goetz")
        );

        Map<String, List<BBook>> booksByAuthors = booksAuthors.stream()
                .collect(Collectors.groupingBy(BBook::getAuthor));

        System.out.println(booksByAuthors);

        List<BBook> books3 = Arrays.asList(
                new BBook("Clean Code", "Robert Martin"),
                new BBook("Clean Architecture", "Robert Martin"),
                new BBook("Effective Java", "Joshua Bloch"),
                new BBook("Java Concurrency", "Brian Goetz"),
                new BBook("The Pragmatic Programmer", "Robert Martin")
        );

        Map<String, Long> noOfBooks = books3.stream()
                .collect(Collectors.groupingBy(BBook::getAuthor, Collectors.counting()));
        System.out.println(noOfBooks);

        List<Integer> salaries = Arrays.asList(
                50000, 70000, 60000, 90000
        );
        int total = salaries.stream()
                .reduce(0, (a, b) -> a + b);

        System.out.println(total);
    }
}
