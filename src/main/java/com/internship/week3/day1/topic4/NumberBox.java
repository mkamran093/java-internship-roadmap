package com.internship.week3.day1.topic4;

public class NumberBox<T extends Number> {

    private T value;

    public NumberBox(T value) {
        this.value = value;
    }

    public T getValue() {
        return value;
    }

    public void setValue(T value) {
        this.value = value;
    }

    public static <T extends Number> void printSquare(T value) {
        System.out.println("Square of " + value + " is " + (value.doubleValue()* value.doubleValue()));
    }

    public static <T extends Comparable<T>> T larger(T a, T b) {
        int result = a.compareTo(b);
        if (result > 0) return a;
        return b;
    }

    public static void main(String args[]) {

        printSquare(5);
        printSquare(2.5);
        printSquare(4.5432190);
        // printSquare("Ali");

        System.out.println(larger("Ali", "Sara"));
        System.out.println(larger(9, 8));
        System.out.println(larger(9.242, 9.456));
    }
}
