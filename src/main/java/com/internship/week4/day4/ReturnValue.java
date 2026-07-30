package com.internship.week4.day4;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class ReturnValue {

    public static void main() throws ExecutionException, InterruptedException {

        ExecutorService executor = Executors.newFixedThreadPool(3);
        List<Future<Integer>> squares = new ArrayList<>();

        try {

            for (int i = 1; i <= 5; i++) {
                int finalI = i;
                squares.add(executor.submit(() -> {
                    System.out.println("Printing square of " + finalI + " on " + Thread.currentThread().getName());
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                }
                    return finalI * finalI;
            }));
            }

            for (Future<Integer> x : squares) {
                System.out.println("Square: " + x.get());
            }

        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        } finally {
            executor.shutdown();
        }
    }
}
