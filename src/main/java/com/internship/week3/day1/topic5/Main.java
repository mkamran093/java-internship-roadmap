package com.internship.week3.day1.topic5;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Main {

    public static double sum(List<? extends Number> numbers) {
//        numbers.add(10);
        double total = 0d;
        for(Number x: numbers) {
            total += x.doubleValue();
        }
        return total;
    }

    public static void addDefault(List<? super Integer> list) {
        list.add(100);
    }

    public static void main(String args[]) {

        List<Integer> integers = List.of(1, 2, 3, 4, 5);
        System.out.println(sum(integers));

        List<Number> numbers = List.of(1, 2, 3, 4);
        List<Object> objects = List.of(1, 3, "ali" , 3.5);
        addDefault(numbers);
        addDefault(objects);

    }
}
