package com.internship.week4.day3;

public class Main {

    public static void main(String args[]) {

        System.out.println("Main Thread started");

        ThreadA threadA = new ThreadA();
        Thread threadB = new Thread(new ThreadB());

        try {
            threadA.start();
            threadB.start();

            threadA.join();
            threadB.join();
        } catch (InterruptedException e) {
            System.out.println(e.getMessage());
        }

        System.out.println("Main thread finished");
    }
}
