package com.internship.week3.day3;

import java.util.Arrays;
import java.util.List;

public class Calculate {

    public int add(int a, int b) {
        return a + b;
    }

    public static void main(String[] args) {
        Calculate calculator = new Calculate();

        List<Integer> numbers = Arrays.asList(1, 2, 3, 4);

        int result = numbers.stream()
                .reduce(0, calculator::add);

        System.out.println(result);
    }
}
