package com.internship.finalPrep;

import java.util.ArrayList;
import java.util.List;

public class GenericStack<T> {

    private List<T> items = new ArrayList<>();

    public void push(T item) {
        items.add(item);
    }

    public T pop() {
        if (items.isEmpty()) {
            throw new RuntimeException("Stack is empty");
        }

        return items.removeLast();
    }

    public T peek() {
        if (items.isEmpty()) {
            throw new RuntimeException("Stack is empty");
        }

        return items.getLast();
    }

    public boolean isEmpty() {
        return items.isEmpty();
    }


}
