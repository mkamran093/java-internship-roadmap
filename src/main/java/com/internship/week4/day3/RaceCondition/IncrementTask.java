package com.internship.week4.day3.RaceCondition;

class IncrementTask implements Runnable {

    private Counter counter;

    public IncrementTask(Counter counter) {
        this.counter = counter;
    }

    @Override
    public void run() {

        for (int i = 0; i < 1000; i++) {
            counter.increment();
        }

    }

}
