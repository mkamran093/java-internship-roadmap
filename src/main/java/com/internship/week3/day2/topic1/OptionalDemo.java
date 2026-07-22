package com.internship.week3.day2.topic1;

import java.util.Optional;

public class OptionalDemo {

    public static Optional<String> getName() {
        return Optional.of("Ram");
    }

    public static void main(String args[]) {
        Optional<String> optional = getName();
        Optional<String> optional1 = optional.map(x -> x.toUpperCase());
        optional.ifPresent(System.out::println);
        optional1.ifPresent(System.out::println);

    }
}
