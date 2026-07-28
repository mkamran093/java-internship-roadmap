package com.internship.week4.day3.RaceCondition;

class Counter {

    int count = 0;

    public void increment() {
        count++;
    }

}

public class Main {

    public static void main(String[] args)
            throws InterruptedException {

        Counter counter = new Counter();

        Thread t1 = new Thread(new IncrementTask(counter));
        Thread t2 = new Thread(new IncrementTask(counter));

        t1.start();
        t2.start();

        t1.join();
        t2.join();

        System.out.println(counter.count);

    }

}
