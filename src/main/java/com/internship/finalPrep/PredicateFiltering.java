package com.internship.finalPrep;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;

public class PredicateFiltering {

    public static List<Integer> filterNumbers(
            List<Integer> numbers,
            Predicate<Integer> condition
            ) {
        List<Integer> result = new ArrayList<>();

        for (Integer num: numbers) {
            if (condition.test(num)) {
                result.add(num);
            }
        }
        return result;
    }

    public static void main(String[] args) {

        List<Integer> numbers = Arrays.asList(3, 8, 15, 22, 7, 40);

        List<Integer> evenNumbers = filterNumbers(numbers, num -> num % 2 == 0);
        List<Integer> greaterThan10 = filterNumbers(numbers, num -> num > 10);

        System.out.println(evenNumbers);
        System.out.println(greaterThan10);
    }
}
