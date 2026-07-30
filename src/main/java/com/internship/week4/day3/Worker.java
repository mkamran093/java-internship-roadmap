package com.internship.week4.day3;

public class Worker extends Thread {

    private SharedData data;

    public Worker(SharedData data) {
        this.data = data;
    }

    @Override
    public void run() {
        while(data.running) {
            System.out.println("Working");
        }
        System.out.println("Worker Stopped");
    }

    public static void main(String[] args) {

    }
}
