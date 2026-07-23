package com.internship.week3.day3;

import java.util.function.Consumer;

public class ConsumerPractice {

    public static void main(String[] args) {

        Consumer<String> printer = str -> System.out.println("Hello, " + str);
        printer.accept("Kamran");
        printer.accept("Ali");

        Consumer<String> upperPrinter = str -> System.out.println(str.toUpperCase());
        upperPrinter.accept("Kamran");
        upperPrinter.accept("Ali");

        Consumer<String> combined = upperPrinter.andThen(printer);
        combined.accept("Kamran and Ali");

        Consumer<String> combined2 = printer.andThen(upperPrinter);
        combined2.accept("Kamran and Ali");


    }
}
