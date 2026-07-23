package com.internship.week3.day3;

import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class MethodReference {

    public static void main(String args[]) {

        List<String> names = Arrays.asList("Alice", "Bob", "Charlie", "David");
//        names.forEach(System.out::println);

        names.stream()
                .map(String::toUpperCase)
                .forEach(System.out::println);

        List<String> numbers = Arrays.asList("10", "20", "30", "40");

        numbers.stream()
                .map(Integer::parseInt)
                .forEach(System.out::println);

        List<String> words = Arrays.asList("Java", "Method", "Reference");

        List<StringBuilder> builders = words.stream()
                .map(StringBuilder::new)
                .collect(Collectors.toList());

        builders.forEach(System.out::println);

        List<String> strings = Arrays.asList("Java", "", "Method", "", "Reference");

        strings.stream()
                .filter(Predicate.not(String::isEmpty))
                .forEach(System.out::println);
    }
}
