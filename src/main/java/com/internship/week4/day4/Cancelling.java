package com.internship.week4.day4;

import java.util.concurrent.*;

public class Cancelling {

    public static void main(String[] args) {

        ExecutorService executor = Executors.newFixedThreadPool(2);

        Future<String> future = executor.submit(() -> {

            for (int i = 1; i <= 10; i++) {

                System.out.println("Working... second " + i);

                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                    System.out.println("Task received interruption. Cleaning up...");
                    return "Task cancelled";
                }
            }

            return "Task completed successfully";
        });


        try {
            System.out.println(future.get(3, TimeUnit.SECONDS));

        } catch (TimeoutException e) {

            System.out.println("Task cancelled by main thread");
            future.cancel(true);

        } catch (InterruptedException e) {

            Thread.currentThread().interrupt();

        } catch (ExecutionException e) {

            System.out.println("Task failed: " + e.getCause());
        }


        executor.shutdown();
    }
}