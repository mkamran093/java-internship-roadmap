package com.internship.week3.day1.MiniProject;

import com.internship.week3.day1.topic6.Identifiable;

import java.util.ArrayList;
import java.util.List;

public class Repository<T extends Identifiable> {

    List<T> items = new ArrayList<>();

    public void save(T item) {
        items.add(item);
    }

    public T findById(int id) {
        for (T item: items) {
            if (item.getId() == id) {
                return item;
            }
        }
        return null;
    }

    public List<T> findAll(){
        return items;
    }

    public void delete(int id) {
        items.removeIf(item -> item.getId() == id);
    }
}
