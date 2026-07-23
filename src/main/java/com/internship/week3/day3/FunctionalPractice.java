package com.internship.week3.day3;

import java.util.function.Function;

public class FunctionalPractice {

    public static void main(String[] args) {

        Function<String, Integer> length = str -> str.length();
        System.out.println(length.apply("Kamran"));
        System.out.println(length.apply("Ali"));
        System.out.println(length.apply("Sara"));
        System.out.println(length.apply("Muhammad"));

        Function<String, String> toUpper = str -> str.toUpperCase();
        System.out.println(toUpper.apply("Kami"));
        System.out.println(toUpper.apply("Ali"));
        System.out.println(toUpper.apply("Sara"));

        Function<String, Integer> composition = toUpper.andThen(length); // confused
        System.out.println(composition.apply("Kamran"));

        Function<String, String> trim = str -> str.trim();
        Function<String, Integer> bonus = trim.andThen(composition);
        System.out.println(bonus.apply(" Kamran  "));

        Function<String, Integer> bonus2 = composition.compose(trim);
        System.out.println(bonus2.apply("   slkgj   "));

    }
}
