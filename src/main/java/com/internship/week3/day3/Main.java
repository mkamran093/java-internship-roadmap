package com.internship.week3.day3;

import java.util.function.Predicate;

public class Main {

    static void execute(int a, int b, Calculator calculator) {
        System.out.println(calculator.calculate(a, b));
    }

    public static void main(String args[]) {


        Greeting hello = name -> System.out.println("Hello, " + name);
        hello.greet("Kamran");

        Square sqr = num -> num * num;
        System.out.println(sqr.square(3));

        Calculator add = (a, b) -> a + b;
        Calculator subtract = (a, b) -> a - b;
        Calculator multiply = (a, b) -> a * b;
        Calculator divide = (a, b) -> {
            if (b == 0) {
                throw new IllegalArgumentException("Zero can't be a denominator");
            }
            return a/b;
        };

//        System.out.println(add.calculate(10, 5));
//        System.out.println(subtract.calculate(10, 5));
//        System.out.println(multiply.calculate(10, 5));
//        System.out.println(divide.calculate(10, 5));


        execute(10, 5, add);
        execute(10, 5, subtract);
        execute(10, 5, multiply);
        execute(10, 2, divide);
        execute(10, 5, (a, b) -> a + b);

        System.out.println("\nIs even");
        Predicate<Integer> isEven = x -> x % 2 == 0;
        System.out.println(isEven.test(4));
        System.out.println(isEven.test(5));
        System.out.println(isEven.test(7));
        System.out.println(isEven.test(6));

        System.out.println("\nIs Positive");
        Predicate<Integer> isPositive = x -> x > 0;
        System.out.println(isPositive.test(4));
        System.out.println(isPositive.test(-7));
        System.out.println(isPositive.test(8));
        System.out.println(isPositive.test(-42));

        System.out.println("\nPositive Even");
        Predicate<Integer> positiveEven = x -> isEven.test(x) && isPositive.test(x);
        System.out.println(positiveEven.test(6));
        System.out.println(positiveEven.test(-6));
        System.out.println(positiveEven.test(-4));
        System.out.println(positiveEven.test(3));

        System.out.println("\n Positive even with combination");
        Predicate<Integer> posEven = isEven.and(isPositive);
        System.out.println(posEven.test(6));
        System.out.println(posEven.test(-6));
        System.out.println(posEven.test(-4));
        System.out.println(posEven.test(3));

    }
}
