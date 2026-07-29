package com.internship.week4.day3;

class SharedData {

    volatile boolean running = true;

}

public class Main {

    public static void main(String args[]) throws InterruptedException {

        System.out.println("Main Thread started");

        SharedData sharedData = new SharedData();
        ThreadA threadA = new ThreadA(sharedData);
        Thread threadB = new Thread(new ThreadB(sharedData));

        try {
            threadA.start();
            threadB.start();

            threadA.join();
            threadB.join();
        } catch (InterruptedException e) {
            System.out.println(e.getMessage());
        }

        System.out.println("Main thread finished");

        Worker worker = new Worker(sharedData);
        worker.start();
        Thread.sleep(3000);
        sharedData.running = false;
        System.out.println("Main changed run to false");

    }
}
