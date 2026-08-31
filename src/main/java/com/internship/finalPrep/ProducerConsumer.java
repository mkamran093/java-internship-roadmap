package com.internship.finalPrep;

import java.util.LinkedList;
import java.util.Queue;

public class ProducerConsumer {

    public static void main(String[] args) throws InterruptedException {

        Queue<Integer> queue = new LinkedList<>();

        Thread producer = new Thread(() -> {
            for (int i = 1; i <= 5; i++) {
                synchronized (queue) {
                    queue.add(i);
                    System.out.println("Produced: " + i);
                    queue.notify();
                }

                try {
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                }
            }
        });

        Thread consumer = new Thread(() -> {
            for (int i = 1; i <= 5; i++) {
                synchronized (queue) {

                    while(queue.isEmpty()) {
                        try {
                            queue.wait();
                        } catch (InterruptedException e) {
                            Thread.currentThread().interrupt();
                        }

                    }
                    int value = queue.remove();
                    System.out.println("Consumed: " + value);
                }
            }
        });

        producer.start();
        consumer.start();

        producer.join();
        consumer.join();
    }
}
