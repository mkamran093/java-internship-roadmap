package com.internship.finalPrep;

import java.util.Arrays;
import java.util.List;

public class GenericMethod {

    public static <T extends Comparable<T>> T findMax(List<T> list) {
        if(list == null || list.isEmpty()) {
            throw  new IllegalArgumentException(
                    "List cannot be empty"
            );
        }
        T max = list.get(0);
        for (T item: list) {
            if (item.compareTo(max) > 0) {
                max = item;
            }
        }

        return max;
    }

    public static void main(String[] args) {
        List<Integer> numbers = Arrays.asList(4, 9, 2, 7);
        List<String> fruits = Arrays.asList( "pear", "apple", "kiwi" );
        System.out.println( "Max number: " + findMax(numbers) );
        System.out.println( "Max string: " + findMax(fruits) );
    }
}
