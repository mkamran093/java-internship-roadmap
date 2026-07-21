package com.internship.week3.day1.topic6;

import java.util.ArrayList;
import java.util.List;

public class Repository<T extends Identifiable> {

    private List<T> items = new ArrayList<>();

    public void save(T item) {
        items.add(item);
    }

    public List<T> findAll() {
        return items;
    }

    public void delete(T item) {
        items.remove(item);
    }

    public T findById(int id) {
        for (T item: items) {
            if (item.getId() == id) {
                return item;
            }
        }
        return null;
    }
}
