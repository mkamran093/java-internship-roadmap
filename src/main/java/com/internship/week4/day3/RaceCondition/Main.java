package com.internship.week4.day3.RaceCondition;

class Counter {

    volatile int count = 0;

    public void increment() {
        count++;
    }
}

public class Main {

    public static void main(String[] args)
            throws InterruptedException {

        long start = System.currentTimeMillis();
        Counter counter = new Counter();

        Thread t1 = new Thread(new IncrementTask(counter));
        Thread t2 = new Thread(new IncrementTask(counter));

        t1.start();
        t2.start();

        t1.join();
        t2.join();

        System.out.println(counter.count);
        long end = System.currentTimeMillis();
        System.out.println("Time: " + (end - start) + " ms");
    }

}
