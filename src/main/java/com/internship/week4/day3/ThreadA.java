package com.internship.week4.day3;

public class ThreadA extends Thread {

    SharedData sharedData;

    public ThreadA(SharedData sharedData) {
        this.sharedData = sharedData;
    }
    @Override
    public void run() {
        for (int i = 1; i <= 5; i++) {
            System.out.println("Thread A : " + i);
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
