package com.internship.week2.day3;

import java.util.ArrayList;

public class ArrayListExperiment {

    public static void main(String args[]) {

        ArrayList<Integer> numbers = new ArrayList<>();
        numbers.add(1);
        numbers.add(2);
        numbers.add(3);
        numbers.add(4);
        numbers.add(5);
        System.out.println("After adding 5 elements: " + numbers.size());
        numbers.add(6);
        numbers.add(7);
        numbers.add(8);
        numbers.add(9);
        numbers.add(10);
        System.out.println("After adding 10 elements: " + numbers.size());
        numbers.add(11);
        numbers.add(12);
        numbers.add(13);
        numbers.add(14);
        numbers.add(15);
        System.out.println("After adding 15 elements: " + numbers.size());

        numbers.remove(0);
        for (Integer num: numbers) {
            System.out.print(num + ", ");
        }
        System.out.println();
        numbers.remove(6);
        for (Integer num: numbers) {
            System.out.print(num + ", ");
        }
        System.out.println();
        numbers.remove(12);
        for (Integer num: numbers) {
            System.out.print(num + ", ");
        }

        // Why is get(10) fast?
        // because it directly calculates the lcoation of the index and return the value at that index, nothing else

        // Why is remove(0) slower than get(0)?
        // because removing at first index will make the rest of the array to shift left 1 step. thats n operations.

        // Does ArrayList physically shrink every time you remove one element?
        // we will never know because java only share the size of arraylist not capacity.


    }

}
