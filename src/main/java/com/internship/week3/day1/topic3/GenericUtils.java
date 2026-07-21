package com.internship.week3.day1.topic3;

import com.internship.week2.day5.LibraryManagement.Book;
import com.internship.week3.day1.topic2.Box;

public class GenericUtils {

    public static <T> void print(T value) {
        System.out.println(value);
    }

    public static <T> T identity(T value) {
        return value;
    }

    public static <T> void swap(Box<T> a, Box<T> b) {
        T value = a.getValue();
        a.setValue(b.getValue());
        b.setValue(value);
    }

    public static void main(String args[]) {

        print("String literal");
        print(45);
        print(4.59);
        print(new Book("23tj2", "lsgjow4j", 3));

        String s = identity("Ali");
        int i = identity(45);
        Book book = identity(new Book("jfi3j", "n3oivnow", 9));

        System.out.println(s);
        System.out.println(i);
        System.out.println(book);

        Box<String> a = new Box<>("Ali");
        Box<String> b = new Box<>("Sara");
        System.out.println("Before Swapping");
        System.out.println("a: " + a.getValue() + ", b: " + b.getValue());
        swap(a, b);
        System.out.println("After Swapping");
        System.out.println("a: " + a.getValue() + ", b: " + b.getValue());


    }
}
