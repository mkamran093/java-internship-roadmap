package com.internship.week4.day4;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class Blocking {

    public static void main(String[] args) {

        ExecutorService executor = Executors.newFixedThreadPool(3);
        List<Future<String>> strings = new ArrayList<>();
        int[] sleepTime = {5000, 1000, 3000, 500, 2000};

        for (int i = 1; i <= 5; i++) {
            int finalI = i;
            strings.add(executor.submit(() -> {
                System.out.println("Task " + finalI + " on thread " + Thread.currentThread().getName() + " Sleeping for " + sleepTime[finalI - 1]);
                try {
                    Thread.sleep(sleepTime[finalI - 1]);
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                    return "Task " + finalI + " Interrupted";
                }

                return "Task " + finalI + " Completed";
            }));
        }

        for (Future<String> str : strings) {
            try {
                System.out.println(str.get());
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            } catch (ExecutionException e) {
                System.out.println(e.getCause());
            }
        }

        executor.shutdown();
        System.out.println("All task finished");
    }
}
