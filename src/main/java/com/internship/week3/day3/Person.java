package com.internship.week3.day3;

import java.util.Arrays;
import java.util.List;

public class Person {
    private String name;

    Person(String name) {
        this.name = name;
    }

    String getName() {
        return name;
    }

    public static void main(String[] args) {
        List<Person> people = Arrays.asList(
                new Person("Alice"),
                new Person("Bob"),
                new Person("Charlie")
        );

        people.stream()
                .map(Person::getName)
                .forEach(System.out::println);

        List<String> words = Arrays.asList("Java", "is", "awesome");

        words.stream()
                .reduce(String::concat)
                .ifPresent(System.out::println);
    }
}
