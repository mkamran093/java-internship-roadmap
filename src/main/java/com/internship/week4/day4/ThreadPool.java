package com.internship.week4.day4;

import com.internship.week4.day3.ThreadA;

import java.sql.Timestamp;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class ThreadPool {

    public static void main(String[] args) {

        ExecutorService executor = Executors.newFixedThreadPool(3);

        for (int i = 1; i <= 5; i++) {
            int finalI = i;
            executor.execute(() -> {
                System.out.println("Task " + finalI + " running on " + Thread.currentThread().getName() + " --- " + new Timestamp(System.currentTimeMillis()));
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
                System.out.println("Task " + finalI + " Finished");
            });
        }

        executor.shutdown();

        try {
            if (!executor.awaitTermination(5, TimeUnit.SECONDS)) {
                System.out.println("Some programs didn't finsih on time");
            }
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        System.out.println("All tasks completed");

    }
}
