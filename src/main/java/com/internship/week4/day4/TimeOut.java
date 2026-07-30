package com.internship.week4.day4;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.*;

public class TimeOut {

    public static void main(String[] args) {

        ExecutorService executor = Executors.newFixedThreadPool(2);
        List<Future<String>> strings = new ArrayList<>();
        int[] sleepTime = {1000, 6000, 2000};

        for (int i = 1; i <= 3; i++) {
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
                System.out.println(str.get(3, TimeUnit.SECONDS));
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
                System.out.println("Task interrupted");
            } catch (ExecutionException e) {
                System.out.println(e.getCause());
            } catch (TimeoutException e) {
                System.out.println("Task took Too long");
                str.cancel(true);
            }
        }

        executor.shutdown();
        System.out.println("All task finished");
    }
}
