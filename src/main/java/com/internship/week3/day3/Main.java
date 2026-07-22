package com.internship.week3.day3;

public class Main {

    public static void main(String args[]) {


        Greeting hello = name -> System.out.println("Hello, " + name);
        hello.greet("Kamran");

        Square sqr = num -> num * num;
        System.out.println(sqr.square(3));
    }
}
