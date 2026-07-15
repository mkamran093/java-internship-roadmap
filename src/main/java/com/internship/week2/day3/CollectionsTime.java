package com.internship.week2.day3;

import java.util.ArrayList;

public class CollectionsTime {

    public static void main(String args[]) {

        ArrayList<Integer> numbers = new ArrayList<>();

        long start = System.nanoTime();
        for (int i = 0; i < 10000; i++) {
            numbers.add(i);
        }
        long end = System.nanoTime();
        System.out.println("Adding 1000 items in arraylist: " + (end - start) + "ns");

        start = System.nanoTime();
        numbers.add(10001);
        end = System.nanoTime();
        System.out.println("Adding an item in arraylist at 10001th location: " + (end - start)+ "ns");


        start = System.nanoTime();
        numbers.get(9999);
        end = System.nanoTime();
        System.out.println("Getting 1000th item in arraylist: " + (end - start)+ "ns");

        start = System.nanoTime();
        numbers.remove(4999);
        end = System.nanoTime();
        System.out.println("Removing 1000th item in arraylist: " + (end - start) + "ns");

    }
}
