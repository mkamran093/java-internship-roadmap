package com.internship.week2.day5;

import java.io.FileReader;

public class ErrorClass {

    public static void divide(int a, int b) {
        System.out.println("Inside divide");
        System.out.println(a/b);
    }

    public static void B() {
        System.out.println("Inside B");
        divide(10, 0);
    }

    public static void A() {
        System.out.println("Inside A");
        try {
            B();
        } catch (ArithmeticException e) {
            System.out.println("Recovered in A");
        }
    }

    public static void main(String args[]) {

//        System.out.println(10/0);

//        String s = null;
//        System.out.println(s.length());
//
//        int[] arr = {1, 2, 3, 4, 5};
//        System.out.println(arr[10]);

//        divide(10, 0);

//        FileReader fileReader = new FileReader("abc.txt");

        A();
    }
}
